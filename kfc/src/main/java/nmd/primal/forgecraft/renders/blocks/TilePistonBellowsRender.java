package nmd.primal.forgecraft.renders.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import nmd.primal.core.api.PrimalStates;
import nmd.primal.forgecraft.blocks.PistonBellows;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.tiles.TilePistonBellows;
import org.lwjgl.opengl.GL11;

/**
 * Created by mminaie on 1/7/17.
 */
public class TilePistonBellowsRender extends TileEntitySpecialRenderer<TilePistonBellows> {

    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    @Override
    public void renderTileEntityAt(TilePistonBellows tile, double x, double y, double z, float partialTicks, int destroyStage)
    {

        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        if (state.getBlock() instanceof PistonBellows) {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 0.5D, z + 0.5D);

        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        float prevLGTX = OpenGlHelper.lastBrightnessX;
        float prevLGTY = OpenGlHelper.lastBrightnessY;

        int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);



            GL11.glPushMatrix();
            if (state.getValue(PistonBellows.FACING) == EnumFacing.NORTH) {

                GL11.glRotated(0, 0.0F, 1.0F, 0.0F);
                if (state.getValue(PrimalStates.ACTIVE) == Boolean.TRUE) {
                    //System.out.println(tile.getAnimation());
                    GL11.glTranslated(0.0D, 0, (double) tile.getAnimation() / 25);
                }
                ItemStack stackToRender = new ItemStack(ModItems.bellowshandle, 1);
                renderItem.renderItem(stackToRender, renderItem.getItemModelMesher().getItemModel(stackToRender));
            }
            if (state.getValue(PistonBellows.FACING) == EnumFacing.SOUTH) {
                //GL11.glPushMatrix();
                GL11.glRotated(180, 0.0F, 1.0F, 0.0F);
                if (state.getValue(PrimalStates.ACTIVE) == Boolean.TRUE) {
                    //System.out.println(tile.getAnimation());
                    GL11.glTranslated(0.0D, 0, (double) tile.getAnimation() / 25);
                }
                ItemStack stackToRender = new ItemStack(ModItems.bellowshandle, 1);
                renderItem.renderItem(stackToRender, renderItem.getItemModelMesher().getItemModel(stackToRender));
                //GL11.glPopMatrix();
            }
            if (state.getValue(PistonBellows.FACING) == EnumFacing.EAST) {
                //GL11.glPushMatrix();
                GL11.glRotated(270, 0.0F, 1.0F, 0.0F);
                if (state.getValue(PrimalStates.ACTIVE) == Boolean.TRUE) {
                    //System.out.println(tile.getAnimation());
                    GL11.glTranslated(0.0D, 0, (double) tile.getAnimation() / 25);
                }
                ItemStack stackToRender = new ItemStack(ModItems.bellowshandle, 1);
                renderItem.renderItem(stackToRender, renderItem.getItemModelMesher().getItemModel(stackToRender));
                //GL11.glPopMatrix();
            }
            if (state.getValue(PistonBellows.FACING) == EnumFacing.WEST) {
                //GL11.glPushMatrix();
                GL11.glRotated(90, 0.0F, 1.0F, 0.0F);
                if (state.getValue(PrimalStates.ACTIVE) == Boolean.TRUE) {
                    //System.out.println(tile.getAnimation());
                    GL11.glTranslated(0.0D, 0, (double) tile.getAnimation() / 25);
                }
                ItemStack stackToRender = new ItemStack(ModItems.bellowshandle, 1);
                renderItem.renderItem(stackToRender, renderItem.getItemModelMesher().getItemModel(stackToRender));
                //GL11.glPopMatrix();
            }
            GL11.glPopMatrix();

            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
            GL11.glPopMatrix();
        }
    }
}