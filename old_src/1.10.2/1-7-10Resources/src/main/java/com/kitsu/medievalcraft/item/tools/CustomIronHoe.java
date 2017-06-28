package com.kitsu.medievalcraft.item.tools;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomIronHoe extends ItemHoe{
	//private String name = "customIronPick";
	//private Item item;

	public CustomIronHoe(String name, ToolMaterial mat) {
		super(mat);
		//item = this;
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		//this.toolMaterial = ModItems.customWoodNormal;
		//GameRegistry.registerItem(this, name);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add("Uses Left: " + Integer.toString(stack.getMaxDamage()-stack.getItemDamage()));
	}


	@Override
	public int getItemEnchantability () {
		return 0;
	}

	@Override
	public boolean getIsRepairable(ItemStack item, ItemStack repair)
	{
		return Items.iron_ingot == repair.getItem() ? true : false;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return false;
	}
}
