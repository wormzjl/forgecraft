package nmd.primal.forgecraft.crafting.registery;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.IForgeRegistry;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.crafting.WorkbenchCrafting;
import nmd.primal.forgecraft.init.ModItems;

import java.lang.reflect.WildcardType;

@GameRegistry.ObjectHolder(ModInfo.MOD_ID)
@Mod.EventBusSubscriber
public final class RecipesWorkbench {
    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<WorkbenchCrafting> event) {
        PrimalAPI.logger(7, "Registering Recipes: " + WorkbenchCrafting.RECIPE_PREFIX);
        final IForgeRegistry<WorkbenchCrafting> recipes = event.getRegistry();

        /***COPPER***/

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.copperaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.copperaxe, 1)).setRecipeName("copperaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.copperaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.copperaxehead, 1)).setRecipeName("copperaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.copperhoehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.copperhoe, 1)).setRecipeName("copperhoe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.copperhoe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.copperhoehead, 1)).setRecipeName("copperhoesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.copperpickaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.copperpickaxe, 1)).setRecipeName("copperpickaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.copperpickaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.copperpickaxehead, 1)).setRecipeName("copperpickaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.coppershovelhead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.coppershovel, 1)).setRecipeName("coppershovel"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.coppershovel, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.coppershovelhead, 1)).setRecipeName("coppershovelsplit"));

        /***BRONZE***/

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.bronzeaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.bronzeaxe, 1)).setRecipeName("bronzeaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.bronzeaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.bronzeaxehead, 1)).setRecipeName("bronzeaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.bronzehoehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.bronzehoe, 1)).setRecipeName("bronzehoe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.bronzehoe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.bronzehoehead, 1)).setRecipeName("bronzehoesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.bronzepickaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.bronzepickaxe, 1)).setRecipeName("bronzepickaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.bronzepickaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.bronzepickaxehead, 1)).setRecipeName("bronzepickaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.bronzeshovelhead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.bronzeshovel, 1)).setRecipeName("bronzeshovel"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.bronzeshovel, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.bronzeshovelhead, 1)).setRecipeName("bronzeshovelsplit"));


        /***iron***/

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.ironaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.ironaxe, 1)).setRecipeName("ironaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.ironaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.ironaxehead, 1)).setRecipeName("ironaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.ironhoehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.ironhoe, 1)).setRecipeName("ironhoe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.ironhoe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.ironhoehead, 1)).setRecipeName("ironhoesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.pickaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.ironpickaxe, 1)).setRecipeName("ironpickaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.ironpickaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.pickaxehead, 1)).setRecipeName("ironpickaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.ironshovelhead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.ironshovel, 1)).setRecipeName("ironshovel"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.ironshovel, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.ironshovelhead, 1)).setRecipeName("ironshovelsplit"));


        /***cleaniron***/

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.cleanironaxe, 1)).setRecipeName("cleanironaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.cleanironaxehead, 1)).setRecipeName("cleanironaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironhoehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.cleanironhoe, 1)).setRecipeName("cleanironhoe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironhoe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.cleanironhoehead, 1)).setRecipeName("cleanironhoesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironpickaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.cleanironpickaxe, 1)).setRecipeName("cleanironpickaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironpickaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.cleanironpickaxehead, 1)).setRecipeName("cleanironpickaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironshovelhead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.cleanironshovel, 1)).setRecipeName("cleanironshovel"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironshovel, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.cleanironshovelhead, 1)).setRecipeName("cleanironshovelsplit"));


        /***steel***/

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.steelaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.steelaxe, 1)).setRecipeName("steelaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.steelaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.steelaxehead, 1)).setRecipeName("steelaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.steelhoehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.steelhoe, 1)).setRecipeName("steelhoe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.steelhoe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.steelhoehead, 1)).setRecipeName("steelhoesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.steelpickaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.steelpickaxe, 1)).setRecipeName("steelpickaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.steelpickaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.steelpickaxehead, 1)).setRecipeName("steelpickaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.steelshovelhead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.steelshovel, 1)).setRecipeName("steelshovel"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.steelshovel, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.steelshovelhead, 1)).setRecipeName("steelshovelsplit"));


        /***wootz***/

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.wootzaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.wootzaxe, 1)).setRecipeName("wootzaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wootzaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.wootzaxehead, 1)).setRecipeName("wootzaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.wootzhoehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.wootzhoe, 1)).setRecipeName("wootzhoe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wootzhoe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.wootzhoehead, 1)).setRecipeName("wootzhoesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.wootzpickaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.wootzpickaxe, 1)).setRecipeName("wootzpickaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wootzpickaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.wootzpickaxehead, 1)).setRecipeName("wootzpickaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.wootzshovelhead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new ItemStack(ModItems.wootzshovel, 1)).setRecipeName("wootzshovel"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wootzshovel, 1, OreDictionary.WILDCARD_VALUE)),
                new ItemStack(ModItems.wootzshovelhead, 1)).setRecipeName("wootzshovelsplit"));

        /*********WEAPONS********/

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawbronzegladius, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(ModItems.bronzegladius, 1)).setRecipeName("bronzegladius"));

    }
}