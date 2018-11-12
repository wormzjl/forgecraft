package nmd.primal.forgecraft.renders.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.blocks.machine.SharpBench;
import nmd.primal.forgecraft.blocks.machine.Workbench;
import nmd.primal.forgecraft.blocks.misc.Gearbox;
import nmd.primal.forgecraft.tiles.TileGearbox;
import nmd.primal.forgecraft.tiles.TileSharpBench;
import org.lwjgl.opengl.GL11;

/**
 * Created by kitsu on 12/4/2016.
 */
public class TileGearboxRender extends TileEntitySpecialRenderer<TileGearbox>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    @Override
    public void render(TileGearbox tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        if (state.getBlock() instanceof Gearbox) {

            GL11.glPushMatrix();
            GL11.glTranslated(x, y, z);
            //GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float prevLGTX = OpenGlHelper.lastBrightnessX;
            float prevLGTY = OpenGlHelper.lastBrightnessY;

            int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

            ItemStack stack0 = tile.getSlotStack(0);
            ItemStack stack1 = tile.getSlotStack(1);
            ItemStack stack2 = tile.getSlotStack(2);

            if (state.getValue(Workbench.FACING) == EnumFacing.NORTH) {

                if (!stack0.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslated(17/32D, 9/32D, 17/32D);
                    //GL11.glRotated(90.0F, 0.0F, 1.0F, 0.0F);
                    //if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    //    GL11.glRotated(PrimalAPI.getRandom().nextDouble(0D, 360D), 0.0D, 0.0D, 1.0D);
                    //}
                    renderItem.renderItem(stack0, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if (!stack1.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslated(25/32D, 9/32D, 17/32D);
                    GL11.glRotated(11.25F, 0F, 0F, 1.0F);
                    //if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    //    GL11.glRotated(PrimalAPI.getRandom().nextDouble(0D, 360D), 0.0D, 0.0D, 1.0D);
                    //}
                    renderItem.renderItem(stack1, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if (!stack2.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslated(16/32D, 16/32D, 16/32D);
                    GL11.glRotated(180F, 0.0F, 1.0F, 0.0F);
                    //if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    //    GL11.glRotated(PrimalAPI.getRandom().nextDouble(0D, 360D), 0.0D, 0.0D, 1.0D);
                    //}
                    renderItem.renderItem(stack2, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
            }
            if (state.getValue(Workbench.FACING) == EnumFacing.SOUTH) {
                if (!stack0.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslated(15/32D, 9/32D, 15/32D);
                    //GL11.glRotated(90.0F, 0.0F, 1.0F, 0.0F);
                    renderItem.renderItem(stack0, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if (!stack1.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslated(7/32D, 9/32D, 15/32D);
                    GL11.glRotated(11.25F, 0F, 0F, 1.0F);
                    renderItem.renderItem(stack1, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if (!stack2.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslated(16/32D, 16/32D, 16/32D);
                    //GL11.glRotated(180F, 0.0F, 1.0F, 0.0F);
                    renderItem.renderItem(stack2, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
            }
            if (state.getValue(Workbench.FACING) == EnumFacing.EAST) {
                if (!stack0.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslated(15/32D, 9/32D, 17/32D);
                    GL11.glRotated(90.0F, 0.0F, 1.0F, 0.0F);
                    renderItem.renderItem(stack0, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if (!stack1.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslated(15/32D, 9/32D, 25/32D);
                    GL11.glRotated(90.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotated(11.25F, 0F, 0F, 1F);
                    renderItem.renderItem(stack1, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if (!stack2.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslated(16/32D, 16/32D, 16/32D);
                    GL11.glRotated(90, 0.0F, 1.0F, 0.0F);
                    renderItem.renderItem(stack2, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
            }
            if (state.getValue(Workbench.FACING) == EnumFacing.WEST) {
                if (!stack0.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslated(17/32D, 9/32D, 15/32D);
                    GL11.glRotated(90.0F, 0.0F, 1.0F, 0.0F);
                    renderItem.renderItem(stack0, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if (!stack1.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslated(17/32D, 9/32D, 7/32D);
                    GL11.glRotated(90.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotated(11.25F, 0F, 0F, 1F);
                    renderItem.renderItem(stack1, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if (!stack2.isEmpty()) {
                    float scale = 1.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslated(16/32D, 16/32D, 16/32D);
                    GL11.glRotated(-90, 0.0F, 1.0F, 0.0F);
                    renderItem.renderItem(stack2, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
            }


            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
            GL11.glPopMatrix();
        }
    }
}