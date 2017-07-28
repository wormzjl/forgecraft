package com.kitsu.medievalcraft.tileents.ingots;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMyDiamond extends TileEntity {
	
	private String myDiamond;
	public int hits = 0;
	public boolean hitGood = false;
	private  NBTTagCompound nbt = new NBTTagCompound();
	
	public void forgeName(String string){
		this.myDiamond = string;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.hits = nbt.getInteger("HITS");
		this.hitGood = nbt.getBoolean("HITBOOLEAN");
		//this.visitor1 = nbt.getString("visitor1");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setInteger("HITS", hits);
		nbt.setBoolean("HITBOOLEAN", hitGood);
		//nbt.setString("visitor1", visitor1);
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, -998, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

}