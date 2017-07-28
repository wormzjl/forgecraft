package com.kitsu.medievalcraft.item.craftingtools.filters;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;

public class CoarseFilter extends Item {
	private String name = "coarseFilter";
	private Item item;

	public CoarseFilter() {

		setMaxStackSize(1);
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		setMaxDamage(300);
		setNoRepair();
		item = this;
		GameRegistry.registerItem(this, name);
	}

	/*@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_){
		
		return true;
	}*/

	

	public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_)
	{
		return false;
	}




}
