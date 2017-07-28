package com.kitsu.medievalcraft.item.misc;

import net.minecraft.item.Item;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;

public class CrucibleLid extends Item {
	
	private String name = "crucibleLid";
	
	public CrucibleLid () {
		
		super();
		
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + name);
		GameRegistry.registerItem(this, name);
		
	}

}
