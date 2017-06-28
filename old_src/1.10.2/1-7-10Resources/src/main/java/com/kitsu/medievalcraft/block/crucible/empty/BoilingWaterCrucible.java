package com.kitsu.medievalcraft.block.crucible.empty;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntityBoilingWaterCrucible;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BoilingWaterCrucible extends BlockContainer {
	
	public BoilingWaterCrucible (String unlocalizedName, Material material) {

		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		//this.setHarvestLevel(null, 0);
		this.setStepSound(soundTypeStone);
		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		this.setBlockBounds(0.2F, 0.0F,  0.25F, 
				0.8F, 0.66F, 0.8F);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){
		
		if(!world.isRemote){
			TileEntityBoilingWaterCrucible boilingEnt = (TileEntityBoilingWaterCrucible) world.getTileEntity(x, y, z);
			int a = player.inventory.currentItem;
			if(player.inventory.getStackInSlot(a)!=null){
				if(player.inventory.getStackInSlot(a).getItem()==ModItems.itemBark){
					if(player.inventory.getStackInSlot(a).stackSize >= 16){
						if((boilingEnt.dotan==false)&&(boilingEnt.dolime!=true)){
							player.inventory.decrStackSize(a, 10+world.rand.nextInt(6));
							boilingEnt.dotan=true;
						}
					}
				}
				if(player.inventory.getStackInSlot(a).getItem()==ModItems.limestoneDust){
					if(player.inventory.getStackInSlot(a).stackSize >= 16){
						if((boilingEnt.dolime==false)&&(boilingEnt.dotan!=true)){
							player.inventory.decrStackSize(a, 8+world.rand.nextInt(8));
							boilingEnt.dolime=true;
						}
					}
				}
			}
		}

		
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		
		return new TileEntityBoilingWaterCrucible();
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
		return RenderId.filledWaterCrucibleID;
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
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		super.randomDisplayTick(world, x, y, z, random);
		if (random.nextInt(3) == 0) {
			world.spawnParticle("cloud",  (x + 0.5D) + (random.nextGaussian()/25), (y + 0.85D), (z + 0.5D) + (random.nextGaussian()/25), (random.nextGaussian()/100), 0.07D, (random.nextGaussian()/100));
			//world.spawnParticle("droplet", (x + 0.5D) + (random.nextGaussian()/50), (y + 0.5D), (z + 0.5D) + (random.nextGaussian()/50), 0.0D, 0.1D, 0.0D);
		}


	}
	
}
