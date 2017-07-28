package com.kitsu.medievalcraft.tileents.crucible.empty;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySlackWaterCrucible extends TileEntity {

	private String slackWaterCrucibleName;
	//int cticks;
	NBTTagCompound tagCompound = new NBTTagCompound();

	public void forgeName(String string){
		this.slackWaterCrucibleName = string;
	}

 }

