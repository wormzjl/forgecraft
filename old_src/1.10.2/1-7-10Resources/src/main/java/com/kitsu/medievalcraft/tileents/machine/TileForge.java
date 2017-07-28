package com.kitsu.medievalcraft.tileents.machine;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.block.ingots.IngotBase;
import com.kitsu.medievalcraft.tileents.ingots.TileIngotBase;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileForge extends TileEntity implements IInventory{
	private String tileForgeName;
	private ItemStack[] inv;
	private NBTTagCompound tag = new NBTTagCompound();
	public int heat;
	public boolean isOn;
	public boolean isBurning;
	private int ticks;
	private Random rand;

	public TileForge(){
		this.inv = new ItemStack[2];
	}

	@Override
	public int getSizeInventory() {
		return this.inv.length;
	}
	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.inv[slot];
	}

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
				this.markForUpdate();
				this.markDirty();
				return itemstack;
			}
			itemstack = this.inv[p_70298_1_].splitStack(p_70298_2_);

			if (this.inv[p_70298_1_].stackSize == 0)
			{
				this.inv[p_70298_1_] = null;
			}
			this.markForUpdate();
			this.markDirty();
			return itemstack;
		}
		this.markForUpdate();
		this.markDirty();
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i)
	{
		if (this.inv[i] != null)
		{
			ItemStack itemstack = this.inv[i];
			this.inv[i] = null;
			this.markForUpdate();
			this.markDirty();
			return itemstack;
		}
		else
		{
			this.markForUpdate();
			this.markDirty();
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		this.inv[slot] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
		this.markForUpdate();
		this.markDirty();
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.tileForgeName : "Forge";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.tileForgeName != null && this.tileForgeName.length() > 0;
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
	public void openInventory() {}
	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack itemstack) {
		return false;
	}

	public void markForUpdate(){
		worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		NBTTagList tagList = tagCompound.getTagList("Inventory", 10);
		this.inv = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < this.inv.length) {
				this.inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
		if (tagCompound.hasKey("CustomName", 8)) {
			this.tileForgeName = tagCompound.getString("CustomName");
		}
		//this.stack0 = tagCompound.getString("stack0");
		this.heat  = tag.getInteger("HEAT");
		this.isOn  = tag.getBoolean("ISON");
		this.ticks = tag.getInteger("TICKS");
		this.isBurning  = tag.getBoolean("BURNING");

	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < inv.length; i++) {
			//ItemStack stack = inv[i];
			if (inv[i] != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				this.inv[i].writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
		tag.setInteger("HEAT", this.heat);
		tag.setBoolean("ISON", this.isOn);
		tag.setBoolean("BURNING", this.isBurning);
		tag.setInteger("TICKS", this.ticks);

	}
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 998, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void updateEntity() {

		World world = this.getWorldObj();
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		if(!world.isRemote){
			forgeMaint(world,x,y,z);
			heatIngot(world, x, y, z);
			fireboxFuelDec(world, x, y, z,this.getStackInSlot(0), this.ticks);
			fireboxFuelDec2(world, x, y, z,this.getStackInSlot(1), this.ticks);
			//System.out.println(world.getBlockMetadata(x, y, z));
		}

		if (worldObj.isRemote) return;
	}

	private void heatIngot(World world, int x, int y, int z){
		if(!world.isRemote){
			if(world.getBlock(x, y+1, z) instanceof IngotBase){
				TileIngotBase tile = (TileIngotBase) world.getTileEntity(x, y+1, z);
				if(world.getBlockMetadata(x, y, z)>7){
					if(tile.hot==false){
						tile.heatTicks--;
					}
				}
			}
		}
	}

	private void fireboxFuelDec(World world, int x, int y, int z, ItemStack stack, int time){
		if(world.getBlockMetadata(x, y, z)>3){
			if(stack!=null){
				if(isItemFuel(stack)==true){
					this.ticks++;
					double burnTime = (this.getItemBurnTime(stack)+((fuelMulti(stack.stackSize, stack)*this.getItemBurnTime(stack))));
					//System.out.println(this.ticks+" "+ burnTime+" "+this.getStackInSlot(0).stackSize);
					if(time >= burnTime){
						if(this.getStackInSlot(0).stackSize==1){
							this.setInventorySlotContents(0, null);
						}
						decrStackSize(0, 1);
						this.ticks=0;
					}
					markForUpdate();
				}
			}
		}
	}


	private void fireboxFuelDec2(World world, int x, int y, int z, ItemStack stack, int time){
		if(world.getBlockMetadata(x, y, z)>7){
			if(stack!=null){
				if(isItemFuel(stack)==true){
					this.ticks++;
					double burnTime = 1.5*(this.getItemBurnTime(stack)+((fuelMulti(stack.stackSize, stack)*this.getItemBurnTime(stack))));
					//System.out.println(this.ticks+" "+ burnTime+" "+this.getStackInSlot(0).stackSize);
					if(time >= burnTime){
						if(this.getStackInSlot(1).stackSize==1){
							this.setInventorySlotContents(1, null);
						}
						decrStackSize(1, 1);
						this.ticks=0;
					}
					markForUpdate();
				}
			}
		}
	}

	private static double fuelMulti(int i, ItemStack stack){
		if(stack!=null){
			if(stack.stackSize<=15){
				return 0.25;
			}
			if(stack.stackSize>=16 && stack.stackSize<=31){
				return 0.5;
			}
			if(stack.stackSize>=32 && stack.stackSize<=47){
				return 0.75;
			}
			if(stack.stackSize>=48){
				return 1;
			}
		}
		return 0.0d;
	}

	public static int getItemBurnTime(ItemStack p_145952_0_)
	{
		if (p_145952_0_ == null)
		{
			return 0;
		}
		Item item = p_145952_0_.getItem();

		if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
		{
			Block block = Block.getBlockFromItem(item);

			if (block == Blocks.wooden_slab)
			{
				return 150;
			}

			if (block.getMaterial() == Material.wood)
			{
				return 300;
			}

			if (block == Blocks.coal_block)
			{
				return 16000;
			}
		}

		if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
		if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
		if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
		if (item == Items.stick) return 100;
		if (item == Items.coal) return 1600;
		if (item == Items.lava_bucket) return 20000;
		if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
		if (item == Items.blaze_rod) return 2400;
		return GameRegistry.getFuelValue(p_145952_0_);
	}

	public static boolean isItemFuel(ItemStack stack)
	{
		return getItemBurnTime(stack) > 0;
	}

	private void forgeMaint(World world, int x, int y, int z){
		if(this.getStackInSlot(0)==null){
			if(world.getBlockMetadata(x, y, z)>=4&&world.getBlockMetadata(x, y, z)<=7){
				world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z)-4, 3);
				this.markDirty();
				this.markForUpdate();
				//world.getBlock(x, y, z).setLightLevel(0f);
			}
		}
		if(this.getStackInSlot(0)==null){
			if(world.getBlockMetadata(x, y, z)>7){
				world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z)-8, 3);
				this.markDirty();
				this.markForUpdate();
				//world.getBlock(x, y, z).setLightLevel(0f);
			}
		}
		if(this.getStackInSlot(1)==null){
			if(world.getBlockMetadata(x, y, z)>=8){
				world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z)-4, 3);
			}
		}
		if(world.getBlockMetadata(x, y, z)>3&&world.getBlockMetadata(x, y, z)<8){
			if(this.getStackInSlot(1)!=null){
				if(world.canBlockSeeTheSky(x, y+1, z)==true || world.provider.isHellWorld==true){
					world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z)+4, 3);
				}
			}
		}
		if(world.getBlockMetadata(x, y, z)>7){
			if(world.rand.nextInt(5)==1){
				world.setBlock(x, y+2, z, ModBlocks.blockSmoke, 0, 2);
			}
		}
	}
}





