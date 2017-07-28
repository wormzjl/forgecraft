package com.kitsu.medievalcraft.renderer.blocks.cannons;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.cannon.TileCannon_28;
import com.kitsu.medievalcraft.tileents.machine.TileEntityAnvilForge;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class Render_Cannon_28 extends TileEntitySpecialRenderer {

	EntityItem entItem = null;

	private static final ResourceLocation MODEL_CRUCIBLE = new ResourceLocation("kitsumedievalcraft:models/Cannon.obj");
	private static final ResourceLocation MODEL_MOUNT = new ResourceLocation("kitsumedievalcraft:models/cannon_mount.obj");
	//private static final ResourceLocation MODEL_CRUCIBLE = new ResourceLocation("kitsumedievalcraft:models/cannonTest.obj");
	private static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/Cannon.png");
	private static final ResourceLocation TEXTURE_MOUNT = new ResourceLocation("kitsumedievalcraft:models/cannon_mount.png");
	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL_CRUCIBLE);
	private IModelCustom modelMount = AdvancedModelLoader.loadModel(MODEL_MOUNT);

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float scale) {
		TileCannon_28 tileEntity = (TileCannon_28)tile;
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		
		renderBlock(tileEntity, tile.getWorldObj(), tile.xCoord,tile.yCoord, tile.zCoord, ModBlocks.cannon_28);
		tileEntity.markForUpdate();
		tileEntity.markDirty();
		GL11.glPopMatrix();
	}


	public void renderBlock(TileCannon_28 tl, World world, int i, int j,int k, Block block) {
		Tessellator tessellator = Tessellator.instance;
		
		float f = block.getLightOpacity(world, i, j, k);
		int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		int l1 = l % 65536;
		int l2 = l / 65536;
		tessellator.setNormal(0.0F, 1.0F, 0.0F);

		int dir = world.getBlockMetadata(i, j, k);
		float a = -22.5F;
		GL11.glPushMatrix();
		//GL11.glRotatef(15F, 0F, 1F, 0F);
		float scale = 1.05f;
		GL11.glScalef(scale, scale, scale);

		GL11.glTranslatef(0.5F, 0.41F, 0.5F);
		GL11.glRotatef(a*dir, 0.0F, 1.0F, 0.0F);
		
		//
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);
		/*
		 * Place your rendering code here.
		 */
		this.model.renderAll();
		
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		//GL11.glRotatef(15F, 0F, 1F, 0F);
		float scale1 = 1.05f;
		GL11.glScalef(scale1, scale1, scale1);

		GL11.glTranslatef(0.5F, 0.41F, 0.5F);
		GL11.glRotatef(a*dir, 0.0F, 1.0F, 0.0F);
		
		//
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE_MOUNT);
		/*
		 * Place your rendering code here.
		 */
		this.modelMount.renderAll();
		
		GL11.glPopMatrix();
	}

}