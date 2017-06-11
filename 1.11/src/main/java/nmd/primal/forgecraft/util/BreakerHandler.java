package nmd.primal.forgecraft.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalItems;
import nmd.primal.forgecraft.CommonUtils;
import nmd.primal.forgecraft.blocks.CustomContainerFacing;
import nmd.primal.forgecraft.tiles.TileBreaker;
import nmd.primal.forgecraft.blocks.CustomContainerFacing.*;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mminaie on 6/11/17.
 */
public interface BreakerHandler {

    default void doBreaking (World world, IBlockState state, BlockPos pos, TileBreaker tile){
        if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.EAST) {
            if(tile.getCharge() > world.getBlockState(pos.east()).getBlockHardness(world, pos.east())) {
                if (world.getBlockState(pos.east()).getBlock() == Blocks.IRON_ORE) {
                    world.setBlockToAir(pos.east());
                    CommonUtils.spawnItemEntityFromWorld(world, pos.east(), new ItemStack(PrimalItems.IRON_DUST, ThreadLocalRandom.current().nextInt(1, 2)));
                    tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()-1);
                }
            } else {
                tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()-10);
            }
        }
        if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.WEST) {
            if(tile.getCharge() > world.getBlockState(pos.west()).getBlockHardness(world, pos.west())) {
                if (world.getBlockState(pos.west()).getBlock() == Blocks.IRON_ORE) {
                    world.setBlockToAir(pos.west());
                    CommonUtils.spawnItemEntityFromWorld(world, pos.east(), new ItemStack(PrimalItems.IRON_DUST, ThreadLocalRandom.current().nextInt(1, 2)));
                }
            } else {
                tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()-10);
            }
        }
        if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.SOUTH) {
            if(tile.getCharge() > world.getBlockState(pos.south()).getBlockHardness(world, pos.south())) {
                if (world.getBlockState(pos.south()).getBlock() == Blocks.IRON_ORE) {
                    world.setBlockToAir(pos.south());
                    CommonUtils.spawnItemEntityFromWorld(world, pos.east(), new ItemStack(PrimalItems.IRON_DUST, ThreadLocalRandom.current().nextInt(1, 2)));
                }
            } else {
                tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()-10);
            }
        }
        if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.NORTH) {
            if(tile.getCharge() > world.getBlockState(pos.north()).getBlockHardness(world, pos.north())) {
                if (world.getBlockState(pos.north()).getBlock() == Blocks.IRON_ORE) {
                    world.setBlockToAir(pos.north());
                    CommonUtils.spawnItemEntityFromWorld(world, pos.east(), new ItemStack(PrimalItems.IRON_DUST, ThreadLocalRandom.current().nextInt(1, 2)));
                }
            } else {
                //tile.getSlotStack(0).damageItem(10, (EntityPlayer) null);
                tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage()-10);
            }
        }
        tile.setCharge(0.0f);
    }

}
