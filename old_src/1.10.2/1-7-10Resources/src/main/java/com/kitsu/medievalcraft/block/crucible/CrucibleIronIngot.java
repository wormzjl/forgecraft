package com.kitsu.medievalcraft.block.crucible;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleIronOre;

public class CrucibleIronIngot extends CrucibleBase{

	public CrucibleIronIngot(Material mat, String unlocalizedName) {
		super(mat, unlocalizedName);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileCrucibleIronOre();
	}
	@Override
	public int getRenderType() {
		return RenderId.coolCrucibleID;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){
		if(!world.isRemote){
			TileCrucibleIronOre tile = (TileCrucibleIronOre) world.getTileEntity(x, y, z);

			if(tile.cooked==false && tile.hot==false){
				int a = player.inventory.currentItem;
				if(player.inventory.getStackInSlot(a)!=null){
					if(player.inventory.getStackInSlot(a).getItem()==Item.getItemFromBlock(this)){
						ItemStack jar = new ItemStack(this);
						player.inventory.addItemStackToInventory(jar);
						if(!world.isRemote){
							world.setBlock(x, y, z, Blocks.air, 0, 2);
						}
					}
				}
				if(player.inventory.getStackInSlot(a)==null){
					ItemStack jar = new ItemStack(this);
					player.inventory.setInventorySlotContents(a, jar);
					if(!world.isRemote){
						world.setBlock(x, y, z, Blocks.air, 0, 2);
					}
				}
			}
		}
		return true;
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {

		return null;
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta){
		if(!world.isRemote){
			if(meta == 0){
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Blocks.stone_slab, 1, 0)));
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModBlocks.emptyCookedCrucible, 1, 0)));
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.iron_ingot, 1, 0)));
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Blocks.sand, 1, 0)));
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.coal, 1, 1)));
			}
			if(meta == 1){

			}
			if(meta == 2){
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Blocks.stone_slab, 1, 0)));
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModBlocks.emptyCookedCrucible, 1, 0)));
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModBlocks.refinedIron, 1, 0)));
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Blocks.glass, 1, 0)));
			}
			
		}
	}


}
