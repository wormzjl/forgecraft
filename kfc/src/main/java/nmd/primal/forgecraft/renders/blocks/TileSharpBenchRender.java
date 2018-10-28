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
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.forgecraft.blocks.machine.SharpBench;
import nmd.primal.forgecraft.blocks.machine.Workbench;
import nmd.primal.forgecraft.items.parts.WeaponPart;
import nmd.primal.forgecraft.tiles.TileSharpBench;
import nmd.primal.forgecraft.tiles.TileWorkbench;
import org.lwjgl.opengl.GL11;

/**
 * Created by kitsu on 12/4/2016.
 */
public class TileSharpBenchRender extends TileEntitySpecialRenderer<TileSharpBench>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    @Override
    public void render(TileSharpBench tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        if (state.getBlock() instanceof SharpBench) {

            GL11.glPushMatrix();
            GL11.glTranslated(x, y, z);
            //GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float prevLGTX = OpenGlHelper.lastBrightnessX;
            float prevLGTY = OpenGlHelper.lastBrightnessY;

            int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

            ItemStack stack0 = tile.getSlotStack(0);

            if (state.getValue(Workbench.FACING) == EnumFacing.NORTH) {

                if (!stack0.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();

                    GL11.glTranslated(0.5D, 0.71875D, 0.28125D);
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotated(90.0F, 0.0F, 1.0F, 0.0F);
                    if(state.getValue(PrimalAPI.States.ACTIVE)) {
                        GL11.glRotated(PrimalAPI.getRandom().nextDouble(0D, 360D), 0.0D, 0.0D, 1.0D);
                    }
                    renderItem.renderItem(stack0, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
            }
            if (state.getValue(Workbench.FACING) == EnumFacing.SOUTH) {
                if (!stack0.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();

                    GL11.glTranslated(0.5D, 0.71875D, 1-0.28125D);
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotated(90.0F, 0.0F, 1.0F, 0.0F);
                    if(state.getValue(PrimalAPI.States.ACTIVE)) {
                        GL11.glRotated(PrimalAPI.getRandom().nextDouble(0D, 360D), 0.0D, 0.0D, 1.0D);
                    }
                    renderItem.renderItem(stack0, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
            }
            if (state.getValue(Workbench.FACING) == EnumFacing.EAST) {
                if (!stack0.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();

                    GL11.glTranslated(1-0.28125D, 0.71875D, 0.5D);
                    GL11.glScalef(scale, scale, scale);
                    //GL11.glRotated(90.0F, 0.0F, 1.0F, 0.0F);
                    if(state.getValue(PrimalAPI.States.ACTIVE)) {
                        GL11.glRotated(PrimalAPI.getRandom().nextDouble(0D, 360D), 0.0D, 0.0D, 1.0D);
                    }
                    renderItem.renderItem(stack0, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
            }
            if (state.getValue(Workbench.FACING) == EnumFacing.WEST) {
                if (!stack0.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();

                    GL11.glTranslated(0.28125D, 0.71875D, 0.5D);
                    GL11.glScalef(scale, scale, scale);
                    //GL11.glRotated(90.0F, 0.0F, 1.0F, 0.0F);
                    if(state.getValue(PrimalAPI.States.ACTIVE)) {
                        GL11.glRotated(PrimalAPI.getRandom().nextDouble(0D, 360D), 0.0D, 0.0D, 1.0D);
                    }
                    renderItem.renderItem(stack0, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
            }


            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
            GL11.glPopMatrix();
        }
    }
}