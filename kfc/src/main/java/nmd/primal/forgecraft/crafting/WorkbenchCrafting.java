package nmd.primal.forgecraft.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.registries.IForgeRegistry;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.core.common.recipes.AbstractRecipe;
import nmd.primal.forgecraft.ModInfo;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mminaie on 11/11/17.
 */
public class WorkbenchCrafting extends AbstractRecipe<WorkbenchCrafting> { //extends AbstractCrafting<CrucibleCrafting> {

    // ***************************************************************************** //
    //  Recipe Handler CrucibleHandler
    // ***************************************************************************** //

    public static final String RECIPE_PREFIX = "workbench";
    public static final IForgeRegistry<WorkbenchCrafting> REGISTRY = ModInfo.Registries.WORKBENCH_CRAFTING;

    public static Collection<WorkbenchCrafting> getRECIPES() {
        return RECIPES;
    }

    public static final Collection<WorkbenchCrafting> RECIPES = REGISTRY.getValuesCollection();

    private Ingredient toolPart;
    private Ingredient toolHead;
    private Ingredient toolPin;
    private Ingredient takeApart;
    private ItemStack output;
    private Ingredient craftingTool;

    public Ingredient getTakeApart() {
        return takeApart;
    }

    public void setTakeApart(Ingredient takeApart) {
        this.takeApart = takeApart;
    }

    public Ingredient getToolPart() {
        return toolPart;
    }

    public void setToolPart(Ingredient toolPart) {
        this.toolPart = toolPart;
    }

    public Ingredient getToolHead() {
        return toolHead;
    }

    public void setToolHead(Ingredient toolHead) {
        this.toolHead = toolHead;
    }

    public Ingredient getToolPin() {
        return toolPin;
    }

    public void setToolPin(Ingredient toolPin) {
        this.toolPin = toolPin;
    }

    public ItemStack getOutput() {
        return output;
    }

    public void setOutput(ItemStack output) {
        this.output = output;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public Ingredient getCraftingTool() {
        return craftingTool;
    }


    private List<Ingredient> ingredientList = new ArrayList<>();

    public WorkbenchCrafting(Ingredient i0, Ingredient i1, Ingredient i2, Ingredient i3 , Ingredient craftingTool, ItemStack output){
        super();
        this.toolPart = i0;
        this.toolHead = i1;
        this.toolPin = i2;
        this.takeApart = i3;
        this.output = output;
        this.craftingTool = craftingTool;
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
        ItemStack[] testArray = ingredient.getMatchingStacks();
        List<ItemStack> testList = RecipeHelper.buildList(testArray);
        if(testList.contains(stack)){
            return true;
        }
        return false;
    }

    public static boolean isRecipe(ItemStack i0, ItemStack i1, ItemStack i2, ItemStack i3, ItemStack cTool){
        for(WorkbenchCrafting recipe : RECIPES){
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
            if(cTool == null){
                cTool = ItemStack.EMPTY;
            }
            if(compare(recipe.toolPart, i0) &&
                    compare(recipe.toolHead, i1) &&
                    compare(recipe.toolPin, i2) &&
                    compare(recipe.takeApart, i3) &&
                    compare(recipe.craftingTool, cTool)){
                return true;
            }
        }
        return false;
    }

    public static WorkbenchCrafting getRecipe(ItemStack i0, ItemStack i1, ItemStack i2, ItemStack i3, ItemStack cTool){
        for(WorkbenchCrafting recipe : RECIPES){

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
            if(cTool == null){
                cTool = ItemStack.EMPTY;
            }
            if(recipe.toolPart.apply(i0) && recipe.toolHead.apply(i1) && recipe.toolPin.apply(i2) && recipe.takeApart.apply(i3) && recipe.craftingTool.apply(cTool) ){
                return recipe;
            }
        }
        return null;
    }
    /*public static boolean isValidIngredient(ItemStack checkStack){
        for(WorkbenchCrafting recipe : RECIPES) {
            if (recipe.ing0.apply(checkStack) ||
                    recipe.ing1.apply(checkStack) ||
                    recipe.ing2.apply(checkStack) ||
                    recipe.ing3.apply(checkStack) ||
                    recipe.ing4.apply(checkStack)) {
                return true;
            }
        }
        return false;
    }*/


    @Override
    public Collection<WorkbenchCrafting> getRecipes() {
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
    public static WorkbenchCrafting getRecipe(String recipe_name)
    {
        return REGISTRY.getValue(getFullRecipeName(RECIPE_PREFIX, recipe_name));
    }
}
