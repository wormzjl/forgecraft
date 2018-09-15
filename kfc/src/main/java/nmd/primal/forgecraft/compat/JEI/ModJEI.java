package nmd.primal.forgecraft.compat.JEI;

import mezz.jei.api.*;
import mezz.jei.api.gui.ICraftingGridHelper;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import nmd.primal.forgecraft.compat.JEI.crucible.CrucibleRecipeCategory;
import nmd.primal.forgecraft.compat.JEI.crucible.CrucibleRecipeChecker;
import nmd.primal.forgecraft.compat.JEI.crucible.CrucibleRecipeHandler;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 9/11/18.
 */
@JEIPlugin
public class ModJEI implements IModPlugin {
    public static IJeiHelpers jeiHelper;
    public static ICraftingGridHelper craftingGridHelper;
    public static IRecipeRegistry recipeRegistry;
    public static IGuiHelper guiHelper;
    private static final int craftOutputSlot = 0;
    private static final int craftInputSlot1 = 1;
    //private static List<ItemStack> gallaghers = new ArrayList<>();
    //private static List<ItemStack> blades = new ArrayList<>();
    //private static List<ItemStack> axes = new ArrayList<>();
    //private static List<ItemStack> shovels = new ArrayList<>();
    //private static List<ItemStack> hoes = new ArrayList<>();

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        final IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

        //
        //  In-World
        //
        //registry.addRecipeCategories(new FlakeRecipeCategory(guiHelper));
        //registry.addRecipeCategories(new GallagherRecipeCategory(guiHelper));
        //registry.addRecipeCategories(new BladeRecipeCategory(guiHelper));
        //registry.addRecipeCategories(new AxeRecipeCategory(guiHelper));
        //registry.addRecipeCategories(new ShovelRecipeCategory(guiHelper));
        //registry.addRecipeCategories(new HoeRecipeCategory(guiHelper));

