package com.kitsu.medievalcraft.tileents.machine;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.block.ModBlocks;

public class TileEntityWaterFilter extends TileEntity{
	
	private String waterFilterName;
	private int filterTime;
	private NBTTagCompound nbt = new NBTTagCompound();
	
	public void forgeName(String string){
		this.waterFilterName = string;
	}
	
	@Override
	public void updateEntity() {
		World world = this.getWorldObj();
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		
		if(!world.isRemote){

			doFilter(world, x, y, z);
		}
	}
	
	private void doFilter(World world, int x, int y, int z){
		Block filterInput = world.getBlock(x, y+1, z);
		Block filterOutput = world.getBlock(x, y-1, z);
		
		if((filterOutput.equals(Blocks.air))){
			if(filterInput.equals(Blocks.water)){
				filterTime++;
				if(filterTime>=450 + world.rand.nextInt(100)){
					world.setBlock(x, y-1, z, ModBlocks.blockFilteredWater, 0, 2);
					world.setBlockToAir(x, y+1, z);
					filterTime=0;
				}
			}
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		//this.hits = nbt.getInteger("HITS");
		this.filterTime = nbt.getInteger("FILTERTIME");
		//this.hitGood = nbt.getBoolean("HITBOOLEAN");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		//nbt.setInteger("HITS", hits);
		nbt.setInteger("FILTERTIME", filterTime);
		//nbt.setBoolean("HITBOOLEAN", hitGood);
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
