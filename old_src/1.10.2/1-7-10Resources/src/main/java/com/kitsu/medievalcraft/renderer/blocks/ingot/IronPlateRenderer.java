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
import com.kitsu.medievalcraft.tileents.ingots.TileIronPlate;

import cpw.mods.fml.client.FMLClientHandler;

public class IronPlateRenderer extends TileEntitySpecialRenderer {
	//"kitsumedievalcraft:models/IronPlate.obj"
	public static final ResourceLocation MODEL_BASE = new ResourceLocation("kitsumedievalcraft:models/IronPlate.obj");
	private static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/IronPlate.png");
	private static final ResourceLocation TEXTURE1 = new ResourceLocation("kitsumedievalcraft:models/HotIronPlate.png");
	
	IModelCustom model = AdvancedModelLoader.loadModel(MODEL_BASE);

	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		TileIronPlate tile = (TileIronPlate) tileEnt;
		if(tile.hot==true){
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE1);
			tile.markForUpdate();
			tile.markDirty();
		}
		if(tile.hot==false){
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);
			tile.markForUpdate();
			tile.markDirty();
		}
		renderBlock(tile, tileEnt.getWorldObj(), tileEnt.xCoord,tileEnt.yCoord, tileEnt.zCoord, ModBlocks.ironPlate);
		GL11.glPopMatrix();
	}
	
	@SuppressWarnings({ "cast"})
	public void renderBlock(TileIronPlate tl, World world, int i, int j,int k, Block block) {
		GL11.glPushMatrix();
		GL11.glScalef(0.25F, 1.5F, 0.25F);
		GL11.glTranslatef(2.0F, 0.03F, 2.0F);

		this.model.renderAll();
		GL11.glPopMatrix();
	}

}