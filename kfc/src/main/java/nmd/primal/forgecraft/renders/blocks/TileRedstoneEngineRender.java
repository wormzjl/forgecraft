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
import nmd.primal.forgecraft.blocks.CustomContainerFacingActive;
import nmd.primal.forgecraft.blocks.machine.RedstoneEngine;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.tiles.TileRedstoneEngine;
import org.lwjgl.opengl.GL11;

/**
 * Created by mminaie on 4/9/17.
 */
public class TileRedstoneEngineRender extends TileEntitySpecialRenderer<TileRedstoneEngine>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    private static int time =0;
    //private static float k =60;
    private static float angle = 17;

    private void doPistonRotations(int t, float kon, float a, float pk, float testa){
        if( pk >= 0 && pk < 0.25 ) {
            GL11.glRotatef(angle * (time/(kon/4)), 1.0F, 0.0F, 0.0F);
        }
        if( pk >= 0.25 && pk < 0.5) {
            GL11.glRotatef(testa, 1.0F, 0.0F, 0.0F);
        }
        if( pk >= 0.5 && pk < 0.75) {
            GL11.glRotatef(testa, 1.0F, 0.0F, 0.0F);
        }
        float thirdFloat = time - ((kon/4)*3);
        if( pk >= 0.75 && pk < 1) {
            GL11.glRotatef(-angle * (((kon/4)-thirdFloat)/(kon/4)), 1.0F, 0.0F, 0.0F);
        }
    }

    @Override
    public void render(TileRedstoneEngine tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        ItemStack crank = new ItemStack(ModItems.woodcrank);
        ItemStack arm = new ItemStack(ModItems.woodpistonarm);
        ItemStack piston = new ItemStack(ModItems.woodpiston);
        ItemStack slotTool = new ItemStack(ModItems.woodfan);
        float k = (60 - (tile.getRedstone()*2));

        time = (int) (tile.getWorld().getTotalWorldTime() % k);

        float percentK = time / k;
        if (state.getBlock() instanceof RedstoneEngine) {

            GL11.glPushMatrix();
            GL11.glTranslated(x, y, z);
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float prevLGTX = OpenGlHelper.lastBrightnessX;
            float prevLGTY = OpenGlHelper.lastBrightnessY;
            int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

            //ItemStack stack0 = tile.getSlotStack(0);
            //float angleZ = (float) ((3/16D) * (Math.sin(Math.toRadians( (360*(time / k))-90 ))) );
            float tempY = (float) ((3/16D) * (Math.cos(Math.toRadians( (360*(time / k))-90) )) );
            float tempZ = (float) ((3/16D)+((3/16D) * (Math.sin(Math.toRadians( (360*(time / k))-90 ))) ));
            float testRads = (float) Math.atan(tempY/ (tempZ+(6.5/16F)) );
            float testAngle = (float)Math.toDegrees(testRads);

            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.NORTH) {
                /***CRANK***/
                GL11.glPushMatrix();
                    GL11.glTranslated((11/32D), (9/32D), (7/32D));
                    if(state.getValue(PrimalAPI.States.ACTIVE)){
                        GL11.glRotatef(360*(percentK), 1.0F, 0.0F, 0.0F);
                    }
                    renderItem.renderItem(crank, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***PISTON***/
                GL11.glPushMatrix();
                    GL11.glTranslated((3/32D), 9/32D, 15/16D);
                    if(state.getValue(PrimalAPI.States.ACTIVE)){
                        doPistonRotations(time, k, angle, percentK, testAngle);
                    }
                    renderItem.renderItem(piston, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***ARM1***/
                GL11.glPushMatrix();

                    GL11.glTranslated((3/32D), 9/32D, 29/32D);
                    if(state.getValue(PrimalAPI.States.ACTIVE)) {
                        //GL11.glTranslated(0.0, ((3/16D) * Math.cos(Math.toRadians( (360*(time / k))-90) )),
                        //        (3/16D)+((3/16D) * Math.sin(Math.toRadians( (360*(time / k))-90 ))) );
                        doPistonRotations(time, k, angle, percentK, testAngle);
                        GL11.glTranslated(0, 0, tempZ);

                    }

                    renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***TOOL SLOT***/
                GL11.glPushMatrix();
                GL11.glTranslated((15/32D), 9/32D, 15/32D);
                GL11.glRotatef(45, 1.0F, 0.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    GL11.glRotatef(-360*(percentK), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(slotTool, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }

            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.SOUTH) {
                /***CRANK***/
                GL11.glPushMatrix();
                GL11.glTranslated((21/32D), (9/32D), (25/32D));
                GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    GL11.glRotatef(360*(time / k), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(crank, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***PISTON***/
                GL11.glPushMatrix();
                GL11.glTranslated((29/32D), 9/32D, 1/16D);
                GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    doPistonRotations(time, k, angle, percentK, testAngle);
                }
                renderItem.renderItem(piston, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***ARM1***/
                GL11.glPushMatrix();

                GL11.glTranslated((29/32D), 9/32D, 3/32D);
                GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    doPistonRotations(time, k, angle, percentK, testAngle);
                    GL11.glTranslated(0, 0, tempZ);

                }

                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***TOOL SLOT***/
                /*GL11.glPushMatrix();
                GL11.glTranslated((29/32D), 9/32D, 13/32D);
                GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    //doPistonRotations(time, k, angle, percentK, testAngle);
                    //GL11.glTranslated(0, 0, tempZ);
                }
                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();*/
            }

            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.EAST) {
                /***CRANK***/
                GL11.glPushMatrix();
                GL11.glTranslated((25/32D), (9/32D), (11/32D));
                GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    GL11.glRotatef(360*(time / k), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(crank, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***PISTON***/
                GL11.glPushMatrix();
                GL11.glTranslated((3/32D), 9/32D, 3/32D);
                GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    doPistonRotations(time, k, angle, percentK, testAngle);
                }
                renderItem.renderItem(piston, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***ARM1***/
                GL11.glPushMatrix();

                GL11.glTranslated((3/32D), 9/32D, 3/32D);
                GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    doPistonRotations(time, k, angle, percentK, testAngle);
                    GL11.glTranslated(0, 0, tempZ);
                }

                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***TOOL SLOT***/
                /*GL11.glPushMatrix();
                GL11.glTranslated((29/32D), 9/32D, 13/32D);
                GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    //doPistonRotations(time, k, angle, percentK, testAngle);
                    //GL11.glTranslated(0, 0, tempZ);
                }
                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();*/
            }

            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.WEST) {
                /***CRANK***/
                GL11.glPushMatrix();
                GL11.glTranslated((7/32D), (9/32D), (21/32D));
                GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    GL11.glRotatef(360*(time / k), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(crank, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***PISTON***/
                GL11.glPushMatrix();
                GL11.glTranslated((29/32D), 9/32D, 29/32D);
                GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    doPistonRotations(time, k, angle, percentK, testAngle);
                }
                renderItem.renderItem(piston, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***ARM1***/
                GL11.glPushMatrix();

                GL11.glTranslated((29/32D), 9/32D, 29/32D);
                GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    doPistonRotations(time, k, angle, percentK, testAngle);
                    GL11.glTranslated(0, 0, tempZ);
                }

                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***TOOL SLOT***/
                /*GL11.glPushMatrix();
                GL11.glTranslated((29/32D), 9/32D, 13/32D);
                GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    //doPistonRotations(time, k, angle, percentK, testAngle);
                    //GL11.glTranslated(0, 0, tempZ);
                }
                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();*/
            }

            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
            GL11.glPopMatrix();
        }
    }
}

                        /*if( percentK >= 0 && percentK < 0.25 ) {
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

                        }*/