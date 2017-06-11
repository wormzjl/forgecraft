package nmd.primal.forgecraft;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.items.tools.CustomAxe;
import nmd.primal.forgecraft.items.tools.CustomHoe;
import nmd.primal.forgecraft.items.tools.CustomPickaxe;
import nmd.primal.forgecraft.items.tools.CustomShovel;
import nmd.primal.forgecraft.util.ToolNBT;

/**
 * Created by mminaie on 3/15/17.
 */
public class CommonEvents implements ToolNBT {


    @SubscribeEvent(priority= EventPriority.LOWEST, receiveCanceled=true)
    public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {

        if(!event.player.getEntityWorld().isRemote) {

            if (event.crafting.getItem() instanceof CustomPickaxe) {
                NBTTagCompound tempTag = new NBTTagCompound();
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
            }
            if (event.crafting.getItem() instanceof CustomAxe) {
                NBTTagCompound tempTag = new NBTTagCompound();
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
            }
            if (event.crafting.getItem() instanceof CustomShovel) {
                NBTTagCompound tempTag = new NBTTagCompound();
                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof ToolPart) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            event.crafting.setItemDamage(event.craftMatrix.getStackInSlot(i).getItemDamage());
                            //if( getDiamondLevel(event.crafting) > 0 ){
                            //    event.crafting.getItem().setHarvestLevel("pickaxe", 3);
                            //}
                        }
                    }
                }
            }
            if (event.crafting.getItem() instanceof CustomHoe) {
                NBTTagCompound tempTag = new NBTTagCompound();
                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof ToolPart) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            event.crafting.setItemDamage(event.craftMatrix.getStackInSlot(i).getItemDamage());
                            //if( getDiamondLevel(event.crafting) > 0 ){
                            //    event.crafting.getItem().setHarvestLevel("pickaxe", 3);
                            //}
                        }
                    }
                }
            }
            if (event.crafting.getItem() instanceof ToolPart) {
                NBTTagCompound tempTag = new NBTTagCompound();
                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof CustomAxe) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            Integer tempDamage = event.craftMatrix.getStackInSlot(i).getItemDamage();
                            event.crafting.setItemDamage(tempDamage);
                        }
                        if (a.getItem() instanceof CustomPickaxe) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            Integer tempDamage = event.craftMatrix.getStackInSlot(i).getItemDamage();
                            event.crafting.setItemDamage(tempDamage);
                        }
                        if (a.getItem() instanceof CustomShovel) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            Integer tempDamage = event.craftMatrix.getStackInSlot(i).getItemDamage();
                            event.crafting.setItemDamage(tempDamage);
                        }
                        if (a.getItem() instanceof CustomHoe) {
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
