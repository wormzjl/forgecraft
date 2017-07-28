package nmd.primal.forgecraft.renders;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
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
import net.minecraft.world.World;
import nmd.primal.forgecraft.blocks.Firebox;
import nmd.primal.forgecraft.tiles.TileFirebox;
import org.lwjgl.opengl.GL11;

/**
 * Created by kitsu on 12/4/2016.
 */
public class TileFireboxRender extends TileEntitySpecialRenderer<TileFirebox>
{
    private final RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    private int rotation;
    private float translateX, translateZ;
    private double textX, textZ;
    private EntityItem entItem = null;

    @Override
    public void renderTileEntityAt(TileFirebox tile, double x, double y, double z, float partialTicks, int destroyStage) {

        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 0.875D, z + 0.5D);
        GL11.glScalef(0.25F, 0.25F, 0.25F);

        World world = tile.getWorld();
        IBlockState state = world.getBlockState(tile.getPos());

        switch(state.getValue(BlockHorizontal.FACING))
        {
            case NORTH:
                rotation = 0;
                //Left and Right
                translateX = 1.5f;
                //Back and Forth
                translateZ = 1.05f;
                break;
            case EAST:
                rotation = 3;
                translateZ = 1.0f;
                translateX = 1.4f;
                break;
            case SOUTH:
                rotation = 2;
                //Left and Right
                translateX = 1.5f;
                //Back and Forth
                translateZ = 0.9f;
                break;
            case WEST:
                rotation = 1;
                //Back and Forth
                translateX = 1.5f;
                //Left and Right
                translateZ = 1.0f;
                break;
        }

        GL11.glTranslatef(-1.5F, -0.0F, -1.0F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        float prevLGTX = OpenGlHelper.lastBrightnessX;
        float prevLGTY = OpenGlHelper.lastBrightnessY;
        BlockPos pos = tile.getPos();
        int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

        ItemStack stack = tile.getStackInSlot(0);
        if (stack != null) {
            boolean is_block = stack.getItem() instanceof ItemBlock;
            float height = -0.75f;

            float scale = is_block ? 0.9F : 1.6F;
            int stackSize = stack.stackSize;

            GL11.glPushMatrix();
            GL11.glTranslatef(translateX, height, translateZ);
            GL11.glScalef(scale, scale, scale);
            GL11.glRotatef(90.0F * rotation, 0.0F, 1.0F, 0.0F);
            Integer temp = tile.getStackInSlot(0).stackSize;

            renderItem.renderItem(stack, renderItem.getItemModelMesher().getItemModel(stack));
            GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
            //float scale = is_block ? 0.9F : 1.6F;
            if(is_block){
                GL11.glScalef(0.08F,0.08F, 0.08f);
                textZ = -23.0D;
            } else {
                GL11.glScalef(0.05F,0.05F, 0.05f);
                textZ = -22.0D;
            }
            GL11.glTranslatef(0.0F, 2.0f, 0.0F);
            GL11.glTranslated(0.0F, 0.0D, textZ);
            getFontRenderer().drawString(temp.toString(), 0, 0, 4210752);
            GL11.glPopMatrix();
        }
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);

        GL11.glPopMatrix();

    }

}
