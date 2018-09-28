package nmd.primal.forgecraft.items.tools;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.forgecraft.util.ToolNBT;

/**
 * Created by mminaie on 3/21/17.
 */
public class CustomShovel extends AbstractShovel implements ToolNBT {

    public CustomShovel(String name, Item.ToolMaterial material, Item damageDrop) {
        super(name, material, damageDrop);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        if(!player.world.isRemote){
            World world = player.getEntityWorld();
            if(itemstack.getItem() instanceof CustomShovel){
                if( getEmerald(itemstack)){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(33), 1);
                }
                if( getDiamondLevel(itemstack) > 0 ){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(34), getDiamondLevel(itemstack));
                    //itemstack.getItem().setHarvestLevel("shovel", 3);
                }
                if( getRedstoneLevel(itemstack) > 0 ){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(32), getRedstoneLevel(itemstack));
                    //System.out.println(itemstack.getEnchantmentTagList());
                }
                if ( getLapisLevel(itemstack) > 0) {
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(35), getLapisLevel(itemstack));
                }
            }
        }

        return false;
    }

}
