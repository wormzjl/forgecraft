package nmd.primal.forgecraft.init;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.tiles.*;

/**
 * Created by kitsu on 12/2/2016.
 */
public class ModTiles {

    public static void registerTileEntities () {
        registerTileEntity(TileForge.class, "firebox");
        registerTileEntity(TilePistonBellows.class, "pistonbellows");
        registerTileEntity(TileBloomery.class, "bloomery");
        registerTileEntity(TileAnvil.class, "anvil");
        registerTileEntity(TileBreaker.class, "breaker");
        registerTileEntity(TileCastingForm.class, "castingform");
        registerTileEntity(TileNBTCrucible.class, "nbtcrucible");
        registerTileEntity(TileWorkbench.class, "workbench");
    }

    private static void registerTileEntity(Class<? extends TileEntity> tile_class, String baseName) {
        GameRegistry.registerTileEntity(tile_class, "tile.forgecraft." + baseName);
    }
}
