package nmd.primal.forgecraft;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.PlayerHelper;
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


    @SubscribeEvent(priority= EventPriority.HIGHEST, receiveCanceled=true)
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
    }
}
