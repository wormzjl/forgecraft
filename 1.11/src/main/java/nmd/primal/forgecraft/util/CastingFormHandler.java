package nmd.primal.forgecraft.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.CommonUtils;
import nmd.primal.forgecraft.crafting.CastingformCrafting;
import nmd.primal.forgecraft.init.ModItems;
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

                                if(player.isSneaking()) {
                                    if (pItem.getItem() != ModItems.castingmud) {
                                        System.out.println("Level 1 a");
                                        if (!tile.getSlotStack(counter).isEmpty()) {
                                            System.out.println("Level 1 b");
                                            ItemStack dropStack = new ItemStack(ModItems.castingmud, 1);
                                            tile.setSlotStack(counter, ItemStack.EMPTY);
                                            PlayerHelper.spawnItemOnGround(world, pos, dropStack);
                                            return true;
                                        }
                                    }
                                }

                                if (pItem.getItem() == ModItems.castingmud) {
                                    System.out.println("Level 2 a");
                                    if (tile.getSlotStack(counter).isEmpty()) {
                                        System.out.println("Level 2 b");
                                        ItemStack castStack = new ItemStack(ModItems.castingmud, 1);
                                        pItem.shrink(1);
                                        tile.setSlotStack(counter, castStack);
                                        return true;
                                    }
                                }
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

                                if(player.isSneaking()) {
                                    if (pItem.getItem() != ModItems.castingmud) {
                                        System.out.println("Level 1 a");
                                        if (!tile.getSlotStack(counter).isEmpty()) {
                                            System.out.println("Level 1 b");
                                            ItemStack dropStack = new ItemStack(ModItems.castingmud, 1);
                                            tile.setSlotStack(counter, ItemStack.EMPTY);
                                            PlayerHelper.spawnItemOnGround(world, pos, dropStack);
                                            return true;
                                        }
                                    }
                                }

                                if (pItem.getItem() == ModItems.castingmud) {
                                    System.out.println("Level 2 a");
                                    if (tile.getSlotStack(counter).isEmpty()) {
                                        System.out.println("Level 2 b");
                                        ItemStack castStack = new ItemStack(ModItems.castingmud, 1);
                                        pItem.shrink(1);
                                        tile.setSlotStack(counter, castStack);
                                        return true;
                                    }
                                }
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

                                if(player.isSneaking()) {
                                    if (pItem.getItem() != ModItems.castingmud) {
                                        System.out.println("Level 1 a");
                                        if (!tile.getSlotStack(counter).isEmpty()) {
                                            System.out.println("Level 1 b");
                                            ItemStack dropStack = new ItemStack(ModItems.castingmud, 1);
                                            tile.setSlotStack(counter, ItemStack.EMPTY);
                                            PlayerHelper.spawnItemOnGround(world, pos, dropStack);
                                            return true;
                                        }
                                    }
                                }

                                if (pItem.getItem() == ModItems.castingmud) {
                                    System.out.println("Level 2 a");
                                    if (tile.getSlotStack(counter).isEmpty()) {
                                        System.out.println("Level 2 b");
                                        ItemStack castStack = new ItemStack(ModItems.castingmud, 1);
                                        pItem.shrink(1);
                                        tile.setSlotStack(counter, castStack);
                                        return true;
                                    }
                                }
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

                                if(player.isSneaking()) {
                                    if (pItem.getItem() != ModItems.castingmud) {
                                        System.out.println("Level 1 a");
                                        if (!tile.getSlotStack(counter).isEmpty()) {
                                            System.out.println("Level 1 b");
                                            ItemStack dropStack = new ItemStack(ModItems.castingmud, 1);
                                            tile.setSlotStack(counter, ItemStack.EMPTY);
                                            PlayerHelper.spawnItemOnGround(world, pos, dropStack);
                                            return true;
                                        }
                                    }
                                }

                                if (pItem.getItem() == ModItems.castingmud) {
                                    System.out.println("Level 2 a");
                                    if (tile.getSlotStack(counter).isEmpty()) {
                                        System.out.println("Level 2 b");
                                        ItemStack castStack = new ItemStack(ModItems.castingmud, 1);
                                        pItem.shrink(1);
                                        tile.setSlotStack(counter, castStack);
                                        return true;
                                    }
                                }
                            }
                        }
                        counter++;
                    }
                }
            }

        return false;
    }

    default void doCraftingformCrafting(String[] tempArray, World world, TileCastingForm tile, BlockPos pos){
        CastingformCrafting recipe = CastingformCrafting.getRecipe(tempArray);
        if (recipe != null) {
            CommonUtils.spawnItemEntityFromWorld(world, pos, recipe.getOutput());
        }
        //world.playEvent(1031, pos, 0);
        for (int i = 0; i < tile.getSlotListSize(); i++) {
            if (!tile.getSlotStack(i).isEmpty()) {
                tile.setSlotStack(i, ItemStack.EMPTY);
            }
        }
    }

}
