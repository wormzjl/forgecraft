package nmd.primal.forgecraft.compat.JEI.forge;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nmd.primal.forgecraft.crafting.ForgeCrafting;

import javax.annotation.Nonnull;
import java.awt.*;

/**
 * Created by mminaie on 9/16/18.
 */
public class ForgeRecipeWrapper implements IRecipeWrapper {

    protected final ForgeCrafting recipe;

    protected Item input;
    protected ItemStack output;
    protected int heat_threshold;
    protected int ideal_time;
    protected int cooldown;

    public ForgeRecipeWrapper(ForgeCrafting recipe) {

        this.recipe = recipe;
        this.input = recipe.getInput();
        this.output = recipe.getOutput();
        this.heat_threshold = recipe.getHeatThreshold();
        this.ideal_time = recipe.getIdealTime();
        this.cooldown = recipe.getCooldown();
    }


    @Override
    public void getIngredients(IIngredients ingredients) {

        ingredients.setInput(ItemStack.class, this.input);
        ingredients.setOutput(ItemStack.class, this.output);
    }

    public ItemStack getIngredient(){
        return new ItemStack(this.input, 1);
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
    {
        //String tempString = new String("To an empty crucible add: " + recipe.getSource().getDisplayName() + ". For details reference the appropriate crucible recipe. Pick up the hot crucible with Stonetongs and right click your casting block.");
        //minecraft.fontRenderer.drawSplitString(tempString, 97, 0, 150, Color.black.getRGB());
        minecraft.fontRenderer.drawString(String.valueOf(recipe.getHeatThreshold()  + "\u00b0"), 24, 36, Color.red.getRGB());
        minecraft.fontRenderer.drawString(String.valueOf(recipe.getIdealTime()), 26, 13, Color.green.getRGB());
    }

}
