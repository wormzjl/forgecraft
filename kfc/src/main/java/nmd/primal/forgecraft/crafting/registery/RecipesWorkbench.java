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
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.copperaxe, 1)).setRecipeName("copperaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.copperaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.copperaxehead, 1)).setRecipeName("copperaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.copperhoehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.copperhoe, 1)).setRecipeName("copperhoe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.copperhoe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.copperhoehead, 1)).setRecipeName("copperhoesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.copperpickaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.copperpickaxe, 1)).setRecipeName("copperpickaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.copperpickaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.copperpickaxehead, 1)).setRecipeName("copperpickaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.coppershovelhead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.coppershovel, 1)).setRecipeName("coppershovel"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.coppershovel, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.coppershovelhead, 1)).setRecipeName("coppershovelsplit"));

        /***BRONZE***/

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.bronzeaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.bronzeaxe, 1)).setRecipeName("bronzeaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.bronzeaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.bronzeaxehead, 1)).setRecipeName("bronzeaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.bronzehoehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.bronzehoe, 1)).setRecipeName("bronzehoe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.bronzehoe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.bronzehoehead, 1)).setRecipeName("bronzehoesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.bronzepickaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.bronzepickaxe, 1)).setRecipeName("bronzepickaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.bronzepickaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.bronzepickaxehead, 1)).setRecipeName("bronzepickaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.bronzeshovelhead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.bronzeshovel, 1)).setRecipeName("bronzeshovel"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.bronzeshovel, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.bronzeshovelhead, 1)).setRecipeName("bronzeshovelsplit"));


        /***iron***/

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.ironaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.ironaxe, 1)).setRecipeName("ironaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.ironaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.ironaxehead, 1)).setRecipeName("ironaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.ironhoehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.ironhoe, 1)).setRecipeName("ironhoe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.ironhoe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.ironhoehead, 1)).setRecipeName("ironhoesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.pickaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.ironpickaxe, 1)).setRecipeName("ironpickaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.ironpickaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.pickaxehead, 1)).setRecipeName("ironpickaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.ironshovelhead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.ironshovel, 1)).setRecipeName("ironshovel"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.ironshovel, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.ironshovelhead, 1)).setRecipeName("ironshovelsplit"));


        /***cleaniron***/

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.cleanironaxe, 1)).setRecipeName("cleanironaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.cleanironaxehead, 1)).setRecipeName("cleanironaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironhoehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.cleanironhoe, 1)).setRecipeName("cleanironhoe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironhoe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.cleanironhoehead, 1)).setRecipeName("cleanironhoesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironpickaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.cleanironpickaxe, 1)).setRecipeName("cleanironpickaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironpickaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.cleanironpickaxehead, 1)).setRecipeName("cleanironpickaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironshovelhead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.cleanironshovel, 1)).setRecipeName("cleanironshovel"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironshovel, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.cleanironshovelhead, 1)).setRecipeName("cleanironshovelsplit"));


        /***steel***/

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.steelaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.steelaxe, 1)).setRecipeName("steelaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.steelaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.steelaxehead, 1)).setRecipeName("steelaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.steelhoehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.steelhoe, 1)).setRecipeName("steelhoe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.steelhoe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.steelhoehead, 1)).setRecipeName("steelhoesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.steelpickaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.steelpickaxe, 1)).setRecipeName("steelpickaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.steelpickaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.steelpickaxehead, 1)).setRecipeName("steelpickaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.steelshovelhead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.steelshovel, 1)).setRecipeName("steelshovel"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.steelshovel, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.steelshovelhead, 1)).setRecipeName("steelshovelsplit"));


        /***wootz***/

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.wootzaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.wootzaxe, 1)).setRecipeName("wootzaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wootzaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.wootzaxehead, 1)).setRecipeName("wootzaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.wootzhoehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.wootzhoe, 1)).setRecipeName("wootzhoe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wootzhoe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.wootzhoehead, 1)).setRecipeName("wootzhoesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.wootzpickaxehead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.wootzpickaxe, 1)).setRecipeName("wootzpickaxe"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wootzpickaxe, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.wootzpickaxehead, 1)).setRecipeName("wootzpickaxesplit"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("stickTreatedWood"),
                Ingredient.fromStacks(new ItemStack(ModItems.wootzshovelhead, 1)),
                new OreIngredient("pinBasic"),
                Ingredient.EMPTY,
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.wootzshovel, 1)).setRecipeName("wootzshovel"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wootzshovel, 1, OreDictionary.WILDCARD_VALUE)),
                new OreIngredient("toolGallagher"),
                new ItemStack(ModItems.wootzshovelhead, 1)).setRecipeName("wootzshovelsplit"));

        /*********WEAPONS********/

        /***GLADIUS***/
        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawcoppergladius, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.coppergladius, 1)).setRecipeName("coppergladius"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.coppergladius, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawcoppergladius, 1)).setRecipeName("rawcoppergladius"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawbronzegladius, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.bronzegladius, 1)).setRecipeName("bronzegladius"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.bronzegladius, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawbronzegladius, 1)).setRecipeName("rawbronzegladius"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawwroughtirongladius, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.wroughtirongladius, 1)).setRecipeName("wroughtirongladius"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wroughtirongladius, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawwroughtirongladius, 1)).setRecipeName("rawwroughtirongladius"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawcleanirongladius, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.cleanirongladius, 1)).setRecipeName("cleanirongladius"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.cleanirongladius, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawcleanirongladius, 1)).setRecipeName("rawcleanirongladius"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawsteelgladius, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.steelgladius, 1)).setRecipeName("steelgladius"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.steelgladius, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawsteelgladius, 1)).setRecipeName("rawsteelgladius"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawwootzgladius, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.wootzgladius, 1)).setRecipeName("wootzgladius"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wootzgladius, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawwootzgladius, 1)).setRecipeName("rawwootzgladius"));

        /***LONGSWORD***/
        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawcleanironlongsword, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.cleanironlongsword, 1)).setRecipeName("cleanironlongsword"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironlongsword, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawcleanironlongsword, 1)).setRecipeName("rawcleanironlongsword"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawsteellongsword, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.steellongsword, 1)).setRecipeName("steellongsword"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.steellongsword, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawsteellongsword, 1)).setRecipeName("rawsteellongsword"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawwootzlongsword, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.wootzlongsword, 1)).setRecipeName("wootzlongsword"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wootzlongsword, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawwootzlongsword, 1)).setRecipeName("rawwootzlongsword"));

        /***SLAYER***/
        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawironslayer, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.wroughtironslayer, 1)).setRecipeName("ironslayer"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wroughtironslayer, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawironslayer, 1)).setRecipeName("rawironslayer"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawcleanironslayer, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.cleanironslayer, 1)).setRecipeName("cleanironslayer"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.cleanironslayer, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawcleanironslayer, 1)).setRecipeName("rawcleanironslayer"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawsteelslayer, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.steelslayer, 1)).setRecipeName("steelslayer"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.steelslayer, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawsteelslayer, 1)).setRecipeName("rawsteelslayer"));

        recipes.register (new WorkbenchCrafting(
                new OreIngredient("cordageGeneral"),
                Ingredient.fromStacks(new ItemStack(ModItems.rawwootzslayer, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.wootzslayer, 1)).setRecipeName("wootzslayer"));

        recipes.register (new WorkbenchCrafting(
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.fromStacks(new ItemStack(ModItems.wootzslayer, 1)),
                new OreIngredient("toolWorkBlade"),
                new ItemStack(ModItems.rawwootzslayer, 1)).setRecipeName("rawwootzslayer"));
    }
}