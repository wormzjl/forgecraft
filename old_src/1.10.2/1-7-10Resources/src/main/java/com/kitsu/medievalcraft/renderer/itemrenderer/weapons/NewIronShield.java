package com.kitsu.medievalcraft.renderer.itemrenderer.weapons;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.item.weapon.ItemIronShield;

public class NewIronShield implements IItemRenderer {

	public static final ResourceLocation WOODEN_SHIELD = new ResourceLocation("kitsumedievalcraft:models/NewIronShield.obj");
	public static final ResourceLocation woodenshield = new ResourceLocation("kitsumedievalcraft:models/NewIronShield.png");
	
	public IModelCustom model = AdvancedModelLoader.loadModel(WOODEN_SHIELD);
	
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
			GL11.glScalef(0.7F, 0.7F, 1.0F);
			GL11.glTranslatef(0.87F, 0.23F, 0.0F);
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(10F, 0.0F, 0.0F, -1.0F);
			GL11.glRotated(90, 1.0, 0.0, 0.0);

			Minecraft.getMinecraft().renderEngine.bindTexture(woodenshield);
			model.renderAll();

			GL11.glPopMatrix();
		} break;
		
		case EQUIPPED_FIRST_PERSON: {
			if (ItemIronShield.ironShieldInUse == true) {
			GL11.glPushMatrix();
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			GL11.glTranslatef(0.9F, 1.4F, -0.5F);
			GL11.glRotated(-115, 1.0, 0.0, 0.0);
			GL11.glRotated(50, 0.0F, 0.0F, 1.0F);
			
			//GL11.glRotatef(25F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-20F, 0.0F, 1.0F, 0.0F);
			//GL11.glRotated(-10, 0.0, 1.0, 0.0);

			//GL11.glRotated(40, 0.0F, 1.0F, 0.0F);

			
			//GL11.glTranslatef(-0.35F, -1.5F, -0.55F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(woodenshield);
			model.renderAll();

			GL11.glPopMatrix();
			}
		} break;
		
		case INVENTORY: {
			GL11.glPushMatrix();
			
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glScalef(6.0F, 6.0F, 6.0F);
			GL11.glTranslatef(0.9F, 1.1F, -10.0F);
			GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(woodenshield);
			model.renderAll();
		  
			GL11.glPopMatrix();
             
		} break;
		
		case ENTITY: {
			GL11.glPushMatrix();
			
			GL11.glScalef(0.75F, 0.75F, 0.75F);
			//GL11.glTranslatef(1.8F, 2.46F, 0.0F);
			GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.0F, 1.2F, 0.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(woodenshield);
			model.renderAll();
		  
			GL11.glPopMatrix();

             
		} break;
		
		
		default: 
			break;
		}
	}
	

}