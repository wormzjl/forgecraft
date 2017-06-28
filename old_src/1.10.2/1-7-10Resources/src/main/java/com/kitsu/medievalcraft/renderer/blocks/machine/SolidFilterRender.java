package com.kitsu.medievalcraft.renderer.blocks.machine;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.tileents.machine.TileEntitySolidFilter;

import cpw.mods.fml.client.FMLClientHandler;

public class SolidFilterRender extends TileEntitySpecialRenderer {

	private ResourceLocation loc;
	private static final ResourceLocation MODEL_CRUCIBLE = new ResourceLocation("kitsumedievalcraft:models/SandFilter.obj");
	private static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/SandFilter.png");
	private static final ResourceLocation TEXTUREEMPTY = new ResourceLocation("kitsumedievalcraft:models/SandFilterEmpty.png");
	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL_CRUCIBLE);

	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {
		
		GL11.glPushMatrix();

		GL11.glTranslatef((float) x, (float) y, (float) z);
		TileEntitySolidFilter tileEntityBlock = (TileEntitySolidFilter) tileEnt;
		if(tileEntityBlock.getStackInSlot(0)!=null){
			if((tileEntityBlock.getStackInSlot(0).getItem()==ModItems.coarseFilter)||(tileEntityBlock.getStackInSlot(0).getItem()==ModItems.mediumFilter)||(tileEntityBlock.getStackInSlot(0).getItem()==ModItems.fineFilter)){
				loc = TEXTURE;
			}
		}
		if(tileEntityBlock.getStackInSlot(0)==null){
			loc = TEXTUREEMPTY;
		}
		
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(loc);
		renderBlock(tileEntityBlock, tileEnt.getWorldObj(), tileEnt.xCoord,tileEnt.yCoord, tileEnt.zCoord, ModBlocks.solidFilter);
		GL11.glPopMatrix();
	}
	
	@SuppressWarnings({ "cast"})
	public void renderBlock(TileEntitySolidFilter tl, World world, int i, int j,int k, Block block) {
		Tessellator tessellator = Tessellator.instance;
		// This will make your block brightness dependent from surroundings
		// lighting.
		float f = block.getLightOpacity(world, i, j, k);
		int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		int l1 = l % 65536;
		int l2 = l / 65536;
		tessellator.setColorOpaque_F(f, f, f);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,(float) l1, (float) l2);

		GL11.glPushMatrix();
		//GL11.glRotatef(15F, 0F, 1F, 0F);
		float scale = 0.8F;
		GL11.glScalef(scale, scale-0.05F, scale);
		GL11.glTranslatef(0.62F,0.58F,0.62F);

		this.model.renderAll();
		GL11.glPopMatrix();
	}

}


