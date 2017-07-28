package com.kitsu.medievalcraft.renderer.blocks;

import net.minecraft.block.Block;
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
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.tileents.TileEntitySmallBarrel;

import cpw.mods.fml.client.FMLClientHandler;

public class SmallBarrelRender extends TileEntitySpecialRenderer {

	private ResourceLocation loc;
	private ResourceLocation unt = new ResourceLocation("kitsumedievalcraft:models/UntitledBarrel.png");
	public static final ResourceLocation MODEL = new ResourceLocation("kitsumedievalcraft:models/NewBarrel.obj");
	private EntityItem entItem = null;

	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL);

	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {
		TileEntitySmallBarrel tile = (TileEntitySmallBarrel) tileEnt;
		loc = new ResourceLocation(tile.res);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		if(loc == null){
			loc = unt;
		}
		
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(loc);
		renderBlock(tile, tileEnt.getWorldObj(), tileEnt.xCoord, tileEnt.yCoord, tileEnt.zCoord, ModBlocks.smallBarrel);
		
		if(tile.scuddedloaded == true){
			//System.out.println(tile.scuddedloaded);
			entItem = new EntityItem(tile.getWorldObj(), x, y, z, new ItemStack(ModItems.scuddedLeather, 1));
			GL11.glPushMatrix();
			this.entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glScalef(0.8f, 0.8f, 0.8f);
			GL11.glRotatef(45, 1, 0, 0);
			RenderManager.instance.renderEntityWithPosYaw(entItem, 0.55D, 0.4D, 0.24D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			tile.markForUpdate();
			tile.markDirty();
			GL11.glPopMatrix();
			tile.markForUpdate();
			tile.markDirty();
		}
		
		if(tile.soakedloaded == true){
			//System.out.println(tile.soakedloaded);
			entItem = new EntityItem(tile.getWorldObj(), x, y, z, new ItemStack(ModItems.soakedLeather, 1));
			GL11.glPushMatrix();
			this.entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glScalef(0.8f, 0.8f, 0.8f);
			GL11.glRotatef(45, 1, 0, 0);
			RenderManager.instance.renderEntityWithPosYaw(entItem, 0.55D, 0.4D, 0.24D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			tile.markForUpdate();
			tile.markDirty();
			GL11.glPopMatrix();
			tile.markForUpdate();
			tile.markDirty();
		}
		
		GL11.glPopMatrix();
	}

	@SuppressWarnings({ "cast"})
	public void renderBlock(TileEntitySmallBarrel tl, World world, int x, int y,int z, Block block) {

		GL11.glPushMatrix();

		float scale = 0.28F;
		GL11.glScalef(scale, scale, scale);
		GL11.glTranslatef(1.6F,0.05F,1.6F);
		GL11.glRotatef(31F, 0.0F, 1.0F, 0.0F);

		this.model.renderAll();

		GL11.glPopMatrix();
	}

}