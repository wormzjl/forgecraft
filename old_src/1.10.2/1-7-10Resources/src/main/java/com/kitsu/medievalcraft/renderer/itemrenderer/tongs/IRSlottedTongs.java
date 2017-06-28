package com.kitsu.medievalcraft.renderer.itemrenderer.tongs;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class IRSlottedTongs implements IItemRenderer {

	public static final ResourceLocation MODEL_TONGS = new ResourceLocation("kitsumedievalcraft:models/TongsEmpty.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/StoneTongs.png");

	public static final ResourceLocation MODEL_TONGS_CRUCIBLE = new ResourceLocation("kitsumedievalcraft:models/StoneTongsCrucible.obj");
	public static final ResourceLocation TEXTURE_CRUCIBLE = new ResourceLocation("kitsumedievalcraft:models/StoneTongsCrucible.png");

	public static final ResourceLocation MODEL_TONGS_INGOT = new ResourceLocation("kitsumedievalcraft:models/StoneTongsIngot.obj");
	public static final ResourceLocation TEXTURE_INGOT = new ResourceLocation("kitsumedievalcraft:models/StoneTongsIngot.png");

	public static final ResourceLocation MODEL = new ResourceLocation("kitsumedievalcraft:models/CrucibleModel.obj");
	public static final ResourceLocation CRUCIBLETEXT = new ResourceLocation("kitsumedievalcraft:models/HotCrucible.png");

	public static final ResourceLocation MODEL_INGOT = new ResourceLocation("kitsumedievalcraft:models/IronIngotBlock.obj");
	public static final ResourceLocation LAPIS = new ResourceLocation("kitsumedievalcraft:models/MyHotLapisBlock.png");
	public static final ResourceLocation REDSTONE = new ResourceLocation("kitsumedievalcraft:models/MyHotRedstoneBlock.png");
	public static final ResourceLocation DAMASCUS = new ResourceLocation("kitsumedievalcraft:models/HotDamascusIngot.png");
	public static final ResourceLocation REFINEDIRON = new ResourceLocation("kitsumedievalcraft:models/HotIronIngotBlock.png");
	public static final ResourceLocation IRON_PLATE = new ResourceLocation("kitsumedievalcraft:models/HotIronPlate.png");
	
	public static final ResourceLocation MODEL_PLATE = new ResourceLocation("kitsumedievalcraft:models/IronPlate.obj");
	public static final ResourceLocation PLATE_TEXTURE = new ResourceLocation("kitsumedievalcraft:models/IronPlate.png");
	public static final ResourceLocation HOTPLATE_TEXTURE = new ResourceLocation("kitsumedievalcraft:models/HotIronPlate.png");

	public IModelCustom model = AdvancedModelLoader.loadModel(MODEL_TONGS);
	public IModelCustom modeltc = AdvancedModelLoader.loadModel(MODEL_TONGS_CRUCIBLE);
	public IModelCustom modelti = AdvancedModelLoader.loadModel(MODEL_TONGS_INGOT);
	public IModelCustom modelC = AdvancedModelLoader.loadModel(MODEL);
	public IModelCustom modelingot = AdvancedModelLoader.loadModel(MODEL_INGOT);
	public IModelCustom modelPlate = AdvancedModelLoader.loadModel(MODEL_PLATE);

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
	public void renderItem(ItemRenderType type, ItemStack stack, Object... data) {

		switch(type) {

		case EQUIPPED: {

			GL11.glPushMatrix();

			float scale = 0.5F;
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(100F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(110F, 1.0F, 0.0F, 0.0F);
			GL11.glRotated(25, 0.0, 0.0, 1.0);
			GL11.glTranslatef(0.2F, 0.0F, 0.85F);
			if(stack.isItemDamaged()==false){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
				model.renderAll();
			}
			//Crucible Renderer
			if((stack.getItemDamage()==1)||(stack.getItemDamage()==2)||(stack.getItemDamage()==3)||(stack.getItemDamage()==4)||(stack.getItemDamage()==5)){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_CRUCIBLE);
				modeltc.renderAll();

				GL11.glPushMatrix();
				float scale1 = 0.6F;
				GL11.glScalef(scale1, scale1, scale1);
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(7.6F, -1.8F, 0.0F);
				Minecraft.getMinecraft().renderEngine.bindTexture(CRUCIBLETEXT);
				modelC.renderAll();
				GL11.glPopMatrix();
			}

			if(stack.getItemDamage()==6||
					stack.getItemDamage()==7||
					stack.getItemDamage()==8||
					stack.getItemDamage()==9){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_INGOT);
				modelti.renderAll();
				GL11.glPushMatrix();
				float scale1 = 1.1F;
				GL11.glScalef(scale1, scale1, scale1);
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(4.7F, 0.15F, 0.0F);
				if(stack.getItemDamage()==6){Minecraft.getMinecraft().renderEngine.bindTexture(LAPIS);}
				if(stack.getItemDamage()==7){Minecraft.getMinecraft().renderEngine.bindTexture(REDSTONE);}
				if(stack.getItemDamage()==8){Minecraft.getMinecraft().renderEngine.bindTexture(DAMASCUS);}
				if(stack.getItemDamage()==9){Minecraft.getMinecraft().renderEngine.bindTexture(REFINEDIRON);}
				modelingot.renderAll();
				GL11.glPopMatrix();
			}
			
			if((stack.getItemDamage()==10)){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_CRUCIBLE);
				modeltc.renderAll();
				GL11.glPushMatrix();
				float scale1 = 0.6F;
				GL11.glScalef(scale1, 3.0f, scale1);
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(8.6F, 0.0F, 0.0F);
				Minecraft.getMinecraft().renderEngine.bindTexture(HOTPLATE_TEXTURE);
				modelPlate.renderAll();
				GL11.glPopMatrix();
			}

			GL11.glPopMatrix();

		} break;

		case EQUIPPED_FIRST_PERSON: {

			GL11.glPushMatrix();
			float f = 0.5F;
			GL11.glScalef(f, f, f);
			GL11.glRotatef(40F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-0.05F, 0.0F, -1.0F);

			if(stack.isItemDamaged()==false){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
				model.renderAll();
			}
			//Crucible Renderer
			if((stack.getItemDamage()==1)||(stack.getItemDamage()==2)||(stack.getItemDamage()==3)||(stack.getItemDamage()==4)||(stack.getItemDamage()==5)){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_CRUCIBLE);
				modeltc.renderAll();
				GL11.glPushMatrix();
				float scale = 0.6F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(7.5F, -1.8F, 0.0F);
				Minecraft.getMinecraft().renderEngine.bindTexture(CRUCIBLETEXT);
				modelC.renderAll();
				GL11.glPopMatrix();
			}

			if(stack.getItemDamage()==6||
					stack.getItemDamage()==7||
					stack.getItemDamage()==8||
					stack.getItemDamage()==9){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_INGOT);
				modelti.renderAll();
				GL11.glPushMatrix();
				float scale = 1.1F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(4.7F, 0.15F, 0.0F);
				if(stack.getItemDamage()==6){Minecraft.getMinecraft().renderEngine.bindTexture(LAPIS);}
				if(stack.getItemDamage()==7){Minecraft.getMinecraft().renderEngine.bindTexture(REDSTONE);}
				if(stack.getItemDamage()==8){Minecraft.getMinecraft().renderEngine.bindTexture(DAMASCUS);}
				if(stack.getItemDamage()==9){Minecraft.getMinecraft().renderEngine.bindTexture(REFINEDIRON);}
				modelingot.renderAll();
				GL11.glPopMatrix();
			}
			
			if((stack.getItemDamage()==10)){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_CRUCIBLE);
				modeltc.renderAll();
				GL11.glPushMatrix();
				float scale = 0.6F;
				GL11.glScalef(scale, 3.0f, scale);
				GL11.glTranslatef(8.6F, 0.0F, 0.0F);
				Minecraft.getMinecraft().renderEngine.bindTexture(HOTPLATE_TEXTURE);
				modelPlate.renderAll();
				GL11.glPopMatrix();
			}

			GL11.glPopMatrix();

		} break;

		case INVENTORY: {

			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			float f = 3.0F;
			GL11.glScalef(f, f, f);
			GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-45, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-1.8F, 0.0F, -3.7F);
			if(stack.isItemDamaged()==false){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
				model.renderAll();
			}

			//Crucible Renderer
			if((stack.getItemDamage()==1)||(stack.getItemDamage()==2)||(stack.getItemDamage()==3)||(stack.getItemDamage()==4)||(stack.getItemDamage()==5)){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_CRUCIBLE);
				modeltc.renderAll();
				GL11.glPushMatrix();
				float scale = 0.5F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(9.25F, 0.15F, 0.0F);
				Minecraft.getMinecraft().renderEngine.bindTexture(CRUCIBLETEXT);
				modelC.renderAll();
				GL11.glPopMatrix();
			}

			if(stack.getItemDamage()==6||
					stack.getItemDamage()==7||
					stack.getItemDamage()==8||
					stack.getItemDamage()==9){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_INGOT);
				modelti.renderAll();
				GL11.glPushMatrix();
				float scale = 0.6F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(8.6F, 0.15F, 0.0F);	
				if(stack.getItemDamage()==6){Minecraft.getMinecraft().renderEngine.bindTexture(LAPIS);}
				if(stack.getItemDamage()==7){Minecraft.getMinecraft().renderEngine.bindTexture(REDSTONE);}
				if(stack.getItemDamage()==8){Minecraft.getMinecraft().renderEngine.bindTexture(DAMASCUS);}
				if(stack.getItemDamage()==9){Minecraft.getMinecraft().renderEngine.bindTexture(REFINEDIRON);}
				modelingot.renderAll();
				GL11.glPopMatrix();
			}
			
			if((stack.getItemDamage()==10)){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_CRUCIBLE);
				modeltc.renderAll();
				GL11.glPushMatrix();
				float scale = 0.6F;
				GL11.glScalef(scale, 3.0f, scale);
				GL11.glTranslatef(8.6F, 0.0F, 0.0F);
				Minecraft.getMinecraft().renderEngine.bindTexture(HOTPLATE_TEXTURE);
				modelPlate.renderAll();
				GL11.glPopMatrix();
			}

			GL11.glPopMatrix();
		} break;

		case ENTITY: {
			GL11.glPushMatrix();
			float f = 0.45F;
			GL11.glScalef(f, f, f);
			if(stack.isItemDamaged()==false){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
				model.renderAll();
			}
			//Crucible Renderer
			if((stack.getItemDamage()==1)||(stack.getItemDamage()==2)||(stack.getItemDamage()==3)||(stack.getItemDamage()==4)||(stack.getItemDamage()==5)){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_CRUCIBLE);
				modeltc.renderAll();
				GL11.glPushMatrix();
				float scale = 0.55F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(8.4F, -1.8F, 0.0F);
				Minecraft.getMinecraft().renderEngine.bindTexture(CRUCIBLETEXT);
				modelC.renderAll();
				GL11.glPopMatrix();
			}

			if(stack.getItemDamage()==6||
					stack.getItemDamage()==7||
					stack.getItemDamage()==8||
					stack.getItemDamage()==9){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_INGOT);
				modelti.renderAll();
				//Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
				//model.renderAll();
				GL11.glPushMatrix();
				float scale = 0.6F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(8.6F, 0.15F, 0.0F);
				if(stack.getItemDamage()==6){Minecraft.getMinecraft().renderEngine.bindTexture(LAPIS);}
				if(stack.getItemDamage()==7){Minecraft.getMinecraft().renderEngine.bindTexture(REDSTONE);}
				if(stack.getItemDamage()==8){Minecraft.getMinecraft().renderEngine.bindTexture(DAMASCUS);}
				if(stack.getItemDamage()==9){Minecraft.getMinecraft().renderEngine.bindTexture(REFINEDIRON);}
				modelingot.renderAll();
				GL11.glPopMatrix();
			}
			if((stack.getItemDamage()==10)){
				Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_CRUCIBLE);
				modeltc.renderAll();
				GL11.glPushMatrix();
				float scale = 0.6F;
				GL11.glScalef(scale, 3.0f, scale);
				GL11.glTranslatef(8.6F, 0.0F, 0.0F);
				Minecraft.getMinecraft().renderEngine.bindTexture(HOTPLATE_TEXTURE);
				modelPlate.renderAll();
				GL11.glPopMatrix();
			}
			
			GL11.glPopMatrix();
		} break;

		default: 
			break;
		}
	}

}

