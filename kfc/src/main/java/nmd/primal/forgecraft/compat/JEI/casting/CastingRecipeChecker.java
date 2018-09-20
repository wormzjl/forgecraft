package nmd.primal.forgecraft.compat.JEI.casting;

import nmd.primal.forgecraft.crafting.AnvilCrafting;
import nmd.primal.forgecraft.crafting.CastingCrafting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mminaie on 9/16/18.
 */
public class CastingRecipeChecker {

    public static List<CastingCrafting> getRecipes() {
        List<CastingCrafting> recipes = new ArrayList<>();
        for (CastingCrafting recipe : CastingCrafting.getCastingRecipes()) {
            recipes.add(recipe);
        }
        return recipes;
    }
}
