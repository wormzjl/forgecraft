package nmd.primal.forgecraft.compat.jei.workbench;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import nmd.primal.forgecraft.crafting.WorkbenchCrafting;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 9/16/18.
 */
public class WorkbenchRecipeWrapper implements IRecipeWrapper {

    protected final WorkbenchCrafting recipe;

    protected Ingredient toolPart;
    protected Ingredient toolHead;
    protected Ingredient toolPin;
    protected Ingredient takeApart;
    protected ItemStack output;

    public WorkbenchRecipeWrapper(WorkbenchCrafting recipe) {

        this.recipe = recipe;
        this.toolPart = recipe.getToolPart();
        this.toolHead = recipe.getToolHead();
        this.toolPin = recipe.getToolPin();
        this.takeApart = recipe.getTakeApart();
        this.output = recipe.getOutput();
    }


    @Override
    public void getIngredients(IIngredients ingredients) {

        ingredients.setInput(ItemStack.class, this.toolPart);
        ingredients.setInput(ItemStack.class, this.toolHead);
        ingredients.setInput(ItemStack.class, this.toolPin);
        ingredients.setInput(ItemStack.class, this.takeApart);
        ingredients.setOutput(ItemStack.class, this.output);
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
    {
        //String tempString = new String("To an empty crucible add: " + recipe.getSource().getDisplayName() + ". For details reference the appropriate crucible recipe. Pick up the hot crucible with Stonetongs and right click your casting block.");
        //minecraft.fontRenderer.drawSplitString(tempString, 97, 0, 150, Color.black.getRGB());
        //minecraft.fontRenderer.drawString(String.valueOf(recipe.getHeatThreshold()  + "\u00b0"), 24, 36, Color.red.getRGB());
        //minecraft.fontRenderer.drawString(String.valueOf(recipe.getIdealTime()), 26, 13, Color.green.getRGB());
    }

}
