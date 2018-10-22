package nmd.primal.forgecraft.compat.jei.casting;

import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;
import nmd.primal.forgecraft.crafting.CastingCrafting;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 9/17/18.
 */
public class CastingRecipeHandler implements IRecipeWrapperFactory<CastingCrafting> {
    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull CastingCrafting recipe) {
        return new CastingRecipeWrapper(recipe);
    }
}