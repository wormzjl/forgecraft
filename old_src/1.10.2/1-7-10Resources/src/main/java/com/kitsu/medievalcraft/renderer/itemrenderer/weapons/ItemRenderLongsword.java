package com.kitsu.medievalcraft.renderer.itemrenderer.weapons;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;
//import com.kitsu.medievalcraft.models.Model;

	

public class ItemRenderLongsword implements IItemRenderer {

	public static final ResourceLocation LONGSWORD = new ResourceLocation("kitsumedievalcraft:models/Longsword.obj");
	public static final ResourceLocation blade = new ResourceLocation("kitsumedievalcraft:models/Longsword.png");
	
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
			GL11.glScalef(0.19F, 0.19F, 0.19F);
			
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			//GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(45F, 0.0F, 0.0F, 1.0F);
			//GL11.glRotated(90, 1.0, 0.0, 0.0);

			GL11.glTranslatef(3.6F, -3.15F, 0.0F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			model.renderAll();

			GL11.glPopMatrix();
		} break;
		
		case EQUIPPED_FIRST_PERSON: {
			
			GL11.glPushMatrix();
			GL11.glScalef(0.3F, 0.3F, 0.3F);
			
			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE

			GL11.glRotatef(40F, 0.0F, 0.0F, 1.0F);

			//GL11.glRotated(-85, 1.0, 0.0, 0.0);
			//GL11.glRotated(50, 0.0F, 0.0F, 1.0F);
			//GL11.glRotated(3, 0.0F, 1.0F, 0.0F);

			//GL11.glTranslatef(0.9F, -0.9F, 0.9F);
			GL11.glTranslatef(2.75F, -4.0F, 0.0F);
		
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			model.renderAll();

			GL11.glPopMatrix();
			
		} break;
		
		case INVENTORY: {
			GL11.glPushMatrix();
			
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glScalef(1.6F, 1.6F, 1.6F);
			GL11.glTranslatef(0.9F, 9.25F, 0.0F);
			GL11.glRotatef(135, 0.0F, 0.0F, -1.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(blade);
			model.renderAll();
		  
			GL11.glPopMatrix();

		} break;
		
		case ENTITY: {
			GL11.glPushMatrix();
			
			GL11.glScalef(0.28F, 0.28F, 0.28F);
			//GL11.glTranslatef(1.8F, 2.46F, 0.0F);
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