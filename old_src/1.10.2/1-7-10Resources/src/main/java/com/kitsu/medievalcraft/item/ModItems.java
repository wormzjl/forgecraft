package com.kitsu.medievalcraft.item;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.craftingtools.FireBow;
import com.kitsu.medievalcraft.item.craftingtools.FlintSaw;
import com.kitsu.medievalcraft.item.craftingtools.ForgeHammer;
import com.kitsu.medievalcraft.item.craftingtools.InlayHammer;
import com.kitsu.medievalcraft.item.craftingtools.IronSaw;
import com.kitsu.medievalcraft.item.craftingtools.LeatherShears;
import com.kitsu.medievalcraft.item.craftingtools.SlottedTongs;
import com.kitsu.medievalcraft.item.craftingtools.WorkBlade;
import com.kitsu.medievalcraft.item.craftingtools.filters.CoarseFilter;
import com.kitsu.medievalcraft.item.craftingtools.filters.FineFilter;
import com.kitsu.medievalcraft.item.craftingtools.filters.MediumFilter;
import com.kitsu.medievalcraft.item.forms.clay.CClayAxeForm;
import com.kitsu.medievalcraft.item.forms.clay.CClayBattleAxeForm;
import com.kitsu.medievalcraft.item.forms.clay.CClayDaggerForm;
import com.kitsu.medievalcraft.item.forms.clay.CClayHoeForm;
import com.kitsu.medievalcraft.item.forms.clay.CClayLongswordForm;
import com.kitsu.medievalcraft.item.forms.clay.CClayMaceHeadForm;
import com.kitsu.medievalcraft.item.forms.clay.CClayPickaxeForm;
import com.kitsu.medievalcraft.item.forms.clay.CClayRingForm;
import com.kitsu.medievalcraft.item.forms.clay.CClaySawBladeForm;
import com.kitsu.medievalcraft.item.forms.clay.CClaySharpTipForm;
import com.kitsu.medievalcraft.item.forms.clay.CClayShortSwordForm;
import com.kitsu.medievalcraft.item.forms.clay.CClaySpadeForm;
import com.kitsu.medievalcraft.item.forms.clay.CClaySpearTipForm;
import com.kitsu.medievalcraft.item.forms.iron.IronAxeForm;
import com.kitsu.medievalcraft.item.forms.iron.IronBattleAxeForm;
import com.kitsu.medievalcraft.item.forms.iron.IronDaggerForm;
import com.kitsu.medievalcraft.item.forms.iron.IronHandleForm;
import com.kitsu.medievalcraft.item.forms.iron.IronHoeForm;
import com.kitsu.medievalcraft.item.forms.iron.IronLongswordForm;
import com.kitsu.medievalcraft.item.forms.iron.IronMaceHeadForm;
import com.kitsu.medievalcraft.item.forms.iron.IronPickaxeForm;
import com.kitsu.medievalcraft.item.forms.iron.IronRingForm;
import com.kitsu.medievalcraft.item.forms.iron.IronSawBladeForm;
import com.kitsu.medievalcraft.item.forms.iron.IronSharpTipForm;
import com.kitsu.medievalcraft.item.forms.iron.IronShortSwordForm;
import com.kitsu.medievalcraft.item.forms.iron.IronSpadeForm;
import com.kitsu.medievalcraft.item.forms.iron.IronSpearTipForm;
import com.kitsu.medievalcraft.item.misc.ItemBark;
import com.kitsu.medievalcraft.item.misc.ItemSmallBarrelLid;
import com.kitsu.medievalcraft.item.misc.RawCuredLeather;
import com.kitsu.medievalcraft.item.throwable.ItemITSpear;
import com.kitsu.medievalcraft.item.throwable.ItemShit;
import com.kitsu.medievalcraft.item.throwable.ItemTester;
import com.kitsu.medievalcraft.item.tools.CustomIronHoe;
import com.kitsu.medievalcraft.item.tools.CustomIronLumberAxe;
import com.kitsu.medievalcraft.item.tools.CustomIronPick;
import com.kitsu.medievalcraft.item.tools.CustomIronShovel;
import com.kitsu.medievalcraft.item.weapon.ItemBattleAxe;
import com.kitsu.medievalcraft.item.weapon.ItemGladius;
import com.kitsu.medievalcraft.item.weapon.ItemHeavyMace;
import com.kitsu.medievalcraft.item.weapon.ItemIronShield;
import com.kitsu.medievalcraft.item.weapon.ItemIronTippedModelArrow;
//import com.kitsu.medievalcraft.item.weapon.ItemIronShield;
import com.kitsu.medievalcraft.item.weapon.ItemLongSword;
import com.kitsu.medievalcraft.item.weapon.ItemLongbow;
import com.kitsu.medievalcraft.item.weapon.ItemModelArrow;
import com.kitsu.medievalcraft.item.weapon.ItemWoodenShield;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;


public final class ModItems {
	
	public static Item slottedTongs;
	
	
	public static Item leatherStrap;
	public static Item wovenLeather;
	public static Item ironChunk;
	public static Item hotironChunk;
	public static Item ironRing;
	
	public static Item itemShit;
	public static Item itemITSpear;
	public static Item itemTester;
	
	public static Item linkedRings;
	public static Item ironRingMesh;
	public static Item chainMailPlate;
	//public static Item hotIronIngot;
	public static Item woodenPlate;
	public static Item ironweaponHandle;
	public static Item woodentoolHandle;
	//public static Item refinedIngot;
	public static Item charcoalLeafPellet;
	public static Item unstrungLongbow;
	public static Item itemBark;
	public static Item quartzDust;
	public static Item salt;
	public static Item strippedSapling;
	public static Item saplingRing;
	public static Item limestoneDust;
	public static Item leatherString;
	public static Item flintKnapped;
	//public static Item crucibleLid;
	//public static Item emptyCrucible;
	//public static Item clayFormBook;
	//SPLIT BOARD
	public static Item halfSplitBoard;
	public static Item splitBoard;
	public static Item acaciaSplitBoard;
	public static Item birchSplitBoard;
	public static Item darkSplitBoard;
	public static Item jungleSplitBoard;
	public static Item oakSplitBoard;
	public static Item spruceSplitBoard;
	public static Item itemSmallBarrelLid;

//-----------------------FILTERS-----------------------//	
	public static Item coarseFilter;
	public static Item mediumFilter;
	public static Item fineFilter;
	public static Item charcoalFilter;
	public static Item woodPulp;
	
//-----------------------LEATHER STUFF-----------------------//	
	public static Item rawCuredLeather;
	public static Item soakedLeather;
	public static Item slackedLeather;
	public static Item scuddedLeather;
	public static Item tannedLeather;
	public static Item finishedLeather;
	public static Item cutLeather;
	
//-----------------------BUCKETS-----------------------//	
	public static Item filteredBucket;
	public static Item tanninBucket;
	public static Item slackBucket;
	
//-----------------------WEAPONS AND SHIELDS-----------------------//	
	public static Item heavyMace;
	public static Item longSword;
	public static Item woodenShield;
	public static Item ironShield;
	public static Item battleAxe;
	public static Item gladius;
	
//-----------------------BOWS AND ARROWS-----------------------//	
	//public static Item testLongbow0;
	//public static Item testLongbow1;
	//public static Item testLongbow10;
	public static Item longbow;
	public static Item itemModelArrow;
	public static Item itemIronTippedModelArrow;
	
	//-----------------------CRAFTING TOOLS-----------------------//
	public static Item leatherShears;
	public static Item flintSaw;
	public static Item ironSaw;
	public static Item forgeHammer;
	public static Item inlayHammer;
	public static Item fireBow;
	public static Item workBlade;
	
	//-----------------------FINISHED TOOL COMBOS-----------------------///
	public static Item customIronPick;
	public static Item customIronPick1;
	public static Item customIronPick2;
	public static Item customIronPick3;
	public static Item customIronPick4;
	public static Item customIronPickCase0;
	public static Item customHandleIronPickCase0;
	public static Item customIronPickCase1;
	public static Item customIronPickCase2;
	public static Item customIronPickCase3;
	public static Item customIronPickCase4;
	public static Item customIronPickCase5;
	public static Item customIronPickCase6;
	public static Item customIronPickCase7;
	public static Item customIronPickCase8;
	public static Item customIronPickCase9;
	public static Item customIronPickCase10;
	public static Item customIronPickCase11;
	public static Item customIronPickCase12;
	public static Item customIronPickCase13;
	public static Item customIronPickCase14;
	public static Item customIronPickCase15;
	public static Item customIronPickCase16;
	public static Item customIronPickCase17;
	public static Item customIronPickCase18;
	public static Item customIronPickCase19;
	public static Item customIronPickCase20;
	public static Item customIronPickCase21;
	public static Item customIronPickCase22;
	public static Item customIronPickCase23;
	public static Item customIronPickCase24;
	public static Item customIronPickCase25;
	public static Item customIronPickCase26;
	public static Item customIronPickCase27;
	public static Item customIronPickCase28;
	public static Item customIronPickCase29;
	public static Item customIronPickCase30;
	public static Item customIronPickCase31;
	public static Item customIronPickCase32;
	public static Item customIronPickCase33;
	public static Item customIronPickCase34;
	public static Item customIronPickCase35;
	public static Item customIronPickCase36;
	public static Item customIronPickCase37;
	public static Item customIronPickCase38;
	public static Item customIronPickCase39;
	public static Item customIronPickCase40;
	public static Item customIronPickCase41;
	public static Item customIronPickCase42;
	public static Item customIronPickCase43;
	public static Item customIronPickCase44;
	public static Item customIronPickCase45;
	public static Item customIronPickCase46;
	public static Item customIronPickCase47;
	public static Item customIronPickCase48;
	public static Item customIronPickCase49;
	public static Item customIronPickCase50;
	public static Item customIronPickCase51;
	public static Item customIronPickCase52;
	
	
	public static Item customStrongIronPick;
	public static Item customWeakIronPick;
	public static Item customHandleIronPick;
	public static Item customHandleStrongIronPick;
	
