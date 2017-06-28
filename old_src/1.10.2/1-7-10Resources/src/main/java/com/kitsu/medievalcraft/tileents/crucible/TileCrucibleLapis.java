package com.kitsu.medievalcraft.tileents.crucible;

public class TileCrucibleLapis extends TileCrucibleBase {

	private static String nameCustom = "crucibleLapis";
	
	public TileCrucibleLapis() {
		super(nameCustom);
		this.cooked = false;
		this.hot = false;
		this.coolTicks = 900;
		this.heatTicks = 850;
	}
}
