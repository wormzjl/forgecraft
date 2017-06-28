package com.kitsu.medievalcraft.renderer.itemrenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRendererModelArrow implements IItemRenderer{
	
	public static final ResourceLocation MODEL_CRUCIBLE = new ResourceLocation("kitsumedievalcraft:models/ModelArrow.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/modelarrow.png");
	
	public IModelCustom model = AdvancedModelLoader.loadModel(MODEL_CRUCIBLE);
	
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
	        		helper == ItemRendererHelper.EQUIPPED_BLOCK ||
	        		helper == ItemRendererHelper.INVENTORY_BLOCK ||
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
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-20F, 0.0F, 1.0F, 0.0F);
			//GL11.glRotatef(40F, 1.0F, 0.0F, 0.0F);
			//GL11.glRotated(90, 1.0, 0.0, 0.0);

			GL11.glTranslatef(0.1F, -0.55F, 0.05F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();

			GL11.glPopMatrix();
		} break;
		
		case EQUIPPED_FIRST_PERSON: {
			
			GL11.glPushMatrix();
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE

			GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);

			//GL11.glRotated(-85, 1.0, 0.0, 0.0);
			//GL11.glRotated(50, 0.0F, 0.0F, 1.0F);
			//GL11.glRotated(3, 0.0F, 1.0F, 0.0F);

			GL11.glTranslatef(0.0F, 0.0F, 1.0F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();

			GL11.glPopMatrix();
			
		} break;
		
		case INVENTORY: {
			GL11.glPushMatrix();
			
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			float iscale = 9F;
			GL11.glScalef(iscale, iscale, iscale);
			GL11.glRotatef(-45, 0.0F, 0.0F, 1.0F);
			//GL11.glRotatef(45, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.2F, 1.2F, 0.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();
		  
			GL11.glPopMatrix();

		} break;
		
		case ENTITY: {
			GL11.glPushMatrix();
			GL11.glScalef(1.0F, 1.0F, 1.0F);
						
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			//GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
			//GL11.glRotatef(20F, 0.0F, 0.0F, 1.0F);
			//GL11.glRotatef(45F, 0.0F, 0.0F, 1.0F);
			//GL11.glRotated(90, 1.0, 0.0, 0.0);

			GL11.glTranslatef(-0.0F, -0.2F, 0.0F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
			model.renderAll();
			GL11.glPopMatrix();

		} break;

		default: 
			break;
		}
	}

}
