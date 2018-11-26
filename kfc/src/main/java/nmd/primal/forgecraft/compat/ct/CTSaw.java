package nmd.primal.forgecraft.compat.ct;


import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.PrimalCore;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.blocks.machine.MachineSaw;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;
import nmd.primal.forgecraft.crafting.MachineSawCrafting;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.List;
import java.util.stream.Collectors;

@ZenClass("mods.forgecraft.MachineSaw")
@ModOnly(ModInfo.MOD_ID)
@ZenRegister
public class CTSaw {

    static
    {
        PrimalCore.LOGGER.info("Registering CraftTweaker: " + MachineSawCrafting.RECIPE_PREFIX);
    }

    @ZenMethod
    public static void addRecipe(IIngredient ing0,
                                 IIngredient output,
                                 String recipe_name)
    {
        CraftTweakerAPI.apply(new Add(ing0, output, recipe_name));
    }

    @ZenMethod
    public static void removeRecipe(String recipe_name)
    {
        CraftTweakerAPI.apply(new Remove(recipe_name));
    }

    @ZenMethod
    public static void removeAll()
    {
        CraftTweakerAPI.apply(new RemoveAll());
    }

    private static class Add implements IAction
    {
        private final String recipe_name;
        private final Ingredient ing0;
        private final List<ItemStack> output;
        private boolean isDisabled, isHidden;

        public Add(IIngredient I0, IIngredient output, String recipe_name)
        {

            ItemStack[] array0 = null;
            ItemStack[] emptyArray = new ItemStack[1];
            emptyArray[0] = ItemStack.EMPTY;

            if(I0 != null) {
                List<ItemStack> zeroIList = I0.getItems().stream().map(CraftTweakerMC::getItemStack).collect(Collectors.toList());
                array0 = zeroIList.stream().toArray(ItemStack[]::new);
            }
            if(I0 == null) {
                array0 = emptyArray;
            }

            this.recipe_name = recipe_name;
            this.ing0 = Ingredient.fromStacks(array0);
            this.output = RecipeHelper.getIIngredientStacks(output);
            this.isDisabled = false;
            this.isHidden = false;
        }

        @Override
        public void apply()
        {
            PrimalCore.LOGGER.info("Add CraftTweaker Recipe: " + this.recipe_name);
            MachineSawCrafting.REGISTRY.register(new MachineSawCrafting(
                    this.ing0,
                    this.output).setRecipeName(this.recipe_name));
        }

        @Override
        public String describe()
        {
            return "[" + ModInfo.MOD_NAME + "] Adding Crafting Tweaker recipe for: "  + MachineSawCrafting.RECIPE_PREFIX;
        }
    }


    private static class Remove implements IAction
    {
        private String recipe_name;

        public Remove(String recipe_name)
        {
            this.recipe_name = recipe_name;
        }

        @Override
        public void apply()
        {
            MachineSawCrafting recipe = MachineSawCrafting.getRecipe(recipe_name);
            if (recipe != null && !recipe.isHidden())
            {
                PrimalCore.LOGGER.info("Remove CraftTweaker Recipe: " + recipe_name);
                recipe.setDisabled(true);
            }
        }

        @Override
        public String describe()
        {
            return "[" + ModInfo.MOD_NAME + "] Removing Crafting Tweaker recipe for:" + MachineSawCrafting.RECIPE_PREFIX;
        }
    }

    private static class RemoveAll implements IAction
    {
        public RemoveAll() { }

        @Override
        public void apply()
        {
            for (MachineSawCrafting recipe : MachineSawCrafting.RECIPES)
            {
                if (!recipe.isHidden())
                    recipe.setDisabled(true);
            }
        }

        @Override
        public String describe()
        {
            return "[" + ModInfo.MOD_NAME + "] Removing Crafting Tweaker recipe for:" + MachineSawCrafting.RECIPE_PREFIX;
        }
    }
}

