/*
 * SERIOUS ISSUE WITH RENDERING OTHER PLAYERS BOW USAGE PROPERLY
 * CURRENT IMPLEMENTATION ONLY RENDERS ON THE CLIENT FOR THE FIRST PERSON VIEW, THE ICON, AND AS AN ENTITY
 * 
 * THE CURRENT IDEA IS TO CREATE A CASE WHERE IF ANOTHER PLAYER BESIDES THE CURRENT PLAYER IS USING THE LONBOW
 * THEN IT WILL REGISTER A DIFFERENT SET OF IItemRenderer's FOR THEM. THE NEW SET OF BOW RENDERS WILL BE ONLY
 * FOR THE THIRD PERSON CASE.
 * 
 * THIS APPROACH REQUIRES THAT THE CLIENT SIDE PLAYER RECIEVES WHICH PLAYER IS USING THE BOW IN 3RD PERSON AND
 * THAT THEY ARE USING A BOW. THE FINAL REQUIREMENT IS TO RECEIVE A PACKET THAT STATES WHICH PLAYER STOPPED USING THEIR BOW.
 * 
 * THE ITEMSTACKS NEED TO BE INSTANCED SO THAT IF A THIRD PLAYER IS USING THE LONGBOW THEN THEY WILL RENDER A DIFFERENT SET
 * OF MODELS.
 * 
 */

package com.kitsu.medievalcraft.item.weapon;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.entity.EntityModelArrow;
import com.kitsu.medievalcraft.entity.EntityModelITArrow;
import com.kitsu.medievalcraft.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemLongbow extends Item{

	public static int longbowTicks;
	private String name = "longbow";
	private boolean bowUse ;
	Random rand = new Random();
	//private NBTTagCompound bowTag = new NBTTagCompound();

	public ItemLongbow() {
		setMaxStackSize(1);
		setUnlocalizedName(name);
		//setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		setMaxDamage(1000);
		setNoRepair();

		GameRegistry.registerItem(this, name);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.bow;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int p_77663_4_, boolean using) {

		if((using == true)&&(bowUse == false)){
			stack.stackTagCompound = new NBTTagCompound();
			stack.stackTagCompound.setInteger("D", 0);
		}
	}

	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		return 72000;
	}

	@Override
	public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player) {

		if((player.inventory.getStackInSlot(player.inventory.currentItem - 1)!=null)){
			if((player.inventory.getStackInSlot(player.inventory.currentItem - 1).getItem()==(ModItems.itemModelArrow))){
				player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
				bowUse = true;
			}
			if((player.inventory.getStackInSlot(player.inventory.currentItem - 1).getItem()==(ModItems.itemIronTippedModelArrow))){
				player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
				bowUse = true;
			}
		}
		return stack;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int p_77615_4_) {

		int j = this.getMaxItemUseDuration(stack) - p_77615_4_;

		stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger("D", 0);
		stack.damageItem(1, player);
		player.worldObj.playSoundAtEntity(player, (Main.MODID + ":longbowRelease"), 0.8F, 1.0F);

		if((player.inventory.getStackInSlot(player.inventory.currentItem - 1)!=null)){
			if((player.inventory.getStackInSlot(player.inventory.currentItem - 1).getItem()==(ModItems.itemModelArrow))){
				float f = j / 20.0F;
				f = (f * f + f * 2.0F) / 3.0F;

				if (f < 0.1D){
					return;
				}

				if (f > 1.0F){
					f = 1.0F;
				}

				player.inventory.consumeInventoryItem(ModItems.itemModelArrow);

				//EntityArrow arrow = new EntityArrow(world, player, f * 2.0F);

				if (!world.isRemote) {
					EntityModelArrow arrow = new EntityModelArrow(world, player, f * 2.0F);
					world.spawnEntityInWorld(arrow);
				}
			}
			if((player.inventory.getStackInSlot(player.inventory.currentItem - 1).getItem()==(ModItems.itemIronTippedModelArrow))){
				float f = j / 20.0F;
				f = (f * f + f * 2.0F) / 3.0F;

				if (f < 0.1D){
					return;
				}

				if (f > 1.0F){
					f = 1.0F;
				}

				player.inventory.consumeInventoryItem(ModItems.itemIronTippedModelArrow);

				//EntityArrow arrow = new EntityArrow(world, player, f * 2.0F);

				if (!world.isRemote) {
					EntityModelITArrow arrow = new EntityModelITArrow(world, player, f * 2.0F);
					world.spawnEntityInWorld(arrow);
				}
			}
		}
		bowUse = false;
	}
}




