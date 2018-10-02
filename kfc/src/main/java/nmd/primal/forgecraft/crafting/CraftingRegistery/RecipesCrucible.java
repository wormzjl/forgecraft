package nmd.primal.forgecraft.crafting.CraftingRegistery;

import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.IForgeRegistry;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;
import nmd.primal.forgecraft.init.ModItems;

@GameRegistry.ObjectHolder(ModInfo.MOD_ID)
@Mod.EventBusSubscriber
public final class RecipesCrucible {
    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<CrucibleCrafting> event) {
        PrimalAPI.logger(7, "Registering Recipes: " + CrucibleCrafting.RECIPE_PREFIX);
        final IForgeRegistry<CrucibleCrafting> recipes = event.getRegistry();

/*
    ItemStack emptyAir = ItemStack.EMPTY;

    NBTTagCompound newTag = new NBTTagCompound();

    NBTTagCompound setHot = new NBTTagCompound();
        setHot.setBoolean("hot",  true);

    ItemStack hotBronzeIngot = new ItemStack(ModItems.bronzeingotball, 1);
        hotBronzeIngot.setTagCompound(setHot);
    ItemStack hotIronIngot = new ItemStack(ModItems.ironingotball, 1);
        hotIronIngot.setTagCompound(setHot);
    ItemStack hotCleanIronIngot = new ItemStack(ModItems.ironcleaningotball, 1);
        hotCleanIronIngot.setTagCompound(setHot);
    ItemStack hotSteelIngot = new ItemStack(ModItems.steelingotball, 1);
        hotSteelIngot.setTagCompound(setHot);
    ItemStack hotWootzIngot = new ItemStack(ModItems.wootzingotball, 1);
        hotWootzIngot.setTagCompound(setHot);

    ItemStack hotBronzeChunk = new ItemStack( ModItems.bronzechunk, 1);
        hotBronzeChunk.setTagCompound(setHot);
    ItemStack hotChunk = new ItemStack( ModItems.wroughtironchunk, 1);
        hotChunk.setTagCompound(setHot);
    ItemStack hotCleanChunk = new ItemStack(ModItems.ironcleanchunk, 1);
        hotCleanChunk.setTagCompound(setHot);
    ItemStack hotSteelChunk = new ItemStack(ModItems.steelchunk, 1);
        hotSteelChunk.setTagCompound(setHot);
    ItemStack hotWootzChunk = new ItemStack(ModItems.wootzchunk, 1);
        hotWootzChunk.setTagCompound(setHot);

    ItemStack diamond = new ItemStack(Items.DIAMOND, 1);
    ItemStack emerald = new ItemStack(Items.EMERALD, 1);

    ItemStack emeraldShard = new ItemStack(PrimalAPI.Items.EMERALD_KNAPP, 1);
    ItemStack diamondShard = new ItemStack(PrimalAPI.Items.DIAMOND_KNAPP, 1);
    ItemStack redstone = new ItemStack(Items.REDSTONE, 1);
    ItemStack lapis = new ItemStack(Items.DYE, 1, 4);



    ItemStack[] toolArray = new ItemStack[24];
    ItemStack[] hotToolArray = new ItemStack[16];

    ItemStack bronzepickaxehead = new ItemStack(ModItems.bronzepickaxehead, 1);
        bronzepickaxehead.setTagCompound(newTag);
    toolArray[0] = bronzepickaxehead;
    ItemStack bronzeaxehead = new ItemStack(ModItems.bronzeaxehead, 1);
        bronzeaxehead.setTagCompound(newTag);
    toolArray[1] = bronzeaxehead;
    ItemStack bronzeshovelhead = new ItemStack(ModItems.bronzeshovelhead, 1);
        bronzeshovelhead.setTagCompound(newTag);
    toolArray[2] = bronzeshovelhead;
    ItemStack bronzehoehead = new ItemStack(ModItems.bronzehoehead, 1);
        bronzehoehead.setTagCompound(newTag);
    toolArray[3] = bronzehoehead;

    ItemStack pickaxehead = new ItemStack(ModItems.pickaxehead, 1);
        pickaxehead.setTagCompound(newTag);
    toolArray[4] = pickaxehead;
    ItemStack ironaxehead = new ItemStack(ModItems.ironaxehead, 1);
        ironaxehead.setTagCompound(newTag);
    toolArray[5] = ironaxehead;
    ItemStack ironshovelhead = new ItemStack(ModItems.ironshovelhead, 1);
        ironshovelhead.setTagCompound(newTag);
    toolArray[6] = ironshovelhead;
    ItemStack ironhoehead = new ItemStack(ModItems.ironhoehead, 1);
        ironhoehead.setTagCompound(newTag);
    toolArray[7] = ironhoehead;

    ItemStack cleanpickaxehead = new ItemStack(ModItems.cleanironpickaxehead, 1);
        cleanpickaxehead.setTagCompound(newTag);
    toolArray[8] = cleanpickaxehead;
    ItemStack cleanaxehead = new ItemStack(ModItems.cleanironaxehead, 1);
        cleanaxehead.setTagCompound(newTag);
    toolArray[9] = cleanaxehead;
    ItemStack cleanshovelhead = new ItemStack(ModItems.cleanironshovelhead, 1);
        cleanshovelhead.setTagCompound(newTag);
    toolArray[10] = cleanshovelhead;
    ItemStack cleanhoehead = new ItemStack(ModItems.cleanironhoehead, 1);
        cleanhoehead.setTagCompound(newTag);
    toolArray[11] =cleanhoehead ;

    ItemStack steelpickaxehead = new ItemStack(ModItems.steelpickaxehead, 1);
        steelpickaxehead.setTagCompound(newTag);
    toolArray[12] = steelpickaxehead;
    ItemStack steelaxehead = new ItemStack(ModItems.steelaxehead, 1);
        steelaxehead.setTagCompound(newTag);
    toolArray[13] =steelaxehead ;
    ItemStack steelshovelhead = new ItemStack(ModItems.steelshovelhead, 1);
        steelshovelhead.setTagCompound(newTag);
    toolArray[14] = steelshovelhead;
    ItemStack steelhoehead = new ItemStack(ModItems.steelhoehead, 1);
        steelhoehead.setTagCompound(newTag);
    toolArray[15] =steelhoehead ;

    ItemStack wootzpickaxehead = new ItemStack(ModItems.wootzpickaxehead, 1);
        wootzpickaxehead.setTagCompound(newTag);
    toolArray[16] = wootzpickaxehead;
    ItemStack wootzaxehead = new ItemStack(ModItems.wootzaxehead, 1);
        wootzaxehead.setTagCompound(newTag);
    toolArray[17] = wootzaxehead;
    ItemStack wootzshovelhead = new ItemStack(ModItems.wootzshovelhead, 1);
        wootzshovelhead.setTagCompound(newTag);
    toolArray[18] =wootzshovelhead ;
    ItemStack wootzhoehead = new ItemStack(ModItems.wootzhoehead, 1);
        wootzhoehead.setTagCompound(newTag);
    toolArray[19] = wootzhoehead;

    ItemStack copperpickaxehead = new ItemStack(ModItems.copperpickaxehead, 1);
        copperpickaxehead.setTagCompound(newTag);
    toolArray[20] = copperpickaxehead;
    ItemStack copperaxehead = new ItemStack(ModItems.copperaxehead, 1);
        copperaxehead.setTagCompound(newTag);
    toolArray[21] = copperaxehead;
    ItemStack coppershovelhead = new ItemStack(ModItems.coppershovelhead, 1);
        coppershovelhead.setTagCompound(newTag);
    toolArray[22] =coppershovelhead ;
    ItemStack copperhoehead = new ItemStack(ModItems.copperhoehead, 1);
        copperhoehead.setTagCompound(newTag);
    toolArray[23] = copperhoehead;

    ItemStack hotpickaxehead = pickaxehead.copy();
    hotToolArray[0] =hotpickaxehead;
    ItemStack hotironaxehead = ironaxehead.copy();
    hotToolArray[1] =hotironaxehead;
    ItemStack hotironshovelhead = ironshovelhead.copy();
    hotToolArray[2] =hotironshovelhead;
    ItemStack hotironhoehead = ironhoehead.copy();
    hotToolArray[3] =hotironhoehead;

    ItemStack hotcleanpickaxehead = cleanpickaxehead.copy();
    hotToolArray[4] = hotcleanpickaxehead;
    ItemStack hotcleanaxehead = cleanaxehead.copy();
    hotToolArray[5] = hotcleanaxehead;
    ItemStack hotcleanshovelhead = cleanshovelhead.copy();
    hotToolArray[6] = hotcleanshovelhead;
    ItemStack hotcleanhoehead = cleanhoehead.copy();
    hotToolArray[7] = hotcleanhoehead;

    ItemStack hotsteelpickaxehead = steelpickaxehead.copy();
    hotToolArray[8] = hotsteelpickaxehead;
    ItemStack hotsteelaxehead = steelaxehead.copy();
    hotToolArray[9] = hotsteelaxehead;
    ItemStack hotsteelshovelhead = steelshovelhead.copy();
    hotToolArray[10] = hotsteelshovelhead;
    ItemStack hotsteelhoehead = steelhoehead.copy();
    hotToolArray[11] = hotsteelhoehead;

    ItemStack hotwootzpickaxehead = wootzpickaxehead.copy();
    hotToolArray[12] = hotwootzpickaxehead;
    ItemStack hotwootzaxehead = wootzaxehead.copy();
    hotToolArray[13] = hotwootzaxehead;
    ItemStack hotwootzshovelhead = wootzshovelhead.copy();
    hotToolArray[14] = hotwootzshovelhead;
    ItemStack hotwootzhoehead = wootzhoehead.copy();
    hotToolArray[15] = hotwootzhoehead;



        for(ItemStack temp : toolArray) {
        NBTTagCompound tags = temp.getTagCompound();
        tags.setTag("tags", tags);

        tags.getCompoundTag("tags").setBoolean("hot", false);
        tags.getCompoundTag("tags").setBoolean("emerald", false);
        tags.getCompoundTag("tags").setInteger("diamond", 0);
        tags.getCompoundTag("tags").setInteger("redstone", 0);
        tags.getCompoundTag("tags").setInteger("lapis", 0);
        tags.getCompoundTag("tags").setInteger("modifiers", 0);
        temp.setTagCompound(tags);
    }

    bronzepickaxehead = toolArray[0];
    bronzeaxehead = toolArray[1];
    bronzeshovelhead = toolArray[2];
    bronzehoehead = toolArray[3];

    pickaxehead = toolArray[4];
    ironaxehead = toolArray[5];
    ironshovelhead = toolArray[6];
    ironhoehead = toolArray[7];

    cleanpickaxehead = toolArray[8];
    cleanaxehead = toolArray[9];
    cleanshovelhead = toolArray[10];
    cleanhoehead = toolArray[11];

    steelpickaxehead = toolArray[12] ;
    steelaxehead = toolArray[13] ;
    steelshovelhead = toolArray[14];
    steelhoehead = toolArray[15] ;

    wootzpickaxehead = toolArray[16];
    wootzaxehead = toolArray[17];
    wootzshovelhead = toolArray[18] ;
    wootzhoehead = toolArray[19];

    copperpickaxehead = toolArray[20];
    copperaxehead = toolArray[21];
    coppershovelhead = toolArray[22];
    copperhoehead = toolArray[23];

        for(ItemStack temp : hotToolArray) {
        //NBTTagCompound newTag = new NBTTagCompound();
        NBTTagCompound tags = new NBTTagCompound();

        //temp.setTagCompound(newTag);
        temp.getTagCompound().setTag("tags", tags);

        temp.getTagCompound().setTag("tags", tags);
        temp.getSubCompound("tags").setBoolean("hot", true);
        temp.getSubCompound("tags").setBoolean("emerald", false);
        temp.getSubCompound("tags").setInteger("diamond", 0);
        temp.getSubCompound("tags").setInteger("redstone", 0);
        temp.getSubCompound("tags").setInteger("lapis", 0);
        temp.getSubCompound("tags").setInteger("modifiers", 0);
    }

    hotpickaxehead = hotToolArray[0];
    hotironaxehead = hotToolArray[1];
    hotironshovelhead = hotToolArray[2];
    hotironhoehead = hotToolArray[3];

    hotcleanpickaxehead = hotToolArray[4];
    hotcleanaxehead = hotToolArray[5];
    hotcleanshovelhead = hotToolArray[6];
    hotcleanhoehead = hotToolArray[7];

    hotsteelpickaxehead = hotToolArray[8] ;
    hotsteelaxehead = hotToolArray[9] ;
    hotsteelshovelhead = hotToolArray[10];
    hotsteelhoehead = hotToolArray[11] ;

    hotwootzpickaxehead = hotToolArray[12];
    hotwootzaxehead = hotToolArray[13];
    hotwootzshovelhead = hotToolArray[14] ;
    hotwootzhoehead = hotToolArray[15];
*/
    //RecipeHandler.addSmelting(ModItems.softcrucible, new ItemStack(ModBlocks.nbtCrucible, 1));

    /***********************/
    /***CRUCIBLE CRAFTING***/
    /***********************/

    recipes.register (new CrucibleCrafting(
                new OreIngredient("oreIron"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(Blocks.IRON_ORE, 1),
                new ItemStack(ModItems.ironingotball, 1),
                1400,
                        1200,
                        800).setRecipeName("wroughtIron1"));

    recipes.register (new CrucibleCrafting(
            new OreIngredient("dustIron"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(Blocks.IRON_ORE, 1),
                new ItemStack(ModItems.ironingotball, 1),
                1250,
                        1100,
                        800).setRecipeName("wroughtIron2"));

    recipes.register (new CrucibleCrafting(
                Ingredient.fromStacks(new ItemStack(ModItems.brokenwroughtirontool, 1)),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
                new ItemStack(ModItems.ironingotball, 1),
                1250,
                        1100,
                        800).setRecipeName("wroughtIron3"));

    recipes.register (new CrucibleCrafting(
                new OreIngredient("dustIron"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.IRON_DUST, 1),
                new ItemStack(ModItems.ironcleaningotball, 1),
                1550,
                        1200,
                        800).setRecipeName("cleanIron1"));

        recipes.register (new CrucibleCrafting(
                Ingredient.fromStacks(new ItemStack(ModItems.brokencleanirontool, 1)),
            new OreIngredient("nuggetIron"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
                new ItemStack(ModItems.ironcleaningotball, 1),
                1550,
                        1200,
                        800).setRecipeName("cleanIron2"));

        recipes.register (new CrucibleCrafting(
                Ingredient.fromStacks(new ItemStack(ModItems.ironcleaningotball, 1)),
            Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_HIGH, 1)),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(ModItems.ironcleaningotball, 1),
                new ItemStack(ModItems.steelingotball, 1),
                2100,
                        1500,
                        1000).setRecipeName("steel1"));

        recipes.register (new CrucibleCrafting(
                Ingredient.fromStacks(new ItemStack(ModItems.brokensteeltool, 1)),
            new OreIngredient("nuggetSteel"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
                new ItemStack(ModItems.steelingotball, 1),
                2100,
                        1500,
                        1000).setRecipeName("steel2"));

        recipes.register (new CrucibleCrafting(
                new OreIngredient("dustMagnetite"),
                Ingredient.fromStacks(new ItemStack(Blocks.LEAVES, 1,BlockPlanks.EnumType.JUNGLE.getMetadata())),
            Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_PURE, 1)),
            Ingredient.fromStacks(new ItemStack(Blocks.LEAVES, 1, BlockPlanks.EnumType.JUNGLE.getMetadata())),
            Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_PURE, 1)),
            new ItemStack(PrimalAPI.Blocks.ORE_MAGNETITE, 1),
                new ItemStack(ModItems.wootzingotball, 1),
                2100,
                        1800,
                        1500).setRecipeName("wootz1"));

        recipes.register (new CrucibleCrafting(
                new OreIngredient("magnetite"),
                Ingredient.fromStacks(new ItemStack(Blocks.LEAVES, 1, BlockPlanks.EnumType.JUNGLE.getMetadata())),
            Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_PURE, 1)),
            Ingredient.fromStacks(new ItemStack(Blocks.LEAVES, 1, BlockPlanks.EnumType.JUNGLE.getMetadata())),
            Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_PURE, 1)),
            new ItemStack(PrimalAPI.Blocks.ORE_MAGNETITE, 1),
                new ItemStack(ModItems.wootzingotball, 1),
                2100,
                        1800,
                        1500).setRecipeName("wootz2"));

        recipes.register (new CrucibleCrafting(
                Ingredient.fromStacks(new ItemStack(ModItems.brokenwootztool, 1)),
            new OreIngredient("nuggetWootz"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
                new ItemStack(ModItems.wootzingotball, 1),
                2100,
                        1800,
                        1500).setRecipeName("wootz3"));

    /***BRONZE***/
    NBTTagCompound tagBronzeDefault = new NBTTagCompound();
        tagBronzeDefault.setString("upgrades", "");
        tagBronzeDefault.setBoolean("hot", false);
    ItemStack defaultBronze = new ItemStack(ModItems.bronzeingotball, 1);
        defaultBronze.setTagCompound(tagBronzeDefault.copy());

        recipes.register (new CrucibleCrafting(
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustTin"),
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    defaultBronze,
            1100,
            800,
            600).setRecipeName("bronze1"));

        recipes.register (new CrucibleCrafting(
                new OreIngredient("ingotBronze"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    defaultBronze,
            1100,
            800,
            600).setRecipeName("bronze2"));

    ItemStack redBronze = defaultBronze.copy();
        redBronze.getTagCompound().setString("upgrades", "redstone");
        recipes.register (new CrucibleCrafting(
                new OreIngredient("ingotBronze"),
                new OreIngredient("dustRedstone"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    redBronze,
            1100,
            800,
            600).setRecipeName("redBronze1"));

    ItemStack diamondBronze = defaultBronze.copy();
        diamondBronze.getTagCompound().setString("upgrades", "diamond");
        recipes.register (new CrucibleCrafting(
                new OreIngredient("ingotBronze"),
                new OreIngredient("flakeDiamond"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    diamondBronze,
            1100,
            800,
            600).setRecipeName("diamondBronze1"));

    ItemStack emeraldBronze = defaultBronze.copy();
        emeraldBronze.getTagCompound().setString("upgrades", "emerald");
        recipes.register (new CrucibleCrafting(
                new OreIngredient("ingotBronze"),
                new OreIngredient("flakeEmerald"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    emeraldBronze,
            1100,
            800,
            600).setRecipeName("emeraldBronze1"));

    ItemStack lapisBronze = defaultBronze.copy();
        lapisBronze.getTagCompound().setString("upgrades", "lapis");
        recipes.register (new CrucibleCrafting(
                new OreIngredient("ingotBronze"),
                new OreIngredient("gemLapis"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    lapisBronze,
            1100,
            800,
            600).setRecipeName("lapisBronze1"));

        recipes.register (new CrucibleCrafting(
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustTin"),
                new OreIngredient("dustRedstone"),
                new ItemStack(PrimalAPI.Items.SLAG, 1),
    redBronze,
            1100,
            800,
            600).setRecipeName("redBronze2"));

        recipes.register (new CrucibleCrafting(
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustTin"),
                new OreIngredient("flakeDiamond"),
                new ItemStack(PrimalAPI.Items.SLAG, 1),
    diamondBronze,
            1100,
            800,
            600).setRecipeName("diamondBronze2"));

        recipes.register (new CrucibleCrafting(
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustTin"),
                new OreIngredient("flakeEmerald"),
                new ItemStack(PrimalAPI.Items.SLAG, 1),
    emeraldBronze,
            1100,
            800,
            600).setRecipeName("emeraldBronze2"));

        recipes.register (new CrucibleCrafting(
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustTin"),
                new OreIngredient("gemLapis"),
                new ItemStack(PrimalAPI.Items.SLAG, 1),
    lapisBronze,
            1100,
            800,
            600).setRecipeName("lapisBronze2"));


    /***COPPER***/
    NBTTagCompound tagCopperDefault = new NBTTagCompound();
        tagCopperDefault.setString("upgrades", "");
        tagCopperDefault.setBoolean("hot", false);
    ItemStack defaultCopper = new ItemStack(PrimalAPI.Items.COPPER_INGOT, 1);
        defaultCopper.setTagCompound(tagCopperDefault.copy());

        recipes.register (new CrucibleCrafting(
                new OreIngredient("oreCopper"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    defaultCopper,
            900,
            800,
            600).setRecipeName("copper1"));

        recipes.register (new CrucibleCrafting(
                new OreIngredient("ingotCopper"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    defaultCopper,
            900,
            750,
            550).setRecipeName("copper2"));

    ItemStack redCopper = defaultCopper.copy();
        redCopper.getTagCompound().setString("upgrades", "redstone");
        recipes.register (new CrucibleCrafting(
                new OreIngredient("ingotCopper"),
                new OreIngredient("dustRedstone"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    redCopper,
            900,
            750,
            550).setRecipeName("redCopper1"));

    ItemStack diamondCopper = defaultCopper.copy();
        diamondCopper.getTagCompound().setString("upgrades", "diamond");
        recipes.register (new CrucibleCrafting(
                new OreIngredient("ingotCopper"),
                new OreIngredient("flakeDiamond"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    diamondCopper,
            900,
            750,
            550).setRecipeName("diamondCopper1"));

    ItemStack emeraldCopper = defaultCopper.copy();
        emeraldCopper.getTagCompound().setString("upgrades", "emerald");
        recipes.register (new CrucibleCrafting(
                new OreIngredient("ingotCopper"),
                new OreIngredient("flakeEmerald"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    emeraldCopper,
            900,
            750,
            550).setRecipeName("emeraldCopper1"));

    ItemStack lapisCopper = defaultCopper.copy();
        lapisCopper.getTagCompound().setString("upgrades", "lapis");
        recipes.register (new CrucibleCrafting(
                new OreIngredient("ingotCopper"),
                new OreIngredient("gemLapis"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    lapisCopper,
            900,
            750,
            550).setRecipeName("lapisCopper1"));

        recipes.register (new CrucibleCrafting(
                new OreIngredient("oreCopper"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
            new OreIngredient("dustRedstone"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    redCopper,
            900,
            750,
            550).setRecipeName("redCopper2"));

        recipes.register (new CrucibleCrafting(
                new OreIngredient("oreCopper"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
            new OreIngredient("flakeDiamond"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    diamondCopper,
            900,
            750,
            550).setRecipeName("diamondCopper2"));

        recipes.register (new CrucibleCrafting(
                new OreIngredient("oreCopper"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
            new OreIngredient("flakeEmerald"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    emeraldCopper,
            900,
            750,
            550).setRecipeName("emeraldCopper2"));

        recipes.register (new CrucibleCrafting(
                new OreIngredient("oreCopper"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
            new OreIngredient("gemLapis"),
    Ingredient.EMPTY,
    Ingredient.EMPTY,
            new ItemStack(PrimalAPI.Items.SLAG, 1),
    lapisCopper,
            900,
            750,
            550).setRecipeName("lapisCopper2"));

    }
}