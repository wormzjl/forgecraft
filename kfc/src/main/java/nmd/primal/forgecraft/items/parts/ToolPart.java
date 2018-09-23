package nmd.primal.forgecraft.items.parts;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.FireHelper;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.util.ToolNBT;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by mminaie on 3/9/17.
 */
public class ToolPart extends Item implements ToolNBT{

    private String toolType;
    private ToolMaterial toolMaterial;

    public ToolPart(String name, Item.ToolMaterial material, String type) {
        this.setMaxDamage(material.getMaxUses());
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setMaxStackSize(1);
        this.setNoRepair();

        this.toolType = type;
        this.toolMaterial = material;

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

                    if (getHot(item) == false) {
                        if (getModifiers(item) != 0) {
                            if ( (getEmerald(item) == true) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.1F;
                            }

                            if ( (getEmerald(item) == true) &&
                                    (getDiamondLevel(item) == 1) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.11F;
                            }

                            if ( (getEmerald(item) == true) &&
                                    (getDiamondLevel(item) == 2) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.12F;
                            }

                            if ( (getEmerald(item) == true) &&
                                    (getDiamondLevel(item) == 1) &&
                                    (getRedstoneLevel(item) == 1) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.111F;
                            }

                            if ( (getEmerald(item) == true) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 2) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.102F;
                            }

                            // ============

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 1) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.01F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 2) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.02F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 3) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.03F;
                            }

                            //=======

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 1) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.001F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 2) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.002F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 3) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.003F;
                            }

                            //=========

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 1)) {
                                return 0.0001F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 2)) {
                                return 0.0002F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 3)) {
                                return 0.0003F;
                            }

                            //=======

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 1) &&
                                    (getRedstoneLevel(item) == 1) &&
                                    (getLapisLevel(item) == 1)) {
                                return 0.0111F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 2) &&
                                    (getRedstoneLevel(item) == 1) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.021F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 1) &&
                                    (getRedstoneLevel(item) == 2) &&
                                    (getLapisLevel(item) == 0)) {
                                return 0.012F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 1) &&
                                    (getLapisLevel(item) == 2)) {
                                return 0.0012F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 2) &&
                                    (getLapisLevel(item) == 1)) {
                                return 0.0021F;
                            }

                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 1) &&
                                    (getRedstoneLevel(item) == 0) &&
                                    (getLapisLevel(item) == 2) ) {
                                return 0.0102F;
                            }
                            if ( (getEmerald(item) == false) &&
                                    (getDiamondLevel(item) == 0) &&
                                    (getRedstoneLevel(item) == 1) &&
                                    (getLapisLevel(item) == 1) ) {
                                return 0.0011F;
                            }
                        }
                    }
                    if (getHot(item) == true) {
                        return 1.0F;
                    }

                    if (getHot(item) == false) {
                        if (getModifiers(item) == 0) {
                            return 0.0F;
                        }
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

    public String getID() {
        return toolType;
    }
    public ToolMaterial getMaterial() {return toolMaterial;}

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
        //System.out.println(item.getTagCompound());
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
        if (item.hasTagCompound()) {
            if (item.getSubCompound("tags").getBoolean("hot")) {
                player.setFire(1);
                if (PrimalAPI.randomCheck(50)) {
                    item.getSubCompound("tags").setBoolean("hot", false);
                    player.getEntityWorld().playSound(null, player.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT, 1.0F, PrimalAPI.getRandom().nextFloat() * 0.4F + 0.8F);
                }
            }
        }

    }

    @Override
    public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem)
    {
        if(entityItem.isWet()){
            if(entityItem.getItem().hasTagCompound()) {
                if(entityItem.getItem().getTagCompound().getBoolean("hot")){
                    entityItem.getItem().getTagCompound().setBoolean("hot", false);
                    entityItem.getEntityWorld().playSound(null, entityItem.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT, 1.0F, PrimalAPI.getRandom().nextFloat() * 0.4F + 0.8F);
                    return true;
                }
            }
        }
        if(!entityItem.isWet()){
            FireHelper.setFire(entityItem.getEntityWorld(),entityItem.getPosition());
            return true;
        }

        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn)
    {
        if(item.hasTagCompound())
        {
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