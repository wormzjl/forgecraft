package com.kitsu.medievalcraft.renderer.itemrenderer.weapons;

import java.util.Vector;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class IRBattleAxe implements IItemRenderer {

	public static final ResourceLocation LONGSWORD = new ResourceLocation("kitsumedievalcraft:models/Battleaxev3.obj");
	public static final ResourceLocation blade = new ResourceLocation("kitsumedievalcraft:models/Battleaxe.png");
	public static final ResourceLocation blade1 = new ResourceLocation("kitsumedievalcraft:models/Battleaxe1.png");
	public Vector testVector;
	
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
			GL11.glScalef(0.25F, 0.25F, 0.25F);
			
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			//GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(45F, 0.0F, 0.0F, 1.0F);
			//GL11.glRotated(90, 1.0, 0.0, 0.0);

			GL11.glTranslatef(2.8F, 0.2F, 0.0F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			//Minecraft.getMinecraft().renderEngine.bindTexture(blade1);
			model.renderAll();

			GL11.glPopMatrix();
		} break;
		
		case EQUIPPED_FIRST_PERSON: {
			
			GL11.glPushMatrix();
			GL11.glScalef(0.3F, 0.4F, 0.3F);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE

			GL11.glRotatef(40F, 0.0F, 0.0F, 1.0F);

			//GL11.glRotated(-85, 1.0, 0.0, 0.0);
			//GL11.glRotated(50, 0.0F, 0.0F, 1.0F);
			//GL11.glRotated(3, 0.0F, 1.0F, 0.0F);

			//GL11.glTranslatef(0.9F, -0.9F, 0.9F);
			GL11.glTranslatef(2.0F, -1.6F, 0.0F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			//Minecraft.getMinecraft().renderEngine.bindTexture(blade1);
			model.renderAll();

			GL11.glPopMatrix();
			
		} break;
		
		case INVENTORY: {
			GL11.glPushMatrix();
			
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glScalef(2.3F, 2.3F, 2.3F);
			GL11.glTranslatef(1.8F, 5.25F, 0.0F);
			GL11.glRotatef(135, 0.0F, 0.0F, -1.0F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			model.renderAll();
		  
			GL11.glPopMatrix();

		} break;
		
		case ENTITY: {
			GL11.glPushMatrix();
			
			GL11.glScalef(0.5F, 0.5F, 0.5F);
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

