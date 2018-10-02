package nmd.primal.forgecraft.compat.ct;


import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.item.IngredientStack;
import crafttweaker.api.oredict.IOreDictEntry;
import crafttweaker.api.oredict.IngredientOreDict;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreIngredient;
import nmd.primal.core.common.PrimalCore;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.List;

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
            Ingredient temp0 = null;
            NonNullList<ItemStack> list0 = NonNullList.create();
            Ingredient temp1 = null;
            List<ItemStack> list1 = NonNullList.create();
            Ingredient temp2 = null;
            List<ItemStack> list2 = NonNullList.create();
            Ingredient temp3 = null;
            List<ItemStack> list3 = NonNullList.create();
            Ingredient temp4 = null;
            List<ItemStack> list4 = NonNullList.create();
            List<IItemStack> zeroIList = I0.getItems();
            List<IItemStack> oneIList = I1.getItems();
            List<IItemStack> twoIList = I2.getItems();
            List<IItemStack> threeIList = I3.getItems();
            List<IItemStack> fourIList = I4.getItems();
            System.out.println(I0.getItems());
            if(I1.getInternal() == new OreIngredient("oreIron") ){
                System.out.println("This is an IoreDictEntry");
            }
            if(I1.getInternal() instanceof IngredientOreDict){
                System.out.println("This is an IngredientOreDict");
            }
            System.out.println(I1);
            System.out.println(I1.getInternal());

            System.out.println(I2.getItems());
            System.out.println(I3.getItems());
            System.out.println(I4.getItems());
            System.out.println(zeroIList);
            System.out.println(oneIList.size());
            System.out.println(twoIList);
            System.out.println(threeIList);
            System.out.println(fourIList);

            for (int i=0; i < zeroIList.size(); i++) {
                list0.add(i, (ItemStack)zeroIList.get(i).getInternal());
            }
            for (int i=0; i < list0.size(); i++) {
                temp0.fromStacks(list0.get(i));
            }


            //instanceof IOreDictEntry
            if(I1 instanceof IOreDictEntry){
                temp1 = new OreIngredient((String) I1.getInternal());
            } else {
                for (int i = 0; i < oneIList.size(); i++) {
                    temp1.apply((ItemStack) zeroIList.get(i).getInternal());
                }
                for (int i = 0; i < list1.size(); i++) {
                    temp1.fromStacks(list1.get(i));
                }
            }

            for (int i=0; i < twoIList.size(); i++) {
                list2.add(i, (ItemStack)twoIList.get(i).getInternal());
            }
            for (int i=0; i < list2.size(); i++) {
                temp2.fromStacks(list2.get(i));
            }

            for (int i=0; i < threeIList.size(); i++) {
                list3.add(i, (ItemStack)threeIList.get(i).getInternal());
            }
            for (int i=0; i < list3.size(); i++) {
                temp3.fromStacks(list3.get(i));
            }

            for (int i=0; i < fourIList.size(); i++) {
                list4.add(i, (ItemStack)fourIList.get(i).getInternal());
            }
            for (int i=0; i < list4.size(); i++) {
                temp4.fromStacks(list4.get(i));
            }

            this.recipe_name = recipe_name;
            this.cookTemp = cookTemp;
            this.cookTime = cookTime;
            this.coolTime = coolTime;
            this.ing0 = temp0;
            this.ing1 = temp1;
            this.ing2 = temp2;
            this.ing3 = temp3;
            this.ing4 = temp4;
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

