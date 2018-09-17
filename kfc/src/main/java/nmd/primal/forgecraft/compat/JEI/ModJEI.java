package nmd.primal.forgecraft.compat.JEI;

import mezz.jei.api.*;
import mezz.jei.api.gui.ICraftingGridHelper;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import nmd.primal.forgecraft.compat.JEI.crucible.CrucibleRecipeCategory;
import nmd.primal.forgecraft.compat.JEI.crucible.CrucibleRecipeChecker;
import nmd.primal.forgecraft.compat.JEI.crucible.CrucibleRecipeHandler;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;
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
        registry.addRecipeCategories(new CrucibleRecipeCategory(guiHelper));
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
        //  Cauldron
        //
        registry.handleRecipes(CrucibleCrafting.class, new CrucibleRecipeHandler(), CrucibleRecipeCategory.CATEGORY);
        registry.addRecipes(CrucibleRecipeChecker.getRecipes(), CrucibleRecipeCategory.CATEGORY);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.nbtCrucible), CrucibleRecipeCategory.CATEGORY);

        // ***************************************************************************** //
        //  Info
        // ***************************************************************************** //
        registry.addIngredientInfo(ItemStack.EMPTY, ItemStack.class, "jei.info.forgecraft.crucible");
        registry.addIngredientInfo(new ItemStack(ModBlocks.nbtCrucible, 1, OreDictionary.WILDCARD_VALUE), ItemStack.class, "jei.info.forgecraft.crucible");
        registry.addIngredientInfo(new OreIngredient("oreIron"), OreIngredient.class, "jei.info.forgecraft.oreiron");
    }
}
