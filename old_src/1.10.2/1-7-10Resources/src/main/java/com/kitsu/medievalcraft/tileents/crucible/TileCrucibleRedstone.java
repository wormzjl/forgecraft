package com.kitsu.medievalcraft.tileents.crucible;

public class TileCrucibleRedstone extends TileCrucibleBase {

	private static String nameCustom = "crucibleRedstone";
	
	public TileCrucibleRedstone() {
		super(nameCustom);
		this.cooked = false;
		this.hot = false;
		this.coolTicks = 900;
		this.heatTicks = 850;
	}
}
