package com.kitsu.medievalcraft.renderer.itemrenderer.machines;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class IRSmallBarrel implements IItemRenderer {
	
	public static final ResourceLocation MODEL = new ResourceLocation("kitsumedievalcraft:models/BarrelFinished.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/BarrelFinished.png");
	
	public IModelCustom model = AdvancedModelLoader.loadModel(MODEL);
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		
		switch(type) {
		case EQUIPPED: {
			return true;
		} 
		case EQUIPPED_FIRST_PERSON: {
			return true;
		} 
		case INVENTORY: {
			return true;
		}
		case ENTITY: {
			return true;
		}
		
		default: return false;
		}
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		
		switch(type) {
		case EQUIPPED: {
			return helper == ItemRendererHelper.BLOCK_3D;
		} 
		case EQUIPPED_FIRST_PERSON: {
			return helper == ItemRendererHelper.EQUIPPED_BLOCK;
		} 
		case INVENTORY: {
			return helper == ItemRendererHelper.INVENTORY_BLOCK;
		}
		case ENTITY: {
	        return (helper == ItemRendererHelper.ENTITY_BOBBING ||
	        		helper == ItemRendererHelper.ENTITY_ROTATION ||
	                helper == ItemRendererHelper.BLOCK_3D);
		}
		
		default: return false;
		}
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		switch(type) {
		
		case EQUIPPED: {
			
			GL11.glPushMatrix();
			float scale = 0.325F;
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(3.2F, -0.75F, -0.2F);
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			GL11.glRotatef(22F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-45F, 0.0F, 1.0F, 0.0F);

			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();

			GL11.glPopMatrix();
		} break;
		
		case EQUIPPED_FIRST_PERSON: {
			float f = 0.5F;
			GL11.glPushMatrix();
			GL11.glScalef(f, f, f);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			//GL11.glRotatef(-135F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-45F, 0.0F, 1.0F, 0.0F);

			GL11.glTranslatef(1.0F, -0.9F, 0.3F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();

			GL11.glPopMatrix();
			
		} break;
		
		case INVENTORY: {
			GL11.glPushMatrix();
			
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			float scale = 0.4F;
			GL11.glScalef(scale, scale, scale);
			
			//GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
			
			GL11.glTranslatef(0.0F, -1.4F, 0.0F);
		
			
			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();
		  
			GL11.glPopMatrix();

		} break;
		
		case ENTITY: {
			GL11.glPushMatrix();
			float scale = 0.5F;
			GL11.glScalef(scale, scale, scale);
			
			GL11.glTranslatef(0.0F, -0.4F, 0.0F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();

			GL11.glPopMatrix();

		} break;

		default: 
			break;
		}
	}

}



