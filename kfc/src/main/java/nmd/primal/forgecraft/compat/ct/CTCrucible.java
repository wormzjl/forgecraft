package nmd.primal.forgecraft.compat.ct;


import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import nmd.primal.core.common.PrimalCore;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.List;
import java.util.stream.Collectors;

@ZenClass("mods.forgecraft.NBTCrucible")
@ModOnly(ModInfo.MOD_ID)
@ZenRegister
public class CTCrucible {



    static
    {
        PrimalCore.LOGGER.info("Registering CraftTweaker: " + CrucibleCrafting.RECIPE_PREFIX);
    }

    @ZenMethod
    public static void addRecipe(IIngredient ing0,
                                 IIngredient ing1,
                                 IIngredient ing2,
                                 IIngredient ing3,
                                 IIngredient ing4,
                                 IItemStack dropsRaw,
                                 IItemStack dropsCooked,
                                 int cookTemp,
                                 int cookTime,
                                 int coolTime,
                                 String recipe_name)
    {
        CraftTweakerAPI.apply(new Add( ing0,
                ing1,
                ing2,
                ing3,
                ing4,
                (ItemStack) dropsRaw.getInternal(),
                (ItemStack) dropsCooked.getInternal(),
                cookTemp, cookTime, coolTime, recipe_name) );
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

        public Add(IIngredient I0, IIngredient I1, IIngredient I2, IIngredient I3, IIngredient I4, ItemStack dropsRaw, ItemStack dropsCooked, int cookTemp, int cookTime, int coolTime, String recipe_name)
        {

            ItemStack[] array0 = null;
            ItemStack[] array1 = null;
            ItemStack[] array2 = null;
            ItemStack[] array3 = null;
            ItemStack[] array4 = null;
            ItemStack[] emptyArray = new ItemStack[1];
            emptyArray[0] = ItemStack.EMPTY;

            if(I0 != null) {
                Ingredient temp0 = null;
                List<ItemStack> zeroIList = I0.getItems().stream().map(CraftTweakerMC::getItemStack).collect(Collectors.toList());
                array0 = zeroIList.stream().toArray(ItemStack[]::new);
            }
            if(I0 == null) {
                array0 = emptyArray;
            }

            if(I1 != null) {
                Ingredient temp1 = null;
                List<ItemStack> oneIList = I1.getItems().stream().map(CraftTweakerMC::getItemStack).collect(Collectors.toList());
                array1 = oneIList.stream().toArray(ItemStack[]::new);
            }
            if(I1 == null) {
                array1 = emptyArray;
            }

            if(I2 != null) {
                Ingredient temp2 = null;
                List<ItemStack> twoIList = I2.getItems().stream().map(CraftTweakerMC::getItemStack).collect(Collectors.toList());
                array2 = twoIList.stream().toArray(ItemStack[]::new);
            }
            if(I2 == null) {
                array2 = emptyArray;
            }

            if(I3 != null) {
                Ingredient temp3 = null;
                List<ItemStack> threeIList = I3.getItems().stream().map(CraftTweakerMC::getItemStack).collect(Collectors.toList());
                array3 = threeIList.stream().toArray(ItemStack[]::new);
            }
            if(I3 == null) {
                array3 = emptyArray;
            }

            if(I4 != null) {
                Ingredient temp4 = null;
                List<ItemStack> fourIList = I4.getItems().stream().map(CraftTweakerMC::getItemStack).collect(Collectors.toList());
                array4 = fourIList.stream().toArray(ItemStack[]::new);
            }
            if(I4 == null) {
                array4 = emptyArray;
            }

            this.recipe_name = recipe_name;
            this.cookTemp = cookTemp;
            this.cookTime = cookTime;
            this.coolTime = coolTime;
            this.ing0 = Ingredient.fromStacks(array0);
            this.ing1 = Ingredient.fromStacks(array1);
            this.ing2 = Ingredient.fromStacks(array2);
            this.ing3 = Ingredient.fromStacks(array3);
            this.ing4 = Ingredient.fromStacks(array4);
            this.dropsCooked = dropsCooked;
            this.dropsRaw = dropsRaw;
            this.isDisabled = false;
            this.isHidden = false;
        }

        @Override
        public void apply()
        {
            PrimalCore.LOGGER.info("Add CraftTweaker Recipe: " + this.recipe_name);
            CrucibleCrafting.REGISTRY.register(new CrucibleCrafting(
                    this.ing0,
                    this.ing1,
                    this.ing2,
                    this.ing3,
                    this.ing4,
                    this.dropsRaw,
                    this.dropsCooked,
                    this.cookTemp,
                    this.cookTime,
                    this.coolTime).setRecipeName(this.recipe_name));
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
            for (CrucibleCrafting recipe : CrucibleCrafting.RECIPES)
            {
                if (!recipe.isHidden())
                    recipe.setDisabled(true);
            }
        }

        @Override
        public String describe()
        {
            return "[" + ModInfo.MOD_NAME + "] Removing Crafting Tweaker recipe for:" + CrucibleCrafting.RECIPE_PREFIX;
        }
    }
}

