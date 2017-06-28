package com.kitsu.medievalcraft.util;

import java.util.Hashtable;

import net.minecraft.util.ResourceLocation;

public class IRTextureModel {

	//public IModelCustom model_arrow = AdvancedModelLoader.loadModel(MODELARROW);

	public static final Hashtable<Integer, ResourceLocation> weaponText = new Hashtable <Integer, ResourceLocation>(){{

		put(0, new ResourceLocation("kitsumedievalcraft:models/Gladius.png"));
		//put(1, ModItems.gladius);
		//put(2, ModItems.heavyMace);
		//put(3, ModItems.battleAxe);

	}};
	
	public static final Hashtable<Integer, ResourceLocation> longbowText = new Hashtable <Integer, ResourceLocation>(){{

		put(0, new ResourceLocation("kitsumedievalcraft:models/NewLongbow1.png"));
		put(1, new ResourceLocation("kitsumedievalcraft:models/NewLongbow2.png"));
		put(2, new ResourceLocation("kitsumedievalcraft:models/NewLongbow3.png"));
		put(3, new ResourceLocation("kitsumedievalcraft:models/NewLongbow4.png"));
		put(4, new ResourceLocation("kitsumedievalcraft:models/NewLongbow5.png"));
		
		//put(1, ModItems.gladius);
		//put(2, ModItems.heavyMace);
		//put(3, ModItems.battleAxe);

	}};

}
