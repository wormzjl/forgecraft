package nmd.primal.forgecraft.init.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import nmd.primal.core.common.recipes.tile.DryingRecipe;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;

@GameRegistry.ObjectHolder(ModInfo.MOD_ID)
@Mod.EventBusSubscriber
public class DryingRecipes
{
    @SubscribeEvent
    public static void registerDryingRecipes(RegistryEvent.Register<DryingRecipe> event)
    {
        final IForgeRegistry<DryingRecipe> recipes = event.getRegistry();

        recipes.register(new DryingRecipe(
                20,
                new ItemStack(ModItems.softcrucible),
                new ItemStack(ModBlocks.nbtCrucible)
        ).setRecipeName(ModInfo.MOD_ID + "_soft_crucible"));
    }
}