package nmd.primal.forgecraft.init;

import net.minecraftforge.client.model.animation.AnimationTESR;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import nmd.primal.forgecraft.renders.blocks.*;
import nmd.primal.forgecraft.tiles.*;

public class ModTileRenders {

    public static void init(){
        ClientRegistry.bindTileEntitySpecialRenderer(TileForge.class, new TileForgeRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TilePistonBellows.class, new TilePistonBellowsRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileBloomery.class, new TileBloomeryRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileAnvil.class, new TileAnvilRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileBreaker.class, new TileBreakerRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCastingForm.class, new TileCastingformRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileWorkbench.class, new TileWorkbenchRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileSharpBench.class, new TileSharpBenchRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileRedstoneBellows.class, new TileRedstoneBellowsRender());
    }



}



/*
        ClientRegistry.bindTileEntitySpecialRenderer(TileRedstoneBellows.class, new AnimationTESR<TileRedstoneBellows>()
        {
            @Override
            public void handleEvents(TileRedstoneBellows tileRedstoneBellows, float time, Iterable<Event> pastEvents)
            {

                //tileRedstoneBellows.handleEvents(time, pastEvents);
            }
        });
 */