package com.kitsu.medievalcraft.compat;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;

public class ModDict {
	
	public static void RegisterOres () {
		
		//OreDictionary.registerOre("itemLeather", Items.leather);
		
		OreDictionary.registerOre("strapLeather", new ItemStack(ModItems.leatherStrap, 1, 0));
		OreDictionary.registerOre("ringIron",  new ItemStack(ModItems.ironRing, 1, 0));
		OreDictionary.registerOre("ingotIron", new ItemStack(ModBlocks.refinedIron, 1, 0));
		OreDictionary.registerOre("nuggetIron", new ItemStack(ModItems.ironChunk, 1, 0));
		OreDictionary.registerOre("ingotSteel", new ItemStack(ModBlocks.damascus, 1, 0));
		OreDictionary.registerOre("materialHardenedLeather", new ItemStack(ModItems.finishedLeather, 1, 0));
		OreDictionary.registerOre("bladeTool", new ItemStack(ModItems.workBlade, 1, 0));
		OreDictionary.registerOre("foodSalt", new ItemStack(ModItems.salt, 1, 0));
		OreDictionary.registerOre("pulpWood", new ItemStack(ModItems.woodPulp, 1, 0));
		OreDictionary.registerOre("knappedFlint", new ItemStack(ModItems.flintKnapped, 1, 0));
		
		OreDictionary.registerOre("blockClay", new ItemStack(Blocks.clay, 1, 0));
        OreDictionary.registerOre("clumpClay", new ItemStack(Items.clay_ball, 1, 0));
        OreDictionary.registerOre("clumpFuel", new ItemStack(ModBlocks.shitblock, 1, 0));
        
        OreDictionary.registerOre("ingotBrickClay", new ItemStack(Items.brick, 1, 0));
        OreDictionary.registerOre("cordageStrong", new ItemStack(Items.string, 1, 0));
		//OreDictionary.registerOre("cordage", new ItemStack(ModItems.leatherString, 1, 0));
		//OreDictionary.registerOre("itemLeather", ModItems.cutLeather);
		//OreDictionary.replacements.put(new ItemStack(Item.leather), "itemLeather");
		
		
		//OreDictionary.registerOre("strapLeather", new ItemStack(ModItems.leatherStrap));
		
	}
}


/*
 *        
 *      OreDictionary.registerOre("foodSalt", new ItemStack(ModItems.saltRock, 1, 0));
        OreDictionary.registerOre("foodSalt", new ItemStack(ModItems.saltFire, 1, 0));
        OreDictionary.registerOre("foodSalt", new ItemStack(ModItems.saltVoid, 1, 0));
        OreDictionary.registerOre("foodSalt", new ItemStack(ModItems.saltNetjry, 1, 0));
 * 
 */