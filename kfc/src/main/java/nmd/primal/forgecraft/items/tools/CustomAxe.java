package nmd.primal.forgecraft.items.tools;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import nmd.primal.forgecraft.util.ToolNBT;

/**
 * Created by mminaie on 3/20/17.
 */
public class CustomAxe extends AbstractAxe implements ToolNBT {

    Item drop;

    public CustomAxe(String name, Item.ToolMaterial material, Item damageDrop, Integer damage, Float speed) {
        super(name, material, damageDrop, damage, speed);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        if(!player.world.isRemote){
            if(itemstack.getItem() instanceof CustomAxe){
                if( getEmerald(itemstack)){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(33), 1);
                }
                if( getDiamondLevel(itemstack) > 0 ){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(34), getDiamondLevel(itemstack));
                    //itemstack.getItem().setHarvestLevel("pickaxe", 3);
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
