package com.kitsu.medievalcraft.renderer.blocks.cannons;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.entity.EntityCannonBall;
import com.kitsu.medievalcraft.entity.EntityITSpear;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class Render_CannonBall_Iron extends Render
{

	//private static final ResourceLocation arrowTextures = new ResourceLocation("textures/entity/arrow.png");
	private static final ResourceLocation arrowTextures = new ResourceLocation("kitsumedievalcraft:textures/items/Cannon.png");
	public static final ResourceLocation MODEL = new ResourceLocation("kitsumedievalcraft:models/cannon_ball.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/Cannon.png");

	public IModelCustom model = AdvancedModelLoader.loadModel(MODEL);

	public void doRender(EntityCannonBall ent, double x, double y, double z, float p_76986_8_, float p_76986_9_)
	{
		GL11.glPushMatrix();
		float scale = 0.01f;
		GL11.glScalef(scale, scale, scale);
		GL11.glTranslatef((float)x, (float)y, (float)z );
		//GL11.glRotatef(ent.prevRotationYaw + (ent.rotationYaw - ent.prevRotationYaw) * p_76986_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
		//GL11.glRotatef(ent.prevRotationPitch + (ent.rotationPitch - ent.prevRotationPitch) * p_76986_9_, 0.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
		model.renderAll();

		GL11.glPopMatrix();
	}

	protected ResourceLocation getEntityTexture(EntityCannonBall p_110775_1_)
	{
		return arrowTextures;
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return this.getEntityTexture((EntityCannonBall)p_110775_1_);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */

	public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		//System.out.println("doRender Ran");
		this.doRender((EntityCannonBall)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	}

}