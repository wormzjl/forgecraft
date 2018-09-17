package nmd.primal.forgecraft.compat.JEI.anvil;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.init.Items;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.crafting.AnvilCrafting;
import nmd.primal.forgecraft.init.ModItems;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mminaie on 9/16/18.
 */
public class AnvilRecipeWrapper implements IRecipeWrapper {

    protected final AnvilCrafting recipe;

    protected String[] input;
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

        for(int i =0; i < input.length; i++){
            ResourceLocation name = new ResourceLocation(input[i]);
            ingredients.setInput(ItemStack.class, ForgeRegistries.ITEMS.getValue(name));
        }
    }

    public Item getIngredient(int a){

        Item[] tempArray = new Item[25];
        for(int i =0; i < input.length; i++){
            ResourceLocation name = new ResourceLocation(input[i]);
            tempArray[i] = ForgeRegistries.ITEMS.getValue(name);
        }
        List<Item> stackList = Arrays.asList(tempArray);
        return stackList.get(a);
    }

}
