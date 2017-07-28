package com.kitsu.medievalcraft.crafting;

import java.util.Hashtable;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;


public final class ModCrafting {

	public static final Hashtable<Integer, Item> pickheads = new Hashtable <Integer, Item>(){{

		put(0, ModItems.unbreakingOneHead);
		put(1, ModItems.unbreakingTwoHead);
		put(2, ModItems.fortuneOneHead);
		put(3, ModItems.fortuneTwoHead);
		put(4, ModItems.efficOneHead);
		put(5, ModItems.efficTwoHead);
		put(6, ModItems.efficOneFortuneOneHead);
		put(7, ModItems.unbreakingOneEfficOneHead);
		put(8, ModItems.unbreakingOneFortuneOneHead);
	}};

	public static final Hashtable<Integer, Item> rods = new Hashtable <Integer, Item>(){{

		put(0, ModItems.woodentoolHandle);
		put(1, ModItems.unbreakingWoodRod);
		put(2, ModItems.fortuneWoodRod);
		put(3, ModItems.ironweaponHandle);
		put(4, ModItems.efficIronRod);
		put(5, ModItems.fortuneIronRod);
	}};

	public static final Hashtable<Integer, Item> spadeheads = new Hashtable <Integer, Item>(){{

		put(0, ModItems.unbreakingOneSpade);
		put(1, ModItems.unbreakingTwoSpade);
		put(2, ModItems.fortuneOneSpade);
		put(3, ModItems.fortuneTwoSpade);
		put(4, ModItems.efficOneSpade);
		put(5, ModItems.efficTwoSpade);
		put(6, ModItems.efficOneFortuneOneSpade);
		put(7, ModItems.unbreakingOneEfficOneSpade);
		put(8, ModItems.unbreakingOneFortuneOneSpade);

	}};

	public static final Hashtable<Integer, Item> lumberaxeheads = new Hashtable <Integer, Item>(){{

		put(0, ModItems.unbreakingOneLumberAxe);
		put(1, ModItems.unbreakingTwoLumberAxe);
		put(2, ModItems.fortuneOneLumberAxe);
		put(3, ModItems.fortuneTwoLumberAxe);
		put(4, ModItems.efficOneLumberAxe);
		put(5, ModItems.efficTwoLumberAxe);
		put(6, ModItems.efficOneFortuneOneLumberAxe);
		put(7, ModItems.unbreakingOneEfficOneLumberAxe);
		put(8, ModItems.unbreakingOneFortuneOneLumberAxe);

	}};

