package nmd.primal.forgecraft.compat.jei.forge;

import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;
import nmd.primal.forgecraft.crafting.ForgeCrafting;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 9/17/18.
 */
public class ForgeRecipeHandler implements IRecipeWrapperFactory<ForgeCrafting> {
    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull ForgeCrafting recipe) {
        return new ForgeRecipeWrapper(recipe);
    }
}