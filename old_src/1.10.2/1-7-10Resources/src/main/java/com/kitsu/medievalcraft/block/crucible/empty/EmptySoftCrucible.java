package com.kitsu.medievalcraft.block.crucible.empty;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntitySoftEmptyCrucible;
import com.kitsu.medievalcraft.util.CustomTab;

public class EmptySoftCrucible extends BlockContainer {
	
	public EmptySoftCrucible (String unlocalizedName, Material material) {

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

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		
		return new TileEntitySoftEmptyCrucible();
	}
	
	@Override
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }
	
	@Override
	public Item getItemDropped(int par1, Random random, int par3) {
		return Item.getItemFromBlock(ModBlocks.emptySoftCrucible);
	}

	@Override
	public Item getItem(World world, int par2, int par3, int par4) {
		return Item.getItemFromBlock(ModBlocks.emptySoftCrucible);
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
