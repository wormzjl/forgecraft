package nmd.primal.forgecraft.renders.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.blocks.machine.Forge;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.BaseMultiItem;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.tiles.TileForge;
import org.lwjgl.opengl.GL11;

/**
 * Created by kitsu on 12/4/2016.
 */
public class TileForgeRender extends TileEntitySpecialRenderer<TileForge>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    @Override
    public void render(TileForge tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        if (state.getBlock() instanceof Forge) {

            GL11.glPushMatrix();
            GL11.glTranslated(x + 0.5D, y + 0.95D, z + 0.5D);
            //GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float prevLGTX = OpenGlHelper.lastBrightnessX;
            float prevLGTY = OpenGlHelper.lastBrightnessY;

            int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

            ItemStack stack0 = tile.getSlotStack(0);

            boolean is_block = stack0.getItem() instanceof ItemBlock;
            float scale = is_block ? 0.1725F : 0.3F;
            double xTrans = is_block ? -1.6D : -0.45D;
            double yTrans = is_block ? -1.26D : 0.75D;

            if (!stack0.isEmpty()) {
                int stackRotation = stack0.getCount();
                GL11.glPushMatrix();
                GL11.glScalef(scale, scale, scale);
                GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                renderItem.renderItem(stack0, renderItem.getItemModelMesher().getItemModel(stack0));
                GL11.glPopMatrix();
                for (int i = 0; i < Math.ceil(stackRotation / 8) + 1; i++) {
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotated(45.0F * i, 0.0F, 1.0F, 0.0F);
                    GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslated(xTrans, yTrans, 0.0D);
                    renderItem.renderItem(stack0, renderItem.getItemModelMesher().getItemModel(stack0));
                    GL11.glPopMatrix();
                }
            }

            if (state.getValue(Forge.FACING) == EnumFacing.NORTH) {
                //float tempScale = 0.8F;
                GL11.glScalef(0.8F, 0.8F, 0.8F);
                GL11.glTranslated(-0.3F, 0.1D, -0.7D);
                int counter = 1;
                for (int i = 0; i < tile.getArraySize(); i++) {
                    for (int a = 0; a < tile.getArraySize(); a++) {
                        if (!tile.getSlotStack(counter).isEmpty()) {
                            Item item = tile.getSlotStack(counter).getItem();

                            if (item instanceof ToolPart ) {
                                GL11.glPushMatrix();
                                double tempScale = 1.0D;
                                GL11.glScaled(tempScale, tempScale, tempScale);
                                GL11.glTranslated(tile.getNormalX(a), 0.0D, tile.getNormalZ(i));
                                renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                                GL11.glPopMatrix();
                            }
                            if (item instanceof BaseMultiItem) {
                                GL11.glPushMatrix();
                                double tempScale = 1.0D;
                                GL11.glScaled(tempScale, tempScale, tempScale);
                                GL11.glTranslated(tile.getNormalX(a), -0.0625D, tile.getNormalZ(i));
                                renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                                GL11.glPopMatrix();
                            }
                        }
                        counter++;
                    }
                }
            }

            if (state.getValue(Forge.FACING) == EnumFacing.SOUTH) {
                //float tempScale = 0.8F;
                GL11.glScalef(0.8F, 0.8F, 0.8F);
                GL11.glTranslated(-0.3F, 0.1D, -0.7D);
                int counter = 1;
                for (int i = 0; i < tile.getArraySize(); i++) {
                    for (int a = 0; a < tile.getArraySize(); a++) {
                        if (!tile.getSlotStack(counter).isEmpty()) {
                            Item item = tile.getSlotStack(counter).getItem();

                            if (item instanceof ToolPart ) {
                                GL11.glPushMatrix();
                                double tempScale = 1.0D;
                                GL11.glScaled(tempScale, tempScale, tempScale);
                                GL11.glTranslated(tile.getReverseX(a), 0.0D, tile.getReverseZ(i));
                                renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                                GL11.glPopMatrix();
                            }
                            if (item instanceof BaseMultiItem) {
                                GL11.glPushMatrix();
                                double tempScale = 1.0D;
                                GL11.glScaled(tempScale, tempScale, tempScale);
                                GL11.glTranslated(tile.getReverseX(a), -0.0625D, tile.getReverseZ(i));
                                renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                                GL11.glPopMatrix();
                            }

                        }
                        counter++;
                    }
                }
            }

            if (state.getValue(Forge.FACING) == EnumFacing.WEST) {
                //float tempScale = 0.8F;
                GL11.glScalef(0.8F, 0.8F, 0.8F);
                GL11.glTranslated(-0.3F, 0.1D, -0.7D);
                int counter = 1;
                for (int a = 0; a < tile.getArraySize(); a++) {
                    for (int i = 0; i < tile.getArraySize(); i++) {
                        if (!tile.getSlotStack(counter).isEmpty()) {
                            Item item = tile.getSlotStack(counter).getItem();
                            if (item instanceof ToolPart ) {
                                GL11.glPushMatrix();
                                double tempScale = 1.0D;
                                GL11.glScaled(tempScale, tempScale, tempScale);
                                GL11.glTranslated(tile.getNormalX(a), 0.0D, tile.getReverseZ(i));
                                renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                                GL11.glPopMatrix();
                            }
                            if (item instanceof BaseMultiItem) {
                                GL11.glPushMatrix();
                                double tempScale = 1.0D;
                                GL11.glScaled(tempScale, tempScale, tempScale);
                                GL11.glTranslated(tile.getNormalX(a), -0.0625D, tile.getReverseZ(i));
                                renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                                GL11.glPopMatrix();
                            } else {

                            }

                        }
                        counter++;
                    }
                }
            }

            if (state.getValue(Forge.FACING) == EnumFacing.EAST) {
                //float tempScale = 0.8F;
                GL11.glScalef(0.8F, 0.8F, 0.8F);
                GL11.glTranslated(-0.3F, 0.1D, -0.7D);
                int counter = 1;
                for (int a = 0; a < tile.getArraySize(); a++) {
                    for (int i = 0; i < tile.getArraySize(); i++) {
                        if (!tile.getSlotStack(counter).isEmpty()) {
                            Item item = tile.getSlotStack(counter).getItem();
                            if (item instanceof ToolPart ) {
                                GL11.glPushMatrix();
                                double tempScale = 1.0D;
                                GL11.glScaled(tempScale, tempScale, tempScale);
                                GL11.glTranslated(tile.getReverseX(a), 0.0D, tile.getNormalZ(i));
                                renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                                GL11.glPopMatrix();
                            }
                            if (item instanceof BaseMultiItem) {
                                GL11.glPushMatrix();
                                double tempScale = 1.0D;
                                GL11.glScaled(tempScale, tempScale, tempScale);
                                GL11.glTranslated(tile.getReverseX(a), -0.0625D, tile.getNormalZ(i));
                                renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                                GL11.glPopMatrix();
                            } else {

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