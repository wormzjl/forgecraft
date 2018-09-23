package nmd.primal.forgecraft.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.core.common.items.tools.Gallagher;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.BaseMultiItem;
import nmd.primal.forgecraft.items.ForgeHammer;
import nmd.primal.forgecraft.items.SlottedTongs;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.tiles.TileAnvil;
import nmd.primal.forgecraft.tiles.TileForge;

import static nmd.primal.forgecraft.blocks.CustomContainerFacing.FACING;
import static nmd.primal.forgecraft.items.SlottedTongs.ITEM_HANDLER;

/**
 * Created by mminaie on 9/22/18.
 */
public interface ForgeHandler {

    int arraySize = 2;
    double[] normalMin = {0.0625, 0.5625};
    double[] normalMax = {0.4375, 0.9375};
    double[] reverseMin = {0.5625, 0.0625};
    double[] reverseMax = {0.9375, 0.4375};

    default int getArraySize(){return arraySize;}
    default double getNormalMin(Integer x) {
        return normalMin[x];
    }
    default double getNormalMax(Integer x) {
        return normalMax[x];
    }
    default double getReverseMin(Integer x) {
        return reverseMin[x];
    }
    default double getReverseMax(Integer x) {
        return reverseMax[x];
    }

    /*****************************************************************************
     Adding and Removing Inventory With Tongs
     *****************************************************************************/

    default boolean doForgeInventoryManager(ItemStack pItem, World world, TileForge tile, BlockPos pos, float hitx, float hity, float hitz, IBlockState state, EntityPlayer player) {

            if (state.getValue(FACING) == EnumFacing.NORTH) {

                int counter = 0;
                for (int z = 0; z < arraySize; z++) {
                    for (int x = 0; x < arraySize; x++) {
                        if (hitx >= this.getNormalMin(x) && hitx <= this.getNormalMax(x)) {
                            if (hitz >= this.getNormalMin(z) && hitz <= this.getNormalMax(z)) {
                                return ForgeHandler.doWork(pItem, (counter + 1), tile, world, pos, player);
                            }
                        }
                        counter++;
                    }
                }
            }
            if (state.getValue(FACING) == EnumFacing.SOUTH) {
                int counter = 0;
                for (int z = 0; z < arraySize; z++) {
                    for (int x = 0; x < arraySize; x++) {
                        if (hitx >= this.getReverseMin(x) && hitx <= this.getReverseMax(x)) {
                            if (hitz >= this.getReverseMin(z) && hitz <= this.getReverseMax(z)) {
                                return ForgeHandler.doWork(pItem, (counter + 1), tile, world, pos, player);
                            }
                        }
                        counter++;
                    }
                }
            }
            if (state.getValue(FACING) == EnumFacing.WEST) {
                int counter = 0;
                for (int x = 0; x < arraySize; x++) {
                    for (int z = 0; z < arraySize; z++) {
                        if (hitx >= this.getNormalMin(x) && hitx <= this.getNormalMax(x)) {
                            if (hitz >= this.getReverseMin(z) && hitz <= this.getReverseMax(z)) {
                                return ForgeHandler.doWork(pItem, (counter + 1), tile, world, pos, player);
                            }
                        }
                        counter++;
                    }
                }
            }
            if (state.getValue(FACING) == EnumFacing.EAST) {
                int counter = 0;
                for (int x = 0; x < arraySize; x++) {
                    for (int z = 0; z < arraySize; z++) {
                        if (hitx >= this.getReverseMin(x) && hitx <= this.getReverseMax(x)) {
                            if (hitz >= this.getNormalMin(z) && hitz <= this.getNormalMax(z)) {
                                return ForgeHandler.doWork(pItem, (counter + 1), tile, world, pos, player);
                            }
                        }
                        counter++;
                    }
                }
            }
        //}
        return false;
    }

    static boolean doWork(ItemStack pItem, Integer counter, TileForge tile, World world, BlockPos pos, EntityPlayer player) {
        if (pItem.getItem().equals(ModItems.slottedtongs)) {
            IItemHandler inventory = (IItemHandlerModifiable) pItem.getCapability(ITEM_HANDLER, null);
            ItemStack tongsStack = inventory.getStackInSlot(0).copy();

            if (tongsStack.isEmpty()) {
                if (!tile.getSlotStack(counter).isEmpty()) {
                    ItemStack tempStack = tile.getSlotStack(counter).copy();
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    inventory.insertItem(0, tempStack, false);
                    return true;
                }
            }

            if (!tongsStack.isEmpty()) {
                if (tile.getSlotStack(counter).isEmpty()) {
                    ItemStack tempStack = tongsStack;
                    tile.setSlotStack(counter, tempStack);
                    inventory.extractItem(0, 1, false);
                    return true;
                }
            }
        }

        if (pItem.getItem() instanceof BaseMultiItem) {
            if (tile.getSlotStack(counter).isEmpty()) {
                ItemStack tempItem = pItem.copy();
                tempItem.setCount(1);
                tile.setSlotStack(counter,tempItem);
                player.inventory.getCurrentItem().shrink(1);
                return true;
            }
        }

        if (pItem.getItem() instanceof ToolPart) {
            if (tile.getSlotStack(counter).isEmpty()) {
                ItemStack tempItem = pItem.copy();
                tempItem.setCount(1);
                tile.setSlotStack(counter,tempItem);
                player.inventory.getCurrentItem().shrink(1);
                return true;
            }
        }

        if (!(pItem.getItem() instanceof BaseMultiItem)) {
            if (RecipeHelper.isOreName(pItem, "ingotIron")) {
                if (tile.getSlotStack(counter).isEmpty()) {
                    tile.setSlotStack(counter, new ItemStack(ModItems.ironingotball, 1));
                    player.inventory.getCurrentItem().shrink(1);
                    return true;
                }
            }
            if (RecipeHelper.isOreName(pItem, "nuggetIron")) {
                if (tile.getSlotStack(counter).isEmpty()) {
                    tile.setSlotStack(counter, new ItemStack(ModItems.wroughtironchunk, 1));
                    player.inventory.getCurrentItem().shrink(1);
                    return true;
                }
            }
            if (RecipeHelper.isOreName(pItem, "ingotSteel")) {
                if (tile.getSlotStack(counter).isEmpty()) {
                    tile.setSlotStack(counter, new ItemStack(ModItems.steelingotball, 1));
                    player.inventory.getCurrentItem().shrink(1);
                    return true;
                }
            }
            if (RecipeHelper.isOreName(pItem, "nuggetSteel")) {
                if (tile.getSlotStack(counter).isEmpty()) {
                    tile.setSlotStack(counter, new ItemStack(ModItems.steelchunk, 1));
                    player.inventory.getCurrentItem().shrink(1);
                    return true;
                }
            }
        }

        return false;
    }

}
