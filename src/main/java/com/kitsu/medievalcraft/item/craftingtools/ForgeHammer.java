package com.kitsu.medievalcraft.item.craftingtools;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.block.ingots.IngotBase;
import com.kitsu.medievalcraft.crafting.ForgeAnvilCrafting;
import com.kitsu.medievalcraft.crafting.TestForgeCrafting;
import com.kitsu.medievalcraft.item.forms.clay.ClayForms;
import com.kitsu.medievalcraft.item.forms.iron.IronForms;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgPacket;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgPacketLocX;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgPacketLocY;
import com.kitsu.medievalcraft.packethandle.forgeHammerParticles.MsgPacketLocZ;
import com.kitsu.medievalcraft.tileents.ingots.TileIngotBase;
import com.kitsu.medievalcraft.tileents.ingots.TileIronPlate;
import com.kitsu.medievalcraft.tileents.ingots.TileMyIronIngot;
import com.kitsu.medievalcraft.tileents.machine.TileEntityAnvilForge;
import com.kitsu.medievalcraft.util.CustomTab;
import com.kitsu.medievalcraft.util.IronFormNames;

import cpw.mods.fml.common.registry.GameRegistry;


public class ForgeHammer extends Item implements IronFormNames{

	private String name = "forgeHammer";
	private Item item;
	//private Block test;
	private int hit, key, blockKey, keys;
	public static boolean forgeHammerLeftClick;
	TileMyIronIngot tileRefIngot;
	TileIronPlate tilePlate;
	Random rand;

	public ForgeHammer() {

		setMaxStackSize(1);
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		setMaxDamage(500);
		setNoRepair();

		item = this;
		GameRegistry.registerItem(this, name);
	}

	private Block blockToRun(Block block) {

		if(block == TestForgeCrafting.blockToCook.get(0)){
			blockKey = 0;
			return TestForgeCrafting.blockToCook.get(0);
		} else
			if(block == TestForgeCrafting.blockToCook.get(3)){
				blockKey = 3;
				return TestForgeCrafting.blockToCook.get(3);
			} else
				if(block == TestForgeCrafting.blockToCook.get(6)){
					blockKey = 6;
					return TestForgeCrafting.blockToCook.get(6);
				} else return block = Blocks.air;
	}

