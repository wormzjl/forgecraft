package nmd.primal.forgecraft.init;

import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.oredict.ShapedOreRecipe;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.recipes.irecipe.RecipeHandler;
import nmd.primal.forgecraft.crafting.AnvilCrafting;
import nmd.primal.forgecraft.crafting.CastingCrafting;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;
import nmd.primal.forgecraft.crafting.ForgeCrafting;

import java.util.Random;

/**
 * Created by kitsu on 11/30/2016.
 */
public class ModCrafting{

    public static void register() {

        Random rand = new Random();
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

        //RecipeHandler.addSmelting(ModItems.softcrucible, new ItemStack(ModBlocks.nbtCrucible, 1));

        /***********************/
        /***CRUCIBLE CRAFTING***/
        /***********************/
/*
        CrucibleCrafting.addRecipe(
                new OreIngredient("oreIron"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(Blocks.IRON_ORE, 1),
                new ItemStack(ModItems.ironingotball, 1),
                1400,
                1200,
                800);

        CrucibleCrafting.addRecipe(
                new OreIngredient("dustIron"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(Blocks.IRON_ORE, 1),
                new ItemStack(ModItems.ironingotball, 1),
                1250,
                1100,
                800);

        CrucibleCrafting.addRecipe(
                Ingredient.fromStacks(new ItemStack(ModItems.brokenwroughtirontool, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                new ItemStack(ModItems.ironingotball, 1),
                1250,
                1100,
                800);

        CrucibleCrafting.addRecipe(
                new OreIngredient("dustIron"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.IRON_DUST, 1),
                new ItemStack(ModItems.ironcleaningotball, 1),
                1550,
                1200,
                800);

        CrucibleCrafting.addRecipe(
                Ingredient.fromStacks(new ItemStack(ModItems.brokencleanirontool, 1)),
                new OreIngredient("nuggetIron"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                new ItemStack(ModItems.ironcleaningotball, 1),
                1550,
                1200,
                800);

        CrucibleCrafting.addRecipe(
                Ingredient.fromStacks(new ItemStack(ModItems.ironcleaningotball, 1)),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_HIGH, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(ModItems.ironcleaningotball, 1),
                new ItemStack(ModItems.steelingotball, 1),
                2100,
                1500,
                1000);

        CrucibleCrafting.addRecipe(
                Ingredient.fromStacks(new ItemStack(ModItems.brokensteeltool, 1)),
                new OreIngredient("nuggetSteel"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                new ItemStack(ModItems.steelingotball, 1),
                2100,
                1500,
                1000);

        CrucibleCrafting.addRecipe(
                new OreIngredient("dustMagnetite"),
                Ingredient.fromStacks(new ItemStack(Blocks.LEAVES, 1, BlockPlanks.EnumType.JUNGLE.getMetadata())),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_PURE, 1)),
                Ingredient.fromStacks(new ItemStack(Blocks.LEAVES, 1, BlockPlanks.EnumType.JUNGLE.getMetadata())),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_PURE, 1)),
                new ItemStack(PrimalAPI.Blocks.ORE_MAGNETITE, 1),
                new ItemStack(ModItems.wootzingotball, 1),
                2100,
                1800,
                1500);

        CrucibleCrafting.addRecipe(
                new OreIngredient("magnetite"),
                Ingredient.fromStacks(new ItemStack(Blocks.LEAVES, 1, BlockPlanks.EnumType.JUNGLE.getMetadata())),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_PURE, 1)),
                Ingredient.fromStacks(new ItemStack(Blocks.LEAVES, 1, BlockPlanks.EnumType.JUNGLE.getMetadata())),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CHARCOAL_PURE, 1)),
                new ItemStack(PrimalAPI.Blocks.ORE_MAGNETITE, 1),
                new ItemStack(ModItems.wootzingotball, 1),
                2100,
                1800,
                1500);

        CrucibleCrafting.addRecipe(
                Ingredient.fromStacks(new ItemStack(ModItems.brokenwootztool, 1)),
                new OreIngredient("nuggetWootz"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                new ItemStack(ModItems.wootzingotball, 1),
                2100,
                1800,
                1500);
*/
        /***BRONZE***/
/*
        NBTTagCompound tagBronzeDefault = new NBTTagCompound();
        tagBronzeDefault.setString("upgrades", "");
        tagBronzeDefault.setBoolean("hot", false);
        ItemStack defaultBronze = new ItemStack(ModItems.bronzeingotball, 1);
        defaultBronze.setTagCompound(tagBronzeDefault.copy());

        CrucibleCrafting.addRecipe(
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustTin"),
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                defaultBronze,
                1100,
                800,
                600);

        CrucibleCrafting.addRecipe(
                new OreIngredient("ingotBronze"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                defaultBronze,
                1100,
                800,
                600);

        ItemStack redBronze = defaultBronze.copy();
        redBronze.getTagCompound().setString("upgrades", "redstone");
        CrucibleCrafting.addRecipe(
                new OreIngredient("ingotBronze"),
                new OreIngredient("dustRedstone"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                redBronze,
                1100,
                800,
                600);

        ItemStack diamondBronze = defaultBronze.copy();
        diamondBronze.getTagCompound().setString("upgrades", "diamond");
        CrucibleCrafting.addRecipe(
                new OreIngredient("ingotBronze"),
                new OreIngredient("flakeDiamond"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                diamondBronze,
                1100,
                800,
                600);

        ItemStack emeraldBronze = defaultBronze.copy();
        emeraldBronze.getTagCompound().setString("upgrades", "emerald");
        CrucibleCrafting.addRecipe(
                new OreIngredient("ingotBronze"),
                new OreIngredient("flakeEmerald"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                emeraldBronze,
                1100,
                800,
                600);

        ItemStack lapisBronze = defaultBronze.copy();
        lapisBronze.getTagCompound().setString("upgrades", "lapis");
        CrucibleCrafting.addRecipe(
                new OreIngredient("ingotBronze"),
                new OreIngredient("gemLapis"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                lapisBronze,
                1100,
                800,
                600);

        CrucibleCrafting.addRecipe(
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustTin"),
                new OreIngredient("dustRedstone"),
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                redBronze,
                1100,
                800,
                600);

        CrucibleCrafting.addRecipe(
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustTin"),
                new OreIngredient("flakeDiamond"),
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                diamondBronze,
                1100,
                800,
                600);

        CrucibleCrafting.addRecipe(
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustTin"),
                new OreIngredient("flakeEmerald"),
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                emeraldBronze,
                1100,
                800,
                600);

        CrucibleCrafting.addRecipe(
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustCopper"),
                new OreIngredient("dustTin"),
                new OreIngredient("gemLapis"),
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                lapisBronze,
                1100,
                800,
                600);

*/
        /***COPPER***/
        /*
        NBTTagCompound tagCopperDefault = new NBTTagCompound();
        tagCopperDefault.setString("upgrades", "");
        tagCopperDefault.setBoolean("hot", false);
        ItemStack defaultCopper = new ItemStack(PrimalAPI.Items.COPPER_INGOT, 1);
        defaultCopper.setTagCompound(tagCopperDefault.copy());

        CrucibleCrafting.addRecipe(
                new OreIngredient("oreCopper"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                defaultCopper,
                900,
                800,
                600);

        CrucibleCrafting.addRecipe(
                new OreIngredient("ingotCopper"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                defaultCopper,
                900,
                750,
                550);

        ItemStack redCopper = defaultCopper.copy();
        redCopper.getTagCompound().setString("upgrades", "redstone");
        CrucibleCrafting.addRecipe(
                new OreIngredient("ingotCopper"),
                new OreIngredient("dustRedstone"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                redCopper,
                900,
                750,
                550);

        ItemStack diamondCopper = defaultCopper.copy();
        diamondCopper.getTagCompound().setString("upgrades", "diamond");
        CrucibleCrafting.addRecipe(
                new OreIngredient("ingotCopper"),
                new OreIngredient("flakeDiamond"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                diamondCopper,
                900,
                750,
                550);

        ItemStack emeraldCopper = defaultCopper.copy();
        emeraldCopper.getTagCompound().setString("upgrades", "emerald");
        CrucibleCrafting.addRecipe(
                new OreIngredient("ingotCopper"),
                new OreIngredient("flakeEmerald"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                emeraldCopper,
                900,
                750,
                550);

        ItemStack lapisCopper = defaultCopper.copy();
        lapisCopper.getTagCompound().setString("upgrades", "lapis");
        CrucibleCrafting.addRecipe(
                new OreIngredient("ingotCopper"),
                new OreIngredient("gemLapis"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                lapisCopper,
                900,
                750,
                550);

        CrucibleCrafting.addRecipe(
                new OreIngredient("oreCopper"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
                new OreIngredient("dustRedstone"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                redCopper,
                900,
                750,
                550);

        CrucibleCrafting.addRecipe(
                new OreIngredient("oreCopper"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
                new OreIngredient("flakeDiamond"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                diamondCopper,
                900,
                750,
                550);

        CrucibleCrafting.addRecipe(
                new OreIngredient("oreCopper"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
                new OreIngredient("flakeEmerald"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                emeraldCopper,
                900,
                750,
                550);

        CrucibleCrafting.addRecipe(
                new OreIngredient("oreCopper"),
                Ingredient.fromStacks(new ItemStack(PrimalAPI.Items.CARBONATE_SLACK, 1)),
                new OreIngredient("gemLapis"),
                Ingredient.EMPTY,
                Ingredient.EMPTY,
                new ItemStack(PrimalAPI.Items.SLAG, 1),
                lapisCopper,
                900,
                750,
                550);
*/


        /***CASTING FORM***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.castingform, 1),
                true, new Object[]{" S ", "S S", " S ",
                ('S'), "logSplit"
        });
        /***CASTING MUD***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.castingmud, 4),
                true, new Object[]{" C ", "CSC", " C ",
                ('S'), Blocks.SAND,
                ('C'), PrimalAPI.Items.MUD_CLUMP
        });
        /***YEW STAVE***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.yewstave, 2),
                true, new Object[]{"C", "C",
                ('C'), PrimalAPI.Items.LOGS_SPLIT_YEW
        });
        /***Unstrung Longbow***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.unstrunglongbow, 1),
                true, new Object[]{"C", "A",
                ('C'), "fatAnimal",
                ('A'), ModItems.rawlongbow
        });
        /***Longbow***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.longbow, 1),
                true, new Object[]{"C ","CA","C ",
                ('C'), PrimalAPI.Items.SILK_CORDAGE,
                ('A'), ModItems.unstrunglongbow
        });

        /***Forge***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.forge_brick),
                "X X", "XYX", "X X", 'X', Items.BRICK, 'Y', Blocks.FURNACE);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.forge_adobe),
                "X X", "XYX", "X X", 'X', PrimalAPI.Items.ADOBE_BRICK_DRY, 'Y', Blocks.FURNACE);
        /***Bloomery***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.bloomery_brick),
                "X X", "X X", "XXX", 'X', Items.BRICK);

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.bloomery_adobe),
                "X X", "X X", "XXX", 'X', PrimalAPI.Items.ADOBE_BRICK_DRY);
        /***Block Breaker***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.blockbreaker),
                "L  ", "BSB", "BBB", 'L', Blocks.LEVER, 'B', new ItemStack(Blocks.PLANKS, 1, OreDictionary.WILDCARD_VALUE), 'S', PrimalAPI.Items.SILK_CORDAGE_COILED);

        /*** Soft Crucible ***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.softcrucible),
                "X X", "X X", "XXX", 'X', Items.CLAY_BALL);

        /*** Soft Crucible ***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.softcrucible),
                "X X", "X X", "XXX", 'X', PrimalAPI.Items.MUD_CLUMP);

        /***Wooden PistonBellows***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.pistonbellowsoak), "XXX", "X Y", "XXX",
                'X', new ItemStack(Blocks.PLANKS, 1, 0), 'Y', ModItems.bellowshandle);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.pistonbellowsspruce), "XXX", "X Y", "XXX",
                'X', new ItemStack(Blocks.PLANKS, 1, 1), 'Y', ModItems.bellowshandle);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.pistonbellowsbirch), "XXX", "X Y", "XXX",
                'X', new ItemStack(Blocks.PLANKS, 1, 2), 'Y', ModItems.bellowshandle);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.pistonbellowsjungle), "XXX", "X Y", "XXX",
                'X', new ItemStack(Blocks.PLANKS, 1, 3), 'Y', ModItems.bellowshandle);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.pistonbellowsacacia), "XXX", "X Y", "XXX",
                'X', new ItemStack(Blocks.PLANKS, 1, 4), 'Y', ModItems.bellowshandle);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.pistonbellowsdarkoak), "XXX", "X Y", "XXX",
                'X', new ItemStack(Blocks.PLANKS, 1, 5), 'Y', ModItems.bellowshandle);

        /***Bellows Handle***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.bellowshandle),
                "X X", "X X", " X ", 'X', Items.STICK);

        /***Tongs***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.slottedtongs, 1),
                "X X", "YSY", 'X', Blocks.STONE, 'S', Items.STRING, 'Y', Items.STICK);

        /***Anvil***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.stoneanvil, 1),
                "   ", " I ", " S ", 'I', "ingotIron", 'S', Blocks.STONE);



        /***************************************************************
         * TOOL CRAFTING RECIPES
         ***************************************************************/

        /***Pickaxe Crafting***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.bronzepickaxe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.bronzepickaxehead, 1, OreDictionary.WILDCARD_VALUE), //new ItemStack( 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.ironpickaxe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.pickaxehead, 1, OreDictionary.WILDCARD_VALUE), //new ItemStack( 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.cleanironpickaxe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.cleanironpickaxehead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.steelpickaxe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.steelpickaxehead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.wootzpickaxe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.wootzpickaxehead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(Items.IRON_PICKAXE), "T", "S",
                ('T'), ModItems.pickaxehead,
                ('S'), Items.STICK);

        /***Axe Crafting***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.bronzeaxe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.bronzeaxehead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.ironaxe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.ironaxehead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.cleanironaxe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.cleanironaxehead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.steelaxe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.steelaxehead,1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.wootzaxe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.wootzaxehead,1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(Items.IRON_AXE), "T", "S",
                ('T'), ModItems.ironaxehead,
                ('S'), Items.STICK);

        /***Shovel Crafting***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.bronzeshovel, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.bronzeshovelhead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.ironshovel, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.ironshovelhead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.cleanironshovel, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.cleanironshovelhead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.steelshovel, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.steelshovelhead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.wootzshovel, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.wootzshovelhead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(Items.IRON_SHOVEL), "T", "S",
                ('T'), ModItems.ironshovelhead,
                ('S'), Items.STICK);

        /***Hoe Crafting***/
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.bronzehoe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.bronzehoehead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.ironhoe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.ironhoehead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.cleanironhoe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.cleanironhoehead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.steelhoe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.steelhoehead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.wootzhoe, 1), "T", "C", "S",
                ('T'), new ItemStack(ModItems.wootzhoehead, 1, OreDictionary.WILDCARD_VALUE),
                ('S'),  "stickTreatedWood",
                ('C'), "cordageGeneral");

        RecipeHandler.addShapedOreRecipe(new ItemStack(Items.IRON_HOE), "T", "S",
                ('T'), ModItems.ironhoehead,
                ('S'), Items.STICK);


        /***************************************************************
         * TOOL DISASSEMBLY RECIPES
         ***************************************************************/
        //RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.ironaxehead, 1, OreDictionary.WILDCARD_VALUE),
        //        "   ", " X ", "   ", 'X', ModItems.ironaxe);

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.bronzeaxehead, 1),
                true, "X", ('X'), new ItemStack(ModItems.bronzeaxe, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.bronzepickaxehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.bronzepickaxe, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.bronzeshovelhead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.bronzeshovel, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.bronzehoehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.bronzehoe, 1, OreDictionary.WILDCARD_VALUE));


        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.ironaxehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.ironaxe, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.pickaxehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.ironpickaxe, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.ironshovelhead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.ironshovel, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.ironhoehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.ironhoe, 1, OreDictionary.WILDCARD_VALUE));


        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.cleanironaxehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.cleanironaxe, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.cleanironpickaxehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.cleanironpickaxe, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.cleanironshovelhead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.cleanironshovel, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.cleanironhoehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.cleanironhoe, 1, OreDictionary.WILDCARD_VALUE));


        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.steelaxehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.steelaxe, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.steelpickaxehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.steelpickaxe, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.steelshovelhead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.steelshovel, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.steelhoehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.steelhoe, 1, OreDictionary.WILDCARD_VALUE));


        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.wootzaxehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.wootzaxe, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.wootzpickaxehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.wootzpickaxe, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.wootzshovelhead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.wootzshovel, 1, OreDictionary.WILDCARD_VALUE));

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModItems.wootzhoehead, 1, OreDictionary.WILDCARD_VALUE),
                true, "X", ('X'), new ItemStack(ModItems.wootzhoe, 1, OreDictionary.WILDCARD_VALUE));




        /******************************************************************************
         CASTING
         ******************************************************************************/

        Item empty = Items.AIR;
        Item muddd = ModItems.castingmud;

        //Casting Pickaxe
        CastingCrafting.addRecipe(
                new ItemStack(ModItems.bronzeingotball, 1),
                new Item[] {
                        muddd,muddd,muddd,muddd,muddd,
                        muddd,empty,empty,empty,muddd,
                        empty,muddd,muddd,muddd,empty,
                        muddd,muddd,muddd,muddd,muddd,
                        muddd,muddd,muddd,muddd,muddd },
                bronzepickaxehead
        );

        //Casting Shovel
        CastingCrafting.addRecipe(
                new ItemStack(ModItems.bronzeingotball, 1),
                new Item[] {
                        muddd,muddd,muddd,muddd,muddd,
                        muddd,muddd,empty,muddd,muddd,
                        muddd,empty,empty,empty,muddd,
                        muddd,empty,empty,empty,muddd,
                        muddd,empty,muddd,empty,muddd },
                bronzeshovelhead
        );

        //Casting Axe
        CastingCrafting.addRecipe(
                new ItemStack(ModItems.bronzeingotball, 1),
                new Item[] {
                        muddd,empty,empty,muddd,muddd,
                        muddd,empty,empty,empty,muddd,
                        muddd,empty,empty,empty,muddd,
                        muddd,empty,muddd,muddd,muddd,
                        muddd,muddd,muddd,muddd,muddd },
                bronzeaxehead
        );

        //Casting Hoe
        CastingCrafting.addRecipe(
                new ItemStack(ModItems.bronzeingotball, 1),
                new Item[] {
                        muddd,muddd,muddd,empty,empty,
                        muddd,muddd,empty,muddd,muddd,
                        muddd,empty,muddd,muddd,muddd,
                        empty,muddd,muddd,muddd,muddd,
                        muddd,muddd,muddd,muddd,muddd },
                bronzehoehead
        );

        //Casting Gladius
        CastingCrafting.addRecipe(
                new ItemStack(ModItems.bronzeingotball, 1),
                new Item[] {
                        muddd,muddd,muddd,muddd,muddd,
                        muddd,muddd,empty,muddd,muddd,
                        muddd,muddd,empty,muddd,muddd,
                        muddd,empty,empty,empty,muddd,
                        muddd,muddd,empty,muddd,muddd },
                new ItemStack(ModItems.bronzegladius, 1)
        );

        //Casting Bronze Plate
        CastingCrafting.addRecipe(
                new ItemStack(ModItems.bronzeingotball, 1),
                new Item[] {
                        muddd,muddd,muddd,muddd,muddd,
                        muddd,empty,empty,empty,muddd,
                        muddd,empty,empty,empty,muddd,
                        muddd,empty,empty,empty,muddd,
                        muddd,muddd,muddd,muddd,muddd },
                new ItemStack(PrimalAPI.Items.BRONZE_PLATE, 1)
        );

        //Casting Pickaxe
        CastingCrafting.addRecipe(
                new ItemStack(PrimalAPI.Items.COPPER_INGOT, 1),
                new Item[]{
                        muddd, muddd, muddd, muddd, muddd,
                        muddd, empty, empty, empty, muddd,
                        empty, muddd, muddd, muddd, empty,
                        muddd, muddd, muddd, muddd, muddd,
                        muddd, muddd, muddd, muddd, muddd},
                copperpickaxehead
        );

        //Casting Shovel
        CastingCrafting.addRecipe(
                new ItemStack(PrimalAPI.Items.COPPER_INGOT, 1),
                new Item[]{
                        muddd, muddd, muddd, muddd, muddd,
                        muddd, muddd, empty, muddd, muddd,
                        muddd, empty, empty, empty, muddd,
                        muddd, empty, empty, empty, muddd,
                        muddd, empty, muddd, empty, muddd},
                coppershovelhead
        );

        //Casting Axe
        CastingCrafting.addRecipe(
                new ItemStack(PrimalAPI.Items.COPPER_INGOT, 1),
                new Item[]{
                        muddd, empty, empty, muddd, muddd,
                        muddd, empty, empty, empty, muddd,
                        muddd, empty, empty, empty, muddd,
                        muddd, empty, muddd, muddd, muddd,
                        muddd, muddd, muddd, muddd, muddd},
                copperaxehead
        );

        //Casting Hoe
        CastingCrafting.addRecipe(
                new ItemStack(PrimalAPI.Items.COPPER_INGOT, 1),
                new Item[]{
                        muddd, muddd, muddd, empty, empty,
                        muddd, muddd, empty, muddd, muddd,
                        muddd, empty, muddd, muddd, muddd,
                        empty, muddd, muddd, muddd, muddd,
                        muddd, muddd, muddd, muddd, muddd},
                copperhoehead
        );
