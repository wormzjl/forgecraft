package com.kitsu.medievalcraft.block.wood;

import java.util.Random;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.packethandle.curedLeather.MsgPacketCuredLeatherX;
import com.kitsu.medievalcraft.packethandle.shelf.MsgPacketShelfCase;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.machine.TileEntityFirebox;
import com.kitsu.medievalcraft.tileents.machine.TileEntityShelfFour;
import com.kitsu.medievalcraft.tileents.machine.TileEntitySolidFilter;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2FPacketSetSlot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ShelfFour extends BlockContainer{

	private final Random random = new Random();
	private int meta;
	private int c;
	public static int caseType;
	private float mopX, mopY, mopZ, mopBlockX, mopBlockY, mopBlockZ;
	public ItemStack stack0;

	public ShelfFour(String unlocalizedName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setHarvestLevel("pickaxe", 1, 0);
		this.setStepSound(Block.soundTypeStone);

		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		//this.setBlockBounds(0.1F, 0.01F,  0.1F, 
		//0.9F,  1.0F, 0.9F);
	}

	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {

		TileEntityShelfFour tileEnt = (TileEntityShelfFour) world.getTileEntity(x, y, z);

		if(world.isRemote){
			MovingObjectPosition mop = Minecraft.getMinecraft().renderViewEntity.rayTrace(5, 1.0F);
			mopX = (float) mop.hitVec.xCoord;
			mopY = (float) mop.hitVec.yCoord;
			mopZ = (float) mop.hitVec.zCoord;
			mopBlockX = mop.blockX;
			mopBlockY = mop.blockY;
			mopBlockZ = mop.blockZ;

			//METADATA 0
			//CASE 0
			if((world.getBlockMetadata(x, y, z) == 0)
					&& (mopX > mopBlockX+0.5f) 
					&& (mopY > mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX) 
					&& ((Math.floor(mopY)) == mopBlockY) 
					&& (Math.floor(mopZ) == mopBlockZ)){
				//System.out.println("Case 0");
				c = 0;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
			//CASE 1
			if((world.getBlockMetadata(x, y, z) == 0)
					&& (mopX < mopBlockX+0.5f) 
					&& (mopY > mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX) 
					&& ((Math.floor(mopY)) == mopBlockY) 
					&& (Math.floor(mopZ) == mopBlockZ)){
				//System.out.println("Case 1");
				c = 1;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
			//CASE 2
			if((world.getBlockMetadata(x, y, z) == 0) 
					&& (mopX > mopBlockX+0.5f) 
					&& (mopY < mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX) 
					&& ((Math.floor(mopY)) == mopBlockY) 
					&& (Math.floor(mopZ) == mopBlockZ)){
				//System.out.println("Case 2");
				c = 2;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
			//CASE 3
			if((world.getBlockMetadata(x, y, z) == 0) 
					&& (mopX < mopBlockX+0.5f) 
					&& (mopY < mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX) 
					&& ((Math.floor(mopY) == mopBlockY)) 
					&& (Math.floor(mopZ) == mopBlockZ)){
				//System.out.println("Case 3");
				c = 3;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}

			//METADATA 2
			//CASE 4
			if((world.getBlockMetadata(x, y, z) == 2) 
					&& (mopX < mopBlockX+0.5f) 
					&& (mopY > mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX) 
					&& (Math.floor(mopY) == mopBlockY) 
					&& (Math.floor(mopZ) == mopBlockZ+1)){
				//System.out.println("Case 4");
				c = 4;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
			//CASE 5
			if((world.getBlockMetadata(x, y, z) == 2) 
					&& (mopX > mopBlockX+0.5f) 
					&& (mopY > mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX) 
					&& (Math.floor(mopY) == mopBlockY) 
					&& (Math.floor(mopZ) == mopBlockZ+1)){
				//System.out.println("Case 5");
				c = 5;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
			//CASE 6
			if((world.getBlockMetadata(x, y, z) == 2) 
					&& (mopX < mopBlockX+0.5f) 
					&& (mopY < mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX) 
					&& (Math.floor(mopY) == mopBlockY) 
					&& (Math.floor(mopZ) == mopBlockZ+1)){
				//System.out.println("Case 6");
				c = 6;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
			//CASE 7
			if((world.getBlockMetadata(x, y, z) == 2) 
					&& (mopX > mopBlockX+0.5f) 
					&& (mopY < mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX) 
					&& (Math.floor(mopY) == mopBlockY) 
					&& (Math.floor(mopZ) == mopBlockZ+1)){
				//System.out.println("Case 7");
				c = 7;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}

			//METADATA 1
			//CASE 8
			if((world.getBlockMetadata(x, y, z) == 1) 
					&& (mopZ > mopBlockZ+0.5f) 
					&& (mopY > mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX+1) 
					&& ((Math.floor(mopY) == mopBlockY) 
							&& (Math.floor(mopZ)) == mopBlockZ)){
				//System.out.println("Case 8");
				c = 8;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
			//CASE 9
			if((world.getBlockMetadata(x, y, z) == 1) 
					&& (mopZ < mopBlockZ+0.5f) 
					&& (mopY > mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX+1) 
					&& ((Math.floor(mopY) == mopBlockY) 
							&& (Math.floor(mopZ)) == mopBlockZ)){
				//System.out.println("Case 9");
				c = 9;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
			//CASE 10
			if((world.getBlockMetadata(x, y, z) == 1) 
					&& (mopZ > mopBlockZ+0.5f) 
					&& (mopY < mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX+1) 
					&& ((Math.floor(mopY) == mopBlockY) 
							&& (Math.floor(mopZ)) == mopBlockZ)){
				//System.out.println("Case 10");
				c = 10;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
			//CASE 11
			if((world.getBlockMetadata(x, y, z) == 1) 
					&& (mopZ < mopBlockZ+0.5f) 
					&& (mopY < mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX+1) 
					&& ((Math.floor(mopY) == mopBlockY) 
							&& (Math.floor(mopZ)) == mopBlockZ)){
				//System.out.println("Case 11");
				c = 11;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}

			//METADATA 3
			//CASE 12
			if((world.getBlockMetadata(x, y, z) == 3) 
					&& (mopZ < mopBlockZ+0.5f) 
					&& (mopY > mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX)
					&& ((Math.floor(mopY) == mopBlockY) 
							&& (Math.floor(mopZ)) == mopBlockZ)){
				//System.out.println("Case 12");
				c = 12;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
			//CASE 13
			if((world.getBlockMetadata(x, y, z) == 3) 
					&& (mopZ > mopBlockZ+0.5f) 
					&& (mopY > mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX) 
					&& ((Math.floor(mopY) == mopBlockY) 
							&& (Math.floor(mopZ)) == mopBlockZ)){
				//System.out.println("Case 13");
				c = 13;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
			//CASE 14
			if((world.getBlockMetadata(x, y, z) == 3) 
					&& (mopZ < mopBlockZ+0.5f) 
					&& (mopY < mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX) 
					&& ((Math.floor(mopY) == mopBlockY) 
							&& (Math.floor(mopZ)) == mopBlockZ)){
				//System.out.println("Case 14");
				c = 14;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
			//Case 15
			if((world.getBlockMetadata(x, y, z) == 3) 
					&& (mopZ > mopBlockZ+0.5f) 
					&& (mopY < mopBlockY+0.5f) 
					&& (Math.floor(mopX) == mopBlockX) 
					&& ((Math.floor(mopY) == mopBlockY) 
							&& (Math.floor(mopZ)) == mopBlockZ)){
				//System.out.println("Case 15");
				c = 15;
				Main.sNet.sendToServer(new MsgPacketShelfCase((int) c));
			}
		}

		/* 
		 * METADATA 0
		 * Meta 0 slot 0 = 0
		 * Meta 0 slot 1 = 1
		 * Meta 0 slot 2 = 2
		 * Meta 0 slot 3 = 3
		 * 
		 * METADATA 2
		 * Meta 2 slot 0 = 4
		 * Meta 2 slot 1 = 5
		 * Meta 2 slot 2 = 6
		 * Meta 2 slot 3 = 7
		 * 
		 * METADATA 1
		 * Meta 1 slot 0 = 8
		 * Meta 1 slot 1 = 9
		 * Meta 1 slot 2 = 10
		 * Meta 1 slot 3 = 11
		 * 
		 * METADATA 3
		 * Meta 3 slot 0 = 12
		 * Meta 3 slot 1 = 13
		 * Meta 3 slot 2 = 14
		 * Meta 3 slot 3 = 15
		 * 
		 * */
		if(!world.isRemote){

			//This will pull items of the Top Left Slot Also considered the 0 Slot
			if(caseType == 0){
				//System.out.println("Meta 0 Stack 0");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(0)==null){
						tileEnt.setInventorySlotContents(0, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					}
					if (tileEnt.getStackInSlot(0)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(0).stackSize<=63){
								ItemStack pStack = player.inventory.getCurrentItem().copy();
								ItemStack sStack = tileEnt.getStackInSlot(0).copy();
								ItemStack sStackTemp = tileEnt.getStackInSlot(0).copy();

								sStackTemp.stackSize++;
								if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
									tileEnt.setInventorySlotContents(0, sStackTemp);
									player.inventory.decrStackSize(player.inventory.currentItem, 1);
								}
							}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(0)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(0));
						tileEnt.setInventorySlotContents(0, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(0).getItem()) )){
						if(tileEnt.getStackInSlot(0)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(0).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(0, 1);
						}
					}
					return true;
				}
			}
			//Top Right Slot of the Shelf Slot 1
			if(caseType == 1){
				//System.out.println("Stack 1");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(1)==null){
						tileEnt.setInventorySlotContents(1, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
						//System.out.println("Stack 1 Statement 1 completed");
					}
					if (tileEnt.getStackInSlot(1)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(1).stackSize<=63){
								ItemStack pStack = player.inventory.getCurrentItem().copy();
								ItemStack sStack = tileEnt.getStackInSlot(1).copy();
								ItemStack sStackTemp = tileEnt.getStackInSlot(1).copy();

								sStackTemp.stackSize++;
								if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
									tileEnt.setInventorySlotContents(1, sStackTemp);
									player.inventory.decrStackSize(player.inventory.currentItem, 1);
								}
							}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(1)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(1));
						tileEnt.setInventorySlotContents(1, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(1).getItem()) )){
						if(tileEnt.getStackInSlot(1)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(1).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(1, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}
			//Bottom Left Slot of the Shelf Slot 2
			if(caseType == 2){
				//System.out.println("Stack 2");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(2)==null){
						tileEnt.setInventorySlotContents(2, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
						//System.out.println("Stack 1 Statement 1 completed");
					}
					if (tileEnt.getStackInSlot(2)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(2).stackSize<=63){
								ItemStack pStack = player.inventory.getCurrentItem().copy();
								ItemStack sStack = tileEnt.getStackInSlot(2).copy();
								ItemStack sStackTemp = tileEnt.getStackInSlot(2).copy();

								sStackTemp.stackSize++;
								if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
									tileEnt.setInventorySlotContents(2, sStackTemp);
									player.inventory.decrStackSize(player.inventory.currentItem, 1);
								}
							}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(2)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(2));
						tileEnt.setInventorySlotContents(2, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(2).getItem()) )){
						if(tileEnt.getStackInSlot(2)!=null){//RenderManager.instance.renderEntityWithPosYaw(this.entItem, 0.45D, 0.95D, 1.25D, 0.0F, 0.0F);
							ItemStack pStack = tileEnt.getStackInSlot(2).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(2, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}

			//Bottom Right Slot of the Shelf Slot 3
			if(caseType == 3){
				//System.out.println("Stack 2");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(3)==null){
						tileEnt.setInventorySlotContents(3, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
						//System.out.println("Stack 1 Statement 1 completed");
					}
					if (tileEnt.getStackInSlot(3)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(3).stackSize<=63){
								ItemStack pStack = player.inventory.getCurrentItem().copy();
								ItemStack sStack = tileEnt.getStackInSlot(3).copy();
								ItemStack sStackTemp = tileEnt.getStackInSlot(3).copy();

								sStackTemp.stackSize++;
								if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
									tileEnt.setInventorySlotContents(3, sStackTemp);
									player.inventory.decrStackSize(player.inventory.currentItem, 1);
								}
							}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(3)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(3));
						tileEnt.setInventorySlotContents(3, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(3).getItem()) )){
						if(tileEnt.getStackInSlot(3)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(3).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(3, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}


			//METADATA 2


			if(caseType == 4){
				//System.out.println("");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(0)==null){
						tileEnt.setInventorySlotContents(0, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					}
					if (tileEnt.getStackInSlot(0)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(0).stackSize<=63){
							ItemStack pStack = player.inventory.getCurrentItem().copy();
							ItemStack sStack = tileEnt.getStackInSlot(0).copy();
							ItemStack sStackTemp = tileEnt.getStackInSlot(0).copy();

							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(0, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(0)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(0));
						tileEnt.setInventorySlotContents(0, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(0).getItem()) )){
						if(tileEnt.getStackInSlot(0)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(0).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(0, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}
			//Top Right Slot of the Shelf Slot 1
			if(caseType == 5){
				//System.out.println("Stack 1");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(1)==null){
						tileEnt.setInventorySlotContents(1, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
						//System.out.println("Stack 1 Statement 1 completed");
					}
					if (tileEnt.getStackInSlot(1)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(1).stackSize<=63){
							ItemStack pStack = player.inventory.getCurrentItem().copy();
							ItemStack sStack = tileEnt.getStackInSlot(1).copy();
							ItemStack sStackTemp = tileEnt.getStackInSlot(1).copy();

							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(1, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(1)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(1));
						tileEnt.setInventorySlotContents(1, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(1).getItem()) )){
						if(tileEnt.getStackInSlot(1)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(1).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(1, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}
			//Bottom Left Slot of the Shelf Slot 2
			if(caseType == 6){
				//System.out.println("Stack 2");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(2)==null){
						tileEnt.setInventorySlotContents(2, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
						//System.out.println("Stack 1 Statement 1 completed");
					}
					if (tileEnt.getStackInSlot(2)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(2).stackSize<=63){
							ItemStack pStack = player.inventory.getCurrentItem().copy();
							ItemStack sStack = tileEnt.getStackInSlot(2).copy();
							ItemStack sStackTemp = tileEnt.getStackInSlot(2).copy();

							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(2, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(2)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(2));
						tileEnt.setInventorySlotContents(2, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(2).getItem()) )){
						if(tileEnt.getStackInSlot(2)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(2).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(2, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}

			//Bottom Right Slot of the Shelf Slot 3
			if(caseType == 7){
				//System.out.println("Stack 2");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(3)==null){
						tileEnt.setInventorySlotContents(3, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
						//System.out.println("Stack 1 Statement 1 completed");
					}
					if (tileEnt.getStackInSlot(3)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(3).stackSize<=63){
							ItemStack pStack = player.inventory.getCurrentItem().copy();
							ItemStack sStack = tileEnt.getStackInSlot(3).copy();
							ItemStack sStackTemp = tileEnt.getStackInSlot(3).copy();

							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(3, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(3)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(3));
						tileEnt.setInventorySlotContents(3, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(3).getItem()) )){
						if(tileEnt.getStackInSlot(3)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(3).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(3, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}

			//METADATA 1

			if(caseType == 8){
				//System.out.println("Meta 1 Slot 0");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(0)==null){
						tileEnt.setInventorySlotContents(0, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					}
					if (tileEnt.getStackInSlot(0)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(0).stackSize<=63){
							ItemStack pStack = player.inventory.getCurrentItem().copy();
							ItemStack sStack = tileEnt.getStackInSlot(0).copy();
							ItemStack sStackTemp = tileEnt.getStackInSlot(0).copy();

							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(0, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(0)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(0));
						tileEnt.setInventorySlotContents(0, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(0).getItem()) )){
						if(tileEnt.getStackInSlot(0)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(0).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(0, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}
			//Top Right Slot of the Shelf Slot 1
			if(caseType == 9){
				//System.out.println("Stack 1");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(1)==null){
						tileEnt.setInventorySlotContents(1, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
						//System.out.println("Stack 1 Statement 1 completed");
					}
					if (tileEnt.getStackInSlot(1)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(1).stackSize<=63){
							ItemStack pStack = player.inventory.getCurrentItem().copy();
							ItemStack sStack = tileEnt.getStackInSlot(1).copy();
							ItemStack sStackTemp = tileEnt.getStackInSlot(1).copy();

							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(1, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(1)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(1));
						tileEnt.setInventorySlotContents(1, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(1).getItem()) )){
						if(tileEnt.getStackInSlot(1)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(1).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(1, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}
			//Bottom Left Slot of the Shelf Slot 2
			if(caseType == 10){
				//System.out.println("Stack 2");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(2)==null){
						tileEnt.setInventorySlotContents(2, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
						//System.out.println("Stack 1 Statement 1 completed");
					}
					if (tileEnt.getStackInSlot(2)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(2).stackSize<=63){
							ItemStack pStack = player.inventory.getCurrentItem().copy();
							ItemStack sStack = tileEnt.getStackInSlot(2).copy();
							ItemStack sStackTemp = tileEnt.getStackInSlot(2).copy();

							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(2, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(2)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(2));
						tileEnt.setInventorySlotContents(2, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(2).getItem()) )){
						if(tileEnt.getStackInSlot(2)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(2).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(2, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}

			//Bottom Right Slot of the Shelf Slot 3
			if(caseType == 11){
				//System.out.println("Stack 2");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(3)==null){
						tileEnt.setInventorySlotContents(3, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
						//System.out.println("Stack 1 Statement 1 completed");
					}
					if (tileEnt.getStackInSlot(3)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(3).stackSize<=63){
							ItemStack pStack = player.inventory.getCurrentItem().copy();
							ItemStack sStack = tileEnt.getStackInSlot(3).copy();
							ItemStack sStackTemp = tileEnt.getStackInSlot(3).copy();

							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(3, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(3)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(3));
						tileEnt.setInventorySlotContents(3, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(3).getItem()) )){
						if(tileEnt.getStackInSlot(3)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(3).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(3, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}



			//META 3





			if(caseType == 12){
				//System.out.println("Meta 1 Slot 0");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(0)==null){
						tileEnt.setInventorySlotContents(0, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					}
					if (tileEnt.getStackInSlot(0)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(0).stackSize<=63){
							ItemStack pStack = player.inventory.getCurrentItem().copy();
							ItemStack sStack = tileEnt.getStackInSlot(0).copy();
							ItemStack sStackTemp = tileEnt.getStackInSlot(0).copy();

							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(0, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(0)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(0));
						tileEnt.setInventorySlotContents(0, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(0).getItem()) )){
						if(tileEnt.getStackInSlot(0)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(0).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(0, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}
			//Top Right Slot of the Shelf Slot 1
			if(caseType == 13){
				//System.out.println("Stack 1");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(1)==null){
						tileEnt.setInventorySlotContents(1, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
						//System.out.println("Stack 1 Statement 1 completed");
					}
					if (tileEnt.getStackInSlot(1)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(1).stackSize<=63){
							ItemStack pStack = player.inventory.getCurrentItem().copy();
							ItemStack sStack = tileEnt.getStackInSlot(1).copy();
							ItemStack sStackTemp = tileEnt.getStackInSlot(1).copy();

							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(1, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(1)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(1));
						tileEnt.setInventorySlotContents(1, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(1).getItem()) )){
						if(tileEnt.getStackInSlot(1)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(1).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(1, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}
			//Bottom Left Slot of the Shelf Slot 2
			if(caseType == 14){
				//System.out.println("Stack 2");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(2)==null){
						tileEnt.setInventorySlotContents(2, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
						//System.out.println("Stack 1 Statement 1 completed");
					}
					if (tileEnt.getStackInSlot(2)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(2).stackSize<=63){
							ItemStack pStack = player.inventory.getCurrentItem().copy();
							ItemStack sStack = tileEnt.getStackInSlot(2).copy();
							ItemStack sStackTemp = tileEnt.getStackInSlot(2).copy();

							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(2, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(2)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(2));
						tileEnt.setInventorySlotContents(2, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(2).getItem()) )){
						if(tileEnt.getStackInSlot(2)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(2).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(2, 1);
						}
					}
					return true;
				}
				//tileEnt.markDirty();
			}

			//Bottom Right Slot of the Shelf Slot 3
			if(caseType == 15){
				//System.out.println("Stack 2");
				if(player.inventory.getCurrentItem()!=null){
					if (tileEnt.getStackInSlot(3)==null){
						tileEnt.setInventorySlotContents(3, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
						//System.out.println("Stack 1 Statement 1 completed");
					}
					if (tileEnt.getStackInSlot(3)!=null){
						if(player.inventory.getCurrentItem()!=null){
							if(tileEnt.getStackInSlot(3).stackSize<=63){
							ItemStack pStack = player.inventory.getCurrentItem().copy();
							ItemStack sStack = tileEnt.getStackInSlot(3).copy();
							ItemStack sStackTemp = tileEnt.getStackInSlot(3).copy();

							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(3, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
						}
					}
					return true;
				}
				if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
					if(tileEnt.getStackInSlot(3)!=null){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(3));
						tileEnt.setInventorySlotContents(3, null);
					}
					return true;
				}
				if (!player.isSneaking()) {
					if((player.inventory.getCurrentItem()==null) || (player.inventory.getCurrentItem().getItem().equals(tileEnt.getStackInSlot(3).getItem()) )){
						if(tileEnt.getStackInSlot(3)!=null){
							ItemStack pStack = tileEnt.getStackInSlot(3).copy();
							pStack.stackSize = 1;
							world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
							tileEnt.decrStackSize(3, 1);
						}
					}
					return true;
				}
			}
		}
		tileEnt.markForUpdate();
		tileEnt.markDirty();
		return true;
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityShelfFour tileEnt = (TileEntityShelfFour) world.getTileEntity(x, y, z);

		if (tileEnt != null) {
			for (int i = 0; i < tileEnt.getSizeInventory(); ++i) {
				ItemStack itemstack = tileEnt.getStackInSlot(i);

				if (itemstack != null) {
					float f = this.random.nextFloat() * 0.6F + 0.1F;
					float f1 = this.random.nextFloat() * 0.6F + 0.1F;
					float f2 = this.random.nextFloat() * 0.6F + 0.1F;

					while (itemstack.stackSize > 0) {
						int j = this.random.nextInt(21) + 10;

						if (j > itemstack.stackSize) {
							j = itemstack.stackSize;
						}

						itemstack.stackSize -= j;
						EntityItem entityitem = new EntityItem(world, x + f, y + f1, z + f2, new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
						}

						float f3 = 0.025F;
						entityitem.motionX = (float) this.random.nextGaussian() * f3;
						entityitem.motionY = (float) this.random.nextGaussian() * f3 + 0.1F;
						entityitem.motionZ = (float) this.random.nextGaussian() * f3;
						world.spawnEntityInWorld(entityitem);
					}
				}
			}
			world.func_147453_f(x, y, z, block);
		}

		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {

		return new TileEntityShelfFour();
	}

	@Override
	public int getRenderType() {
		return RenderId.shelfFourID;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack p_149689_6_) {
		//int dir = ; 

		if(!world.isRemote){
			world.setBlockMetadataWithNotify(x, y, z, (MathHelper.floor_double((player.rotationYaw * 4F) / 360F + 0.5D) & 3), 2);
			
		}
		world.markBlockForUpdate(x, y, z);

		//System.out.println((MathHelper.floor_double((player.rotationYaw * 4F) / 360F + 0.5D) & 3));
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_)
	{
		this.setBlockBoundsBasedOnState(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
		return super.getSelectedBoundingBoxFromPool(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
	{
		this.getDir(p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_));
	}

	public void getDir(int dir)
	{

		if (dir == 0)
		{ //minX minY minZ, maxX, maxY, maxZ
			this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 0.5F);
		}

		if (dir == 1)
		{
			this.setBlockBounds(0.5F, 0F, 0F, 1F, 1F, 1F);
		}

		if (dir == 2)
		{
			this.setBlockBounds(0F, 0F, 0.5F, 1F, 1F, 1F);
			//this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

		if (dir == 3)
		{
			this.setBlockBounds(0F, 0F, 0F, 0.5F, 1F, 1F);
			//this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

	}
}
