package nmd.primal.forgecraft.renders.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import nmd.primal.forgecraft.blocks.CastingBlock;
import nmd.primal.forgecraft.blocks.CustomContainerFacing;
import nmd.primal.forgecraft.items.casting.CastingPart;
import nmd.primal.forgecraft.tiles.TileCastingBlock;
import org.lwjgl.opengl.GL11;

/**
 * Created by mminaie on 6/21/17.
 */
public class TileCastingBlockRender extends TileEntitySpecialRenderer <TileCastingBlock>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    @Override
    public void render(TileCastingBlock tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        if (state.getBlock() instanceof CastingBlock) {

            GL11.glPushMatrix();
            GL11.glTranslated(x + 0.5, y + 0.25D, z + 0.5);
            //GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float prevLGTX = OpenGlHelper.lastBrightnessX;
            float prevLGTY = OpenGlHelper.lastBrightnessY;
            GL11.glScaled(0.99D, 0.99D, 0.99D);
            int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

            if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.NORTH) {
                if (!tile.getSlotStack(0).isEmpty()) {
                    Item item = tile.getSlotStack(0).getItem();

                    if (item instanceof CastingPart) {
                        GL11.glPushMatrix();
                        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);

                        renderItem.renderItem(tile.getSlotStack(0), ItemCameraTransforms.TransformType.FIXED);
                        GL11.glPopMatrix();
                    }
                }
            }
            if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.SOUTH) {
                if (!tile.getSlotStack(0).isEmpty()) {
                    Item item = tile.getSlotStack(0).getItem();
                    if (item instanceof CastingPart) {
                        GL11.glPushMatrix();
                        GL11.glRotated(90.0D, 0.0D, 0.0D, 0.0D);

                        renderItem.renderItem(tile.getSlotStack(0), ItemCameraTransforms.TransformType.FIXED);
                        GL11.glPopMatrix();
                    }
                }
            }

            if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.WEST) {
                if (!tile.getSlotStack(0).isEmpty()) {
                    Item item = tile.getSlotStack(0).getItem();
                    if (item instanceof CastingPart) {
                        GL11.glPushMatrix();
                        GL11.glRotated(90.0D, 1.0D, 0.0D, 0.0D);
                        GL11.glRotated(90.0D, 0.0D, 0.0D, 1.0D);
                        //GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
                        renderItem.renderItem(tile.getSlotStack(0), ItemCameraTransforms.TransformType.FIXED);
                        GL11.glPopMatrix();
                    }
                }
            }
            if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.EAST) {
                if (!tile.getSlotStack(0).isEmpty()) {
                    Item item = tile.getSlotStack(0).getItem();
                    if (item instanceof CastingPart) {
                        GL11.glPushMatrix();
                        GL11.glRotated(90.0D, 1.0D, 0.0D, 0.0D);
                        GL11.glRotated(-90.0D, 0.0D, 0.0D, 1.0D);

                        renderItem.renderItem(tile.getSlotStack(0), ItemCameraTransforms.TransformType.FIXED);
                        GL11.glPopMatrix();
                    }
                }
            }



            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
            GL11.glPopMatrix();
        }
    }
}
