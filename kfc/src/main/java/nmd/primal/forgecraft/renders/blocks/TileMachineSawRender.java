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
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.blocks.CustomContainerFacingActive;
import nmd.primal.forgecraft.blocks.machine.MachineSaw;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModSounds;
import nmd.primal.forgecraft.tiles.TileMachineSaw;
import nmd.primal.forgecraft.tiles.TileRedstoneEngine;
import org.lwjgl.opengl.GL11;

/**
 * Created by mminaie on 4/9/17.
 */
public class TileMachineSawRender extends TileEntitySpecialRenderer<TileMachineSaw> {
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    private boolean sound1;

    private boolean getSound1() {
        return sound1;
    }
    private void setSound1(boolean sound) {
        this.sound1 = sound;
    }

    @Override
    public void render(TileMachineSaw tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        World world = tile.getWorld();

        ItemStack saw = tile.getSlotStack(0);

        if (state.getBlock() instanceof MachineSaw) {

            GL11.glPushMatrix();
            GL11.glTranslated(x, y, z);
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float prevLGTX = OpenGlHelper.lastBrightnessX;
            float prevLGTY = OpenGlHelper.lastBrightnessY;
            int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

             //N  O  R  T  H
            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.NORTH) {
                GL11.glPushMatrix();
                GL11.glTranslated((16 / 32D), (27 / 32D), (16 / 32D));
                GL11.glRotatef(180 , 0.0F, 1.0F, 0.0F);
                if(world.getBlockState(pos.west()).getBlock().equals(ModBlocks.redstoneengine)) {
                    if(state.getValue(PrimalAPI.States.ACTIVE) && tile.getTransfer()) {
                        GL11.glRotatef(-360 * createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone()), 1.0F, 0.0F, 0.0F);
                        if(createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone())<=0.02F && !getSound1()){
                            world.playSound(pos.getX(), pos.getY(), pos.getZ(), ModSounds.SAW_MACHINE, SoundCategory.BLOCKS, 0.15F, 1.0F, true);
                        }
                        if(createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone())>0.02F && getSound1()){
                            setSound1(false);
                        }
                    }

                }
                renderItem.renderItem(saw, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }

            //S O U T H//
            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.SOUTH) {
                GL11.glPushMatrix();
                GL11.glTranslated((16 / 32D), (27 / 32D), (16 / 32D));
                if(world.getBlockState(pos.east()).getBlock().equals(ModBlocks.redstoneengine)) {
                    if(state.getValue(PrimalAPI.States.ACTIVE) && tile.getTransfer()) {
                        GL11.glRotatef(-360 * createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone()), 1.0F, 0.0F, 0.0F);
                        if(createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone())<=0.02F && !getSound1()){
                            world.playSound(pos.getX(), pos.getY(), pos.getZ(), ModSounds.SAW_MACHINE, SoundCategory.BLOCKS, 0.15F, 1.0F, true);
                        }
                        if(createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone())>0.02F && getSound1()){
                            setSound1(false);
                        }
                    }
                }
                renderItem.renderItem(saw, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }

            //E A S T//
            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.EAST) {
                GL11.glPushMatrix();
                GL11.glTranslated((16 / 32D), (27 / 32D), (16 / 32D));
                GL11.glRotatef(90 , 0.0F, 1.0F, 0.0F);
                if(world.getBlockState(pos.north()).getBlock().equals(ModBlocks.redstoneengine)) {
                    if(state.getValue(PrimalAPI.States.ACTIVE) && tile.getTransfer()) {
                        GL11.glRotatef(360 * createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone()), 1.0F, 0.0F, 0.0F);
                        if(createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone())<=0.02F && !getSound1()){
                            world.playSound(pos.getX(), pos.getY(), pos.getZ(), ModSounds.SAW_MACHINE, SoundCategory.BLOCKS, 0.15F, 1.0F, true);
                        }
                        if(createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone())>0.02F && getSound1()){
                            setSound1(false);
                        }
                    }
                }
                renderItem.renderItem(saw, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }

            //W E S T//
            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.WEST) {
                GL11.glPushMatrix();
                GL11.glTranslated((16 / 32D), (27 / 32D), (16 / 32D));
                GL11.glRotatef(-90 , 0.0F, 1.0F, 0.0F);
                if(world.getBlockState(pos.south()).getBlock().equals(ModBlocks.redstoneengine)) {
                    if(state.getValue(PrimalAPI.States.ACTIVE) && tile.getTransfer()) {
                        GL11.glRotatef(360 * createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone()), 1.0F, 0.0F, 0.0F);
                        if(createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone())<=0.02F && !getSound1()){
                            world.playSound(pos.getX(), pos.getY(), pos.getZ(), ModSounds.SAW_MACHINE, SoundCategory.BLOCKS, 0.15F, 1.0F, true);
                        }
                        if(createOutputK(tile.getWorld(), tile.getGearMulti(), tile.getRedstone())>0.02F && getSound1()){
                            setSound1(false);
                        }
                    }
                }
                renderItem.renderItem(saw, ItemCameraTransforms.TransformType.FIXED);
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
            /************************
             S  O  U  T  H
             ************************/
