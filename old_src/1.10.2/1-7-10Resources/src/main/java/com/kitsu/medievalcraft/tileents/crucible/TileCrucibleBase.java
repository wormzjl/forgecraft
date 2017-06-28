package com.kitsu.medievalcraft.tileents.crucible;

import com.kitsu.medievalcraft.block.ModBlocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileCrucibleBase extends TileEntity {
	
	private String specName;
	public int coolTicks;
	public int heatTicks;
	public boolean cooked;
	public boolean hot;
	//private NBTTagCompound nbt = new NBTTagCompound();
	public TileCrucibleBase(String name){
		specName = name;
	}
	
	public void markForUpdate(){
		worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}
	
	@Override
	public void updateEntity() {
		World world = this.getWorldObj();
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		if(!world.isRemote){
			if(this.heatTicks<=0){
				world.setBlockMetadataWithNotify(x, y, z, 1, 2);
			}
			if(this.coolTicks<=0){
				world.setBlockMetadataWithNotify(x, y, z, 2, 2);
			}
			coolDown(world, x, y, z);
			//System.out.println(this.heatTicks);
			//System.out.println(this.coolTicks);
		}
	}
	
	private void coolDown(World world, int x, int y, int z){
		if(!world.isRemote){
			if((world.getBlock(x, y-1, z)!=ModBlocks.firebox)&&(this.hot==true)){
				coolTicks--;
				if(coolTicks <= 0){
					this.cooked=true;
					this.hot=false;
					this.markForUpdate();
					this.markDirty();
				}
			}
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		this.coolTicks = tagCompound.getInteger("COOLTICKS");
		this.heatTicks = tagCompound.getInteger("HEATTICKS");
		this.cooked = tagCompound.getBoolean("COOKED");
		this.hot = tagCompound.getBoolean("HOT");
		if (tagCompound.hasKey("CustomName", 8)) {
			specName = tagCompound.getString("CustomName");
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("COOLTICKS", this.coolTicks);
		tagCompound.setInteger("HEATTICKS", this.heatTicks);
		tagCompound.setBoolean("COOKED", this.cooked);
		tagCompound.setBoolean("HOT", this.hot);
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