	private void onClick(Block block, Block blockSub, World world, int x, int y, int z, EntityPlayer p, ItemStack stack, Random rand){

		if(block == ModBlocks.refinedIron){
			tileRefIngot = (TileMyIronIngot) world.getTileEntity(x, y, z);
		}
		if(block == ModBlocks.ironPlate){
			tilePlate = (TileIronPlate) world.getTileEntity(x, y, z);
		}

		if((block instanceof IngotBase)&&(blockSub == ModBlocks.forgeAnvil) && (p.isSwingInProgress == false)&&(block!=ModBlocks.ironPlate)){
			TileEntityAnvilForge tileEnt = (TileEntityAnvilForge) world.getTileEntity(x, y-1, z);
			TileIngotBase tile = (TileIngotBase) world.getTileEntity(x, y, z);
			if((tileEnt.getStackInSlot(0).getItem() instanceof IronForms)&&(tile.hot==true)){
				p.worldObj.playSoundAtEntity(p, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
				Main.sNet.sendToAll(new MsgPacket(true));
				Main.sNet.sendToAll(new MsgPacketLocX(x));
				Main.sNet.sendToAll(new MsgPacketLocY(y));
				Main.sNet.sendToAll(new MsgPacketLocZ(z));
				tile.hits++;
				if(tile.hits >= 3 + rand.nextInt(3)){
					world.spawnEntityInWorld(new EntityItem(world, x+0.5D, y+0.6D, z+0.5D, forms.get(tileEnt.getStackInSlot(0).getItem())));
					stack.damageItem(1, p);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					if(tileEnt.getStackInSlot(0).getMaxStackSize() == 1){
						if(tileEnt.getStackInSlot(0).getItemDamage() == tileEnt.getStackInSlot(0).getMaxDamage()-1){
							tileEnt.decrStackSize(0, 1);
						}
						else {tileEnt.getStackInSlot(0).setItemDamage(tileEnt.getStackInSlot(0).getItemDamage()+1);
						}
					}
				}
			}
			if((tileEnt.getStackInSlot(0).getItem() instanceof ClayForms)&&(tile.hot==true)&&(block!=ModBlocks.ironPlate)){
				p.worldObj.playSoundAtEntity(p, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
				Main.sNet.sendToAll(new MsgPacket(true));
				Main.sNet.sendToAll(new MsgPacketLocX(x));
				Main.sNet.sendToAll(new MsgPacketLocY(y));
				Main.sNet.sendToAll(new MsgPacketLocZ(z));
				tile.hits++;
				if(tile.hits >= 3 + rand.nextInt(3)){
					world.spawnEntityInWorld(new EntityItem(world, x+0.5D, y+0.6D, z+0.5D, formsClay.get(tileEnt.getStackInSlot(0).getItem())));
					stack.damageItem(1, p);
					world.setBlock(x, y, z, Blocks.air, 0, 2);
					tileEnt.decrStackSize(0, 1);
					tile.markForUpdate();
					}
				}
			}
		
			



		/*if((block == blockToRun(block)) && (blockSub == ModBlocks.forgeAnvil) && (p.isSwingInProgress == false)){
			TileEntityAnvilForge tileEnt = (TileEntityAnvilForge) world.getTileEntity(x, y-1, z);

			if((tileEnt.getStackInSlot(0) == null) && (blockKey == 0)){
				if (rand.nextInt(2) == 0 ) {
					tileRefIngot.hits++;
				}
				p.worldObj.playSoundAtEntity(p, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
				Main.sNet.sendToAll(new MsgPacket(true));
				Main.sNet.sendToAll(new MsgPacketlTicks(x));
				Main.sNet.sendToAll(new MsgPacketLocY(y));
				Main.sNet.sendToAll(new MsgPacketLocZ(z));

				if(tileRefIngot.hits >= 4){
					tileRefIngot.hits = 0;
					p.worldObj.playSoundAtEntity(p, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
					Main.sNet.sendToAll(new MsgPacket(true));
					Main.sNet.sendToAll(new MsgPacketlTicks(x));
					Main.sNet.sendToAll(new MsgPacketLocY(y));
					Main.sNet.sendToAll(new MsgPacketLocZ(z));
					world.setBlock(x, y, z, ModBlocks.ironPlate, 0, 2);
					stack.damageItem(1, p);
				}
			}
			if((tileEnt.getStackInSlot(0) != null)){
				if((tileEnt.getStackInSlot(0).getItem() == Items.flower_pot) && (blockKey == 0)){
					if (rand.nextInt(2) == 0 ) {
						tileRefIngot.hits++;
					}
					p.worldObj.playSoundAtEntity(p, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
					Main.sNet.sendToAll(new MsgPacket(true));
					Main.sNet.sendToAll(new MsgPacketlTicks(x));
					Main.sNet.sendToAll(new MsgPacketLocY(y));
					Main.sNet.sendToAll(new MsgPacketLocZ(z));

					if(tileRefIngot.hits >= 4){key
						tileRefIngot.hits = 0;
						p.worldObj.playSoundAtEntity(p, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
						Main.sNet.sendToAll(new MsgPacket(true));
						Main.sNet.sendToAll(new MsgPacketlTicks(x));
						Main.sNet.sendToAll(new MsgPacketLocY(y));
						Main.sNet.sendToAll(new MsgPacketLocZ(z));
						world.setBlock(x, y, z, Blocks.air, 0, 2);
						tileEnt.decrStackSize(0, 1);
						ItemStack bucket = new ItemStack(Items.bucket);
						world.spawnEntityInWorld(new EntityItem(world, x+0.5D, y+0.6D, z+0.5D, bucket));
						stack.damageItem(1, p);
					}
				}
			}

			if(tileEnt.getStackInSlot(0) != null){
				Item checkItem = tileEnt.getStackInSlot(0).getItem();
				String displayName = tileEnt.getStackInSlot(0).getDisplayName();

				if(displayName.equals(getTool(tileEnt.getStackInSlot(0)))){
					if(tileEnt.getStackInSlot(0).isItemDamaged() == true){
						p.worldObj.playSoundAtEntity(p, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
						Main.sNet.sendToAll(new MsgPacket(true));
						Main.sNet.sendToAll(new MsgPacketlTicks(x));
						Main.sNet.sendToAll(new MsgPacketLocY(y));
						Main.sNet.sendToAll(new MsgPacketLocZ(z));
						stack.damageItem(1, p);
						if (rand.nextInt(2) == 0 ) {
							tileRefIngot.hits++;
						}
					}
					if(tileRefIngot.hits >= 4){
						tileRefIngot.hits=0;
						checkItem.setDamage(tileEnt.getStackInSlot(0), 0);
						world.setBlock(x, y, z, Blocks.air, 0, 2);
					}
				}

				if((blockKey == 3) && tileEnt.getStackInSlot(0).getItem().equals(ModItems.woodentoolHandle)){
					p.worldObj.playSoundAtEntity(p, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
					Main.sNet.sendToAll(new MsgPacket(true));
					Main.sNet.sendToAll(new MsgPacketlTicks(x));
					Main.sNet.sendToAll(new MsgPacketLocY(y));
					Main.sNet.sendToAll(new MsgPacketLocZ(z));

					if (rand.nextInt(2) == 0 ) {
						tilePlate.hits++;
					}
					if(tilePlate.hits >= 4){
						tilePlate.hits=0;
						tileEnt.decrStackSize(0, 1);
						world.setBlock(x, y, z, Blocks.air, 0, 2);
						ItemStack ironForm = new ItemStack(ModItems.ironHandleForm);
						world.spawnEntityInWorld(new EntityItem(world, x+0.5D, y+0.6D, z+0.5D, ironForm));
					}
				}

				if((checkItem == getItem(checkItem)) || (checkItem == getItem3(checkItem)) || (checkItem == getItem2(checkItem).getItem())){
					if (rand.nextInt(2) == 0 ) {
						if(blockKey == 0){
							tileRefIngot.hits++;
						}
						if(blockKey == 3){
							tilePlate.hits++;
						}
					}
					p.worldObj.playSoundAtEntity(p, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
					Main.sNet.sendToAll(new MsgPacket(true));
					Main.sNet.sendToAll(new MsgPacketlTicks(x));
					Main.sNet.sendToAll(new MsgPacketLocY(y));
					Main.sNet.sendToAll(new MsgPacketLocZ(z));

					if((blockKey == 0) && (checkItem == getItem(checkItem))){

						if(tileRefIngot.hits >= 4){
							tileRefIngot.hits=0;
							giveItem(key, world, x, y, z, p);
							stack.damageItem(1, p);
							if(tileEnt.getStackInSlot(0).getMaxStackSize() == 1){
								if(tileEnt.getStackInSlot(0).getItemDamage() == tileEnt.getStackInSlot(0).getMaxDamage()-1){
									tileEnt.decrStackSize(0, 1);
								} else {tileEnt.getStackInSlot(0).setItemDamage(tileEnt.getStackInSlot(0).getItemDamage()+1);}
							}
							if((tileEnt.getStackInSlot(0).getItem() == getItem3(checkItem))){
								tileEnt.decrStackSize(0, 1);
							}
						}
					}

					if((blockKey == 0) && (checkItem == getItem3(checkItem))){
						if(tileRefIngot.hits >= 4){
							tileRefIngot.hits=0;
							giveItem(key, world, x, y, z, p);
							stack.damageItem(1, p);
							if(tileEnt.getStackInSlot(0).getMaxStackSize() == 1){
								if(tileEnt.getStackInSlot(0).getItemDamage() == tileEnt.getStackInSlot(0).getMaxDamage()-1){
									tileEnt.decrStackSize(0, 1);
								} else {tileEnt.getStackInSlot(0).setItemDamage(tileEnt.getStackInSlot(0).getItemDamage()+1);} 
							}
							if((tileEnt.getStackInSlot(0).getItem() == getItem3(checkItem))){
								tileEnt.decrStackSize(0, 1);
							}
						}
					}
					if(blockKey == 3){
						p.worldObj.playSoundAtEntity(p, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
						Main.sNet.sendToAll(new MsgPacket(true));
						Main.sNet.sendToAll(new MsgPacketlTicks(x));
						Main.sNet.sendToAll(new MsgPacketLocY(y));
						Main.sNet.sendToAll(new MsgPacketLocZ(z));
						if((checkItem == getItem2(checkItem).getItem())){
							if(tilePlate.hits >= 3){
								tilePlate.hits=0;
								giveItem(key, world, x, y, z, p);
								stack.damageItem(1, p);
								if(tileEnt.getStackInSlot(0).getItem() == getItem2(checkItem).getItem()){
									tileEnt.decrStackSize(0, 1);
								}
							}
						}
					}
				}
			}
		}
		 */

	}
	/*
	 * 		ItemStack gladius0 = new ItemStack(ModItems.gladius);
		gladius0.stackTagCompound = new NBTTagCompound();
		gladius0.stackTagCompound.setInteger("GLADIUSTEXTURE", 0);
	 */

	public void giveItem(int a, World world, int x, int y, int z, EntityPlayer p){
		if(blockKey == 0){
			world.setBlock(x, y, z, Blocks.air, 0, 2);
			p.worldObj.playSoundAtEntity(p, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
			world.spawnEntityInWorld(new EntityItem(world, x+0.5D, y+0.6D, z+0.5D, ForgeAnvilCrafting.itemToGive.get(key)));
		}
		if(blockKey == 3){
			Item item = ForgeAnvilCrafting.itemToCheck.get(key);
			world.setBlock(x, y, z, Blocks.air, 0, 2);
			p.worldObj.playSoundAtEntity(p, Main.MODID + ":anvilhammer", 1.0F, 1.0F);
			world.spawnEntityInWorld(new EntityItem(world, x+0.5D, y+0.6D, z+0.5D, new ItemStack(item, 1, 0)));
		}

	}

	private Item getItem(Item testItem){
		for(int i = 0; i < ForgeAnvilCrafting.itemToCheck.size(); i++){
			if(testItem == ForgeAnvilCrafting.itemToCheck.get(i)){
				key = i;
			}
		}
		return ForgeAnvilCrafting.itemToCheck.get(key);
	}

	private ItemStack getItem2(Item testItem){
		for(int i = 0; i < ForgeAnvilCrafting.itemToGive.size(); i++){
			if(testItem == ForgeAnvilCrafting.itemToGive.get(i).getItem()){
				key = i;
			}
		}
		return ForgeAnvilCrafting.itemToGive.get(key);
	}

	private Item getItem3(Item testItem){
		for(int i = 0; i < ForgeAnvilCrafting.itemToCheckClay.size(); i++){
			if(testItem == ForgeAnvilCrafting.itemToCheckClay.get(i)){
				key = i;
			}
		}
		return ForgeAnvilCrafting.itemToCheckClay.get(key);
	}


	private String getTool(ItemStack s){
		for(int i = 0; i < ForgeAnvilCrafting.toolToRepair.size(); i++){
			if(s.getDisplayName().equals(ForgeAnvilCrafting.toolToRepair.get(i)) ){
				keys = i;
			}
		}
		return ForgeAnvilCrafting.toolToRepair.get(keys);
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

	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int p_77663_4_, boolean using) {

		if(using == true){
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 10, 4, true));
		}
	}

	@Override
	public int getItemEnchantability () {
		return 0;
	}

	@Override
	public boolean getIsRepairable(ItemStack item, ItemStack repair)
	{
		return Items.iron_ingot == repair.getItem() ? true : false;
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
		return false;
	}

	@Override
	public Item getContainerItem()
	{
		item.setDamage(new ItemStack(item), +1);
		return item;
	}



}




