package nmd.primal.forgecraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.items.tools.CustomPickaxe;

/**
 * Created by mminaie on 3/15/17.
 */
public class ClientEvents {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority= EventPriority.LOWEST, receiveCanceled=true)
    public void toolTipOverride(ItemTooltipEvent event) {

        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer)
        {
            ItemStack held_stack = ((EntityPlayer) entity).getActiveItemStack();
            if(held_stack.getItem() instanceof CustomPickaxe){
                event.getToolTip().clear();
                if(entity.getEntityWorld().isRemote) {
                    event.setCanceled(true);
                }
            }
        }

    }

}
