package nmd.primal.forgecraft.init.recipes;

import net.minecraft.item.ItemStack;
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

import java.util.List;

@GameRegistry.ObjectHolder(ModInfo.MOD_ID)
@Mod.EventBusSubscriber
public class CauldronRecipes
{
    @SubscribeEvent
    public static void registerCauldronRecipes(RegistryEvent.Register<CauldronRecipe> event)
    {
        final IForgeRegistry<CauldronRecipe> recipes = event.getRegistry();

        ItemStack defaultBronzeGladius = new ItemStack(ModItems.rawbronzegladius, 1);
        ItemStack defaultCopperGladius = new ItemStack(ModItems.rawcoppergladius, 1);
        ItemStack defaultWroughtIronGladius = new ItemStack(ModItems.rawwroughtirongladius, 1);
        ItemStack defaultCleanIronGladius = new ItemStack(ModItems.rawcleanirongladius, 1);
        ItemStack defaultSteelGladius = new ItemStack(ModItems.rawsteelgladius, 1);
        ItemStack defaultWootzGladius = new ItemStack(ModItems.rawwootzgladius, 1);

        ItemStack defaultCleanIronLongsword = new ItemStack(ModItems.rawcleanironlongsword, 1);
        ItemStack defaultSteelLongsword = new ItemStack(ModItems.rawsteellongsword, 1);
        ItemStack defaultWootzLongsword = new ItemStack(ModItems.rawwootzlongsword, 1);

        ItemStack defaultIronSlayer = new ItemStack(ModItems.rawironslayer, 1);
        ItemStack defaultCleanIronSlayer = new ItemStack(ModItems.rawcleanironslayer, 1);
        ItemStack defaultSteelSlayer = new ItemStack(ModItems.rawsteelslayer, 1);
        ItemStack defaultWootzSlayer = new ItemStack(ModItems.rawwootzslayer, 1);

        List<ItemStack> recipeList = RecipeHelper.buildList(defaultBronzeGladius, defaultCopperGladius, defaultWroughtIronGladius, defaultCleanIronGladius, defaultSteelGladius, defaultWootzGladius,
                defaultCleanIronLongsword, defaultSteelLongsword, defaultWootzLongsword,
                defaultIronSlayer, defaultCleanIronSlayer, defaultSteelSlayer, defaultWootzSlayer);

        for(ItemStack s : recipeList){
            setDefaultNBT(s);
        }

        genRecipesForList(recipeList, recipes);

    }

    static void setDefaultNBT(ItemStack stack){
        stack.getOrCreateSubCompound("tags");
        stack.getSubCompound("tags").setInteger("smite", 0);
        stack.getSubCompound("tags").setInteger("bane", 0);
        stack.getSubCompound("tags").setInteger("fire", 0);
        stack.getSubCompound("tags").setInteger("fortune", 0);
        stack.getSubCompound("tags").setInteger("leech", 0);
        stack.getSubCompound("tags").setInteger("sweeping", 0);
        stack.getSubCompound("tags").setInteger("sharpness", 0);
        stack.getSubCompound("tags").setBoolean("hot", false);
    }

    static CauldronRecipe genSmiteRecipe(ItemStack stack) {
        return new CauldronRecipe(
                5,
                new FluidStack(FluidRegistry.WATER, 1000),
                new FluidStack(PrimalAPI.Fluids.WASTE, 1000),
                RecipeHelper.getOreStack("dustSilver", 2),
                RecipeHelper.buildList(stack),
                stack,
                ItemStack.EMPTY).setRecipeName(ModInfo.MOD_ID, stack.getUnlocalizedName().toString().concat("smite"));
    }
    static CauldronRecipe genBaneRecipe(ItemStack stack) {
        return new CauldronRecipe(
                5,
                new FluidStack(FluidRegistry.WATER, 1000),
                new FluidStack(PrimalAPI.Fluids.WASTE, 1000),
                RecipeHelper.getOreStack("foodPoison", 2),
                RecipeHelper.buildList(stack),
                stack,
                ItemStack.EMPTY).setRecipeName(ModInfo.MOD_ID, stack.getUnlocalizedName().toString().concat("bane"));
    }

    static CauldronRecipe genFireRecipe(ItemStack stack) {
        return new CauldronRecipe(
                5,
                new FluidStack(FluidRegistry.WATER, 1000),
                new FluidStack(PrimalAPI.Fluids.WASTE, 1000),
                RecipeHelper.getOreStack("dustBlaze", 2),
                RecipeHelper.buildList(stack),
                stack,
                ItemStack.EMPTY).setRecipeName(ModInfo.MOD_ID, stack.getUnlocalizedName().toString().concat("fire"));
    }

    static CauldronRecipe genFortuneRecipe(ItemStack stack) {
        return new CauldronRecipe(
                5,
                new FluidStack(FluidRegistry.WATER, 1000),
                new FluidStack(PrimalAPI.Fluids.WASTE, 1000),
                RecipeHelper.getOreStack("gemLapis", 2),
                RecipeHelper.buildList(stack),
                stack,
                ItemStack.EMPTY).setRecipeName(ModInfo.MOD_ID, stack.getUnlocalizedName().toString().concat("fortune"));
    }

    /*static CauldronRecipe genLeechRecipe(ItemStack stack) {
        return new CauldronRecipe(
                5,
                new FluidStack(FluidRegistry.WATER, 1000),
                new FluidStack(PrimalAPI.Fluids.WASTE, 1000),
                RecipeHelper.getOreStack("dustWitheredBone", 1),
                RecipeHelper.buildList(stack),
                stack,
                ItemStack.EMPTY).setRecipeName(ModInfo.MOD_ID, stack.getUnlocalizedName().toString().concat("leech"));
    }*/

    static void genRecipesForList(List<ItemStack> list, IForgeRegistry<CauldronRecipe> recipes){
        for(ItemStack s : list){
            recipes.register(genSmiteRecipe(s));
            recipes.register(genBaneRecipe(s));
            recipes.register(genFireRecipe(s));
            recipes.register(genFortuneRecipe(s));
        }
    }

}