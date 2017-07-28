package com.kitsu.medievalcraft.item.tools;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomIronShovel extends ItemSpade{
	private String name = "customIronShovel";
	private Item item;

	public CustomIronShovel(String name, ToolMaterial mat) {
		super(mat);
		//item = this;
		this.setUnlocalizedName(name);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setTextureName(Main.MODID + ":" + name);
		//this.toolMaterial = ModItems.customWoodNormal;
		//GameRegistry.registerItem(this, name);
	}
	@Override
	public int getItemEnchantability () {
		return 0;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		list.add("Uses Left: " + Integer.toString(stack.getMaxDamage()-stack.getItemDamage()));
	}

	@Override
	public boolean getIsRepairable(ItemStack item, ItemStack repair) {
		return Items.iron_ingot == repair.getItem() ? true : false;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack){
		return false;
	}

	
}
