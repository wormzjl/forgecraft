package com.kitsu.medievalcraft.item.craftingtools.filters;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;

public class FineFilter extends Item {
	private String name = "fineFilter";
	private Item item;
	
public FineFilter() {
		
		setMaxStackSize(1);
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		setMaxDamage(300);
		setNoRepair();
		item = this;
		GameRegistry.registerItem(this, name);
	}

    public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_)
    {
        return false;
    }

	
}
