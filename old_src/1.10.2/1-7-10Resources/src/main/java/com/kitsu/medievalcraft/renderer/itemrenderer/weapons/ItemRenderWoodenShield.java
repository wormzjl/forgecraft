package com.kitsu.medievalcraft.renderer.itemrenderer.weapons;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

//import com.kitsu.medievalcraft.models.Model;
import com.kitsu.medievalcraft.item.weapon.ItemWoodenShield;

	

public class ItemRenderWoodenShield implements IItemRenderer {

	public static final ResourceLocation WOODEN_SHIELD = new ResourceLocation("kitsumedievalcraft:models/woodenShieldObjectTriangle.obj");
	public static final ResourceLocation woodenshield = new ResourceLocation("kitsumedievalcraft:models/woodenshield.png");
	
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
			GL11.glScalef(0.875F, 0.875F, 0.875F);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(10F, 0.0F, 0.0F, -1.0F);
			GL11.glRotated(90, 1.0, 0.0, 0.0);

			GL11.glTranslatef(-0.35F, -1.5F, -0.55F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(woodenshield);
			model.renderAll();

			GL11.glPopMatrix();
		} break;
		
		case EQUIPPED_FIRST_PERSON: {
			if (ItemWoodenShield.woodenShieldInUse == true) {
			GL11.glPushMatrix();
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE

			GL11.glRotatef(0F, 0.0F, 0.0F, 0.0F);

			GL11.glRotated(-85, 1.0, 0.0, 0.0);
			GL11.glRotated(50, 0.0F, 0.0F, 1.0F);
			GL11.glRotated(3, 0.0F, 1.0F, 0.0F);

			GL11.glTranslatef(0.9F, -0.9F, 0.9F);
			//GL11.glTranslatef(-0.35F, -1.5F, -0.55F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(woodenshield);
			model.renderAll();

			GL11.glPopMatrix();
			}
		} break;
		
		case INVENTORY: {
			GL11.glPushMatrix();
			
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glScalef(9.5F, 9.5F, 9.5F);
			GL11.glTranslatef(0.85F, 0.1F, 0.0F);
			GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(woodenshield);
			model.renderAll();
		  
			GL11.glPopMatrix();
             
		} break;
		
		case ENTITY: {
			GL11.glPushMatrix();
			
			GL11.glScalef(1.25F, 1.25F, 1.25F);
			//GL11.glTranslatef(1.8F, 2.46F, 0.0F);
			GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(woodenshield);
			model.renderAll();
		  
			GL11.glPopMatrix();

             
		} break;
		
		
		default: 
			break;
		}
	}
	

}