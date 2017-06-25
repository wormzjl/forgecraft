package nmd.primal.forgecraft.items.parts;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.util.ToolNBT;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by mminaie on 3/9/17.
 */
public class BronzeToolPart extends Item implements ToolNBT{

    private int ID;

    public BronzeToolPart(String name, ToolMaterial material, Integer ID) {
        this.setMaxDamage(material.getMaxUses());
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        //this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setMaxStackSize(1);
        this.setNoRepair();

        this.ID = ID;

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter()
        {

            /***

             hot . emerald . diamond . redstone . lapis
             0  .    0    .    0    .     0    .   0

             ***/

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack item, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (item.hasTagCompound()) {


                    if (getModifiers(item) != 0) {
                        if (getEmerald(item)) {
                            return 0.1F;
                        }

                        if (getDiamondLevel(item) == 1) {
                            return 0.2F;
                        }

                        if ( getRedstoneLevel(item) == 1) {
                            return 0.3F;
                        }

                        if (getLapisLevel(item) == 1) {
                            return 0.4F;
                        }
                    }
                    if (getModifiers(item) == 0) {
                        return 0.0F;
                    }
                }
                return 0.0F;
            }
        });

    }

    public static boolean isHidden()
    {
        return false;
    }

    public int getID() {
        return ID;
    }

    @Override
    public void onCreated(ItemStack item, World worldIn, EntityPlayer playerIn) {

        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            NBTTagCompound tags = new NBTTagCompound();

            item.getTagCompound().setTag("tags", tags);

            setHot(item, false);
            setEmerald(item, false);
            setDiamondLevel(item, 0);
            setRedstoneLevel(item, 0);
            setLapisLevel(item, 0);
            setModifiers(item, 0);
        }

    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            NBTTagCompound tags = new NBTTagCompound();

            item.getTagCompound().setTag("tags", tags);

            setHot(item, false);
            setEmerald(item, false);
            setDiamondLevel(item, 0);
            setRedstoneLevel(item, 0);
            setLapisLevel(item, 0);
            setModifiers(item, 0);
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
        if(player.getEntityWorld().isRemote) {

            if(item.hasTagCompound()) {

                tooltip.add(ChatFormatting.GRAY + "Upgrades");
                if  (getEmerald(item) == true) {
                    tooltip.add(ChatFormatting.DARK_GREEN + "Emerald");
                }
                if (getDiamondLevel(item) > 0) {
                    tooltip.add(ChatFormatting.AQUA + "Diamond Level: " + getDiamondLevel(item));
                }
                if (getRedstoneLevel(item) > 0) {
                    tooltip.add(ChatFormatting.RED + "Redstone Level: " + getRedstoneLevel(item));
                }
                if (getLapisLevel(item) > 0) {
                    tooltip.add(ChatFormatting.BLUE + "Lapis Level: " + getLapisLevel(item));
                }
            }
        }
    }




}
