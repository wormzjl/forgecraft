package com.kitsu.medievalcraft;

import net.minecraft.world.World;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


public class CommonProxy {
	
    public void registerRenderer() {
    	
    }
    
    public void registerItemRenderers() {
    	
    }
    
    public void registerSounds() {
    
    }
    

    public Object getClient() {
        return null;
    }


    public World getClientWorld() {
        return null;
    }
	
	public void preInit(FMLPreInitializationEvent e) {
		//ModItems.init();
		//ModBlocks.init();
		//ModCrafting.init();
	}
	
	public void init(FMLInitializationEvent e) {

    }

	public void postInit(FMLPostInitializationEvent e) {

	}

}
