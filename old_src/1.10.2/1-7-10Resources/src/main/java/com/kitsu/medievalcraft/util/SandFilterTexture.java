package com.kitsu.medievalcraft.util;

import java.util.Hashtable;

import net.minecraft.util.ResourceLocation;

public class SandFilterTexture {
	
	public static final Hashtable<Integer, ResourceLocation> filterText = new Hashtable <Integer, ResourceLocation>(){{

		put(0, new ResourceLocation("kitsumedievalcraft:models/SandFilterEmpty.png"));
		put(1, new ResourceLocation("kitsumedievalcraft:models/SandFilter.png"));
		//put(2, ModItems.heavyMace);
		//put(3, ModItems.battleAxe);

	}};

}
