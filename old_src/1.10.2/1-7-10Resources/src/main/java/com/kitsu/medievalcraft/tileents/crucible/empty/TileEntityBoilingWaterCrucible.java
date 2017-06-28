package com.kitsu.medievalcraft.tileents.crucible.empty;

import com.kitsu.medievalcraft.block.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityBoilingWaterCrucible extends TileEntity {

	private String boilingWaterCrucibleName;
	private int bticks, cticks;
	public boolean dotan, dolime;

	public NBTTagCompound nbt = new NBTTagCompound();

	public void forgeName(String string){
		this.boilingWaterCrucibleName = string;
	}
	private void heat(World world, int x, int y, int z){
		if(!world.isRemote){
			if(world.getBlock(x, y-1, z).equals(ModBlocks.firebox)&&world.getBlockMetadata(x, y-1, z)==1){
				cticks = 0;
				if((dotan==true)){
					bticks++;
					if(bticks >= 1000 + world.rand.nextInt(50)){
						world.setBlock(x, y, z, ModBlocks.tanWaterCrucible, 0, 2);
						//System.out.println("Tan Crucible");
					}
				}
				if((dolime==true)){
					bticks++;
					if(bticks >= 1000 + world.rand.nextInt(50)){
						world.setBlock(x, y, z, ModBlocks.slackWaterCrucible, 0, 2);
						//System.out.println("Tan Crucible");
					}
				}
			}
		}
	}
	private void cool(World world, int x, int y, int z){
		Block fire = this.worldObj.getBlock(x, y-2, z);
		Block ironbar = this.worldObj.getBlock(x, y - 1, z);
		if(!world.isRemote){
			if(world.getBlock(x, y-1, z)!=(ModBlocks.firebox)||world.getBlock(x, y-1, z)!=(Blocks.fire)){
				cticks++;
				if(cticks >= 500 + world.rand.nextInt(50)){
					world.setBlock(x, y, z, ModBlocks.filledWaterCrucible, 0, 2);
				}
			}
			if(world.getBlock(x, y-1, z)==(ModBlocks.firebox)&&world.getBlockMetadata(x, y, z)==0){
				cticks++;
				if(cticks >= 500 + world.rand.nextInt(50)){
					world.setBlock(x, y, z, ModBlocks.filledWaterCrucible, 0, 2);
				}
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		this.bticks = tagCompound.getInteger("BTICKS");
		this.cticks = tagCompound.getInteger("CTICKS");
		this.dotan = tagCompound.getBoolean("DOTAN");
		this.dotan = tagCompound.getBoolean("DOLIME");
		if (tagCompound.hasKey("CustomName", 8)) {
			this.boilingWaterCrucibleName = tagCompound.getString("CustomName");
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("BTICKS", bticks);
		tagCompound.setInteger("CTICKS", cticks);
		tagCompound.setBoolean("DOTAN", dotan);
		tagCompound.setBoolean("DOLIME", dolime);
	}

	@Override
	public void updateEntity() {
		World world = this.getWorldObj();
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		if(!world.isRemote){
			heat(world, x, y, z);
			cool(world, x, y, z);
		}
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
