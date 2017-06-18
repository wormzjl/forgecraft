package nmd.primal.forgecraft.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalItems;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.blocks.CustomContainerFacing;
import nmd.primal.forgecraft.tiles.TileBreaker;

import static nmd.primal.core.common.helper.CommonUtils.randomCheck;

//import nmd.primal.forgecraft.CommonUtils;

/**
 * Created by mminaie on 6/11/17.
 */
public interface BreakerHandler {

    default void doBreaking (World world, IBlockState state, BlockPos pos, TileBreaker tile){

        if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.EAST) {

            if(tile.getCharge() > getThreshold(world, pos.east())) {
                if (world.getBlockState(pos.east()).getBlock() == Blocks.IRON_ORE) {
                    world.setBlockToAir(pos.east());
                    PlayerHelper.spawnItemOnGround(world, pos.east(), new ItemStack(PrimalItems.IRON_DUST, randomChanceReturn(9, 1, 2)));

                    tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()+1);
                }
            } else {
                tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()+10);
            }
        }
        if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.WEST) {
            if(tile.getCharge() > getThreshold(world, pos.west())) {
                if (world.getBlockState(pos.west()).getBlock() == Blocks.IRON_ORE) {
                    world.setBlockToAir(pos.west());
                    PlayerHelper.spawnItemOnGround(world, pos.east(), new ItemStack(PrimalItems.IRON_DUST, randomChanceReturn(9, 1, 2)));
                    tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()+1);
                }
            } else {
                tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()+10);
            }
        }
        if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.SOUTH) {
            if(tile.getCharge() > getThreshold(world, pos.south())) {
                if (world.getBlockState(pos.south()).getBlock() == Blocks.IRON_ORE) {
                    world.setBlockToAir(pos.south());
                    PlayerHelper.spawnItemOnGround(world, pos.east(), new ItemStack(PrimalItems.IRON_DUST, randomChanceReturn(9, 1, 2)));
                    tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()+1);
                }
            } else {
                tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()+10);
            }
        }
        if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.NORTH) {
            if(tile.getCharge() > getThreshold(world, pos.north())) {
                if (world.getBlockState(pos.north()).getBlock() == Blocks.IRON_ORE) {
                    world.setBlockToAir(pos.north());
                    PlayerHelper.spawnItemOnGround(world, pos.east(), new ItemStack(PrimalItems.IRON_DUST, randomChanceReturn(9, 1, 2)));
                    tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()+1);
                }
            } else {
                //tile.getSlotStack(0).damageItem(10, (EntityPlayer) null);
                tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()+10);
            }
        }
        tile.setCharge(0.0f);
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
