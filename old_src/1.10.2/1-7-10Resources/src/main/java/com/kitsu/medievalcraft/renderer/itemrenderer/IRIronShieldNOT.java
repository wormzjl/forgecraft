package com.kitsu.medievalcraft.renderer.itemrenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;
//import com.kitsu.medievalcraft.models.Model;



public class IRIronShieldNOT implements IItemRenderer {

	public static final ResourceLocation IRON_SHIELD = new ResourceLocation("kitsumedievalcraft:models/IronShield.obj");
	public static final ResourceLocation ironshield = new ResourceLocation("kitsumedievalcraft:models/ironshield.png");
	//private static RenderItem renderItem = new RenderItem();
	public static boolean use;


	public IModelCustom model = AdvancedModelLoader.loadModel(IRON_SHIELD);

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {

		switch(type) {
		case EQUIPPED: {
			return false;
		} 
		case EQUIPPED_FIRST_PERSON: {
			return false;
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

		//System.out.println(use);

		switch(type) {

		case EQUIPPED: {

			//EntityClientPlayerMP entityclientplayermp = this.mc.thePlayer;


			//System.out.println(a + " : " + b);
			GL11.glPushMatrix();

			float scale = 0.75F;
			GL11.glScalef(scale, scale, scale);


			//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
			//GL11.glRotatef(30F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-20F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(20F, 0.0F, 0.0F, 1.0F);
			//GL11.glRotated(90, 1.0, 0.0, 0.0);

			GL11.glTranslatef(0.5F, -0.1F, -0.1F);

			Minecraft.getMinecraft().renderEngine.bindTexture(ironshield);
			model.renderAll();

			GL11.glPopMatrix();

		} break;

		case EQUIPPED_FIRST_PERSON: {

			
				GL11.glPushMatrix();
				GL11.glScalef(0.6F, 0.6F, 0.6F);

				//ANGLE, X ROTATE, Y ROTATE, Z ROTATE
				//GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
				//GL11.glRotatef(10F, 0.0F, 0.0F, 0.0F);
				GL11.glRotatef(50F, 0.0F, 1.0F, 0.0F);

				GL11.glRotated(75, 1.0, 0.0, 0.0);
				GL11.glRotated(90, 0.0, 1.0, 0.0);

				GL11.glTranslatef(1.3F, 0.5F, 1.2F);

				Minecraft.getMinecraft().renderEngine.bindTexture(ironshield);
				model.renderAll();

				GL11.glPopMatrix();
				
		} break;

		case INVENTORY: {
			GL11.glPushMatrix();

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glScalef(4.4F, 4.4F, 4.4F);
			GL11.glTranslatef(1.2F, 1.5F, 5.0F);
			//GL11.glRotatef(10, 0.0F, 1.0F, 1.0F);
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
			//GL11.glRotatef(4, 0.0F, 1.0F, 0.0F);

			Minecraft.getMinecraft().renderEngine.bindTexture(ironshield);
			model.renderAll();

			GL11.glPopMatrix();


		} break;

		case ENTITY: {
			GL11.glPushMatrix();

			GL11.glScalef(0.9F, 0.9F, 0.9F);
			//GL11.glTranslatef(1.8F, 2.46F, 0.0F);
			//GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);

			Minecraft.getMinecraft().renderEngine.bindTexture(ironshield);
			model.renderAll();

			GL11.glPopMatrix();


		} break;

		default: 
			break;
		}
	}


}