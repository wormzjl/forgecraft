package nmd.primal.forgecraft.init.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import nmd.primal.core.common.recipes.tile.CauldronRecipe;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModItems;

@GameRegistry.ObjectHolder(ModInfo.MOD_ID)
@Mod.EventBusSubscriber
public class CauldronRecipes
{
    @SubscribeEvent
    public static void registerCauldronRecipes(RegistryEvent.Register<CauldronRecipe> event)
    {
        final IForgeRegistry<CauldronRecipe> recipes = event.getRegistry();

        ItemStack defaultBronze = new ItemStack(ModItems.bronzegladius);

        NBTTagCompound tags = new NBTTagCompound();
        defaultBronze.setTagCompound(tags);

        ItemStack lapisBronze = defaultBronze.copy();
        lapisBronze.getTagCompound().setTag("tags", tags);
        lapisBronze.getSubCompound("tags").setInteger("smite", 0);
        lapisBronze.getSubCompound("tags").setInteger("bane", 0);
        lapisBronze.getSubCompound("tags").setInteger("fire", 0);
        lapisBronze.getSubCompound("tags").setInteger("lapis", 1);
        lapisBronze.getSubCompound("tags").setBoolean("modified", true);





/*
        recipes.register(new CauldronRecipe(
                5,
                FluidRegistry.getFluidStack("water", 1000),
                FluidRegistry.getFluidStack("water", 1000),
                new ItemStack(ModItems.rawbronzegladius, 1),
                new ItemStack(Items.DYE, 1, 4),
                ItemStack.EMPTY,
                ItemStack.EMPTY,
                lapisBronze,
                ItemStack.EMPTY).setRecipeName("finishedGladius")
                );
                */
    }
}
