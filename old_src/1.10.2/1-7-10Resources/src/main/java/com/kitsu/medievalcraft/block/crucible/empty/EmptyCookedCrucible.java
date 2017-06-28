package com.kitsu.medievalcraft.block.crucible.empty;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntityEmptyCookedCrucible;
import com.kitsu.medievalcraft.util.CustomTab;

public class EmptyCookedCrucible extends BlockContainer {

	public EmptyCookedCrucible (String unlocalizedName, Material material) {

		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		//this.setHardness(1.0F);
		//this.setResistance(1.0F);
		//this.setHarvestLevel(null, 0);
		this.setStepSound(soundTypeStone);
		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		this.setBlockBounds(0.2F, 0.0F,  0.25F, 
				0.8F, 0.66F, 0.8F);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){

		int a = player.inventory.currentItem;
		if(player.inventory.getStackInSlot(a)!=null){
			if(player.inventory.getStackInSlot(a).getItem()==Items.water_bucket){
				ItemStack bucket = new ItemStack(Items.bucket);
				player.inventory.setInventorySlotContents(a, bucket);
				if(!world.isRemote){
					world.setBlock(x, y, z, ModBlocks.filledWaterCrucible, 0, 2);
				}
			}
		}
		if(player.inventory.getStackInSlot(a)!=null){
			if(player.inventory.getStackInSlot(a).getItem()==Item.getItemFromBlock(ModBlocks.emptyCookedCrucible)){
				ItemStack jar = new ItemStack(ModBlocks.emptyCookedCrucible);
				player.inventory.addItemStackToInventory(jar);
				if(!world.isRemote){
					world.setBlock(x, y, z, Blocks.air, 0, 2);
				}
			}
		}
		if(player.inventory.getStackInSlot(a)==null){
			ItemStack jar = new ItemStack(ModBlocks.emptyCookedCrucible);
			player.inventory.setInventorySlotContents(a, jar);
			if(!world.isRemote){
				world.setBlock(x, y, z, Blocks.air, 0, 2);
			}
		}


		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {

		return new TileEntityEmptyCookedCrucible();
	}

	@Override
	public int quantityDropped(Random p_149745_1_)
	{
		return 1;
	}

	@Override
	public Item getItemDropped(int par1, Random random, int par3) {
		return Item.getItemFromBlock(ModBlocks.emptyCookedCrucible);
	}

	@Override
	public Item getItem(World world, int par2, int par3, int par4) {
		return Item.getItemFromBlock(ModBlocks.emptyCookedCrucible);
	}

	@Override
	public int getRenderType() {
		return RenderId.emptyCrucibleID;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

}
