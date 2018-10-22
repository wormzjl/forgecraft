package nmd.primal.forgecraft.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.registries.IForgeRegistry;
import nmd.primal.core.common.recipes.AbstractRecipe;
import nmd.primal.forgecraft.ModInfo;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mminaie on 11/11/17.
 */
public class CrucibleCrafting extends AbstractRecipe<CrucibleCrafting> { //extends AbstractCrafting<CrucibleCrafting> {

    // ***************************************************************************** //
    //  Recipe Handler CrucibleHandler
    // ***************************************************************************** //

    public static final String RECIPE_PREFIX = "crucible";
    public static final IForgeRegistry<CrucibleCrafting> REGISTRY = ModInfo.Registries.CRUCIBLE_CRAFTING;

    public static Collection<CrucibleCrafting> getRECIPES() {
        return RECIPES;
    }

    public static final Collection<CrucibleCrafting> RECIPES = REGISTRY.getValuesCollection();

    //public static ArrayList<CrucibleCrafting> getCrucibleCrafting() {
        //return crucibleCrafting;
    //}

    //private static ArrayList<CrucibleCrafting> crucibleCrafting = new ArrayList<>();

    private int cookTemp;
    private int cookTime;
    private int coolTime;

    public Ingredient getIng0() {
        return ing0;
    }

    public void setIng0(Ingredient ing0) {
        this.ing0 = ing0;
    }

    public Ingredient getIng1() {
        return ing1;
    }

    public void setIng1(Ingredient ing1) {
        this.ing1 = ing1;
    }

    public Ingredient getIng2() {
        return ing2;
    }

    public void setIng2(Ingredient ing2) {
        this.ing2 = ing2;
    }

    public Ingredient getIng3() {
        return ing3;
    }

    public void setIng3(Ingredient ing3) {
        this.ing3 = ing3;
    }

    public Ingredient getIng4() {
        return ing4;
    }

    public void setIng4(Ingredient ing4) {
        this.ing4 = ing4;
    }

    private Ingredient ing0;
    private Ingredient ing1;
    private Ingredient ing2;
    private Ingredient ing3;
    private Ingredient ing4;

    private ItemStack dropsCooked;
    private ItemStack dropsRaw;

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    private List<Ingredient> ingredientList = new ArrayList<>();

    public CrucibleCrafting(Ingredient i0, Ingredient i1, Ingredient i2, Ingredient i3, Ingredient i4,
                            ItemStack outputRaw, ItemStack outputCooked,
                            Integer temp, Integer cookTime, Integer coolTime){
        super();
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
        this.dropsRaw = outputRaw;
        this.dropsCooked = outputCooked;
        this.cookTemp = temp;
        this.cookTime = cookTime;
        this.coolTime = coolTime;
    }

    public static boolean compare(Ingredient ingredient, ItemStack stack){
        if(stack == null){
            stack = new ItemStack(Items.AIR, 1);
        }
        if(ingredient == null && stack.isEmpty()) {
            return true;
        }

        if (ingredient.test(ItemStack.EMPTY)) {
            if (stack.isEmpty()) {
                return true;
            }
        }

        if(ingredient.apply(stack)){
            return true;
        }

        return false;
    }

    public static boolean isRecipe(ItemStack i0, ItemStack i1, ItemStack i2, ItemStack i3, ItemStack i4){
        for(CrucibleCrafting recipe : RECIPES){
            if(i0 == null){
                i0 = ItemStack.EMPTY;
            }
            if(i1 == null){
                i1 = ItemStack.EMPTY;
            }
            if(i2 == null){
                i2 = ItemStack.EMPTY;
            }
            if(i3 == null){
                i3 = ItemStack.EMPTY;
            }
            if(i4 == null){
                i4 = ItemStack.EMPTY;
            }
            if(compare(recipe.ing0, i0) &&
                    compare(recipe.ing1, i1) &&
                    compare(recipe.ing2, i2) &&
                    compare(recipe.ing3, i3) &&
                    compare(recipe.ing4, i4) ){
                return true;
            }
        }
        return false;
    }

    public static CrucibleCrafting getRecipe(ItemStack i0, ItemStack i1, ItemStack i2, ItemStack i3, ItemStack i4){
        for(CrucibleCrafting recipe : RECIPES){

            if(i0 == null){
                i0 = ItemStack.EMPTY;
            }
            if(i1 == null){
                i1 = ItemStack.EMPTY;
            }
            if(i2 == null){
                i2 = ItemStack.EMPTY;
            }
            if(i3 == null){
                i3 = ItemStack.EMPTY;
            }
            if(i4 == null){
                i4 = ItemStack.EMPTY;
            }

            if(recipe.ing0.apply(i0) && recipe.ing1.apply(i1) && recipe.ing2.apply(i2) && recipe.ing3.apply(i3) && recipe.ing4.apply(i4) ){
                return recipe;
            }
        }
        return null;
    }
    public static boolean isValidIngredient(ItemStack checkStack){
        for(CrucibleCrafting recipe : RECIPES) {
            if (recipe.ing0.apply(checkStack) ||
                    recipe.ing1.apply(checkStack) ||
                    recipe.ing2.apply(checkStack) ||
                    recipe.ing3.apply(checkStack) ||
                    recipe.ing4.apply(checkStack)) {
                return true;
            }
        }
        return false;
    }

    public int getCookTemp() {
        return cookTemp;
    }

    public int getCookTime() {
        return cookTime;
    }

    public int getCoolTime() {
        return coolTime;
    }

    public ItemStack getDropsCooked() {
        return dropsCooked;
    }

    public ItemStack getDropsRaw() {
        return dropsRaw;
    }




    @Override
    public Collection<CrucibleCrafting> getRecipes() {
        return RECIPES;
    }

    @Override
    public String getRecipePrefix() {
        return RECIPE_PREFIX;
    }

    /**
     * Shim for getting a recipe directly from correctly formatted name
     * @param recipe_name basic recipe name, no prefix or mod id
     * @return Recipe object
     */
    @Nullable
    public static CrucibleCrafting getRecipe(String recipe_name)
    {
        return REGISTRY.getValue(getFullRecipeName(RECIPE_PREFIX, recipe_name));
    }
}
