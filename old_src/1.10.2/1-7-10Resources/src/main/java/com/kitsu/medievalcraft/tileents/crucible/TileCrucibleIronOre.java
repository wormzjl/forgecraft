package com.kitsu.medievalcraft.tileents.crucible;

import com.kitsu.medievalcraft.block.ModBlocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.world.World;

public class TileCrucibleIronOre extends TileCrucibleBase {

	private static String nameCustom = "crucibleIron";
	
	public TileCrucibleIronOre() {
		super(nameCustom);
		this.cooked = false;
		this.hot = false;
		this.coolTicks = 900;
		this.heatTicks = 800;
	}
}
