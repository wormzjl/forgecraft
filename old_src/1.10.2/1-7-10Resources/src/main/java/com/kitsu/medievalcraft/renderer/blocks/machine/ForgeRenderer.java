package com.kitsu.medievalcraft.renderer.blocks.machine;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.machine.TileEntityFirebox;
import com.kitsu.medievalcraft.tileents.machine.TileForge;

import cpw.mods.fml.client.FMLClientHandler;

public class ForgeRenderer extends TileEntitySpecialRenderer {

	EntityItem entItem = null;
	EntityItem entItem1 = null;
	public static final ResourceLocation MODEL = new ResourceLocation("kitsumedievalcraft:models/SingleForge.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/SingleForge.png");
	public static final ResourceLocation TEXTURE1 = new ResourceLocation("kitsumedievalcraft:models/SingleForgeBurning.png");
	public static final ResourceLocation TEXTURE2 = new ResourceLocation("kitsumedievalcraft:models/SingleForgeOn.png");
	private ResourceLocation loc;

	IModelCustom model = AdvancedModelLoader.loadModel(MODEL);

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float scale) {
		TileForge tileEntity = (TileForge)tile;
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);

		if(tileEntity.getStackInSlot(1) != null){
			entItem1 = new EntityItem(tileEntity.getWorldObj(), x, y, z, tileEntity.getStackInSlot(1));
			GL11.glPushMatrix();
			this.entItem1.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glScalef(0.5f, 0.1f, 0.5f);
			GL11.glRotatef(90, 1, 0, 0);
			RenderManager.instance.renderEntityWithPosYaw(entItem1, 1.0D, 0.8D, -10.0D, 0.0F, 0.0F);
			
			RenderManager.instance.renderEntityWithPosYaw(entItem1, 1.25D, 1.0D, -10.0D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entItem1, 1.25D, 0.5D, -10.0D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entItem1, 0.7D, 0.6D, -10.0D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entItem1, 0.7D, 1.0D, -10.0D, 0.0F, 0.0F);
			
			RenderManager.instance.renderEntityWithPosYaw(entItem1, 1.5D, 0.75D, -10.0D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entItem1, 1.0D, 1.2D, -10.0D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entItem1, 0.98D, 0.35D, -10.0D, 0.0F, 0.0F);
			//RenderManager.instance.renderEntityWithPosYaw(entItem1, 0.5D, 0.7D, -10.0D, 0.0F, 0.0F);
			
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();
			tileEntity.markForUpdate();
			tileEntity.markDirty();
		}
		
		if(tileEntity.getStackInSlot(0) != null){
			entItem = new EntityItem(tileEntity.getWorldObj(), x, y, z, tileEntity.getStackInSlot(0));
			GL11.glPushMatrix();
			this.entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			
			GL11.glScalef(1.0f, 1.0f, 1.0f);
			//GL11.glRotatef(10, 0, 1, 0);
			RenderManager.instance.renderEntityWithPosYaw(entItem, 0.55D, 0.25D, 0.5D, 0.0F, 0.0F);
			
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();
			tileEntity.markForUpdate();
			tileEntity.markDirty();
		}
		if(tile.getBlockMetadata()<4){
			loc = TEXTURE;
		}
		if(tile.getBlockMetadata()>3&&tile.getBlockMetadata()<8){
			loc = TEXTURE1;
		}
		if(tile.getBlockMetadata()>7){
			loc = TEXTURE2;
		}

		if(loc == null){
			loc = TEXTURE;
		}

		FMLClientHandler.instance().getClient().renderEngine.bindTexture(loc);
		renderBlock(tileEntity, tile.getWorldObj(), tile.xCoord,tile.yCoord, tile.zCoord, ModBlocks.forge);
		GL11.glPopMatrix();

	}

	public void renderBlock(TileForge tl, World world, int i, int j,int k, Block block) {
		GL11.glPushMatrix();
		float scale = 0.50f;
		GL11.glScalef(scale, scale, scale);
		GL11.glTranslatef(1.0F, 1.0F, 1.0F);
		int dir = world.getBlockMetadata(i, j, k);
		
		if(dir == 2||dir == 6||dir == 10){
			GL11.glRotated(-180F, 0.0, 1.0F, 0.0F);
		}
		if(dir == 3||dir == 7||dir == 11){
		}
		if(dir == 0||dir == 4||dir == 8){
			GL11.glRotated(90F, 0.0, 1.0F, 0.0F);
		}
		if(dir == 1||dir == 5||dir == 9){
			GL11.glRotated(-90F, 0.0, 1.0F, 0.0F);
		}
		

		this.model.renderAll();
		GL11.glPopMatrix();
	}

}