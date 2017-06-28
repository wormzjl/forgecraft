package com.kitsu.medievalcraft.item;

import java.util.Hashtable;

import com.kitsu.medievalcraft.block.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class TongsDamageTable {

public static final Hashtable<Block, Integer> blockToStore = new Hashtable <Block, Integer>(){{
		
		put(ModBlocks.crucibleIronOre, 1);
		put(ModBlocks.crucibleIronIngot, 2);
		put(ModBlocks.crucibleLapis, 3);
		put(ModBlocks.crucibleRedstone, 4);
		put(ModBlocks.crucibleWootz, 5);
		put(ModBlocks.lapisIngot, 6);
		put(ModBlocks.redstoneIngot, 7);
		put(ModBlocks.damascus, 8);
		put(ModBlocks.refinedIron, 9);
		put(ModBlocks.ironPlate, 10);

	}};
	
public static final Hashtable<Integer, Block> blockToGet = new Hashtable <Integer, Block>(){{
		
		put(1, ModBlocks.crucibleIronOre);
		put(2, ModBlocks.crucibleIronIngot);
		put(3, ModBlocks.crucibleLapis);
		put(4, ModBlocks.crucibleRedstone);
		put(5, ModBlocks.crucibleWootz);
		put(6, ModBlocks.lapisIngot);
		put(7, ModBlocks.redstoneIngot);
		put(8, ModBlocks.damascus);
		put(9, ModBlocks.refinedIron);
		put(10, ModBlocks.ironPlate);
		//put(11, ModBlocks.hotDamascusIngot);
		//put(12, ModBlocks.hotIronPlate);
		//put(13, ModBlocks.hotLapisIngot);
		//put(14, ModBlocks.hotRedstoneIngot);
	}};
}
