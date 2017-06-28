package com.kitsu.medievalcraft.renderer.blocks.machine;

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

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.machine.TileEntityFirebox;

import cpw.mods.fml.client.FMLClientHandler;

public class FireboxRenderer extends TileEntitySpecialRenderer {

	//public ModelFirebox model;
	EntityItem entItem = null;
	//boolean slotStatus;
	public static final ResourceLocation MODEL = new ResourceLocation("kitsumedievalcraft:models/Firebox.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/FireboxUV.png");

	IModelCustom model = AdvancedModelLoader.loadModel(MODEL);

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float scale) {
		TileEntityFirebox tileEntity = (TileEntityFirebox)tile;
		
		GL11.glPushMatrix();

		GL11.glTranslatef((float) x, (float) y, (float) z);

		renderBlock(tileEntity, tile.getWorldObj(), tile.xCoord,tile.yCoord, tile.zCoord, ModBlocks.firebox);
		
		if(tileEntity.getStackInSlot(0) != null){
			entItem = new EntityItem(tileEntity.getWorldObj(), x, y, z, tileEntity.getStackInSlot(0));
				GL11.glPushMatrix();
				this.entItem.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(1.0f, 1.0f, 1.0f);
				RenderManager.instance.renderEntityWithPosYaw(entItem, 0.5D, 0.3D, 0.5D, 0.0F, 0.0F);
				GL11.glRotatef(90, 0, 1, 0);
				RenderManager.instance.renderEntityWithPosYaw(entItem, -0.5D, 0.3D, 0.5D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			
			tileEntity.markForUpdate();
			tileEntity.markDirty();
		
		GL11.glPopMatrix();

	}

	@SuppressWarnings({ "cast"})
	public void renderBlock(TileEntityFirebox tl, World world, int i, int j,int k, Block block) {
		int dir = world.getBlockMetadata(i, j, k);

		GL11.glPushMatrix();
		//GL11.glRotatef(15F, 0F, 1F, 0F);
		float scale = 0.50f;
		GL11.glScalef(scale, 1.16F, scale);
		GL11.glTranslatef(1.0F, 0.1F, 1.0F);
		//
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);

		this.model.renderAll();
		GL11.glPopMatrix();
	}

}