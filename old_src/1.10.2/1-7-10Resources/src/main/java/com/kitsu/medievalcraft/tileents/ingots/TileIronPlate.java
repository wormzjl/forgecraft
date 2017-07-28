package com.kitsu.medievalcraft.tileents.ingots;

public class TileIronPlate extends TileIngotBase{

	private static String nameCustom = "tileIronPlate";
	
	public TileIronPlate() {
		super(nameCustom);
		this.hits = 0;
		this.hot = false;
		this.heatTicks = 450;
		this.heatBase = 450;
	}

}
