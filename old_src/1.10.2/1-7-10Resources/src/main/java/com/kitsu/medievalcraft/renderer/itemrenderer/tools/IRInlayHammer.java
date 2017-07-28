package com.kitsu.medievalcraft.renderer.itemrenderer.tools;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class IRInlayHammer implements IItemRenderer {

	public static final ResourceLocation LONGSWORD = new ResourceLocation("kitsumedievalcraft:models/InlayHammer.obj");
	public static final ResourceLocation blade = new ResourceLocation("kitsumedievalcraft:models/InlayHammer.png");
	
	public IModelCustom model = AdvancedModelLoader.loadModel(LONGSWORD);
	
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
			return false;
		} 
		case EQUIPPED_FIRST_PERSON: {
			return false;
		} 
		case INVENTORY: {
			return false;
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
			GL11.glRotatef(15F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(10F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(10F, 1.0F, 0.0F, 0.0F);
			//GL11.glRotated(5, 0.0, 1.0, 0.0);
			float scale = 0.2F;
			GL11.glScalef(scale, scale, scale);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			//GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			
			//GL11.glRotated(90, 1.0, 0.0, 0.0);

			GL11.glTranslatef(2.1F, -0.2F, 0.0F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			model.renderAll();

			GL11.glPopMatrix();
		} break;
		
		case EQUIPPED_FIRST_PERSON: {
			
			GL11.glPushMatrix();
			GL11.glRotated(80F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-15F, 1.0F, 0.0F, 0.0F);
			float scale = 0.15F;
			GL11.glScalef(scale, scale, scale);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE

			//GL11.glRotated(180, 0.0, 0.0, 1.0);
			//GL11.glRotated(180, 0.0F, 1.0F, 0.0F);
			//GL11.glRotated(180, 1.0F, 0.0F, 0.0F);

			GL11.glTranslatef(2.0F, -0.3F, 2.0F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			model.renderAll();

			GL11.glPopMatrix();
			
		} break;
		
		case INVENTORY: {
			GL11.glPushMatrix();
			GL11.glRotated(90F, 0.0F, 1.0F, 0.0F);
			GL11.glRotated(135F, 1.0F, 0.0F, 0.0F);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			float scale = 1.5F;
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(0.0F, -3.4F, -7.9F);
			//GL11.glRotatef(135, 0.0F, 0.0F, -1.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			model.renderAll();
		  
			GL11.glPopMatrix();

		} break;
		
		case ENTITY: {
			GL11.glPushMatrix();
			float scale = 0.2F;
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(0.0F, 1.0F, 0.0F);
			//GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			model.renderAll();
		  
			GL11.glPopMatrix();

		} break;

		default: 
			break;
		}
	}


}