package com.kitsu.medievalcraft.item.craftingtools;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;
//import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorkBlade extends Item {

	private String name = "workBlade";
	private Item item;
	//private int[] locarray = new int[3];
	//private int hits;
	//private boolean inUse;
	Random rand;

	public WorkBlade() {

		setMaxStackSize(1);
		setUnlocalizedName(name);
		//setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		setMaxDamage(500);
		setNoRepair();

		item = this;

		GameRegistry.registerItem(this, name);
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_){

		if(!world.isRemote){
			getBark(world, x, y, z, player, stack);
			makeLonbow(world, x, y, z, player, stack);
		}
		return true;
	}

	private void getBark(World world, int x, int y, int z, EntityPlayer player, ItemStack stack){
		if(player.isSwingInProgress == false){
			if(world.getBlock(x, y, z).getUnlocalizedName().equals("tile.log")){
				player.worldObj.playSoundAtEntity(player, Main.MODID + ":scrapes1", 0.25F, 1.8F);
				if(world.rand.nextInt(8)==1){
					if(world.getBlock(x, y, z).equals(Blocks.log)){
						//System.out.println("lvl5");
						int woodMeta = world.getBlockMetadata(x, y, z);
						if(woodMeta == 0){
							world.setBlock(x, y, z, ModBlocks.cleanOak, 0, 2);
						}
						if(woodMeta == 4){
							world.setBlock(x, y, z, ModBlocks.cleanOak, 4, 2);
						}
						if(woodMeta == 8){
							world.setBlock(x, y, z, ModBlocks.cleanOak, 8, 2);
						}
						if(woodMeta == 1){
							world.setBlock(x, y, z, ModBlocks.cleanSpruce, 0, 2);
						}
						if(woodMeta == 5){
							world.setBlock(x, y, z, ModBlocks.cleanSpruce, 4, 2);
						}
						if(woodMeta == 9){
							world.setBlock(x, y, z, ModBlocks.cleanSpruce, 8, 2);
						}
						if(woodMeta == 2){
							world.setBlock(x, y, z, ModBlocks.cleanBirch, 0, 2);
						}
						if(woodMeta == 6){
							world.setBlock(x, y, z, ModBlocks.cleanBirch, 4, 2);
						}
						if(woodMeta == 10){
							world.setBlock(x, y, z, ModBlocks.cleanBirch, 8, 2);
						}
						if(woodMeta == 3){
							world.setBlock(x, y, z, ModBlocks.cleanJungle, 0, 2);
						}
						if(woodMeta == 7){
							world.setBlock(x, y, z, ModBlocks.cleanJungle, 4, 2);
						}
						if(woodMeta == 11){
							world.setBlock(x, y, z, ModBlocks.cleanJungle, 8, 2);
						}
					}
					if(world.getBlock(x, y, z).equals(Blocks.log2)){
						//System.out.println("lvl6");
						int woodMeta = world.getBlockMetadata(x, y, z);
						if(woodMeta == 0){
							world.setBlock(x, y, z, ModBlocks.cleanAcacia, 0, 2);
						}
						if(woodMeta == 4){
							world.setBlock(x, y, z, ModBlocks.cleanAcacia, 4, 2);
						}
						if(woodMeta == 8){
							world.setBlock(x, y, z, ModBlocks.cleanAcacia, 8, 2);
						}
						if(woodMeta == 1){
							world.setBlock(x, y, z, ModBlocks.cleanDarkOak, 0, 2);
						}
						if(woodMeta == 5){
							world.setBlock(x, y, z, ModBlocks.cleanDarkOak, 4, 2);
						}
						if(woodMeta == 9){
							world.setBlock(x, y, z, ModBlocks.cleanDarkOak, 8, 2);
						}
					}

					world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.itemBark, 5 + world.rand.nextInt(4), 0)));
				}
			}
		}
	}

	private void makeLonbow(World world, int x, int y, int z, EntityPlayer player, ItemStack stack){
		if(!world.isRemote){
			if((world.getBlock(x, y, z).equals(ModBlocks.jungleSplitLog))&&world.getBlock(x, y-1, z).equals(ModBlocks.jungleSplitLog)){
				player.worldObj.playSoundAtEntity(player, Main.MODID + ":scrapes1", 0.25F, 1.8F);
				player.swingItem();
				if(world.rand.nextInt(10)==0){
					world.setBlockToAir(x, y, z);
					world.setBlockToAir(x, y-1, z);
					world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.unstrungLongbow, 1, 0)));
				}
			}
		}
	}


	/*@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_){
		if(player.isSwingInProgress == false){
			if(!world.isRemote){
				if((world.getBlock(x, y, z).equals(Blocks.log)) && (world.getBlockMetadata(x, y, z)==3)){
					if((world.getBlock(x, y-1, z).equals(Blocks.log)) && (world.getBlockMetadata(x, y-1, z)==3)){
						if(world.getBlock(x, y+1, z).equals(Blocks.air)){

							if((stack.stackTagCompound.getInteger("HITS") == 0) || (stack.stackTagCompound.getInteger("X") != x) || (stack.stackTagCompound.getInteger("Y") != y) || (stack.stackTagCompound.getInteger("Z") != z)){
								stack.stackTagCompound.setInteger("X", x);
								stack.stackTagCompound.setInteger("Y", y);
								stack.stackTagCompound.setInteger("Z", z);
								stack.stackTagCompound.setInteger("HITS", 1);
							}
							if(stack.stackTagCompound.getInteger("HITS") > 0){
								if((stack.stackTagCompound.getInteger("X") == x) && (stack.stackTagCompound.getInteger("Y") == y) && (stack.stackTagCompound.getInteger("Z") == z)){
									if (world.rand.nextInt(2) == 0 ) {
										stack.stackTagCompound.setInteger("HITS", stack.stackTagCompound.getInteger("HITS") + 1);
										stack.stackTagCompound.setInteger("X", x);
										stack.stackTagCompound.setInteger("Y", y);
										stack.stackTagCompound.setInteger("Z", z);
										stack.damageItem(1, player);
									}
								}
							}
							if(stack.stackTagCompound.getInteger("HITS") == 10){
								stack.stackTagCompound.setInteger("HITS", 0);
								stack.stackTagCompound.setInteger("X", 0);
								stack.stackTagCompound.setInteger("Y", 0);
								stack.stackTagCompound.setInteger("Z", 0);
								world.setBlock(x, y, z, Blocks.air, 0, 2);
								world.setBlock(x, y-1, z, Blocks.air, 0, 2);
								world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.unstrungLongbow, 1, 0)));
							}
						}
					}
				}
			}
		}

		return true;
	}*/

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




