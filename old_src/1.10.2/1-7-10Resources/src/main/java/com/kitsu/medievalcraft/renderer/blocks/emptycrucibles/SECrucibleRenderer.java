package com.kitsu.medievalcraft.renderer.blocks.emptycrucibles;

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
import com.kitsu.medievalcraft.tileents.crucible.empty.TileEntitySoftEmptyCrucible;

import cpw.mods.fml.client.FMLClientHandler;

public class SECrucibleRenderer extends TileEntitySpecialRenderer {


	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/EmptyUncookedCrucible.png");
	public static final ResourceLocation TEXTUREa = new ResourceLocation("kitsumedievalcraft:models/emptycookedcrucible.png");
	private static final ResourceLocation MODEL_CRUCIBLE = new ResourceLocation("kitsumedievalcraft:models/EmptyCrucible.obj");

	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL_CRUCIBLE);

	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {

		GL11.glPushMatrix();
		// This will move our renderer so that it will be on proper place in the
		// world
		GL11.glTranslatef((float) x, (float) y, (float) z);
		TileEntitySoftEmptyCrucible tileEntityBlock = (TileEntitySoftEmptyCrucible) tileEnt;
		/*
		 * Note that true tile entity coordinates (tileEntity.xCoord, etc) do
		 * not match to render coordinates (d, etc) that are calculated as [true
		 * coordinates] - [player coordinates (camera coordinates)]
		 */
		renderBlock(tileEntityBlock, tileEnt.getWorldObj(), tileEnt.xCoord,tileEnt.yCoord, tileEnt.zCoord, ModBlocks.emptySoftCrucible);
		GL11.glPopMatrix();
	}
	@SuppressWarnings({ "cast",})
	public void renderBlock(TileEntitySoftEmptyCrucible tl, World world, int i, int j,int k, Block block) {
		Tessellator tessellator = Tessellator.instance;
		// This will make your block brightness dependent from surroundings
		// lighting.
		float f = block.getLightOpacity(world, i, j, k);
		int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		int l1 = l % 65536;
		int l2 = l / 65536;
		tessellator.setColorOpaque_F(f, f, f);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,(float) l1, (float) l2);

		/*
		 * This will rotate your model corresponding to player direction that
		 * was when you placed the block. If you want this to work, add these
		 * lines to onBlockPlacedBy method in your block class. int dir =
		 * MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) +
		 * 0.5D) & 3; world.setBlockMetadataWithNotify(x, y, z, dir, 0);
		 */

		int dir = world.getBlockMetadata(i, j, k);

		GL11.glPushMatrix();
		//GL11.glTranslatef(0.5F, 0, 0.5F);
		// This line actually rotates the renderer.
		//

		//bindTextureByName("yourTexturePath");
		GL11.glScalef(0.28F, 0.28F, 0.28F);

		GL11.glTranslatef(1.76F, 0.0F, 1.85F);

		GL11.glRotatef(28.5F, 0F, 1F, 0F);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);
		/*
		 * Place your rendering code here.
		 */
		this.model.renderAll();
		GL11.glPopMatrix();
	}

}
