package nmd.primal.forgecraft.crafting;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mminaie on 6/22/17.
 */
public class CastingformCrafting {

    // ***************************************************************************** //
    //  Recipe Handler AnvilCrafting
    // ***************************************************************************** //

    private static ArrayList<CastingformCrafting> castingRecipes = new ArrayList<>();

    private String[] input = new String[25];

    private ItemStack output;

    public CastingformCrafting(String[] input, ItemStack output, String upgrade){

        this.input = input;
        this.output = output;

    }

    // ***************************************************************************** //
    //  Recipe Methods
    // ***************************************************************************** //

    public static void addRecipe(String[] input, ItemStack output, String upgrade)
    {
        castingRecipes.add(new CastingformCrafting(input, output, upgrade));
    }

    public static boolean isRecipe(String[] array)
    {
        for(CastingformCrafting recipe : castingRecipes) {
            if (Arrays.equals(array, recipe.input))

                return true;
        }
        return false;
    }

    public static CastingformCrafting getRecipe(String[] array)
    {
        for(CastingformCrafting recipe : castingRecipes) {
            if (Arrays.equals(array, recipe.input))
                return recipe;
        }
        return null;
    }

    public String[] getInput() {return this.input;}

    public ItemStack getOutput() {return this.output;}

}