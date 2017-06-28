package com.kitsu.medievalcraft.util;

import java.util.Hashtable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;

public interface AnvilUtil {

	static final Hashtable<Item, ItemStack> formsIron = new Hashtable <Item, ItemStack>(){{

		put(ModItems.ironAxeForm, new ItemStack(ModItems.ironaxeHead, 1));
		put(ModItems.ironBattleAxeForm, new ItemStack(ModItems.ironbattleaxeHead, 1));
		put(ModItems.ironDaggerForm, new ItemStack(ModItems.irondaggerBlade, 3));
		put(ModItems.ironHandleForm, new ItemStack(ModItems.ironweaponHandle, 2));
		put(ModItems.ironHoeForm, new ItemStack(ModItems.ironhoeHead, 1));
		put(ModItems.ironLongswordForm, new ItemStack(ModItems.ironlongswordBlade, 1));
		put(ModItems.ironMaceHeadForm, new ItemStack(ModItems.ironmaceHead, 1));
		put(ModItems.ironPickaxeForm, new ItemStack(ModItems.ironpickaxeHead, 1));
		put(ModItems.ironRingForm, new ItemStack(ModItems.ironRing, 9));
		put(ModItems.ironSawBladeForm, new ItemStack(ModItems.ironsawBlade, 1));
		put(ModItems.ironSharpTipForm, new ItemStack(ModItems.ironsharpTip, 9));
		put(ModItems.ironShortSwordForm, new ItemStack(ModItems.ironshortswordBlade, 2));
		put(ModItems.ironSpadForm, new ItemStack(ModItems.ironspadeHead, 1));
		put(ModItems.ironSpearTipForm, new ItemStack(ModItems.ironspearTip, 1));
		
	}};
	
	static final Hashtable<Item, ItemStack> makeForms = new Hashtable <Item, ItemStack>(){{

		put(ModItems.ironaxeHead, new ItemStack(ModItems.ironAxeForm, 1));
		put(ModItems.ironbattleaxeHead, new ItemStack(ModItems.ironBattleAxeForm, 1));
		put(ModItems.irondaggerBlade, new ItemStack(ModItems.ironDaggerForm, 1));
		put(ModItems.woodentoolHandle, new ItemStack(ModItems.ironHandleForm, 1));
		put(ModItems.ironhoeHead, new ItemStack(ModItems.ironHoeForm, 1));
		put(ModItems.ironlongswordBlade, new ItemStack(ModItems.ironLongswordForm, 1));
		put(ModItems.ironmaceHead, new ItemStack(ModItems.ironMaceHeadForm, 1));
		put(ModItems.ironpickaxeHead, new ItemStack(ModItems.ironPickaxeForm, 1));
		put(ModItems.ironRing, new ItemStack(ModItems.ironRingForm, 1));
		put(ModItems.ironsawBlade, new ItemStack(ModItems.ironSawBladeForm, 1));
		put(ModItems.ironsharpTip, new ItemStack(ModItems.ironSharpTipForm, 1));
		put(ModItems.ironshortswordBlade, new ItemStack(ModItems.ironShortSwordForm, 1));
		put(ModItems.ironspadeHead, new ItemStack(ModItems.ironSpadForm, 1));
		put(ModItems.ironspearTip, new ItemStack(ModItems.ironSpearTipForm, 1));
		
	}};
	
	static final Hashtable<Item, ItemStack> formsClay = new Hashtable <Item, ItemStack>(){{

		put(ModItems.cookedaxeHeadClayForm, new ItemStack(ModItems.ironaxeHead, 1));
		put(ModItems.cookedbattleaxeClayForm, new ItemStack(ModItems.ironbattleaxeHead, 1));
		put(ModItems.cookeddaggerClayForm, new ItemStack(ModItems.irondaggerBlade, 3));
		//put(ModItems., new ItemStack(ModItems.ironweaponHandle, 1));
		put(ModItems.cookedhoeHeadClayForm, new ItemStack(ModItems.ironhoeHead, 1));
		put(ModItems.cookedlongswordClayForm, new ItemStack(ModItems.ironlongswordBlade, 1));
		put(ModItems.cookedmaceheadClayForm, new ItemStack(ModItems.ironmaceHead, 1));
		put(ModItems.cookedpickaxeClayForm, new ItemStack(ModItems.ironpickaxeHead, 1));
		put(ModItems.cookedringClayForm, new ItemStack(ModItems.ironRing, 9));
		put(ModItems.cookedsawbladeClayForm, new ItemStack(ModItems.ironsawBlade, 1));
		put(ModItems.cookedsharptipClayForm, new ItemStack(ModItems.ironsharpTip, 9));
		put(ModItems.cookedshortswordClayForm, new ItemStack(ModItems.ironshortswordBlade, 2));
		put(ModItems.cookedspadeHeadClayForm, new ItemStack(ModItems.ironspadeHead, 1));
		put(ModItems.cookedspeartipClayForm, new ItemStack(ModItems.ironspearTip, 1));
		
	}};
	static final Hashtable<Item, Item> makeFormsTest = new Hashtable <Item, Item>(){{

		put(ModItems.ironaxeHead, (ModItems.ironAxeForm));
		put(ModItems.ironbattleaxeHead, (ModItems.ironBattleAxeForm));
		put(ModItems.irondaggerBlade, (ModItems.ironDaggerForm));
		put(ModItems.woodentoolHandle, (ModItems.ironHandleForm));
		put(ModItems.ironhoeHead, (ModItems.ironHoeForm));
		put(ModItems.ironlongswordBlade, (ModItems.ironLongswordForm));
		put(ModItems.ironmaceHead, (ModItems.ironMaceHeadForm));
		put(ModItems.ironpickaxeHead, (ModItems.ironPickaxeForm));
		put(ModItems.ironRing, (ModItems.ironRingForm));
		put(ModItems.ironsawBlade, (ModItems.ironSawBladeForm));
		put(ModItems.ironsharpTip, (ModItems.ironSharpTipForm));
		put(ModItems.ironshortswordBlade, (ModItems.ironShortSwordForm));
		put(ModItems.ironspadeHead, (ModItems.ironSpadForm));
		put(ModItems.ironspearTip, (ModItems.ironSpearTipForm));
		
	}};
	
	
	//==============TESTING========================//
	static final Hashtable<Item, Item> formsIronTest = new Hashtable <Item, Item>(){{

		put(ModItems.ironAxeForm, (ModItems.ironaxeHead));
		put(ModItems.ironBattleAxeForm, (ModItems.ironbattleaxeHead));
		put(ModItems.ironDaggerForm, (ModItems.irondaggerBlade));
		put(ModItems.ironHandleForm, (ModItems.ironweaponHandle));
		put(ModItems.ironHoeForm, (ModItems.ironhoeHead));
		put(ModItems.ironLongswordForm, (ModItems.ironlongswordBlade));
		put(ModItems.ironMaceHeadForm, (ModItems.ironmaceHead));
		put(ModItems.ironPickaxeForm, (ModItems.ironpickaxeHead));
		put(ModItems.ironRingForm, (ModItems.ironRing));
		put(ModItems.ironSawBladeForm, (ModItems.ironsawBlade));
		put(ModItems.ironSharpTipForm, (ModItems.ironsharpTip));
		put(ModItems.ironShortSwordForm, (ModItems.ironshortswordBlade));
		put(ModItems.ironSpadForm, (ModItems.ironspadeHead));
		put(ModItems.ironSpearTipForm, (ModItems.ironspearTip));
		
	}};
	

	
}
