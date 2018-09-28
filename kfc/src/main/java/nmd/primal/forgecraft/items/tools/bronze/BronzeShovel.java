package nmd.primal.forgecraft.items.tools.bronze;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import nmd.primal.forgecraft.init.ModConfig;
import nmd.primal.forgecraft.items.tools.AbstractShovel;
import nmd.primal.forgecraft.util.ToolNBT;

/**
 * Created by mminaie on 3/21/17.
 */
public class BronzeShovel extends AbstractShovel implements ToolNBT {

    public BronzeShovel(String name, ToolMaterial material, Item damageDrop) {
        super(name, material, damageDrop);
    }


    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        if(!player.world.isRemote){

            if(itemstack.getItem() instanceof BronzeShovel){
                if( getEmerald(itemstack)){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(33), 1);
                }
                if ( getLapisLevel(itemstack) > 0) {
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(35), ModConfig.Features.BRONZE_LAPIS_MULTIPLIER);
                }
            }
        }

        return false;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        for (String type : getToolClasses(stack))
        {
            if (state.getBlock().isToolEffective(type, state))
                return efficiency;
        }
        return this.efficiency + 1;
    }

}
