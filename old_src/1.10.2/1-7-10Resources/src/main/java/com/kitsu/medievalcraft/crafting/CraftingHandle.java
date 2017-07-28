package com.kitsu.medievalcraft.crafting;

import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.item.ModItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftingHandle {

	public static int craftflag;
	//ItemStack j;
	//ItemStack R;


	@SubscribeEvent
	public void onItemCrafting(PlayerEvent.ItemCraftedEvent event) {    

		for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots 

			if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
				//ItemStack a = event.craftMatrix.getStackInSlot(i);
				ItemStack j = event.craftMatrix.getStackInSlot(i); // Gets the item
				//ItemStack L = event.craftMatrix.getStackInSlot(i - 1);
				//ItemStack R = event.craftMatrix.getStackInSlot(i+3);

				//FORGE HAMMER
				if (j.getItem() != null && j.getItem() == ModItems.forgeHammer) {

					ItemStack k = new ItemStack(ModItems.forgeHammer, 2, (j.getItemDamage() + 1));

					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);
					event.player.worldObj.playSoundAtEntity(event.player, "random.anvil_use", 0.8F, 1.0F );

					//IRONSAW
				}  if (j.getItem() != null && j.getItem() == ModItems.ironSaw) {
					ItemStack k = new ItemStack(ModItems.ironSaw, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.player.worldObj.playSoundAtEntity(event.player, Main.MODID + ":sawwood", 0.1F, 2.0F);
					event.craftMatrix.setInventorySlotContents(i, k);
					//FLINTSAW
				}  if (j.getItem() != null && j.getItem() == ModItems.flintSaw) {
					ItemStack k = new ItemStack(ModItems.flintSaw, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.player.worldObj.playSoundAtEntity(event.player, Main.MODID + ":sawwood", 0.1F, 3.0F);
					event.craftMatrix.setInventorySlotContents(i, k);
					
					//WORKBLADE
				}  if (j.getItem() != null && j.getItem() == ModItems.workBlade) {
					ItemStack k = new ItemStack(ModItems.workBlade, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON AXE FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironAxeForm) {
					ItemStack k = new ItemStack(ModItems.ironAxeForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON BATTLE AXE FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironBattleAxeForm) {
					ItemStack k = new ItemStack(ModItems.ironBattleAxeForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON DAGGER FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironDaggerForm) {
					ItemStack k = new ItemStack(ModItems.ironDaggerForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON HALBERD FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironHandleForm) {
					ItemStack k = new ItemStack(ModItems.ironHandleForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON HOE FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironHoeForm) {
					ItemStack k = new ItemStack(ModItems.ironHoeForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON LONGSWORD FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironLongswordForm) {
					ItemStack k = new ItemStack(ModItems.ironLongswordForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON MACE HEAD FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironMaceHeadForm) {
					ItemStack k = new ItemStack(ModItems.ironMaceHeadForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON PICKAXE FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironPickaxeForm) {
					ItemStack k = new ItemStack(ModItems.ironPickaxeForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON RING FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironRingForm) {
					ItemStack k = new ItemStack(ModItems.ironRingForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON SAWBLADE FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironSawBladeForm) {
					ItemStack k = new ItemStack(ModItems.ironSawBladeForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON SHARP TIP FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironSharpTipForm) {
					ItemStack k = new ItemStack(ModItems.ironSharpTipForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON SHORT SWORD FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironShortSwordForm) {
					ItemStack k = new ItemStack(ModItems.ironShortSwordForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON SPADE FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironSpadForm) {
					ItemStack k = new ItemStack(ModItems.ironSpadForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//IRON SPEAR TIP FORM
				}  if (j.getItem() != null && j.getItem() == ModItems.ironSpearTipForm) {
					ItemStack k = new ItemStack(ModItems.ironSpearTipForm, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);

					//LEATHER SHEARS
				}  if (j.getItem() != null && j.getItem() == ModItems.leatherShears) {
					ItemStack k = new ItemStack(ModItems.leatherShears, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);
					event.player.worldObj.playSoundAtEntity(event.player, "mob.sheep.shear", 0.8F, 1.0F );

				}	
			}
		}
	}
}
