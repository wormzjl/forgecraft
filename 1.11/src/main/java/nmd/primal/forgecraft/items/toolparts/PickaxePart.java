package nmd.primal.forgecraft.items.toolparts;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * Created by mminaie on 3/11/17.
 */
public class PickaxePart extends ToolPart {

    /***

     Hot . Emerald . Diamond . Redstone . lapis

     ***/

    public PickaxePart(String name) {
        super(name);

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack item, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (item.hasTagCompound()) {
                    if (item.getTagCompound().getBoolean("hot") == true) {
                        return 1.0F;
                    }

                    if (item.getTagCompound().getBoolean("hot") == false) {
                        if (item.getTagCompound().getInteger("modifiers") == 0) {
                            return 0.0F;
                        }
                    }

                    if (item.getTagCompound().getBoolean("hot") == false) {
                        if (item.getTagCompound().getInteger("modifiers") != 0) {
                            if ((item.getTagCompound().getBoolean("emerald") == true) &&
                                    (item.getTagCompound().getInteger("diamond") == 0) &&
                                    (item.getTagCompound().getInteger("redstone") == 0) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.1F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == true) &&
                                    (item.getTagCompound().getInteger("diamond") == 1) &&
                                    (item.getTagCompound().getInteger("redstone") == 0) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.11F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == true) &&
                                    (item.getTagCompound().getInteger("diamond") == 2) &&
                                    (item.getTagCompound().getInteger("redstone") == 0) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.12F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == true) &&
                                    (item.getTagCompound().getInteger("diamond") == 1) &&
                                    (item.getTagCompound().getInteger("redstone") == 1) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.111F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == true) &&
                                    (item.getTagCompound().getInteger("diamond") == 0) &&
                                    (item.getTagCompound().getInteger("redstone") == 2) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.102F;
                            }

                            // ============

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 1) &&
                                    (item.getTagCompound().getInteger("redstone") == 0) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.01F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 2) &&
                                    (item.getTagCompound().getInteger("redstone") == 0) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.02F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 3) &&
                                    (item.getTagCompound().getInteger("redstone") == 0) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.03F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 0) &&
                                    (item.getTagCompound().getInteger("redstone") == 1) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.001F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 0) &&
                                    (item.getTagCompound().getInteger("redstone") == 2) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.002F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 0) &&
                                    (item.getTagCompound().getInteger("redstone") == 3) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.003F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 0) &&
                                    (item.getTagCompound().getInteger("redstone") == 0) &&
                                    (item.getTagCompound().getInteger("lapis") == 1)) {
                                return 0.0001F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 0) &&
                                    (item.getTagCompound().getInteger("redstone") == 0) &&
                                    (item.getTagCompound().getInteger("lapis") == 2)) {
                                return 0.0002F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 0) &&
                                    (item.getTagCompound().getInteger("redstone") == 0) &&
                                    (item.getTagCompound().getInteger("lapis") == 3)) {
                                return 0.0003F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 1) &&
                                    (item.getTagCompound().getInteger("redstone") == 1) &&
                                    (item.getTagCompound().getInteger("lapis") == 1)) {
                                return 0.0111F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 2) &&
                                    (item.getTagCompound().getInteger("redstone") == 1) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.021F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 1) &&
                                    (item.getTagCompound().getInteger("redstone") == 2) &&
                                    (item.getTagCompound().getInteger("lapis") == 0)) {
                                return 0.012F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 0) &&
                                    (item.getTagCompound().getInteger("redstone") == 1) &&
                                    (item.getTagCompound().getInteger("lapis") == 2)) {
                                return 0.012F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 0) &&
                                    (item.getTagCompound().getInteger("redstone") == 1) &&
                                    (item.getTagCompound().getInteger("lapis") == 2)) {
                                return 0.0012F;
                            }

                            if ((item.getTagCompound().getBoolean("emerald") == false) &&
                                    (item.getTagCompound().getInteger("diamond") == 1) &&
                                    (item.getTagCompound().getInteger("redstone") == 0) &&
                                    (item.getTagCompound().getInteger("lapis") == 2)) {
                                return 0.0102F;
                            }
                        }
                    }
                }
                return 0.0F;
            }
        });

    }

    @Override
    public void onCreated(ItemStack item, World worldIn, EntityPlayer playerIn) {

        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            item.getTagCompound().setBoolean("hot", false);

            item.getTagCompound().setBoolean("emerald", false);
            item.getTagCompound().setInteger("diamond", 0);
            item.getTagCompound().setInteger("redstone", 0);
            item.getTagCompound().setInteger("lapis", 0);

            item.getTagCompound().setInteger("modifiers", 0);
        }

    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            item.getTagCompound().setBoolean("hot", false);

            item.getTagCompound().setBoolean("emerald", false);
            item.getTagCompound().setInteger("diamond", 0);
            item.getTagCompound().setInteger("redstone", 0);
            item.getTagCompound().setInteger("lapis", 0);

            item.getTagCompound().setInteger("modifiers", 0);
        }
    }


}
