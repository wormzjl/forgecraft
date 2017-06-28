package com.kitsu.medievalcraft.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.TileEntityTestBlock;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleIronOre;
import com.kitsu.medievalcraft.util.CustomTab;

public class TestBlock extends BlockContainer {
	
	public TestBlock (String unlocalizedName, Material material) {

		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		//this.setCreativeTab(CustomTab.MedievalCraftTab);
		//this.setHardness(1.0F);
		//this.setResistance(1.0F);
		//this.setHarvestLevel(null, 0);
		this.setStepSound(soundTypeStone);
		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		//this.setBlockBounds(0.2F, 0.0F,  0.25F, 
		//		0.8F, 0.66F, 0.8F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		
		return new TileCrucibleIronOre();
	}
	
	@Override
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

	@Override
	public int getRenderType() {
		return RenderId.testBlockID;
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
