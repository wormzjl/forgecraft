package nmd.primal.forgecraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.blocks.fluids.BasicFluidBlockKFC;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import static nmd.primal.core.common.helper.RegistryHelper.registerFluidBlock;
import static nmd.primal.core.common.helper.RegistryHelper.registerFluidItems;

public class ModFluids {

    public static Fluid HOLY_WATER;

    public static final Set<IFluidBlock> FLUID_BLOCKS = new HashSet<>();

    // ***************************************************************************** //
    //  Fluid Registration
    // ***************************************************************************** //
    @Mod.EventBusSubscriber(modid= ModInfo.MOD_ID)
    public static class RegistrationHandler
    {
        /**
         * Register this mod's fluid {@link Block}s.
         * @param event The event
         */
        @SubscribeEvent
        public static void registryFluidBlocks(final RegistryEvent.Register<Block> event)
        {
            final IForgeRegistry<Block> registry = event.getRegistry();

            registerFluidBlock(registry,
                    HOLY_WATER = createFluid("holy_water", 0xFFEDF1F5, true,
                            fluid -> fluid.setDensity(1000).setViscosity(1000).setTemperature(100).setLuminosity(5).setGaseous(false),
                            fluid -> new BasicFluidBlockKFC(fluid, Material.WATER)));

        }

        /**
         * Register this mod's fluid {@link ItemBlock}s.
         * @param event The event
         */
        // Use EventPriority.LOWEST so this is called after the RegistryEvent.Register<Item> handler in ModBlocks where
        // the ItemBlock for ModBlocks.FLUID_TANK is registered.
        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void registryFluidItems(final RegistryEvent.Register<Item> event)
        {
            final IForgeRegistry<Item> registry = event.getRegistry();

            registerFluidItems(registry, FLUID_BLOCKS);
        }
    }


    // ***************************************************************************** //
    //  Registry Overrides
    // ***************************************************************************** //
    private static <T extends Block & IFluidBlock> Fluid createFluid(String name, int color, boolean hasFlowIcon, Consumer<Fluid> fluidPropertyApplier, Function<Fluid, T> blockFactory)
    {
        return nmd.primal.core.common.helper.RegistryHelper.createFluid(name, ModInfo.MOD_ID, FLUID_BLOCKS, color, hasFlowIcon, fluidPropertyApplier, blockFactory);
    }


}
