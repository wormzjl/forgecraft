package nmd.primal.forgecraft.init.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.core.common.recipes.tile.CauldronRecipe;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.util.WeaponNBT;

@GameRegistry.ObjectHolder(ModInfo.MOD_ID)
@Mod.EventBusSubscriber
public class CauldronRecipes
{
    @SubscribeEvent
    public static void registerCauldronRecipes(RegistryEvent.Register<CauldronRecipe> event)
    {
        final IForgeRegistry<CauldronRecipe> recipes = event.getRegistry();

        ItemStack defaultBronzeGladius = new ItemStack(ModItems.rawbronzegladius, 1);

        //WeaponNBT.setDefaultNBT(defaultBronzeGladius);
        NonNullList<ItemStack> tempList1 = NonNullList.<ItemStack>create();
        tempList1.add(0, new ItemStack(ModItems.rawbronzegladius, 1));
        recipes.register(new CauldronRecipe(
                5,
                new FluidStack(FluidRegistry.WATER, 1000),
                new FluidStack(PrimalAPI.Fluids.WASTE, 1000),
                RecipeHelper.getOreStack("gemLapis", 1),
                tempList1,
                defaultBronzeGladius,
                ItemStack.EMPTY).setRecipeName("rawbronzegladiuslapis"));

    }
}

//int cook_time,
// FluidStack fluid_input,
// FluidStack fluid_output,
// List<ItemStack> item_input_1,
// List<ItemStack> item_input_2,
// ItemStack item_output_1,
// ItemStack item_output_2