package com.kitsu.medievalcraft.renderer.blocks.cannons;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.entity.EntityCannonBall;
import com.kitsu.medievalcraft.tileents.cannon.TileCannonBall28;
import com.kitsu.medievalcraft.tileents.cannon.TileCannon_28;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class Render_CannonBall_Iron_Block extends TileEntitySpecialRenderer {

	EntityItem entItem = null;

	private static final ResourceLocation MODEL_CRUCIBLE = new ResourceLocation("kitsumedievalcraft:models/cannon_ball.obj");
	private static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/CannonBall.png");
	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL_CRUCIBLE);

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float scale) {
		TileCannonBall28 tileEntity = (TileCannonBall28)tile;
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		
		renderBlock(tileEntity, tile.getWorldObj(), tile.xCoord,tile.yCoord, tile.zCoord, ModBlocks.cannonBall_28);

		GL11.glPopMatrix();
	}


	public void renderBlock(TileCannonBall28 tl, World world, int i, int j,int k, Block block) {
		Tessellator tessellator = Tessellator.instance;
		// This will make your block brightness dependent from surroundings
		// lighting.
		/*float f = block.getLightOpacity(world, i, j, k);
		int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		int l1 = l % 65536;
		int l2 = l / 65536;
		tessellator.setNormal(0.0F, 1.0F, 0.0F);*/
		//OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,(float) l1, (float) l2);

		/*
		 * This will rotate your model corresponding to player direction that
		 * was when you placed the block. If you want this to work, add these
		 * lines to onBlockPlacedBy method in your block class. int dir =
		 * MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) +
		 * 0.5D) & 3; world.setBlockMetadataWithNotify(x, y, z, dir, 0);
		 */

		int dir = world.getBlockMetadata(i, j, k);

		GL11.glPushMatrix();
		//GL11.glRotatef(15F, 0F, 1F, 0F);
		float scale = 0.25f;
		GL11.glScalef(scale, scale, scale);
		
		/*if(dir == 0){
			GL11.glTranslatef(0.48F, 0.5F, 0.7F);
			GL11.glRotated(180F, 0.0, 1.0F, 0.0F);
		}
		if(dir == 1){
			GL11.glTranslatef(0.3F, 0.5F, 0.48F);
			GL11.glRotated(90F, 0.0, 1.0F, 0.0F);
		}
		if(dir == 2){
			GL11.glTranslatef(0.48F, 0.5F, 0.3F);
			GL11.glRotated(0F, 0.0, 1.0F, 0.0F);
		}*/

		GL11.glTranslatef(2.0F, 0.5F, 2.0F);
		//GL11.glRotated(-90F, 0.0, 1.0F, 0.0F);
		
		//
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);
		/*
		 * Place your rendering code here.
		 */
		this.model.renderAll();
		GL11.glPopMatrix();
	}

}