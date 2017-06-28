package com.kitsu.medievalcraft.util;

import java.util.Hashtable;

import net.minecraft.item.Item;

import com.kitsu.medievalcraft.item.ModItems;

public class ShieldSwitchTable {

	public static final Hashtable<Integer, Item> weapons = new Hashtable <Integer, Item>(){{

		put(0, ModItems.longSword);
		put(1, ModItems.gladius);
		put(2, ModItems.heavyMace);
		put(3, ModItems.battleAxe);

	}};

	public static final Hashtable<Integer, Item> shields = new Hashtable <Integer, Item>(){{

		put(0, ModItems.woodenShield);
		put(1, ModItems.ironShield);

	}};


}
