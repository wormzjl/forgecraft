package com.kitsu.medievalcraft.renderer.blocks.crucibles;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleWootz;

import cpw.mods.fml.client.FMLClientHandler;

public class WootzCrucibleRenderer extends TileEntitySpecialRenderer {
	
	public static final ResourceLocation TEXTURE0 = new ResourceLocation("kitsumedievalcraft:models/Crucible.png");
	public static final ResourceLocation TEXTURE1 = new ResourceLocation("kitsumedievalcraft:models/HotCrucible.png");
	public static final ResourceLocation TEXTURE2 = new ResourceLocation("kitsumedievalcraft:models/CoolCrucible.png");
	public static final ResourceLocation MODEL = new ResourceLocation("kitsumedievalcraft:models/CrucibleModel.obj");
	
	IModelCustom model = AdvancedModelLoader.loadModel(MODEL);

	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {
		TileCrucibleWootz tile = (TileCrucibleWootz) tileEnt;
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		if(tile.cooked==true){
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE2);
			tile.markForUpdate();
			tile.markDirty();
		}
		if(tile.hot==true){
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE1);
			tile.markForUpdate();
			tile.markDirty();
		}
		if(tile.hot==false && tile.cooked == false){
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE0);
			tile.markForUpdate();
			tile.markDirty();
		}
		renderBlock(tile, tileEnt.getWorldObj(), tileEnt.xCoord,tileEnt.yCoord, tileEnt.zCoord, ModBlocks.crucibleWootz);
		GL11.glPopMatrix();
		//tile.markForUpdate();
		//tile.markDirty();
	}

	public void renderBlock(TileCrucibleWootz tl, World world, int i, int j,int k, Block block) {
		GL11.glPushMatrix();
		GL11.glScalef(0.28F, 0.28F, 0.28F);
		GL11.glTranslatef(1.76F, 0.0F, 1.85F);
		GL11.glRotatef(28.5F, 0F, 1F, 0F);
		
		this.model.renderAll();
		GL11.glPopMatrix();
	}

}
