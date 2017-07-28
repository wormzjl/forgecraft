package com.kitsu.medievalcraft.block.fluid;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSmoke extends BlockFluidFinite{

	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;

	public BlockSmoke(Fluid fluid, Material material) {
		super(fluid, material);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setBlockTextureName(Main.MODID + ":" + this.getUnlocalizedName());
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return (side == 0 || side == 1)? stillIcon : flowingIcon;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register) {
		stillIcon = register.registerIcon(Main.MODID + ":fluidStill");
		flowingIcon = register.registerIcon(Main.MODID + ":fluidFlowing");
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
		return super.displaceIfPossible(world, x, y, z);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		super.randomDisplayTick(world, x, y, z, random);

		if (random.nextInt(6) == 0) {
			world.spawnParticle("cloud", x + 0.5D, y + 0.5D, z + 0.5D, 0.0D, 0.2D, 0.0D);
			world.spawnParticle("largesmoke", x + 0.5D, y + 0.5D, z + 0.5D, 0.0D, 0.2D, 0.0D);
		}	
		if (random.nextInt(6) == 1) {
			world.spawnParticle("cloud", x + 0.8D, y + 0.5D, z + 0.5D, 0.0D, 0.2D, 0.0D);
			world.spawnParticle("largesmoke", x + 0.8D, y + 0.5D, z + 0.5D, 0.0D, 0.2D, 0.0D);
		}
		if (random.nextInt(6) == 2) {	
			world.spawnParticle("cloud", x + 0.2D, y + 0.5D, z + 0.5D, 0.0D, 0.2D, 0.0D);
			world.spawnParticle("largesmoke", x + 0.2D, y + 0.5D, z + 0.5D, 0.0D, 0.2D, 0.0D);
		}	
		if (random.nextInt(6) == 3) {
			world.spawnParticle("cloud", x + 0.5D, y + 0.5D, z + 0.8D, 0.0D, 0.2D, 0.0D);
			world.spawnParticle("largesmoke", x + 0.5D, y + 0.5D, z + 0.8D, 0.0D, 0.2D, 0.0D);
		}
		if (random.nextInt(6) == 4) {	
			world.spawnParticle("cloud", x + 0.5D, y + 0.5D, z + 0.2D, 0.0D, 0.2D, 0.0D);
			world.spawnParticle("largesmoke", x + 0.5D, y + 0.5D, z + 0.2D, 0.0D, 0.2D, 0.0D);
		}
		if (random.nextInt(6) == 5) {
			world.spawnParticle("cloud", x + 0.8D, y + 0.5D, z + 0.2D, 0.0D, 0.2D, 0.0D);
			world.spawnParticle("largesmoke", x + 0.8D, y + 0.5D, z + 0.2D, 0.0D, 0.2D, 0.0D);
		}
	}


}