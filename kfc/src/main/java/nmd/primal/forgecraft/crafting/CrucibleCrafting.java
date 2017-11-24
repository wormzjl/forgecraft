package nmd.primal.forgecraft.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mminaie on 11/11/17.
 */
public class CrucibleCrafting {

    // ***************************************************************************** //
    //  Recipe Handler CrucibleHandler
    // ***************************************************************************** //

    private static ArrayList<CrucibleCrafting> crucibleCrafting = new ArrayList<>();

    private Ingredient ing0;
    private Ingredient ing1;
    private Ingredient ing2;
    private Ingredient ing3;
    private Ingredient ing4;

    private List<Ingredient> ingredientList;

    private ItemStack drops;


    public CrucibleCrafting(Ingredient i0, Ingredient i1, Ingredient i2, Ingredient i3, Ingredient i4, ItemStack output){

        this.ing0 = i0;
        this.ing1 = i1;
        this.ing2 = i2;
        this.ing3 = i3;
        this.ing4 = i4;
        this.ingredientList.add(0, i0);
        this.ingredientList.add(1, i1);
        this.ingredientList.add(2, i2);
        this.ingredientList.add(3, i3);
        this.ingredientList.add(4, i4);
        this.drops = output;
    }

    public static void addRecipe(Ingredient i0, Ingredient i1, Ingredient i2, Ingredient i3, Ingredient i4, ItemStack drop)
    {
        crucibleCrafting.add(new CrucibleCrafting(i0, i1, i2, i3, i4, drop));
    }

    public static boolean isRecipe(ItemStack i0, ItemStack i1, ItemStack i2, ItemStack i3, ItemStack i4){
        for(CrucibleCrafting recipe : crucibleCrafting){
            if(recipe.ing0.apply(i0) && recipe.ing1.apply(i1) && recipe.ing2.apply(i2) && recipe.ing3.apply(i3) && recipe.ing4.apply(i4) ){
                return true;
            }
        }
        return false;
    }

    public static CrucibleCrafting getRecipe(ItemStack i0, ItemStack i1, ItemStack i2, ItemStack i3, ItemStack i4){
        for(CrucibleCrafting recipe : crucibleCrafting){
            if(recipe.ing0.apply(i0) && recipe.ing1.apply(i1) && recipe.ing2.apply(i2) && recipe.ing3.apply(i3) && recipe.ing4.apply(i4) ){
                return recipe;
            }
        }
        return null;
    }

}
