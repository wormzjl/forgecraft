package com.kitsu.medievalcraft.util;

import java.util.Hashtable;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;

public interface InlayTables {

	public static Hashtable<Integer, Block> upgrade = new Hashtable <Integer, Block>(){{

		put(0, ModBlocks.myDiamond);
		put(1, ModBlocks.myEmerald);
		put(2, ModBlocks.lapisIngot);
		put(3, ModBlocks.redstoneIngot);
		//put(3, ModItems.battleAxe);

	}};

	public static Hashtable<Integer, Item> zeroUpgrade = new Hashtable <Integer, Item>(){{

		put(0,  ModItems.ironpickaxeHead);
		put(1,  ModItems.ironspadeHead);
		//put(2,  ModItems.ironhoeHead);
		put(2,  ModItems.ironaxeHead);
		//put(4,  ModItems.ironlongswordBlade);
		//put(5,  ModItems.ironshortswordBlade);
		//put(6,  ModItems.irondaggerBlade);
		//put(7,  ModItems.ironspearTip);
		//put(8,  ModItems.ironmaceHead);
		//put(9,  ModItems.ironbattleaxeHead);
		//put(10, ModItems.ironsawBlade);
		//put(11, ModItems.ironsharpTip);
		//put(12, ModItems.ironRing);
		//put(13, ModItems.woodentoolHandle);
		//put(14, ModItems.ironweaponHandle);

	}};

	public static Hashtable<Integer, Item> oneUpgrade = new Hashtable <Integer, Item>(){{

		put(0,  ModItems.unbreakingOneHead);
		put(1,  ModItems.unbreakingOneSpade);
		//put(2,  ModItems.unbreakingOneHoe);
		put(2,  ModItems.unbreakingOneLumberAxe);
		
		put(3,  ModItems.efficOneHead);
		put(4,  ModItems.efficOneSpade);
		//put(6,  ModItems.efficOneHoe);
		put(5,  ModItems.efficOneLumberAxe);
		
		put(6,  ModItems.fortuneOneHead);
		put(7,  ModItems.fortuneOneSpade);
		//put(10, ModItems.fortuneOneHoe);
		put(8, ModItems.fortuneOneLumberAxe);

	}};
	
	public static Hashtable<Integer, Item> twoUpgrade = new Hashtable <Integer, Item>(){{

		put(0,  ModItems.unbreakingTwoHead);
		put(1,  ModItems.unbreakingTwoSpade);
		//put(2,  ModItems.unbreakingTwoHoe);
		put(2,  ModItems.unbreakingTwoLumberAxe);
		
		put(3,  ModItems.efficTwoHead);
		put(4,  ModItems.efficTwoSpade);
		//put(6,  ModItems.efficTwoHoe);
		put(5,  ModItems.efficTwoLumberAxe);
		
		put(6,  ModItems.fortuneTwoHead);
		put(7,  ModItems.fortuneTwoSpade);
		//put(10, ModItems.fortuneTwoHoe);
		put(8, ModItems.fortuneTwoLumberAxe);

	}};
	
	public static Hashtable<Integer, Item> multiUpgrade = new Hashtable <Integer, Item>(){{

		put(0,  ModItems.unbreakingOneEfficOneHead);
		put(1,  ModItems.unbreakingOneEfficOneSpade);
		//put(2,  ModItems.unbreakingTwoHoe);
		put(2,  ModItems.unbreakingOneEfficOneLumberAxe);
		
		put(3,  ModItems.efficOneFortuneOneHead);
		put(4,  ModItems.efficOneFortuneOneSpade);
		//put(10, ModItems.fortuneTwoHoe);
		put(5, ModItems.efficOneFortuneOneLumberAxe);
		
		put(6,  ModItems.unbreakingOneFortuneOneHead);
		put(7,  ModItems.unbreakingOneFortuneOneSpade);
		//put(6,  ModItems.efficTwoHoe);
		put(8,  ModItems.unbreakingOneFortuneOneLumberAxe);

	}};
	
	public static Hashtable<Integer, Item> silkTouch = new Hashtable <Integer, Item>(){{

		put(0,  ModItems.silkTouchIronHead);
		put(1,  ModItems.silkTouchIronSpade);
		//put(2,  ModItems.unbreakingTwoHoe);
		put(2,  ModItems.silkTouchIronLumberAxe);

	}};


	public static Hashtable<Integer, String> enchantType = new Hashtable <Integer, String>(){{

		put(0, "unbreaking");
		put(1, "fortune");
		put(2, "effic");
		put(3, "silktouch");

	}};

}
