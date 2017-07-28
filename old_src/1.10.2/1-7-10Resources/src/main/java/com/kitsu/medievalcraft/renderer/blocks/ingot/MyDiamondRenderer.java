package com.kitsu.medievalcraft.renderer.blocks.ingot;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.ingots.TileEntityMyDiamond;

import cpw.mods.fml.client.FMLClientHandler;

public class MyDiamondRenderer extends TileEntitySpecialRenderer {
	
	public static final ResourceLocation MODEL_BASE = new ResourceLocation("kitsumedievalcraft:models/Diamond.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/Diamond.png");
	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL_BASE);
	
	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {
		
		GL11.glPushMatrix();

		GL11.glTranslatef((float) x, (float) y, (float) z);
		TileEntityMyDiamond tileEntityBlock = (TileEntityMyDiamond) tileEnt;

		renderBlock(tileEntityBlock, tileEnt.getWorldObj(), tileEnt.xCoord,tileEnt.yCoord, tileEnt.zCoord, ModBlocks.myDiamond);
		GL11.glPopMatrix();
	}
	
	@SuppressWarnings({"cast" })
	public void renderBlock(TileEntityMyDiamond tl, World world, int i, int j,int k, Block block) {

		GL11.glPushMatrix();

		GL11.glScalef(0.08F, 0.08F, 0.08F);
		GL11.glTranslatef(6.3F, 0.0F, 6.3F);

		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);

		this.model.renderAll();
		GL11.glPopMatrix();
	}

}
