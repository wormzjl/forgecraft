package com.kitsu.medievalcraft.tileents.crucible.empty;

import com.kitsu.medievalcraft.block.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityFilledWaterCrucible extends TileEntity {

	private String filledWaterCrucibleName;
	public int cookTime = 450;
	public int coolTime = 500;
	public Block cookBlock = ModBlocks.boilingWaterCrucible;

	public TileEntityFilledWaterCrucible() {

	}
	
}
