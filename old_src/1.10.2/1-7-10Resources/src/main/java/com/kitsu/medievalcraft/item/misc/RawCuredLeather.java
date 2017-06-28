package com.kitsu.medievalcraft.item.misc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.packethandle.curedLeather.MsgPacketCuredLeatherX;
import com.kitsu.medievalcraft.packethandle.curedLeather.MsgPacketCuredLeatherY;
import com.kitsu.medievalcraft.packethandle.curedLeather.MsgPacketCuredLeatherZ;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;

public class RawCuredLeather extends Item {

	private String name = "rawCuredLeather";
	private boolean setWater;
	private int x, y, z;
	public static int serverX, serverY, serverZ;

	public RawCuredLeather () {

		super();
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name).setMaxStackSize(1);
		GameRegistry.registerItem(this, name);

	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		//stack.stackTagCompound = new NBTTagCompound();
		if(world.isRemote) {

			//System.out.println(player.rayTrace(3.0F, 1.0F).blockX);
			//System.out.println(player.rayTrace(3.0F, 1.0F).sideHit);
			//System.out.println(Minecraft.getMinecraft().objectMouseOver.typeOfHit);
			//System.out.println(Minecraft.getMinecraft().objectMouseOver.sideHit);

			if(player.rayTrace(3.0F, 1.0F).typeOfHit.BLOCK.equals(player.rayTrace(3.0F, 1.0F).typeOfHit.BLOCK)){
				//System.out.println(Minecraft.getMinecraft().objectMouseOver.sideHit);

				if(player.rayTrace(3.0F, 1.0F).sideHit==1){
					x = player.rayTrace(3.0F, 1.0F).blockX;
					y = player.rayTrace(3.0F, 1.0F).blockY+1;
					z = player.rayTrace(3.0F, 1.0F).blockZ;
					Main.sNet.sendToServer(new MsgPacketCuredLeatherX(x));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherY(y));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherZ(z));

				}
				if(player.rayTrace(3.0F, 1.0F).sideHit==2){
					x = player.rayTrace(3.0F, 1.0F).blockX;
					y = player.rayTrace(3.0F, 1.0F).blockY;
					z = player.rayTrace(3.0F, 1.0F).blockZ-1;
					Main.sNet.sendToServer(new MsgPacketCuredLeatherX(x));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherY(y));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherZ(z));

				}
				if(player.rayTrace(3.0F, 1.0F).sideHit==3){
					x = player.rayTrace(3.0F, 1.0F).blockX;
					y = player.rayTrace(3.0F, 1.0F).blockY;
					z = player.rayTrace(3.0F, 1.0F).blockZ+1;
					Main.sNet.sendToServer(new MsgPacketCuredLeatherX(x));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherY(y));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherZ(z));

				}
				if(player.rayTrace(3.0F, 1.0F).sideHit==4){
					x = player.rayTrace(3.0F, 1.0F).blockX-1;
					y = player.rayTrace(3.0F, 1.0F).blockY;
					z = player.rayTrace(3.0F, 1.0F).blockZ;
					Main.sNet.sendToServer(new MsgPacketCuredLeatherX(x));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherY(y));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherZ(z));

				}
				if(player.rayTrace(3.0F, 1.0F).sideHit==5){
					x = player.rayTrace(3.0F, 1.0F).blockX+1;
					y = player.rayTrace(3.0F, 1.0F).blockY;
					z = player.rayTrace(3.0F, 1.0F).blockZ;
					Main.sNet.sendToServer(new MsgPacketCuredLeatherX(x));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherY(y));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherZ(z));

				}
				if(player.rayTrace(3.0F, 1.0F).sideHit==0){
					x = player.rayTrace(3.0F, 1.0F).blockX;
					y = player.rayTrace(3.0F, 1.0F).blockY-1;
					z = player.rayTrace(3.0F, 1.0F).blockZ;
//Main.sNet.sendToAll(new MsgPacketLocZ(z));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherX(x));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherY(y));
					Main.sNet.sendToServer(new MsgPacketCuredLeatherZ(z));
				}

			}
			//stack.stackTagCompound = new NBTTagCompound();
			//stack.stackTagCompound.setInteger("X", x);
			//stack.stackTagCompound.setInteger("Y", y);
			//stack.stackTagCompound.setInteger("Z", z);

			//System.out.println(stack.stackTagCompound.getInteger("X"));
			//System.out.println(stack.stackTagCompound.getInteger("Y"));
			//System.out.println(stack.stackTagCompound.getInteger("Z"));
		}
		if(!world.isRemote){
			//System.out.println(serverX + ":" + serverY + ":" + serverZ);
			if(world.getBlock(serverX, serverY, serverZ).equals(ModBlocks.blockFilteredWater)){
				world.setBlock(serverX, serverY, serverZ, Blocks.water, 0, 2);
				player.inventory.decrStackSize(player.inventory.currentItem, 1);
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.soakedLeather, 1));
				player.inventoryContainer.detectAndSendChanges();
			}
		}

		//System.out.println(stack.stackTagCompound.getBoolean("WATER"));
		if(world.isRemote){
			if(world.getBlock(serverX, serverY, serverZ).equals(ModBlocks.blockFilteredWater)){
				//player.inventory.decrStackSize(player.inventory.currentItem, 1);
				//player.inventory.addItemStackToInventory(new ItemStack(ModItems.soakedLeather, 1));
			}
		}



		return super.onItemRightClick(stack, world, player); 
	}

	private void setToWater(World world, int x, int y, int z, EntityPlayer player){
		world.setBlock(x, y, z, Blocks.water, 0, 2);

	}

}


