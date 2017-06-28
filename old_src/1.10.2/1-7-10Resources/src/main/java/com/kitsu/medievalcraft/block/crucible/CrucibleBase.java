package com.kitsu.medievalcraft.block.crucible;

import java.util.Random;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.util.CustomTab;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class CrucibleBase extends BlockContainer {

	//comment
	protected CrucibleBase(Material mat, String unlocalizedName) {
		super(mat);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(2.0F);
		this.setResistance(1.0F);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(soundTypeStone);
		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		this.setBlockBounds(0.2F, 0.0F,  0.25F, 
				0.8F, 0.66F, 0.8F);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){
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
		return true;
	}
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Item.getItemFromBlock(this);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getRenderType() {
		return 0;
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
