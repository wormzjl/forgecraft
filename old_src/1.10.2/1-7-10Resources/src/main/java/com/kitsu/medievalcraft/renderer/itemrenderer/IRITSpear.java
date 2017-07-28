package com.kitsu.medievalcraft.renderer.itemrenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class IRITSpear implements IItemRenderer{

	public static final ResourceLocation MODEL = new ResourceLocation("kitsumedievalcraft:models/Spear.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/Spear.png");

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
			return false;
		} 
		case EQUIPPED_FIRST_PERSON: {
			return false;
		} 
		case INVENTORY: {
			return false;
		}
		case ENTITY: {
			return false;
		}

		default: return false;
		}
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		switch(type) {
		case EQUIPPED: {
			GL11.glPushMatrix();
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			if(item.getMaxDamage()==500){
				GL11.glTranslatef(0.5F, 0.6F, -0.125F);
				GL11.glRotatef(40F, 0.0F, 0.0F, 1.0F);
			}
			if(item.getMaxDamage()==100){
				GL11.glTranslatef(0.5F, 0.4F, -0.0F);
				GL11.glRotatef(140F, 0.0F, 0.0F, 1.0F);
			}
			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();
			GL11.glPopMatrix();
			
		} break;

		case EQUIPPED_FIRST_PERSON: {

			GL11.glPushMatrix();
			GL11.glScalef(1.0F, 1.0F, 1.0F);

			if(item.getMaxDamage()==500){
				GL11.glRotatef(40F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.0F, 0.8F, -0.2F);
			}
			if(item.getMaxDamage()==100){
				GL11.glRotatef(110F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.0F, -0.5F, -0.2F);
			}
			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();
			GL11.glPopMatrix();

		} break;

		case INVENTORY: {
			GL11.glPushMatrix();

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			float iscale = 5F;
			GL11.glScalef(iscale, iscale, iscale);
			GL11.glTranslatef(1.5F,  1.5F, 0.0F);
			GL11.glRotatef(-45, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
			//GL11.glTranslatef(0.2F, 1.2F, 0.0F);

			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();

			GL11.glPopMatrix();

		} break;

		case ENTITY: {
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			GL11.glScalef(2.0F, 2.0F, 2.0F);
			//GL11.glTranslatef(5.0F, 5.0F, 5.0F);

			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			//GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			//GL11.glRotatef(90F, 1.0F, 0.0F, 1.0F);
			//GL11.glRotatef(45F, 0.0F, 0.0F, 1.0F);
			//GL11.glRotated(90, 1.0, 0.0, 0.0);

			model.renderAll();
			GL11.glPopMatrix();

		} break;

		default: 
			break;
		}
	}

}
