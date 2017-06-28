package com.kitsu.medievalcraft.block.ingots;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.ingots.TileMyIronIngot;
import com.kitsu.medievalcraft.util.CustomTab;

public class RefinedIron extends IngotBase {

	public RefinedIron(String unlocalizedName, Material material) {
		super(unlocalizedName, material);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		
		return new TileMyIronIngot();
	}
	
	@Override
	public int getRenderType() {
		return RenderId.myironingotID;
	}

}
