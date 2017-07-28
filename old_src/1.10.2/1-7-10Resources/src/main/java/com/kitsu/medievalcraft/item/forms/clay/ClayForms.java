package com.kitsu.medievalcraft.item.forms.clay;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;

public abstract class ClayForms extends Item {
	
	protected ClayForms(String name, Item item){
		setMaxStackSize(1);
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		setHasSubtypes(false);
		item = this;
		GameRegistry.registerItem(this, name);
		
	}
}
