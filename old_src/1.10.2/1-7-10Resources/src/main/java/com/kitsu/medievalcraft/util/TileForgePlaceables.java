package com.kitsu.medievalcraft.util;

import java.util.Hashtable;

import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.block.ModBlocks;

public interface TileForgePlaceables {

	static final Hashtable<Integer, ItemStack> placeMe = new Hashtable <Integer, ItemStack>(){{

		put(0, new ItemStack(ModBlocks.refinedIron));
		put(1, new ItemStack(ModBlocks.redstoneIngot));
		put(2, new ItemStack(ModBlocks.lapisIngot));
		put(3, new ItemStack(ModBlocks.ironPlate));
		put(4, new ItemStack(ModBlocks.damascus));

	}};
	
}