	public static Item customIronShovel0;
	public static Item customIronShovel1;
	public static Item customIronShovel2;
	public static Item customIronShovel3;
	public static Item customIronShovelCase0;
	public static Item customIronShovelCase00;
	public static Item customIronShovelCase1;
	public static Item customIronShovelCase2;
	public static Item customIronShovelCase3;
	public static Item customIronShovelCase4;
	public static Item customIronShovelCase5;
	public static Item customIronShovelCase6;
	public static Item customIronShovelCase7;
	public static Item customIronShovelCase8;
	public static Item customIronShovelCase9;
	public static Item customIronShovelCase10;
	public static Item customIronShovelCase11;
	public static Item customIronShovelCase12;
	public static Item customIronShovelCase13;
	public static Item customIronShovelCase14;
	public static Item customIronShovelCase15;
	public static Item customIronShovelCase16;
	public static Item customIronShovelCase17;
	public static Item customIronShovelCase18;
	public static Item customIronShovelCase19;
	public static Item customIronShovelCase20;
	public static Item customIronShovelCase21;
	public static Item customIronShovelCase22;
	public static Item customIronShovelCase23;
	public static Item customIronShovelCase24;
	public static Item customIronShovelCase25;
	public static Item customIronShovelCase26;
	public static Item customIronShovelCase27;
	public static Item customIronShovelCase28;
	public static Item customIronShovelCase29;
	public static Item customIronShovelCase30;
	public static Item customIronShovelCase31;
	public static Item customIronShovelCase32;
	public static Item customIronShovelCase33;
	public static Item customIronShovelCase34;
	public static Item customIronShovelCase35;
	public static Item customIronShovelCase36;
	public static Item customIronShovelCase37;
	public static Item customIronShovelCase38;
	public static Item customIronShovelCase39;
	public static Item customIronShovelCase40;
	public static Item customIronShovelCase41;
	public static Item customIronShovelCase42;
	public static Item customIronShovelCase43;
	public static Item customIronShovelCase44;
	public static Item customIronShovelCase45;
	public static Item customIronShovelCase46;
	public static Item customIronShovelCase47;
	public static Item customIronShovelCase48;
	public static Item customIronShovelCase49;
	public static Item customIronShovelCase50;
	public static Item customIronShovelCase51;
	public static Item customIronShovelCase52;
	public static Item customIronShovelCase53;
	
	
	
	public static Item customIronShovel;
	public static Item customStrongIronShovel;
	public static Item customWeakIronShovel;
	public static Item customHandleIronShovel;
	public static Item customHandleStrongIronShovel;
	
	public static Item customIronLumberAxe0;
	public static Item customIronLumberAxe1;
	public static Item customIronLumberAxe2;
	public static Item customIronLumberAxe3;
	
	public static Item customIronLumberAxe;
	public static Item customStrongIronLumberAxe;
	public static Item customWeakIronLumberAxe;
	public static Item customHandleIronLumberAxe;
	public static Item customHandleStrongIronLumberAxe;
	
	public static Item customIronHoe;
	
	//-----------------------CLAYFORMS-----------------------///
	public static Item pickaxeClayForm;
	public static Item spadeHeadClayForm;
	public static Item hoeHeadClayForm;
	public static Item axeHeadClayForm;
	public static Item longswordClayForm;
	public static Item shortswordClayForm;
	public static Item daggerClayForm;
	//public static Item halberdClayForm;
	public static Item speartipClayForm;
	public static Item maceheadClayForm;
	public static Item sharptipClayForm;
	public static Item battleaxeClayForm;
	public static Item ringClayForm;
	//public static Item plateClayForm;
	public static Item sawbladeClayForm;
	
	//-----------------------COOKED CLAYFORMS-----------------------//
	public static Item cookedpickaxeClayForm;
	public static Item cookedspadeHeadClayForm;
	public static Item cookedhoeHeadClayForm;
	public static Item cookedaxeHeadClayForm;
	public static Item cookedlongswordClayForm;
	public static Item cookedshortswordClayForm;
	public static Item cookeddaggerClayForm;
	//public static Item cookedhalberdClayForm;
	public static Item cookedspeartipClayForm;
	public static Item cookedmaceheadClayForm;
	public static Item cookedsharptipClayForm;
	public static Item cookedbattleaxeClayForm;
	public static Item cookedringClayForm;
	public static Item cookedplateClayForm;
	public static Item cookedsawbladeClayForm;
	
	//-----------------------TOOLHEADS-----------------------//
	public static Item ironpickaxeHead;
	public static Item ironspadeHead;
	public static Item ironhoeHead;
	public static Item ironaxeHead;
	public static Item ironlongswordBlade;
	public static Item ironshortswordBlade;
	public static Item irondaggerBlade;
	public static Item ironHandleForm;
	public static Item ironspearTip;
	public static Item ironsharpTip;
	public static Item ironmaceHead;
	public static Item ironbattleaxeHead;
	public static Item ironsquarePlate;
	public static Item ironsawBlade;
	
	
	//-----------------------IRON FORMS-----------------------//
	public static Item ironPickaxeForm;
	public static Item ironSpadForm;
	public static Item ironHoeForm;
	public static Item ironAxeForm;
	public static Item ironLongswordForm;
	public static Item ironShortSwordForm;
	public static Item ironDaggerForm;
	//public static Item ironHalberdForm;
	public static Item ironSpearTipForm;
	public static Item ironMaceHeadForm;
	public static Item ironBattleAxeForm;
	public static Item ironSharpTipForm;
	public static Item ironSawBladeForm;
	public static Item ironRingForm;
	
	//-----------------------PICK PARTS-----------------------//
	public static Item silkTouchIronHead;
	public static Item unbreakingOneHead;
	public static Item unbreakingTwoHead;
	public static Item efficOneHead;
	public static Item efficTwoHead;
	public static Item fortuneOneHead;
	public static Item fortuneTwoHead;
	public static Item unbreakingOneEfficOneHead;
	public static Item unbreakingOneFortuneOneHead;
	public static Item efficOneFortuneOneHead;
	
	//-----------------------SHOVEL PARTS-----------------------//
	public static Item silkTouchIronSpade;
	public static Item unbreakingOneSpade;
	public static Item unbreakingTwoSpade;
	public static Item efficOneSpade;
	public static Item efficTwoSpade;
	public static Item fortuneOneSpade;
	public static Item fortuneTwoSpade;
	public static Item unbreakingOneEfficOneSpade;
	public static Item unbreakingOneFortuneOneSpade;
	public static Item efficOneFortuneOneSpade;
	
	//-----------------------LUMBERAXE PARTS-----------------------//
	public static Item silkTouchIronLumberAxe;
	public static Item unbreakingOneLumberAxe;
	public static Item unbreakingTwoLumberAxe;
	public static Item efficOneLumberAxe;
	public static Item efficTwoLumberAxe;
	public static Item fortuneOneLumberAxe;
	public static Item fortuneTwoLumberAxe;
	public static Item unbreakingOneEfficOneLumberAxe;
	public static Item unbreakingOneFortuneOneLumberAxe;
	public static Item efficOneFortuneOneLumberAxe;
	
	//-----------------------ROD PARTS-----------------------//
	public static Item fortuneWoodRod;
	public static Item unbreakingWoodRod;
	public static Item fortuneIronRod;
	public static Item efficIronRod;
	
	//-----------------------TEMP CANNON PARTS-----------------------//
	public static Item cannonBreach;
	public static Item cannonBarrel;
	
	//EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability)
	//Max stats a tool / weapon can have
	//public static ToolMaterial TUTORIAL = EnumHelper.addToolMaterial("TUTORIAL", 3, 1000, 15.0F, 4.0F, 30);
	/*Vanilla Tools
    WOOD(0, 59, 2.0F, 0, 15), STONE(1, 131, 4.0F, 1, 5), IRON(2, 250, 6.0F, 2, 14), EMERALD(3, 1561, 8.0F, 3, 10), GOLD(0, 32, 12.0F, 0, 22);*/
	
