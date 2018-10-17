package nmd.primal.forgecraft.init;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.RegistryHelper;

public class ModFluids {

    public static Fluid SILVER_WATER;

    @SubscribeEvent
    public static void registryFluidBlocks(final RegistryEvent.Register<Block> event){
        final IForgeRegistry<Block> registry = event.getRegistry();
        //RegistryHelper.registerFluidBlock(registry,
         //       );
    }


}
