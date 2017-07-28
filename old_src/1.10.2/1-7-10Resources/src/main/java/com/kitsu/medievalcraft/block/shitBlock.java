
package com.kitsu.medievalcraft.block;


import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraftforge.common.util.ForgeDirection;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

public class shitBlock extends Block {

	protected shitBlock(String unlocalizedName, Material material) {

		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(2.0F);
		this.setResistance(6.0F);
		this.setHarvestLevel("shovel", 0);
		this.setStepSound(soundTypeSnow);
		this.setTickRandomly(true);

	}
	
	public void updateTick(World world, int x, int y, int z, Random random){
		//System.out.println("Block Tick");
		if(random.nextInt(100)==0){
			//System.out.println("Random Method Fired");
			//world.setBlock(x, y, z, Blocks.air, 0, 2);
			world.func_147480_a(x, y, z, false);
		}
	}
	
	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
	{
		if (this == ModBlocks.shitblock && side == UP)
		{
			return true;
		}
		if ((world.provider instanceof WorldProviderEnd) && this == Blocks.bedrock && side == UP)
		{
			return true;
		}
		return false;
	}


}
