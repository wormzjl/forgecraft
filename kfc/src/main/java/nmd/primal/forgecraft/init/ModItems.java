package nmd.primal.forgecraft.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.items.*;
import nmd.primal.forgecraft.items.armor.CustomHelmet;
import nmd.primal.forgecraft.items.blocks.ItemNBTCrucible;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.items.parts.WeaponPart;
import nmd.primal.forgecraft.items.tools.CustomAxe;
import nmd.primal.forgecraft.items.tools.CustomHoe;
import nmd.primal.forgecraft.items.tools.CustomPickaxe;
import nmd.primal.forgecraft.items.tools.CustomShovel;
import nmd.primal.forgecraft.items.weapons.*;

/**
 * Created by kitsu on 11/26/2016.
 */

public class ModItems {

    //public static Item test;
    public static Item itemnbtcrucible;
    public static Item slottedtongs;
   // public static Item itemcrucible;
    public static Item bellowshandle;
    public static Item forgehammer;
    public static Item softcrucible;
    //public static Item stonetongs;
    public static Item castingmud;



    public static Item bronzeingotball;
    public static Item bronzechunk;
    public static Item ironingotball;
    public static Item wroughtironchunk;
    public static Item ironcleaningotball;
    public static Item ironcleanchunk;
    public static Item steelingotball;
    public static Item steelchunk;
    public static Item wootzingotball;
    public static Item wootzchunk;

    public static Item ironsledgehammer;
    public static Item coppersledgehammer;
    public static Item bronzesledgehammer;
    public static Item cleanironsledgehammer;
    public static Item steelsledgehammer;
    public static Item wootzsledgehammer;

    public static Item copperpickaxehead;
    public static Item copperaxehead;
    public static Item coppershovelhead;
    public static Item copperhoehead;

    public static Item copperpickaxe;
    public static Item copperaxe;
    public static Item coppershovel;
    public static Item copperhoe;


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

    public static Item rawbronzegladius;
    public static Item rawcoppergladius;
    public static Item rawwroughtirongladius;
    public static Item rawcleanirongladius;
    public static Item rawsteelgladius;
    public static Item rawwootzgladius;

    public static Item bronzegladius;
    public static Item wroughtirongladius;
    public static Item cleanirongladius;
    public static Item steelgladius;
    public static Item wootzgladius;

    public static Item cleanironlongsword;
    public static Item steellongsword;
    public static Item wootzlongsword;

    public static Item wroughtironslayer;
    public static Item cleanironslayer;
    public static Item steelslayer;
    public static Item wootzslayer;

    public static Item brokencoppertool;
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
    public static Item wootzworkblade;

    public static Item leatherhelmet;
    //public static Item testleggings;

    //public static Item forgingmanual;

