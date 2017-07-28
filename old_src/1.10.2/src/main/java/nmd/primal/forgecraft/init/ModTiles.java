package nmd.primal.forgecraft.init;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.tiles.TileFirebox;

/**
 * Created by kitsu on 12/2/2016.
 */
public class ModTiles {

    public static void registerTileEntities () {
        registerTileEntity(TileFirebox.class, "firebox");
    }

    private static void registerTileEntity(Class<? extends TileEntity> tile_class, String baseName) {
        GameRegistry.registerTileEntity(tile_class, "tile.forgecraft." + baseName);
    }
}
