package nmd.primal.forgecraft.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalMaterials;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.items.*;
import nmd.primal.forgecraft.items.armor.CustomLeggings;
import nmd.primal.forgecraft.items.casting.CastingPart;
import nmd.primal.forgecraft.items.parts.BronzeToolPart;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.items.tools.*;
import nmd.primal.forgecraft.items.weapons.CustomShield;
import nmd.primal.forgecraft.items.weapons.CustomSword;
import nmd.primal.forgecraft.items.weapons.Longbow;
import nmd.primal.forgecraft.items.weapons.SlayerSword;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ModItems {

    //public static Item test;
    public static Item bellowshandle;
    public static Item forgehammer;
    public static Item softcrucible;
    public static Item stonetongs;
    public static Item castingmud;

    public static Item ironingotballhot;
    public static Item ironchunkhot;
    public static Item ironcleaningotballhot;
    public static Item ironcleanchunkhot;
    public static Item steelingotballhot;
    public static Item steelchunkhot;
    public static Item wootzingotballhot;
    public static Item wootzchunkhot;


    public static Item cast_axe;
    public static Item cast_gladius;
    public static Item cast_hoe;
    public static Item cast_pickaxe;
    public static Item cast_shovel;


    public static Item pickaxehead;
    public static Item ironaxehead;
    public static Item ironshovelhead;
    public static Item ironhoehead;

    public static Item cleanironpickaxehead;
    public static Item cleanironaxehead;
    public static Item cleanironshovelhead;
    public static Item cleanironhoehead;

    public static Item steelpickaxehead;
    public static Item steelaxehead;
    public static Item steelshovelhead;
    public static Item steelhoehead;

    public static Item wootzpickaxehead;
    public static Item wootzaxehead;
    public static Item wootzshovelhead;
    public static Item wootzhoehead;


    public static Item bronzepickaxehead;
    public static Item bronzeaxehead;
    public static Item bronzeshovelhead;
    public static Item bronzehoehead;

    public static Item bronzepickaxe;
    public static Item bronzeaxe;
    public static Item bronzeshovel;
    public static Item bronzehoe;

    public static Item ironpickaxe;
    public static Item ironaxe;
    public static Item ironshovel;
    public static Item ironhoe;

    public static Item cleanironpickaxe;
    public static Item cleanironaxe;
    public static Item cleanironshovel;
    public static Item cleanironhoe;

    public static Item steelpickaxe;
    public static Item steelaxe;
    public static Item steelshovel;
    public static Item steelhoe;

    public static Item wootzpickaxe;
    public static Item wootzaxe;
    public static Item wootzshovel;
    public static Item wootzhoe;

    public static Item bronzegladius;
    public static Item wroughtirongladius;
    public static Item cleanirongladius;
    public static Item steelgladius;

    public static Item cleanironlongsword;
    public static Item steellongsword;

    public static Item wroughtironslayer;
    public static Item cleanironslayer;
    public static Item steelslayer;

    public static Item brokenbronzetool;
    public static Item brokenwroughtirontool;
    public static Item brokencleanirontool;
    public static Item brokensteeltool;
    public static Item brokenwootztool;

    public static Item wroughtironshield;
    //public static Item cleanironshield;
    //public static Item steelshield;
    //public static Item wootzshield;

    public static Item matchlockmusket;
    public static Item rawlongbow;
    public static Item unstrunglongbow;
    public static Item longbow;


    //public static Item testleggings;

    //public static Item forgingmanual;

    public static void init() {
        //OBJLoader.INSTANCE.addDomain(ModInfo.MOD_ID);
        //pistonbellows = new ItemBellowsHandle("pistonbellows");
        bellowshandle = new BaseItem("bellowshandle");
        softcrucible = new ItemSoftCrucible("softcrucible");
        stonetongs = new ItemStoneTongs("stonetongs");
        forgehammer = new ForgeHammer("forgehammer");
        castingmud = new BaseItem("castingmud");

        rawlongbow = new BaseItem("rawlongbow");
        unstrunglongbow = new BaseItem("unstrunglongbow");
        longbow = new Longbow("longbow");
        //matchlockmusket = new Musket("matchlock_musket");


        /**********
         CASTING PARTS
         **********/
        cast_axe = new CastingPart("cast_axe");
        cast_gladius = new CastingPart("cast_gladius");
        cast_hoe = new CastingPart("cast_hoe");
        cast_pickaxe = new CastingPart("cast_pickaxe");
        cast_shovel = new CastingPart("cast_shovel");

        /**********
         TOOL PARTS
         **********/

        bronzepickaxehead = new BronzeToolPart("bronzepickaxehead", PrimalMaterials.TOOL_BRONZE, 41);
        bronzeaxehead = new BronzeToolPart("bronzeaxehead", PrimalMaterials.TOOL_BRONZE, 42);
        bronzeshovelhead = new BronzeToolPart("bronzeshovelhead", PrimalMaterials.TOOL_BRONZE, 43);
        bronzehoehead = new BronzeToolPart("bronzehoehead", PrimalMaterials.TOOL_BRONZE, 44);

        pickaxehead = new ToolPart("ironpickaxehead", PrimalMaterials.TOOL_WROUGHT_IRON, 8);
        ironaxehead = new ToolPart("ironaxehead", PrimalMaterials.TOOL_WROUGHT_IRON, 9);
        ironshovelhead = new ToolPart("ironshovelhead", PrimalMaterials.TOOL_WROUGHT_IRON, 10);
        ironhoehead = new ToolPart("ironhoehead", PrimalMaterials.TOOL_WROUGHT_IRON, 11);

        cleanironpickaxehead = new ToolPart("cleanironpickaxehead", PrimalMaterials.TOOL_CLEAN_IRON, 17);
        cleanironaxehead = new ToolPart("cleanironaxehead", PrimalMaterials.TOOL_CLEAN_IRON, 18);
        cleanironshovelhead = new ToolPart("cleanironshovelhead", PrimalMaterials.TOOL_CLEAN_IRON, 19);
        cleanironhoehead = new ToolPart("cleanironhoehead", PrimalMaterials.TOOL_CLEAN_IRON, 20);

        steelpickaxehead = new ToolPart("steelpickaxehead", PrimalMaterials.TOOL_BASIC_STEEL, 26);
        steelaxehead = new ToolPart("steelaxehead", PrimalMaterials.TOOL_BASIC_STEEL, 27);
        steelshovelhead = new ToolPart("steelshovelhead", PrimalMaterials.TOOL_BASIC_STEEL, 28);
        steelhoehead = new ToolPart("steelhoehead", PrimalMaterials.TOOL_BASIC_STEEL, 29);

        wootzpickaxehead = new ToolPart("wootzpickaxehead", PrimalMaterials.TOOL_WOOTZ_STEEL, 35);
        wootzaxehead = new ToolPart("wootzaxehead", PrimalMaterials.TOOL_WOOTZ_STEEL, 36);
        wootzshovelhead = new ToolPart("wootzshovelhead", PrimalMaterials.TOOL_WOOTZ_STEEL, 37);
        wootzhoehead = new ToolPart("wootzhoehead", PrimalMaterials.TOOL_WOOTZ_STEEL, 38);
        /**********
         TOOLS
         **********/
        bronzepickaxe = new BronzePickaxe("bronzepickaxe", PrimalMaterials.TOOL_BRONZE, bronzepickaxehead);
        bronzeaxe = new BronzeAxe("bronzeaxe", PrimalMaterials.TOOL_BRONZE, bronzeaxehead);
        bronzeshovel = new BronzeShovel("bronzeshovel", PrimalMaterials.TOOL_BRONZE, bronzeshovelhead);
        bronzehoe = new BronzeHoe("bronzehoe", PrimalMaterials.TOOL_BRONZE, bronzehoehead);

        ironpickaxe = new CustomPickaxe("ironpickaxe", PrimalMaterials.TOOL_WROUGHT_IRON, pickaxehead);
        ironaxe = new CustomAxe("ironaxe", PrimalMaterials.TOOL_WROUGHT_IRON, ironaxehead);
        ironshovel = new CustomShovel("ironshovel", PrimalMaterials.TOOL_WROUGHT_IRON, ironshovelhead);
        ironhoe = new CustomHoe("ironhoe", PrimalMaterials.TOOL_WROUGHT_IRON, ironhoehead);

        cleanironpickaxe = new CustomPickaxe("cleanironpickaxe", PrimalMaterials.TOOL_CLEAN_IRON, cleanironpickaxehead);
        cleanironaxe = new CustomAxe("cleanironaxe", PrimalMaterials.TOOL_CLEAN_IRON, cleanironaxehead);
        cleanironshovel = new CustomShovel("cleanironshovel", PrimalMaterials.TOOL_CLEAN_IRON, cleanironshovelhead);
        cleanironhoe = new CustomHoe("cleanironhoe", PrimalMaterials.TOOL_CLEAN_IRON, cleanironhoehead);

        steelpickaxe = new CustomPickaxe("steelpickaxe", PrimalMaterials.TOOL_BASIC_STEEL, steelpickaxehead);
        steelaxe = new CustomAxe("steelaxe", PrimalMaterials.TOOL_BASIC_STEEL, steelaxehead);
        steelshovel = new CustomShovel("steelshovel", PrimalMaterials.TOOL_BASIC_STEEL, steelshovelhead);
        steelhoe = new CustomHoe("steelhoe", PrimalMaterials.TOOL_BASIC_STEEL, steelhoehead);

        wootzpickaxe = new CustomPickaxe("wootzpickaxe", PrimalMaterials.TOOL_WOOTZ_STEEL, wootzpickaxehead);
        wootzaxe = new CustomAxe("wootzaxe", PrimalMaterials.TOOL_WOOTZ_STEEL, wootzaxehead);
        wootzshovel = new CustomShovel("wootzshovel", PrimalMaterials.TOOL_WOOTZ_STEEL, wootzshovelhead);
        wootzhoe = new CustomHoe("wootzhoe", PrimalMaterials.TOOL_WOOTZ_STEEL, wootzhoehead);

        /**********
         WEAPONS
         **********/
        bronzegladius = new CustomSword("bronzegladius", PrimalMaterials.TOOL_BRONZE, 5D, 2D);
        wroughtirongladius = new CustomSword("wroughtirongladius", PrimalMaterials.TOOL_WROUGHT_IRON, 4.5D, -1.85D);
        cleanirongladius = new CustomSword("cleanirongladius", PrimalMaterials.TOOL_CLEAN_IRON, 5D, -1.85D);
        steelgladius = new CustomSword("steelgladius", PrimalMaterials.TOOL_BASIC_STEEL,6D, -1.85D);

        cleanironlongsword = new CustomSword("cleanironlongsword", PrimalMaterials.TOOL_CLEAN_IRON, 7D, -2.5D);
        steellongsword = new CustomSword("steellongsword", PrimalMaterials.TOOL_BASIC_STEEL,8D, -2.25D);

        wroughtironslayer = new SlayerSword("wroughtironslayer", PrimalMaterials.TOOL_WROUGHT_IRON, 11.5D, -3.7D);
        cleanironslayer = new SlayerSword("cleanironslayer", PrimalMaterials.TOOL_CLEAN_IRON, 10D, -3.5D);
        steelslayer = new SlayerSword("steelslayer", PrimalMaterials.TOOL_BASIC_STEEL,11D, -3.3D);

        wroughtironshield = new CustomShield("wroughtironshield", PrimalMaterials.TOOL_WROUGHT_IRON);

        /**********
         INGOTS AND CHUNKS
         **********/
        ironingotballhot = new BaseMultiItem("ironingothot", PrimalMaterials.TOOL_WROUGHT_IRON, 6);
        ironchunkhot = new BaseMultiItem("ironchunkhot", PrimalMaterials.TOOL_WROUGHT_IRON, 7);
        ironcleaningotballhot= new BaseMultiItem("ironcleaningotballhot", PrimalMaterials.TOOL_CLEAN_IRON, 15);
        ironcleanchunkhot= new BaseMultiItem("ironcleanchunkhot", PrimalMaterials.TOOL_CLEAN_IRON, 16);
        steelingotballhot= new BaseMultiItem("steelingotballhot", PrimalMaterials.TOOL_BASIC_STEEL, 24);
        steelchunkhot= new BaseMultiItem("steelchunkhot", PrimalMaterials.TOOL_BASIC_STEEL, 25);
        wootzingotballhot= new BaseMultiItem("wootzingotballhot", PrimalMaterials.TOOL_WOOTZ_STEEL, 33);
        wootzchunkhot= new BaseMultiItem("wootzchunkhot", PrimalMaterials.TOOL_WOOTZ_STEEL, 34);

        //forgingmanual = new ItemForgingManual();
        //test = new ItemTest("ironsword");

        brokenbronzetool = new BaseItem("brokenbronzetool");
        brokenwroughtirontool = new BaseItem("brokenwroughtirontool");
        brokencleanirontool = new BaseItem("brokencleanirontool");
        brokensteeltool = new BaseItem("brokensteeltool");
        brokenwootztool = new BaseItem("brokenwootztool");

        /**********
         ARMOR
         **********/
        //testleggings=new CustomLeggings(PrimalMaterials.ARMOR_ADAMANT, 3, EntityEquipmentSlot.LEGS, "testleggings");
        //registerItem(312, "diamond_leggings", (new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.LEGS)).setUnlocalizedName("leggingsDiamond"));
    }

    public static void register() {
        ForgeRegistries.ITEMS.register(castingmud);
        ForgeRegistries.ITEMS.register(bellowshandle);
        ForgeRegistries.ITEMS.register(softcrucible);
        ForgeRegistries.ITEMS.register(stonetongs);
        ForgeRegistries.ITEMS.register(forgehammer);
        ForgeRegistries.ITEMS.register(ironingotballhot);
        ForgeRegistries.ITEMS.register(ironchunkhot);
        ForgeRegistries.ITEMS.register(ironcleaningotballhot);
        ForgeRegistries.ITEMS.register(ironcleanchunkhot);
        ForgeRegistries.ITEMS.register(steelingotballhot);
        ForgeRegistries.ITEMS.register(steelchunkhot);
        ForgeRegistries.ITEMS.register(wootzingotballhot);
        ForgeRegistries.ITEMS.register(wootzchunkhot);
        //ForgeRegistries.ITEMS.register(test);

        /**********
         CASTING PARTS
         **********/
        ForgeRegistries.ITEMS.register(cast_axe);
        ForgeRegistries.ITEMS.register(cast_gladius);
        ForgeRegistries.ITEMS.register(cast_hoe);
        ForgeRegistries.ITEMS.register(cast_pickaxe);
        ForgeRegistries.ITEMS.register(cast_shovel);

        /**********
         TOOL PARTS
         **********/
        ForgeRegistries.ITEMS.register(bronzepickaxehead);
        ForgeRegistries.ITEMS.register(bronzeaxehead);
        ForgeRegistries.ITEMS.register(bronzeshovelhead);
        ForgeRegistries.ITEMS.register(bronzehoehead);

        ForgeRegistries.ITEMS.register(pickaxehead);
        ForgeRegistries.ITEMS.register(ironaxehead);
        ForgeRegistries.ITEMS.register(ironshovelhead);
        ForgeRegistries.ITEMS.register(ironhoehead);

        ForgeRegistries.ITEMS.register(cleanironpickaxehead);
        ForgeRegistries.ITEMS.register(cleanironaxehead);
        ForgeRegistries.ITEMS.register(cleanironshovelhead);
        ForgeRegistries.ITEMS.register(cleanironhoehead);

        ForgeRegistries.ITEMS.register(steelpickaxehead);
        ForgeRegistries.ITEMS.register(steelaxehead);
        ForgeRegistries.ITEMS.register(steelshovelhead);
        ForgeRegistries.ITEMS.register(steelhoehead);

        ForgeRegistries.ITEMS.register(wootzpickaxehead);
        ForgeRegistries.ITEMS.register(wootzaxehead);
        ForgeRegistries.ITEMS.register(wootzshovelhead);
        ForgeRegistries.ITEMS.register(wootzhoehead);

        /**********
         TOOLS
         **********/
        ForgeRegistries.ITEMS.register(bronzepickaxe);
        ForgeRegistries.ITEMS.register(bronzeaxe);
        ForgeRegistries.ITEMS.register(bronzeshovel);
        ForgeRegistries.ITEMS.register(bronzehoe);

        ForgeRegistries.ITEMS.register(ironpickaxe);
        ForgeRegistries.ITEMS.register(ironaxe);
        ForgeRegistries.ITEMS.register(ironshovel);
        ForgeRegistries.ITEMS.register(ironhoe);

        ForgeRegistries.ITEMS.register(cleanironpickaxe);
        ForgeRegistries.ITEMS.register(cleanironaxe);
        ForgeRegistries.ITEMS.register(cleanironshovel);
        ForgeRegistries.ITEMS.register(cleanironhoe);

        ForgeRegistries.ITEMS.register(steelpickaxe);
        ForgeRegistries.ITEMS.register(steelaxe);
        ForgeRegistries.ITEMS.register(steelshovel);
        ForgeRegistries.ITEMS.register(steelhoe);

        ForgeRegistries.ITEMS.register(wootzpickaxe);
        ForgeRegistries.ITEMS.register(wootzaxe);
        ForgeRegistries.ITEMS.register(wootzshovel);
        ForgeRegistries.ITEMS.register(wootzhoe);

        /**********
         WEAPONS
         **********/
        ForgeRegistries.ITEMS.register(wroughtirongladius);
        ForgeRegistries.ITEMS.register(bronzegladius);
        ForgeRegistries.ITEMS.register(cleanirongladius);
        ForgeRegistries.ITEMS.register(steelgladius);

        ForgeRegistries.ITEMS.register(cleanironlongsword);
        ForgeRegistries.ITEMS.register(steellongsword);

        ForgeRegistries.ITEMS.register(wroughtironslayer);
        ForgeRegistries.ITEMS.register(cleanironslayer);
        ForgeRegistries.ITEMS.register(steelslayer);

        ForgeRegistries.ITEMS.register(rawlongbow);
        ForgeRegistries.ITEMS.register(unstrunglongbow);
        ForgeRegistries.ITEMS.register(longbow);
        //ForgeRegistries.ITEMS.register(matchlockmusket);

        ForgeRegistries.ITEMS.register(brokenbronzetool);
        ForgeRegistries.ITEMS.register(brokenwroughtirontool);
        ForgeRegistries.ITEMS.register(brokencleanirontool);
        ForgeRegistries.ITEMS.register(brokensteeltool);
        ForgeRegistries.ITEMS.register(brokenwootztool);

        /**********
         ARMOR
         **********/
        //ForgeRegistries.ITEMS.register(testleggings);



        //ForgeRegistries.ITEMS.register(forgingmanual);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        registerRender(castingmud);
        registerRender(bellowshandle);
        registerRender(softcrucible);
        registerRender(forgehammer);
        registerRender(ironingotballhot);
        registerRender(ironchunkhot);
        registerRender(ironcleaningotballhot);
        registerRender(ironcleanchunkhot);
        registerRender(steelingotballhot);
        registerRender(steelchunkhot);
        //registerRender(test);

        /**********
         CASTING PARTS
         **********/
        registerRender(cast_axe);
        registerRender(cast_gladius);
        registerRender(cast_hoe);
        registerRender(cast_pickaxe);
        registerRender(cast_shovel);

        /**********
         TOOL PARTS
         **********/
        registerRender(bronzepickaxehead);
        registerRender(bronzeaxehead);
        registerRender(bronzeshovelhead);
        registerRender(bronzehoehead);

        registerRender(pickaxehead);
        registerRender(ironaxehead);
        registerRender(ironshovelhead);
        registerRender(ironhoehead);

        registerRender(cleanironpickaxehead);
        registerRender(cleanironaxehead);
        registerRender(cleanironshovelhead);
        registerRender(cleanironhoehead);

        registerRender(steelpickaxehead);
        registerRender(steelaxehead);
        registerRender(steelshovelhead);
        registerRender(steelhoehead);

        registerRender(wootzpickaxehead);
        registerRender(wootzaxehead);
        registerRender(wootzshovelhead);
        registerRender(wootzhoehead);

        /**********
         TOOLS
         **********/
        registerRender(bronzepickaxe);
        registerRender(bronzeaxe);
        registerRender(bronzeshovel);
        registerRender(bronzehoe);

        registerRender(ironpickaxe);
        registerRender(ironaxe);
        registerRender(ironshovel);
        registerRender(ironhoe);

        registerRender(cleanironpickaxe);
        registerRender(cleanironaxe);
        registerRender(cleanironshovel);
        registerRender(cleanironhoe);

        registerRender(steelpickaxe);
        registerRender(steelaxe);
        registerRender(steelshovel);
        registerRender(steelhoe);

        registerRender(wootzpickaxe);
        registerRender(wootzaxe);
        registerRender(wootzshovel);
        registerRender(wootzhoe);

        /**********
         WEAPONS
         **********/
        registerRender(wroughtironshield);

        registerRender(bronzegladius);
        registerRender(wroughtirongladius);
        registerRender(cleanirongladius);
        registerRender(steelgladius);

        registerRender(cleanironlongsword);
        registerRender(steellongsword);

        registerRender(wroughtironslayer);
        registerRender(cleanironslayer);
        registerRender(steelslayer);

        registerRender(rawlongbow);
        registerRender(unstrunglongbow);
        registerRender(longbow);
        //registerRender(forgingmanual);
        //registerRender(matchlockmusket);


        registerRender(brokenbronzetool);
        registerRender(brokenwroughtirontool);
        registerRender(brokencleanirontool);
        registerRender(brokensteeltool);
        registerRender(brokenwootztool);


        /**********
         ARMOR
         **********/
        //registerRender(testleggings);

    }

    @SideOnly(Side.CLIENT)
    public static void registerCustomRenders(){
        ModelBakery.registerItemVariants(ModItems.stonetongs, ModItems.stonetongs.getRegistryName(),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_default"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_emptyhot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_emptyhotcracked"),

                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotiron"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotironcooked"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotironfailed"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_ingot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_chunk"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_pickaxe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_axe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_shovel_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hoe_hot"),

                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotcleaniron"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotcleanironcooked"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotcleanironfailed"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_cleanironingot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_cleanironchunk"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_cleaniron_pickaxe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_cleaniron_axe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_cleaniron_shovel_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_cleaniron_hoe_hot"),

                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotsteel"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotsteelcooked"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotsteelfailed"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_steelingot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_steelchunk"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_steel_pickaxe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_steel_axe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_steel_shovel_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_steel_hoe_hot"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotbronze"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotbronzecooked"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotbronze_lapis"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotbronzecooked_lapis"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotbronze_redstone"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotbronzecooked_redstone"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotbronze_emerald"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotbronzecooked_emerald"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotbronze_diamond"),
                new ResourceLocation(ModInfo.MOD_ID, "stonetongs_hotbronzecooked_diamond")
                );
        ModelLoader.setCustomMeshDefinition(ModItems.stonetongs, new ItemMeshDefinition() {

            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                if (stack.hasTagCompound()) {
                  if (stack.getTagCompound().getInteger("type") == 0 ){
                    return new ModelResourceLocation(stack.getItem().getRegistryName() + "_default", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 1 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_emptyhot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 2 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_emptyhotcracked", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 3 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotiron", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 4 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotironcooked", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 5 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotironfailed", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 6 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_ingot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 7 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_chunk", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 8 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_pickaxe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 9 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_axe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 10 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_shovel_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 11 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hoe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 12 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotcleaniron", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 13 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotcleanironcooked", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 14 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotcleanironfailed", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 15 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_cleanironingot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 16 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_cleanironchunk", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 17 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_cleaniron_pickaxe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 18 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_cleaniron_axe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 19 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_cleaniron_shovel_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 20 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_cleaniron_hoe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 21 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotsteel", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 22 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotsteelcooked", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 23 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotsteelfailed", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 24 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_steelingot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 25 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_steelchunk", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 26 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_steel_pickaxe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 27 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_steel_axe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 28 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_steel_shovel_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 29 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_steel_hoe_hot", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 39 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotbronze", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 40 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotbronzecooked", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 45 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotbronze_emerald", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 46 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotbronzecooked_emerald", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 47 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotbronze_diamond", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 48 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotbronzecooked_diamond", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 49 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotbronze_redstone", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 50 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotbronzecooked_redstone", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 51 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotbronze_lapis", "inventory");
                  }
                  else if (stack.getTagCompound().getInteger("type") == 52 ) {
                      return new ModelResourceLocation(stack.getItem().getRegistryName() + "_hotbronzecooked_lapis", "inventory");
                  }
                  else return new ModelResourceLocation(stack.getItem().getRegistryName(), "inventory");
                }
                return new ModelResourceLocation(stack.getItem().getRegistryName(), "inventory");
            }
        });
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    private static void registerRenderItemBlock(ItemBlock item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    /*public static void registerRender(Item item, int meta, String fileName) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(fileName), "inventory"));

    }

    public static void registerRender(Item item, int meta, String fileName) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(fileName, "inventory"));
    }*/



}