    public static void init() {

        //OBJLoader.INSTANCE.addDomain(ModInfo.MOD_ID);
        //pistonbellows = new ItemBellowsHandle("pistonbellows");
        itemnbtcrucible = new ItemNBTCrucible("itemnbtcrucible", ModBlocks.nbtCrucible);
        slottedtongs = new SlottedTongs("slottedtongs");
        //itemcrucible = new ItemCrucible("itemcrucible");
        bellowshandle = new BaseItem("bellowshandle");
        softcrucible = new ItemSoftCrucible("softcrucible");
        //stonetongs = new ItemStoneTongs("stonetongs");
        forgehammer = new ForgeHammer("forgehammer");
        castingmud = new BaseItem("castingmud");

        rawlongbow = new RawLongbow("rawlongbow");
        unstrunglongbow = new BaseItem("unstrunglongbow");
        longbow = new Longbow("longbow");
        //matchlockmusket = new Musket("matchlock_musket");
        wootzworkblade = new Workblade("wootzworkblade", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, -1.0F).setFireProof(true);


        /**********
         TOOL PARTS
         **********/
        copperpickaxehead = new ToolPart("copperpickaxehead", PrimalAPI.ToolMaterials.TOOL_COPPER, "pickaxe");
        copperaxehead = new ToolPart("copperaxehead", PrimalAPI.ToolMaterials.TOOL_COPPER, "axe");
        coppershovelhead= new ToolPart("coppershovelhead", PrimalAPI.ToolMaterials.TOOL_COPPER, "shovel");
        copperhoehead = new ToolPart("copperhoehead", PrimalAPI.ToolMaterials.TOOL_COPPER, "hoe");

        bronzepickaxehead = new ToolPart("bronzepickaxehead", PrimalAPI.ToolMaterials.TOOL_BRONZE, "pickaxe");
        bronzeaxehead = new ToolPart("bronzeaxehead", PrimalAPI.ToolMaterials.TOOL_BRONZE, "axe");
        bronzeshovelhead = new ToolPart("bronzeshovelhead", PrimalAPI.ToolMaterials.TOOL_BRONZE, "shovel");
        bronzehoehead = new ToolPart("bronzehoehead", PrimalAPI.ToolMaterials.TOOL_BRONZE, "hoe");

        pickaxehead = new ToolPart("ironpickaxehead", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, "pickaxe");
        ironaxehead = new ToolPart("ironaxehead", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, "axe");
        ironshovelhead = new ToolPart("ironshovelhead", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, "shovel");
        ironhoehead = new ToolPart("ironhoehead", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, "hoe");

        cleanironpickaxehead = new ToolPart("cleanironpickaxehead", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, "pickaxe");
        cleanironaxehead = new ToolPart("cleanironaxehead", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, "axe");
        cleanironshovelhead = new ToolPart("cleanironshovelhead", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, "shovel");
        cleanironhoehead = new ToolPart("cleanironhoehead", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, "hoe");

        steelpickaxehead = new ToolPart("steelpickaxehead", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL, "pickaxe");
        steelaxehead = new ToolPart("steelaxehead", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL, "axe");
        steelshovelhead = new ToolPart("steelshovelhead", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL, "shovel");
        steelhoehead = new ToolPart("steelhoehead", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL, "hoe");

        wootzpickaxehead = new ToolPart("wootzpickaxehead", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, "pickaxe");
        wootzaxehead = new ToolPart("wootzaxehead", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, "axe");
        wootzshovelhead = new ToolPart("wootzshovelhead", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, "shovel");
        wootzhoehead = new ToolPart("wootzhoehead", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, "hoe");

        /**********
         TOOLS
         **********/
        copperpickaxe = new CustomPickaxe("copperpickaxe", PrimalAPI.ToolMaterials.TOOL_COPPER, brokencoppertool);
        copperaxe = new CustomAxe("copperaxe", PrimalAPI.ToolMaterials.TOOL_COPPER, brokencoppertool, 4, -2.6F);
        coppershovel = new CustomShovel("coppershovel", PrimalAPI.ToolMaterials.TOOL_COPPER, brokencoppertool);
        copperhoe = new CustomHoe("copperhoe", PrimalAPI.ToolMaterials.TOOL_COPPER, brokencoppertool);
        coppersledgehammer = new SledgeHammer("coppersledgehammer", PrimalAPI.ToolMaterials.TOOL_COPPER, 12, -3.7D);

        bronzepickaxe = new CustomPickaxe("bronzepickaxe", PrimalAPI.ToolMaterials.TOOL_BRONZE, bronzepickaxehead);
        bronzeaxe = new CustomAxe("bronzeaxe", PrimalAPI.ToolMaterials.TOOL_BRONZE, bronzeaxehead, 5, -2.4f);
        bronzeshovel = new CustomShovel("bronzeshovel", PrimalAPI.ToolMaterials.TOOL_BRONZE, bronzeshovelhead);
        bronzehoe = new CustomHoe("bronzehoe", PrimalAPI.ToolMaterials.TOOL_BRONZE, bronzehoehead);
        bronzesledgehammer = new SledgeHammer("bronzesledgehammer", PrimalAPI.ToolMaterials.TOOL_BRONZE, 12, -3.7D);

        ironpickaxe = new CustomPickaxe("ironpickaxe", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, pickaxehead);
        ironaxe = new CustomAxe("ironaxe", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, ironaxehead, 5, -3.6f);
        ironshovel = new CustomShovel("ironshovel", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, ironshovelhead);
        ironhoe = new CustomHoe("ironhoe", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, ironhoehead);
        ironsledgehammer = new SledgeHammer("ironsledgehammer", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, 12, -3.7D);

        cleanironpickaxe = new CustomPickaxe("cleanironpickaxe", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, cleanironpickaxehead);
        cleanironaxe = new CustomAxe("cleanironaxe", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, cleanironaxehead, 6, -3.2f);
        cleanironshovel = new CustomShovel("cleanironshovel", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, cleanironshovelhead);
        cleanironhoe = new CustomHoe("cleanironhoe", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, cleanironhoehead);
        cleanironsledgehammer = new SledgeHammer("cleanironsledgehammer", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, 12, -3.7D);

        steelpickaxe = new CustomPickaxe("steelpickaxe", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL, steelpickaxehead);
        steelaxe = new CustomAxe("steelaxe", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL, steelaxehead, 7, -2.8f);
        steelshovel = new CustomShovel("steelshovel", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL, steelshovelhead);
        steelhoe = new CustomHoe("steelhoe", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL, steelhoehead);
        steelsledgehammer = new SledgeHammer("steelsledgehammer", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL, 12, -3.5D);

        wootzpickaxe = new CustomPickaxe("wootzpickaxe", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, wootzpickaxehead);
        wootzaxe = new CustomAxe("wootzaxe", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, wootzaxehead, 8, -2.4f);
        wootzshovel = new CustomShovel("wootzshovel", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, wootzshovelhead);
        wootzhoe = new CustomHoe("wootzhoe", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, wootzhoehead);
        wootzsledgehammer = new SledgeHammer("wootzsledgehammer", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, 12, -3.4D);

        /**********
         WEAPONS
         **********/
        rawbronzegladius = new WeaponPart("rawbronzegladius", PrimalAPI.ToolMaterials.TOOL_BRONZE);
        rawcoppergladius= new WeaponPart("rawcoppergladius", PrimalAPI.ToolMaterials.TOOL_COPPER);
        rawwroughtirongladius= new WeaponPart("rawwroughtirongladius", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON);
        rawcleanirongladius= new WeaponPart("rawcleanirongladius", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON);
        rawsteelgladius= new WeaponPart("rawsteelgladius", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL);
        rawwootzgladius= new WeaponPart("rawwootzgladius", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL);

        bronzegladius = new CustomSword("bronzegladius", PrimalAPI.ToolMaterials.TOOL_BRONZE, 5.5D, 2D);
        wroughtirongladius = new CustomSword("wroughtirongladius", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, 4.5D, -1.85D);
        cleanirongladius = new CustomSword("cleanirongladius", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, 5D, -1.85D);
        steelgladius = new CustomSword("steelgladius", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL,6D, -1.85D);
        wootzgladius = new CustomSword("wootzgladius", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, 7D, -1.75D);

        cleanironlongsword = new CustomSword("cleanironlongsword", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, 7D, -2.5D);
        steellongsword = new CustomSword("steellongsword", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL,8D, -2.25D);
        wootzlongsword = new CustomSword("wootzlongsword", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL,9D, -2D);

        wroughtironslayer = new SlayerSword("wroughtironslayer", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, 11.5D, -3.7D);
        cleanironslayer = new SlayerSword("cleanironslayer", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, 10D, -3.5D);
        steelslayer = new SlayerSword("steelslayer", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL,11D, -3.3D);
        wootzslayer = new SlayerSword("wootzslayer", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL,11D, -3.1D);

        wroughtironshield = new CustomShield("wroughtironshield", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON);

        /**********
         INGOTS AND CHUNKS
         **********/

        bronzeingotball = new BaseMultiItem("bronzeingotball", PrimalAPI.ToolMaterials.TOOL_BRONZE);
        bronzechunk = new BaseMultiItem("bronzechunk", PrimalAPI.ToolMaterials.TOOL_BRONZE);
        ironingotball = new BaseMultiItem("ironingotball", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON);
        wroughtironchunk = new BaseMultiItem("wroughtironchunk", PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON);
        ironcleaningotball= new BaseMultiItem("ironcleaningotball", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON);
        ironcleanchunk= new BaseMultiItem("ironcleanchunk", PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON);
        steelingotball= new BaseMultiItem("steelingotball", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL);
        steelchunk= new BaseMultiItem("steelchunk", PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL);
        wootzingotball= new BaseMultiItem("wootzingotball", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL);
        wootzchunk= new BaseMultiItem("wootzchunk", PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL);


        //forgingmanual = new ItemForgingManual();
        //test = new ItemTest("ironsword");

        brokencoppertool = new BaseItem("brokencoppertool");
        brokenbronzetool = new BaseItem("brokenbronzetool");
        brokenwroughtirontool = new BaseItem("brokenwroughtirontool");
        brokencleanirontool = new BaseItem("brokencleanirontool");
        brokensteeltool = new BaseItem("brokensteeltool");
        brokenwootztool = new BaseItem("brokenwootztool");

        /**********
         ARMOR
         **********/
        leatherhelmet=new CustomHelmet(PrimalAPI.ArmorMaterials.ARMOR_HIDE, 0, EntityEquipmentSlot.HEAD, "leatherhelmet");
        //testleggings=new CustomHelmet(PrimalAPI.ToolMaterials.ARMOR_ADAMANT, 3, EntityEquipmentSlot.LEGS, "testleggings");
        //registerItem(312, "diamond_leggings", (new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.LEGS)).setUnlocalizedName("leggingsDiamond"));
    }

