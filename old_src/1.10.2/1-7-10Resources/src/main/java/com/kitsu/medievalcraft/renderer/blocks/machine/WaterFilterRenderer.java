package com.kitsu.medievalcraft.renderer.blocks.machine;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.machine.TileEntityWaterFilter;

import cpw.mods.fml.client.FMLClientHandler;

public class WaterFilterRenderer extends TileEntitySpecialRenderer {
	
	public static final ResourceLocation MODEL_CRUCIBLE = new ResourceLocation("kitsumedievalcraft:models/WaterFilter.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/WaterFilter.png");
	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL_CRUCIBLE);

	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {
		
		GL11.glPushMatrix();

		GL11.glTranslatef((float) x, (float) y, (float) z);
		TileEntityWaterFilter tileEntityBlock = (TileEntityWaterFilter) tileEnt;

		renderBlock(tileEntityBlock, tileEnt.getWorldObj(), tileEnt.xCoord,tileEnt.yCoord, tileEnt.zCoord, ModBlocks.waterFilter);
		GL11.glPopMatrix();
	}
	
	@SuppressWarnings({ "cast"})
	public void renderBlock(TileEntityWaterFilter tl, World world, int i, int j,int k, Block block) {

		GL11.glPushMatrix();

		float scale = 0.5F;
		GL11.glScalef(scale, scale, scale);
		GL11.glTranslatef(1.0F, 1.09F, 1.0F);

		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);

		this.model.renderAll();
		GL11.glPopMatrix();
	}

}
