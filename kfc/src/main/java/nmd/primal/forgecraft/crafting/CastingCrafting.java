package nmd.primal.forgecraft.crafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mminaie on 6/22/17.
 */
public class CastingCrafting {

    // ***************************************************************************** //
    //  Recipe Handler AnvilCrafting
    // ***************************************************************************** //

    private static ArrayList<CastingCrafting> castingRecipes = new ArrayList<>();

    private Item[] input = new Item[25];

    private ItemStack output;

    public CastingCrafting(Item[] input, ItemStack output){

        this.input = input;
        this.output = output;

    }

    // ***************************************************************************** //
    //  Recipe Methods
    // ***************************************************************************** //

    public static void addRecipe(Item[] input, ItemStack output)
    {
        castingRecipes.add(new CastingCrafting(input, output));
    }

    public static boolean isRecipe(Item[] array)
    {
        for(CastingCrafting recipe : castingRecipes) {
            if (Arrays.equals(array, recipe.input))

                return true;
        }
        return false;
    }

    public static CastingCrafting getRecipe(Item[] array)
    {
        for(CastingCrafting recipe : castingRecipes) {
            if (Arrays.equals(array, recipe.input))
                return recipe;
        }
        return null;
    }

    public Item[] getInput() {return this.input;}

    public ItemStack getOutput() {return this.output;}

}