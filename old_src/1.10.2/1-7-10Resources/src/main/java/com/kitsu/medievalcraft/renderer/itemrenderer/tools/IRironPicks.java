package com.kitsu.medievalcraft.renderer.itemrenderer.tools;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraft.util.IIcon;

public class IRironPicks implements IItemRenderer {

	private static RenderItem renderItem = new RenderItem();
	
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
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) {
        // ====================== Render item texture ======================
       IIcon icon = itemStack.getIconIndex();
       GL11.glTranslatef(0F, 0.5F, 0.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
        renderItem.renderIcon(0, 0, icon, 16, 16);
	}
}


/*
 * 
 * switch(type) {
		
		case EQUIPPED: {
			
			GL11.glPushMatrix();
			GL11.glRotatef(15F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(10F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(10F, 1.0F, 0.0F, 0.0F);
			GL11.glRotated(5, 0.0, 1.0, 0.0);
			//float scale = 0.2F;
			//GL11.glScalef(scale, scale, scale);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			//GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			
			//GL11.glRotated(90, 1.0, 0.0, 0.0);

			GL11.glTranslatef(0.45F, 0.2F, 0.0F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			model.renderAll();

			GL11.glPopMatrix();
		} break;
		
		case EQUIPPED_FIRST_PERSON: {
			
			GL11.glPushMatrix();
			GL11.glRotated(90F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-25F, 1.0F, 0.0F, 0.0F);
			float scale = 0.8F;
			GL11.glScalef(scale, scale, scale);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE

			//GL11.glRotated(180, 0.0, 0.0, 1.0);
			//GL11.glRotated(180, 0.0F, 1.0F, 0.0F);
			//GL11.glRotated(180, 1.0F, 0.0F, 0.0F);

			GL11.glTranslatef(0.3F, -0.2F, 0.7F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			model.renderAll();

			GL11.glPopMatrix();
			
		} break;
		
		case INVENTORY: {
			GL11.glPushMatrix();
			GL11.glRotated(90F, 0.0F, 1.0F, 0.0F);
			GL11.glRotated(135F, 1.0F, 0.0F, 0.0F);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			
			GL11.glScalef(6.0F, 6.0F, 6.0F);
			GL11.glTranslatef(0.0F, -0.3F, -1.85F);
			//GL11.glRotatef(135, 0.0F, 0.0F, -1.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			model.renderAll();
		  
			GL11.glPopMatrix();

		} break;
		
		case ENTITY: {
			GL11.glPushMatrix();
			
			GL11.glScalef(0.7F, 0.7F, 0.7F);
			GL11.glTranslatef(0.0F, 1.0F, 0.0F);
			//GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			model.renderAll();
		  
			GL11.glPopMatrix();
 * 
 * 
 */