package com.kitsu.medievalcraft.renderer.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.TileEntityTestBlock;

import cpw.mods.fml.client.FMLClientHandler;

public class TestBlockRenderer extends TileEntitySpecialRenderer {

	public static final ResourceLocation MODEL = new ResourceLocation("kitsumedievalcraft:models/Shelf.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/ShelfMini32.png");
	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL);
	
	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {
		
		GL11.glPushMatrix();
		// This will move our renderer so that it will be on proper place in the
		// world
		GL11.glTranslatef((float) x, (float) y, (float) z);
		TileEntityTestBlock tileEntityBlock = (TileEntityTestBlock) tileEnt;

		renderBlock(tileEntityBlock, tileEnt.getWorldObj(), tileEnt.xCoord,tileEnt.yCoord, tileEnt.zCoord, ModBlocks.testBlock);
		GL11.glPopMatrix();
	}
	
	public void renderBlock(TileEntityTestBlock tl, World world, int i, int j,int k, Block block) {
		
		GL11.glPushMatrix();

		float scale = 0.5F;
		GL11.glScalef(scale, scale, scale);
		GL11.glTranslatef(1F, 1F, 1F);

		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);

		this.model.renderAll();
		GL11.glPopMatrix();
	}

}
