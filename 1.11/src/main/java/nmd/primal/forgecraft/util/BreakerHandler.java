package nmd.primal.forgecraft.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import nmd.primal.core.api.PrimalBlocks;
import nmd.primal.core.api.PrimalItems;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.blocks.CustomContainerFacing;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.tiles.TileBreaker;

import java.util.Arrays;

import static net.minecraftforge.oredict.OreDictionary.getOreIDs;
import static nmd.primal.core.common.helper.CommonUtils.randomCheck;

//import nmd.primal.forgecraft.CommonUtils;

/**
 * Created by mminaie on 6/11/17.
 */
public interface BreakerHandler {

    default boolean hasOreName(ItemStack itemStack, String oreName)
    {
        int[] oreIds = OreDictionary.getOreIDs(itemStack);
        for(int oreId : oreIds)
        {
            String oreNameEntry = OreDictionary.getOreName(oreId);
            if(oreName.equals(oreNameEntry))
            {
                return true;
            }
        }
        return false;
    }

    /*
    int checkid = OreDictionary.getOreID(oreDictName);
for (int id:OreDictionary.getOreIDs(stack))
    if(id == checkid) return true;
return false;
     */

// somewhere else
//if(hasOreName(new ItemStack(Blocks.LOG), "logWood"))
    // item is logWood

    default void doBreaking(World world, IBlockState state, BlockPos pos, TileBreaker tile){
        for (EnumFacing face : EnumFacing.values()) {
            if(world.getBlockState(pos).getValue(CustomContainerFacing.FACING) == face) {
                if (tile.getCharge() > getThreshold(world, pos.offset(face))) {
                    Block smashBlock = world.getBlockState(pos.offset(face)).getBlock();
                    ItemStack smashStack = new ItemStack(smashBlock, 1);
                    System.out.println(smashStack.getItem());
                    if (hasOreName(smashStack, "oreIron")) {
                        world.setBlockToAir(pos.offset(face));
                        PlayerHelper.spawnItemOnGround(world, pos.offset(face), new ItemStack(PrimalItems.IRON_DUST, randomChanceReturn(9, 1, 2)));
                        tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage() + 1);
                    }
                    if (hasOreName(smashStack, "oreCopper")) {
                        world.setBlockToAir(pos.offset(face));
                        PlayerHelper.spawnItemOnGround(world, pos.offset(face), new ItemStack(PrimalItems.COPPER_DUST, randomChanceReturn(9, 1, 2)));

                        tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage() + 1);
                    }
                } else {
                    tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage() + 10);
                }
            }
            tile.setCharge(0.0f);
        }
    }

    default float getThreshold(World world, BlockPos pos){
        float threshold = world.getBlockState(pos).getBlockHardness(world, pos) * (world.getBlockState(pos).getBlock().getExplosionResistance(null)*5);
        if(threshold > 179){
            threshold = 178;
        }
        return threshold;
    }

    public static int randomChanceReturn(int bound, int output1, int output2)
    {
        return randomCheck(bound) ? output2 : output1;
    }

}
