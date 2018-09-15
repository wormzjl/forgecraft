package nmd.primal.forgecraft.compat.JEI.crucible;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.List;

/**
 * Created by mminaie on 9/13/18.
 */
public class CrucibleRecipeWrapper implements IRecipeWrapper
{
    protected final CrucibleCrafting recipe;

    //protected final List<Ingredient> ;
    protected final int cookTemp;
    protected final int cookTime;
    protected final int coolTime;

    protected final ItemStack dropsCooked;
    protected final ItemStack dropsRaw;

    protected Ingredient ing0;
    protected Ingredient ing1;
    protected Ingredient ing2;
    protected Ingredient ing3;
    protected Ingredient ing4;

    protected List crucibleCrafting;


    public CrucibleRecipeWrapper(CrucibleCrafting recipe)
    {
        this.recipe = recipe;
        this.cookTemp = recipe.getCookTemp();
        this.cookTime = recipe.getCookTime();
        this.coolTime = recipe.getCoolTime();

        this.dropsCooked = recipe.getDropsCooked();
        this.dropsRaw = recipe.getDropsRaw();

        this.ing0 = recipe.getIng0();
        this.ing1 = recipe.getIng1();
        this.ing2 = recipe.getIng2();
        this.ing3 = recipe.getIng3();
        this.ing4 = recipe.getIng4();

        this.crucibleCrafting = recipe.getIngredientList();
    }

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        ingredients.setInput(Ingredient.class, this.crucibleCrafting);
        //ingredients.setOutputs(ItemStack.class, this.dropsCooked);
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
    {
        minecraft.fontRenderer.drawString(String.valueOf(cookTime), 80, 48, Color.gray.getRGB());
        minecraft.fontRenderer.drawString(String.valueOf(cookTemp), 80, 38, Color.gray.getRGB());
    }
}