	public static ToolMaterial longswordmat = EnumHelper.addToolMaterial("LONGSWORD", 1, 350, 2.0F, 2.0F, 0);
	public static ToolMaterial ironspearmat = EnumHelper.addToolMaterial("IRONSPEAR", 1, 350, 2.0F, 2.0F, 0);
	public static ToolMaterial woodenshieldmat = EnumHelper.addToolMaterial("WOODENSHIELD", 0, 65, 2.0F, -3.5F, 0);
	public static ToolMaterial ironshieldmat = EnumHelper.addToolMaterial("IRONSHIELD", 0, 500, 2.0F, -3.5F, 0);
	public static ToolMaterial heavymacemat = EnumHelper.addToolMaterial("HEAVYMACE", 0, 350, 4.0F, -4.0F, 0);
	public static ToolMaterial customIronPickmat = EnumHelper.addToolMaterial("WOODWEAK", 2, 250, 6.0F, 0, 0);
	//public static ToolMaterial customIronPickDiamondTip = EnumHelper.addToolMaterial("DIAMONDTIP", 3, 500, 7.0F, 2, 0);
	public static ToolMaterial customWoodNormal = EnumHelper.addToolMaterial("WOODNORMAL", 2, 350, 6.25F, 0, 0);
	public static ToolMaterial customWoodStrong = EnumHelper.addToolMaterial("WOODSTRONG", 3, 500, 6.75F, 0, 0);
	public static ToolMaterial customWoodWeak = EnumHelper.addToolMaterial("WOODWEAK", 2, 300, 6.0F, 0, 0);
	public static ToolMaterial customIronToolRodStrong = EnumHelper.addToolMaterial("IRONSTRONG", 3, 350, 7.5F, 0, 0);
	public static ToolMaterial customIronToolRodNormal = EnumHelper.addToolMaterial("IRONNORMAL", 2, 300, 7.5F, 0, 0);
	public static ToolMaterial customIronToolRodWeak = EnumHelper.addToolMaterial("IRONWEAK", 2, 250, 7.5F, 0, 0);
 
	public static void init() {

		/*
		tutorialItem = new Item().setUnlocalizedName("tutorialItem").setCreativeTab(CreativeTabs.tabMisc)
				.setTextureName(Main.MODID + ":tutorialItem");
		GameRegistry.registerItem(tutorialItem, "tutorialItem");
		COPY TEMPLATE
		xxx = new Item().setUnlocalizedName("xxx").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "xxx");
		GameRegistry.registerItem(xxx, "xxx");
		
		
		
		//longbow = new Item().setUnlocalizedName("longbow").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":longbow");
		//GameRegistry.registerItem(longbow, "longbow");
		
		//hotIronPlate = new Item().setUnlocalizedName("hotIronPlate").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":hotIronPlate");
		//GameRegistry.registerItem(hotIronPlate, "hotIronPlate");
			
		salt = new Item().setUnlocalizedName("salt").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":salt");
		GameRegistry.registerItem(salt, "salt");
*/
		//acaciaSplitBoard = new Item().setUnlocalizedName("acaciaSplitBoard").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":acaciaSplitBoard");
		//GameRegistry.registerItem(acaciaSplitBoard, "acaciaSplitBoard");
		
		//birchSplitBoard = new Item().setUnlocalizedName("birchSplitBoard").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":birchSplitBoard");
		//GameRegistry.registerItem(birchSplitBoard, "birchSplitBoard");
		
		//darkSplitBoard = new Item().setUnlocalizedName("darkSplitBoard").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":darkSplitBoard");
		//GameRegistry.registerItem(darkSplitBoard, "darkSplitBoard");
		
		//jungleSplitBoard = new Item().setUnlocalizedName("jungleSplitBoard").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":jungleSplitBoard");
		//GameRegistry.registerItem(jungleSplitBoard, "jungleSplitBoard");
		
		//oakSplitBoard = new Item().setUnlocalizedName("oakSplitBoard").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":oakSplitBoard");
		//GameRegistry.registerItem(oakSplitBoard, "oakSplitBoard");
		
		//spruceSplitBoard = new Item().setUnlocalizedName("spruceSplitBoard").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":spruceSplitBoard");
		//GameRegistry.registerItem(spruceSplitBoard, "spruceSplitBoard");

		//itemSmallBarrelLid = new Item().setUnlocalizedName("itemSmallBarrelLid").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":itemSmallBarrelLid");
		//GameRegistry.registerItem(itemSmallBarrelLid, "itemSmallBarrelLid");
		cannonBreach = new Item().setUnlocalizedName("cannonBreach").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":cannonBreach");
		GameRegistry.registerItem(cannonBreach, "cannonBreach");
		
