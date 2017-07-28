package com.kitsu.medievalcraft.block.machines;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.machine.TileEntityWaterFilter;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WaterFilter extends BlockContainer {

	public WaterFilter(String unlocalizedName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setHarvestLevel("pickaxe", 1, 0);
		this.setStepSound(Block.soundTypeStone);
		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		//this.setBlockBounds(0.17F, 0.0F,  0.315F, 
		//0.8F,  0.15F, 0.725F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {

		return new TileEntityWaterFilter();
	}

	@Override
	public int getRenderType() {
		return RenderId.waterFilterID;
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
		if((world.getBlock(x, y+1, z).equals(Blocks.water)) && world.getBlock(x, y-1, z).equals(Blocks.air)){
			if (random.nextInt(8) == 0) {
				world.spawnParticle("bubble", x + 0.3D,  y + 1.1D, z + 0.34D, 0.0D, 0.0D, 0.0D);
			}
			if (random.nextInt(8) == 1) {
				world.spawnParticle("bubble", x + 0.3D,  y + 1.1D, z + 0.34D, 0.0D, 0.0D, 0.0D);
			}
			if (random.nextInt(8) == 2) {
				world.spawnParticle("bubble", x + 0.75D, y + 1.1D, z + 0.6D,  0.0D, 0.0D, 0.0D);
			}
			if (random.nextInt(8) == 3) {
				world.spawnParticle("bubble", x + 0.45D, y + 1.1D, z + 0.75D, 0.0D, 0.0D, 0.0D);
			}
		}
	}
}

