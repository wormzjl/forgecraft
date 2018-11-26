package nmd.primal.forgecraft.renders.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.forgecraft.blocks.CustomContainerFacingActive;
import nmd.primal.forgecraft.blocks.machine.RedstoneEngine;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.init.ModSounds;
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
    private boolean sound1;
    private boolean sound2;

    private boolean getSound1() {
        return sound1;
    }
    private void setSound1(boolean sound) {
        this.sound1 = sound;
    }

    private boolean getSound2() {
        return sound2;
    }
    private void setSound2(boolean sound) {
        this.sound2 = sound;
    }


    private void doPistonRotations(int t, float kon, float a, float pk, float testa, World world, BlockPos pos){

        if( pk >= 0 && pk < 0.25 ) {
            if(pk<=0.02 && !getSound2()){
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), ModSounds.ENGINE_RETRACTION, SoundCategory.BLOCKS, 0.25F, 1.0F, true);
                setSound2(true);
            }

            GL11.glRotatef(angle * (time/(kon/4)), 1.0F, 0.0F, 0.0F);
        }
        if( pk >= 0.25 && pk < 0.5) {
            if(getSound2()){
                setSound2(false);
            }
            GL11.glRotatef(testa, 1.0F, 0.0F, 0.0F);
        }
        if( pk >= 0.5 && pk < 0.75) {
            if(pk<=0.52 && !getSound1()){
               world.playSound(pos.getX(), pos.getY(), pos.getZ(), ModSounds.ENGINE_EXTENSION, SoundCategory.BLOCKS, 0.2F, 1.0F, true);
               setSound1(true);
            }

            GL11.glRotatef(testa, 1.0F, 0.0F, 0.0F);
        }
        float thirdFloat = time - ((kon/4)*3);
        if( pk >= 0.75 && pk <= 1) {
            if(getSound1()){
                setSound1(false);
            }
            GL11.glRotatef(-angle * (((kon/4)-thirdFloat)/(kon/4)), 1.0F, 0.0F, 0.0F);
        }
    }

    @Override
    public void render(TileRedstoneEngine tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        World world = tile.getWorld();

        ItemStack crank    = new ItemStack(ModItems.woodcrank);
        ItemStack arm      = new ItemStack(ModItems.woodpistonarm);
        ItemStack piston   = new ItemStack(ModItems.woodpiston);

        ItemStack gearbox  = tile.getSlotStack(0);
        ItemStack slotTool = tile.getSlotStack(1);

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

            /************************
             N  O  R  T  H
             ************************/

            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.NORTH) {
                /***C R A N K***/
                GL11.glPushMatrix();
                GL11.glTranslated((11/32D), (16/32D), (7/32D));
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    GL11.glRotatef(360*(percentK), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(crank, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***P I S T O N***/
                GL11.glPushMatrix();
                    GL11.glTranslated((3/32D), 16/32D, 15/16D);
                    if(state.getValue(PrimalAPI.States.ACTIVE)){
                        doPistonRotations(time, k, angle, percentK, testAngle, world, pos);
                    }
                    renderItem.renderItem(piston, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***A R M***/
                GL11.glPushMatrix();

                GL11.glTranslated((3/32D), 16/32D, 29/32D);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    //GL11.glTranslated(0.0, ((3/16D) * Math.cos(Math.toRadians( (360*(time / k))-90) )),
                    //        (3/16D)+((3/16D) * Math.sin(Math.toRadians( (360*(time / k))-90 ))) );
                    doPistonRotations(time, k, angle, percentK, testAngle, world, pos);
                    GL11.glTranslated(0, 0, tempZ);

                }
                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***G E A R B O X***/
                GL11.glPushMatrix();

                GL11.glTranslated(16/32D, 23/32D, 16/32D);
                GL11.glRotatef(-90, 0F, 1F, 0.0F);
                renderItem.renderItem(gearbox, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***A X L E***/
                GL11.glPushMatrix();

                GL11.glTranslated((16/32D), 16/32D, 16/32D);

                if(state.getValue(PrimalAPI.States.ACTIVE)) {

                    GL11.glRotatef(-360 * createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone()) , 1.0F, 0.0F, 0.0F);
                    //GL11.glRotatef(-360*(percentKFast), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(slotTool, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }
            /************************
             S  O  U  T  H
             ************************/
            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.SOUTH) {
                /***CRANK***/
                GL11.glPushMatrix();
                GL11.glTranslated((21/32D), (16/32D), (25/32D));
                GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    GL11.glRotatef(360*(time / k), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(crank, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***PISTON***/
                GL11.glPushMatrix();
                GL11.glTranslated((29/32D), 16/32D, 1/16D);
                GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    doPistonRotations(time, k, angle, percentK, testAngle, world, pos);
                }
                renderItem.renderItem(piston, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***ARM1***/
                GL11.glPushMatrix();

                GL11.glTranslated((29/32D), 16/32D, 3/32D);
                GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    doPistonRotations(time, k, angle, percentK, testAngle, world, pos);
                    GL11.glTranslated(0, 0, tempZ);
                }
                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***GEARBOX***/
                GL11.glPushMatrix();

                GL11.glTranslated(16/32D, 23/32D, 16/32D);
                GL11.glRotatef(90, 0F, 1F, 0.0F);
                renderItem.renderItem(gearbox, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***TOOL SLOT***/
                GL11.glPushMatrix();

                float gearMulti = 1;

                GL11.glTranslated((16/32D), 16/32D, 16/32D);
                GL11.glRotatef(180, 0F, 1F, 0F);

                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    GL11.glRotatef(-360*createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone()), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(slotTool, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }
            /************************
             E  A  S  T
             ************************/
            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.EAST) {
                /***CRANK***/
                GL11.glPushMatrix();
                GL11.glTranslated((25/32D), (16/32D), (11/32D));
                GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    GL11.glRotatef(360*(time / k), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(crank, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***PISTON***/
                GL11.glPushMatrix();
                GL11.glTranslated((3/32D), 16/32D, 3/32D);
                GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    doPistonRotations(time, k, angle, percentK, testAngle, world, pos);
                }
                renderItem.renderItem(piston, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***ARM1***/
                GL11.glPushMatrix();

                GL11.glTranslated((3/32D), 16/32D, 3/32D);
                GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    doPistonRotations(time, k, angle, percentK, testAngle, world, pos);
                    GL11.glTranslated(0, 0, tempZ);
                }

                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***GEARBOX***/
                GL11.glPushMatrix();

                GL11.glTranslated(16/32D, 23/32D, 16/32D);
                GL11.glRotatef(180, 0F, 1F, 0.0F);
                renderItem.renderItem(gearbox, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***TOOL SLOT***/
                GL11.glPushMatrix();

                float gearMulti = 1;

                GL11.glTranslated((16/32D), 16/32D, 16/32D);
                GL11.glRotatef(-90, 0F, 1F, 0F);

                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    GL11.glRotatef(-360*createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone()), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(slotTool, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }
            /************************
             W  E  S  T
             ************************/
            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.WEST) {
                /***CRANK***/
                GL11.glPushMatrix();
                GL11.glTranslated((7/32D), (16/32D), (21/32D));
                GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    GL11.glRotatef(360*(time / k), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(crank, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***PISTON***/
                GL11.glPushMatrix();
                GL11.glTranslated((29/32D), 16/32D, 29/32D);
                GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    doPistonRotations(time, k, angle, percentK, testAngle, world, pos);
                }
                renderItem.renderItem(piston, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***ARM1***/
                GL11.glPushMatrix();

                GL11.glTranslated((29/32D), 16/32D, 29/32D);
                GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    doPistonRotations(time, k, angle, percentK, testAngle, world, pos);
                    GL11.glTranslated(0, 0, tempZ);
                }

                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***GEARBOX***/
                GL11.glPushMatrix();

                GL11.glTranslated(16/32D, 23/32D, 16/32D);
                //GL11.glRotatef(180, 0F, 1F, 0.0F);
                renderItem.renderItem(gearbox, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***TOOL SLOT***/
                GL11.glPushMatrix();

                float gearMulti = 1;

                GL11.glTranslated((16/32D), 16/32D, 16/32D);
                GL11.glRotatef(90, 0F, 1F, 0F);

                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    GL11.glRotatef(-360*createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone()), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(slotTool, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }

            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
            GL11.glPopMatrix();
        }
    }

    public float createOutputK(World world, Float gearMulti, int redstone){
        if(gearMulti==1){
            float k = (60 - (redstone*2));
            float time = (int) (world.getTotalWorldTime() % k);
            float tempK = (time / k);
            return tempK;
        } else if (gearMulti==4){
            float fastk = (60 - (redstone*2))*0.25F;
            float fastTime = (int) (world.getTotalWorldTime() % fastk);
            float tempk = fastTime / fastk;
            return tempk;
        } else if(gearMulti==0.25){
            float slowk = (60 - (redstone*2))*4F;
            float slowTime = (int) (world.getTotalWorldTime() % slowk);
            float tempk = slowTime / slowk;
            return tempk;
        } else return 0;
    }

}