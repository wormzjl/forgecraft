package nmd.primal.forgecraft.renders.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import nmd.primal.forgecraft.blocks.Breaker;
import nmd.primal.forgecraft.tiles.TileBreaker;
import org.lwjgl.opengl.GL11;

/**
 * Created by mminaie on 4/9/17.
 */
public class TileBreakerRender extends TileEntitySpecialRenderer<TileBreaker>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    @Override
    public void renderTileEntityAt(TileBreaker tile, double x, double y, double z, float partialTicks, int destroyStage) {

        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        if (state.getBlock() instanceof Breaker) {

            GL11.glPushMatrix();
            GL11.glTranslated(x, y, z);
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float prevLGTX = OpenGlHelper.lastBrightnessX;
            float prevLGTY = OpenGlHelper.lastBrightnessY;
            int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

            //ItemStack stack0 = tile.getSlotStack(0);

            if (state.getValue(Breaker.FACING) == EnumFacing.NORTH) {
                GL11.glPushMatrix();
                GL11.glTranslated(0.5D, 0.450D, 0.7);
                GL11.glRotated(90, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-135, 0.0f, 0.0f, 1.0f);

                GL11.glRotatef(tile.getCharge(), 0.0f, 0.0f, 1.0f);

                GL11.glTranslatef(0.0f, 0.40f, 0.0f);
                GL11.glTranslated(-0.45D, 0.0D, 0.0D);

                renderItem.renderItem(tile.getSlotStack(0), ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }

            if (state.getValue(Breaker.FACING) == EnumFacing.EAST) {
                GL11.glPushMatrix();
                GL11.glTranslated(0.3D, 0.450D, 0.5);
                //GL11.glRotated(90, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-135, 0.0f, 0.0f, 1.0f);

                GL11.glRotatef(tile.getCharge(), 0.0f, 0.0f, 1.0f);

                GL11.glTranslatef(0.0f, 0.40f, 0.0f);
                GL11.glTranslated(-0.45D, 0.0D, 0.0D);

                renderItem.renderItem(tile.getSlotStack(0), ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }

            if (state.getValue(Breaker.FACING) == EnumFacing.SOUTH) {
                GL11.glPushMatrix();
                GL11.glTranslated(0.5D, 0.450D, 0.3);
                GL11.glRotated(90, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(45, 0.0f, 0.0f, 1.0f);

                GL11.glRotatef(tile.getCharge(), 0.0f, 0.0f, -1.0f);

                GL11.glTranslatef(0.0f, 0.40f, 0.0f);
                GL11.glTranslated(-0.45D, 0.0D, 0.0D);

                renderItem.renderItem(tile.getSlotStack(0), ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }

            if (state.getValue(Breaker.FACING) == EnumFacing.WEST) {
                GL11.glPushMatrix();
                GL11.glTranslated(0.7D, 0.450D, 0.5);
                //GL11.glRotated(90, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(45, 0.0f, 0.0f, 1.0f);

                GL11.glRotatef(tile.getCharge(), 0.0f, 0.0f, -1.0f);

                GL11.glTranslatef(0.0f, 0.40f, 0.0f);
                GL11.glTranslated(-0.45D, 0.0D, 0.0D);

                renderItem.renderItem(tile.getSlotStack(0), ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }

            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
            GL11.glPopMatrix();
        }
    }
}