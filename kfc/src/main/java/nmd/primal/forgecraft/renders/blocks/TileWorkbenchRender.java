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
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.forgecraft.blocks.machine.Workbench;
import nmd.primal.forgecraft.items.parts.WeaponHandle;
import nmd.primal.forgecraft.items.parts.WeaponPart;
import nmd.primal.forgecraft.tiles.TileWorkbench;
import org.lwjgl.opengl.GL11;

/**
 * Created by kitsu on 12/4/2016.
 */
public class TileWorkbenchRender extends TileEntitySpecialRenderer<TileWorkbench>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    @Override
    public void render(TileWorkbench tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        if (state.getBlock() instanceof Workbench) {

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
            ItemStack stack3 = tile.getSlotStack(3);
            ItemStack stack4 = tile.getSlotStack(4);
            ItemStack stack5 = tile.getSlotStack(5);
            ItemStack stack6 = tile.getSlotStack(6);




            if (state.getValue(Workbench.FACING) == EnumFacing.NORTH) {

                if (!stack0.isEmpty()) {
                    boolean is_block = stack0.getItem() instanceof ItemBlock;
                    float scale = is_block ? 0.5F : 0.3F;
                    double trans = is_block ? 0.3125D : 0.3125D;
                    double yTrans = is_block ? 0.3D : 0.3D;
                    GL11.glPushMatrix();


                    GL11.glTranslated(trans, yTrans, 0.25D);
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotated(180.0F, 0.0F, 1.0F, 0.0F);
                    renderItem.renderItem(stack0, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();

                }
                if (!stack1.isEmpty()) {
                    boolean is_block = stack1.getItem() instanceof ItemBlock;
                    float scale = is_block ? 0.5F : 0.3F;
                    double trans = is_block ? 0.3125D : 0.3125D;
                    double yTrans = is_block ? 0.3D : 0.3D;
                    GL11.glPushMatrix();

                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(trans+0.375D, yTrans, 0.25D);
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotated(180.0F, 0.0F, 1.0F, 0.0F);
                    renderItem.renderItem(stack1, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();

                }
                if(!stack2.isEmpty()){
                    GL11.glPushMatrix();

                    if(RecipeHelper.isOreName(stack2.getItem(), "cordageGeneral")){
                        GL11.glTranslated(0.4375, 0.65625D, 0.26D);
                        GL11.glScalef(0.5F, 0.5F, 0.5F);
                        GL11.glRotated(90.0F, 1.0F, .0F, 0.0F);
                        //GL11.glRotated(45.0F, 0.0F, 0.0F, 1.0F);
                        //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    } else {
                        GL11.glTranslated(0.4375, 0.65625D, 0.26D);
                        GL11.glScalef(0.7F, 1F, 0.55F);
                        GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                        GL11.glRotated(-45.0F, 0.0F, 1.0F, 0.0F);

                    }
                    renderItem.renderItem(stack2, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if(!stack3.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);

                    if(stack3.getItem() instanceof WeaponPart){
                        GL11.glTranslated(0.67D, 0.376D, 0.25D);
                        GL11.glScalef(0.6F, 0.6F, 0.6F);

                    } else {
                        GL11.glTranslated(0.37D, 0.2075D, 0.21D);
                        GL11.glScalef(1F, 1F, 1F);
                    }
                    GL11.glRotated(-90.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack3, ItemCameraTransforms.TransformType.HEAD);
                    GL11.glPopMatrix();
                }
                if(!stack4.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.85, 0.65625D, 0.25D);
                    GL11.glScalef(0.3F, 0.3F, 0.3F);
                    GL11.glRotated(45.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack4, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if(!stack5.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.48D, 0.20625D, -0.15D);
                    GL11.glScalef(1F, 1F, 1F);
                    GL11.glRotated(-90.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotated(-90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack5, ItemCameraTransforms.TransformType.HEAD);
                    GL11.glPopMatrix();
                }

            }
            if (state.getValue(Workbench.FACING) == EnumFacing.SOUTH) {

                if (!stack0.isEmpty()) {
                    boolean is_block = stack0.getItem() instanceof ItemBlock;
                    float scale = is_block ? 0.5F : 0.3F;
                    double trans = is_block ? 0.3125D : 0.3125D;
                    double yTrans = is_block ? 0.3D : 0.3D;
                    GL11.glPushMatrix();

                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(trans+0.375D, yTrans, 0.75D);

                    GL11.glScalef(scale, scale, scale);
                    renderItem.renderItem(stack0, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();

                }
                if (!stack1.isEmpty()) {
                    boolean is_block = stack1.getItem() instanceof ItemBlock;
                    float scale = is_block ? 0.5F : 0.3F;
                    double trans = is_block ? 0.3125D : 0.3125D;
                    double yTrans = is_block ? 0.3D : 0.3D;
                    GL11.glPushMatrix();

                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(trans, yTrans, 0.75D);
                    GL11.glScalef(scale, scale, scale);
                    renderItem.renderItem(stack1, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();

                }
                if(!stack2.isEmpty()){
                    GL11.glPushMatrix();

                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.5625, 0.65625D, 0.7925D);
                    GL11.glScalef(0.7F, 1F, 0.55F);
                    GL11.glRotated(-45.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack2, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if(!stack3.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.55, 0.2075D, 0.77D);
                    GL11.glScalef(1F, 1F, 1F);
                    GL11.glRotated(90.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack3, ItemCameraTransforms.TransformType.HEAD);
                    GL11.glPopMatrix();
                }
                if(!stack4.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.175, 0.65625D, 0.78D);
                    GL11.glScalef(0.3F, 0.3F, 0.3F);
                    GL11.glRotated(45.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack4, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if(!stack5.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.52D, 0.20625D, 1.15D);
                    GL11.glScalef(1F, 1F, 1F);
                    GL11.glRotated(90.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotated(-90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack5, ItemCameraTransforms.TransformType.HEAD);
                    GL11.glPopMatrix();
                }
            }
            if (state.getValue(Workbench.FACING) == EnumFacing.EAST) {

                if (!stack0.isEmpty()) {
                    boolean is_block = stack0.getItem() instanceof ItemBlock;
                    float scale = is_block ? 0.5F : 0.3F;
                    double trans = is_block ? 0.3125D : 0.3125D;
                    double yTrans = is_block ? 0.3D : 0.3D;
                    GL11.glPushMatrix();


                    GL11.glTranslated(0.75D, yTrans, trans);
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotated(90F, 0.0F, 1.0F, 0.0F);
                    renderItem.renderItem(stack0, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();

                }
                if (!stack1.isEmpty()) {
                    boolean is_block = stack1.getItem() instanceof ItemBlock;
                    float scale = is_block ? 0.5F : 0.3F;
                    double trans = is_block ? 0.3125D : 0.3125D;
                    double yTrans = is_block ? 0.3D : 0.3D;
                    GL11.glPushMatrix();

                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.75D, yTrans, trans+0.375D);
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotated(90F, 0.0F, 1.0F, 0.0F);
                    renderItem.renderItem(stack1, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();

                }
                if(!stack2.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.7925D, 0.65625D, 0.4375);
                    GL11.glScalef(0.55F, 1F, 0.7F);
                    GL11.glRotated(45F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack2, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if(!stack3.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.75, 0.2075D, 0.4D);
                    GL11.glScalef(1F, 1F, 1F);
                    GL11.glRotated(180.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack3, ItemCameraTransforms.TransformType.HEAD);
                    GL11.glPopMatrix();
                }
                if(!stack4.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.755, 0.65625D, 0.8D);
                    GL11.glScalef(0.3F, 0.3F, 0.3F);
                    GL11.glRotated(-45.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack4, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if(!stack5.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(1.15D, 0.20625D, 0.485D);
                    GL11.glScalef(1F, 1F, 1F);
                    GL11.glRotated(180.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotated(-90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack5, ItemCameraTransforms.TransformType.HEAD);
                    GL11.glPopMatrix();
                }
            }
            if (state.getValue(Workbench.FACING) == EnumFacing.WEST) {

                if (!stack0.isEmpty()) {
                    boolean is_block = stack0.getItem() instanceof ItemBlock;
                    float scale = is_block ? 0.5F : 0.3F;
                    double trans = is_block ? 0.3125D : 0.3125D;
                    double yTrans = is_block ? 0.3D : 0.3D;
                    GL11.glPushMatrix();

                    GL11.glTranslated(0.25D, yTrans, trans+0.375D);
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotated(-90F, 0.0F, 1.0F, 0.0F);
                    renderItem.renderItem(stack0, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();

                }
                if (!stack1.isEmpty()) {
                    boolean is_block = stack1.getItem() instanceof ItemBlock;
                    float scale = is_block ? 0.5F : 0.3F;
                    double trans = is_block ? 0.3125D : 0.3125D;
                    double yTrans = is_block ? 0.3D : 0.3D;
                    GL11.glPushMatrix();

                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.25D, yTrans, trans);
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotated(-90F, 0.0F, 1.0F, 0.0F);
                    renderItem.renderItem(stack1, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if(!stack2.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.255D, 0.65625D, 0.565);
                    GL11.glScalef(0.55F, 1F, 0.7F);
                    GL11.glRotated(45F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack2, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if(!stack3.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.235, 0.2075D, 0.6D);
                    GL11.glScalef(1F, 1F, 1F);
                    //GL11.glRotated(-180.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack3, ItemCameraTransforms.TransformType.HEAD);
                    GL11.glPopMatrix();
                }
                if(!stack4.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(0.2175, 0.65625D, 0.185D);
                    GL11.glScalef(0.3F, 0.3F, 0.3F);
                    GL11.glRotated(-45.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack4, ItemCameraTransforms.TransformType.FIXED);
                    GL11.glPopMatrix();
                }
                if(!stack5.isEmpty()){
                    GL11.glPushMatrix();
                    //System.out.println(stack2);
                    //GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(-0.138D, 0.20625D, 0.52D);
                    GL11.glScalef(1F, 1F, 1F);
                    //GL11.glRotated(180.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotated(-90.0F, 1.0F, 0.0F, 0.0F);

                    renderItem.renderItem(stack5, ItemCameraTransforms.TransformType.HEAD);
                    GL11.glPopMatrix();
                }
            }


            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
            GL11.glPopMatrix();
        }
    }
}