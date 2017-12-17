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
        registerTileEntity(TileBaseCrucible.class, "basecrucible");
        registerTileEntity(TileAnvil.class, "anvil");
        registerTileEntity(TileBreaker.class, "breaker");
        registerTileEntity(TileCastingForm.class, "castingform");
        registerTileEntity(TileCastingBlock.class, "castingblock");
        registerTileEntity(TileNBTCrucible.class, "nbtcrucible");
    }

    private static void registerTileEntity(Class<? extends TileEntity> tile_class, String baseName) {
        GameRegistry.registerTileEntity(tile_class, "tile.forgecraft." + baseName);
    }
}
