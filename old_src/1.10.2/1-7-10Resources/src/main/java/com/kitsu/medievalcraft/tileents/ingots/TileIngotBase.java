package com.kitsu.medievalcraft.tileents.ingots;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.machine.TileEntityAnvilForge;
import com.kitsu.medievalcraft.util.AnvilUtil;

public class TileIngotBase extends TileEntity implements AnvilUtil{

	private String specName;
	public int hits = 0;
	public int heatBase = 300;
	public int coolTicks = 250;
	public int heatTicks = 300;
	public int coolBase = 250;
	public boolean hot;

	public TileIngotBase(String name){
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
			//System.out.println(this.heatTicks);
			if(this.heatTicks<=0){
				world.setBlockMetadataWithNotify(x, y, z, 1, 2);
				this.hot=true;
				//this.heatTicks=100;
			}
			if(this.coolTicks<=0){
				world.setBlockMetadataWithNotify(x, y, z, 0, 2);
			}
			coolDown(world,x,y,z);
			//makeItem(world,x,y,z);
		}

	}

	private void coolDown(World world, int x, int y, int z){
		if(!world.isRemote){
			if(this.hot==true){
				if(world.getBlockMetadata(x, y-1, z)<8){
					coolTicks--;
					if(coolTicks <= 0){
						world.setBlockMetadataWithNotify(x, y, z, 0, 2);
						this.hot=false;
						this.coolTicks=coolBase;
						this.heatTicks=heatBase;
						this.markForUpdate();
						this.markDirty();
					}
				}
			}
		}
	}

	/*
	private void makeItem(World world, int x, int y, int z){
		if(this.hits==0 && this.hot==true && world.getBlock(x, y-1, z).equals(ModBlocks.forgeAnvil)){
			TileEntityAnvilForge tile = (TileEntityAnvilForge) world.getTileEntity(x, y-1, z);
			if(tile.getStackInSlot(0)!=null){



				System.out.println(forms.get(tile.getStackInSlot(0).getItem().getUnlocalizedName()));
				if(tile.getStackInSlot(0).equals(forms.get(tile.getStackInSlot(0).getItem().getUnlocalizedName()))){
					System.out.println("Logic is Working");
				}
			}
		}
	}
	 */

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		this.hits = tagCompound.getInteger("HITS");
		this.coolTicks = tagCompound.getInteger("COOLTICK");
		this.heatTicks = tagCompound.getInteger("HEATTICKS");
		this.hot = tagCompound.getBoolean("HOT");
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("HITS", this.hits);
		tagCompound.setInteger("COOLTICK", this.coolTicks);
		tagCompound.setInteger("HEATTICKS", this.heatTicks);
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