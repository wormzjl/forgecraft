package com.kitsu.medievalcraft.tileents.crucible;

import net.minecraft.tileentity.TileEntity;

public class TileCrucibleWootz extends TileCrucibleBase {

	private static String nameCustom = "crucibleWootz";
	
	public TileCrucibleWootz() {
		super(nameCustom);
		this.cooked = false;
		this.hot = false;
		this.coolTicks = 1100;
		this.heatTicks = 900;
	}
}
