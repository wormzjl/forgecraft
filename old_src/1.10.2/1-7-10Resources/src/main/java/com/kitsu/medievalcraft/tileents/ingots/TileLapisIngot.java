package com.kitsu.medievalcraft.tileents.ingots;

public class TileLapisIngot extends TileIngotBase{

	private static String nameCustom = "tileLapisIngot";
	
	public TileLapisIngot() {
		super(nameCustom);
		this.hits = 0;
		this.hot = false;
		this.coolTicks = 300;
		this.coolBase = 300;
		this.heatTicks = 600;
		this.heatBase = 600;
	}

}
