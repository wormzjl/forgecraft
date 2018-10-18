package nmd.primal.forgecraft;

import net.minecraft.init.Items;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.oredict.OreDictionary;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.api.events.CauldronEvent;
import nmd.primal.core.api.events.CauldronRecipeEvent;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.core.common.recipes.tile.CauldronRecipe;
import nmd.primal.core.common.tiles.machines.TileCauldron;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.items.parts.WeaponPart;
import nmd.primal.forgecraft.items.tools.CustomAxe;
import nmd.primal.forgecraft.items.tools.CustomHoe;
import nmd.primal.forgecraft.items.tools.CustomPickaxe;
import nmd.primal.forgecraft.items.tools.CustomShovel;
import nmd.primal.forgecraft.util.ToolNBT;
import nmd.primal.forgecraft.util.WeaponNBT;

import java.util.List;

/**
 * Created by mminaie on 3/15/17.
 */
public class CommonEvents implements WeaponNBT {

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onItemCrafted(CauldronRecipeEvent.Pre event){

        CauldronRecipe recipe = event.getRecipe();

        if (recipe.matches("rawbronzegladiussmite", "rawbronzegladiusbane", "rawbronzegladiuslapis")){

            NonNullList<ItemStack> inputList = NonNullList.<ItemStack>withSize(6, ItemStack.EMPTY);
            inputList.set(0, event.getTile().getInputHandler().getStackInSlot(0));
            inputList.set(1, event.getTile().getInputHandler().getStackInSlot(1));
            inputList.set(2, event.getTile().getInputHandler().getStackInSlot(2));
            inputList.set(3, event.getTile().getInputHandler().getStackInSlot(3));
            inputList.set(4, event.getTile().getInputHandler().getStackInSlot(4));
            inputList.set(5, event.getTile().getInputHandler().getStackInSlot(5));

            TileCauldron tile = event.getTile();
            ItemStack inputStack = tile.getInputStack(event.getOutputs().get(0));
            Item inputStackItem = null;
            if(inputStack.getItem() instanceof WeaponPart){
               inputStackItem = inputStack.getItem();
            }
            ItemStack modStack = ItemStack.EMPTY;
            ItemStack outputStack = event.getOutputs().get(0);

            modStack = getOppositeStack(inputList, inputStack);

            if (inputStack.hasTagCompound()) {
                if (inputStack.getSubCompound("tags") != null) {
                    NBTTagCompound tags = inputStack.getTagCompound().copy();
                    if(inputStackItem != null) {
                        if (getModifiers(inputStack) < WeaponNBT.materialModifiers.get(((WeaponPart) outputStack.getItem()).getMaterial()) ) {
                            if (RecipeHelper.isOreName(modStack, "dustSilver")) {
                                setSmiteLevel(outputStack, getSmiteLevel(inputStack) + 1);
                                setModifiers(outputStack, getModifiers(inputStack) + 1);
                            }
                            if (RecipeHelper.isOreName(modStack, "foodPoison")) {
                                setBaneLevel(outputStack, getBaneLevel(inputStack) + 1);
                                setModifiers(outputStack, getModifiers(inputStack) + 1);
                            }
                            if (RecipeHelper.isOreName(modStack, "dustBlaze")) {
                                setFireLevel(outputStack, getFireLevel(inputStack) + 1);
                                setModifiers(outputStack, getModifiers(inputStack) + 1);
                            }
                            if (RecipeHelper.isOreName(modStack, "gemLapis")) {
                                setFortuneLevel(outputStack, getFortuneLevel(inputStack) + 1);
                                setModifiers(outputStack, getModifiers(inputStack) + 1);
                            }
                            if (RecipeHelper.isOreName(modStack, "boneWithered", "dustWitheredBone", "skullWithered")) {
                                setLeechLevel(outputStack, getLeechLevel(inputStack) + 1);
                                setModifiers(outputStack, getModifiers(inputStack) + 1);
                            }
                        }
                    }
                }
            }
        }
    }

    private ItemStack getOppositeStack(NonNullList<ItemStack> inputList, ItemStack inputStack){
        ItemStack modStack = ItemStack.EMPTY;

        for (int i = 0; i < inputList.size(); i++) {
            if(inputList.get(i) != ItemStack.EMPTY && !(inputList.get(i).getItem() instanceof WeaponPart) ){
                System.out.println(inputList.get(i));
                modStack = inputList.get(i);
            }
        }
        System.out.println(modStack);
        return modStack;
    }

    /*@SubscribeEvent(priority= EventPriority.HIGHEST, receiveCanceled=true)
    public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {

        if(!event.player.getEntityWorld().isRemote) {

            if (event.crafting.getItem() instanceof CustomPickaxe) {
                doToolNBT(event);
            }
            if (event.crafting.getItem() instanceof CustomAxe ) {
                doToolNBT(event);
            }
            if (event.crafting.getItem() instanceof CustomShovel ) {
                doToolNBT(event);
            }
            if (event.crafting.getItem() instanceof CustomHoe) {
                doToolNBT(event);
            }
            if (event.crafting.getItem() instanceof ToolPart) {

                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof CustomAxe) {
                            doQuickNBT(event, i, a);
                            PlayerHelper.spawnItemOnPlayer(event.player.world, event.player, new ItemStack(PrimalAPI.Items.LACQUER_STICK, 1));
                        }
                        if (a.getItem() instanceof CustomPickaxe) {
                            doQuickNBT(event, i, a);
                            PlayerHelper.spawnItemOnPlayer(event.player.world, event.player, new ItemStack(PrimalAPI.Items.LACQUER_STICK, 1));
                        }
                        if (a.getItem() instanceof CustomShovel) {
                            doQuickNBT(event, i, a);
                            PlayerHelper.spawnItemOnPlayer(event.player.world, event.player, new ItemStack(PrimalAPI.Items.LACQUER_STICK, 1));
                        }
                        if (a.getItem() instanceof CustomHoe) {
                            doQuickNBT(event, i, a);
                            PlayerHelper.spawnItemOnPlayer(event.player.world, event.player, new ItemStack(PrimalAPI.Items.LACQUER_STICK, 1));
                        }
                    }
                }
            }
        }
    }

    private void doQuickNBT(PlayerEvent.ItemCraftedEvent event, Integer i, ItemStack a){
        NBTTagCompound tempTag;
        tempTag = a.getSubCompound("tags").copy();
        event.crafting.getTagCompound().setTag("tags", tempTag);
        event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
        Integer tempDamage = event.craftMatrix.getStackInSlot(i).getItemDamage();
        event.crafting.setItemDamage(tempDamage);
    }

    private void doToolNBT(PlayerEvent.ItemCraftedEvent event) {
        NBTTagCompound tempTag;
        for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

            if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                if (a.getItem() instanceof ToolPart) {
                    tempTag = a.getSubCompound("tags").copy();
                    event.crafting.getTagCompound().setTag("tags", tempTag);
                    event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                    event.crafting.setItemDamage(event.craftMatrix.getStackInSlot(i).getItemDamage());
                }
            }
        }
    }*/
}
