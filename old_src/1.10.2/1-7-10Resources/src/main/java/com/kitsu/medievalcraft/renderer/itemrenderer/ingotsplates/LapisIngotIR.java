package com.kitsu.medievalcraft.renderer.itemrenderer.ingotsplates;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class LapisIngotIR implements IItemRenderer {
	
	public static final ResourceLocation MODEL_CRUCIBLE = new ResourceLocation("kitsumedievalcraft:models/IronIngotBlock.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/MyLapisBlock.png");
	public static final ResourceLocation TEXTURE1 = new ResourceLocation("kitsumedievalcraft:models/MyHotLapisBlock.png");
	private ResourceLocation loc;
	
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
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,ItemRendererHelper helper) {
		
		switch(type) {
		case EQUIPPED: {
			return helper == ItemRendererHelper.BLOCK_3D;
		} 
		case EQUIPPED_FIRST_PERSON: {
			return helper == ItemRendererHelper.EQUIPPED_BLOCK;
		} 
		case INVENTORY: {
			return helper == ItemRendererHelper.INVENTORY_BLOCK;
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
			GL11.glRotated(90, 0, 1.0, 0);
			GL11.glRotated(-20, 1, 0, 0);
			GL11.glScalef(0.75F, 0.75F, 0.75F);
			GL11.glTranslatef(0.0F, 0.0F, 1.15F);
			if(item.getItemDamage()==0){
				loc=TEXTURE;
			}
			if(item.getItemDamage()==1){
				loc=TEXTURE1;
			}
			Minecraft.getMinecraft().renderEngine.bindTexture(loc);
			model.renderAll();
			GL11.glPopMatrix();
		} break;
		
		case EQUIPPED_FIRST_PERSON: {
			float f = 0.75F;
			GL11.glPushMatrix();
			GL11.glRotated(45, 0, 1.0, 0);
			GL11.glRotated(-20, 1, 0, 0);
			GL11.glRotated(30, 0, 0, 1);
			GL11.glScalef(f, f, f);
			GL11.glTranslatef(-0.2F, 1.0F, 1.15F);
			if(item.getItemDamage()==0){
				loc=TEXTURE;
			}
			if(item.getItemDamage()==1){
				loc=TEXTURE1;
			}
			Minecraft.getMinecraft().renderEngine.bindTexture(loc);
			model.renderAll();
			GL11.glPopMatrix();
		} break;
		case INVENTORY: {
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			if(item.getItemDamage()==0){
				loc=TEXTURE;
			}
			if(item.getItemDamage()==1){
				loc=TEXTURE1;
			}
			Minecraft.getMinecraft().renderEngine.bindTexture(loc);
			model.renderAll();
			GL11.glPopMatrix();
		} break;
		case ENTITY: {
			GL11.glPushMatrix();
			if(item.getItemDamage()==0){
				loc=TEXTURE;
			}
			if(item.getItemDamage()==1){
				loc=TEXTURE1;
			}
			Minecraft.getMinecraft().renderEngine.bindTexture(loc);
			model.renderAll();
			GL11.glPopMatrix();
		} break;
		default: 
			break;
		}
	}

}



