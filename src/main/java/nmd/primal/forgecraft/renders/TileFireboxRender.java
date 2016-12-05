package nmd.primal.forgecraft.renders;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import nmd.primal.forgecraft.blocks.Firebox;
import nmd.primal.forgecraft.tiles.TileFirebox;
import org.lwjgl.opengl.GL11;

/**
 * Created by kitsu on 12/4/2016.
 */
public class TileFireboxRender extends TileEntitySpecialRenderer<TileFirebox>
{
    private final RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();


    @Override
    public void renderTileEntityAt(TileFirebox tile, double x, double y, double z, float partialTicks, int destroyStage) {

        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 0.875D, z + 0.5D);
        GL11.glScalef(0.25F, 0.25F, 0.25F);
        //GL11.glRotatef(90.0F * (-tile.rotation + 3), 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-1.5F, -0.0F, -1.0F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        float prevLGTX = OpenGlHelper.lastBrightnessX;
        float prevLGTY = OpenGlHelper.lastBrightnessY;
        BlockPos pos = tile.getPos();
        int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
        //int bright = (this.getLight(tile.getWorld(), pos) / 2);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

        ///
        //  offset height of rendering for worktable slabs
        //  Think about ways to avoid instanceof
        ///
        //IBlockState state = this.getWorld().getBlockState(pos);
        //Block block = state.getBlock();

                ItemStack stack = tile.getStackInSlot(0);
                if (stack != null) {
                    ///
                    //  rotate 90 degrees for blocks but not items?
                    ///
                    boolean is_block = stack.getItem() instanceof ItemBlock;
                    float rotation = is_block ? 180.0F : 90.0F;
                    float height = is_block ? 0.52F : 0.42F;
                    //float scale = is_block ? 0.8F : 1.2F;
                    float scale = is_block ? 0.8F : 1.5F;

                    //RenderHelper.glItem(renderItem, stack, shelf_column, 0.0F, row_height, rotation);

                    GL11.glPushMatrix();
                    //GL11.glTranslated(rack_column * 0.75F, 0.0D, craft_row * 0.75F);
                    //GL11.glTranslated(rack_column * 1.5F, 0.0D, rack_row);
                    GL11.glTranslated(1.4F, 0.0D, 1.5D);

                    //GL11.glTranslatef(0.75F, 0.52F, 0.25F);
                    GL11.glTranslatef(0.75F, height, 0.25F);
                    GL11.glScalef(scale, scale, scale);
                    //
                    // item/block rotation
                    //GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(rotation, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                    renderItem.renderItem(stack, renderItem.getItemModelMesher().getItemModel(stack));

                    GL11.glPopMatrix();

        }
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);

        GL11.glPopMatrix();

    }

}
