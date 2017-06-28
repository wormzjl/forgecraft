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
import com.kitsu.medievalcraft.tileents.ingots.TileRedstoneIngot;

import cpw.mods.fml.client.FMLClientHandler;

public class RedstoneIngotRenderer extends TileEntitySpecialRenderer {

	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/MyRedstoneBlock.png");
	public static final ResourceLocation TEXTURE1 = new ResourceLocation("kitsumedievalcraft:models/MyHotRedstoneBlock.png");
	private static final ResourceLocation MODEL_BASE = new ResourceLocation("kitsumedievalcraft:models/IronIngotBlock.obj");

	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL_BASE);

	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glScalef(0.3F, 0.3F, 0.3F);
		GL11.glTranslatef(1.65F, 0.175F, 1.75F);
		GL11.glRotatef(15F, 0F, 1F, 0F);
		TileRedstoneIngot tile = (TileRedstoneIngot) tileEnt;
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
		renderBlock(tile, tileEnt.getWorldObj(), tileEnt.xCoord,tileEnt.yCoord, tileEnt.zCoord, ModBlocks.redstoneIngot);
		GL11.glPopMatrix();
	}
	
	@SuppressWarnings({ "cast"})
	public void renderBlock(TileRedstoneIngot tl, World world, int i, int j,int k, Block block) {
		GL11.glPushMatrix();
		this.model.renderAll();
		GL11.glPopMatrix();
	}

}