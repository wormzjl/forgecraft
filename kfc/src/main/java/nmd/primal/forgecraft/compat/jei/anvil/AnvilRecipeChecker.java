package nmd.primal.forgecraft.compat.jei.anvil;

import nmd.primal.forgecraft.crafting.AnvilCrafting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mminaie on 9/16/18.
 */
public class AnvilRecipeChecker {

    public static List<AnvilCrafting> getRecipes() {
        List<AnvilCrafting> recipes = new ArrayList<>();
        for (AnvilCrafting recipe : AnvilCrafting.getAnvilRecipes()) {
            recipes.add(recipe);
        }
        return recipes;
    }
}