        //
        //  Tiles
        //
        //registry.addRecipeCategories(new DryingRecipeCategory(guiHelper));
        //registry.addRecipeCategories(new HibachiRecipeCategory(guiHelper));
        //registry.addRecipeCategories(new SmelterRecipeCategory(guiHelper));
        registry.addRecipeCategories(new CrucibleRecipeCategory(guiHelper));
    }

    @Override
    public void register(@Nonnull IModRegistry registry) {
        jeiHelper = registry.getJeiHelpers();
        guiHelper = jeiHelper.getGuiHelper();
        craftingGridHelper = guiHelper.createCraftingGridHelper(craftInputSlot1, craftOutputSlot);

        //this.buildToolLists();

        //
        //  Crafting Tables
        //
        //registry.handleRecipes(TableRecipe.class, new TableRecipeHandler(), VanillaRecipeCategoryUid.CRAFTING);
        //registry.getRecipeTransferRegistry().addRecipeTransferHandler(new CraftingTableTransfer());
        //registry.addRecipeCatalyst(new ItemStack(PrimalAPI.Blocks.WORKTABLE_SHELF, 1, OreDictionary.WILDCARD_VALUE), VanillaRecipeCategoryUid.CRAFTING);
        //registry.addRecipeCatalyst(new ItemStack(PrimalAPI.Blocks.WORKTABLE_SLAB, 1, OreDictionary.WILDCARD_VALUE), VanillaRecipeCategoryUid.CRAFTING);

        // ***************************************************************************** //
        //  Tile Recipes
        // ***************************************************************************** //
        //
        //  Drying Racks
        //
        //registry.handleRecipes(DryingRecipe.class, new DryingRecipeHandler(), DryingRecipeCategory.CATEGORY);
        //registry.addRecipes(DryingRecipeChecker.getRecipes(), DryingRecipeCategory.CATEGORY);
        // TODO: report to JEI? wildcard does not work for the tab icon
        //registry.addRecipeCatalyst(new ItemStack(PrimalAPI.Blocks.DRYING_RACK, 1, OreDictionary.WILDCARD_VALUE), DryingRecipeCategory.CATEGORY);
        //for (ITypeWood.EnumType type : ITypeWood.EnumType.values())
        //    registry.addRecipeCatalyst(new ItemStack(PrimalAPI.Blocks.DRYING_RACK, 1, type.getMetadata()), DryingRecipeCategory.CATEGORY);

        //
        //  Hibachi
        //
        //registry.handleRecipes(HibachiRecipe.class, new HibachiRecipeHandler(), HibachiRecipeCategory.CATEGORY);
        //registry.addRecipes(HibachiRecipeChecker.getRecipes(), HibachiRecipeCategory.CATEGORY);
        //for (ITypeMud.EnumType type : ITypeMud.EnumType.values())
        //    registry.addRecipeCatalyst(new ItemStack(PrimalAPI.Blocks.HIBACHI, 1, type.getMetadata()), HibachiRecipeCategory.CATEGORY);

        //
        //  Smelter
        //
        //registry.handleRecipes(SmelterRecipe.class, new SmelterRecipeHandler(), SmelterRecipeCategory.CATEGORY);
        //registry.addRecipes(SmelterRecipeChecker.getRecipes(), SmelterRecipeCategory.CATEGORY);
        //for (ITypeMud.EnumType type : ITypeMud.EnumType.values()) {
        //    ItemStack stack = new ItemStack(PrimalAPI.Blocks.SMELTER, 1, type.getMetadata());
        //    NBTTagCompound nbt = new NBTTagCompound();
        //    stack.setTagInfo("BlockEntityTag", nbt);
        //    nbt.setBoolean("covered", true);
        //     registry.addRecipeCatalyst(stack, SmelterRecipeCategory.CATEGORY);
        //}

        //
        //  Cauldron
        //
        registry.handleRecipes(CrucibleCrafting.class, new CrucibleRecipeHandler(), CrucibleRecipeCategory.CATEGORY);
        registry.addRecipes(CrucibleRecipeChecker.getRecipes(), CrucibleRecipeCategory.CATEGORY);
        //registry.addRecipeCatalyst(new ItemStack(PrimalAPI.Blocks.CAULDRON), CrucibleRecipeCategory.CATEGORY);

        // ***************************************************************************** //
        //  In-World Tools
        // ***************************************************************************** //
        //
        //  Flaking
        //
        /*registry.handleRecipes(FlakeRecipe.class, new FlakeRecipeHandler(), FlakeRecipeCategory.CATEGORY);
        registry.addRecipes(FlakeRecipeChecker.getRecipes(), FlakeRecipeCategory.CATEGORY);
        registry.addRecipeCatalyst(new ItemStack(Blocks.STONE), FlakeRecipeCategory.CATEGORY);

        //
        //  Gallagher
        //
        registry.handleRecipes(GallagherRecipe.class, new GallagherRecipeHandler(), GallagherRecipeCategory.CATEGORY);
        registry.addRecipes(GallagherRecipeChecker.getRecipes(), GallagherRecipeCategory.CATEGORY);
        for (ItemStack stack : gallaghers)
            registry.addRecipeCatalyst(stack, GallagherRecipeCategory.CATEGORY);

        //
        //  Blade
        //
        registry.handleRecipes(BladeRecipe.class, new BladeRecipeHandler(), BladeRecipeCategory.CATEGORY);
        registry.addRecipes(BladeRecipeChecker.getRecipes(), BladeRecipeCategory.CATEGORY);
        for (ItemStack stack : blades)
            registry.addRecipeCatalyst(stack, BladeRecipeCategory.CATEGORY);

        //
        //  Axe
        //
        registry.handleRecipes(AxeRecipe.class, new AxeRecipeHandler(), AxeRecipeCategory.CATEGORY);
        registry.addRecipes(AxeRecipeChecker.getRecipes(), AxeRecipeCategory.CATEGORY);
        for (ItemStack stack : axes)
            registry.addRecipeCatalyst(stack, AxeRecipeCategory.CATEGORY);

        //
        //  Shovel
        //
        registry.handleRecipes(ShovelRecipe.class, new ShovelRecipeHandler(), ShovelRecipeCategory.CATEGORY);
        registry.addRecipes(ShovelRecipeChecker.getRecipes(), ShovelRecipeCategory.CATEGORY);
        for (ItemStack stack : shovels)
            registry.addRecipeCatalyst(stack, ShovelRecipeCategory.CATEGORY);

        //
        //  Hoe
        //
        registry.handleRecipes(HoeRecipe.class, new HoeRecipeHandler(), HoeRecipeCategory.CATEGORY);
        registry.addRecipes(HoeRecipeChecker.getRecipes(), HoeRecipeCategory.CATEGORY);
        for (ItemStack stack : hoes)
            registry.addRecipeCatalyst(stack, HoeRecipeCategory.CATEGORY);
*/
        // ***************************************************************************** //
        //  Info
        // ***************************************************************************** //
        /*
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.FISH_TRAP, 1, OreDictionary.WILDCARD_VALUE), ItemStack.class, "jei.info.primal.fish_trap");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.DRYING_RACK, 1, OreDictionary.WILDCARD_VALUE), ItemStack.class, "jei.info.primal.drying_rack");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.HIBACHI, 1, OreDictionary.WILDCARD_VALUE), ItemStack.class, "jei.info.primal.hibachi");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.SMELTER, 1, OreDictionary.WILDCARD_VALUE), ItemStack.class, "jei.info.primal.smelter");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.CAULDRON), ItemStack.class, "jei.info.primal.cauldron");

        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.STORAGE_CRATE, 1, OreDictionary.WILDCARD_VALUE), ItemStack.class, "jei.info.primal.crate");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.BARREL, 1, OreDictionary.WILDCARD_VALUE), ItemStack.class, "jei.info.primal.barrel");

        registry.addIngredientInfo(new ItemStack(PrimalAPI.Items.PLANT_FIBER), ItemStack.class, "jei.info.primal.plant_fiber", "jei.info.primal.fiber");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Items.CINERIS_FIBER), ItemStack.class, "jei.info.primal.cineris_fiber", "jei.info.primal.fiber");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Items.VOID_FIBER), ItemStack.class, "jei.info.primal.ineris_fiber", "jei.info.primal.fiber");

        registry.addIngredientInfo(RecipeHelper.buildList(new OreIngredient("ladle").getMatchingStacks()), ItemStack.class, "jei.info.primal.ladle");
        registry.addIngredientInfo(RecipeHelper.buildList(new OreIngredient("rock").getMatchingStacks()), ItemStack.class, "jei.info.primal.rocks");
        registry.addIngredientInfo(RecipeHelper.buildList(new OreIngredient("flake").getMatchingStacks()), ItemStack.class, "jei.info.primal.flakes");
        registry.addIngredientInfo(RecipeHelper.buildList(new OreIngredient("pelt").getMatchingStacks()), ItemStack.class, "jei.info.primal.pelts");
        registry.addIngredientInfo(RecipeHelper.buildList(new OreIngredient("hide").getMatchingStacks()), ItemStack.class, "jei.info.primal.hides");
        registry.addIngredientInfo(RecipeHelper.buildList(new OreIngredient("ash").getMatchingStacks()), ItemStack.class, "jei.info.primal.ash");
        registry.addIngredientInfo(RecipeHelper.buildList(new OreIngredient("logStripped").getMatchingStacks()), ItemStack.class, "jei.info.primal.log_stripped");
        registry.addIngredientInfo(RecipeHelper.buildList(new OreIngredient("logSplit").getMatchingStacks()), ItemStack.class, "jei.info.primal.log_split");
        registry.addIngredientInfo(RecipeHelper.buildList(new OreIngredient("logStack").getMatchingStacks()), ItemStack.class, "jei.info.primal.log_stack");

        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.THATCH_WET), ItemStack.class, "jei.info.primal.wet_block");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.MUD_WET), ItemStack.class, "jei.info.primal.wet_block");
        //registry.addIngredientInfo(new ItemStack(PrimalAPI.Items.DARK_LENS_GOGGLES),ItemStack.class,"jei.info.primal.goggles");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.IGNIS_FATUUS), ItemStack.class, "jei.info.primal.ignis");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Items.ACONITE_ROOT), ItemStack.class, "jei.info.primal.aconite");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Items.CINERIS_SEED), ItemStack.class, "jei.info.primal.cineris");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Items.VOID_SEED), ItemStack.class, "jei.info.primal.cineris");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.SOUL_GLASS), ItemStack.class, "jei.info.primal.soulglass");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.PITFALL), ItemStack.class, "jei.info.primal.pitfall");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.ANCIENT_ICE), ItemStack.class, "jei.info.primal.ancient_ice");
        registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.OVIS_ATRE_WOOL), ItemStack.class, "jei.info.primal.ovis_atre_wool");
        //registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.SATETSU),ItemStack.class,"jei.info.primal.satetsu");
        //registry.addIngredientInfo(new ItemStack(PrimalAPI.Blocks.NETHER_GROWTH),ItemStack.class,"jei.info.primal.nethergrowth");

        registry.addIngredientInfo(new ItemStack(PrimalAPI.Items.DIRT_STICK), ItemStack.class, "jei.info.primal.debug_dirt_stick");
        */
        //this.cleanLists();
    }

    /*
    private void buildToolLists() {
        for (Item item : ForgeRegistries.ITEMS.getValuesCollection()) {
            if (item != null) {
                //ItemStack stack = new ItemStack(item);
                //if (CommonUtils.isToolEffective(stack, Blocks.PLANKS.getDefaultState()))
                if (item instanceof ItemAxe)
                    axes.add(new ItemStack(item));

                    //if (CommonUtils.isToolEffective(stack, Blocks.DIRT.getDefaultState()))
                else if (item instanceof ItemSpade)
                    shovels.add(new ItemStack(item));

                else if (item instanceof ItemHoe)
                    hoes.add(new ItemStack(item));

                else if (item instanceof WorkBlade)
                    blades.add(new ItemStack(item));

                else if (item instanceof Gallagher)
                    gallaghers.add(new ItemStack(item));
            }
        }
    }

    private void cleanLists() {
        axes.clear();
        shovels.clear();
        hoes.clear();
        blades.clear();
        gallaghers.clear();
    }
    */
}
