package com.kitsu.medievalcraft.renderer.itemrenderer.tongs;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class IRStoneTongsHotIron implements IItemRenderer {

	public static final ResourceLocation MODEL_TONGS = new ResourceLocation("kitsumedievalcraft:models/StoneTongsIngot.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/StoneTongsIngot.png");
	
	public static final ResourceLocation MODEL_INGOT = new ResourceLocation("kitsumedievalcraft:models/IronIngotBlock.obj");
	public static final ResourceLocation INGOT_TEXTURE = new ResourceLocation("kitsumedievalcraft:models/HotIronIngotBlock.png");

	public IModelCustom model = AdvancedModelLoader.loadModel(MODEL_TONGS);
	public IModelCustom modelingot = AdvancedModelLoader.loadModel(MODEL_INGOT);

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
			float f = 0.5F;
			GL11.glScalef(f, f, f);


			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			GL11.glRotatef(100F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(110F, 1.0F, 0.0F, 0.0F);
			GL11.glRotated(25, 0.0, 0.0, 1.0);

			GL11.glTranslatef(0.2F, 0.0F, 0.85F);

			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();
			GL11.glPushMatrix();
			float scale = 1.1F;
			GL11.glScalef(scale, scale, scale);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);

			GL11.glTranslatef(4.7F, 0.15F, 0.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(INGOT_TEXTURE);
			modelingot.renderAll();
			GL11.glPopMatrix();
			GL11.glPopMatrix();

		} break;

		case EQUIPPED_FIRST_PERSON: {

			GL11.glPushMatrix();
			float f = 0.5F;
			GL11.glScalef(f, f, f);

			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE

			GL11.glRotatef(40F, 0.0F, 0.0F, 1.0F);


			GL11.glTranslatef(-0.05F, 0.0F, -1.0F);

			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();
			GL11.glPushMatrix();
			float scale = 1.1F;
			GL11.glScalef(scale, scale, scale);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			//GL11.glRotatef(40F, 0.0F, 0.0F, 1.0F);

			GL11.glTranslatef(4.7F, 0.15F, 0.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(INGOT_TEXTURE);
			modelingot.renderAll();
			GL11.glPopMatrix();
			GL11.glPopMatrix();

		} break;

		case INVENTORY: {

			GL11.glPushMatrix();

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			float f = 2.5F;
			GL11.glScalef(f, f, f);

			GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-45, 0.0F, 1.0F, 0.0F);

			GL11.glTranslatef(-2.0F, 0.0F, -4.35F);

			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();
			GL11.glPushMatrix();
			float scale = 0.6F;
			GL11.glScalef(scale, scale, scale);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			//GL11.glRotatef(40F, 0.0F, 0.0F, 1.0F);

			GL11.glTranslatef(8.6F, 0.15F, 0.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(INGOT_TEXTURE);
			modelingot.renderAll();
			GL11.glPopMatrix();
			GL11.glPopMatrix();


		} break;

		case ENTITY: {
			GL11.glPushMatrix();
			float f = 0.45F;
			GL11.glScalef(f, f, f);

			//GL11.glTranslatef(0.0F, 0.0F, 0.0F);

			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();
			GL11.glPushMatrix();
			float scale = 0.6F;
			GL11.glScalef(scale, scale, scale);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			//GL11.glRotatef(40F, 0.0F, 0.0F, 1.0F);

			GL11.glTranslatef(8.6F, 0.15F, 0.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(INGOT_TEXTURE);
			modelingot.renderAll();
			GL11.glPopMatrix();
			GL11.glPopMatrix();

		} break;

		default: 
			break;
		}
	}

}

