package nmd.primal.forgecraft.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.items.tools.Gallagher;
import nmd.primal.forgecraft.CommonUtils;
import nmd.primal.forgecraft.crafting.AnvilCrafting;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.BaseMultiItem;
import nmd.primal.forgecraft.items.ForgeHammer;
import nmd.primal.forgecraft.items.SlottedTongs;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.tiles.TileAnvil;

import java.util.concurrent.ThreadLocalRandom;

import static nmd.primal.forgecraft.blocks.CustomContainerFacing.FACING;

/**
 * Created by mminaie on 6/10/17.
 */
public interface AnvilHandler {

    double[] normalMin = {0.0625, 0.25, 0.4375, 0.625, 0.8125};

    default double getNormalMin(Integer x) {
        return normalMin[x];
    }

    double[] normalMax = {0.1875, 0.375, 0.5625, 0.75, 0.9375};

    default double getNormalMax(Integer x) {
        return normalMax[x];
    }

    double[] reverseMin = {0.8125, 0.625, 0.4375, 0.25, 0.0625};

    default double getReverseMin(Integer x) {
        return reverseMin[x];
    }

    double[] reverseMax = {0.9375, 0.75, 0.5625, 0.375, 0.1875};

    default double getReverseMax(Integer x) {
        return reverseMax[x];
    }

