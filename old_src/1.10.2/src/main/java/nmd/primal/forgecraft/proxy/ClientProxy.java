package nmd.primal.forgecraft.proxy;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.renders.TileFireboxRender;
import nmd.primal.forgecraft.tiles.TileFirebox;

import static nmd.primal.forgecraft.init.ModItems.*;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ClientProxy implements CommonProxy {

    @Override
    public void init() {

        ModItems.registerRenders();
        ModBlocks.registerRenders();
        this.registerTileRendering();
    }

    //@Override
    public void registerTileRendering()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileFirebox.class, new TileFireboxRender());
    }


}
