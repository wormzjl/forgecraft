package nmd.primal.forgecraft.compat.JEI.casting;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nmd.primal.forgecraft.crafting.CastingCrafting;

import javax.annotation.Nonnull;
import java.awt.*;

/**
 * Created by mminaie on 9/16/18.
 */
public class CastingRecipeWrapper implements IRecipeWrapper {

    protected final CastingCrafting recipe;

    protected Item[] input;
    protected ItemStack source;
    protected ItemStack output;

    public CastingRecipeWrapper(CastingCrafting recipe) {

        this.recipe = recipe;
        this.input = recipe.getInput();
        this.output = recipe.getOutput();
        this.source =recipe.getSource();
    }


    @Override
    public void getIngredients(IIngredients ingredients) {

        for(int i =0; i < 25; i++){
            //if(this.input[i] != new ItemStack(Items.AIR, 1) {
                ingredients.setInput(ItemStack.class, this.input[i]);
            //}
        }
        ingredients.setOutput(ItemStack.class, this.output);
    }

    public ItemStack getIngredient(int a){
        return new ItemStack(input[a], 1);
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
    {
        String tempString = new String("To an empty crucible add: " + recipe.getSource().getDisplayName() + ". For details reference the appropriate crucible recipe. Pick up the hot crucible with Stonetongs and right click your casting block.");
        minecraft.fontRenderer.drawSplitString(tempString, 97, 0, 150, Color.black.getRGB());
    }

}
