package nmd.primal.forgecraft.crafting.registery;

import crafttweaker.api.block.IBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.IForgeRegistry;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.crafting.MachineSawCrafting;
import nmd.primal.forgecraft.crafting.WorkbenchCrafting;
import nmd.primal.forgecraft.init.ModItems;

import java.util.List;

@GameRegistry.ObjectHolder(ModInfo.MOD_ID)
@Mod.EventBusSubscriber
public final class RecipesMachineSaw {
    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<MachineSawCrafting> event) {
        PrimalAPI.logger(7, "Registering Recipes: " + MachineSawCrafting.RECIPE_PREFIX);
        final IForgeRegistry<MachineSawCrafting> recipes = event.getRegistry();

        ItemStack sticks = new ItemStack(Items.STICK, 2);

        recipes.register(new MachineSawCrafting(
                new OreIngredient("logOak"),
                RecipeHelper.buildList(
                        (new ItemStack(Item.getItemFromBlock(Blocks.PLANKS), 4, 0)),
                        (new ItemStack(PrimalAPI.Items.BARK_OAK, 4)),
                        sticks))
                .setRecipeName("planksOak"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("logSpruce"),
                RecipeHelper.buildList(
                        (new ItemStack(Item.getItemFromBlock(Blocks.PLANKS), 4, 1)),
                        (new ItemStack(PrimalAPI.Items.BARK_SPRUCE, 4)),
                        sticks))
                .setRecipeName("planksSpruce"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("logBirch"),
                RecipeHelper.buildList(
                        (new ItemStack(Item.getItemFromBlock(Blocks.PLANKS), 4, 2)),
                        (new ItemStack(PrimalAPI.Items.BARK_BIRCH, 4)),
                        sticks))
                .setRecipeName("planksBirch"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("logJungle"),
                RecipeHelper.buildList(
                        (new ItemStack(Item.getItemFromBlock(Blocks.PLANKS), 4, 3)),
                        (new ItemStack(PrimalAPI.Items.BARK_JUNGLE, 4)),
                        sticks))
                .setRecipeName("planksJungle"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("logAcacia"),
                RecipeHelper.buildList(
                        (new ItemStack(Item.getItemFromBlock(Blocks.PLANKS), 4, 0)),
                        (new ItemStack(PrimalAPI.Items.BARK_ACACIA, 4)),
                sticks))
                .setRecipeName("planksAcacia"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("logIronwood"),
                RecipeHelper.buildList(
                        (new ItemStack(Item.getItemFromBlock(PrimalAPI.Blocks.PLANKS), 4, 0)),
                        (new ItemStack(PrimalAPI.Items.BARK_IRONWOOD, 4)),
                        (new ItemStack(PrimalAPI.Items.IRONWOOD_STICK, 2))
                ))
                .setRecipeName("planksIronwood"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("logYew"),
                RecipeHelper.buildList(
                        (new ItemStack(Item.getItemFromBlock(PrimalAPI.Blocks.PLANKS), 4, 1)),
                        (new ItemStack(PrimalAPI.Items.BARK_YEW, 4)),
                        (new ItemStack(PrimalAPI.Items.YEW_STICK, 2))
                ))
                .setRecipeName("yewPlanks"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("logCorypha"),
                RecipeHelper.buildList(
                        (new ItemStack(Item.getItemFromBlock(PrimalAPI.Blocks.PLANKS), 4, 3)),
                        (new ItemStack(PrimalAPI.Items.BARK_CORYPHA, 4)),
                        (new ItemStack(PrimalAPI.Items.CORYPHA_STICK, 2))))
                .setRecipeName("coryphaPlanks"));

        recipes.register(new MachineSawCrafting(
                new OreIngredient("strippedOak"),
                RecipeHelper.buildList(new ItemStack(PrimalAPI.Items.LOGS_SPLIT_OAK, 6)))
                .setRecipeName("splitOak"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("strippedSpruce"),
                RecipeHelper.buildList(new ItemStack(PrimalAPI.Items.LOGS_SPLIT_SPRUCE, 6)))
                .setRecipeName("splitSpruce"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("strippedBirch"),
                RecipeHelper.buildList(new ItemStack(PrimalAPI.Items.LOGS_SPLIT_BIRCH, 6)))
                .setRecipeName("splitBirch"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("strippedJungle"),
                RecipeHelper.buildList(new ItemStack(PrimalAPI.Items.LOGS_SPLIT_JUNGLE, 6)))
                .setRecipeName("splitJungle"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("strippedAcacia"),
                RecipeHelper.buildList(new ItemStack(PrimalAPI.Items.LOGS_SPLIT_ACACIA, 6)))
                .setRecipeName("splitAcacia"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("strippedDarkOak"),
                RecipeHelper.buildList(new ItemStack(PrimalAPI.Items.LOGS_SPLIT_DARK_OAK, 6)))
                .setRecipeName("splitDarkOak"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("strippedIronwood"),
                RecipeHelper.buildList(new ItemStack(PrimalAPI.Items.LOGS_SPLIT_IRONWOOD, 6)))
                .setRecipeName("splitIronwood"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("strippedYew"),
                RecipeHelper.buildList(new ItemStack(PrimalAPI.Items.LOGS_SPLIT_YEW, 6)))
                .setRecipeName("splitYew"));
        recipes.register(new MachineSawCrafting(
                new OreIngredient("strippedCorypha"),
                RecipeHelper.buildList(new ItemStack(PrimalAPI.Items.LOGS_SPLIT_CORYPHA, 6)))
                .setRecipeName("splitCorypha"));
    }
}