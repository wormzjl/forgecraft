package nmd.primal.forgecraft.compat.jei.workbench;

import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;
import nmd.primal.forgecraft.crafting.WorkbenchCrafting;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 9/17/18.
 */
public class WorkbenchRecipeHandler implements IRecipeWrapperFactory<WorkbenchCrafting> {
    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull WorkbenchCrafting recipe) {
        return new WorkbenchRecipeWrapper(recipe);
    }
}