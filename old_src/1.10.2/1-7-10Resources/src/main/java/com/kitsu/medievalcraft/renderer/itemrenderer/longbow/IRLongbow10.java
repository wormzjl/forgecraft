package com.kitsu.medievalcraft.renderer.itemrenderer.longbow;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class IRLongbow10 implements IItemRenderer {
	
	//MODELS
		public static final ResourceLocation MODEL_0 = new ResourceLocation("kitsumedievalcraft:models/Longbow0.obj");
		public static final ResourceLocation MODEL_1 = new ResourceLocation("kitsumedievalcraft:models/Longbow1.obj");
		public static final ResourceLocation MODEL_2 = new ResourceLocation("kitsumedievalcraft:models/Longbow2.obj");
		public static final ResourceLocation MODEL_3 = new ResourceLocation("kitsumedievalcraft:models/Longbow3.obj");
		public static final ResourceLocation MODEL_4 = new ResourceLocation("kitsumedievalcraft:models/Longbow4.obj");
		public static final ResourceLocation MODEL_5 = new ResourceLocation("kitsumedievalcraft:models/Longbow5.obj");
		public static final ResourceLocation MODEL_6 = new ResourceLocation("kitsumedievalcraft:models/Longbow6.obj");
		public static final ResourceLocation MODEL_7 = new ResourceLocation("kitsumedievalcraft:models/Longbow7.obj");
		public static final ResourceLocation MODEL_8 = new ResourceLocation("kitsumedievalcraft:models/Longbow8.obj");
		public static final ResourceLocation MODEL_9 = new ResourceLocation("kitsumedievalcraft:models/Longbow9.obj");
		public static final ResourceLocation MODEL_10 = new ResourceLocation("kitsumedievalcraft:models/Longbow10.obj");
		public static final ResourceLocation MODELARROW = new ResourceLocation("kitsumedievalcraft:models/ModelArrow.obj");
		//TEXTURES
		public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/LongbowRig.png");
		public static final ResourceLocation ARROWTEXTURE = new ResourceLocation("kitsumedievalcraft:models/modelarrow.png");
		
		//ASSIGN MODELLOADER
		public IModelCustom model_0 = AdvancedModelLoader.loadModel(MODEL_0);
		public IModelCustom model_1 = AdvancedModelLoader.loadModel(MODEL_1);
		public IModelCustom model_2 = AdvancedModelLoader.loadModel(MODEL_2);
		public IModelCustom model_3 = AdvancedModelLoader.loadModel(MODEL_3);
		public IModelCustom model_4 = AdvancedModelLoader.loadModel(MODEL_4);
		public IModelCustom model_5 = AdvancedModelLoader.loadModel(MODEL_5);
		public IModelCustom model_6 = AdvancedModelLoader.loadModel(MODEL_6);
		public IModelCustom model_7 = AdvancedModelLoader.loadModel(MODEL_7);
		public IModelCustom model_8 = AdvancedModelLoader.loadModel(MODEL_8);
		public IModelCustom model_9 = AdvancedModelLoader.loadModel(MODEL_9);
		public IModelCustom model_10 = AdvancedModelLoader.loadModel(MODEL_10);
		public IModelCustom model_arrow = AdvancedModelLoader.loadModel(MODELARROW);
	
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
			float equipScale = 0.6F;
			GL11.glScalef(equipScale,equipScale, equipScale);


			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			GL11.glRotatef(195F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-15F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-17F, 0.0F, 1.0F, .0F);
			//GL11.glRotated(90, 1.0, 0.0, 0.0);

			GL11.glTranslatef(0.6F, 0.0F, -0.4F);

			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model_10.renderAll();
			//System.out.println(MODEL);
			GL11.glPopMatrix();
		} break;

		case EQUIPPED_FIRST_PERSON: {

			GL11.glPushMatrix();
			//float firstScale = 0.6F;
			GL11.glScalef(0.4F, 0.4F, 0.4F);

			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE

			//GL11.glRotatef(-10F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(40F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
			
			//GL11.glRotated(20, 0.0D, 1.0D, 0.0D);

			GL11.glTranslatef(-1.6F, -0.5F, -1.4F);
			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			
			model_10.renderAll();
			GL11.glPopMatrix();

		} break;

		case INVENTORY: {
			GL11.glPushMatrix();
			float invScale = 1.8F;
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glScalef(invScale+1, invScale, invScale);
			
			GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-35, 1.0F, 0.0F, 0.0F);
			//GL11.glRotatef(0, 0.0F, 0.0F, 1.0F);
			
			GL11.glTranslatef(-15.0F, 2.2F, 3.9F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model_10.renderAll();

			GL11.glPopMatrix();

		} break;

		case ENTITY: {
			GL11.glPushMatrix();
			float eScale = 0.45F;
			GL11.glScalef(eScale, eScale, eScale);


			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			//GL11.glRotatef(-60F, 1.0F, 0.0F, 0.0F);
			//GL11.glRotatef(20F, 0.0F, 0.0F, 1.0F);
			//GL11.glRotatef(45F, 0.0F, 0.0F, 1.0F);
			//GL11.glRotated(90, 1.0, 0.0, 0.0);

			GL11.glTranslatef(0.0F, 3.9F, 0.0F);

			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model_10.renderAll();

			GL11.glPopMatrix();

		} break;

		default: 
			break;
		}
	}

}
