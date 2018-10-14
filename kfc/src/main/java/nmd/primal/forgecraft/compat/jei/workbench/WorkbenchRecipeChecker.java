package nmd.primal.forgecraft.compat.jei.workbench;

import nmd.primal.forgecraft.crafting.WorkbenchCrafting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mminaie on 9/16/18.
 */
public class WorkbenchRecipeChecker {

    public static List<WorkbenchCrafting> getRecipes() {
        List<WorkbenchCrafting> recipes = new ArrayList<>();
        for (WorkbenchCrafting recipe : WorkbenchCrafting.getRECIPES()) {
            if(!recipe.isDisabled()) {
                if(!recipe.isHidden()) {
                    recipes.add(recipe);
                }
            }
        }
        return recipes;
    }
}
