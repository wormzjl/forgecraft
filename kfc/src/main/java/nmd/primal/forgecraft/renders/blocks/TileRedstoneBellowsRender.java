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
import nmd.primal.forgecraft.blocks.machine.Breaker;
import nmd.primal.forgecraft.blocks.machine.RedstoneBellows;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.tiles.TileBreaker;
import nmd.primal.forgecraft.tiles.TileRedstoneBellows;
import org.lwjgl.opengl.GL11;

/**
 * Created by mminaie on 4/9/17.
 */
public class TileRedstoneBellowsRender extends TileEntitySpecialRenderer<TileRedstoneBellows>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    private static int time =0;
    private static float k =80;
    private static float angle = 17;

    @Override
    public void render(TileRedstoneBellows tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        ItemStack crank = new ItemStack(ModItems.woodcrank);
        ItemStack arm = new ItemStack(ModItems.woodpistonarm);
        ItemStack piston = new ItemStack(ModItems.woodpiston);
        int[] angles = {0,45,45*2, 45*3, 45*4, 45*5, 45*6, 45*7};
        time++;
        if(time > k){
            time = 0;
        }
        float percentK = time / k;
        if (state.getBlock() instanceof RedstoneBellows) {

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
                /***CRANK***/
                GL11.glPushMatrix();
                GL11.glTranslated((11/32D), (9/32D), (7/32D));
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    GL11.glRotatef(360*(time / k), 1.0F, 0.0F, 0.0F);
                }
                //GL11.glTranslated(0.5D, 0.450D, 0.7);
                //GL11.glRotated(90, 0.0f, 1.0f, 0.0f);
                //GL11.glRotatef(-135, 0.0f, 0.0f, 1.0f);

                //GL11.glRotatef(tile.getCharge(), 0.0f, 0.0f, 1.0f);

                //GL11.glTranslatef(0.0f, 0.40f, 0.0f);
                //GL11.glTranslated(-0.45D, 0.0D, 0.0D);

                renderItem.renderItem(crank, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
                /***PISTON***/
                GL11.glPushMatrix();
                GL11.glTranslated((3/32D), 9/32D, 15/16D);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    //System.out.println(percentK);
                    //GL11.glRotatef(17, 1.0F, 0.0F, 0.0F);
                    if( percentK >= 0 && percentK < 0.25 ) {
                        GL11.glRotatef(angle * (time/(k/4)), 1.0F, 0.0F, 0.0F);
                    }
                    float halfFloat = time - (k/4);
                    if( percentK >= 0.25 && percentK < 0.5) {
                        GL11.glRotatef(angle * (((k/4)-halfFloat)/(k/4)), 1.0F, 0.0F, 0.0F);
                    }
                    if( percentK >= 0.5 && percentK < 0.75) {
                        GL11.glRotatef(-angle * ((time-(k/2))/(k/4)), 1.0F, 0.0F, 0.0F);
                    }
                    float thirdFloat = time - ((k/4)*3);
                    if( percentK >= 0.75 && percentK < 1) {
                        GL11.glRotatef(-angle * (((k/4)-thirdFloat)/(k/4)), 1.0F, 0.0F, 0.0F);

                    }

                    //GL11.glRotatef(360*partialTicks, 1.0F, 0.0F, 0.0F);
                }

                //GL11.glRotatef(tile.getCharge(), 0.0f, 0.0f, 1.0f);

                //GL11.glTranslatef(0.0f, 0.40f, 0.0f);
                //GL11.glTranslated(-0.45D, 0.0D, 0.0D);

                renderItem.renderItem(piston, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
                /***ARM1***/
                GL11.glPushMatrix();
                //GL11.glTranslated(0.5D, 0.450D, 0.7);
                //GL11.glRotated(90, 0.0f, 1.0f, 0.0f);
                //GL11.glRotatef(-135, 0.0f, 0.0f, 1.0f);

                //GL11.glRotatef(tile.getCharge(), 0.0f, 0.0f, 1.0f);

                //GL11.glTranslatef(0.0f, 0.40f, 0.0f);
                //GL11.glTranslated(-0.45D, 0.0D, 0.0D);

                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
                /***ARM2***/
                GL11.glPushMatrix();
                GL11.glTranslated(0.5D, 0, 7/16D);
                //GL11.glRotated(90, 0.0f, 1.0f, 0.0f);
                //GL11.glRotatef(-135, 0.0f, 0.0f, 1.0f);

                //GL11.glRotatef(tile.getCharge(), 0.0f, 0.0f, 1.0f);

                //GL11.glTranslatef(0.0f, 0.40f, 0.0f);
                //GL11.glTranslated(-0.45D, 0.0D, 0.0D);
                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }

            if (state.getValue(Breaker.FACING) == EnumFacing.EAST) {
                GL11.glPushMatrix();
                GL11.glTranslated(0.3D, 0.450D, 0.5);
                //GL11.glRotated(90, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-135, 0.0f, 0.0f, 1.0f);

                //GL11.glRotatef(tile.getCharge(), 0.0f, 0.0f, 1.0f);

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

                //GL11.glRotatef(tile.getCharge(), 0.0f, 0.0f, -1.0f);

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

                //GL11.glRotatef(tile.getCharge(), 0.0f, 0.0f, -1.0f);

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