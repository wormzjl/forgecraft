package com.kitsu.medievalcraft.item.craftingtools;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.tileents.ingots.TileEntityMyDiamond;
import com.kitsu.medievalcraft.tileents.ingots.TileEntityMyEmerald;
import com.kitsu.medievalcraft.tileents.ingots.TileLapisIngot;
import com.kitsu.medievalcraft.tileents.ingots.TileRedstoneIngot;
import com.kitsu.medievalcraft.tileents.machine.TileEntityAnvilForge;
import com.kitsu.medievalcraft.util.CustomTab;
import com.kitsu.medievalcraft.util.InlayTables;

import cpw.mods.fml.common.registry.GameRegistry;

public class InlayHammer extends Item implements InlayTables{

	private String name = "inlayHammer";
	//private Item item;
	//private Block test;
	private int keyUpgrade, keyCheck, keyCheckOne, hit;
	public static boolean forgeHammerLeftClick;
	TileEntityMyDiamond tileDiamond;
	TileEntityMyEmerald tileEmerald;
	TileRedstoneIngot tileRedstone;
	TileLapisIngot tileLapis;
	//TileEntityHotIronPlate tilePlate;
	Random rand;

	public InlayHammer() {

		setMaxStackSize(1);
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		setMaxDamage(500);
		setNoRepair();

		//item = this;
		GameRegistry.registerItem(this, name);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_){

		Block block = world.getBlock(x, y, z);
		Block anvil = world.getBlock(x, y-1, z);
		if(!world.isRemote){
			onClick(block, anvil, world, x, y, z, player, stack, world.rand);
		}

		return true;
	}
	/*
	 * ItemStack gladius0 = new ItemStack(ModItems.gladius);
		gladius0.stackTagCompound = new NBTTagCompound();
		gladius0.stackTagCompound.setInteger("GLADIUSTEXTURE", 0);*/

	private void onClick(Block block, Block blockSub, World world, int x, int y, int z, EntityPlayer player, ItemStack stack, Random rand){
		if(block == ModBlocks.myDiamond){
			tileDiamond = (TileEntityMyDiamond) world.getTileEntity(x, y, z);
		}
		if(block == ModBlocks.myEmerald){
			tileEmerald = (TileEntityMyEmerald) world.getTileEntity(x, y, z);
		}
		if(block == ModBlocks.redstoneIngot){
			tileRedstone = (TileRedstoneIngot) world.getTileEntity(x, y, z);
		}
		if(block == ModBlocks.lapisIngot){
			tileLapis = (TileLapisIngot) world.getTileEntity(x, y, z);
		}

		if((block == blockToRun(block))
				&& (blockSub == ModBlocks.forgeAnvil)
				&& (player.isSwingInProgress == false)){
			TileEntityAnvilForge tileAnvil = (TileEntityAnvilForge) world.getTileEntity(x, y-1, z);
			//DIAMOND BLOCK
			if(keyUpgrade == 0){

				if(tileAnvil.getStackInSlot(0) != null){

					player.worldObj.playSoundAtEntity(player, Main.MODID + ":anvilhammer", 1.0F, 2.25F);

					if(tileAnvil.getStackInSlot(0).getItem().equals(ModItems.woodentoolHandle)){
						if (rand.nextInt(2) == 0 ) {
							tileDiamond.hits++;
						}
						if(tileDiamond.hits >= 8){
							tileDiamond.hits=0;
							ItemStack resetStack = new ItemStack(ModItems.unbreakingWoodRod);
							tileAnvil.setInventorySlotContents(0, resetStack);
							world.setBlock(x, y, z, Blocks.air, 0, 2);
							stack.damageItem(1, player);
						}
					}

					if(tileAnvil.getStackInSlot(0).isItemEqual(new ItemStack(oneUpgradeCheck(tileAnvil.getStackInSlot(0).getItem())))){
						if(keyCheckOne == 0){
							if (rand.nextInt(2) == 0 ) {
								tileDiamond.hits++;
							}
							if(tileDiamond.hits >= 8){
								tileDiamond.hits=0;
								if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("unbreaking")){
									Item reset = InlayTables.twoUpgrade.get(keyCheckOne);
									ItemStack resetStack = new ItemStack(reset);
									resetStack.stackTagCompound = new NBTTagCompound();
									tileAnvil.setInventorySlotContents(0, resetStack);
									world.setBlock(x, y, z, Blocks.air, 0, 2);
									stack.damageItem(1, player);
								}
							}
						}

						if(keyCheckOne == 1){
							if (rand.nextInt(2) == 0 ) {
								tileDiamond.hits++;
							}
							if(tileDiamond.hits >= 8){
								tileDiamond.hits = 0;
								if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("unbreaking")){
									Item reset = InlayTables.twoUpgrade.get(keyCheckOne);
									ItemStack resetStack = new ItemStack(reset);
									resetStack.stackTagCompound = new NBTTagCompound();
									tileAnvil.setInventorySlotContents(0, resetStack);
									world.setBlock(x, y, z, Blocks.air, 0, 2);
									stack.damageItem(1, player);
								}
							}
						}

						if(keyCheckOne == 2){
							if (rand.nextInt(2) == 0 ) {
								tileDiamond.hits++;
							}
							if(tileDiamond.hits >= 8){
								tileDiamond.hits=0;
								if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("unbreaking")){
									Item reset = InlayTables.twoUpgrade.get(keyCheckOne);
									ItemStack resetStack = new ItemStack(reset);
									resetStack.stackTagCompound = new NBTTagCompound();
									tileAnvil.setInventorySlotContents(0, resetStack);
									world.setBlock(x, y, z, Blocks.air, 0, 2);
									stack.damageItem(1, player);
								}
							}
						}

						if(keyCheckOne == 3){
							if (rand.nextInt(2) == 0 ) {
								tileDiamond.hits++;
							}
							if(tileDiamond.hits >= 8){
								tileDiamond.hits=0;
								if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("effic")){
									Item reset = InlayTables.multiUpgrade.get(keyCheckOne-3);
									ItemStack resetStack = new ItemStack(reset);
									resetStack.stackTagCompound = new NBTTagCompound();
									tileAnvil.setInventorySlotContents(0, resetStack);
									world.setBlock(x, y, z, Blocks.air, 0, 2);
									stack.damageItem(1, player);
								}
							}
						}

						if(keyCheckOne == 4){
							if (rand.nextInt(2) == 0 ) {
								tileDiamond.hits++;
							}
							if(tileDiamond.hits >= 8){
								tileDiamond.hits=0;
								if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("effic")){
									Item reset = InlayTables.multiUpgrade.get(keyCheckOne-3);
									ItemStack resetStack = new ItemStack(reset);
									resetStack.stackTagCompound = new NBTTagCompound();
									tileAnvil.setInventorySlotContents(0, resetStack);
									world.setBlock(x, y, z, Blocks.air, 0, 2);
									stack.damageItem(1, player);
								}
							}
						}

