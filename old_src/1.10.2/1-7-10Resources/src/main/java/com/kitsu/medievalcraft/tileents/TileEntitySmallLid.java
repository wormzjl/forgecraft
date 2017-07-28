package com.kitsu.medievalcraft.tileents;

import com.kitsu.medievalcraft.block.ModBlocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntitySmallLid extends TileEntity {

	private String smallLidName;
	public int logs;
	public int ring;
	//public static boolean hitGood = false;
	//public NBTTagCompound nbt = new NBTTagCompound();

	public void smallLidName(String string){
		this.smallLidName = string;
	}

	@Override
	public void updateEntity() {
		World world = this.getWorldObj();
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		if(!world.isRemote){
			if(ring>=2){
				world.setBlock(x, y, z, ModBlocks.smallBarrel, 0, 2);
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		if (nbt.hasKey("CustomName", 8)) {
			this.smallLidName = nbt.getString("CustomName");
		}
		this.logs = nbt.getInteger("LOGS");
		this.ring = nbt.getInteger("RING");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setInteger("LOGS", logs);
		nbt.setInteger("RING", ring);
	}
	
	@Override
	public Packet getDescriptionPacket() {
	    NBTTagCompound nbt = new NBTTagCompound();
	    writeToNBT(nbt);
	    return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, -999, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
	    readFromNBT(pkt.func_148857_g());
	    worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
//func_148857_g()

	public void markForUpdate(){
		worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}
}