/*
            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.SOUTH) {
                /***CRANK***/
/*
                GL11.glPushMatrix();
                GL11.glTranslated((21/32D), (16/32D), (25/32D));
                GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    GL11.glRotatef(360*(time / k), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(crank, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***PISTON***/
/*
                GL11.glPushMatrix();
                GL11.glTranslated((29/32D), 16/32D, 1/16D);
                GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    doPistonRotations(time, k, angle, percentK, testAngle);
                }
                renderItem.renderItem(piston, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***ARM1***/
/*
                GL11.glPushMatrix();

                GL11.glTranslated((29/32D), 16/32D, 3/32D);
                GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    doPistonRotations(time, k, angle, percentK, testAngle);
                    GL11.glTranslated(0, 0, tempZ);
                }
                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***GEARBOX***/
/*
                GL11.glPushMatrix();

                GL11.glTranslated(16/32D, 23/32D, 16/32D);
                GL11.glRotatef(90, 0F, 1F, 0.0F);
                renderItem.renderItem(gearbox, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***TOOL SLOT***/
/*
                GL11.glPushMatrix();

                float gearMulti = 1;

                GL11.glTranslated((16/32D), 16/32D, 16/32D);
                GL11.glRotatef(180, 0F, 1F, 0F);

                NonNullList<ItemStack> gearList = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
                if(gearbox.getSubCompound("BlockEntityTag") != null) {
                    ItemStackHelper.loadAllItems(gearbox.getSubCompound("BlockEntityTag"), gearList);
                    if(RecipeHelper.isOreName(gearList.get(0), "gearPrimalSmall")) {
                        gearMulti=4F;
                    }
                    if(RecipeHelper.isOreName(gearList.get(0), "gearPrimalMedium")) {
                        gearMulti=1;
                    }
                    if(RecipeHelper.isOreName(gearList.get(0), "gearPrimalLarge")) {
                        gearMulti=0.25f;
                    }
                }

                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    GL11.glRotatef(-360*(percentK*gearMulti), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(slotTool, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }
            /************************
             E  A  S  T
             ************************/
/*
            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.EAST) {
                /***CRANK***/
/*
                GL11.glPushMatrix();
                GL11.glTranslated((25/32D), (16/32D), (11/32D));
                GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    GL11.glRotatef(360*(time / k), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(crank, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***PISTON***/
/*
                GL11.glPushMatrix();
                GL11.glTranslated((3/32D), 16/32D, 3/32D);
                GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    doPistonRotations(time, k, angle, percentK, testAngle);
                }
                renderItem.renderItem(piston, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***ARM1***/
