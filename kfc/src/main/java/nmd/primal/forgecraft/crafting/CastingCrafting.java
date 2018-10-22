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

    public ItemStack getSource() {
        return source;
    }

    private ItemStack source;


    public CastingCrafting(ItemStack source, Item[] input, ItemStack output){

        this.input = input;
        this.output = output;
        this.source = source;
    }

    // ***************************************************************************** //
    //  Recipe Methods
    // ***************************************************************************** //

    public static void addRecipe(ItemStack source, Item[] input, ItemStack output)
    {
        castingRecipes.add(new CastingCrafting(source, input, output));
    }

    public static ArrayList<CastingCrafting> getCastingRecipes() {
        return castingRecipes;
    }

    public static boolean isRecipe(Item[] array)
    {
        for(CastingCrafting recipe : castingRecipes) {
            if (Arrays.equals(array, recipe.input))

                return true;
        }
        return false;
    }

    public static CastingCrafting getRecipe(ItemStack source, Item[] array)
    {
        for(CastingCrafting recipe : castingRecipes) {
            if (source.getItem() == recipe.getSource().getItem() ) {
                if (Arrays.equals(array, recipe.input))
                    return recipe;
            }
        }
        return null;
    }

    public Item[] getInput() {return this.input;}

    public ItemStack getOutput() {return this.output;}

}