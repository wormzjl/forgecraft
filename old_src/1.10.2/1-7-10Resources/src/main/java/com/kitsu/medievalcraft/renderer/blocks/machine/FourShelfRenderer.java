package com.kitsu.medievalcraft.renderer.blocks.machine;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.machine.TileEntityShelfFour;

import cpw.mods.fml.client.FMLClientHandler;

public class FourShelfRenderer extends TileEntitySpecialRenderer {

	private EntityItem entItem = null;
	private EntityItem entItem1 = null;
	private EntityItem entItem2 = null;
	private EntityItem entItem3 = null;
	private static final ResourceLocation MODEL = new ResourceLocation("kitsumedievalcraft:models/Shelf.obj");
	private static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/ShelfMini32.png");
	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL);
		
	// THE FKNG RENDERER NEEDS TO KNOW WHAT THE FK TO RENDER; SEND IT A FKNG ITEMSTACK
	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {
		TileEntityShelfFour tileEntityBlock = (TileEntityShelfFour) tileEnt;
		//World world = tileEnt.getWorldObj();
		//System.out.println(tileEntityBlock.getStackInSlot(0));
		int dir = tileEnt.blockMetadata;
		GL11.glPushMatrix();

		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotated(90F, 0.0, 1.0F, 0.0F);

		renderBlock(tileEntityBlock, tileEnt.getWorldObj(), tileEnt.xCoord,tileEnt.yCoord, tileEnt.zCoord, ModBlocks.shelfFour);
		
		if(tileEntityBlock.getStackInSlot(0) != null){
			entItem = new EntityItem(tileEntityBlock.getWorldObj(), x, y, z, tileEntityBlock.getStackInSlot(0));
			if(dir == 0){
				GL11.glPushMatrix();
				this.entItem.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glRotatef(90, 0, 1, 0);
				RenderManager.instance.renderEntityWithPosYaw(entItem, -1.175D, 0.95D, -0.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			if(dir == 1){
				GL11.glPushMatrix();
				this.entItem.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				RenderManager.instance.renderEntityWithPosYaw(entItem, -1.175D, 0.95D, 1.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			if(dir == 2){
				GL11.glPushMatrix();
				this.entItem.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glRotatef(-90, 0, 1, 0);
				RenderManager.instance.renderEntityWithPosYaw(entItem, 0.5D, 0.95D, 1.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			if(dir == 3){
				GL11.glPushMatrix();
				this.entItem.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glRotatef(180, 0, 1, 0);
				RenderManager.instance.renderEntityWithPosYaw(entItem, 0.5D, 0.95D, -0.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			tileEntityBlock.markForUpdate();
			tileEntityBlock.markDirty();
		}
		if(tileEntityBlock.getStackInSlot(1) != null){
			entItem1 = new EntityItem(tileEntityBlock.getWorldObj(), x, y, z, tileEntityBlock.getStackInSlot(1));
			if(dir == 0){
				GL11.glPushMatrix();
				this.entItem1.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glRotatef(90, 0, 1, 0);;
				RenderManager.instance.renderEntityWithPosYaw(entItem1, -0.4D, 0.95D, -0.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			if(dir == 1){
				GL11.glPushMatrix();
				this.entItem1.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				RenderManager.instance.renderEntityWithPosYaw(entItem1, -0.4D, 0.95D, 1.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			if(dir == 2){
				GL11.glPushMatrix();
				this.entItem1.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glRotatef(-90, 0, 1, 0);
				RenderManager.instance.renderEntityWithPosYaw(entItem1, 1.25D, 0.95D, 1.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			if(dir == 3){
				GL11.glPushMatrix();
				this.entItem1.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glRotatef(180, 0, 1, 0);
				RenderManager.instance.renderEntityWithPosYaw(entItem1, 1.25D, 0.95D, -0.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			tileEntityBlock.markForUpdate();
			tileEntityBlock.markDirty();
		}
		if(tileEntityBlock.getStackInSlot(2) != null){
			entItem2 = new EntityItem(tileEntityBlock.getWorldObj(), x, y, z, tileEntityBlock.getStackInSlot(2));
			if(dir == 0){
				GL11.glPushMatrix();
				this.entItem2.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glRotatef(90, 0, 1, 0);;
				RenderManager.instance.renderEntityWithPosYaw(entItem2, -1.175D, 0.25D, -0.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			if(dir == 1){
				GL11.glPushMatrix();
				this.entItem2.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				RenderManager.instance.renderEntityWithPosYaw(entItem2, -1.175D, 0.25D, 1.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			if(dir == 2){
				GL11.glPushMatrix();
				this.entItem2.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glRotatef(-90, 0, 1, 0);
				RenderManager.instance.renderEntityWithPosYaw(entItem2, 0.5D, 0.25D, 1.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			if(dir == 3){
				GL11.glPushMatrix();
				this.entItem2.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glRotatef(180, 0, 1, 0);
				RenderManager.instance.renderEntityWithPosYaw(entItem2, 0.5D, 0.25D, -0.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			tileEntityBlock.markForUpdate();
			tileEntityBlock.markDirty();
		}
		if(tileEntityBlock.getStackInSlot(3) != null){
			entItem3 = new EntityItem(tileEntityBlock.getWorldObj(), x, y, z, tileEntityBlock.getStackInSlot(3));
			if(dir == 0){
				GL11.glPushMatrix();
				this.entItem3.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glRotatef(90, 0, 1, 0);;
				RenderManager.instance.renderEntityWithPosYaw(entItem3, -0.4D, 0.25D, -0.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			if(dir == 1){
				GL11.glPushMatrix();
				this.entItem3.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				RenderManager.instance.renderEntityWithPosYaw(entItem3, -0.4D, 0.25D, 1.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			if(dir == 2){
				GL11.glPushMatrix();
				this.entItem3.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glRotatef(-90, 0, 1, 0);
				RenderManager.instance.renderEntityWithPosYaw(entItem3, 1.25D, 0.25D, 1.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			if(dir == 3){
				GL11.glPushMatrix();
				this.entItem3.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				GL11.glScalef(0.6f, 0.6f, 0.6f);
				GL11.glRotatef(180, 0, 1, 0);
				RenderManager.instance.renderEntityWithPosYaw(entItem3, 1.25D, 0.25D, -0.35D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();
			}
			tileEntityBlock.markForUpdate();
			tileEntityBlock.markDirty();
		}
		GL11.glPopMatrix();
	}

public void renderBlock(TileEntityShelfFour tl, World world, int i, int j,int k, Block block) {
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

	float scale = 0.5F;
	GL11.glScalef(scale, scale, scale);
	GL11.glTranslatef(0F, 1F, 1F);
	int dir = world.getBlockMetadata(i, j, k);
	if(dir == 1){
		GL11.glTranslatef(-1F, 0F, 1F);
		GL11.glRotated(-90F, 0.0, 1.0F, 0.0F);
	}
	if(dir == 2){
		GL11.glTranslatef(-2F, 0F, 0F);
		GL11.glRotated(-180F, 0.0, 1.0F, 0.0F);
	}
	if(dir == 3){
		GL11.glTranslatef(-1F, 0F, -1F);
		GL11.glRotated(90F, 0.0, 1.0F, 0.0F);
	}
	//GL11.glRotatef(15F, 0F, 1F, 0F);
	FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);

	this.model.renderAll();
	GL11.glPopMatrix();
}

}
