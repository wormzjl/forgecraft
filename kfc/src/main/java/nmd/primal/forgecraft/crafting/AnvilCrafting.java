package nmd.primal.forgecraft.crafting;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mminaie on 3/5/17.
 */
public class AnvilCrafting {

    // ***************************************************************************** //
    //  Recipe Handler AnvilCrafting
    // ***************************************************************************** //

    private static ArrayList<AnvilCrafting> anvilRecipes = new ArrayList<>();

    private String[] input = new String[25];

    private String upgradeType;

    private ItemStack output;

    public AnvilCrafting(String[] input, ItemStack output, String upgrade){

        this.input = input;
        this.output = output;
        this.upgradeType = upgrade;

    }

    // ***************************************************************************** //
    //  Recipe Methods
    // ***************************************************************************** //

    public static void addRecipe(String[] input, ItemStack output, String upgrade)
    {
        anvilRecipes.add(new AnvilCrafting(input, output, upgrade));
    }

    public static boolean isRecipe(String[] array)
    {
        for(AnvilCrafting recipe : anvilRecipes) {
            if (Arrays.equals(array, recipe.input))

                return true;
        }
        return false;
    }

    public static AnvilCrafting getRecipe(String[] array)
    {
        for(AnvilCrafting recipe : anvilRecipes) {
            if (Arrays.equals(array, recipe.input))
                return recipe;
        }
        return null;
    }

    public String[] getInput() {return this.input;}

    public ItemStack getOutput() {return this.output;}

    public String getUpgrade() {return this.upgradeType; }

}