    public static void register() {
        //ForgeRegistries.ITEMS.register();

        ForgeRegistries.ITEMS.register(itemnbtcrucible);
        ForgeRegistries.ITEMS.register(slottedtongs);
        //ForgeRegistries.ITEMS.register(itemcrucible);
        ForgeRegistries.ITEMS.register(castingmud);
        ForgeRegistries.ITEMS.register(bellowshandle);
        ForgeRegistries.ITEMS.register(softcrucible);
        ForgeRegistries.ITEMS.register(wootzworkblade);
        ForgeRegistries.ITEMS.register(forgehammer);

        ForgeRegistries.ITEMS.register(bronzeingotball);
        ForgeRegistries.ITEMS.register(bronzechunk);
        ForgeRegistries.ITEMS.register(ironingotball);
        ForgeRegistries.ITEMS.register(wroughtironchunk);
        ForgeRegistries.ITEMS.register(ironcleaningotball);
        ForgeRegistries.ITEMS.register(ironcleanchunk);
        ForgeRegistries.ITEMS.register(steelingotball);
        ForgeRegistries.ITEMS.register(steelchunk);
        ForgeRegistries.ITEMS.register(wootzingotball);
        ForgeRegistries.ITEMS.register(wootzchunk);

        //ForgeRegistries.ITEMS.register(test);

        /**********
         TOOL PARTS
         **********/

        ForgeRegistries.ITEMS.register(copperpickaxehead);
        ForgeRegistries.ITEMS.register(copperaxehead);
        ForgeRegistries.ITEMS.register(coppershovelhead);
        ForgeRegistries.ITEMS.register(copperhoehead);

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
        ForgeRegistries.ITEMS.register(copperpickaxe);
        ForgeRegistries.ITEMS.register(copperaxe);
        ForgeRegistries.ITEMS.register(coppershovel);
        ForgeRegistries.ITEMS.register(copperhoe);
        ForgeRegistries.ITEMS.register(coppersledgehammer);

        ForgeRegistries.ITEMS.register(bronzepickaxe);
        ForgeRegistries.ITEMS.register(bronzeaxe);
        ForgeRegistries.ITEMS.register(bronzeshovel);
        ForgeRegistries.ITEMS.register(bronzehoe);
        ForgeRegistries.ITEMS.register(bronzesledgehammer);

        ForgeRegistries.ITEMS.register(ironpickaxe);
        ForgeRegistries.ITEMS.register(ironaxe);
        ForgeRegistries.ITEMS.register(ironshovel);
        ForgeRegistries.ITEMS.register(ironhoe);
        ForgeRegistries.ITEMS.register(ironsledgehammer);

        ForgeRegistries.ITEMS.register(cleanironpickaxe);
        ForgeRegistries.ITEMS.register(cleanironaxe);
        ForgeRegistries.ITEMS.register(cleanironshovel);
        ForgeRegistries.ITEMS.register(cleanironhoe);
        ForgeRegistries.ITEMS.register(cleanironsledgehammer);

        ForgeRegistries.ITEMS.register(steelpickaxe);
        ForgeRegistries.ITEMS.register(steelaxe);
        ForgeRegistries.ITEMS.register(steelshovel);
        ForgeRegistries.ITEMS.register(steelhoe);
        ForgeRegistries.ITEMS.register(steelsledgehammer);

        ForgeRegistries.ITEMS.register(wootzpickaxe);
        ForgeRegistries.ITEMS.register(wootzaxe);
        ForgeRegistries.ITEMS.register(wootzshovel);
        ForgeRegistries.ITEMS.register(wootzhoe);
        ForgeRegistries.ITEMS.register(wootzsledgehammer);

        /**********
         WEAPONS
         **********/
        ForgeRegistries.ITEMS.register(rawbronzegladius);
        ForgeRegistries.ITEMS.register(rawcoppergladius);
        ForgeRegistries.ITEMS.register(rawwroughtirongladius);
        ForgeRegistries.ITEMS.register(rawcleanirongladius);
        ForgeRegistries.ITEMS.register(rawsteelgladius);
        ForgeRegistries.ITEMS.register(rawwootzgladius);

        ForgeRegistries.ITEMS.register(wroughtirongladius);
        ForgeRegistries.ITEMS.register(bronzegladius);
        ForgeRegistries.ITEMS.register(cleanirongladius);
        ForgeRegistries.ITEMS.register(steelgladius);
        ForgeRegistries.ITEMS.register(wootzgladius);

        ForgeRegistries.ITEMS.register(cleanironlongsword);
        ForgeRegistries.ITEMS.register(steellongsword);
        ForgeRegistries.ITEMS.register(wootzlongsword);

        ForgeRegistries.ITEMS.register(wroughtironslayer);
        ForgeRegistries.ITEMS.register(cleanironslayer);
        ForgeRegistries.ITEMS.register(steelslayer);
        ForgeRegistries.ITEMS.register(wootzslayer);

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
        ForgeRegistries.ITEMS.register(leatherhelmet);
        //ForgeRegistries.ITEMS.register(testleggings);



        //ForgeRegistries.ITEMS.register(forgingmanual);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        registerRender(itemnbtcrucible);
        registerRender(slottedtongs);
        registerRender(castingmud);
        registerRender(bellowshandle);
        registerRender(softcrucible);
        registerRender(forgehammer);
        registerRender(wootzworkblade);

        registerRender(bronzeingotball);
        registerRender(bronzechunk);
        registerRender(ironingotball);
        registerRender(wroughtironchunk);
        registerRender(ironcleaningotball);
        registerRender(ironcleanchunk);
        registerRender(steelingotball);
        registerRender(steelchunk);
        registerRender(wootzingotball);
        registerRender(wootzchunk);

        //registerRender(test);

        /**********
         TOOL PARTS
         **********/

        registerRender(copperpickaxehead);
        registerRender(copperaxehead);
        registerRender(coppershovelhead);
        registerRender(copperhoehead);

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
        registerRender(copperpickaxe);
        registerRender(copperaxe);
        registerRender(coppershovel);
        registerRender(copperhoe);
        registerRender(coppersledgehammer);

        registerRender(bronzepickaxe);
        registerRender(bronzeaxe);
        registerRender(bronzeshovel);
        registerRender(bronzehoe);
        registerRender(bronzesledgehammer);

        registerRender(ironpickaxe);
        registerRender(ironaxe);
        registerRender(ironshovel);
        registerRender(ironhoe);
        registerRender(ironsledgehammer);

        registerRender(cleanironpickaxe);
        registerRender(cleanironaxe);
        registerRender(cleanironshovel);
        registerRender(cleanironhoe);
        registerRender(cleanironsledgehammer);

        registerRender(steelpickaxe);
        registerRender(steelaxe);
        registerRender(steelshovel);
        registerRender(steelhoe);
        registerRender(steelsledgehammer);

        registerRender(wootzpickaxe);
        registerRender(wootzaxe);
        registerRender(wootzshovel);
        registerRender(wootzhoe);
        registerRender(wootzsledgehammer);

        /**********
         WEAPONS
         **********/
        //registerRender(wroughtironshield);

        registerRender(rawbronzegladius);
        registerRender(rawcoppergladius);
        registerRender(rawwroughtirongladius);
        registerRender(rawcleanirongladius);
        registerRender(rawsteelgladius);
        registerRender(rawwootzgladius);

        registerRender(bronzegladius);
        registerRender(wroughtirongladius);
        registerRender(cleanirongladius);
        registerRender(steelgladius);
        registerRender(wootzgladius);

        registerRender(cleanironlongsword);
        registerRender(steellongsword);
        registerRender(wootzlongsword);

        registerRender(wroughtironslayer);
        registerRender(cleanironslayer);
        registerRender(steelslayer);
        registerRender(wootzslayer);

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
        registerRender(leatherhelmet);

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
