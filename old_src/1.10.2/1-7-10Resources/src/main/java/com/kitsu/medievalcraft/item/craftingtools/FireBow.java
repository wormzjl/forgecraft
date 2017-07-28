package com.kitsu.medievalcraft.item.craftingtools;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;


public class FireBow extends Item {

	private String name = "fireBow";
	private Item item;
	Random rand = new Random();

	public FireBow() {

		setMaxStackSize(1);
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		setMaxDamage(100);
		setNoRepair();

		item = this;

		GameRegistry.registerItem(this, name);

	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_){
		if(!world.isRemote){
			if(rand.nextInt(5) == 0){
				world.setBlock(x, y + 1, z , Blocks.fire);
				stack.damageItem(1, player);
				//player.worldObj.playSoundAtEntity(player, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
				/*for(int i=0; i < player.worldObj.playerEntities.size(); i++){
					EntityPlayer test = (EntityPlayer) player.worldObj.playerEntities.get(i);
					Vec3 vecTest = Vec3.createVectorHelper(test.posX, test.posY, test.posZ);
					Vec3 vecPlayer = Vec3.createVectorHelper(player.posX, player.posY, player.posZ);
					if(vecPlayer.distanceTo(vecTest)>10f && vecPlayer.distanceTo(vecTest)<100f){
						test.worldObj.playSoundAtEntity(test, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
					}
				}*/
			}
		}
		return true;
	}

	@Override
	public int getItemEnchantability () {
		return 0;

	}

	@Override
	public boolean getIsRepairable(ItemStack item, ItemStack repair){
		return Items.stick == repair.getItem() ? true : false;
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
		return false;
	}

	@Override
	public Item getContainerItem()
	{
		item.setDamage(new ItemStack(item), +1);
		return item;
	}

}




