package nmd.primal.forgecraft.items.tools.bronze;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.forgecraft.init.ModConfig;
import nmd.primal.forgecraft.items.tools.AbstractPickaxe;
import nmd.primal.forgecraft.util.ToolNBT;

/**
 * Created by mminaie on 3/14/17.
 */
public class BronzePickaxe extends AbstractPickaxe implements ToolNBT {

    private Item drop;

    public BronzePickaxe(String name, ToolMaterial material, Item damageDrop) {
        super(name, material, damageDrop);
    }


    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        if(!player.world.isRemote){
            World world = player.getEntityWorld();
            //System.out.println(world.getBlockState(pos).getBlock());
            if(itemstack.getItem() instanceof BronzePickaxe){
                if( getEmerald(itemstack)){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(33), 1);
                }
                /*if( getDiamondLevel(itemstack) > 0 ){
                    //itemstack.addEnchantment(Enchantment.getEnchantmentByID(34), getDiamondLevel(itemstack));
                    itemstack.getItem().setHarvestLevel("pickaxe", 3);
                }*/
                if ( getLapisLevel(itemstack) > 0) {
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(35), ModConfig.Features.BRONZE_LAPIS_MULTIPLIER);
                }
            }
        }
        return false;
    }


}
