package nmd.primal.forgecraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import nmd.primal.forgecraft.ForgeCraft;

/**
 * Created by mminaie on 2/4/17.
 */
public class ItemForgingManual extends BaseItem {

    public ItemForgingManual(String name) {
        super(name);
    }

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if (world.isRemote) {
            //player.openGui(ForgeCraft.instance, GuiHandler., world, 0, 0, 0);
            player.openGui(ForgeCraft.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
            return new ActionResult(EnumActionResult.PASS, player.getHeldItem(hand));
        }
        return new ActionResult(EnumActionResult.PASS, player.getHeldItem(hand));
    }

}