	public static final void init() {

		GameRegistry.addRecipe(new ItemStack(Items.iron_horse_armor), new Object[] {"jjj", "lll", "www", 'j', Items.iron_ingot, 'l', ModItems.wovenLeather, 'w', Blocks.wool});
		GameRegistry.addRecipe(new ItemStack(Items.golden_horse_armor), new Object[] {"jjj", "lll", "www", 'j', Items.gold_ingot, 'l', ModItems.wovenLeather, 'w', Blocks.wool});
		GameRegistry.addRecipe(new ItemStack(ModItems.wovenLeather), new Object[] {"sss", "sss", "sss", 's', ModItems.leatherStrap});
		GameRegistry.addRecipe(new ItemStack(ModItems.linkedRings), new Object[] {"   ", "   ", "xx ", 'x', ModItems.ironRing});
		GameRegistry.addRecipe(new ItemStack(ModItems.ironRingMesh), new Object[] {"xxx", "xxx", "xxx", 'x', ModItems.linkedRings});
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_helmet), new Object[] {"xxx", "x x", "   ", 'x', ModItems.ironRingMesh});
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_chestplate), new Object[] {"x x", "xxx", "xxx", 'x', ModItems.ironRingMesh});
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_leggings), new Object[] {"xxx", "x x", "x x", 'x', ModItems.ironRingMesh});
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_boots), new Object[] {"   ", "x x", "x x", 'x', ModItems.ironRingMesh});
		//Character.valueOf('x'), new ItemStack(ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE)
		GameRegistry.addRecipe(new ItemStack(Items.saddle), new Object[]{"WWW", "i i", "x x", 'W', ModItems.wovenLeather, 'i', ModItems.leatherStrap, 'x', ModItems.ironRing});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.shitblock), new Object[]{"xxx", "xxx","xxx", 'x', ModItems.itemShit});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.eggWashedWall, 5), new Object[]{"xyx", "yxy","xyx", 'y', Items.egg, 'x', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.eggWashedBrick, 5), new Object[]{"xyx", "yxy","xyx", 'y', Items.egg, 'x', ModBlocks.eggWashedWall});
		GameRegistry.addRecipe(new ItemStack(ModItems.woodenPlate), new Object[]{" x ", "xxx", " x ", 'x', Blocks.wooden_slab});

		//GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.workBlade, true, new Object[]{"x", "y", 'x', ModItems.irondaggerBlade, Character.valueOf('y'), "strapLeather"}));
		GameRegistry.addRecipe(new ItemStack(Blocks.iron_block), new Object[]{"xxx", "xxx","xxx", 'x', ModBlocks.refinedIron});
		GameRegistry.addRecipe(new ItemStack(Items.paper), new Object[]{"xxx", "xxx","xxx", 'x', ModItems.woodPulp});
		GameRegistry.addRecipe(new ItemStack(ModItems.saplingRing), new Object[]{" x ", "x x"," x ", 'x', ModItems.strippedSapling});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.limestoneRaw), new Object[]{"xx", "xx", 'x', ModItems.limestoneDust});
		GameRegistry.addRecipe(new ItemStack(Items.shears), new Object[]{"x x"," y ", 'x', ModItems.irondaggerBlade, 'y', ModItems.ironRing});
		GameRegistry.addRecipe(new ItemStack(Blocks.iron_bars, 18), new Object[]{"xx", "xx", 'x', ModItems.ironweaponHandle});
		
		//-----------------------FILTERS-----------------------//
		GameRegistry.addRecipe(new ItemStack(ModItems.charcoalFilter), new Object[]
				{"xyx", "zzz", "xyx",
			'x', Items.string,
			'y', Items.paper,
			'z', new ItemStack(Items.coal,0,1)});
		GameRegistry.addRecipe(new ItemStack(ModItems.coarseFilter), new Object[]
				{"xyx", " z ", "xyx",
			'x', Items.string,
			'y', Items.paper,
			'z', new ItemStack(ModItems.woodPulp,1,0)});
		GameRegistry.addRecipe(new ItemStack(ModItems.mediumFilter), new Object[]
				{"xyx", "zz ", "xyx",
			'x', Items.string,
			'y', Items.paper,
			'z', new ItemStack(ModItems.woodPulp,2,0)});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.fineFilter), new Object[]
				{"xyx", "zzz", "xyx",
			'x', Items.string,
			'y', Items.paper,
			'z', new ItemStack(ModItems.woodPulp,4,0)});

		//-----------------------TOOLS-----------------------//
		GameRegistry.addRecipe(new ItemStack(ModItems.forgeHammer), new Object[]
				{"bii", " i ", " i ",
			'b', Blocks.iron_block,
			'i', ModBlocks.refinedIron});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.leatherShears), new Object[]
				{" x ", "  x", 'x', ModItems.irondaggerBlade});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.slottedTongs), new Object[]
				{"x x", "aya", "y y",
			'y', Items.stick,
			'x', Blocks.stone,
			'a', Items.string});
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.inlayHammer, true, new Object[]
				{"xxx"," x ", " y ",
				'x', ModBlocks.damascus,
				'y', ModItems.ironweaponHandle}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.fireBow), 
				new Object[]{" x ", "xyx", 'x', Items.stick, Character.valueOf('y'), "cordageStrong"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.workBlade, true, new Object[]
				{"x", "y",
				'x', ModItems.irondaggerBlade,
				'y', Items.stick}));
		
		GameRegistry.addRecipe(new ItemStack(ModItems.ironSaw), new Object []
				{"x", "y",
			'x', Blocks.planks,
			'y', ModItems.ironsawBlade});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.flintSaw), new Object []{" x ", "xyx",'x', Items.stick,'y', Items.flint});

		//-----------------------MACHINES-----------------------//
		GameRegistry.addRecipe(new ItemStack(ModBlocks.forgeAnvil), new Object[]
				{"xyx", " x ","xxx",
			'x',ModBlocks.refinedIron,
			'y', Blocks.iron_block});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.formtable), new Object[]
				{"ccc", "bbb", "bbb",
			'c', Blocks.crafting_table,
			'b', Blocks.brick_block});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.forge), new Object []
				{"xax", "xsx", "xxx",
			'x', Blocks.stonebrick, 'a', Blocks.stone_slab, 's', ModBlocks.firebox});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.forge), new Object []
				{"xax", "xsx", "xxx",
			'x', Blocks.nether_brick, 'a', Blocks.stone_slab, 's', ModBlocks.firebox});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.solidFilter), new Object[]
				{"xyx", "y y", "xyx", 
			'x', ModItems.splitBoard, 
			'y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.waterFilter), new Object[]
				{" i ", "xyx", " i ", 
			'x', ModBlocks.ironPlate, 
			'i', Blocks.iron_bars,
			'y', ModItems.charcoalFilter});
		GameRegistry.addRecipe(new ItemStack(ModItems.itemSmallBarrelLid), new Object[]
				{"ixi", "xxx", "ixi", 
			'x', ModItems.halfSplitBoard, 
			'i', ModItems.strippedSapling});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.shelfFour), new Object[]
				{"ixi", "x x", "ixi", 
			'x', ModItems.halfSplitBoard, 
			'i', ModItems.splitBoard});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.firebox), new Object[]
				{"x x", "x x", "xxx",  
			'x', Items.brick});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.firebox), new Object[]
				{"x x", "x x", "xxx",  
			'x', Items.netherbrick});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.firebox), new Object[]
				{"x x", "x x", "xxx",  
				('x'), "ingotBrickClay"}));

		//-----------------------LEATHER STUFF-----------------------//

		//GameRegistry.addRecipe(new ItemStack(ModItems.rawCuredLeather), new Object[]{"x", "z", 'x', Items.leather, 'z', ModItems.salt});
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.rawCuredLeather), new Object[]{Items.leather, "foodSalt"}));
		GameRegistry.addRecipe(new ItemStack(ModItems.finishedLeather), new Object[]{"x",'x', ModItems.tannedLeather});
		//GameRegistry.addRecipe(new ItemStack(ModItems.rawCuredLeather), new Object[]{"x", "z", 'x', Items.leather, 'z', ModItems.salt});


		//-----------------------ARROWS STUFF-----------------------//

		GameRegistry.addRecipe(new ItemStack(ModItems.itemModelArrow, 4), new Object[]{" x", "zy", 'x', Items.stick, 'y', Items.feather, 'z', ModItems.leatherString});
		GameRegistry.addRecipe(new ItemStack(ModItems.itemModelArrow, 4), new Object[]{" x", "zy", 'x', Items.stick, 'y', Items.feather, 'z', Items.string});
		GameRegistry.addRecipe(new ItemStack(ModItems.itemIronTippedModelArrow), new Object[]{"x", "z", 'z', ModItems.itemModelArrow, 'x', ModItems.ironsharpTip});
		
		//GameRegistry.addRecipe(new ItemStack(ModItems.itemIronTippedModelArrow, 4), new Object[]{" a"," x", "zy", 'x', Items.stick, 'y', Items.feather, 'z', ModItems.leatherString, 'a', ModItems.ironsharpTip});
		//GameRegistry.addRecipe(new ItemStack(ModItems.itemIronTippedModelArrow, 4), new Object[]{" a"," x", "zy", 'x', Items.stick, 'y', Items.feather, 'z', Items.string, 'a', ModItems.ironsharpTip});
		//Temp Recipe
		ItemStack longbow0 = new ItemStack(ModItems.longbow);
		longbow0.stackTagCompound = new NBTTagCompound();
		longbow0.stackTagCompound.setInteger("D", 0);
		GameRegistry.addRecipe(longbow0, new Object[]{"ya", 'y', ModItems.unstrungLongbow, 'a', Items.string});

		//-----------------------CRUCIBLE STUFF-----------------------//
		//GameRegistry.addRecipe(new ItemStack(ModItems.crucibleLid), new Object[]{"x", "y", 'x', Items.clay_ball, 'y', Blocks.stone_slab});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.emptySoftCrucible), new Object[]{"y y", "y y", "yyy", 'y', "clumpClay"}));
		GameRegistry.addRecipe(new ItemStack(ModItems.charcoalLeafPellet), new Object[]{"xxx", "xyx", "xxx", 'x', new ItemStack(Blocks.leaves,0,3), 'y', new ItemStack(Items.coal,0,1)});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.crucibleIronOre), 
				new Object[]{" x ", "abc", " y ",
			'x', Blocks.stone_slab,
			'y', ModBlocks.emptyCookedCrucible, 
			'a', Blocks.sand, 
			'b', Blocks.iron_ore, 
			'c', new ItemStack(Items.coal,0,1)});		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.crucibleIronIngot), 
				new Object[]{" x ", "abc"," y ",
			'x', Blocks.stone_slab,
			'y', ModBlocks.emptyCookedCrucible, 
			'a', Blocks.sand,
			'b', "ingotIron",
			'c', new ItemStack(Items.coal,0,1)}));	
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.crucibleWootz), 
				new Object[]{" x ", "abc", " y ",
			'x', Blocks.stone_slab,
			'y', ModBlocks.emptyCookedCrucible, 
			'a', Blocks.sand,
			'b', ModBlocks.wootzOre,
			'c', ModItems.charcoalLeafPellet});	
		GameRegistry.addRecipe(new ItemStack(ModBlocks.crucibleLapis),
				new Object[]{" x ", "abb", " y ", 
			'x', Blocks.stone_slab, 
			'a', Blocks.sand, 'b', Blocks.lapis_block,
			'y', ModBlocks.emptyCookedCrucible});	
		GameRegistry.addRecipe(new ItemStack(ModBlocks.crucibleRedstone),
				new Object[]{" x ", "abb", " y ", 
			'x', Blocks.stone_slab, 
			'a', Blocks.sand, 'b', Blocks.redstone_block,
			'y', ModBlocks.emptyCookedCrucible});	

		//-----------------------WEAPONS-----------------------//
		GameRegistry.addRecipe(new ShapedOreRecipe((ModItems.longSword), new Object[]{"b", "a", Character.valueOf('a'), "strapLeather", 'b', ModItems.ironlongswordBlade}));
		GameRegistry.addRecipe(new ShapedOreRecipe((ModItems.heavyMace), new Object[]{" a ", "aba", " c ", 'a', ModItems.ironsharpTip, 'b', ModItems.ironmaceHead, 'c', ModItems.ironweaponHandle}));

		ItemStack woodenknockshield = new ItemStack(ModItems.woodenShield);
		woodenknockshield.addEnchantment(Enchantment.knockback, 1);
		GameRegistry.addRecipe(new ShapedOreRecipe(woodenknockshield, new Object[]{"xxx", "sxs", "xxx", Character.valueOf('s'), "strapLeather", 'x', ModItems.woodenPlate}));

		ItemStack ironknockshield = new ItemStack(ModItems.ironShield);
		ironknockshield.addEnchantment(Enchantment.knockback, 2);
		//GameRegistry.addRecipe(new ShapedOreRecipe(ironknockshield, new Object[]{"xxx", "sxs", "xxx", Character.valueOf('s'), "strapLeather", 'x', ModBlocks.ironPlate}));

		ItemStack gladius0 = new ItemStack(ModItems.gladius);
		gladius0.stackTagCompound = new NBTTagCompound();
		gladius0.stackTagCompound.setInteger("GLADIUSTEXTURE", 0);
		GameRegistry.addRecipe(new ShapedOreRecipe(gladius0, new Object[]{"x", "y", Character.valueOf('y'), "strapLeather", 'x', ModItems.ironshortswordBlade}));
		GameRegistry.addRecipe(new ShapedOreRecipe((ModItems.itemITSpear), new Object[]{"a", "c", "b", 'a', ModItems.ironspearTip, 'b', ModItems.woodentoolHandle, Character.valueOf('c'), "strapLeather"}));

		//-----------------------CANNONS-----------------------//
		GameRegistry.addRecipe(new ItemStack(ModItems.cannonBarrel),
				new Object[]{" xx", "   ", " xx", 
			'x', ModBlocks.ironPlate});	
		GameRegistry.addRecipe(new ItemStack(ModItems.cannonBreach),
				new Object[]{" x ", "  x", " x ", 
			'x', ModBlocks.ironPlate});	
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cannon_28),
				new Object[]{" x ","cyc", "ccc", 
			'y', ModItems.cannonBreach,
			'c', ModItems.splitBoard,
			'x', ModItems.cannonBarrel});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.cannonBall_28,4),
				new Object[]{" x ", "xyx", " x ", 
			'x', "nuggetIron",
			'y', Blocks.stone}));
		
		//-----------------------PICKAXE COMBOS-----------------------//
		//BASE PICK
		GameRegistry.addRecipe(new ItemStack(Items.iron_pickaxe),      new Object[]{"a", "b", 'a',ModItems.ironpickaxeHead,   'b', ModItems.woodentoolHandle});
		GameRegistry.addRecipe(new ItemStack(Items.iron_pickaxe),      new Object[]{"a", "b", 'a',ModItems.ironpickaxeHead,   'b', ModItems.ironweaponHandle});
		GameRegistry.addRecipe(new ItemStack(Items.iron_shovel),       new Object[]{"a", "b", 'a',ModItems.ironspadeHead,   'b', ModItems.woodentoolHandle});
		GameRegistry.addRecipe(new ItemStack(Items.iron_shovel),       new Object[]{"a", "b", 'a',ModItems.ironspadeHead,   'b', ModItems.ironweaponHandle});
		GameRegistry.addRecipe(new ItemStack(Items.iron_axe),          new Object[]{"a", "b", 'a',ModItems.ironaxeHead,   'b', ModItems.woodentoolHandle});
		GameRegistry.addRecipe(new ItemStack(Items.iron_axe),          new Object[]{"a", "b", 'a',ModItems.ironaxeHead,   'b', ModItems.ironweaponHandle});

		GameRegistry.addRecipe(new ShapedOreRecipe((ModItems.customIronPick),      new Object[]{"a", "c", "b", Character.valueOf('c'), "strapLeather", 'a',ModItems.ironpickaxeHead,   'b', ModItems.woodentoolHandle}));
		GameRegistry.addRecipe(new ShapedOreRecipe((ModItems.customHandleIronPick),      new Object[]{"a", "c", "b", Character.valueOf('c'), "strapLeather", 'a',ModItems.ironpickaxeHead,   'b', ModItems.ironweaponHandle}));
		GameRegistry.addRecipe(new ShapedOreRecipe((ModItems.customIronShovel),    new Object[]{"a", "c", "b", Character.valueOf('c'), "strapLeather", 'a',ModItems.ironspadeHead,   'b', ModItems.woodentoolHandle}));
		GameRegistry.addRecipe(new ShapedOreRecipe((ModItems.customHandleIronShovel),    new Object[]{"a", "c", "b", Character.valueOf('c'), "strapLeather", 'a',ModItems.ironspadeHead,   'b', ModItems.ironweaponHandle}));
		GameRegistry.addRecipe(new ShapedOreRecipe((ModItems.customIronLumberAxe), new Object[]{"a", "c", "b", Character.valueOf('c'), "strapLeather", 'a', ModItems.ironaxeHead,   'b', ModItems.woodentoolHandle}));
		GameRegistry.addRecipe(new ShapedOreRecipe((ModItems.customHandleIronLumberAxe), new Object[]{"a", "c", "b", Character.valueOf('c'), "strapLeather", 'a', ModItems.ironaxeHead,   'b', ModItems.ironweaponHandle}));

		GameRegistry.addRecipe(new ShapedOreRecipe((ModItems.customIronHoe), new Object[]{"a", "c", "b", Character.valueOf('c'), "strapLeather", 'a', ModItems.ironhoeHead,   'b', ModItems.woodentoolHandle}));
		
		ItemStack sTouchpick = new ItemStack(ModItems.customIronPick1);
		sTouchpick.addEnchantment(Enchantment.silkTouch, 1);

		ItemStack sTouchpick1 = new ItemStack(ModItems.customIronPick2);
		sTouchpick1.addEnchantment(Enchantment.silkTouch, 1);
		sTouchpick1.addEnchantment(Enchantment.unbreaking, 1);
		
		ItemStack sTouchpick3 = new ItemStack(ModItems.customIronPick4);
		sTouchpick3.addEnchantment(Enchantment.silkTouch, 1);

		ItemStack sTouchpick2 = new ItemStack(ModItems.customIronPick3);
		sTouchpick2.addEnchantment(Enchantment.silkTouch, 1);
		sTouchpick2.addEnchantment(Enchantment.efficiency, 1);

		GameRegistry.addRecipe(new ShapedOreRecipe(sTouchpick, new Object[]{"a", "c", "b", 'a', ModItems.silkTouchIronHead, 'b', ModItems.woodentoolHandle, Character.valueOf('c'), "strapLeather"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(sTouchpick1, new Object[]{"a", "c", "b", 'a', ModItems.silkTouchIronHead, 'b', ModItems.unbreakingWoodRod, Character.valueOf('c'), "strapLeather"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(sTouchpick3, new Object[]{"a", "c", "b", 'a', ModItems.silkTouchIronHead, 'b', ModItems.ironweaponHandle, Character.valueOf('c'), "strapLeather"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(sTouchpick2, new Object[]{"a", "c", "b", 'a', ModItems.silkTouchIronHead, 'b', ModItems.efficIronRod, Character.valueOf('c'), "strapLeather"}));

		ItemStack sTouchspade0 = new ItemStack(ModItems.customIronShovel0);
		sTouchspade0.addEnchantment(Enchantment.silkTouch, 1);
		
		ItemStack sTouchspade2 = new ItemStack(ModItems.customIronShovel2);
		sTouchspade2.addEnchantment(Enchantment.silkTouch, 1);

		ItemStack sTouchspade1 = new ItemStack(ModItems.customIronShovel1);
		sTouchspade1.addEnchantment(Enchantment.silkTouch, 1);
		sTouchspade1.addEnchantment(Enchantment.unbreaking, 1);

		ItemStack sTouchspade3 = new ItemStack(ModItems.customIronShovel3);
		sTouchspade3.addEnchantment(Enchantment.silkTouch, 1);
		sTouchspade3.addEnchantment(Enchantment.efficiency, 1);

		GameRegistry.addRecipe(new ShapedOreRecipe(sTouchspade0, new Object[]{"a", "c", "b", 'a', ModItems.silkTouchIronSpade, 'b', ModItems.woodentoolHandle, Character.valueOf('c'), "strapLeather"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(sTouchspade1, new Object[]{"a", "c", "b", 'a', ModItems.silkTouchIronSpade, 'b', ModItems.unbreakingWoodRod, Character.valueOf('c'), "strapLeather"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(sTouchspade2, new Object[]{"a", "c", "b", 'a', ModItems.silkTouchIronSpade, 'b', ModItems.ironweaponHandle, Character.valueOf('c'), "strapLeather"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(sTouchspade3, new Object[]{"a", "c", "b", 'a', ModItems.silkTouchIronSpade, 'b', ModItems.efficIronRod, Character.valueOf('c'), "strapLeather"}));

		ItemStack sTouchaxe = new ItemStack(ModItems.customIronLumberAxe0);
		sTouchaxe.addEnchantment(Enchantment.silkTouch, 1);
		
		ItemStack sTouchaxe3 = new ItemStack(ModItems.customIronLumberAxe3);
		sTouchaxe3.addEnchantment(Enchantment.silkTouch, 1);

		ItemStack sTouchaxe1 = new ItemStack(ModItems.customIronLumberAxe1);
		sTouchaxe1.addEnchantment(Enchantment.silkTouch, 1);
		sTouchaxe1.addEnchantment(Enchantment.unbreaking, 1);

		ItemStack sTouchaxe2 = new ItemStack(ModItems.customIronLumberAxe2);
		sTouchaxe2.addEnchantment(Enchantment.silkTouch, 1);
		sTouchaxe2.addEnchantment(Enchantment.efficiency, 1);

		GameRegistry.addRecipe(new ShapedOreRecipe(sTouchaxe, new Object[]{"a", "c", "b", 'a', ModItems.silkTouchIronLumberAxe, 'b', ModItems.woodentoolHandle, Character.valueOf('c'), "strapLeather"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(sTouchaxe1, new Object[]{"a", "c", "b", 'a', ModItems.silkTouchIronLumberAxe, 'b', ModItems.unbreakingWoodRod, Character.valueOf('c'), "strapLeather"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(sTouchaxe3, new Object[]{"a", "c", "b", 'a', ModItems.silkTouchIronLumberAxe, 'b', ModItems.ironweaponHandle, Character.valueOf('c'), "strapLeather"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(sTouchaxe2, new Object[]{"a", "c", "b", 'a', ModItems.silkTouchIronLumberAxe, 'b', ModItems.efficIronRod, Character.valueOf('c'), "strapLeather"}));

		//REGISTERS ALL POSSIBLE COMBINATIONS OF PICKAXE
		for (int i = 0; i < pickheads.size(); i++) {
			for (int j = 0; j < rods.size(); j++) {
				//UNBREAKING 1
				if ((i == 0 && j == 0)){
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase0);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 0 && j == 3)){
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronPickCase0);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING 2
				((i == 0 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//CUSTOMSTRONGIRONPICK
				((i == 1 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				
				((i == 1 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase3);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 

				//UNBREAKING 3
				((i == 1 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase4);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 3);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE 1
				((i == 2 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase5);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 

				((i == 2 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase6);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE 2
				((i == 3 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase7);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 2 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase8);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				
				((i == 3 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase9);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 2 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase10);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE 3
				((i == 3 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase11);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 3);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE 3
				((i == 3 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase12);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 3);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC 1
				((i == 4 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase13);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 

				((i == 4 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase14);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC 2
				((i == 5 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase15);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 5 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase16);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 4 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase17);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC 3
				((i == 5 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase18);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 3);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING ONE + FORTUNE ONE
				((i == 0 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase19);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 0 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase20);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING ONE + EFFIC ONE
				((i == 0 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase21);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING TWO + FORTUNE ONE
				((i == 1 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase22);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 1 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase23);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING TWO + EFFIC ONE
				((i == 1 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase24);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE ONE + UNBREAKING
				((i == 2 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase25);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE ONE + EFFIC ONE
				((i == 2 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase26);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
		//FORTUNE TWO + UNBREAKING ONE
				((i == 3 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase27);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE TWO + EFFIC ONE
				((i == 3 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase28);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONE + UNBREAKING
				((i == 4 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase29);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONE + FORTUNE
				((i == 4 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase30);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 4 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase31);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC TWO + UNBREAKING
				((i == 5 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase32);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC TWO + FORTUNE
				((i == 5 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase33);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 5 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase34);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONE + FORTUNE
				((i == 6 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase35);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONEFORTUNE + WOOD/IRON
				((i == 6 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase36);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 6 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase37);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 6 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase38);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONEFORTUNE + FORTUNE
				((i == 6 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase39);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONEFORTUNE + EFFIC
				((i == 6 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase40);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEEFFICONE + WOOD/IRON
				((i == 7 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase41);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 7 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase42);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEEFFICONE + unbreaking
				((i == 7 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase43);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEEFFICONE + fortune
				((i == 7 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase44);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 7 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase45);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEEFFICONE + effic
				((i == 7 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase46);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEFORTUNEONE + wood/iron
				((i == 8 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase47);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 8 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase48);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEFORTUNEONE + fortune
				((i == 8 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase49);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 8 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase50);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEFORTUNEONE + unbreaking
				((i == 8 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase51);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEFORTUNEONE + effic
				((i == 8 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronPickCase52);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', pickheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} 
			}
		}

		//REGISTERS ALL POSSIBLE COMBINATIONS OF SHOVEL
		for (int i = 0; i < spadeheads.size(); i++) {
			for (int j = 0; j < rods.size(); j++) {
				//UNBREAKING 1
				if ((i == 0 && j == 0)){
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase0);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 0 && j == 3)){
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase00);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING 2
				((i == 0 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//CUSTOMSTRONGIRONPICK
				((i == 1 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				
				((i == 1 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase3);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 

				//UNBREAKING 3
				((i == 1 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase4);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 3);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE 1
				((i == 2 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase5);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 

				((i == 2 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase6);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE 2
				((i == 3 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase7);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 2 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase8);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				
				((i == 3 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase9);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 2 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase10);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE 3
				((i == 3 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase11);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 3);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE 3
				((i == 3 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase12);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 3);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC 1
				((i == 4 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase13);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 

				((i == 4 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase14);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC 2
				((i == 5 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase15);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 5 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase16);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 4 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase17);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC 3
				((i == 5 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase18);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 3);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING ONE + FORTUNE ONE
				((i == 0 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase19);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 0 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase20);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING ONE + EFFIC ONE
				((i == 0 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase21);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING TWO + FORTUNE ONE
				((i == 1 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase22);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 1 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase23);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING TWO + EFFIC ONE
				((i == 1 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase24);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE ONE + UNBREAKING
				((i == 2 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase25);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE ONE + EFFIC ONE
				((i == 2 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase26);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
		//FORTUNE TWO + UNBREAKING ONE
				((i == 3 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase27);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE TWO + EFFIC ONE
				((i == 3 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase28);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONE + UNBREAKING
				((i == 4 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase29);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONE + FORTUNE
				((i == 4 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase30);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 4 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase31);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC TWO + UNBREAKING
				((i == 5 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase32);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC TWO + FORTUNE
				((i == 5 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase33);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 5 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase34);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONE + FORTUNE
				((i == 6 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase35);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONEFORTUNE + WOOD/IRON
				((i == 6 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase36);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 6 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase37);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 6 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase38);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONEFORTUNE + FORTUNE
				((i == 6 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase39);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONEFORTUNE + EFFIC
				((i == 6 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase40);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEEFFICONE + WOOD/IRON
				((i == 7 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase41);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 7 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase42);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEEFFICONE + unbreaking
				((i == 7 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase43);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEEFFICONE + fortune
				((i == 7 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase44);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 7 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase45);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEEFFICONE + effic
				((i == 7 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase46);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEFORTUNEONE + wood/iron
				((i == 8 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase47);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 8 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase48);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEFORTUNEONE + fortune
				((i == 8 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase49);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 8 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase50);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEFORTUNEONE + unbreaking
				((i == 8 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase51);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEFORTUNEONE + effic
				((i == 8 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronShovelCase52);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', spadeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} 
			}
		}

		//REGISTERS ALL POSSIBLE COMBINATIONS OF LUMBERAXE
		for (int i = 0; i < lumberaxeheads.size(); i++) {
			for (int j = 0; j < rods.size(); j++) {
				//UNBREAKING 1
				if ((i == 0 && j == 0)){
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 

				((i == 0 && j == 3)){
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING 2
				((i == 0 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//CUSTOMSTRONGIronLumberAxe
				((i == 1 && j == 0) || (i == 1 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customStrongIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 

				((i == 1 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleStrongIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING 3
				((i == 1 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customStrongIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 3);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE 1
				((i == 2 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customWeakIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 

				((i == 2 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE 2
				((i == 3 && j == 0) || (i == 2 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customWeakIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 

				((i == 3 && j == 3) || (i == 2 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE 3
				((i == 3 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customWeakIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 3);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 

				((i == 3 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 3);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC 1
				((i == 4 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customWeakIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 

				((i == 4 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC 2
				((i == 5 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customWeakIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 5 && j == 3) || (i == 4 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC 3
				((i == 5 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 3);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING ONE + FORTUNE ONE

				((i == 0 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 0 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING ONE + EFFIC ONE
				((i == 0 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING TWO + FORTUNE ONE
				((i == 1 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customStrongIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 1 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleStrongIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKING TWO + EFFIC ONE
				((i == 1 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleStrongIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE ONE + UNBREAKING
				((i == 2 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE ONE + EFFIC ONE
				((i == 2 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE TWO + UNBREAKING ONE
				((i == 3 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//FORTUNE TWO + EFFIC ONE
				((i == 3 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONE + UNBREAKING
				((i == 4 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONE + FORTUNE
				((i == 4 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customWeakIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 4 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC TWO + UNBREAKING
				((i == 5 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC TWO + FORTUNE
				((i == 5 && j == 2) || (i == 5 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customWeakIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 5 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONE + FORTUNE + UNBREAKING
				((i == 6 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customWeakIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONEFORTUNE + WOOD/IRON
				((i == 6 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 6 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONEFORTUNE + FORTUNE
				((i == 6 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customWeakIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 6 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//EFFIC ONEFORTUNE + EFFIC
				((i == 6 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEEFFICONE + WOOD/IRON
				((i == 7 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 7 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEEFFICONE + unbreaking
				((i == 7 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEEFFICONE + fortune
				((i == 7 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 7 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEEFFICONE + effic
				((i == 7 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEFORTUNEONE + wood/iron
				((i == 8 && j == 0)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 8 && j == 3)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEFORTUNEONE + fortune
				((i == 8 && j == 2)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				((i == 8 && j == 5)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 2);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEFORTUNEONE + unbreaking
				((i == 8 && j == 1)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 2);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} else if 
				//UNBREAKONEFORTUNEONE + effic
				((i == 8 && j == 4)) {
					ItemStack enchantedSwitch = new ItemStack(ModItems.customHandleIronLumberAxe);
					enchantedSwitch.addEnchantment(Enchantment.fortune, 1);
					enchantedSwitch.addEnchantment(Enchantment.unbreaking, 1);
					enchantedSwitch.addEnchantment(Enchantment.efficiency, 1);
					GameRegistry.addRecipe(new ShapedOreRecipe(enchantedSwitch, 
							new Object[]{"a", "c", "b", 'a', lumberaxeheads.get(i), 'b', rods.get(j), Character.valueOf('c'), "strapLeather"}));
				} 
			}
		}

		//ItemStack enchanted = new ItemStack(ModItems.customIronPick);
		//enchanted.addEnchantment(Enchantment.unbreaking, 2);
		//GameRegistry.addRecipe(enchanted, new Object[]{"a","b", 'a', pickheads.get(2), 'b', rods.get(0)});

		//-----------------------TOOL ROD CRAFTING-----------------------//
		GameRegistry.addRecipe(new ItemStack(ModItems.fortuneWoodRod), new Object []{"a", "b", 'a', ModItems.woodentoolHandle, 'b', Blocks.lapis_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingWoodRod), new Object []{"a", "b", 'a', ModItems.woodentoolHandle, 'b', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(ModItems.fortuneIronRod), new Object []{"a", "b", 'a', ModItems.ironweaponHandle, 'b', Blocks.lapis_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficIronRod), new Object[]{"a", "b", 'a', ModItems.ironweaponHandle, 'b', Blocks.redstone_block});

		//-----------------------PICKAXE HEAD CRAFTING-----------------------//
		/*GameRegistry.addRecipe(new ItemStack(ModItems.silkTouchIronHead), new Object []{"aba", 'a', Items.emerald, 'b', ModItems.ironpickaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneHead), new Object []{"ab", 'a', Items.diamond, 'b', ModItems.ironpickaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneHead), new Object []{"ba", 'a', Items.diamond, 'b', ModItems.ironpickaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingTwoHead), new Object []{"aba", 'a', Items.diamond, 'b', ModItems.ironpickaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficOneHead), new Object[]{"ab", 'a', Blocks.redstone_block, 'b', ModItems.ironpickaxeHead});	
		GameRegistry.addRecipe(new ItemStack(ModItems.efficOneHead), new Object[]{"ba", 'a', Blocks.redstone_block, 'b', ModItems.ironpickaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficTwoHead), new Object []{"aba", 'a', Blocks.redstone_block, 'b', ModItems.ironpickaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.fortuneOneHead), new Object[]{"ab", 'a', Blocks.lapis_block, 'b', ModItems.ironpickaxeHead});	
		GameRegistry.addRecipe(new ItemStack(ModItems.fortuneOneHead), new Object[]{"ba", 'a', Blocks.lapis_block, 'b', ModItems.ironpickaxeHead});	
		GameRegistry.addRecipe(new ItemStack(ModItems.fortuneTwoHead), new Object []{"aba", 'a', Blocks.lapis_block, 'b', ModItems.ironpickaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficOneFortuneOneHead), new Object[]{"abc", 'a', Blocks.redstone_block, 'b', ModItems.ironpickaxeHead, 'c', Blocks.lapis_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficOneFortuneOneHead), new Object[]{"cba", 'a', Blocks.redstone_block, 'b', ModItems.ironpickaxeHead, 'c', Blocks.lapis_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneEfficOneHead), new Object[]{"abc", 'a', Items.diamond, 'b', ModItems.ironpickaxeHead, 'c', Blocks.redstone_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneEfficOneHead), new Object[]{"cba", 'a', Items.diamond, 'b', ModItems.ironpickaxeHead, 'c', Blocks.redstone_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneFortuneOneHead), new Object[]{"abc", 'a', Items.diamond, 'b', ModItems.ironpickaxeHead, 'c', Blocks.lapis_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneFortuneOneHead), new Object[]{"cba", 'a', Items.diamond, 'b', ModItems.ironpickaxeHead, 'c', Blocks.lapis_block});

		//-----------------------SPADE CRAFTING-----------------------//
		GameRegistry.addRecipe(new ItemStack(ModItems.silkTouchIronSpade), new Object []{"aba", 'a', Items.emerald, 'b', ModItems.ironspadeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneSpade), new Object []{"ab", 'a', Items.diamond, 'b', ModItems.ironspadeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneSpade), new Object []{"ba", 'a', Items.diamond, 'b', ModItems.ironspadeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingTwoSpade), new Object []{"aba", 'a', Items.diamond, 'b', ModItems.ironspadeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficOneSpade), new Object[]{"ab", 'a', Blocks.redstone_block, 'b', ModItems.ironspadeHead});	
		GameRegistry.addRecipe(new ItemStack(ModItems.efficOneSpade), new Object[]{"ba", 'a', Blocks.redstone_block, 'b', ModItems.ironspadeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficTwoSpade), new Object []{"aba", 'a', Blocks.redstone_block, 'b', ModItems.ironspadeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.fortuneOneSpade), new Object[]{"ab", 'a', Blocks.lapis_block, 'b', ModItems.ironspadeHead});	
		GameRegistry.addRecipe(new ItemStack(ModItems.fortuneOneSpade), new Object[]{"ba", 'a', Blocks.lapis_block, 'b', ModItems.ironspadeHead});	
		GameRegistry.addRecipe(new ItemStack(ModItems.fortuneTwoSpade), new Object []{"aba", 'a', Blocks.lapis_block, 'b', ModItems.ironspadeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficOneFortuneOneSpade), new Object[]{"abc", 'a', Blocks.redstone_block, 'b', ModItems.ironspadeHead, 'c', Blocks.lapis_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficOneFortuneOneSpade), new Object[]{"cba", 'a', Blocks.redstone_block, 'b', ModItems.ironspadeHead, 'c', Blocks.lapis_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneEfficOneSpade), new Object[]{"abc", 'a', Items.diamond, 'b', ModItems.ironspadeHead, 'c', Blocks.redstone_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneEfficOneSpade), new Object[]{"cba", 'a', Items.diamond, 'b', ModItems.ironspadeHead, 'c', Blocks.redstone_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneFortuneOneSpade), new Object[]{"abc", 'a', Items.diamond, 'b', ModItems.ironspadeHead, 'c', Blocks.lapis_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneFortuneOneSpade), new Object[]{"cba", 'a', Items.diamond, 'b', ModItems.ironspadeHead, 'c', Blocks.lapis_block});


		//-----------------------SPADE CRAFTING-----------------------//
		GameRegistry.addRecipe(new ItemStack(ModItems.silkTouchIronLumberAxe), new Object []{"a", "b", "a", 'a', Items.emerald, 'b', ModItems.ironaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneLumberAxe), new Object []{"a", "b", 'a', Items.diamond, 'b', ModItems.ironaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneLumberAxe), new Object []{"b", "a", 'a', Items.diamond, 'b', ModItems.ironaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingTwoLumberAxe), new Object []{"a", "b", "a", 'a', Items.diamond, 'b', ModItems.ironaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficOneLumberAxe), new Object[]{"a", "b", 'a', Blocks.redstone_block, 'b', ModItems.ironaxeHead});	
		GameRegistry.addRecipe(new ItemStack(ModItems.efficOneLumberAxe), new Object[]{"b", "a", 'a', Blocks.redstone_block, 'b', ModItems.ironaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficTwoLumberAxe), new Object []{"a", "b", "a", 'a', Blocks.redstone_block, 'b', ModItems.ironaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.fortuneOneLumberAxe), new Object[]{"a", "b", 'a', Blocks.lapis_block, 'b', ModItems.ironaxeHead});	
		GameRegistry.addRecipe(new ItemStack(ModItems.fortuneOneLumberAxe), new Object[]{"b", "a", 'a', Blocks.lapis_block, 'b', ModItems.ironaxeHead});	
		GameRegistry.addRecipe(new ItemStack(ModItems.fortuneTwoLumberAxe), new Object []{"a", "b", "a", 'a', Blocks.lapis_block, 'b', ModItems.ironaxeHead});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficOneFortuneOneLumberAxe), new Object[]{"a", "b", "c", 'a', Blocks.redstone_block, 'b', ModItems.ironaxeHead, 'c', Blocks.lapis_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.efficOneFortuneOneLumberAxe), new Object[]{"c", "b", "a", 'a', Blocks.redstone_block, 'b', ModItems.ironaxeHead, 'c', Blocks.lapis_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneEfficOneLumberAxe), new Object[]{"a", "b", "c", 'a', Items.diamond, 'b', ModItems.ironaxeHead, 'c', Blocks.redstone_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneEfficOneLumberAxe), new Object[]{"c", "b", "a", 'a', Items.diamond, 'b', ModItems.ironaxeHead, 'c', Blocks.redstone_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneFortuneOneLumberAxe), new Object[]{"a", "b", "c", 'a', Items.diamond, 'b', ModItems.ironaxeHead, 'c', Blocks.lapis_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.unbreakingOneFortuneOneLumberAxe), new Object[]{"c", "b", "a", 'a', Items.diamond, 'b', ModItems.ironaxeHead, 'c', Blocks.lapis_block});
		 */
		//-----------------------SMELTING RECIPES-----------------------//
		//GameRegistry.addSmelting(xxx, new ItemStack(ModItems.yyy), 0.0F);
		GameRegistry.addSmelting(ModItems.pickaxeClayForm, new ItemStack(ModItems.cookedpickaxeClayForm), 0.0F);
		GameRegistry.addSmelting(ModItems.spadeHeadClayForm, new ItemStack(ModItems.cookedspadeHeadClayForm), 0.0F);
		GameRegistry.addSmelting(ModItems.hoeHeadClayForm, new ItemStack(ModItems.cookedhoeHeadClayForm), 0.0F);
		GameRegistry.addSmelting(ModItems.axeHeadClayForm, new ItemStack(ModItems.cookedaxeHeadClayForm), 0.0F);
		GameRegistry.addSmelting(ModItems.longswordClayForm, new ItemStack(ModItems.cookedlongswordClayForm), 0.0F);
		GameRegistry.addSmelting(ModItems.shortswordClayForm, new ItemStack(ModItems.cookedshortswordClayForm), 0.0F);
		GameRegistry.addSmelting(ModItems.daggerClayForm, new ItemStack(ModItems.cookeddaggerClayForm), 0.0F);
		//GameRegistry.addSmelting(ModItems.halberdClayForm, new ItemStack(ModItems.cookedhalberdClayForm), 0.0F);
		GameRegistry.addSmelting(ModItems.speartipClayForm, new ItemStack(ModItems.cookedspeartipClayForm), 0.0F);
		GameRegistry.addSmelting(ModItems.maceheadClayForm, new ItemStack(ModItems.cookedmaceheadClayForm), 0.0F);
		GameRegistry.addSmelting(ModItems.sharptipClayForm, new ItemStack(ModItems.cookedsharptipClayForm), 0.0F);
		GameRegistry.addSmelting(ModItems.battleaxeClayForm, new ItemStack(ModItems.cookedbattleaxeClayForm), 0.0F);
		GameRegistry.addSmelting(ModItems.ringClayForm, new ItemStack(ModItems.cookedringClayForm), 0.0F);
		//GameRegistry.addSmelting(ModItems.plateClayForm, new ItemStack(ModItems.cookedplateClayForm), 0.0F);
		GameRegistry.addSmelting(ModItems.sawbladeClayForm, new ItemStack(ModItems.cookedsawbladeClayForm), 0.0F);
		//GameRegistry.addSmelting(ModItems.ironsquarePlate, new ItemStack(ModBlocks.hotIronPlate), 0.0F);
		GameRegistry.addSmelting(ModItems.ironChunk, new ItemStack(ModItems.hotironChunk), 0.0F);

		//-----------------------FORGE HAMMER CRAFTING-----------------------//
		//IRON CHUNK
		GameRegistry.addRecipe(new ShapedOreRecipe (new ItemStack(ModItems.ironChunk, 9, 0), new Object[]{"x", "y", 
			Character.valueOf('y'), "ingotIron", 
			Character.valueOf('x'), new ItemStack(ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE) }));
		/*
		//IRON PICKAXE HEAD FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironpickaxeHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedpickaxeClayForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON SPADE HEAD FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironspadeHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedspadeHeadClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON HOE HEAD FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironhoeHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedhoeHeadClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON AXE HEAD FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironaxeHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedaxeHeadClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON LONGSWORD FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironlongswordBlade, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE),
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedlongswordClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON SHORT SWORD FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironshortswordBlade, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedshortswordClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON DAGGER FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.irondaggerBlade, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookeddaggerClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON HALBERD FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironhalberdHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedhalberdClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON SPEAR TIP FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironspearTip, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedspeartipClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON SHARP TIP FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironsharpTip, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotironChunk, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedsharptipClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON MACE HEAD FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironmaceHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedmaceheadClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON BATTLE AXE FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironbattleaxeHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedbattleaxeClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON SAW BLADE FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironsawBlade, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedsawbladeClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON SQUARE PLATE FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironsquarePlate, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedplateClayForm, OreDictionary.WILDCARD_VALUE) });

		//IRON RING FROM CLAY FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironRing, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotironChunk, 
			Character.valueOf('z'),	new ItemStack (ModItems.cookedringClayForm, OreDictionary.WILDCARD_VALUE) });
		 */
		//IRON WEAPON HANDLE
		//GameRegistry.addRecipe(new ItemStack(ModItems.ironweaponHandle, 1, 0), new Object []{"ab ", "   ", "   ", 
		//	Character.valueOf('b'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
		//	Character.valueOf('a'), ModItems.hotIronIngot});
		/*
		//IRON PICKAXE HEAD FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironpickaxeHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'), new ItemStack (ModItems.ironPickaxeForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON SPADE HEAD FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironspadeHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),new ItemStack (ModItems.ironSpadForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON HOE HEAD FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironhoeHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.ironHoeForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON AXE HEAD FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironaxeHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.ironAxeForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON LONGSWORD FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironlongswordBlade, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.ironLongswordForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON SHORT SWORD FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironshortswordBlade, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.ironShortSwordForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON DAGGER FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.irondaggerBlade, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.ironDaggerForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON HALBERD FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironhalberdHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'), new ItemStack (ModItems.ironHalberdForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON SPEAR TIP FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironspearTip, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.ironSpearTipForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON SHARP TIP FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironsharpTip, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotironChunk, 
			Character.valueOf('z'),	new ItemStack (ModItems.ironSharpTipForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON MACE HEAD FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironmaceHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.ironMaceHeadForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON BATTLE AXE FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironbattleaxeHead, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'), new ItemStack (ModItems.ironBattleAxeForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON SAW BLADE FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironsawBlade, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotIronIngot, 
			Character.valueOf('z'),	new ItemStack (ModItems.ironSawBladeForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON RING FROM IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironRing, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.hotironChunk, 
			Character.valueOf('z'),	new ItemStack (ModItems.ironRingForm, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON PLATE FORM FROM IRON PLATE
		GameRegistry.addRecipe(new ItemStack(ModItems.ironsquarePlate, 1, 0), new Object []{"x", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('z'), ModItems.hotIronIngot });

		//IRON FORM TEMPLATES
		//IRON PICK FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironPickaxeForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironpickaxeHead, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		//IRON SPADE FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironSpadForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironspadeHead, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		//IRON HOE FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironHoeForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironhoeHead, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		//IRON AXE FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironAxeForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironaxeHead, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		//IRON LONG SWORD FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironLongswordForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironlongswordBlade, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		//IRON SHORT SWORD FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironShortSwordForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironshortswordBlade, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		//IRON DAGGER FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironDaggerForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.irondaggerBlade, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		//IRON HALBERD HEAD FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironHalberdForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironhalberdHead, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		//IRON SPEAR TIP FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironSpearTipForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironspearTip, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		//IRON SHARPTIP FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironSharpTipForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironsharpTip, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		//IRON MACE HEAD FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironMaceHeadForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironmaceHead, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });

		//IRON BATTLEAXE FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironBattleAxeForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironbattleaxeHead, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		//IRON SAW BLADE FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironSawBladeForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironsawBlade, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		//IRON RING IRON FORM
		GameRegistry.addRecipe(new ItemStack(ModItems.ironRingForm, 1, 0), new Object []{"x", "y", "z", 
			Character.valueOf('x'), new ItemStack (ModItems.forgeHammer, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.ironRing, 
			Character.valueOf('z'),	new ItemStack (ModBlocks.hotIronPlate, 1, OreDictionary.WILDCARD_VALUE) });
		 */



		//-----------------------LEATHER SHEARS CRAFTING-----------------------//
		GameRegistry.addRecipe(new ItemStack(ModItems.leatherStrap, 9, 0), new Object[]
				{"x", "y",
			Character.valueOf('x'), new ItemStack(ModItems.leatherShears, 1, OreDictionary.WILDCARD_VALUE),
			Character.valueOf('y'), ModItems.cutLeather});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.leatherString, 9, 0), new Object[]
				{"x", "y",
			Character.valueOf('x'), new ItemStack(ModItems.leatherShears, 1, OreDictionary.WILDCARD_VALUE),
			Character.valueOf('y'), ModItems.leatherStrap});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.cutLeather, 9, 0), new Object[]
				{"x", "y", 
			Character.valueOf('x'), new ItemStack(ModItems.leatherShears, 1, OreDictionary.WILDCARD_VALUE), 
			Character.valueOf('y'), ModItems.finishedLeather});
		
		//-----------------------CRAFTINGBLADE-----------------------//
		GameRegistry.addRecipe(new ItemStack(ModItems.strippedSapling, 1, 0), new Object[]
				{"x", "y",
			Character.valueOf('x'), new ItemStack(ModItems.workBlade, 1, OreDictionary.WILDCARD_VALUE),
			Character.valueOf('y'), Blocks.sapling });
		
		GameRegistry.addRecipe(new ItemStack(ModItems.scuddedLeather, 1, 0), new Object[]
				{"x", "y",
			Character.valueOf('x'), new ItemStack(ModItems.workBlade, 1, OreDictionary.WILDCARD_VALUE),
			Character.valueOf('y'), ModItems.slackedLeather });

		//-----------------------SAW CRAFTING-----------------------//
		//GameRegistry.addRecipe(new ItemStack(Blocks.planks, 4, 0), new Object[]{"x  ", "y  ", "   ", Character.valueOf('x'), new ItemStack(ModItems.ironSaw, 1, OreDictionary.WILDCARD_VALUE), Character.valueOf('y'), Blocks.log });
		//GameRegistry.addRecipe(new ItemStack(Blocks.wooden_slab, 3, 0), new Object[]{"x  ", "y  ", "   ", Character.valueOf('x'), new ItemStack(ModItems.ironSaw, 1, OreDictionary.WILDCARD_VALUE), Character.valueOf('y'), Blocks.planks });
		GameRegistry.addRecipe(new ItemStack(ModItems.woodentoolHandle, 3, 0), new Object[]{"x", "y",
			Character.valueOf('x'), new ItemStack(ModItems.ironSaw, 1, OreDictionary.WILDCARD_VALUE),
			Character.valueOf('y'), Blocks.wooden_slab });
		GameRegistry.addRecipe(new ItemStack(ModItems.woodentoolHandle, 3, 0), new Object[]{"x", "y",
			Character.valueOf('x'), new ItemStack(ModItems.flintSaw, 1, OreDictionary.WILDCARD_VALUE),
			Character.valueOf('y'), Blocks.wooden_slab });
		GameRegistry.addRecipe(new ItemStack(ModItems.slackedLeather, 1, 0), new Object[]{"x", "y",
			Character.valueOf('x'), new ItemStack(ModItems.workBlade, 1, OreDictionary.WILDCARD_VALUE),
			Character.valueOf('y'), ModItems.scuddedLeather });
		GameRegistry.addRecipe(new ItemStack(ModItems.halfSplitBoard, 2, 0), new Object[]{"x", "y", Character.valueOf('x'), new ItemStack(ModItems.flintSaw, 1, OreDictionary.WILDCARD_VALUE), Character.valueOf('y'), ModItems.splitBoard});
		GameRegistry.addRecipe(new ItemStack(ModItems.halfSplitBoard, 2, 0), new Object[]{"x", "y", Character.valueOf('x'), new ItemStack(ModItems.ironSaw, 1, OreDictionary.WILDCARD_VALUE), Character.valueOf('y'), ModItems.splitBoard});

	}

}