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
import com.kitsu.medievalcraft.tileents.TileEntitySmallLid;

import cpw.mods.fml.client.FMLClientHandler;

public class BarrelLidRender extends TileEntitySpecialRenderer {

	public static final ResourceLocation MODEL = new ResourceLocation("kitsumedievalcraft:models/BarrelLid.obj");
	private ResourceLocation loc;
	private ResourceLocation TEXTURE9 = new ResourceLocation("kitsumedievalcraft:models/BarrelLidRing.png");
	private ResourceLocation TEXTURE8 = new ResourceLocation("kitsumedievalcraft:models/BarrelLid8.png");
	private ResourceLocation TEXTURE7 = new ResourceLocation("kitsumedievalcraft:models/BarrelLid7.png");
	private ResourceLocation TEXTURE6 = new ResourceLocation("kitsumedievalcraft:models/BarrelLid6.png");
	private ResourceLocation TEXTURE5 = new ResourceLocation("kitsumedievalcraft:models/BarrelLid5.png");
	private ResourceLocation TEXTURE4 = new ResourceLocation("kitsumedievalcraft:models/BarrelLid4.png");
	private ResourceLocation TEXTURE3 = new ResourceLocation("kitsumedievalcraft:models/BarrelLid3.png");
	private ResourceLocation TEXTURE2 = new ResourceLocation("kitsumedievalcraft:models/BarrelLid2.png");
	private ResourceLocation TEXTURE1 = new ResourceLocation("kitsumedievalcraft:models/BarrelLid1.png");
	private ResourceLocation TEXTURE0 = new ResourceLocation("kitsumedievalcraft:models/BarrelLid0.png");

	//private IModelCustom model;
	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL);

	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {

		GL11.glPushMatrix();
		// This will move our renderer so that it will be on proper place in the
		// world
		GL11.glTranslatef((float) x, (float) y, (float) z);
		TileEntitySmallLid tile = (TileEntitySmallLid) tileEnt;

		if(tile.logs==0){
			loc = TEXTURE0;
			tile.markForUpdate();
			tile.markDirty();
		}
		if(tile.logs==1){
			loc = TEXTURE1;
			tile.markForUpdate();
			tile.markDirty();
		}
		if(tile.logs==2){
			loc = TEXTURE2;
			tile.markForUpdate();
			tile.markDirty();
		}
		if(tile.logs==3){
			loc = TEXTURE3;
			tile.markForUpdate();
			tile.markDirty();
		}
		if(tile.logs==4){
			loc = TEXTURE4;
			tile.markForUpdate();
			tile.markDirty();
		}
		if(tile.logs==5){
			loc = TEXTURE5;
			tile.markForUpdate();
			tile.markDirty();
		}
		if(tile.logs==6){
			loc = TEXTURE6;
			tile.markForUpdate();
			tile.markDirty();
		}
		if(tile.logs==7){
			loc = TEXTURE7;
			tile.markForUpdate();
			tile.markDirty();
		}
		if(tile.logs==8){
			loc = TEXTURE8;
			tile.markForUpdate();
			tile.markDirty();
		}
		if(tile.ring==1){
			loc = TEXTURE9;
			tile.markForUpdate();
			tile.markDirty();
		}

		FMLClientHandler.instance().getClient().renderEngine.bindTexture(loc);
		renderBlock(tile, tileEnt.getWorldObj(), tileEnt.xCoord,tileEnt.yCoord, tileEnt.zCoord, ModBlocks.smallBarrelLid);
		GL11.glPopMatrix();
	}

	
	public void renderBlock(TileEntitySmallLid tl, World world, int i, int j,int k, Block block) {

		GL11.glPushMatrix();
		//GL11.glRotatef(15F, 0F, 1F, 0F);
		float scale = 0.3F;
		GL11.glScalef(scale, scale+0.1F, scale);
		GL11.glTranslatef(1.66F,0.06F,1.66F);
		GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);

		this.model.renderAll();
		GL11.glPopMatrix();
	}

}