package nmd.primal.forgecraft.compat.jei.crucible;

import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 9/13/18.
 */
public class CrucibleRecipeHandler implements IRecipeWrapperFactory<CrucibleCrafting>
{
    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull CrucibleCrafting recipe)
    {
        return new CrucibleRecipeWrapper(recipe);
    }
}