package nmd.primal.forgecraft;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.oredict.OreDictionary;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.api.events.CauldronEvent;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.items.parts.WeaponPart;
import nmd.primal.forgecraft.items.tools.CustomAxe;
import nmd.primal.forgecraft.items.tools.CustomHoe;
import nmd.primal.forgecraft.items.tools.CustomPickaxe;
import nmd.primal.forgecraft.items.tools.CustomShovel;
import nmd.primal.forgecraft.util.ToolNBT;

/**
 * Created by mminaie on 3/15/17.
 */
public class CommonEvents implements ToolNBT {

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onItemCrafted(CauldronEvent event){

        NonNullList<ItemStack> inputs = NonNullList.<ItemStack>withSize(6,ItemStack.EMPTY);
        inputs.set(0, event.getTile().getInputHandler().getStackInSlot(0));
        inputs.set(1, event.getTile().getInputHandler().getStackInSlot(1));
        inputs.set(2, event.getTile().getInputHandler().getStackInSlot(2));
        inputs.set(3, event.getTile().getInputHandler().getStackInSlot(3));
        inputs.set(4, event.getTile().getInputHandler().getStackInSlot(4));
        inputs.set(5, event.getTile().getInputHandler().getStackInSlot(5));

        NonNullList<ItemStack> outputs = NonNullList.<ItemStack>withSize(6,ItemStack.EMPTY);
        outputs.set(0, event.getTile().getOutputHandler().getStackInSlot(0));
        outputs.set(1, event.getTile().getOutputHandler().getStackInSlot(1));
        outputs.set(2, event.getTile().getOutputHandler().getStackInSlot(2));
        outputs.set(3, event.getTile().getOutputHandler().getStackInSlot(3));
        outputs.set(4, event.getTile().getOutputHandler().getStackInSlot(4));
        outputs.set(5, event.getTile().getOutputHandler().getStackInSlot(5));

        //System.out.println(inputs. + ":" + outputs.stream());

        if(getMatchingStacks(inputs, outputs).get(0) != ItemStack.EMPTY){

            System.out.println(getMatchingStacks(inputs, outputs).get(0) + " : " + getMatchingStacks(inputs, outputs).get(1));
        }

    }

    private NonNullList<ItemStack> getMatchingStacks(NonNullList<ItemStack> input, NonNullList<ItemStack> output){
        ItemStack inputStack = ItemStack.EMPTY;
        ItemStack outputStack = ItemStack.EMPTY;
        NonNullList<ItemStack> returnList = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);
        for (int i = 0; i < input.size(); i++) {
            if(input.get(i).getItem() instanceof WeaponPart){
                inputStack = input.get(i);
            }
        }
        for (int i = 0; i < output.size(); i++) {
            if(output.get(i).getItem() instanceof WeaponPart){
                outputStack = output.get(i);
            }
        }
        if(inputStack != null && outputStack != null && inputStack.equals(outputStack)){
            returnList.set(0, inputStack);
            returnList.set(1, outputStack);
        }
        return returnList;
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
