package nmd.primal.forgecraft.renders.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import nmd.primal.forgecraft.blocks.BloomeryBase;
import nmd.primal.forgecraft.tiles.TileBloomery;
import org.lwjgl.opengl.GL11;

/**
 * Created by mminaie on 1/22/17.
 */
public class TileBloomeryRender extends TileEntitySpecialRenderer<TileBloomery>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    @Override
    public void render(TileBloomery tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        if (state.getBlock() instanceof BloomeryBase) {

            GL11.glPushMatrix();
            GL11.glTranslated(x + 0.5D, y + 0.0626D, z + 0.5D);
            //GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float prevLGTX = OpenGlHelper.lastBrightnessX;
            float prevLGTY = OpenGlHelper.lastBrightnessY;
            int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

            ItemStack stack0 = tile.getSlotStack(0);
            ItemStack stack1 = tile.getSlotStack(1);

            if (!stack1.isEmpty()) {
                GL11.glPushMatrix();
                GL11.glTranslated(0, 0.50D, 0);
                //renderItem.renderItem(stack1, renderItem.getItemModelMesher().getItemModel(stack1));
                renderItem.renderItem(stack1, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }

            if (!stack0.isEmpty()) {

                boolean is_block = stack0.getItem() instanceof ItemBlock;
                float scale = is_block ? 0.1725F : 0.3F;
                double xTrans = is_block ? -1.6D : -0.45D;
                double yTrans = is_block ? -1.26D : -0.7D;
                int stackRotation = stack0.getCount();

                GL11.glPushMatrix();
                GL11.glScalef(scale, scale, scale);
                GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                renderItem.renderItem(stack0, renderItem.getItemModelMesher().getItemModel(stack0));
                GL11.glPopMatrix();

                for (int i = 0; i < Math.ceil(stackRotation / 8) + 1; i++) {
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotated(45.0F * i, 0.0F, 1.0F, 0.0F);
                    GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(xTrans, yTrans, 0.0D);
                    renderItem.renderItem(stack0, renderItem.getItemModelMesher().getItemModel(stack0));
                    GL11.glPopMatrix();
                }
            }



            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
            GL11.glPopMatrix();
        }
    }
}