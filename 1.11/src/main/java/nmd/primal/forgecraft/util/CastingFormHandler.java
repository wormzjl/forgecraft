package nmd.primal.forgecraft.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.forgecraft.tiles.TileCastingForm;

import static nmd.primal.forgecraft.blocks.CustomContainerFacing.FACING;

/**
 * Created by mminaie on 6/20/17.
 */
public interface CastingFormHandler {

    double[] normalMin = {0.1875, 0.3125, 0.4375, 0.5625, 0.6875};

    default double getNormalMin(Integer x) {
        return normalMin[x];
    }

    double[] normalMax = {0.3125, 0.4375, 0.5625, 0.6875, 0.8125};

    default double getNormalMax(Integer x) {
        return normalMax[x];
    }

    double[] reverseMin = {0.6875, 0.5625, 0.4375, 0.3125, 0.1875};

    default double getReverseMin(Integer x) {
        return reverseMin[x];
    }

    double[] reverseMax = {0.8125, 0.6875, 0.5625, 0.4375, 0.3125};

    default double getReverseMax(Integer x) {
        return reverseMax[x];
    }



    /*****************************************************************************
     Adding and Removing Inventory With Tongs
     *****************************************************************************/

    default boolean doInventoryManager(ItemStack pItem, World world, TileCastingForm tile, BlockPos pos, float hitx, float hity, float hitz, IBlockState state, EntityPlayer player) {

            if (state.getValue(FACING) == EnumFacing.NORTH) {
                int counter = 0;
                for (int z = 0; z < 5; z++) {
                    for (int x = 0; x < 5; x++) {
                        if (hitx >= this.getNormalMin(x) && hitx <= this.getNormalMax(x)) {
                            if (hitz >= this.getNormalMin(z) && hitz <= this.getNormalMax(z)) {
                                System.out.println("North Facing: " + tile.getSlotStack(counter));
                                return true;
                            }
                        }
                        counter++;
                    }
                }
            }
            if (state.getValue(FACING) == EnumFacing.SOUTH) {
                int counter = 0;
                for (int z = 0; z < 5; z++) {
                    for (int x = 0; x < 5; x++) {
                        if (hitx >= this.getReverseMin(x) && hitx <= this.getReverseMax(x)) {
                            if (hitz >= this.getReverseMin(z) && hitz <= this.getReverseMax(z)) {

                                return true;
                            }
                        }
                        counter++;
                    }
                }
            }
            if (state.getValue(FACING) == EnumFacing.WEST) {
                int counter = 0;
                for (int x = 0; x < 5; x++) {
                    for (int z = 0; z < 5; z++) {
                        if (hitx >= this.getNormalMin(x) && hitx <= this.getNormalMax(x)) {
                            if (hitz >= this.getReverseMin(z) && hitz <= this.getReverseMax(z)) {

                                return true;
                            }
                        }
                        counter++;
                    }
                }
            }
            if (state.getValue(FACING) == EnumFacing.EAST) {
                int counter = 0;
                for (int x = 0; x < 5; x++) {
                    for (int z = 0; z < 5; z++) {
                        if (hitx >= this.getReverseMin(x) && hitx <= this.getReverseMax(x)) {
                            if (hitz >= this.getNormalMin(z) && hitz <= this.getNormalMax(z)) {

                                return true;
                            }
                        }
                        counter++;
                    }
                }
            }

        return false;
    }


}