    default boolean doAnvilRecipe(ItemStack pItem, String[] tempArray, World world, TileAnvil tile, BlockPos pos, EntityPlayer player) {
        AnvilCrafting recipe = AnvilCrafting.getRecipe(tempArray);
        if (recipe != null) {
            if (pItem.getItem() instanceof Gallagher) {
                pItem.damageItem(15, player);
            }
            if (pItem.getItem() instanceof ForgeHammer) {
                pItem.damageItem(1, player);
            }
            world.playEvent(1031, pos, 0);


            if (ThreadLocalRandom.current().nextInt(0, 2) == 0) {

                if (recipe.getOutput().getItem() instanceof ToolPart) {

                    if (!tile.getSlotStack(12).getItem().equals(recipe.getOutput().getItem())) {
                        ItemStack tempStack = recipe.getOutput();
                        tempStack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound tags = new NBTTagCompound();

                        tempStack.getTagCompound().setTag("tags", tags);
                        tempStack.getSubCompound("tags").setBoolean("hot", false);

                        tempStack.getSubCompound("tags").setBoolean("emerald", false);
                        tempStack.getSubCompound("tags").setInteger("diamond", 0);
                        tempStack.getSubCompound("tags").setInteger("redstone", 0);
                        tempStack.getSubCompound("tags").setInteger("lapis", 0);

                        tempStack.getSubCompound("tags").setInteger("modifiers", 0);
                        CommonUtils.spawnItemEntityFromWorld(world, pos, tempStack);
                    }

                    if (tile.getSlotStack(12).getItem().equals(recipe.getOutput().getItem())) {

                        NBTTagCompound tempNBT = tile.getSlotStack(12).getSubCompound("tags");
                        ItemStack outputStack = recipe.getOutput();
                        outputStack.setTagCompound(new NBTTagCompound());
                        outputStack.getTagCompound().setTag("tags", tempNBT);
                        outputStack.getSubCompound("tags").setBoolean("hot", false);

                        if (recipe.getUpgrade() == "repair") {
                            CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                        }

                        if (outputStack.getSubCompound("tags").getInteger("modifiers") < 3) {

                            //Upgrade emerald
                            if (recipe.getUpgrade() == "emerald") {
                                if (outputStack.getSubCompound("tags").getInteger("lapis") == 0) {
                                    if (outputStack.getSubCompound("tags").getBoolean("emerald") == false) {
                                        outputStack.setItemDamage(tile.getSlotStack(12).getItemDamage());
                                        outputStack.getSubCompound("tags").setInteger("emerald",
                                                (outputStack.getSubCompound("tags").getInteger("emerald") + 1));
                                        outputStack.getSubCompound("tags").setInteger("modifiers",
                                                (outputStack.getSubCompound("tags").getInteger("modifiers") + 1));
                                        CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                                    }
                                }
                            }

                            //Upgrade diamond
                            if (recipe.getUpgrade() == "diamond") {
                                outputStack.setItemDamage(tile.getSlotStack(12).getItemDamage());
                                outputStack.getSubCompound("tags").setInteger("diamond",
                                        (outputStack.getSubCompound("tags").getInteger("diamond") + 1));
                                outputStack.getSubCompound("tags").setInteger("modifiers",
                                        (outputStack.getSubCompound("tags").getInteger("modifiers") + 1));
                                CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                            }

                            //Upgrade redstone
                            if (recipe.getUpgrade() == "redstone") {
                                outputStack.setItemDamage(tile.getSlotStack(12).getItemDamage());
                                outputStack.getSubCompound("tags").setInteger("redstone",
                                        (outputStack.getSubCompound("tags").getInteger("redstone") + 1));
                                outputStack.getSubCompound("tags").setInteger("modifiers",
                                        (outputStack.getSubCompound("tags").getInteger("modifiers") + 1));
                                CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                            }

                            //Upgrade lapis
                            if (recipe.getUpgrade() == "lapis") {
                                outputStack.setItemDamage(tile.getSlotStack(12).getItemDamage());
                                if (outputStack.getSubCompound("tags").getBoolean("emerald") == false) {
                                    outputStack.getSubCompound("tags").setInteger("lapis",
                                            (outputStack.getSubCompound("tags").getInteger("lapis") + 1));
                                    outputStack.getSubCompound("tags").setInteger("modifiers",
                                            (outputStack.getSubCompound("tags").getInteger("modifiers") + 1));
                                    CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                                }
                            }
                        }
                    }
                } else {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, recipe.getOutput());
                }
                //world.playEvent(1031, pos, 0);
                for (int i = 0; i < tile.getSlotListSize(); i++) {
                    if (!tile.getSlotStack(i).isEmpty()) {
                        tile.setSlotStack(i, ItemStack.EMPTY);
                    }
                }
                return true;
            }
        }
        return false;
    }


    /*****************************************************************************
     Adding and Removing Inventory With Tongs
     *****************************************************************************/

    default boolean doAnvilInventoryManager(ItemStack pItem, World world, TileAnvil tile, BlockPos pos, float hitx, float hity, float hitz, IBlockState state, EntityPlayer player) {
        if ((!(pItem.getItem() instanceof Gallagher)) || (!(pItem.getItem() instanceof ForgeHammer))) {
            if (pItem.getItem() instanceof BaseMultiItem) {
                return false;
            }
            if (state.getValue(FACING) == EnumFacing.NORTH) {
                int counter = 0;
                for (int z = 0; z < 5; z++) {
                    for (int x = 0; x < 5; x++) {
                        if (hitx >= this.getNormalMin(x) && hitx <= this.getNormalMax(x)) {
                            if (hitz >= this.getNormalMin(z) && hitz <= this.getNormalMax(z)) {
                                return AnvilHandler.doWork(pItem, counter, tile, world, pos, player);
                                //return true;
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
                                return AnvilHandler.doWork(pItem, counter, tile, world, pos, player);
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
                                return AnvilHandler.doWork(pItem, counter, tile, world, pos, player);
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
                                return AnvilHandler.doWork(pItem, counter, tile, world, pos, player);
                            }
                        }
                        counter++;
                    }
                }
            }
        }
        return false;
    }


    static boolean doWork(ItemStack pItem, Integer counter, TileAnvil tile, World world, BlockPos pos, EntityPlayer player) {
        if (!world.isRemote) {
            if (pItem.getItem().equals(ModItems.slottedtongs)) {

                SlottedTongs tongs = (SlottedTongs) pItem.getItem();
                ItemStack tongStack = tongs.getSlotList().get(0).copy();

                if (tongStack.isEmpty()) {
                    if (!tile.getSlotStack(counter).isEmpty()) {
                        ItemStack tempStack = tile.getSlotStack(counter).copy();
                        tongs.setSlotList(tempStack);
                        tile.setSlotStack(counter, ItemStack.EMPTY);
                        return true;
                    }
                }

                if (!tongStack.isEmpty()) {
                    if (tile.getSlotStack(counter).isEmpty()) {
                        ItemStack tempStack = tongs.getSlotList().get(0).copy();
                        tile.setSlotStack(counter, tempStack);
                        tongs.setSlotList(ItemStack.EMPTY);
                        return true;
                    }
                }
            }

            if (pItem.getItem().equals(Items.AIR) && player.isSneaking()) {

                if (tile.getSlotStack(counter).getItem().equals(Items.DIAMOND)) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
                }
                if (tile.getSlotStack(counter).getItem().equals(PrimalAPI.Items.DIAMOND_KNAPP)) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
                }
                if (tile.getSlotStack(counter).getItem().equals(Items.EMERALD)) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
                }
                if (tile.getSlotStack(counter).getItem().equals(PrimalAPI.Items.EMERALD_KNAPP)) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
                }
                if (tile.getSlotStack(counter).getItem().equals(Items.REDSTONE)) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
                }

                if (tile.getSlotStack(counter).getItem().equals(Items.DYE) && tile.getSlotStack(counter).getItemDamage() == EnumDyeColor.BLUE.getDyeDamage()) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
                }

                if (tile.getSlotStack(counter).getItem() instanceof BaseMultiItem) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
                }
            }
            if(tile.getSlotStack(counter).getItem() instanceof ToolPart){
                if (tile.getSlotStack(counter).getSubCompound("tags").getBoolean("hot") == false) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, tile.getSlotStack(counter));
                    tile.setSlotStack(counter, ItemStack.EMPTY);
                    return true;
                }
            }

            if (pItem.getItem().equals(Items.DIAMOND)) {
                if (tile.getSlotStack(counter).isEmpty()) {
                    tile.setSlotStack(counter, new ItemStack(pItem.getItem(), 1));
                    pItem.shrink(1);
                    return true;
                }
            }

            if (pItem.getItem().equals(Items.EMERALD)) {
                if (tile.getSlotStack(counter).isEmpty()) {
                    tile.setSlotStack(counter, new ItemStack(pItem.getItem(), 1));
                    pItem.shrink(1);
                    return true;
                }
            }

            if (pItem.getItem().equals(PrimalAPI.Items.EMERALD_KNAPP)) {
                if (tile.getSlotStack(counter).isEmpty()) {
                    tile.setSlotStack(counter, new ItemStack(pItem.getItem(), 1));
                    pItem.shrink(1);
                    return true;
                }
            }

            if (pItem.getItem().equals(PrimalAPI.Items.DIAMOND_KNAPP)) {
                if (tile.getSlotStack(counter).isEmpty()) {
                    tile.setSlotStack(counter, new ItemStack(pItem.getItem(), 1));
                    pItem.shrink(1);
                    return true;
                }
            }

            if (pItem.getItem().equals(Items.REDSTONE)) {
                if (tile.getSlotStack(counter).isEmpty()) {
                    tile.setSlotStack(counter, new ItemStack(pItem.getItem(), 1));
                    pItem.shrink(1);
                    return true;
                }
            }

            if (pItem.getItem().equals(Items.DYE) && pItem.getItemDamage() == EnumDyeColor.BLUE.getDyeDamage()) {
                if (tile.getSlotStack(counter).isEmpty()) {
                    tile.setSlotStack(counter, new ItemStack(pItem.getItem(), 1, pItem.getItemDamage()));
                    pItem.shrink(1);
                    return true;
                }
            }
        }
        return false;
    }

    static void doDrops(World world, BlockPos pos) {
        if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops")) {
            TileAnvil tile = (TileAnvil) world.getTileEntity(pos);
            if (tile != null) {
                for (ItemStack stack : tile.getSlotList()) {
                    if (stack != null) {
                        float offset = 0.7F;
                        double offsetX = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        double offsetY = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        double offsetZ = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        ItemStack dropStack = null;
                        if (stack.getItem() instanceof BaseMultiItem) {
                            BaseMultiItem item = (BaseMultiItem) stack.getItem();
/*
                            switch (item.getID()) {
                                case 6:
                                    dropStack = new ItemStack(ModBlocks.ironball, 1);
                                    break;
                                case 7:
                                    dropStack = new ItemStack(ModBlocks.ironchunk, 1);
                                    break;
                                case 8:
                                    dropStack = new ItemStack(ModItems.pickaxehead, 1);
                                    break;
                                case 9:
                                    dropStack = new ItemStack(ModItems.ironaxehead, 1);
                                    break;
                                case 10:
                                    dropStack = new ItemStack(ModItems.ironshovelhead, 1);
                                    break;
                                case 11:
                                    dropStack = new ItemStack(ModItems.ironhoehead, 1);
                                    break;
                                case 15:
                                    dropStack = new ItemStack(ModBlocks.ironcleanball, 1);
                                    break;
                                case 16:
                                    dropStack = new ItemStack(ModBlocks.ironcleanchunk, 1);
                                    break;
                                case 17:
                                    dropStack = new ItemStack(ModItems.cleanironpickaxehead, 1);
                                    break;
                                case 18:
                                    dropStack = new ItemStack(ModItems.cleanironaxehead, 1);
                                    break;
                                case 19:
                                    dropStack = new ItemStack(ModItems.cleanironshovelhead, 1);
                                    break;
                                case 20:
                                    dropStack = new ItemStack(ModItems.cleanironhoehead, 1);
                                    break;
                                case 24:
                                    dropStack = new ItemStack(ModBlocks.steelball, 1);
                                    break;
                                case 25:
                                    dropStack = new ItemStack(ModBlocks.steelchunk, 1);
                                    break;
                                case 26:
                                    dropStack = new ItemStack(ModItems.steelpickaxehead, 1);
                                    break;
                                case 27:
                                    dropStack = new ItemStack(ModItems.steelaxehead, 1);
                                    break;
                                case 28:
                                    dropStack = new ItemStack(ModItems.steelshovelhead, 1);
                                    break;
                                case 29:
                                    dropStack = new ItemStack(ModItems.steelhoehead, 1);
                                    break;
                                case 33:
                                    dropStack = new ItemStack(ModBlocks.wootzball, 1);
                                    break;
                                case 34:
                                    dropStack = new ItemStack(ModBlocks.wootzchunk, 1);
                                    break;
                                case 35:
                                    dropStack = new ItemStack(ModItems.wootzpickaxehead, 1);
                                    break;
                                case 36:
                                    dropStack = new ItemStack(ModItems.wootzaxehead, 1);
                                    break;
                                case 37:
                                    dropStack = new ItemStack(ModItems.wootzshovelhead, 1);
                                    break;
                                case 38:
                                    dropStack = new ItemStack(ModItems.wootzhoehead, 1);
                                    break;
                            }*/

                        } else {
                            dropStack = stack;
                        }
                        if(dropStack.hasTagCompound()){
                            if(dropStack.getItem() instanceof ToolPart){
                                dropStack.getSubCompound("tags").setBoolean("hot", false);
                            }
                        }
                        EntityItem itemDrop = new EntityItem(world, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, dropStack);
                        itemDrop.setDefaultPickupDelay();
                        world.spawnEntity(itemDrop);
                    }
                }
            }
        }
    }
}
