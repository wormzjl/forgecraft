package nmd.primal.forgecraft.compat.jei.anvil;

import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;
import nmd.primal.forgecraft.crafting.AnvilCrafting;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 9/17/18.
 */
public class AnvilRecipeHandler  implements IRecipeWrapperFactory<AnvilCrafting> {
    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull AnvilCrafting recipe) {
        return new AnvilRecipeWrapper(recipe);
    }
}