package com.kitsu.medievalcraft.tileents.machine;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
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
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.block.crucible.CrucibleBase;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleBase;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntityFilledWaterCrucible;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntitySoftEmptyCrucible;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityFirebox extends TileEntity implements IInventory{

	private String fireboxName;
	private ItemStack[] inv;
	private NBTTagCompound tag = new NBTTagCompound();
	private int ticks;
	public boolean isOn;

	public TileEntityFirebox(){
		this.inv = new ItemStack[1];
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
		return this.hasCustomInventoryName() ? this.fireboxName : "Shelf";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.fireboxName != null && this.fireboxName.length() > 0;
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
			this.fireboxName = tagCompound.getString("CustomName");
		}
		//this.stack0 = tagCompound.getString("stack0");
		this.ticks = tag.getInteger("TICKS");
		this.isOn = tag.getBoolean("ISON");

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
		tag.setInteger("TICKS", this.ticks);
		tag.setBoolean("ISON", this.isOn);
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

		World world = getWorldObj();
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		if(!world.isRemote){

			fireboxMaint(world, x, y, z);
			fireboxFuelDec(world, x, y, z, this.getStackInSlot(0), this.ticks);
			isFurnace(world, x, y, z);
			isCrucible(world, x, y, z);
			//isIngot(world, x, y, z);
		}
		if (worldObj.isRemote) return;
	}
	
	private void fireboxMaint(World world, int x, int y, int z){
		if((this.getStackInSlot(0)==null)&&(world.getBlockMetadata(x, y, z)==1)){
			world.setBlockMetadataWithNotify(x, y, z, 0, 3);
			if(world.getBlock(x, y+1, z)==Blocks.fire){
				world.setBlock(x, y+1, z, Blocks.air, 0, 2);
			}
			this.markForUpdate();
			this.markDirty();
			//world.getBlock(x, y, z).setLightLevel(0f);
		}
		if(world.getBlockMetadata(x, y, z)==1 && world.getBlock(x, y+1, z).equals(Blocks.air)){
			world.setBlock(x, y+1, z, Blocks.fire, 0, 2);
		}
	}
	private void fireboxFuelDec(World world, int x, int y, int z, ItemStack stack, int time){
		if(world.getBlock(x, y+1, z).equals(Blocks.fire)){
			if(stack!=null){
				if(isItemFuel(stack)==true){
					this.ticks++;
					double burnTime = (this.getItemBurnTime(stack)+((fuelMulti(stack.stackSize, stack)*this.getItemBurnTime(stack))));
					//System.out.println(this.ticks);
					if(time >= burnTime){
						decrStackSize(0, 1);
						this.ticks=0;
					}
					markForUpdate();
				}
			}
		}
	}
	private static double fuelMulti(int i, ItemStack stack){
		double a=0;
		if(stack!=null){
			if(stack.stackSize<=15){
				a=0.25;
			}
			if(stack.stackSize>=16 && stack.stackSize<=31){
				a=0.5;
			}
			if(stack.stackSize>=32 && stack.stackSize<=47){
				a=0.75;
			}
			if(stack.stackSize>=48){
				a=1;
			}
		}
		return a;
	}
	public static int getItemBurnTime(ItemStack stack)
	{
		if (stack == null)
		{
			return 0;
		}
		Item item = stack.getItem();

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
		return GameRegistry.getFuelValue(stack);
	}
	public static boolean isItemFuel(ItemStack stack)
	{
		if(getItemBurnTime(stack)>0){
			return true;
		} else
		return false;
	}
	public void isFurnace(World world, int x, int y, int z){
		if(world.getBlock(x, y+1, z).equals(Blocks.furnace)&&(world.getBlockMetadata(x, y, z)==1)){
			TileEntityFurnace tile = (TileEntityFurnace) world.getTileEntity(x, y+1, z);
			if(tile.getStackInSlot(0)!=null){
				if(isItemFuel(tile.getStackInSlot(1))==false){
					tile.furnaceBurnTime = (int)(this.getItemBurnTime(this.getStackInSlot(0))+((fuelMulti(this.getStackInSlot(0).stackSize, this.getStackInSlot(0))*this.getItemBurnTime(this.getStackInSlot(0)))));
					BlockFurnace.updateFurnaceBlockState(true, world, x, y+1, z);
				}
			}
		}
		if(world.getBlock(x, y+1, z).equals(Blocks.furnace)&&(world.getBlockMetadata(x, y, z)==1)){
			TileEntityFurnace tile = (TileEntityFurnace) world.getTileEntity(x, y+1, z);
			if(tile.getStackInSlot(1)!=null){
				if(isItemFuel(tile.getStackInSlot(1))==false){
					BlockFurnace.updateFurnaceBlockState(false, world, x, y+1, z);
				}
			}
		}
	}
	public void isCrucible(World world, int x, int y, int z){
		if(world.getBlock(x, y+1, z) instanceof CrucibleBase){
			TileCrucibleBase tile = (TileCrucibleBase) world.getTileEntity(x, y+1, z);
			if(tile.hot == false && tile.cooked == false && world.getBlockMetadata(x, y, z)==1){
				tile.heatTicks--;
				if(tile.heatTicks<=0){
					tile.hot=true;
					tile.markForUpdate();
					tile.markDirty();
				}
			}
		}
		if(world.getBlock(x, y+1, z).equals(ModBlocks.emptySoftCrucible)){
			TileEntitySoftEmptyCrucible tile = (TileEntitySoftEmptyCrucible) world.getTileEntity(x, y+1, z);
			if(world.getBlockMetadata(x, y, z)==1){
				tile.cookTime--;
				if(tile.cookTime<=0){
					world.setBlock(x, y+1, z, tile.cookBlock, 0, 2);
				}
			}
		}
		if(world.getBlock(x, y+1, z).equals(ModBlocks.filledWaterCrucible)){
			TileEntityFilledWaterCrucible tile = (TileEntityFilledWaterCrucible) world.getTileEntity(x, y+1, z);
			if(world.getBlockMetadata(x, y, z)==1){
				tile.cookTime--;
				if(tile.cookTime<=0){
					world.setBlock(x, y+1, z, tile.cookBlock, 0, 2);
				}
			}
		}
	}


}





