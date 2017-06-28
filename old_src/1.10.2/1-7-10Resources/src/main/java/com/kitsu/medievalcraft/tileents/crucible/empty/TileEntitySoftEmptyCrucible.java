package com.kitsu.medievalcraft.tileents.crucible.empty;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import com.kitsu.medievalcraft.block.ModBlocks;

public class TileEntitySoftEmptyCrucible extends TileEntity {

	private String emptyCrucibleName;
	public int cookTime = 250;
	public Block cookBlock = ModBlocks.emptyCookedCrucible;
	
	public void emptyCrucibleName(String string){
		this.emptyCrucibleName = string;
	}
	
}
