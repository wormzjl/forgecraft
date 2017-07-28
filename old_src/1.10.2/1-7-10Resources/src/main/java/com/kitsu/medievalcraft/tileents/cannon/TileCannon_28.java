package com.kitsu.medievalcraft.tileents.cannon;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.util.CannonUtil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileCannon_28 extends TileEntity implements IInventory, ISidedInventory, CannonUtil{

	private String tileCannon_28;
	private ItemStack[] inv;
	private NBTTagCompound tag = new NBTTagCompound();
	private int ticks;
	public boolean isOn;
	public static boolean smoke;
	public static int xSmoke, ySmoke, zSmoke;
	private static final int[] slots_all = new int[] {0,1};
	private static final int[] slots_top = new int[] {0};
	//private static final int[] slots_bottom = new int[] {2, 1};
	private static final int[] slots_sides = new int[] {1};


	public TileCannon_28(){
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
	public ItemStack decrStackSize(int slot, int par2)
	{
		if (this.inv[slot] != null)
		{
			ItemStack itemstack;

			if (this.inv[slot].stackSize <= par2)
			{
				itemstack = this.inv[slot];
				this.inv[slot] = null;
				this.markForUpdate();
				this.markDirty();
				return itemstack;
			}
			itemstack = this.inv[slot].splitStack(par2);

			if (this.inv[slot].stackSize == 0)
			{
				this.inv[slot] = null;
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
		return this.hasCustomInventoryName() ? this.tileCannon_28 : "tileCannon_28";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.tileCannon_28 != null && this.tileCannon_28.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 5;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {}
	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		if(this.getStackInSlot(0)==null && slot == 0 && itemstack.getItem() == Items.gunpowder){
			return true;
		}
		if(this.getStackInSlot(0)!=null && slot == 0 && itemstack.getItem() == Items.gunpowder && this.getStackInSlot(0).stackSize <= 5){
				return true;
		}
		if(this.getStackInSlot(1)==null && slot == 1 && itemstack.getItem() == Item.getItemFromBlock(ModBlocks.cannonBall_28)){
			return true;
		}
		if(this.getStackInSlot(1)!=null){
				return false;
		}

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
			this.tileCannon_28 = tagCompound.getString("CustomName");
		}

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
			if(this.isOn==true){
				ticks++;
			}
			if(ticks>=100){
				this.isOn=false;
				ticks=0;
			}
		}
		if(world.isRemote){

		}
		if (worldObj.isRemote) return;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int par1) {

		/*if(par1 == 1){
			return slots_top;
		}
		else return slots_sides;*/
		return slots_all;
		
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int p_102007_3_) {

		return this.isItemValidForSlot(slot, itemstack);
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {

		return false;
	}




}





