package com.kitsu.medievalcraft.renderer.itemrenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRendererLongbow implements IItemRenderer {

	//MODELS
	//public static final ResourceLocation MODEL_X = new ResourceLocation("kitsumedievalcraft:models/NewLongbow.obj");
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
	//public IModelCustom model = AdvancedModelLoader.loadModel(MODEL_X);;
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
	
	private float x0 = 0.15F;
	private float x1 = 0.30F;
	private float x2 = 0.45F;
	private float x3 = 0.60F;
	private float x4 = 0.75F;
	private float x5 = 0.90F;
	private float x6 = 1.05F;
	private float x7 = 1.2F;
	private float x8 = 1.35F;
	private float x9 = 1.5F;
	//private float x10 = 1.65F;
	private float a = 1.8F;


	
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
	
	private void shootingRotate(){
		GL11.glTranslatef(-1.75F, -0.75F, 1.5F);
		GL11.glRotated(70, 1.0, 0.0, 0.0);
		GL11.glRotated(20, 0.0, 1.0, 0.0);
		GL11.glRotated(10, 0.0, 0.0, 1.0);
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack stack, Object... data) {
		
		switch(type) {
		
		case EQUIPPED: {
			
			GL11.glPushMatrix();
			GL11.glRotated(190, 0.0, 1.0, 0.0);
			GL11.glRotated(-14, 0.0, 0.0, 1.0);
			GL11.glRotated(-11, 1.0, 0.0, 0.0);
			float equipScale = 0.55F;
			GL11.glScalef(equipScale,equipScale, equipScale);
			
			GL11.glTranslatef(-0.75F, 0.0F, -0.45F);

			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);

			if(stack.stackTagCompound.getInteger("D") == 0){
				GL11.glTranslatef(0.0F, 0.0F, 0.2F);
				model_0.renderAll();
			}

			if(stack.stackTagCompound.getInteger("D") == 1){
				model_1.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F-x0, -0.075F, 0.1F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 2){
				model_2.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x1, -0.075F, 0.1F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 3){
				
				model_3.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x2, -0.075F, 0.1F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 4){
				
				model_4.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x3, -0.075F, 0.1F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 5){
				
				model_5.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x4, -0.075F, 0.1F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 6){
				
				model_6.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x5, -0.075F, 0.1F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 7){
				
				model_7.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x6, -0.075F, 0.1F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 8){
				
				model_8.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x7, -0.075F, 0.1F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 9){
				
				model_9.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x8, -0.075F, 0.1F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 10){
				
				model_10.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x9, -0.075F, 0.1F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}

			GL11.glPopMatrix();
		} break;

		case EQUIPPED_FIRST_PERSON: {
			
			GL11.glPushMatrix();
			GL11.glRotated(-20, 0.0, 1.0, 0.0);
			GL11.glRotated(50, 0.0, 0.0, 1.0);
			GL11.glRotated(5, 1.0, 0.0, 0.0);
			float equipScale = 0.55F;
			GL11.glScalef(equipScale,equipScale, equipScale);
			GL11.glRotatef(270F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(280F, 0.0F, 1.0F, 0.0F);

			GL11.glTranslatef(0.4F, 1.4F, -2.0F);

			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);

			if(stack.stackTagCompound.getInteger("D") == 0){

				model_0.renderAll();
			}

			if(stack.stackTagCompound.getInteger("D") == 1){
				shootingRotate();
				
				model_1.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F-x0, -0.075F, 0.2F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 2){
				
				shootingRotate();
				
				model_2.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x1, -0.075F, 0.2F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 3){
				shootingRotate();

				model_3.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x2, -0.075F, 0.2F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 4){
				shootingRotate();

				model_4.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x3, -0.075F, 0.2F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 5){
				shootingRotate();

				model_5.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x4, -0.075F, 0.2F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 6){
				shootingRotate();

				model_6.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x5, -0.075F, 0.2F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 7){
				shootingRotate();

				model_7.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x6, -0.075F, 0.2F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 8){
				shootingRotate();

				model_8.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x7, -0.075F, 0.2F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 9){
				shootingRotate();

				model_9.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x8, -0.075F, 0.2F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}
			if(stack.stackTagCompound.getInteger("D") == 10){
				shootingRotate();

				model_10.renderAll();
				GL11.glPushMatrix();
				GL11.glScalef(a, a, a);
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.68F - x9, -0.075F, 0.2F);
				Minecraft.getMinecraft().renderEngine.bindTexture(ARROWTEXTURE);
				model_arrow.renderAll();
				GL11.glPopMatrix();
			}

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
			model_0.renderAll();

			GL11.glPopMatrix();

		} break;

		case ENTITY: {
			GL11.glPushMatrix();
			float eScale = 0.45F;
			GL11.glScalef(eScale, eScale, eScale);

			GL11.glTranslatef(0.0F, 3.9F, 0.0F);

			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model_0.renderAll();

			GL11.glPopMatrix();

		} break;

		default: 
			break;
		}
	}

}



