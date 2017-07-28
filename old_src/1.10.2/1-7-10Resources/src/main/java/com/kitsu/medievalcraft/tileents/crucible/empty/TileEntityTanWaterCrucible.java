package com.kitsu.medievalcraft.tileents.crucible.empty;

import net.minecraft.tileentity.TileEntity;

public class TileEntityTanWaterCrucible extends TileEntity {

	private String tanWaterCrucibleName;
	//int cticks;
	//NBTTagCompound tagCompound = new NBTTagCompound();

	public void forgeName(String string){
		this.tanWaterCrucibleName = string;
	}
	/*
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		//this.cticks = tagCompound.getInteger("CTICKS");
		if (tagCompound.hasKey("CustomName", 8)) {
			this.tanWaterCrucibleName = tagCompound.getString("CustomName");
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		//tagCompound.setInteger("CTICKS", cticks);
	}
	
	/*@Override
	public void updateEntity() {
		World world = this.getWorldObj();
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		if(!world.isRemote){
			//heat(world, x, y, z);
		}
	}*/
 }