/*
        //Casting Gladius
        CastingCrafting.addRecipe(
                new ItemStack(PrimalAPI.Items.COPPER_INGOT, 1),
                new Item[] {
                        muddd,muddd,muddd,muddd,muddd,
                        muddd,muddd,empty,muddd,muddd,
                        muddd,muddd,empty,muddd,muddd,
                        muddd,empty,empty,empty,muddd,
                        muddd,muddd,empty,muddd,muddd },
                new ItemStack(ModItems.coppergladius, 1)
        );
*/

            //Casting Bronze Plate
            CastingCrafting.addRecipe(
                    new ItemStack(PrimalAPI.Items.COPPER_INGOT, 1),
                    new Item[]{
                            muddd, muddd, muddd, muddd, muddd,
                            muddd, empty, empty, empty, muddd,
                            muddd, empty, empty, empty, muddd,
                            muddd, empty, empty, empty, muddd,
                            muddd, muddd, muddd, muddd, muddd},
                    new ItemStack(PrimalAPI.Items.COPPER_PLATE, 1)
            );


        /******************************************************************************
          FORGING
         ******************************************************************************/

//Makes a Hot Iron Ingot
        ForgeCrafting.addRecipe(
                ModItems.ironingotball,
                //800, 200
                hotIronIngot,
                800,
                100,
                500,
                1.0f,
                1.0f
        );