		cannonBarrel = new Item().setUnlocalizedName("cannonBarrel").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":cannonBarrel");
		GameRegistry.registerItem(cannonBarrel, "cannonBarrel");
		
		woodPulp = new Item().setUnlocalizedName("woodPulp").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":woodPulp");
		GameRegistry.registerItem(woodPulp, "woodPulp");
		
		halfSplitBoard = new Item().setUnlocalizedName("halfSplitBoard").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":halfSplitBoard");
		GameRegistry.registerItem(halfSplitBoard, "halfSplitBoard");
		
		splitBoard = new Item().setUnlocalizedName("splitBoard").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":splitBoard");
		GameRegistry.registerItem(splitBoard, "splitBoard");
		
		finishedLeather = new Item().setUnlocalizedName("finishedLeather").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":finishedLeather");
		GameRegistry.registerItem(finishedLeather, "finishedLeather");
		
		cutLeather = new Item().setUnlocalizedName("cutLeather").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":cutLeather");
		GameRegistry.registerItem(cutLeather, "cutLeather");
		
		tannedLeather = new Item().setUnlocalizedName("tannedLeather").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":tannedLeather");
		GameRegistry.registerItem(tannedLeather, "tannedLeather");
		
		scuddedLeather = new Item().setUnlocalizedName("scuddedLeather").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":scuddedLeather");
		GameRegistry.registerItem(scuddedLeather, "scuddedLeather");
		
		slackedLeather = new Item().setUnlocalizedName("slackedLeather").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":slackedLeather");
		GameRegistry.registerItem(slackedLeather, "slackedLeather");
		
		soakedLeather = new Item().setUnlocalizedName("soakedLeather").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":soakedLeather");
		GameRegistry.registerItem(soakedLeather, "soakedLeather");
		
		//rawCuredLeather = new Item().setUnlocalizedName("rawCuredLeather").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":rawCuredLeather");
		//GameRegistry.registerItem(rawCuredLeather, "rawCuredLeather");
		
		strippedSapling = new Item().setUnlocalizedName("strippedSapling").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":strippedSapling");
		GameRegistry.registerItem(strippedSapling, "strippedSapling");
		
		saplingRing = new Item().setUnlocalizedName("saplingRing").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":saplingRing");
		GameRegistry.registerItem(saplingRing, "saplingRing");

		quartzDust = new Item().setUnlocalizedName("quartzDust").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":quartzDust");
		GameRegistry.registerItem(quartzDust, "quartzDust");
		
		salt = new Item().setUnlocalizedName("salt").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":salt");
		GameRegistry.registerItem(salt, "salt");
		
		limestoneDust = new Item().setUnlocalizedName("limestoneDust").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":limestoneDust");
		GameRegistry.registerItem(limestoneDust, "limestoneDust");
		
		charcoalLeafPellet = new Item().setUnlocalizedName("charcoalLeafPellet").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":charcoalLeafPellet");
		GameRegistry.registerItem(charcoalLeafPellet, "charcoalLeafPellet");
		
		unstrungLongbow = new Item().setUnlocalizedName("unstrungLongbow").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":unstrungLongbow");
		GameRegistry.registerItem(unstrungLongbow, "unstrungLongbow");
		
		leatherString = new Item().setUnlocalizedName("leatherString").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":leatherString");
		GameRegistry.registerItem(leatherString, "leatherString");
		
		//refinedIngot = new Item().setUnlocalizedName("refinedIngot").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":refinedIngot");
		//GameRegistry.registerItem(refinedIngot, "refinedIngot");
		
		//coarseFilter = new Item().setUnlocalizedName("coarseFilter").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":coarseFilter").setMaxStackSize(1).setMaxDamage(300);
		//GameRegistry.registerItem(coarseFilter, "coarseFilter");
		//mediumFilter = new Item().setUnlocalizedName("mediumFilter").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":mediumFilter").setMaxStackSize(1).setMaxDamage(300);
		//GameRegistry.registerItem(mediumFilter, "mediumFilter");
		//fineFilter = new Item().setUnlocalizedName("fineFilter").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":fineFilter").setMaxStackSize(1).setMaxDamage(300);
		//GameRegistry.registerItem(fineFilter, "fineFilter");
		
		leatherStrap = new Item().setUnlocalizedName("leatherStrap").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":leatherStrap");
		GameRegistry.registerItem(leatherStrap, "leatherStrap");
		
		wovenLeather = new Item().setUnlocalizedName("wovenLeather").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":wovenLeather");
		GameRegistry.registerItem(wovenLeather, "wovenLeather");
		
		ironChunk = new Item().setUnlocalizedName("ironChunk").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":ironChunk");
		GameRegistry.registerItem(ironChunk, "ironChunk");
		
		hotironChunk = new Item().setUnlocalizedName("hotironChunk").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":hotironChunk");
		GameRegistry.registerItem(hotironChunk, "hotironChunk");
		
		ironRing = new Item().setUnlocalizedName("ironRing").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":ironRing").setMaxStackSize(16);
		GameRegistry.registerItem(ironRing, "ironRing");
		
		linkedRings = new Item().setUnlocalizedName("linkedRings").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":linkedRings").setMaxStackSize(1);
		GameRegistry.registerItem(linkedRings, "linkedRings");
		
		ironRingMesh = new Item().setUnlocalizedName("ironRingMesh").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":ironRingMesh");
		GameRegistry.registerItem(ironRingMesh, "ironRingMesh");
		
		//hotIronIngot = new Item().setUnlocalizedName("hotIronIngot").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":hotIronIngot");
		//GameRegistry.registerItem(hotIronIngot, "hotIronIngot");
		
		ironweaponHandle = new Item().setUnlocalizedName("ironweaponHandle").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":ironweaponHandle");
		GameRegistry.registerItem(ironweaponHandle, "ironweaponHandle");
		
		woodenPlate = new Item().setUnlocalizedName("woodenPlate").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":woodenPlate");
		GameRegistry.registerItem(woodenPlate, "woodenPlate");
		
		woodentoolHandle = new Item().setUnlocalizedName("woodentoolHandle").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":woodentoolHandle");
		GameRegistry.registerItem(woodentoolHandle, "woodentoolHandle");
		
		flintKnapped = new Item().setUnlocalizedName("flintKnapped").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":flintKnapped");
		GameRegistry.registerItem(flintKnapped, "flintKnapped");
		
		//-----------------------CLAY FORMS-----------------------//
		pickaxeClayForm = new Item().setUnlocalizedName("pickaxeClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "pickaxeClayForm");
		GameRegistry.registerItem(pickaxeClayForm, "pickaxeClayForm");
		
		spadeHeadClayForm = new Item().setUnlocalizedName("spadeHeadClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "spadeHeadClayForm");
		GameRegistry.registerItem(spadeHeadClayForm, "spadeHeadClayForm");
		
		hoeHeadClayForm = new Item().setUnlocalizedName("hoeHeadClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "hoeHeadClayForm");
		GameRegistry.registerItem(hoeHeadClayForm, "hoeHeadClayForm");
		
		axeHeadClayForm = new Item().setUnlocalizedName("axeHeadClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "axeHeadClayForm");
		GameRegistry.registerItem(axeHeadClayForm, "axeHeadClayForm");
		
		longswordClayForm = new Item().setUnlocalizedName("longswordClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "longswordClayForm");
		GameRegistry.registerItem(longswordClayForm, "longswordClayForm");
		
		shortswordClayForm = new Item().setUnlocalizedName("shortswordClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "shortswordClayForm");
		GameRegistry.registerItem(shortswordClayForm, "shortswordClayForm");
		
		daggerClayForm = new Item().setUnlocalizedName("daggerClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "daggerClayForm");
		GameRegistry.registerItem(daggerClayForm, "daggerClayForm");
		
		//halberdClayForm = new Item().setUnlocalizedName("halberdClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "halberdClayForm");
		//GameRegistry.registerItem(halberdClayForm, "halberdClayForm");
		
		speartipClayForm = new Item().setUnlocalizedName("speartipClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "speartipClayForm");
		GameRegistry.registerItem(speartipClayForm, "speartipClayForm");
		
		maceheadClayForm = new Item().setUnlocalizedName("maceheadClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "maceheadClayForm");
		GameRegistry.registerItem(maceheadClayForm, "maceheadClayForm");
		
		sharptipClayForm = new Item().setUnlocalizedName("sharptipClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "sharptipClayForm");
		GameRegistry.registerItem(sharptipClayForm, "sharptipClayForm");
		
		battleaxeClayForm = new Item().setUnlocalizedName("battleaxeClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "battleaxeClayForm");
		GameRegistry.registerItem(battleaxeClayForm, "battleaxeClayForm");
		
		ringClayForm = new Item().setUnlocalizedName("ringClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ringClayForm");
		GameRegistry.registerItem(ringClayForm, "ringClayForm");
		
		//plateClayForm = new Item().setUnlocalizedName("plateClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "plateClayForm");
		//GameRegistry.registerItem(plateClayForm, "plateClayForm");
		
		sawbladeClayForm = new Item().setUnlocalizedName("sawbladeClayForm").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "sawbladeClayForm");
		GameRegistry.registerItem(sawbladeClayForm, "sawbladeClayForm");

		
		
		//-----------------------COOKED CLAY FORMS-----------------------//
		cookedpickaxeClayForm = new CClayPickaxeForm("cookedpickaxeClayForm", cookedpickaxeClayForm);
		cookedspadeHeadClayForm = new CClaySpadeForm("cookedspadeHeadClayForm", cookedspadeHeadClayForm);
		cookedhoeHeadClayForm = new CClayHoeForm("cookedhoeHeadClayForm", cookedhoeHeadClayForm);
		cookedaxeHeadClayForm = new CClayAxeForm("cookedaxeHeadClayForm", cookedaxeHeadClayForm);
		cookedlongswordClayForm = new CClayLongswordForm("cookedlongswordClayForm", cookedlongswordClayForm);
		cookedshortswordClayForm = new CClayShortSwordForm("cookedshortswordClayForm", cookedshortswordClayForm);
		cookeddaggerClayForm = new CClayDaggerForm("cookeddaggerClayForm", cookeddaggerClayForm);
		cookedspeartipClayForm = new CClaySpearTipForm("cookedspeartipClayForm", cookedspeartipClayForm);
		cookedmaceheadClayForm = new CClayMaceHeadForm("cookedmaceheadClayForm", cookedmaceheadClayForm);
		cookedsharptipClayForm = new CClaySharpTipForm("cookedsharptipClayForm", cookedsharptipClayForm);
		cookedbattleaxeClayForm = new CClayBattleAxeForm("cookedbattleaxeClayForm", cookedbattleaxeClayForm);
		cookedringClayForm = new CClayRingForm("cookedringClayForm", cookedringClayForm);
		cookedsawbladeClayForm = new CClaySawBladeForm("cookedsawbladeClayForm", cookedsawbladeClayForm);

		//-----------------------IRON PARTS-----------------------//
		ironpickaxeHead = new Item().setUnlocalizedName("ironpickaxeHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironpickaxeHead").setMaxStackSize(64);
		GameRegistry.registerItem(ironpickaxeHead, "ironpickaxeHead");
		
		ironspadeHead = new Item().setUnlocalizedName("ironspadeHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironspadeHead").setMaxStackSize(64);
		GameRegistry.registerItem(ironspadeHead, "ironspadeHead");
		
		ironhoeHead = new Item().setUnlocalizedName("ironhoeHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironhoeHead").setMaxStackSize(64);
		GameRegistry.registerItem(ironhoeHead, "ironhoeHead");
		
		ironaxeHead = new Item().setUnlocalizedName("ironaxeHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironaxeHead").setMaxStackSize(64);
		GameRegistry.registerItem(ironaxeHead, "ironaxeHead");
		
		ironlongswordBlade = new Item().setUnlocalizedName("ironlongswordBlade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironlongswordBlade").setMaxStackSize(64);
		GameRegistry.registerItem(ironlongswordBlade, "ironlongswordBlade");
		
		ironshortswordBlade = new Item().setUnlocalizedName("ironshortswordBlade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironshortswordBlade").setMaxStackSize(64);
		GameRegistry.registerItem(ironshortswordBlade, "ironshortswordBlade");
		
		irondaggerBlade = new Item().setUnlocalizedName("irondaggerBlade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "irondaggerBlade").setMaxStackSize(64);
		GameRegistry.registerItem(irondaggerBlade, "irondaggerBlade");
		
		//ironhalberdHead = new Item().setUnlocalizedName("ironhalberdHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironhalberdHead");
		//GameRegistry.registerItem(ironhalberdHead, "ironhalberdHead");
		
		ironspearTip = new Item().setUnlocalizedName("ironspearTip").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironspearTip").setMaxStackSize(64);
		GameRegistry.registerItem(ironspearTip, "ironspearTip");
		
		ironsharpTip = new Item().setUnlocalizedName("ironsharpTip").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironsharpTip").setMaxStackSize(64);
		GameRegistry.registerItem(ironsharpTip, "ironsharpTip");
		
		ironmaceHead = new Item().setUnlocalizedName("ironmaceHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironmaceHead").setMaxStackSize(64);
		GameRegistry.registerItem(ironmaceHead, "ironmaceHead");
		
		ironbattleaxeHead = new Item().setUnlocalizedName("ironbattleaxeHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironbattleaxeHead").setMaxStackSize(64);
		GameRegistry.registerItem(ironbattleaxeHead, "ironbattleaxeHead");
		
		ironsquarePlate = new Item().setUnlocalizedName("ironsquarePlate").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironsquarePlate").setMaxStackSize(64);
		GameRegistry.registerItem(ironsquarePlate, "ironsquarePlate");
		
		ironsawBlade = new Item().setUnlocalizedName("ironsawBlade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "ironsawBlade").setMaxStackSize(64);
		GameRegistry.registerItem(ironsawBlade, "ironsawBlade");
		
		//-----------------------TOOL ROD PARTS-----------------------//
		//FORTUNE WOOD ROD
		fortuneWoodRod = new Item().setUnlocalizedName("fortuneWoodRod").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "fortuneWoodRod");
		GameRegistry.registerItem(fortuneWoodRod, "fortuneWoodRod");
		
		//UNBREAKING WOOD ROD
		unbreakingWoodRod = new Item().setUnlocalizedName("unbreakingWoodRod").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingWoodRod");
		GameRegistry.registerItem(unbreakingWoodRod, "unbreakingWoodRod");
		
		//FORTUNE IRON ROD
		fortuneIronRod = new Item().setUnlocalizedName("fortuneIronRod").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "fortuneIronRod");
		GameRegistry.registerItem(fortuneIronRod, "fortuneIronRod");
		
		//EFFIC IRON ROD
		efficIronRod = new Item().setUnlocalizedName("efficIronRod").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "efficIronRod");
		GameRegistry.registerItem(efficIronRod, "efficIronRod");
		
		
		//-----------------------ENCHANTED PICK HEAD PARTS-----------------------//
		
		silkTouchIronHead = new Item().setUnlocalizedName("silkTouchIronHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "silkTouchIronHead").setMaxStackSize(1);
		GameRegistry.registerItem(silkTouchIronHead, "silkTouchIronHead");
		
		unbreakingOneHead = new Item().setUnlocalizedName("unbreakingOneHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingOneHead").setMaxStackSize(1);
		GameRegistry.registerItem(unbreakingOneHead, "unbreakingOneHead");
		
		unbreakingTwoHead = new Item().setUnlocalizedName("unbreakingTwoHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingTwoHead").setMaxStackSize(1);
		GameRegistry.registerItem(unbreakingTwoHead, "unbreakingTwoHead");
		
		efficOneHead = new Item().setUnlocalizedName("efficOneHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "efficOneHead").setMaxStackSize(1);
		GameRegistry.registerItem(efficOneHead, "efficOneHead");
		
		efficTwoHead = new Item().setUnlocalizedName("efficTwoHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "efficTwoHead").setMaxStackSize(1);
		GameRegistry.registerItem(efficTwoHead, "efficTwoHead");
		
		fortuneOneHead = new Item().setUnlocalizedName("fortuneOneHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "fortuneOneHead").setMaxStackSize(1);
		GameRegistry.registerItem(fortuneOneHead, "fortuneOneHead");
		
		fortuneTwoHead = new Item().setUnlocalizedName("fortuneTwoHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "fortuneTwoHead").setMaxStackSize(1);
		GameRegistry.registerItem(fortuneTwoHead, "fortuneTwoHead");
		
		unbreakingOneEfficOneHead = new Item().setUnlocalizedName("unbreakingOneEfficOneHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingOneEfficOneHead").setMaxStackSize(1);
		GameRegistry.registerItem(unbreakingOneEfficOneHead, "unbreakingOneEfficOneHead");
		
		unbreakingOneFortuneOneHead = new Item().setUnlocalizedName("unbreakingOneFortuneOneHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingOneFortuneOneHead").setMaxStackSize(1);
		GameRegistry.registerItem(unbreakingOneFortuneOneHead, "unbreakingOneFortuneOneHead");
		
		efficOneFortuneOneHead = new Item().setUnlocalizedName("efficOneFortuneOneHead").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "efficOneFortuneOneHead").setMaxStackSize(1);
		GameRegistry.registerItem(efficOneFortuneOneHead, "efficOneFortuneOneHead");

		//-----------------------ENCHANTED SPADE PARTS-----------------------//
		
		silkTouchIronSpade = new Item().setUnlocalizedName("silkTouchIronSpade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "silkTouchIronSpade").setMaxStackSize(1);
		GameRegistry.registerItem(silkTouchIronSpade, "silkTouchIronSpade");
		
		unbreakingOneSpade = new Item().setUnlocalizedName("unbreakingOneSpade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingOneSpade").setMaxStackSize(1);
		GameRegistry.registerItem(unbreakingOneSpade, "unbreakingOneSpade");
		
		unbreakingTwoSpade = new Item().setUnlocalizedName("unbreakingTwoSpade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingTwoSpade").setMaxStackSize(1);
		GameRegistry.registerItem(unbreakingTwoSpade, "unbreakingTwoSpade");
		
		efficOneSpade = new Item().setUnlocalizedName("efficOneSpade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "efficOneSpade").setMaxStackSize(1);
		GameRegistry.registerItem(efficOneSpade, "efficOneSpade");
		
		efficTwoSpade = new Item().setUnlocalizedName("efficTwoSpade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "efficTwoSpade").setMaxStackSize(1);
		GameRegistry.registerItem(efficTwoSpade, "efficTwoSpade");
		
		fortuneOneSpade = new Item().setUnlocalizedName("fortuneOneSpade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "fortuneOneSpade").setMaxStackSize(1);
		GameRegistry.registerItem(fortuneOneSpade, "fortuneOneSpade");
		
		fortuneTwoSpade = new Item().setUnlocalizedName("fortuneTwoSpade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "fortuneTwoSpade").setMaxStackSize(1);
		GameRegistry.registerItem(fortuneTwoSpade, "fortuneTwoSpade");
		
		unbreakingOneEfficOneSpade = new Item().setUnlocalizedName("unbreakingOneEfficOneSpade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingOneEfficOneSpade").setMaxStackSize(1);
		GameRegistry.registerItem(unbreakingOneEfficOneSpade, "unbreakingOneEfficOneSpade");
		
		unbreakingOneFortuneOneSpade = new Item().setUnlocalizedName("unbreakingOneFortuneOneSpade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingOneFortuneOneSpade").setMaxStackSize(1);
		GameRegistry.registerItem(unbreakingOneFortuneOneSpade, "unbreakingOneFortuneOneSpade");
		
		efficOneFortuneOneSpade = new Item().setUnlocalizedName("efficOneFortuneOneSpade").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "efficOneFortuneOneSpade").setMaxStackSize(1);
		GameRegistry.registerItem(efficOneFortuneOneSpade, "efficOneFortuneOneSpade");
		
		//-----------------------ENCHANTED LUMBERAXE PARTS-----------------------//
		
		silkTouchIronLumberAxe = new Item().setUnlocalizedName("silkTouchIronLumberAxe").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "silkTouchIronLumberAxe").setMaxStackSize(1);
		GameRegistry.registerItem(silkTouchIronLumberAxe, "silkTouchIronLumberAxe");
		
		unbreakingOneLumberAxe = new Item().setUnlocalizedName("unbreakingOneLumberAxe").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingOneLumberAxe").setMaxStackSize(1);
		GameRegistry.registerItem(unbreakingOneLumberAxe, "unbreakingOneLumberAxe");
		
		unbreakingTwoLumberAxe = new Item().setUnlocalizedName("unbreakingTwoLumberAxe").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingTwoLumberAxe").setMaxStackSize(1);
		GameRegistry.registerItem(unbreakingTwoLumberAxe, "unbreakingTwoLumberAxe");
		
		efficOneLumberAxe = new Item().setUnlocalizedName("efficOneLumberAxe").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "efficOneLumberAxe").setMaxStackSize(1);
		GameRegistry.registerItem(efficOneLumberAxe, "efficOneLumberAxe");
		
		efficTwoLumberAxe = new Item().setUnlocalizedName("efficTwoLumberAxe").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "efficTwoLumberAxe").setMaxStackSize(1);
		GameRegistry.registerItem(efficTwoLumberAxe, "efficTwoLumberAxe");
		
		fortuneOneLumberAxe = new Item().setUnlocalizedName("fortuneOneLumberAxe").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "fortuneOneLumberAxe").setMaxStackSize(1);
		GameRegistry.registerItem(fortuneOneLumberAxe, "fortuneOneLumberAxe");
		
		fortuneTwoLumberAxe = new Item().setUnlocalizedName("fortuneTwoLumberAxe").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "fortuneTwoLumberAxe").setMaxStackSize(1);
		GameRegistry.registerItem(fortuneTwoLumberAxe, "fortuneTwoLumberAxe");
		
		unbreakingOneEfficOneLumberAxe = new Item().setUnlocalizedName("unbreakingOneEfficOneLumberAxe").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingOneEfficOneLumberAxe").setMaxStackSize(1);
		GameRegistry.registerItem(unbreakingOneEfficOneLumberAxe, "unbreakingOneEfficOneLumberAxe");
		
		unbreakingOneFortuneOneLumberAxe = new Item().setUnlocalizedName("unbreakingOneFortuneOneLumberAxe").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "unbreakingOneFortuneOneLumberAxe").setMaxStackSize(1);
		GameRegistry.registerItem(unbreakingOneFortuneOneLumberAxe, "unbreakingOneFortuneOneLumberAxe");
		
		efficOneFortuneOneLumberAxe = new Item().setUnlocalizedName("efficOneFortuneOneLumberAxe").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "efficOneFortuneOneLumberAxe").setMaxStackSize(1);
		GameRegistry.registerItem(efficOneFortuneOneLumberAxe, "efficOneFortuneOneLumberAxe");
		
		//BUCKETS
		filteredBucket = new FluidBucket(ModBlocks.blockFilteredWater);
		filteredBucket.setUnlocalizedName("filteredBucket").setContainerItem(Items.bucket).setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "filteredBucket");
		GameRegistry.registerItem(filteredBucket, "filteredBucket");
		FluidContainerRegistry.registerFluidContainer(ModBlocks.fluidFiltered, new ItemStack(filteredBucket), new ItemStack(Items.bucket));
		
		tanninBucket = new FluidBucket(ModBlocks.blockTannin);
		tanninBucket.setUnlocalizedName("tanninBucket").setContainerItem(Items.bucket).setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "tanninBucket");
		GameRegistry.registerItem(tanninBucket, "tanninBucket");
		FluidContainerRegistry.registerFluidContainer(ModBlocks.fluidTan, new ItemStack(tanninBucket), new ItemStack(Items.bucket));
		
		slackBucket = new FluidBucket(ModBlocks.blockSlackedLime);
		slackBucket.setUnlocalizedName("slackBucket").setContainerItem(Items.bucket).setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":" + "slackBucket");
		GameRegistry.registerItem(slackBucket, "slackBucket");
		FluidContainerRegistry.registerFluidContainer(ModBlocks.fluidSlackedLime, new ItemStack(slackBucket), new ItemStack(Items.bucket));
		
		itemShit = new ItemShit();
		itemTester = new ItemTester();
		
		itemModelArrow = new ItemModelArrow();
		itemIronTippedModelArrow = new ItemIronTippedModelArrow();
		itemITSpear = new ItemITSpear("itemITSpear", ironspearmat);
		
		itemBark= new ItemBark();
		itemSmallBarrelLid = new ItemSmallBarrelLid();
		
		forgeHammer = new ForgeHammer();
		inlayHammer = new InlayHammer();
		workBlade = new WorkBlade();
		
		slottedTongs = new SlottedTongs();
		//testLongbow0 = new ItemTestLongbow0();
		//testLongbow1 = new ItemTestLongbow1();
		//testLongbow10 = new ItemTestLongbow10();
		longbow = new ItemLongbow();
		
		coarseFilter = new CoarseFilter();
		mediumFilter = new MediumFilter();
		fineFilter = new FineFilter();
		charcoalFilter = new Item().setUnlocalizedName("charcoalFilter").setCreativeTab(CustomTab.MedievalCraftTab).setTextureName(Main.MODID + ":charcoalFilter");
		GameRegistry.registerItem(charcoalFilter, "charcoalFilter");
		
		rawCuredLeather = new RawCuredLeather();
		fireBow = new FireBow();
		leatherShears = new LeatherShears();
		ironSaw = new IronSaw();
		flintSaw = new FlintSaw();
		
		ironAxeForm = new IronAxeForm("ironAxeForm", ironAxeForm);
		ironBattleAxeForm = new IronBattleAxeForm("ironBattleAxeForm", ironBattleAxeForm);
		ironDaggerForm = new IronDaggerForm("ironDaggerForm", ironDaggerForm);
		ironHandleForm = new IronHandleForm("ironHandleForm", ironHandleForm);
		ironHoeForm = new IronHoeForm("ironHoeForm", ironHoeForm);
		ironLongswordForm = new IronLongswordForm("ironLongswordForm", ironLongswordForm);
		ironMaceHeadForm = new IronMaceHeadForm("ironMaceHeadForm", ironMaceHeadForm);
		ironPickaxeForm = new IronPickaxeForm("ironPickaxeForm", ironPickaxeForm);
		ironRingForm = new IronRingForm("ironRingForm", ironRingForm);
		ironSawBladeForm = new IronSawBladeForm("ironSawBladeForm", ironSawBladeForm);
		ironSharpTipForm = new IronSharpTipForm("ironSharpTipForm", ironSharpTipForm);
		ironShortSwordForm = new IronShortSwordForm("ironShortSwordForm", ironShortSwordForm);
		ironSpadForm = new IronSpadeForm("ironSpadeForm", ironSpadForm);
		ironSpearTipForm = new IronSpearTipForm("ironSpearTipForm", ironSpearTipForm);
		//clayFormBook = new ItemClayFormBook();
		
		//-----------------------MATERIALS REGISTERY-----------------------//
		
		GameRegistry.registerItem(gladius = new ItemGladius("gladius", longswordmat), "gladius");
		GameRegistry.registerItem(longSword = new ItemLongSword("longSword", longswordmat), "longSword");
		GameRegistry.registerItem(woodenShield = new ItemWoodenShield("woodenShield", woodenshieldmat), "woodenShield");
		GameRegistry.registerItem(ironShield = new ItemIronShield("ironShield", ironshieldmat), "ironShield");
		//GameRegistry.registerItem(ironShield = new ItemIronShield("ironShield", ironshieldmat), "ironShield");
		
		GameRegistry.registerItem(heavyMace = new ItemHeavyMace("heavyMace", heavymacemat), "heavyMace");
		GameRegistry.registerItem(battleAxe = new ItemBattleAxe("battleAxe",  heavymacemat), "battleAxe");
		//PICKAXES
		//Silk Touch
		GameRegistry.registerItem(customIronPick1 = new CustomIronPick("customIronPick1", customWoodWeak), "customIronPick1");
		GameRegistry.registerItem(customIronPick2 = new CustomIronPick("customIronPick2", customWoodNormal), "customIronPick2");
		GameRegistry.registerItem(customIronPick3 = new CustomIronPick("customIronPick3", customIronToolRodWeak), "customIronPick3");
		GameRegistry.registerItem(customIronPick4 = new CustomIronPick("customIronPick4", customIronToolRodWeak), "customIronPick4");
		
		//Pickaxe Casetypes
		GameRegistry.registerItem(customIronPickCase0 = new CustomIronPick("customIronPickCase0", customWoodNormal), "customIronPickCase0");
		GameRegistry.registerItem(customHandleIronPickCase0 = new CustomIronPick("customHandleIronPickCase0", customIronToolRodNormal), "customHandleIronPickCase0");
		GameRegistry.registerItem(customIronPickCase1 = new CustomIronPick("customIronPickCase1", customWoodNormal), "customIronPickCase1");
		GameRegistry.registerItem(customIronPickCase2 = new CustomIronPick("customIronPickCase2", customWoodNormal), "customIronPickCase2");
		GameRegistry.registerItem(customIronPickCase3 = new CustomIronPick("customIronPickCase3", customIronToolRodNormal), "customIronPickCase3");
		GameRegistry.registerItem(customIronPickCase4 = new CustomIronPick("customIronPickCase4", customWoodStrong), "customIronPickCase4");
		GameRegistry.registerItem(customIronPickCase5 = new CustomIronPick("customIronPickCase5", customWoodWeak), "customIronPickCase5");
		GameRegistry.registerItem(customIronPickCase6 = new CustomIronPick("customIronPickCase6", customIronToolRodWeak), "customIronPickCase6");
		GameRegistry.registerItem(customIronPickCase7 = new CustomIronPick("customIronPickCase7", customWoodWeak), "customIronPickCase7");
		GameRegistry.registerItem(customIronPickCase8 = new CustomIronPick("customIronPickCase8", customWoodWeak), "customIronPickCase8");
		GameRegistry.registerItem(customIronPickCase9 = new CustomIronPick("customIronPickCase9", customIronToolRodWeak), "customIronPickCase9");
		GameRegistry.registerItem(customIronPickCase10 = new CustomIronPick("customIronPickCase10", customIronToolRodWeak), "customIronPickCase10");
		GameRegistry.registerItem(customIronPickCase11 = new CustomIronPick("customIronPickCase11", customWoodWeak), "customIronPickCase11");
		GameRegistry.registerItem(customIronPickCase12 = new CustomIronPick("customIronPickCase12", customIronToolRodWeak), "customIronPickCase12");
		GameRegistry.registerItem(customIronPickCase13 = new CustomIronPick("customIronPickCase13", customWoodNormal), "customIronPickCase13");
		GameRegistry.registerItem(customIronPickCase14 = new CustomIronPick("customIronPickCase14", customIronToolRodNormal), "customIronPickCase14");
		GameRegistry.registerItem(customIronPickCase15 = new CustomIronPick("customIronPickCase15", customWoodWeak), "customIronPickCase15");
		GameRegistry.registerItem(customIronPickCase16 = new CustomIronPick("customIronPickCase16", customIronToolRodWeak), "customIronPickCase16");
		GameRegistry.registerItem(customIronPickCase17 = new CustomIronPick("customIronPickCase17", customIronToolRodWeak), "customIronPickCase17");
		GameRegistry.registerItem(customIronPickCase18 = new CustomIronPick("customIronPickCase18", customIronToolRodWeak), "customIronPickCase18");
		GameRegistry.registerItem(customIronPickCase19 = new CustomIronPick("customIronPickCase19", customWoodNormal), "customIronPickCase19");
		GameRegistry.registerItem(customIronPickCase20 = new CustomIronPick("customIronPickCase20", customIronToolRodNormal), "customIronPickCase20");
		GameRegistry.registerItem(customIronPickCase21 = new CustomIronPick("customIronPickCase21", customIronToolRodNormal), "customIronPickCase21");
		GameRegistry.registerItem(customIronPickCase22 = new CustomIronPick("customIronPickCase22", customWoodNormal), "customIronPickCase22");
		GameRegistry.registerItem(customIronPickCase23 = new CustomIronPick("customIronPickCase23", customIronToolRodStrong), "customIronPickCase23");
		GameRegistry.registerItem(customIronPickCase24 = new CustomIronPick("customIronPickCase24", customIronToolRodStrong), "customIronPickCase24");
		GameRegistry.registerItem(customIronPickCase25 = new CustomIronPick("customIronPickCase25", customWoodNormal), "customIronPickCase25");
		GameRegistry.registerItem(customIronPickCase26 = new CustomIronPick("customIronPickCase26", customIronToolRodWeak), "customIronPickCase26");
		GameRegistry.registerItem(customIronPickCase27 = new CustomIronPick("customIronPickCase27", customWoodNormal), "customIronPickCase27");
		GameRegistry.registerItem(customIronPickCase28 = new CustomIronPick("customIronPickCase28", customIronToolRodWeak), "customIronPickCase28");
		GameRegistry.registerItem(customIronPickCase29 = new CustomIronPick("customIronPickCase29", customWoodNormal), "customIronPickCase29");
		GameRegistry.registerItem(customIronPickCase30 = new CustomIronPick("customIronPickCase30", customWoodWeak), "customIronPickCase30");
		GameRegistry.registerItem(customIronPickCase31 = new CustomIronPick("customIronPickCase31", customIronToolRodWeak), "customIronPickCase31");
		GameRegistry.registerItem(customIronPickCase32 = new CustomIronPick("customIronPickCase32", customWoodNormal), "customIronPickCase32");
		GameRegistry.registerItem(customIronPickCase33 = new CustomIronPick("customIronPickCase33", customWoodWeak), "customIronPickCase33");
		GameRegistry.registerItem(customIronPickCase34 = new CustomIronPick("customIronPickCase34", customIronToolRodWeak), "customIronPickCase34");
		GameRegistry.registerItem(customIronPickCase35 = new CustomIronPick("customIronPickCase35", customWoodWeak), "customIronPickCase35");
		GameRegistry.registerItem(customIronPickCase36 = new CustomIronPick("customIronPickCase36", customWoodWeak), "customIronPickCase36");
		GameRegistry.registerItem(customIronPickCase37 = new CustomIronPick("customIronPickCase37", customWoodNormal), "customIronPickCase37");
		GameRegistry.registerItem(customIronPickCase38 = new CustomIronPick("customIronPickCase38", customIronToolRodWeak), "customIronPickCase38");
		GameRegistry.registerItem(customIronPickCase39 = new CustomIronPick("customIronPickCase39", customIronToolRodWeak), "customIronPickCase39");
		GameRegistry.registerItem(customIronPickCase40 = new CustomIronPick("customIronPickCase40", customIronToolRodWeak), "customIronPickCase40");
		GameRegistry.registerItem(customIronPickCase41 = new CustomIronPick("customIronPickCase41", customWoodNormal), "customIronPickCase41");
		GameRegistry.registerItem(customIronPickCase42 = new CustomIronPick("customIronPickCase42", customIronToolRodNormal), "customIronPickCase42");
		GameRegistry.registerItem(customIronPickCase43 = new CustomIronPick("customIronPickCase43", customWoodNormal), "customIronPickCase43");
		GameRegistry.registerItem(customIronPickCase44 = new CustomIronPick("customIronPickCase44", customWoodWeak), "customIronPickCase44");
		GameRegistry.registerItem(customIronPickCase45 = new CustomIronPick("customIronPickCase45", customIronToolRodWeak), "customIronPickCase45");
		GameRegistry.registerItem(customIronPickCase46 = new CustomIronPick("customIronPickCase46", customIronToolRodWeak), "customIronPickCase46");
		GameRegistry.registerItem(customIronPickCase47 = new CustomIronPick("customIronPickCase47", customWoodNormal), "customIronPickCase47");
		GameRegistry.registerItem(customIronPickCase48 = new CustomIronPick("customIronPickCase48", customIronToolRodNormal), "customIronPickCase48");
		GameRegistry.registerItem(customIronPickCase49 = new CustomIronPick("customIronPickCase49", customWoodWeak), "customIronPickCase49");
		GameRegistry.registerItem(customIronPickCase50 = new CustomIronPick("customIronPickCase50", customIronToolRodWeak), "customIronPickCase50");
		GameRegistry.registerItem(customIronPickCase51 = new CustomIronPick("customIronPickCase51", customWoodNormal), "customIronPickCase51");
		GameRegistry.registerItem(customIronPickCase52 = new CustomIronPick("customIronPickCase52", customIronToolRodWeak), "customIronPickCase52");
		
		
		GameRegistry.registerItem(customIronPick = new CustomIronPick("customIronPick", customWoodNormal), "customIronPick");
		GameRegistry.registerItem(customStrongIronPick = new CustomIronPick("customStrongIronPick", customWoodStrong), "customStrongIronPick");
		GameRegistry.registerItem(customWeakIronPick = new CustomIronPick("customWeakIronPick", customWoodWeak), "customWeakIronPick");
		GameRegistry.registerItem(customHandleIronPick = new CustomIronPick("customHandleIronPick", customIronToolRodNormal), "customHandleIronPick");
		GameRegistry.registerItem(customHandleStrongIronPick = new CustomIronPick("customHandleStrongIronPick", customIronToolRodStrong), "customHandleStrongIronPick");
		
		//SHOVELS
		//SilkTouch Numbers
		GameRegistry.registerItem(customIronShovel0 = new CustomIronShovel("customIronShovel0", customWoodWeak), "customIronShovel0");
		GameRegistry.registerItem(customIronShovel1 = new CustomIronShovel("customIronShovel1", customIronToolRodWeak), "customIronShovel1");
		GameRegistry.registerItem(customIronShovel2 = new CustomIronShovel("customIronShovel2", customWoodNormal), "customIronShovel2");
		GameRegistry.registerItem(customIronShovel3 = new CustomIronShovel("customIronShovel3", customIronToolRodWeak), "customIronShovel3");
		
		GameRegistry.registerItem(customIronShovelCase0 = new CustomIronShovel("customIronShovelCase0", customWoodNormal), "customIronShovelCase0");
		GameRegistry.registerItem(customIronShovelCase00 = new CustomIronShovel("customIronShovelCase00", customIronToolRodNormal), "customIronShovelCase00");
		GameRegistry.registerItem(customIronShovelCase1 = new CustomIronShovel("customIronShovelCase1", customWoodNormal), "customIronShovelCase1");
		GameRegistry.registerItem(customIronShovelCase2 = new CustomIronShovel("customIronShovelCase2", customWoodNormal), "customIronShovelCase2");
		GameRegistry.registerItem(customIronShovelCase3 = new CustomIronShovel("customIronShovelCase3", customIronToolRodNormal), "customIronShovelCase3");
		GameRegistry.registerItem(customIronShovelCase4 = new CustomIronShovel("customIronShovelCase4", customWoodStrong), "customIronShovelCase4");
		GameRegistry.registerItem(customIronShovelCase5 = new CustomIronShovel("customIronShovelCase5", customWoodWeak), "customIronShovelCase5");
		GameRegistry.registerItem(customIronShovelCase6 = new CustomIronShovel("customIronShovelCase6", customIronToolRodWeak), "customIronShovelCase6");
		GameRegistry.registerItem(customIronShovelCase7 = new CustomIronShovel("customIronShovelCase7", customWoodWeak), "customIronShovelCase7");
		GameRegistry.registerItem(customIronShovelCase8 = new CustomIronShovel("customIronShovelCase8", customWoodWeak), "customIronShovelCase8");
		GameRegistry.registerItem(customIronShovelCase9 = new CustomIronShovel("customIronShovelCase9", customIronToolRodWeak), "customIronShovelCase9");
		GameRegistry.registerItem(customIronShovelCase10 = new CustomIronShovel("customIronShovelCase10", customIronToolRodWeak), "customIronShovelCase10");
		GameRegistry.registerItem(customIronShovelCase11 = new CustomIronShovel("customIronShovelCase11", customWoodWeak), "customIronShovelCase11");
		GameRegistry.registerItem(customIronShovelCase12 = new CustomIronShovel("customIronShovelCase12", customIronToolRodWeak), "customIronShovelCase12");
		GameRegistry.registerItem(customIronShovelCase13 = new CustomIronShovel("customIronShovelCase13", customWoodNormal), "customIronShovelCase13");
		GameRegistry.registerItem(customIronShovelCase14 = new CustomIronShovel("customIronShovelCase14", customIronToolRodNormal), "customIronShovelCase14");
		GameRegistry.registerItem(customIronShovelCase15 = new CustomIronShovel("customIronShovelCase15", customWoodWeak), "customIronShovelCase15");
		GameRegistry.registerItem(customIronShovelCase16 = new CustomIronShovel("customIronShovelCase16", customIronToolRodWeak), "customIronShovelCase16");
		GameRegistry.registerItem(customIronShovelCase17 = new CustomIronShovel("customIronShovelCase17", customIronToolRodWeak), "customIronShovelCase17");
		GameRegistry.registerItem(customIronShovelCase18 = new CustomIronShovel("customIronShovelCase18", customIronToolRodWeak), "customIronShovelCase18");
		GameRegistry.registerItem(customIronShovelCase19 = new CustomIronShovel("customIronShovelCase19", customWoodNormal), "customIronShovelCase19");
		GameRegistry.registerItem(customIronShovelCase20 = new CustomIronShovel("customIronShovelCase20", customIronToolRodNormal), "customIronShovelCase20");
		GameRegistry.registerItem(customIronShovelCase21 = new CustomIronShovel("customIronShovelCase21", customIronToolRodNormal), "customIronShovelCase21");
		GameRegistry.registerItem(customIronShovelCase22 = new CustomIronShovel("customIronShovelCase22", customWoodNormal), "customIronShovelCase22");
		GameRegistry.registerItem(customIronShovelCase23 = new CustomIronShovel("customIronShovelCase23", customIronToolRodStrong), "customIronShovelCase23");
		GameRegistry.registerItem(customIronShovelCase24 = new CustomIronShovel("customIronShovelCase24", customIronToolRodStrong), "customIronShovelCase24");
		GameRegistry.registerItem(customIronShovelCase25 = new CustomIronShovel("customIronShovelCase25", customWoodNormal), "customIronShovelCase25");
		GameRegistry.registerItem(customIronShovelCase26 = new CustomIronShovel("customIronShovelCase26", customIronToolRodWeak), "customIronShovelCase26");
		GameRegistry.registerItem(customIronShovelCase27 = new CustomIronShovel("customIronShovelCase27", customWoodNormal), "customIronShovelCase27");
		GameRegistry.registerItem(customIronShovelCase28 = new CustomIronShovel("customIronShovelCase28", customIronToolRodWeak), "customIronShovelCase28");
		GameRegistry.registerItem(customIronShovelCase29 = new CustomIronShovel("customIronShovelCase29", customWoodNormal), "customIronShovelCase29");
		GameRegistry.registerItem(customIronShovelCase30 = new CustomIronShovel("customIronShovelCase30", customWoodWeak), "customIronShovelCase30");
		GameRegistry.registerItem(customIronShovelCase31 = new CustomIronShovel("customIronShovelCase31", customIronToolRodWeak), "customIronShovelCase31");
		GameRegistry.registerItem(customIronShovelCase32 = new CustomIronShovel("customIronShovelCase32", customWoodNormal), "customIronShovelCase32");
		GameRegistry.registerItem(customIronShovelCase33 = new CustomIronShovel("customIronShovelCase33", customWoodWeak), "customIronShovelCase33");
		GameRegistry.registerItem(customIronShovelCase34 = new CustomIronShovel("customIronShovelCase34", customIronToolRodWeak), "customIronShovelCase34");
		GameRegistry.registerItem(customIronShovelCase35 = new CustomIronShovel("customIronShovelCase35", customWoodWeak), "customIronShovelCase35");
		GameRegistry.registerItem(customIronShovelCase36 = new CustomIronShovel("customIronShovelCase36", customWoodWeak), "customIronShovelCase36");
		GameRegistry.registerItem(customIronShovelCase37 = new CustomIronShovel("customIronShovelCase37", customWoodNormal), "customIronShovelCase37");
		GameRegistry.registerItem(customIronShovelCase38 = new CustomIronShovel("customIronShovelCase38", customIronToolRodWeak), "customIronShovelCase38");
		GameRegistry.registerItem(customIronShovelCase39 = new CustomIronShovel("customIronShovelCase39", customIronToolRodWeak), "customIronShovelCase39");
		GameRegistry.registerItem(customIronShovelCase40 = new CustomIronShovel("customIronShovelCase40", customIronToolRodWeak), "customIronShovelCase40");
		GameRegistry.registerItem(customIronShovelCase41 = new CustomIronShovel("customIronShovelCase41", customWoodNormal), "customIronShovelCase41");
		GameRegistry.registerItem(customIronShovelCase42 = new CustomIronShovel("customIronShovelCase42", customIronToolRodNormal), "customIronShovelCase42");
		GameRegistry.registerItem(customIronShovelCase43 = new CustomIronShovel("customIronShovelCase43", customWoodNormal), "customIronShovelCase43");
		GameRegistry.registerItem(customIronShovelCase44 = new CustomIronShovel("customIronShovelCase44", customWoodWeak), "customIronShovelCase44");
		GameRegistry.registerItem(customIronShovelCase45 = new CustomIronShovel("customIronShovelCase45", customIronToolRodWeak), "customIronShovelCase45");
		GameRegistry.registerItem(customIronShovelCase46 = new CustomIronShovel("customIronShovelCase46", customIronToolRodWeak), "customIronShovelCase46");
		GameRegistry.registerItem(customIronShovelCase47 = new CustomIronShovel("customIronShovelCase47", customWoodNormal), "customIronShovelCase47");
		GameRegistry.registerItem(customIronShovelCase48 = new CustomIronShovel("customIronShovelCase48", customIronToolRodNormal), "customIronShovelCase48");
		GameRegistry.registerItem(customIronShovelCase49 = new CustomIronShovel("customIronShovelCase49", customWoodWeak), "customIronShovelCase49");
		GameRegistry.registerItem(customIronShovelCase50 = new CustomIronShovel("customIronShovelCase50", customIronToolRodWeak), "customIronShovelCase50");
		GameRegistry.registerItem(customIronShovelCase51 = new CustomIronShovel("customIronShovelCase51", customWoodNormal), "customIronShovelCase51");
		GameRegistry.registerItem(customIronShovelCase52 = new CustomIronShovel("customIronShovelCase52", customIronToolRodWeak), "customIronShovelCase52");
		
		GameRegistry.registerItem(customIronShovel = new CustomIronShovel("customIronShovel", customWoodNormal), "customIronShovel");
		GameRegistry.registerItem(customStrongIronShovel = new CustomIronShovel("customStrongIronShovel", customWoodStrong), "customStrongIronShovel");
		GameRegistry.registerItem(customWeakIronShovel = new CustomIronShovel("customWeakIronShovel", customWoodWeak), "customWeakIronShovel");
		GameRegistry.registerItem(customHandleIronShovel = new CustomIronShovel("customHandleIronShovel", customIronToolRodNormal), "customHandleIronShovel");
		GameRegistry.registerItem(customHandleStrongIronShovel = new CustomIronShovel("customHandleStrongIronShovel", customIronToolRodStrong), "customHandleStrongIronShovel");
		
		//LUMBERAXE
		//Silk Touch
		GameRegistry.registerItem(customIronLumberAxe0 = new CustomIronLumberAxe("customIronLumberAxe0", customWoodWeak), "customIronLumberAxe0");
		GameRegistry.registerItem(customIronLumberAxe1 = new CustomIronLumberAxe("customIronLumberAxe1", customWoodNormal), "customIronLumberAxe1");
		GameRegistry.registerItem(customIronLumberAxe2 = new CustomIronLumberAxe("customIronLumberAxe2", customIronToolRodWeak), "customIronLumberAxe2");
		GameRegistry.registerItem(customIronLumberAxe3 = new CustomIronLumberAxe("customIronLumberAxe3", customIronToolRodWeak), "customIronLumberAxe3");
		
		GameRegistry.registerItem(customIronLumberAxe = new CustomIronLumberAxe("customIronLumberAxe", customWoodNormal), "customIronLumberAxe");
		GameRegistry.registerItem(customStrongIronLumberAxe = new CustomIronLumberAxe("customStrongIronLumberAxe", customWoodStrong), "customStrongIronLumberAxe");
		GameRegistry.registerItem(customWeakIronLumberAxe = new CustomIronLumberAxe("customWeakIronLumberAxe", customWoodWeak), "customWeakIronLumberAxe");
		GameRegistry.registerItem(customHandleIronLumberAxe = new CustomIronLumberAxe("customHandleIronLumberAxe", customIronToolRodNormal), "customHandleIronLumberAxe");
		GameRegistry.registerItem(customHandleStrongIronLumberAxe = new CustomIronLumberAxe("customHandleStrongIronLumberAxe", customIronToolRodStrong), "customHandleStrongIronLumberAxe");
		
		GameRegistry.registerItem(customIronHoe = new CustomIronHoe("customIronHoe", customWoodNormal), "customIronHoe");
		
	}
}
