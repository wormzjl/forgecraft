package nmd.primal.forgecraft.compat.CT;


import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import nmd.primal.core.common.PrimalCore;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.List;

@ZenClass("mods.primal.NBTCrucible")
@ModOnly(ModInfo.MOD_ID)
@ZenRegister
public class CTCrucible {

    static
    {
        PrimalCore.LOGGER.info("Registering CraftTweaker: " + CrucibleCrafting.RECIPE_PREFIX);
    }

    @ZenMethod
    public static void addRecipe(String recipe_name,
                                 int cookTemp,
                                 int cookTime,
                                 int coolTime,
                                 Ingredient ing0,
                                 Ingredient ing1,
                                 Ingredient ing2,
                                 Ingredient ing3,
                                 Ingredient ing4,
                                 ItemStack dropsCooked,
                                 ItemStack dropsRaw)
    {
        CraftTweakerAPI.apply(new Add(recipe_name, cookTemp, cookTime, coolTime, ing0, ing1, ing2, ing3, ing4, dropsCooked, dropsRaw) );
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
        private final int cookTemp;
        private final int cookTime;
        private final int coolTime;
        private final Ingredient ing0, ing1, ing2, ing3, ing4;
        private final ItemStack dropsCooked;
        private final ItemStack dropsRaw;
        private boolean isDisabled, isHidden;

        //private final List<ItemStack> ingredients;
        //private final ItemStack output;
        //private final int cook_time;
        //private boolean is_disabled, is_hidden;

        public Add(String recipe_name, int cookTemp, int cookTime, int coolTime, Ingredient ing0, Ingredient ing1, Ingredient ing2, Ingredient ing3, Ingredient ing4,ItemStack dropsCooked, ItemStack dropsRaw)
        {
            this.recipe_name = recipe_name;
            this.cookTemp = cookTemp;
            this.cookTime = cookTime;
            this.coolTime = coolTime;
            this.ing0 = ing0;
            this.ing1 = ing1;
            this.ing2 = ing2;
            this.ing3 = ing3;
            this.ing4 =ing4;
            this.dropsCooked = dropsCooked
            this.dropsRaw = dropsRaw;
            this.isDisabled = false;
            this.isHidden = false;
        }

        @Override
        public void apply()
        {
            PrimalCore.LOGGER.info("Add CraftTweaker Recipe: " + this.recipe_name);
            CrucibleCrafting.REGISTRY.register(new CrucibleCrafting(this.cook_time, this.ingredients, this.output).setRecipeName(this.recipe_name));
        }

        @Override
        public String describe()
        {
            return "[" + ModInfo.MOD_NAME + "] Adding Crafting Tweaker recipe for: "  + CrucibleCrafting.RECIPE_PREFIX;
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
            CrucibleCrafting recipe = CrucibleCrafting.getRecipe(recipe_name);
            if (recipe != null && !recipe.isHidden())
            {
                PrimalCore.LOGGER.info("Remove CraftTweaker Recipe: " + recipe_name);
                recipe.setDisabled(true);
            }
        }

        @Override
        public String describe()
        {
            return "[" + ModInfo.MOD_NAME + "] Removing Crafting Tweaker recipe for:" + CrucibleCrafting.RECIPE_PREFIX;
        }
    }

    private static class RemoveAll implements IAction
    {
        public RemoveAll() { }

        @Override
        public void apply()
        {
            for (HibachiRecipe recipe : HibachiRecipe.RECIPES)
            {
                if (!recipe.isHidden())
                    recipe.setDisabled(true);
            }
        }

        @Override
        public String describe()
        {
            return "[" + ModInfo.MOD_NAME + "] Removing Crafting Tweaker recipe for:" + HibachiRecipe.RECIPE_PREFIX;
        }
    }
}

}
