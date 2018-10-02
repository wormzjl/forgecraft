package nmd.primal.forgecraft.compat.jei.forge;

import nmd.primal.forgecraft.crafting.ForgeCrafting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mminaie on 9/16/18.
 */
public class ForgeRecipeChecker {

    public static List<ForgeCrafting> getRecipes() {
        List<ForgeCrafting> recipes = new ArrayList<>();
        for (ForgeCrafting recipe : ForgeCrafting.getForgeRecipes()) {
            recipes.add(recipe);
        }
        return recipes;
    }
}
