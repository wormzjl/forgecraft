package com.kitsu.medievalcraft.tileents.machine;

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
import com.kitsu.medievalcraft.crafting.TestForgeCrafting;
import com.kitsu.medievalcraft.tileents.ingots.TileIngotBase;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityTestForge extends TileEntity implements IInventory {

	public ItemStack[] inv;
	private String forgeName;
	private int type, checkKey, cookKey, ticks, fuelTicks;
	public boolean isRunning;
	private NBTTagCompound tag = new NBTTagCompound();

	public TileEntityTestForge(){
		inv = new ItemStack[1];
	}

	public void forgeName(String string){
		this.forgeName = string;
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
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_)
	{
		this.inv[p_70299_1_] = p_70299_2_;

		if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
		{
			p_70299_2_.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.forgeName : "Forge";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.forgeName != null && this.forgeName.length() > 0;
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

	private Block getBlock(Block testBlock){
		for(int i = 0; i < TestForgeCrafting.blockToCheck.size(); i++){
			if(testBlock == TestForgeCrafting.blockToCheck.get(i)){
				checkKey = i;
				type = checkKey;
			}
		}
		return TestForgeCrafting.blockToCheck.get(type);
	}
	/*private int getCookTime(int a){
		for(int i = 0; i < TestForgeCrafting.cookTable.size(); i++){
			if(a == TestForgeCrafting.cookTable.get(i)){
				cookKey = i;
			}
		}
		return TestForgeCrafting.cookTable.get(cookKey);
	}*/

	private void cook(World world, int x, int y, int z){
		Block isAir = world.getBlock(x, y+2, z);
		Block checkBlock = world.getBlock(x, y+1, z);
		Block fire = world.getBlock(x, y-1, z);
		TileEntityTestForge tileEnt = (TileEntityTestForge) world.getTileEntity(x, y, z);
		if(!world.isRemote){
			if(fire==ModBlocks.firebox){
				TileEntityFirebox box = (TileEntityFirebox) world.getTileEntity(x, y-1, z);
				if(checkBlock instanceof IngotBase && box.isOn==true && isItemFuel(this.getStackInSlot(0))==true){
					TileIngotBase tile = (TileIngotBase) world.getTileEntity(x, y+1, z);
					System.out.println(tile.hot);
					System.out.println(tile.heatTicks);
					if(tile.hot==false){
						tile.heatTicks--;
					}
				}
			}
		}
	}
	
	private void fuelDec(World world, int x, int y, int z){
		Block fire = world.getBlock(x, y-1, z);
		TileEntityTestForge tileEnt = (TileEntityTestForge) world.getTileEntity(x, y, z);
		if(!world.isRemote){
			if(tileEnt.getStackInSlot(0) != null){
				if((isItemFuel(tileEnt.getStackInSlot(0)) == true) && (world.getBlock(x, y-1, z).equals(fire))){
					fuelTicks++;
					
					//System.out.println(fuelTicks + " " + getItemBurnTime(tileEnt.getStackInSlot(0)));
					if(fuelTicks >= 2*getItemBurnTime(tileEnt.getStackInSlot(0))){
						fuelTicks = 0;
						
						if (tileEnt.getStackInSlot(0).stackSize == 1){
							tileEnt.setInventorySlotContents(0, null);
						} else {
							tileEnt.getStackInSlot(0).stackSize--;
						}
					}
				}
			}
			if(tileEnt.getStackInSlot(0) == (null)){
				fuelTicks = 0;
			}
		}
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

	@Override
	public void updateEntity() {
		World world = getWorldObj();
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		cook(world, x, y, z);
		fuelDec(world, x, y, z);
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
			this.forgeName = tagCompound.getString("CustomName");
		}

		this.type = tag.getInteger("TYPE");
		this.ticks = tag.getInteger("TICKS");
		this.fuelTicks = tag.getInteger("FUELTICKS");
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
		tag.setInteger("TYPE", type);
		tag.setInteger("TICKS", this.ticks);
		tag.setInteger("FUELTICKS", this.fuelTicks);
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}
	
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