//Makes a Hot Clean Iron Ingot
        ForgeCrafting.addRecipe(
                ModItems.ironcleaningotball,
                hotCleanIronIngot,
                900,
                250,
                500,
                1.0f,
                1.0f
        );
//Makes a Hot Steel Ingot
        ForgeCrafting.addRecipe(
                ModItems.steelingotball,
                hotSteelIngot,
                1000,
                300,
                500,
                1.0f,
                1.0f
        );
        //Makes a Hot Wootz Ingot
        ForgeCrafting.addRecipe(
                ModItems.wootzingotball,
                hotWootzIngot,
                1000,
                300,
                500,
                1.0f,
                1.0f
        );

// Converts a Vanilla Ingot into ForgeCraft Ingot Ball
        ForgeCrafting.addRecipe(
                Items.IRON_INGOT,
                hotIronIngot,
                800,
                200,
                500,
                1.0f,
                1.0f
        );

//Makes a Hot Iron Chunk
        ForgeCrafting.addRecipe(
                ModItems.wroughtironchunk,
                hotChunk,
                800,
                160,
                400,
                1.0f,
                1.0f
        );
//Makes a Hot Clean Iron Chunk
        ForgeCrafting.addRecipe(
                ModItems.ironcleanchunk,
                hotCleanChunk,
                900,
                250,
                500,
                1.0f,
                1.0f
        );
