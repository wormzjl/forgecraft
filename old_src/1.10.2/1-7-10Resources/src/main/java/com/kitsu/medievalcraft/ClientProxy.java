package com.kitsu.medievalcraft;

import com.kitsu.medievalcraft.entity.EntityCannonBall;
import com.kitsu.medievalcraft.entity.EntityITSpear;
import com.kitsu.medievalcraft.entity.EntityModelArrow;
import com.kitsu.medievalcraft.entity.EntityModelITArrow;
import com.kitsu.medievalcraft.entity.EntityShit;
import com.kitsu.medievalcraft.entity.EntityTester;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.renderer.RendererRegistry;
import com.kitsu.medievalcraft.renderer.blocks.RenderModelArrow;
import com.kitsu.medievalcraft.renderer.blocks.RenderModelITArrow;
import com.kitsu.medievalcraft.renderer.blocks.RenderModelITSpear;
import com.kitsu.medievalcraft.renderer.blocks.cannons.Render_CannonBall_Iron;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderer() { 	
    	RenderingRegistry.registerEntityRenderingHandler(EntityShit.class, new RenderSnowball(ModItems.itemShit));
    	RenderingRegistry.registerEntityRenderingHandler(EntityTester.class, new RenderSnowball(ModItems.itemTester));
    	RenderingRegistry.registerEntityRenderingHandler(EntityModelArrow.class, new RenderModelArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntityModelITArrow.class, new RenderModelITArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntityITSpear.class, new RenderModelITSpear());
    	RenderingRegistry.registerEntityRenderingHandler(EntityCannonBall.class, new Render_CannonBall_Iron());
    	//RenderingRegistry.registerEntityRenderingHandler(ProjectileCannonBall.class, new Render_CannonBall_Projectile());
    }
    
    @Override
    public void registerItemRenderers() {

    	RenderId.init();
    	RendererRegistry.init();
    }
    
    @Override
    public void registerSounds() {
        //MinecraftForge.EVENT_BUS.register(new ModSounds());//register the sound event handling class
    }

    
    @Override
    public Object getClient() {
    	return FMLClientHandler.instance().getClient();
    }

    @Override
    public World getClientWorld() {
    	return FMLClientHandler.instance().getClient().theWorld;
    }
    
}
