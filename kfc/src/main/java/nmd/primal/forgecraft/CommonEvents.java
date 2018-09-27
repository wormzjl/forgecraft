package nmd.primal.forgecraft;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import nmd.primal.forgecraft.items.parts.BronzeToolPart;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.items.tools.*;
import nmd.primal.forgecraft.items.tools.bronze.BronzeAxe;
import nmd.primal.forgecraft.items.tools.bronze.BronzeHoe;
import nmd.primal.forgecraft.items.tools.bronze.BronzePickaxe;
import nmd.primal.forgecraft.items.tools.bronze.BronzeShovel;
import nmd.primal.forgecraft.util.ToolNBT;

/**
 * Created by mminaie on 3/15/17.
 */
public class CommonEvents implements ToolNBT {


    @SubscribeEvent(priority= EventPriority.LOWEST, receiveCanceled=true)
    public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {

        if(!event.player.getEntityWorld().isRemote) {

            if (event.crafting.getItem() instanceof CustomPickaxe || event.crafting.getItem() instanceof BronzePickaxe) {
                NBTTagCompound tempTag = new NBTTagCompound();
                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof ToolPart || a.getItem() instanceof BronzeToolPart) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            event.crafting.setItemDamage(event.craftMatrix.getStackInSlot(i).getItemDamage());
                        }
                    }
                }
            }
            if (event.crafting.getItem() instanceof CustomAxe || event.crafting.getItem() instanceof BronzeAxe) {
                NBTTagCompound tempTag = new NBTTagCompound();
                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof ToolPart || a.getItem() instanceof BronzeToolPart) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            event.crafting.setItemDamage(event.craftMatrix.getStackInSlot(i).getItemDamage());
                        }
                    }
                }
            }
            if (event.crafting.getItem() instanceof CustomShovel || event.crafting.getItem() instanceof BronzeShovel) {
                NBTTagCompound tempTag = new NBTTagCompound();
                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof ToolPart || a.getItem() instanceof BronzeToolPart) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            event.crafting.setItemDamage(event.craftMatrix.getStackInSlot(i).getItemDamage());
                        }
                    }
                }
            }
            if (event.crafting.getItem() instanceof CustomHoe || event.crafting.getItem() instanceof BronzeHoe) {
                NBTTagCompound tempTag = new NBTTagCompound();
                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof ToolPart || a.getItem() instanceof BronzeToolPart) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            event.crafting.setItemDamage(event.craftMatrix.getStackInSlot(i).getItemDamage());
                        }
                    }
                }
            }
            if (event.crafting.getItem() instanceof ToolPart || event.crafting.getItem() instanceof BronzeToolPart) {
                NBTTagCompound tempTag = new NBTTagCompound();
                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof CustomAxe || a.getItem() instanceof BronzeAxe) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            Integer tempDamage = event.craftMatrix.getStackInSlot(i).getItemDamage();
                            event.crafting.setItemDamage(tempDamage);
                        }
                        if (a.getItem() instanceof CustomPickaxe || a.getItem() instanceof BronzePickaxe) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            Integer tempDamage = event.craftMatrix.getStackInSlot(i).getItemDamage();
                            event.crafting.setItemDamage(tempDamage);
                        }
                        if (a.getItem() instanceof CustomShovel || a.getItem() instanceof BronzeShovel) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            Integer tempDamage = event.craftMatrix.getStackInSlot(i).getItemDamage();
                            event.crafting.setItemDamage(tempDamage);
                        }
                        if (a.getItem() instanceof CustomHoe || a.getItem() instanceof BronzeHoe) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            Integer tempDamage = event.craftMatrix.getStackInSlot(i).getItemDamage();
                            event.crafting.setItemDamage(tempDamage);
                        }
                    }
                }
            }
        }
    }


}
