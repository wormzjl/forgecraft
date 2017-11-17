package nmd.primal.forgecraft.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.oredict.OreDictionary;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.recipes.RecipeHandler;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;

import java.util.*;

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


    public CrucibleCrafting(Ingredient i0, Ingredient i1, Ingredient i2, Ingredient i3, Ingredient i4){

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
    }

    public static void addRecipe(Ingredient i0, Ingredient i1, Ingredient i2, Ingredient i3, Ingredient i4)
    {
        crucibleCrafting.add(new CrucibleCrafting(i0, i1, i2, i3, i4));
    }



//CustomIngredient(String ore, ItemStack... stacks)


    /*private Ingredient ingredient;


    public CrucibleCrafting(Ingredient input){
        this.ingredient = input;
    }

    public static void addIngredient(Ingredient input){
        crucibleChecking.add(new CrucibleCrafting(input));
    }*/



}
