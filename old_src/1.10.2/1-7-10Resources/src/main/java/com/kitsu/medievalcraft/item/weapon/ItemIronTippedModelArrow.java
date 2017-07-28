package com.kitsu.medievalcraft.item.weapon;

import net.minecraft.item.Item;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemIronTippedModelArrow extends Item {
	

	private String name = "itemIronTippedModelArrow";
	
	public ItemIronTippedModelArrow() {
		
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		
	}

}
