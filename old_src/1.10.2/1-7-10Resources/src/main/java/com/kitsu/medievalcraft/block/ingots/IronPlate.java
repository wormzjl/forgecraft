package com.kitsu.medievalcraft.block.ingots;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.ingots.TileIronPlate;
import com.kitsu.medievalcraft.tileents.ingots.TileMyIronIngot;
import com.kitsu.medievalcraft.util.CustomTab;

public class IronPlate extends IngotBase {

	public IronPlate(String unlocalizedName, Material material) {
		super(unlocalizedName, material);
		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		this.setBlockBounds(0.3F, 0.0F,  0.3F, 
				            0.7F,  0.12F, 0.7F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileIronPlate();
	}
	
	@Override
	public int getRenderType() {
		return RenderId.ironPlateID;
	}

}
