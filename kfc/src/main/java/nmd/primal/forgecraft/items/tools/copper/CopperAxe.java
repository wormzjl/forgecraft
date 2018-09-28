package nmd.primal.forgecraft.items.tools.copper;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import nmd.primal.forgecraft.init.ModConfig;
import nmd.primal.forgecraft.items.tools.AbstractAxe;
import nmd.primal.forgecraft.util.ToolNBT;

/**
 * Created by mminaie on 6/25/17.
 */
public class CopperAxe extends AbstractAxe implements ToolNBT {

    Item drop;

    public CopperAxe(String name, ToolMaterial material, Item damageDrop, Integer damage, Float speed) {
        super(name, material, damageDrop, damage, speed);
    }


    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        if(!player.world.isRemote){
            //System.out.println(world.getBlockState(pos).getBlock());
            if(itemstack.getItem() instanceof CopperAxe){
                if(ModConfig.Features.ENABLE_COPPER_EMERALD) {
                    if (getEmerald(itemstack)) {
                        itemstack.addEnchantment(Enchantment.getEnchantmentByID(33), 1);
                    }
                }
                /*if( getDiamondLevel(itemstack) > 0 ){
                    itemstack.getItem().setHarvestLevel("pickaxe", 3);
                }
                if ( getLapisLevel(itemstack) > 0) {
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(35), ModConfig.Features.BRONZE_LAPIS_MULTIPLIER);
                }*/
            }
        }

        return false;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        //return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;

        if(material != Material.WOOD && material != Material.PLANTS && material != Material.VINE){
            return  super.getDestroySpeed(stack, state);
        } else {
            return this.efficiency + 1;
        }

    }

}
