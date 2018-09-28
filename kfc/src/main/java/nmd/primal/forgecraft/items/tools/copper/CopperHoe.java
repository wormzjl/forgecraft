package nmd.primal.forgecraft.items.tools.copper;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.init.ModConfig;
import nmd.primal.forgecraft.items.tools.AbstractHoe;
import nmd.primal.forgecraft.util.ToolNBT;

import javax.annotation.Nullable;

/**
 * Created by mminaie on 3/21/17.
 */
public class CopperHoe extends AbstractHoe implements ToolNBT {

    public CopperHoe(String name, ToolMaterial material, Item damageDrop) {
        super(name, material, damageDrop);

    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        if(!player.world.isRemote){
            World world = player.getEntityWorld();
                if(ModConfig.Features.ENABLE_COPPER_EMERALD) {
                    if (getEmerald(itemstack)) {
                        itemstack.addEnchantment(Enchantment.getEnchantmentByID(33), 1);
                    }
                }
        }

        return false;
    }

}
