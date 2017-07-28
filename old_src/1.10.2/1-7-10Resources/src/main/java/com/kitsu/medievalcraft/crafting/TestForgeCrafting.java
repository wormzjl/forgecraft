package com.kitsu.medievalcraft.crafting;

import java.util.Hashtable;

import net.minecraft.block.Block;

import com.kitsu.medievalcraft.block.ModBlocks;

public class TestForgeCrafting {
	
	public static final Hashtable<Integer, Block> blockToCheck = new Hashtable <Integer, Block>(){{
		
		/*put(0, ModBlocks.myIronIngot);
		put(1, ModBlocks.filledCrucibleIron);
		put(2, ModBlocks.emptySoftCrucible);
		put(3, ModBlocks.ironPlate);
		put(4, ModBlocks.filledCrucibleIronIngot);
		put(5, ModBlocks.filledCrucibleDamascus);
		put(6, ModBlocks.damascusIngot);
		put(7, ModBlocks.filledLapisCrucible);
		put(8, ModBlocks.lapisIngot);
		put(9, ModBlocks.redstoneIngot);
		put(10, ModBlocks.filledRedstoneCrucible);*/
		
	}};
	
	/*public static final Hashtable<Integer, Integer> cookTable= new Hashtable <Integer, Integer>(){{

		put(0, 300);
		put(1, 1000);
		put(2, 200);
		put(3, 250);
		put(4, 750);
		put(5, 1200);
		put(6, 400);
		put(7, 900);
		put(8, 400);
		put(9, 400);
		put(10, 900);
	}};*/
	
	public static final Hashtable<Integer, Block> blockToCook = new Hashtable <Integer, Block>(){{

		put(0, ModBlocks.refinedIron);
		//put(1, ModBlocks.crucibleIronOre);
		//put(2, ModBlocks.emptyCookedCrucible);
		put(3, ModBlocks.ironPlate);
		//put(4, ModBlocks.hotCrucibleIron);
		//put(5, ModBlocks.hotCrucibleDamascus);
		put(6, ModBlocks.damascus);
		//put(7, ModBlocks.hotLapisCrucible);
		//put(8, ModBlocks.hotLapisIngot);
		//put(9, ModBlocks.hotRedstoneIngot);
		//put(10, ModBlocks.hotRedstoneCrucible);
		
	}};
	

	
	
}
