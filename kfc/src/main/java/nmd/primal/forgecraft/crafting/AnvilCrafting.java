package nmd.primal.forgecraft.crafting;

import net.minecraft.item.Item;
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

    public static ArrayList<AnvilCrafting> getAnvilRecipes() {
        return anvilRecipes;
    }

    private static ArrayList<AnvilCrafting> anvilRecipes = new ArrayList<>();

    private ItemStack[] input = new ItemStack[25];

    private String upgradeType;

    private ItemStack output;

    public AnvilCrafting(ItemStack[] input, ItemStack output, String upgrade){

        this.input = input;
        this.output = output;
        this.upgradeType = upgrade;

    }

    // ***************************************************************************** //
    //  Recipe Methods
    // ***************************************************************************** //

    public static void addRecipe(ItemStack[] input, ItemStack output, String upgrade)
    {
        anvilRecipes.add(new AnvilCrafting(input, output, upgrade));
    }

    public static boolean isRecipe(ItemStack[] array)
    {
        for(AnvilCrafting recipe : anvilRecipes) {
            if (Arrays.equals(array, recipe.input))
                return true;
        }
        return false;
    }

    public static AnvilCrafting getRecipe(ItemStack[] array)
    {
        for(AnvilCrafting recipe : anvilRecipes) {
            if(checkArrays(recipe.getInput(), array)){
                return recipe;
            }
        }
        return null;
    }

    public static boolean checkArrays (ItemStack[] leftArray, ItemStack[] rightArray){
        int a =0;
        for(int i=0; i<leftArray.length; i++){
            if( (leftArray[i].isEmpty() && rightArray[i].isEmpty()) ||
                    ((leftArray[i].isItemEqualIgnoreDurability(rightArray[i]))) ) {
                a++;
            }
            if(a == 25){
                return true;
            }
        }
        return false;
    }

    public ItemStack[] getInput() {return this.input;}

    public ItemStack getOutput() {return this.output.copy();}

    public String getUpgrade() {return this.upgradeType; }

}
