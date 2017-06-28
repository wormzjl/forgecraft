package com.kitsu.medievalcraft.renderer.blocks.machine;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.machine.TileEntityAnvilForge;

import cpw.mods.fml.client.FMLClientHandler;

public class ForgeAnvilRenderer extends TileEntitySpecialRenderer {

	EntityItem entItem = null;

	private static final ResourceLocation MODEL_CRUCIBLE = new ResourceLocation("kitsumedievalcraft:models/ForgeAnvil.obj");
	private static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/ForgeAnvil.png");
	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL_CRUCIBLE);

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float scale) {
		TileEntityAnvilForge tileEntity = (TileEntityAnvilForge)tile;
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		
		if(tileEntity.getStackInSlot(0)==null){
			entItem=null;
		}
		
		if(tileEntity.getStackInSlot(0)!=null){
			entItem = new EntityItem(tileEntity.getWorldObj(), x, y, z, tileEntity.getStackInSlot(0));
			GL11.glPushMatrix();
			this.entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glRotatef(90, 1, 0, 0);
			RenderManager.instance.renderEntityWithPosYaw(this.entItem, 0.48D, 0.25D, -1.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();
			tileEntity.markForUpdate();
			tileEntity.markDirty();
		}
		
		renderBlock(tileEntity, tile.getWorldObj(), tile.xCoord,tile.yCoord, tile.zCoord, ModBlocks.forgeAnvil);
		tileEntity.markForUpdate();
		tileEntity.markDirty();
		GL11.glPopMatrix();
	}


	public void renderBlock(TileEntityAnvilForge tl, World world, int i, int j,int k, Block block) {
		Tessellator tessellator = Tessellator.instance;
		// This will make your block brightness dependent from surroundings
		// lighting.
		float f = block.getLightOpacity(world, i, j, k);
		int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		int l1 = l % 65536;
		int l2 = l / 65536;
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
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
		float scale = 0.58f;
		GL11.glScalef(scale, 0.63F, scale);
		GL11.glTranslatef(0.83F, 0.05F, 0.82F);
		if(dir == 1){
			GL11.glRotated(-90F, 0.0, 1.0F, 0.0F);
		}
		if(dir == 2){
			GL11.glRotated(-180F, 0.0, 1.0F, 0.0F);
		}
		if(dir == 3){
			GL11.glRotated(90F, 0.0, 1.0F, 0.0F);
		}
		//
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);
		/*
		 * Place your rendering code here.
		 */
		this.model.renderAll();
		GL11.glPopMatrix();
	}

}