						if(keyCheckOne == 5){
							if (rand.nextInt(2) == 0 ) {
								tileDiamond.hits++;
							}
							if(tileDiamond.hits >= 8){
								tileDiamond.hits = 0;

								if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("effic")){
									Item reset = InlayTables.multiUpgrade.get(keyCheckOne-3);
									ItemStack resetStack = new ItemStack(reset);
									resetStack.stackTagCompound = new NBTTagCompound();
									tileAnvil.setInventorySlotContents(0, resetStack);
									world.setBlock(x, y, z, Blocks.air, 0, 2);
									stack.damageItem(1, player);
								}
							}
						}

						if(keyCheckOne == 6){
							if (rand.nextInt(2) == 0 ) {
								tileDiamond.hits++;
							}
							if(tileDiamond.hits >= 8){
								tileDiamond.hits=0;

								if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("fortune")){
									Item reset = InlayTables.multiUpgrade.get(keyCheckOne);
									ItemStack resetStack = new ItemStack(reset);
									resetStack.stackTagCompound = new NBTTagCompound();
									tileAnvil.setInventorySlotContents(0, resetStack);
									world.setBlock(x, y, z, Blocks.air, 0, 2);
									stack.damageItem(1, player);
								}
							}
						}

						if(keyCheckOne == 7){
							if (rand.nextInt(2) == 0 ) {
								tileDiamond.hits++;
							}
							if(tileDiamond.hits >= 8){
								tileDiamond.hits=0;

								if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("fortune")){
									Item reset = InlayTables.multiUpgrade.get(keyCheckOne);
									ItemStack resetStack = new ItemStack(reset);
									resetStack.stackTagCompound = new NBTTagCompound();
									tileAnvil.setInventorySlotContents(0, resetStack);
									world.setBlock(x, y, z, Blocks.air, 0, 2);
									stack.damageItem(1, player);
								}
							}
						}

						if(keyCheckOne == 8){
							if (rand.nextInt(2) == 0 ) {
								tileDiamond.hits++;
							}
							if(tileDiamond.hits >= 8){
								tileDiamond.hits=0;

								if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("fortune")){
									Item reset = InlayTables.multiUpgrade.get(keyCheckOne);
									ItemStack resetStack = new ItemStack(reset);
									resetStack.stackTagCompound = new NBTTagCompound();
									tileAnvil.setInventorySlotContents(0, resetStack);
									world.setBlock(x, y, z, Blocks.air, 0, 2);
									stack.damageItem(1, player);
								}
							}
						}

					}
					if (rand.nextInt(2) == 0 ) {
						tileDiamond.hits++;
					}
					if(tileDiamond.hits >= 8){
						tileDiamond.hits=0;
						//CHECKS IF ITS A ZERO UPGRADED TOOL HEAD AND RETURNS THE LVL 1 UNBREAKING VARIANT
						if(tileAnvil.getStackInSlot(0).isItemEqual(new ItemStack(zeroUpgradeCheck(tileAnvil.getStackInSlot(0).getItem())))){
							Item reset = InlayTables.oneUpgrade.get(keyCheck);
							ItemStack resetStack = new ItemStack(reset);
							resetStack.stackTagCompound = new NBTTagCompound();
							resetStack.stackTagCompound.setInteger("UPGRADES", 1);
							resetStack.stackTagCompound.setString("ENCHANTTYPE", "unbreaking");
							tileAnvil.setInventorySlotContents(0, resetStack);
							world.setBlock(x, y, z, Blocks.air, 0, 2);
							stack.damageItem(1, player);
						}
					}
				}
			}

			if(keyUpgrade == 1){
				if(tileAnvil.getStackInSlot(0) != null){
					player.worldObj.playSoundAtEntity(player, Main.MODID + ":anvilhammer", 1.0F, 2.25F);
					if (rand.nextInt(2) == 0 ) {
						tileEmerald.hits++;
					}
					if(tileEmerald.hits >= 8){
						tileEmerald.hits = 0;
						if(tileAnvil.getStackInSlot(0).isItemEqual(new ItemStack(zeroUpgradeCheck(tileAnvil.getStackInSlot(0).getItem())))){
							Item reset = InlayTables.silkTouch.get(keyCheck);
							ItemStack resetStack = new ItemStack(reset);
							resetStack.stackTagCompound = new NBTTagCompound();
							tileAnvil.setInventorySlotContents(0, resetStack);
							world.setBlock(x, y, z, Blocks.air, 0, 2);
							stack.damageItem(1, player);
						}
					}
				}
			}

			if(keyUpgrade == 2){
				if(tileAnvil.getStackInSlot(0) != null){
					if(tileLapis.hot==true){
						player.worldObj.playSoundAtEntity(player, Main.MODID + ":anvilhammer", 1.0F, 2.25F);
						if(tileAnvil.getStackInSlot(0).getItem().equals(ModItems.woodentoolHandle)){
							if (rand.nextInt(2) == 0 ) {
								tileLapis.hits++;
							}
							if(tileLapis.hits >= 8){
								tileLapis.hits=0;
								ItemStack resetStack = new ItemStack(ModItems.fortuneWoodRod);
								tileAnvil.setInventorySlotContents(0, resetStack);
								world.setBlock(x, y, z, Blocks.air, 0, 2);
								stack.damageItem(1, player);
							}
						}
						if(tileAnvil.getStackInSlot(0).getItem().equals(ModItems.ironweaponHandle)){
							if (rand.nextInt(2) == 0 ) {
								tileLapis.hits++;
							}
							if(tileLapis.hits >= 8){
								tileLapis.hits=0;
								ItemStack resetStack = new ItemStack(ModItems.fortuneIronRod);
								tileAnvil.setInventorySlotContents(0, resetStack);
								world.setBlock(x, y, z, Blocks.air, 0, 2);
								stack.damageItem(1, player);
							}
						}

						if(tileAnvil.getStackInSlot(0).isItemEqual(new ItemStack(oneUpgradeCheck(tileAnvil.getStackInSlot(0).getItem())))){
							//System.out.println("Lvl 1 second upgrade");
							//System.out.println(keyCheckOne);
							//System.out.println(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE"));
							//ItemStack tempStack = tileAnvil.getStackInSlot(0);
							//keyCHeckone is oneUpgrade check
							if(keyCheckOne == 0){
								if (rand.nextInt(2) == 0 ) {
									tileLapis.hits++;
								}
								if(tileLapis.hits >= 8){
									tileLapis.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("unbreaking")){
										Item reset = InlayTables.multiUpgrade.get(keyCheckOne+6);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 1){
								if (rand.nextInt(2) == 0 ) {
									tileLapis.hits++;
								}
								if(tileLapis.hits >= 8){
									tileLapis.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("unbreaking")){
										Item reset = InlayTables.multiUpgrade.get(keyCheckOne+6);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 2){
								if (rand.nextInt(2) == 0 ) {
									tileLapis.hits++;
								}
								if(tileLapis.hits >= 8){
									tileLapis.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("unbreaking")){
										Item reset = InlayTables.multiUpgrade.get(keyCheckOne+6);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 3){
								if (rand.nextInt(2) == 0 ) {
									tileLapis.hits++;
								}
								if(tileLapis.hits >= 8){
									tileLapis.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("effic")){
										Item reset = InlayTables.multiUpgrade.get(keyCheckOne);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 4){
								if (rand.nextInt(2) == 0 ) {
									tileLapis.hits++;
								}
								if(tileLapis.hits >= 8){
									tileLapis.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("effic")){
										Item reset = InlayTables.multiUpgrade.get(keyCheckOne);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 5){
								if (rand.nextInt(2) == 0 ) {
									tileLapis.hits++;
								}
								if(tileLapis.hits >= 8){
									tileLapis.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("effic")){
										Item reset = InlayTables.multiUpgrade.get(keyCheckOne);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 6){
								if (rand.nextInt(2) == 0 ) {
									tileLapis.hits++;
								}
								if(tileLapis.hits >= 8){
									tileLapis.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("fortune")){
										Item reset = InlayTables.twoUpgrade.get(keyCheckOne);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 7){
								if (rand.nextInt(2) == 0 ) {
									tileLapis.hits++;
								}
								if(tileLapis.hits >= 8){
									tileLapis.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("fortune")){
										Item reset = InlayTables.twoUpgrade.get(keyCheckOne);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 8){
								if (rand.nextInt(2) == 0 ) {
									tileLapis.hits++;
								}
								if(tileLapis.hits >= 8){
									tileLapis.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("fortune")){
										Item reset = InlayTables.twoUpgrade.get(keyCheckOne);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}
						}

						if(tileAnvil.getStackInSlot(0).isItemEqual(new ItemStack(zeroUpgradeCheck(tileAnvil.getStackInSlot(0).getItem())))){
							if (rand.nextInt(2) == 0 ) {
								tileLapis.hits++;
							}
							if(tileLapis.hits >= 8){
								tileLapis.hits=0;
								Item reset = InlayTables.oneUpgrade.get(keyCheck+6);
								ItemStack resetStack = new ItemStack(reset);
								resetStack.stackTagCompound = new NBTTagCompound();
								resetStack.stackTagCompound.setInteger("UPGRADES", 1);
								resetStack.stackTagCompound.setString("ENCHANTTYPE", "fortune");
								tileAnvil.setInventorySlotContents(0, resetStack);
								world.setBlock(x, y, z, Blocks.air, 0, 2);
								stack.damageItem(1, player);
								//System.out.println(resetStack.stackTagCompound.getString("ENCHANTTYPE"));
							}
						}
					}
				}
			}
			if(keyUpgrade == 3){
				if(tileAnvil.getStackInSlot(0) != null){
					if(tileRedstone.hot==true){
						player.worldObj.playSoundAtEntity(player, Main.MODID + ":anvilhammer", 1.0F, 2.25F);

						if(tileAnvil.getStackInSlot(0).getItem().equals(ModItems.ironweaponHandle)){
							if (rand.nextInt(2) == 0 ) {
								tileRedstone.hits++;
							}
							if(tileRedstone.hits >= 8){
								tileRedstone.hits=0;
								ItemStack resetStack = new ItemStack(ModItems.efficIronRod);
								tileAnvil.setInventorySlotContents(0, resetStack);
								world.setBlock(x, y, z, Blocks.air, 0, 2);
								stack.damageItem(1, player);
							}
						}

						if(tileAnvil.getStackInSlot(0).isItemEqual(new ItemStack(oneUpgradeCheck(tileAnvil.getStackInSlot(0).getItem())))){
							//System.out.println("Lvl 1 second upgrade");
							//System.out.println(keyCheckOne);
							//System.out.println(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE"));
							//ItemStack tempStack = tileAnvil.getStackInSlot(0);
							//keyCHeckone is oneUpgrade check
							if(keyCheckOne == 0){
								if (rand.nextInt(2) == 0 ) {
									tileRedstone.hits++;
								}
								if(tileRedstone.hits >= 8){
									tileRedstone.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("unbreaking")){
										Item reset = InlayTables.multiUpgrade.get(keyCheckOne);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 1){
								if (rand.nextInt(2) == 0 ) {
									tileRedstone.hits++;
								}
								if(tileRedstone.hits >= 8){
									tileRedstone.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("unbreaking")){
										Item reset = InlayTables.multiUpgrade.get(keyCheckOne);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 2){
								if (rand.nextInt(2) == 0 ) {
									tileRedstone.hits++;
								}
								if(tileRedstone.hits >= 8){
									tileRedstone.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("unbreaking")){
										Item reset = InlayTables.multiUpgrade.get(keyCheckOne);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 3){
								if (rand.nextInt(2) == 0 ) {
									tileRedstone.hits++;
								}
								if(tileRedstone.hits >= 8){
									tileRedstone.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("effic")){
										Item reset = InlayTables.twoUpgrade.get(keyCheckOne);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 4){
								if (rand.nextInt(2) == 0 ) {
									tileRedstone.hits++;
								}
								if(tileRedstone.hits >= 8){
									tileRedstone.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("effic")){
										Item reset = InlayTables.twoUpgrade.get(keyCheckOne);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 5){
								if (rand.nextInt(2) == 0 ) {
									tileRedstone.hits++;
								}
								if(tileRedstone.hits >= 8){
									tileRedstone.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("effic")){
										Item reset = InlayTables.twoUpgrade.get(keyCheckOne);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 6){
								if (rand.nextInt(2) == 0 ) {
									tileRedstone.hits++;
								}
								if(tileRedstone.hits >= 8){
									tileRedstone.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("fortune")){
										Item reset = InlayTables.multiUpgrade.get(keyCheckOne-3);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 7){
								if (rand.nextInt(2) == 0 ) {
									tileRedstone.hits++;
								}
								if(tileRedstone.hits >= 8){
									tileRedstone.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("fortune")){
										Item reset = InlayTables.multiUpgrade.get(keyCheckOne-3);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

							if(keyCheckOne == 8){
								if (rand.nextInt(2) == 0 ) {
									tileRedstone.hits++;
								}
								if(tileRedstone.hits >= 8){
									tileRedstone.hits=0;
									if(tileAnvil.getStackInSlot(0).stackTagCompound.getString("ENCHANTTYPE").equals("fortune")){
										Item reset = InlayTables.multiUpgrade.get(keyCheckOne-3);
										ItemStack resetStack = new ItemStack(reset);
										resetStack.stackTagCompound = new NBTTagCompound();
										tileAnvil.setInventorySlotContents(0, resetStack);
										world.setBlock(x, y, z, Blocks.air, 0, 2);
										stack.damageItem(1, player);
									}
								}
							}

						}

						if(tileAnvil.getStackInSlot(0).isItemEqual(new ItemStack(zeroUpgradeCheck(tileAnvil.getStackInSlot(0).getItem())))){
							if (rand.nextInt(2) == 0 ) {
								tileRedstone.hits++;
							}
							if(tileRedstone.hits >= 8){
								tileRedstone.hits=0;
								Item reset = InlayTables.oneUpgrade.get(keyCheck+3);
								ItemStack resetStack = new ItemStack(reset);
								resetStack.stackTagCompound = new NBTTagCompound();
								resetStack.stackTagCompound.setInteger("UPGRADES", 1);
								resetStack.stackTagCompound.setString("ENCHANTTYPE", "effic");
								tileAnvil.setInventorySlotContents(0, resetStack);
								world.setBlock(x, y, z, Blocks.air, 0, 2);
								stack.damageItem(1, player);
								//System.out.println(resetStack.stackTagCompound.getString("ENCHANTTYPE"));
							}
						}
					}
				}
			}
		}
	}

	private Block blockToRun(Block testBlock){
		for(int i = 0; i < InlayTables.upgrade.size(); i++){
			if(testBlock == InlayTables.upgrade.get(i)){
				keyUpgrade = i;
			}
		}
		return InlayTables.upgrade.get(keyUpgrade);
	}

	private Item zeroUpgradeCheck(Item testItem){
		for(int i = 0; i < InlayTables.zeroUpgrade.size(); i++){
			if(testItem == InlayTables.zeroUpgrade.get(i)){
				keyCheck = i;
			}
		}
		return InlayTables.zeroUpgrade.get(keyCheck);
	}

	private Item oneUpgradeCheck(Item testItem){
		for(int i = 0; i < InlayTables.oneUpgrade.size(); i++){
			if(testItem == InlayTables.oneUpgrade.get(i)){
				keyCheckOne = i;
			}
		}
		return InlayTables.oneUpgrade.get(keyCheckOne);
	}


}




