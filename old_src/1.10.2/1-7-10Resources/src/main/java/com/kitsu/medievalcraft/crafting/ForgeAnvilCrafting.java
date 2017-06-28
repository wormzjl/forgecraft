package com.kitsu.medievalcraft.crafting;

import java.util.Hashtable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.item.ModItems;

public class ForgeAnvilCrafting {
	
public static final Hashtable<Integer, Item> itemToCheck = new Hashtable <Integer, Item>(){{
		
		put(0, ModItems.ironPickaxeForm);
		put(1, ModItems.ironSpadForm);
		put(2, ModItems.ironHoeForm);
		put(3, ModItems.ironAxeForm);
		put(4, ModItems.ironLongswordForm);
		put(5, ModItems.ironShortSwordForm);
		put(6, ModItems.ironDaggerForm);
		put(7, ModItems.ironSpearTipForm);
		put(8, ModItems.ironMaceHeadForm);
		put(9, ModItems.ironBattleAxeForm);
		put(10, ModItems.ironSawBladeForm);
		put(11, ModItems.ironSharpTipForm);
		put(12, ModItems.ironRingForm);
		put(13, ModItems.ironHandleForm);
		
	}};
	
public static final Hashtable<Integer, Item> itemToCheckClay = new Hashtable <Integer, Item>(){{
		
		put(0, ModItems.cookedpickaxeClayForm);
		put(1, ModItems.cookedspadeHeadClayForm);
		put(2, ModItems.cookedhoeHeadClayForm);
		put(3, ModItems.cookedaxeHeadClayForm);
		put(4, ModItems.cookedlongswordClayForm);
		put(5, ModItems.cookedshortswordClayForm);
		put(6, ModItems.cookeddaggerClayForm);
		put(7, ModItems.cookedspeartipClayForm);
		put(8, ModItems.cookedmaceheadClayForm);
		put(9, ModItems.cookedbattleaxeClayForm);
		put(10, ModItems.cookedsawbladeClayForm);
		put(11, ModItems.cookedsharptipClayForm);
		put(12, ModItems.cookedringClayForm);
		
	}};
	
public static final Hashtable<Integer, ItemStack> itemToGive = new Hashtable <Integer, ItemStack>(){{
		
		put(0,  new ItemStack (ModItems.ironpickaxeHead, 1, 0));
		put(1,  new ItemStack (ModItems.ironspadeHead, 1, 0));
		put(2,  new ItemStack (ModItems.ironhoeHead, 1, 0));
		put(3,  new ItemStack (ModItems.ironaxeHead, 1, 0));
		put(4,  new ItemStack (ModItems.ironlongswordBlade, 1, 0));
		put(5,  new ItemStack (ModItems.ironshortswordBlade,2,0));
		put(6,  new ItemStack (ModItems.irondaggerBlade, 3,0));
		put(7,  new ItemStack (ModItems.ironspearTip, 1, 0));
		put(8,  new ItemStack (ModItems.ironmaceHead, 1, 0));
		
		put(9,  new ItemStack (ModItems.ironbattleaxeHead, 1, 0));
		put(10, new ItemStack (ModItems.ironsawBlade, 1, 0));
		put(11, new ItemStack (ModItems.ironsharpTip,9,0));
		put(12, new ItemStack (ModItems.ironRing,9,0));
		put(13, new ItemStack (ModItems.ironweaponHandle, 2, 0));
		
	}};
	
	public static final Hashtable<Integer, String> toolToRepair = new Hashtable <Integer, String>(){{

		put(0, "Forged Pickaxe");
		put(1, "Forged Shovel");
		put(2, "Forged Lumber Axe");
		put(3, "Leather Shears");
		put(4, "Iron Saw");
		put(5, "Iron Shield");
		put(6, "Heavy Mace");
		put(7, "Longsword");
		put(8, "Forge Hammer");
		put(9, "Crafting Blade");
		put(10, "Gladius");
		
	}};

}
