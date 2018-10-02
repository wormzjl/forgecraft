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
import net.minecraftforge.items.IItemHandler;
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
import static nmd.primal.forgecraft.items.SlottedTongs.ITEM_HANDLER;

/**
 * Created by mminaie on 6/10/17.
 */
public interface AnvilHandler extends ToolMaterialMap {

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

    default boolean doAnvilRecipe(ItemStack pItem, ItemStack stack12, ItemStack[] tempArray, World world, TileAnvil tile, BlockPos pos, EntityPlayer player) {
        AnvilCrafting recipe = AnvilCrafting.getRecipe(tempArray);
        if (recipe != null) {
            if (pItem.getItem() instanceof Gallagher) {
                pItem.damageItem(10, player);
            }
            if (pItem.getItem() instanceof ForgeHammer) {
                pItem.damageItem(1, player);
            }
            world.playEvent(1031, pos, 0);

            if (ThreadLocalRandom.current().nextInt(0, 2) == 0) {

                if (recipe.getOutput().getItem() instanceof ToolPart) {

                    if (!tile.getSlotStack(12).getItem().equals(recipe.getOutput().getItem()) ) {

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
                        for (int i = 0; i < tile.getSlotListSize(); i++) {
                            if (!tile.getSlotStack(i).isEmpty()) {
                                tile.setSlotStack(i, ItemStack.EMPTY);
                            }
                        }
                        return true;
                    }

                    if (tile.getSlotStack(12).getItem().equals(recipe.getOutput().getItem())) {

                        NBTTagCompound tempNBT = tile.getSlotStack(12).getSubCompound("tags");
                        ItemStack outputStack = recipe.getOutput();
                        outputStack.setTagCompound(new NBTTagCompound());
                        outputStack.getTagCompound().setTag("tags", tempNBT);
                        outputStack.getSubCompound("tags").setBoolean("hot", false);


                        if (recipe.getUpgrade() == "repair") {
                            CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                            for (int i = 0; i < tile.getSlotListSize(); i++) {
                                if (!tile.getSlotStack(i).isEmpty()) {
                                    tile.setSlotStack(i, ItemStack.EMPTY);
                                }
                            }
                            return true;
                        }

                        if (outputStack.getSubCompound("tags").getInteger("modifiers") < ToolMaterialMap.materialModifiers.get(((ToolPart) recipe.getOutput().getItem()).getMaterial()) ) {

                            //Upgrade emerald
                            if (recipe.getUpgrade() == "emerald") {
                                if (outputStack.getSubCompound("tags").getInteger("lapis") == 0) {
                                    if (!outputStack.getSubCompound("tags").getBoolean("emerald")) {
                                        outputStack.setItemDamage(tile.getSlotStack(12).getItemDamage());
                                        outputStack.getSubCompound("tags").setInteger("emerald",
                                                (outputStack.getSubCompound("tags").getInteger("emerald") + 1));
                                        outputStack.getSubCompound("tags").setInteger("modifiers",
                                                (outputStack.getSubCompound("tags").getInteger("modifiers") + 1));
                                        CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                                        for (int i = 0; i < tile.getSlotListSize(); i++) {
                                            if (!tile.getSlotStack(i).isEmpty()) {
                                                tile.setSlotStack(i, ItemStack.EMPTY);
                                            }
                                        }
                                        return true;
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
                                for (int i = 0; i < tile.getSlotListSize(); i++) {
                                    if (!tile.getSlotStack(i).isEmpty()) {
                                        tile.setSlotStack(i, ItemStack.EMPTY);
                                    }
                                }
                                return true;
                            }

                            //Upgrade redstone
                            if (recipe.getUpgrade() == "redstone") {
                                outputStack.setItemDamage(tile.getSlotStack(12).getItemDamage());
                                outputStack.getSubCompound("tags").setInteger("redstone",
                                        (outputStack.getSubCompound("tags").getInteger("redstone") + 1));
                                outputStack.getSubCompound("tags").setInteger("modifiers",
                                        (outputStack.getSubCompound("tags").getInteger("modifiers") + 1));
                                CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                                for (int i = 0; i < tile.getSlotListSize(); i++) {
                                    if (!tile.getSlotStack(i).isEmpty()) {
                                        tile.setSlotStack(i, ItemStack.EMPTY);
                                    }
                                }
                                return true;
                            }

                            //Upgrade lapis
                            if (recipe.getUpgrade() == "lapis") {
                                outputStack.setItemDamage(tile.getSlotStack(12).getItemDamage());
                                if (!outputStack.getSubCompound("tags").getBoolean("emerald")) {
                                    outputStack.getSubCompound("tags").setInteger("lapis",
                                            (outputStack.getSubCompound("tags").getInteger("lapis") + 1));
                                    outputStack.getSubCompound("tags").setInteger("modifiers",
                                            (outputStack.getSubCompound("tags").getInteger("modifiers") + 1));
                                    CommonUtils.spawnItemEntityFromWorld(world, pos, outputStack);
                                    for (int i = 0; i < tile.getSlotListSize(); i++) {
                                        if (!tile.getSlotStack(i).isEmpty()) {
                                            tile.setSlotStack(i, ItemStack.EMPTY);
                                        }
                                    }
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }
                if (!(recipe.getOutput().getItem() instanceof ToolPart)) {
                    CommonUtils.spawnItemEntityFromWorld(world, pos, recipe.getOutput());
                    for (int i = 0; i < tile.getSlotListSize(); i++) {
                        if (!tile.getSlotStack(i).isEmpty()) {
                            tile.setSlotStack(i, ItemStack.EMPTY);
                        }
                    }
                    return true;
                }
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


            if (pItem.getItem().equals(ModItems.slottedtongs)) {

                IItemHandler inventory = pItem.getCapability(ITEM_HANDLER, null);
                ItemStack tongStack = inventory.getStackInSlot(0).copy();
                SlottedTongs itemstackItem = (SlottedTongs) pItem.getItem();

                if (tongStack.isEmpty()) {
                    if (!tile.getSlotStack(counter).isEmpty()) {
                        ItemStack tempStack = tile.getSlotStack(counter).copy();
                        inventory.insertItem(0,tempStack, false);
                        tile.setSlotStack(counter, ItemStack.EMPTY);
                        itemstackItem.markDirty(pItem);
                        return true;
                    }
                }

                if (!tongStack.isEmpty()) {
                    if (tile.getSlotStack(counter).isEmpty()) {
                        tile.setSlotStack(counter, inventory.extractItem(0, 1, false));
                        itemstackItem.markDirty(pItem);
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

        return false;
    }

    static void doDrops(World world, BlockPos pos) {
        if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops")) {
            TileAnvil tile = (TileAnvil) world.getTileEntity(pos);
            if (tile != null) {
                for (ItemStack stack : tile.getSlotList()) {
                    if (stack != ItemStack.EMPTY) {
                        float offset = 0.7F;
                        double offsetX = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        double offsetY = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        double offsetZ = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        System.out.println(stack);
                        EntityItem itemDrop = new EntityItem(world, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, stack);
                        itemDrop.setDefaultPickupDelay();
                        world.spawnEntity(itemDrop);
                    }
                }
            }
        }
    }
}
