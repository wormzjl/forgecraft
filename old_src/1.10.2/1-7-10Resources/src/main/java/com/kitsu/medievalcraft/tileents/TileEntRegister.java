package com.kitsu.medievalcraft.tileents;

import com.kitsu.medievalcraft.tileents.cannon.TileCannonBall28;
import com.kitsu.medievalcraft.tileents.cannon.TileCannon_28;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleIronOre;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleLapis;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleRedstone;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleWootz;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntityBoilingWaterCrucible;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntityEmptyCookedCrucible;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntityFilledWaterCrucible;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntitySlackWaterCrucible;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntitySoftEmptyCrucible;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntityTanWaterCrucible;
import com.kitsu.medievalcraft.tileents.ingots.TileDamascus;
import com.kitsu.medievalcraft.tileents.ingots.TileEntityMyDiamond;
import com.kitsu.medievalcraft.tileents.ingots.TileEntityMyEmerald;
import com.kitsu.medievalcraft.tileents.ingots.TileIronPlate;
import com.kitsu.medievalcraft.tileents.ingots.TileLapisIngot;
import com.kitsu.medievalcraft.tileents.ingots.TileMyIronIngot;
import com.kitsu.medievalcraft.tileents.ingots.TileRedstoneIngot;
import com.kitsu.medievalcraft.tileents.machine.TileEntityAnvilForge;
import com.kitsu.medievalcraft.tileents.machine.TileEntityFirebox;
import com.kitsu.medievalcraft.tileents.machine.TileEntityShelfFour;
import com.kitsu.medievalcraft.tileents.machine.TileEntitySolidFilter;
import com.kitsu.medievalcraft.tileents.machine.TileEntityTestForge;
import com.kitsu.medievalcraft.tileents.machine.TileEntityWaterFilter;
import com.kitsu.medievalcraft.tileents.machine.TileForge;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntRegister {
	
	public static final void init() {
		
        GameRegistry.registerTileEntity(TileEntityTestForge.class, "TestForge");
        GameRegistry.registerTileEntity(TileEntityAnvilForge.class, "AnvilForge");
        GameRegistry.registerTileEntity(TileEntitySoftEmptyCrucible.class, "SoftEmptyCrucible");
        GameRegistry.registerTileEntity(TileEntityEmptyCookedCrucible.class, "EmptyCookedCrucible");

        GameRegistry.registerTileEntity(TileEntityMyDiamond.class, "MyDiamond");
        GameRegistry.registerTileEntity(TileEntityMyEmerald.class, "MyEmerald");

        GameRegistry.registerTileEntity(TileEntityWaterFilter.class, "WaterFilter");

        GameRegistry.registerTileEntity(TileEntityFilledWaterCrucible.class, "FilledWaterCrucible");
        GameRegistry.registerTileEntity(TileEntityBoilingWaterCrucible.class, "BoilingWaterCrucible");
        GameRegistry.registerTileEntity(TileEntityTanWaterCrucible.class, "TanWaterCrucible");
        GameRegistry.registerTileEntity(TileEntitySlackWaterCrucible.class, "SlackWaterCrucible");
        GameRegistry.registerTileEntity(TileEntitySolidFilter.class, "SolidFilter");
        GameRegistry.registerTileEntity(TileEntitySmallLid.class, "SmallLid");
        GameRegistry.registerTileEntity(TileEntitySmallBarrel.class, "SmallBarrel");
        GameRegistry.registerTileEntity(TileEntityShelfFour.class, "ShelfFour");
        GameRegistry.registerTileEntity(TileEntityFirebox.class, "Firebox");
        GameRegistry.registerTileEntity(TileForge.class, "Forge");

        GameRegistry.registerTileEntity(TileCrucibleIronOre.class, "CrucibleIronOre");
        GameRegistry.registerTileEntity(TileCrucibleWootz.class, "CrucibleWootz");
        GameRegistry.registerTileEntity(TileCrucibleLapis.class, "CrucibleLapis");
        GameRegistry.registerTileEntity(TileCrucibleRedstone.class, "CrucibleRedstone");
        
        GameRegistry.registerTileEntity(TileMyIronIngot.class, "MyIronIngot");
        GameRegistry.registerTileEntity(TileDamascus.class, "Damascus");
        GameRegistry.registerTileEntity(TileIronPlate.class, "IronPlate");
        GameRegistry.registerTileEntity(TileRedstoneIngot.class, "RedstoneIngot");
        GameRegistry.registerTileEntity(TileLapisIngot.class, "LapisIngot");
        
        GameRegistry.registerTileEntity(TileCannon_28.class, "Cannon_28");
        GameRegistry.registerTileEntity(TileCannonBall28.class, "CannonBall_28");
        
	}

}
