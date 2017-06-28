package com.kitsu.medievalcraft.tileents;

import net.minecraft.tileentity.TileEntity;

public class TileEntityTestBlock extends TileEntity{

	private String testBlockName;
	
	public void forgeName(String string){
		this.testBlockName = string;
	}
	
}
