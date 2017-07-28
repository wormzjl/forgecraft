package com.kitsu.medievalcraft.contain;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.tileents.machine.TileEntityAnvilForge;
import com.kitsu.medievalcraft.tileents.machine.TileEntityFirebox;

public class ContainerForgeAnvil extends Container {

	protected TileEntityAnvilForge tileEnt;

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tileEnt.isUseableByPlayer(player);
	}

	public ContainerForgeAnvil (InventoryPlayer inventoryPlayer, TileEntityAnvilForge te){
		tileEnt = te;
		addSlotToContainer(new Slot(tileEnt, 0, 80, 34));
		bindPlayerInventory(inventoryPlayer);
	}
	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
						8 + j * 18, 84 + i * 18));
			}
		}
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);
		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();
			if (slot < 9) {
				if (!this.mergeItemStack(stackInSlot, 9, this.inventorySlots.size(), true)) {
					return null;
				}
			}
			else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
				return null;
			}
			if (stackInSlot.stackSize == 0) {
				slotObject.putStack((ItemStack)null);
			} else {
				slotObject.onSlotChanged();
			}
		}
		return stack;
	}

}