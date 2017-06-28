package com.kitsu.medievalcraft.renderer.blocks.emptycrucibles;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntityFilledWaterCrucible;

import cpw.mods.fml.client.FMLClientHandler;

public class WaterCrucibleRender extends TileEntitySpecialRenderer {

	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/EmptyWaterCrucible.png");
	public static final ResourceLocation TEXTUREa = new ResourceLocation("kitsumedievalcraft:models/emptycookedcrucible.png");
	private static final ResourceLocation MODEL_CRUCIBLE = new ResourceLocation("kitsumedievalcraft:models/EmptyCrucible.obj");

	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL_CRUCIBLE);

	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {

		GL11.glPushMatrix();

		GL11.glTranslatef((float) x, (float) y, (float) z);
		TileEntityFilledWaterCrucible tileEntityBlock = (TileEntityFilledWaterCrucible) tileEnt;

		renderBlock(tileEntityBlock, tileEnt.getWorldObj(), tileEnt.xCoord,tileEnt.yCoord, tileEnt.zCoord, ModBlocks.filledWaterCrucible);
		GL11.glPopMatrix();
	}
	
	@SuppressWarnings({ "cast"})
	public void renderBlock(TileEntityFilledWaterCrucible tl, World world, int i, int j,int k, Block block) {

		GL11.glPushMatrix();

		GL11.glScalef(0.28F, 0.28F, 0.28F);

		GL11.glTranslatef(1.76F, 0.0F, 1.85F);

		GL11.glRotatef(28.5F, 0F, 1F, 0F);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);

		this.model.renderAll();
		GL11.glPopMatrix();
	}
}