package nmd.primal.forgecraft.compat.jei.crucible;

import nmd.primal.forgecraft.crafting.CrucibleCrafting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mminaie on 9/13/18.
 */
public class CrucibleRecipeChecker {

    public static List<CrucibleCrafting> getRecipes() {
        List<CrucibleCrafting> recipes = new ArrayList<>();
        for (CrucibleCrafting recipe : CrucibleCrafting.getRECIPES()) {
            if(!recipe.isDisabled()) {
                if(!recipe.isHidden()) {
                    recipes.add(recipe);
                }
            }
        }
        return recipes;
    }
}