/*
                GL11.glPushMatrix();

                GL11.glTranslated((3/32D), 16/32D, 3/32D);
                GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    doPistonRotations(time, k, angle, percentK, testAngle);
                    GL11.glTranslated(0, 0, tempZ);
                }

                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***GEARBOX***/
/*
                GL11.glPushMatrix();

                GL11.glTranslated(16/32D, 23/32D, 16/32D);
                GL11.glRotatef(180, 0F, 1F, 0.0F);
                renderItem.renderItem(gearbox, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***TOOL SLOT***/
/*
                GL11.glPushMatrix();

                float gearMulti = 1;

                GL11.glTranslated((16/32D), 16/32D, 16/32D);
                GL11.glRotatef(-90, 0F, 1F, 0F);

                NonNullList<ItemStack> gearList = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
                if(gearbox.getSubCompound("BlockEntityTag") != null) {
                    ItemStackHelper.loadAllItems(gearbox.getSubCompound("BlockEntityTag"), gearList);
                    if(RecipeHelper.isOreName(gearList.get(0), "gearPrimalSmall")) {
                        gearMulti=4F;
                    }
                    if(RecipeHelper.isOreName(gearList.get(0), "gearPrimalMedium")) {
                        gearMulti=1;
                    }
                    if(RecipeHelper.isOreName(gearList.get(0), "gearPrimalLarge")) {
                        gearMulti=0.25f;
                    }
                }

                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    GL11.glRotatef(-360*(percentK*gearMulti), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(slotTool, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }
            /************************
             W  E  S  T
             ************************/
/*
            if (state.getValue(CustomContainerFacingActive.FACING) == EnumFacing.WEST) {
                /***CRANK***/
/*
                GL11.glPushMatrix();
                GL11.glTranslated((7/32D), (16/32D), (21/32D));
                GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    GL11.glRotatef(360*(time / k), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(crank, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***PISTON***/
/*
                GL11.glPushMatrix();
                GL11.glTranslated((29/32D), 16/32D, 29/32D);
                GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)){
                    doPistonRotations(time, k, angle, percentK, testAngle);
                }
                renderItem.renderItem(piston, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***ARM1***/
/*
                GL11.glPushMatrix();

                GL11.glTranslated((29/32D), 16/32D, 29/32D);
                GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    doPistonRotations(time, k, angle, percentK, testAngle);
                    GL11.glTranslated(0, 0, tempZ);
                }

                renderItem.renderItem(arm, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***GEARBOX***/
/*
                GL11.glPushMatrix();

                GL11.glTranslated(16/32D, 23/32D, 16/32D);
                //GL11.glRotatef(180, 0F, 1F, 0.0F);
                renderItem.renderItem(gearbox, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();

                /***TOOL SLOT***/
/*
                GL11.glPushMatrix();

                float gearMulti = 1;

                GL11.glTranslated((16/32D), 16/32D, 16/32D);
                GL11.glRotatef(90, 0F, 1F, 0F);

                NonNullList<ItemStack> gearList = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
                if(gearbox.getSubCompound("BlockEntityTag") != null) {
                    ItemStackHelper.loadAllItems(gearbox.getSubCompound("BlockEntityTag"), gearList);
                    if(RecipeHelper.isOreName(gearList.get(0), "gearPrimalSmall")) {
                        gearMulti=4F;
                    }
                    if(RecipeHelper.isOreName(gearList.get(0), "gearPrimalMedium")) {
                        gearMulti=1;
                    }
                    if(RecipeHelper.isOreName(gearList.get(0), "gearPrimalLarge")) {
                        gearMulti=0.25f;
                    }
                }

                if(state.getValue(PrimalAPI.States.ACTIVE)) {
                    GL11.glRotatef(-360*(percentK*gearMulti), 1.0F, 0.0F, 0.0F);
                }
                renderItem.renderItem(slotTool, ItemCameraTransforms.TransformType.FIXED);
                GL11.glPopMatrix();
            }
*/
            //OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
            //GL11.glPopMatrix();
        //}


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