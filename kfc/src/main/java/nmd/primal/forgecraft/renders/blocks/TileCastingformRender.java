package nmd.primal.forgecraft.renders.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import nmd.primal.forgecraft.blocks.CastingForm;
import nmd.primal.forgecraft.blocks.CustomContainerFacing;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.tiles.TileCastingForm;
import org.lwjgl.opengl.GL11;

/**
 * Created by mminaie on 6/21/17.
 */
public class TileCastingformRender extends TileEntitySpecialRenderer <TileCastingForm>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    @Override
    public void render(TileCastingForm tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        if (state.getBlock() instanceof CastingForm) {

            GL11.glPushMatrix();
            GL11.glTranslated(x+2/16D, y+0.25D, z+2/16D);
            //GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float prevLGTX = OpenGlHelper.lastBrightnessX;
            float prevLGTY = OpenGlHelper.lastBrightnessY;

            int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

        /*
        NORTH
        SLOT |   X   |  Y
        0    | 3/16  | 3/16
        1    | 5/16  | 3/16
        2    | 7/16  | 3/16
        3    | 9/16 | 3/16
        4    | 11/16 | 3/16
        --------------------
        5    | 3/16  | 5/16
        6    | 5/16  | 5/16
        7    | 7/16  | 5/16
        8    | 9/16 | 5/16
        9    | 11/16 | 5/16
        --------------------
        10   | 3/16  | 8/16
        11   | 5/16  | 8/16
        12   | 7/16  | 8/16
        13   | 9/16 | 8/16
        14   | 11/16 | 8/16
        --------------------
        15   | 3/16  | 11/16
        16   | 5/16  | 11/16
        17   | 7/16  | 11/16
        18   | 9/16 | 11/16
        19   | 11/16 | 11/16
        --------------------
        20   | 3/16  | 14/16
        21   | 5/16  | 14/16
        22   | 7/16  | 14/16
        23   | 9/16 | 14/16
        24   | 11/16 | 14/16
         */



            if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.NORTH) {
                int counter = 0;
                for (int i = 0; i < 5; i++) {
                    for (int a = 0; a < 5; a++) {
                        if (!tile.getSlotStack(counter).isEmpty()) {
                            Item item = tile.getSlotStack(counter).getItem();
                            if (item.equals(ModItems.castingmud)) {
                                GL11.glPushMatrix();
                                GL11.glTranslated(tile.getNormalX(a), 0.0D, tile.getNormalZ(i));
                                renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                                GL11.glPopMatrix();
                            }
                        }
                        counter++;
                    }
                }
            }
            if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.SOUTH) {
                int counter = 0;
                for (int i = 0; i < 5; i++) {
                    for (int a = 0; a < 5; a++) {
                        if (!tile.getSlotStack(counter).isEmpty()) {
                            Item item = tile.getSlotStack(counter).getItem();
                            if (item.equals(ModItems.castingmud)) {
                                GL11.glPushMatrix();
                                GL11.glTranslated(tile.getReverseX(a), 0.0D, tile.getReverseZ(i));
                                renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                                GL11.glPopMatrix();
                            }
                        }
                        counter++;
                    }
                }
            }
            if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.WEST) {
                int counter = 0;
                for (int a = 0; a < 5; a++) {
                    for (int i = 0; i < 5; i++) {
                        if (!tile.getSlotStack(counter).isEmpty()) {
                            Item item = tile.getSlotStack(counter).getItem();
                            if (item.equals(ModItems.castingmud)) {
                                GL11.glPushMatrix();
                                GL11.glTranslated(tile.getNormalX(a), 0.0D, tile.getReverseZ(i));
                                renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                                GL11.glPopMatrix();
                            }
                        }
                        counter++;
                    }
                }
            }
            if (state.getValue(CustomContainerFacing.FACING) == EnumFacing.EAST) {
                int counter = 0;
                for (int a = 0; a < 5; a++) {
                    for (int i = 0; i < 5; i++) {
                        if (!tile.getSlotStack(counter).isEmpty()) {
                            Item item = tile.getSlotStack(counter).getItem();
                            if (item.equals(ModItems.castingmud)) {
                                GL11.glPushMatrix();
                                GL11.glTranslated(tile.getReverseX(a), 0.0D, tile.getNormalZ(i));
                                renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                                GL11.glPopMatrix();
                            }
                        }
                        counter++;
                    }
                }
            }


            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
            GL11.glPopMatrix();
        }
    }
}