//Makes a Hot Steel Chunk
        ForgeCrafting.addRecipe(
                ModItems.steelchunk,
                hotSteelChunk,
                1000,
                300,
                500,
                1.0f,
                1.0f
        );

        //Makes a Hot Wootz Chunk
        ForgeCrafting.addRecipe(
                ModItems.wootzchunk,
                hotWootzChunk,
                1000,
                300,
                500,
                1.0f,
                1.0f
        );

        /***Makes a Hot Iron PickaxeHead***/
        ForgeCrafting.addRecipe(
                ModItems.pickaxehead,
                hotpickaxehead,
                800,
                160,
                400,
                1.0f,
                1.0f
        );

        /***Makes a Hot Clean Iron PickaxeHead***/
        ForgeCrafting.addRecipe(
                ModItems.cleanironpickaxehead,
                hotcleanpickaxehead,
                800,
                170,
                400,
                1.0f,
                1.0f
        );

        /***Makes a Hot Steel PickaxeHead***/
        ForgeCrafting.addRecipe(
                ModItems.steelpickaxehead,
                hotsteelpickaxehead,
                1000,
                180,
                400,
                1.0f,
                1.0f
        );

        /***Makes a Hot Wootz PickaxeHead***/
        ForgeCrafting.addRecipe(
                ModItems.wootzpickaxehead,
                hotwootzpickaxehead,
                1000,
                190,
                400,
                1.0f,
                1.0f
        );

        /***Makes a Hot Iron AxeHead***/
        ForgeCrafting.addRecipe(
                ModItems.ironaxehead,
                hotironaxehead,
                800,
                160,
                400,
                1.0f,
                1.0f
        );
        /***Makes a Hot Clean Iron AxeHead***/
        ForgeCrafting.addRecipe(
                ModItems.cleanironaxehead,
                hotcleanaxehead,
                800,
                170,
                400,
                1.0f,
                1.0f
        );
        /***Makes a Hot Steel AxeHead***/
        ForgeCrafting.addRecipe(
                ModItems.steelaxehead,
                hotsteelaxehead,
                1000,
                180,
                400,
                1.0f,
                1.0f
        );
        /***Makes a Hot Wootz AxeHead***/
        ForgeCrafting.addRecipe(
                ModItems.wootzaxehead,
                hotwootzaxehead,
                1000,
                190,
                400,
                1.0f,
                1.0f
        );

        /***Makes a Hot Iron ShovelHead***/
        ForgeCrafting.addRecipe(
                ModItems.ironshovelhead,
                hotironshovelhead,
                800,
                160,
                400,
                1.0f,
                1.0f
        );
        /***Makes a Hot Clean Iron ShovelHead***/
        ForgeCrafting.addRecipe(
                ModItems.cleanironshovelhead,
                hotcleanshovelhead,
                800,
                170,
                400,
                1.0f,
                1.0f
        );
        /***Makes a Hot Steel ShovelHead***/
        ForgeCrafting.addRecipe(
                ModItems.steelshovelhead,
                hotsteelshovelhead,
                1000,
                180,
                400,
                1.0f,
                1.0f
        );
        /***Makes a Hot Wootz ShovelHead***/
        ForgeCrafting.addRecipe(
                ModItems.wootzshovelhead,
                hotwootzshovelhead,
                1000,
                190,
                400,
                1.0f,
                1.0f
        );

        /***Makes a Hot Iron HoeHead***/
        ForgeCrafting.addRecipe(
                ModItems.ironhoehead,
                hotironhoehead,
                800,
                160,
                400,
                1.0f,
                1.0f
        );
        /***Makes a Hot Clean Iron HoeHead***/
        ForgeCrafting.addRecipe(
                ModItems.cleanironhoehead,
                hotcleanhoehead,
                800,
                170,
                400,
                1.0f,
                1.0f
        );
        /***Makes a Hot Steel HoeHead***/
        ForgeCrafting.addRecipe(
                ModItems.steelhoehead,
                hotsteelhoehead,
                1000,
                180,
                400,
                1.0f,
                1.0f
        );
        /***Makes a Hot Wootz HoeHead***/
        ForgeCrafting.addRecipe(
                ModItems.wootzhoehead,
                hotwootzhoehead,
                1000,
                190,
                400,
                1.0f,
                1.0f
        );

        /******************************************************************************
               ANVILING
         ******************************************************************************/



        /*** ForgeHammer ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,hotChunk,hotChunk,hotChunk,emptyAir,
                        emptyAir,hotChunk,hotChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir },
                new ItemStack(ModItems.forgehammer, 1),
                "null"
        );

        /*** ForgeHammer ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,emptyAir,
                        emptyAir,hotCleanChunk,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir },
                new ItemStack(ModItems.forgehammer, 1),
                "null"
        );

        /*** ForgeHammer ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,emptyAir,
                        emptyAir,hotSteelChunk,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir },
                new ItemStack(ModItems.forgehammer, 1),
                "null"
        );

        /*** ForgeHammer ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,emptyAir,
                        emptyAir,hotWootzChunk,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir },
                new ItemStack(ModItems.forgehammer, 1),
                "null"
        );

        /*** Bucket ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,hotChunk,emptyAir,hotChunk,emptyAir,
                        emptyAir,hotChunk,emptyAir,hotChunk,emptyAir,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(Items.BUCKET, 1),
                "null"
        );

        /*** Bucket ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,hotCleanChunk,emptyAir,hotCleanChunk,emptyAir,
                        emptyAir,hotCleanChunk,emptyAir,hotCleanChunk,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(Items.BUCKET, 1),
                "null"
        );

        /*** Bucket ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,hotSteelChunk,emptyAir,hotSteelChunk,emptyAir,
                        emptyAir,hotSteelChunk,emptyAir,hotSteelChunk,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(Items.BUCKET, 1),
                "null"
        );

        /*** Primal Plate ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,hotChunk,hotChunk,hotChunk,emptyAir,
                        emptyAir,hotChunk,hotChunk,hotChunk,emptyAir,
                        emptyAir,hotChunk,hotChunk,hotChunk,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(PrimalAPI.Items.IRON_PLATE, 1),
                "null"
        );

        /*** Primal Plate ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,emptyAir,
                        emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,emptyAir,
                        emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(PrimalAPI.Items.IRON_PLATE, 1),
                "null"
        );

        /*** Steel Plate ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,emptyAir,
                        emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,emptyAir,
                        emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(PrimalAPI.Items.STEEL_PLATE, 1),
                "null"
        );



        /*** Steel Plate ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,emptyAir,
                        emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,emptyAir,
                        emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(PrimalAPI.Items.STEEL_PLATE, 1),
                "null"
        );

        /*** Flaked diamond ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamond,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(PrimalAPI.Items.DIAMOND_KNAPP, PrimalAPI.randomChanceReturn(2, 2, 3)),
                "null"
        );

        /*** Temp Iron Sword ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir,
                        emptyAir,hotChunk,hotChunk,hotChunk,emptyAir,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir },
                new ItemStack(ModItems.wroughtirongladius, 1),
                "null"
        );
        /*** Temp Clean Iron Sword ***/

        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanirongladius, 1),
                "null"
        );
        /*** Temp Steel Sword ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir },
                new ItemStack(ModItems.steelgladius, 1),
                "null"
        );
        /*** Temp Wootz Sword ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzgladius, 1),
                "null"
        );
        /*** Temp Clean Iron LongSword ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironlongsword, 1),
                "null"
        );
        /*** Temp Steel LongSword ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir },
                new ItemStack(ModItems.steellongsword, 1),
                "null"
        );
        /*** Temp Wootz LongSword ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzlongsword, 1),
                "null"
        );

        /*** Temp WROUGHTIRON SLAYER ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,hotChunk,hotChunk,hotChunk,
                        emptyAir,emptyAir,hotChunk,hotChunk,emptyAir,
                        emptyAir,emptyAir,hotChunk,hotChunk,emptyAir,
                        emptyAir,hotChunk,hotChunk,hotChunk,hotChunk,
                        emptyAir,emptyAir,hotChunk,hotChunk,emptyAir },
                new ItemStack(ModItems.wroughtironslayer, 1),
                "null"
        );
        /*** Temp CLEANIRON SLAYER ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,
                        emptyAir,emptyAir,hotCleanChunk,hotCleanChunk,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,hotCleanChunk,emptyAir,
                        emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,hotCleanChunk,
                        emptyAir,emptyAir,hotCleanChunk,hotCleanChunk,emptyAir },
                new ItemStack(ModItems.cleanironslayer, 1),
                "null"
        );
        /*** Temp STEELSLAYER ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,
                        emptyAir,emptyAir,hotSteelChunk,hotSteelChunk,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,hotSteelChunk,emptyAir,
                        emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,hotSteelChunk,
                        emptyAir,emptyAir,hotSteelChunk,hotSteelChunk,emptyAir },
                new ItemStack(ModItems.steelslayer, 1),
                "null"
        );
        /*** Temp WOOTZ SLAYER ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,
                        emptyAir,emptyAir,hotWootzChunk,hotWootzChunk,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,hotWootzChunk,emptyAir,
                        emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,hotWootzChunk,
                        emptyAir,emptyAir,hotWootzChunk,hotWootzChunk,emptyAir },
                new ItemStack(ModItems.wootzslayer, 1),
                "null"
        );
        
        
        
        /*** Flaked emerald ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emerald,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(PrimalAPI.Items.EMERALD_KNAPP, PrimalAPI.randomChanceReturn(3, 2, 3)),
                "null"
        );

        /*******************************************************
         *                       Pickaxes                      *
         *******************************************************/
        /***Iron Pickaxe Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,hotChunk,hotChunk,hotChunk,emptyAir,
                        hotChunk,emptyAir,emptyAir,emptyAir,hotChunk,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.pickaxehead, 1),
                "null"
        );
        /***Clean Iron Pickaxe Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,emptyAir,
                        hotCleanChunk,emptyAir,emptyAir,emptyAir,hotCleanChunk,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironpickaxehead, 1),
                "null"
        );
        /***Steel Pickaxe Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,emptyAir,
                        hotSteelChunk,emptyAir,emptyAir,emptyAir,hotSteelChunk,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelpickaxehead, 1),
                "null"
        );
        /***Wootz Pickaxe Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,emptyAir,
                        hotWootzChunk,emptyAir,emptyAir,emptyAir,hotWootzChunk,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzpickaxehead, 1),
                "null"
        );

        /*** REPAIR Iron Pickaxe Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,pickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.pickaxehead, 1),
                "repair"
        );
        /*** REPAIR Clean Iron Pickaxe Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironpickaxehead, 1),
                "repair"
        );
        /*** REPAIR Steel Pickaxe Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelpickaxehead, 1),
                "repair"
        );
        /*** REPAIR Wootz Pickaxe Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzpickaxehead, 1),
                "repair"
        );

        /*** Emerald Upgrade to Iron Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,pickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.pickaxehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Iron Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,pickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.pickaxehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Iron Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,pickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.pickaxehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Iron Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,pickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.pickaxehead, 1),
                "lapis"
        );

        /*** Emerald Upgrade to Clean Iron Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironpickaxehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Clean Iron Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironpickaxehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Clean Iron Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironpickaxehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Clean Iron Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironpickaxehead, 1),
                "lapis"
        );

        /*** Emerald Upgrade to Steel Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelpickaxehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Steel Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelpickaxehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Steel Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelpickaxehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Steel Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelpickaxehead, 1),
                "lapis"
        );

        /*** Emerald Upgrade to Wootz Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzpickaxehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Wootz Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzpickaxehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Wootz Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzpickaxehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Wootz Pickaxe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzpickaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzpickaxehead, 1),
                "lapis"
        );

        /*******************************************************
         *                        Axes                         *
         *******************************************************/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,hotChunk,hotChunk,emptyAir,emptyAir,
                        emptyAir,hotChunk,hotChunk,hotChunk,emptyAir,
                        emptyAir,hotChunk,hotChunk,hotChunk,emptyAir,
                        emptyAir,hotChunk,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironaxehead, 1),
                "null"
        );
        /*** REPAIR AXE Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironaxehead, 1),
                "repair"
        );
        /*** Clean Iron Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,hotCleanChunk,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,emptyAir,
                        emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,emptyAir,
                        emptyAir,hotCleanChunk,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironaxehead, 1),
                "null"
        );
        /*** REPAIR Clean Iron AXE Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironaxehead, 1),
                "repair"
        );
        /*** Steel Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,hotSteelChunk,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,emptyAir,
                        emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,emptyAir,
                        emptyAir,hotSteelChunk,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelaxehead, 1),
                "null"
        );
        /*** REPAIR steel AXE Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelaxehead, 1),
                "repair"
        );
        /*** Wootz Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,hotWootzChunk,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,emptyAir,
                        emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,emptyAir,
                        emptyAir,hotWootzChunk,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzaxehead, 1),
                "null"
        );
        /*** REPAIR Wootz AXE Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzaxehead, 1),
                "repair"
        );


        /*** Emerald Upgrade to Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironaxehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironaxehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironaxehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironaxehead, 1),
                "lapis"
        );

        /*** Emerald Upgrade to Clean Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironaxehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Clean Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironaxehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Clean Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironaxehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Clean Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironaxehead, 1),
                "lapis"
        );

        /*** Emerald Upgrade to Steel Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelaxehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Steel Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelaxehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Steel Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelaxehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Steel Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelaxehead, 1),
                "lapis"
        );

        /*** Emerald Upgrade to Wootz Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzaxehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Wootz Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzaxehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Wootz Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzaxehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Wootz Axe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzaxehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzaxehead, 1),
                "lapis"
        );

        /*******************************************************
         *                       Shovel                        *
         *******************************************************/
        /*** Iron Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir,
                        emptyAir,hotChunk,hotChunk,hotChunk,emptyAir,
                        emptyAir,hotChunk,hotChunk,hotChunk,emptyAir,
                        emptyAir,hotChunk,emptyAir,hotChunk,emptyAir },
                new ItemStack(ModItems.ironshovelhead, 1),
                "null"
        );

        /*** REPAIR iron SHOVEL Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironshovelhead, 1),
                "repair"
        );
        /*** Clean Iron Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,emptyAir,
                        emptyAir,hotCleanChunk,hotCleanChunk,hotCleanChunk,emptyAir,
                        emptyAir,hotCleanChunk,emptyAir,hotCleanChunk,emptyAir },
                new ItemStack(ModItems.cleanironshovelhead, 1),
                "null"
        );

        /*** REPAIR clean iron SHOVEL Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironshovelhead, 1),
                "repair"
        );
        /*** Steel Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,emptyAir,
                        emptyAir,hotSteelChunk,hotSteelChunk,hotSteelChunk,emptyAir,
                        emptyAir,hotSteelChunk,emptyAir,hotSteelChunk,emptyAir },
                new ItemStack(ModItems.steelshovelhead, 1),
                "null"
        );

        /*** REPAIR steel SHOVEL Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelshovelhead, 1),
                "repair"
        );
        /*** Wootz Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,emptyAir,
                        emptyAir,hotWootzChunk,hotWootzChunk,hotWootzChunk,emptyAir,
                        emptyAir,hotWootzChunk,emptyAir,hotWootzChunk,emptyAir },
                new ItemStack(ModItems.wootzshovelhead, 1),
                "null"
        );

        /*** REPAIR Wootz SHOVEL Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzshovelhead, 1),
                "repair"
        );

        /*** Emerald Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironshovelhead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironshovelhead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironshovelhead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironshovelhead, 1),
                "lapis"
        );
        /*** Emerald Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironshovelhead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironshovelhead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironshovelhead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironshovelhead, 1),
                "lapis"
        );
        /*** Emerald Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelshovelhead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelshovelhead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelshovelhead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelshovelhead, 1),
                "lapis"
        );
        //
        /*** Emerald Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzshovelhead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzshovelhead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzshovelhead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Shovel Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzshovelhead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzshovelhead, 1),
                "lapis"
        );

        /*******************************************************
         *                         Hoe                         *
         *******************************************************/
        /*** Iron Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,hotChunk,hotChunk,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir,
                        emptyAir,hotChunk,emptyAir,emptyAir,emptyAir,
                        hotChunk,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironhoehead, 1),
                "null"
        );

        /*** REPAIR Iron HOE Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironhoehead, 1),
                "repair"
        );
        /*** Clean Iron Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,hotCleanChunk,hotCleanChunk,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,hotCleanChunk,emptyAir,emptyAir,emptyAir,
                        hotCleanChunk,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironhoehead, 1),
                "null"
        );

        /*** REPAIR Clean Iron HOE Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotCleanChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironhoehead, 1),
                "repair"
        );
        /*** Steel Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,hotSteelChunk,hotSteelChunk,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,hotSteelChunk,emptyAir,emptyAir,emptyAir,
                        hotSteelChunk,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelhoehead, 1),
                "null"
        );

        /*** REPAIR Steel HOE Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelhoehead, 1),
                "repair"
        );
        /*** Wootz Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,hotWootzChunk,hotWootzChunk,
                        emptyAir,emptyAir,hotWootzChunk,emptyAir,emptyAir,
                        emptyAir,hotWootzChunk,emptyAir,emptyAir,emptyAir,
                        hotWootzChunk,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzhoehead, 1),
                "null"
        );

        /*** REPAIR Wootz HOE Head***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,hotSteelChunk,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzhoehead, 1),
                "repair"
        );

        /*** Emerald Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironhoehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironhoehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironhoehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,ironhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.ironhoehead, 1),
                "lapis"
        );
        /*** Emerald Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironhoehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironhoehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironhoehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,cleanhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.cleanironhoehead, 1),
                "lapis"
        );
        /*** Emerald Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelhoehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelhoehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelhoehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,steelhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.steelhoehead, 1),
                "lapis"
        );
        //
        /*** Emerald Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emeraldShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzhoehead, 1),
                "emerald"
        );

        /*** Diamond Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,diamondShard,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzhoehead, 1),
                "diamond"
        );

        /*** Redstone Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,redstone,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzhoehead, 1),
                "redstone"
        );

        /*** Lapis Upgrade to Hoe Head ***/
        AnvilCrafting.addRecipe(
                new ItemStack [] {
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,lapis,emptyAir,emptyAir,
                        emptyAir,emptyAir,wootzhoehead,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir,
                        emptyAir,emptyAir,emptyAir,emptyAir,emptyAir },
                new ItemStack(ModItems.wootzhoehead, 1),
                "lapis"
        );

    }
}
