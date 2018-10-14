package nmd.primal.forgecraft.compat.jei;

import mezz.jei.api.*;
import mezz.jei.api.gui.ICraftingGridHelper;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import nmd.primal.forgecraft.compat.jei.anvil.AnvilRecipeCategory;
import nmd.primal.forgecraft.compat.jei.anvil.AnvilRecipeChecker;
import nmd.primal.forgecraft.compat.jei.anvil.AnvilRecipeHandler;
import nmd.primal.forgecraft.compat.jei.casting.CastingRecipeCategory;
import nmd.primal.forgecraft.compat.jei.casting.CastingRecipeChecker;
import nmd.primal.forgecraft.compat.jei.casting.CastingRecipeHandler;
import nmd.primal.forgecraft.compat.jei.crucible.CrucibleRecipeCategory;
import nmd.primal.forgecraft.compat.jei.crucible.CrucibleRecipeChecker;
import nmd.primal.forgecraft.compat.jei.crucible.CrucibleRecipeHandler;
import nmd.primal.forgecraft.compat.jei.forge.ForgeRecipeCategory;
import nmd.primal.forgecraft.compat.jei.forge.ForgeRecipeChecker;
import nmd.primal.forgecraft.compat.jei.forge.ForgeRecipeHandler;
import nmd.primal.forgecraft.compat.jei.workbench.WorkbenchRecipeCategory;
import nmd.primal.forgecraft.compat.jei.workbench.WorkbenchRecipeChecker;
import nmd.primal.forgecraft.compat.jei.workbench.WorkbenchRecipeHandler;
import nmd.primal.forgecraft.crafting.*;
import nmd.primal.forgecraft.init.ModBlocks;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 9/11/18.
 */
@JEIPlugin
public class ModJEI implements IModPlugin
{
    public static IJeiHelpers jeiHelper;
    public static ICraftingGridHelper craftingGridHelper;
    public static IRecipeRegistry recipeRegistry;
    public static IGuiHelper guiHelper;
    private static final int craftOutputSlot = 0;
    private static final int craftInputSlot1 = 1;

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry)
    {
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        final IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

        //
        //  Recipe Categories
        //
        registry.addRecipeCategories(new ForgeRecipeCategory(guiHelper));
        registry.addRecipeCategories(new CrucibleRecipeCategory(guiHelper));
        registry.addRecipeCategories(new AnvilRecipeCategory(guiHelper));
        registry.addRecipeCategories(new CastingRecipeCategory(guiHelper));
        registry.addRecipeCategories(new WorkbenchRecipeCategory(guiHelper));
    }

    @Override
    public void register(@Nonnull IModRegistry registry) {
        jeiHelper = registry.getJeiHelpers();
        guiHelper = jeiHelper.getGuiHelper();
        craftingGridHelper = guiHelper.createCraftingGridHelper(craftInputSlot1, craftOutputSlot);

        // ***************************************************************************** //
        //  Recipes
        // ***************************************************************************** //
        //
        //  Forging
        //
        registry.handleRecipes(ForgeCrafting.class, new ForgeRecipeHandler(), ForgeRecipeCategory.CATEGORY);
        registry.addRecipes(ForgeRecipeChecker.getRecipes(), ForgeRecipeCategory.CATEGORY);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.forge_brick), ForgeRecipeCategory.CATEGORY);
        //
        //  Crucible
        //
        registry.handleRecipes(CrucibleCrafting.class, new CrucibleRecipeHandler(), CrucibleRecipeCategory.CATEGORY);
        registry.addRecipes(CrucibleRecipeChecker.getRecipes(), CrucibleRecipeCategory.CATEGORY);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.nbtCrucible), CrucibleRecipeCategory.CATEGORY);
        //
        //  Anvil
        //
        registry.handleRecipes(AnvilCrafting.class, new AnvilRecipeHandler(), AnvilRecipeCategory.CATEGORY);
        registry.addRecipes(AnvilRecipeChecker.getRecipes(), AnvilRecipeCategory.CATEGORY);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.stoneanvil), AnvilRecipeCategory.CATEGORY);
        //
        //  Casting
        //
        registry.handleRecipes(CastingCrafting.class, new CastingRecipeHandler(), CastingRecipeCategory.CATEGORY);
        registry.addRecipes(CastingRecipeChecker.getRecipes(), CastingRecipeCategory.CATEGORY);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.castingform), CastingRecipeCategory.CATEGORY);

        //
        //  Workbench
        //
        registry.handleRecipes(WorkbenchCrafting.class, new WorkbenchRecipeHandler(), WorkbenchRecipeCategory.CATEGORY);
        registry.addRecipes(WorkbenchRecipeChecker.getRecipes(), WorkbenchRecipeCategory.CATEGORY);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.workbench), WorkbenchRecipeCategory.CATEGORY);



        // ***************************************************************************** //
        //  Info
        // ***************************************************************************** //
        //registry.addIngredientInfo(ItemStack.EMPTY, ItemStack.class, "jei.info.forgecraft.crucible");
        registry.addIngredientInfo(new ItemStack(ModBlocks.nbtCrucible, 1, OreDictionary.WILDCARD_VALUE), ItemStack.class, "jei.info.forgecraft.crucible");
        //registry.addIngredientInfo(new OreIngredient("oreIron"), OreIngredient.class, "jei.info.forgecraft.oreiron");
        registry.addIngredientInfo(new ItemStack(ModBlocks.castingform, 1, OreDictionary.WILDCARD_VALUE), ItemStack.class, "jei.info.forgecraft.casting");
        registry.addIngredientInfo(new ItemStack(ModBlocks.stoneanvil, 1, OreDictionary.WILDCARD_VALUE), ItemStack.class, "jei.info.forgecraft.anvil");


    }
}
