package nmd.primal.forgecraft.compat.JEI.anvil;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.crafting.AnvilCrafting;
import nmd.primal.forgecraft.init.ModItems;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mminaie on 9/16/18.
 */
public class AnvilRecipeWrapper implements IRecipeWrapper {

    protected final AnvilCrafting recipe;

    protected ItemStack[] input;
    protected String upgradeType;
    protected ItemStack output;

    public AnvilRecipeWrapper(AnvilCrafting recipe) {

        this.recipe = recipe;
        this.input = recipe.getInput();
        this.upgradeType = recipe.getUpgrade();
        this.output = recipe.getOutput();

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
        return input[a];
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
    {
        //minecraft.fontRenderer.drawString(recipe.getDropsCooked().getDisplayName() + " Recipe", 20, 5, Color.black.getRGB());
    }

}
