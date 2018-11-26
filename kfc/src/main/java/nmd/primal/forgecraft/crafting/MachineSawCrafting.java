package nmd.primal.forgecraft.crafting;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
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
public class MachineSawCrafting extends AbstractRecipe<MachineSawCrafting> { //extends AbstractCrafting<CrucibleCrafting> {

    // ***************************************************************************** //
    //  Recipe Handler CrucibleHandler
    // ***************************************************************************** //

    public static final String RECIPE_PREFIX = "machine_saw";
    public static final IForgeRegistry<MachineSawCrafting> REGISTRY = ModInfo.Registries.MACHINE_SAW_CRAFTING;

    public static Collection<MachineSawCrafting> getRECIPES() {
        return RECIPES;
    }

    public static final Collection<MachineSawCrafting> RECIPES = REGISTRY.getValuesCollection();

    private Ingredient input;
    private List<ItemStack> output;

    public Ingredient getInput() {
        return input;
    }
    public void setInput(Ingredient input) {
        this.input = input;
    }

    public List<ItemStack> getOutput() {
        return output;
    }
    public void setOutput(List<ItemStack> output) {
        this.output = output;
    }

    public MachineSawCrafting(Ingredient input, List<ItemStack> output){
        super();
        this.input = input;
        this.output = output;
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

    public boolean isRecipe(ItemStack input){
        for(MachineSawCrafting recipe : RECIPES){
            if(input == null){
                input = ItemStack.EMPTY;
            }
            if(compare(recipe.input, input)){
                return true;
            }
        }
        return false;
    }

    public static MachineSawCrafting getRecipe(ItemStack input){
        for(MachineSawCrafting recipe : RECIPES){
            if(input == null){
                input = ItemStack.EMPTY;
            }
            if(recipe.input.apply(input)){
                return recipe;
            }
        }
        return null;
    }

    @Override
    public Collection<MachineSawCrafting> getRecipes() {
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
    public static MachineSawCrafting getRecipe(String recipe_name)
    {
        return REGISTRY.getValue(getFullRecipeName(RECIPE_PREFIX, recipe_name));
    }
}
