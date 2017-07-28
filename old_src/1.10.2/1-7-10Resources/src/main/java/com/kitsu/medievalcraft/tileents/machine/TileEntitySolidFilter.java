package com.kitsu.medievalcraft.tileents.machine;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.item.ModItems;

public class TileEntitySolidFilter extends TileEntity implements IInventory{

	private String solidFilterName;
	public ItemStack[] inv;
	private NBTTagCompound tag = new NBTTagCompound();
	public boolean renderFilter;
	public int hits;
	public int renderInt;


	public TileEntitySolidFilter(){
		inv = new ItemStack[1];
	}

	public void sandFilterName(String string){
		this.solidFilterName = string;
	}

	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_)
	{
		if (this.inv[p_70304_1_] != null)
		{
			ItemStack itemstack = this.inv[p_70304_1_];
			this.inv[p_70304_1_] = null;
			return itemstack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		this.inv[slot] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.solidFilterName : "Filter";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.solidFilterName != null && this.solidFilterName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack itemstack) {

		return false;
	}
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Inventory", 10);
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
		if (tagCompound.hasKey("CustomName", 8)) {
			this.solidFilterName = tagCompound.getString("CustomName");
		}

		this.hits = tag.getInteger("FILTERHITS");
		//this.renderFilter = tag.getBoolean("RENDER");
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];
			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
		tag.setInteger("FILTERHITS", this.hits);
		//tag.setBoolean("RENDER", this.renderFilter);
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
	{
		if (this.inv[p_70298_1_] != null)
		{
			ItemStack itemstack;

			if (this.inv[p_70298_1_].stackSize <= p_70298_2_)
			{
				itemstack = this.inv[p_70298_1_];
				this.inv[p_70298_1_] = null;
				return itemstack;
			}
			itemstack = this.inv[p_70298_1_].splitStack(p_70298_2_);

			if (this.inv[p_70298_1_].stackSize == 0)
			{
				this.inv[p_70298_1_] = null;
			}

			return itemstack;
		}
		return null;
	}

	public void updateEntity() {
		World world = this.getWorldObj();
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		if(!world.isRemote){
			if(hits>=10 + world.rand.nextInt(10)){

				world.playSoundEffect(x+0.5D, y+0.5D, z+0.5D, "dig.sand", 1.0F, 0.5F);
				if(world.getBlock(x, y+1, z).equals(Blocks.sand)){
					if(this.getStackInSlot(0).getItem() == ModItems.coarseFilter){
						world.spawnEntityInWorld(new EntityItem(world, x, y-0.5D, z, new ItemStack(ModItems.quartzDust, 1 + world.rand.nextInt(3))));
						System.out.println("quartzDust Please");
					}
					if(this.getStackInSlot(0).getItem() == ModItems.mediumFilter){
						world.spawnEntityInWorld(new EntityItem(world, x, y-0.5D, z, new ItemStack(ModItems.salt, 1 + world.rand.nextInt(3))));
					}
					if(this.getStackInSlot(0).getItem() == ModItems.fineFilter){
						world.spawnEntityInWorld(new EntityItem(world, x, y-0.5D, z, new ItemStack(ModItems.limestoneDust, 2 + world.rand.nextInt(3))));
					}
				}
				if(world.getBlock(x, y+1, z).equals(Blocks.gravel)){
					if(this.getStackInSlot(0).getItem() == ModItems.coarseFilter){
						if(world.rand.nextInt(2) == 0){
						world.spawnEntityInWorld(new EntityItem(world, x, y-0.5D, z, new ItemStack(Items.flint, 1 + world.rand.nextInt(1))));
						}
					}
					if(this.getStackInSlot(0).getItem() == ModItems.mediumFilter){
						//world.spawnEntityInWorld(new EntityItem(world, x, y-0.5D, z, new ItemStack(ModItems.salt, 1 + world.rand.nextInt(5))));
						if(world.rand.nextInt(2) == 0){
							world.spawnEntityInWorld(new EntityItem(world, x, y-0.5D, z, new ItemStack(Blocks.sand, 1)));
						}
					}
					if(this.getStackInSlot(0).getItem() == ModItems.fineFilter){
						if(world.rand.nextInt(2) == 0){
						world.spawnEntityInWorld(new EntityItem(world, x, y-0.5D, z, new ItemStack(ModItems.limestoneDust, 2 + world.rand.nextInt(2))));
						}
					}
				}
				hits=0;
				world.setBlockToAir(x, y+1, z);
			}
		}
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, -998, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

}




