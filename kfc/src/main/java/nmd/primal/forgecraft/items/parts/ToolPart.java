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
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.util.ToolMaterialMap;
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

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

            /***

             hot | emerald | diamond | redstone | lapis
             X.0 |   0.X   |   0.0X  |   0.00X  |  0.000X

             ***/

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack item, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (item.hasTagCompound()) {
                    Float returnFloat = 0.0F;
                    if(getEmerald(item)){
                        returnFloat += 0.1F;
                    }
                    if(getDiamondLevel(item)>0){
                        returnFloat += (0.01F * getDiamondLevel(item));
                    }
                    if(getRedstoneLevel(item)>0){
                        returnFloat += (0.001F * getRedstoneLevel(item));
                    }
                    if(getLapisLevel(item)>0){
                        returnFloat += (0.0001F * getLapisLevel(item));
                    }
                    if(getHot(item)){
                        returnFloat = 1.0F;
                    }
                    return returnFloat;
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

    public void createDefaultNBT(ItemStack item){
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
    public void onCreated(ItemStack item, World worldIn, EntityPlayer playerIn) {

        createDefaultNBT(item);

    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        //System.out.println(item.getTagCompound());
        createDefaultNBT(item);
        if (item.hasTagCompound()) {
            if (item.getSubCompound("tags").getBoolean("hot")) {
                player.setFire(1);
                if (PrimalAPI.randomCheck(10)) {
                    item.getSubCompound("tags").setBoolean("hot", false);
                    player.getEntityWorld().playSound(null, player.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT, 1.0F, PrimalAPI.getRandom().nextFloat() * 0.4F + 0.8F);
                }
            }
        }

    }

    @Override
    public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem)
    {
        if(!entityItem.getEntityWorld().isRemote) {
            if (entityItem.getItem().hasTagCompound()) {
                if (entityItem.isWet()) {

                    if (entityItem.getItem().getTagCompound().getBoolean("hot")) {
                        entityItem.getItem().getTagCompound().setBoolean("hot", false);
                        entityItem.getEntityWorld().playSound(null, entityItem.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT, 1.0F, PrimalAPI.getRandom().nextFloat() * 0.4F + 0.8F);
                        return true;
                    }
                }
            /*
            if (!entityItem.isWet()) {
                if (entityItem.getItem().getTagCompound().getBoolean("hot")) {
                    FireHelper.setFire(entityItem.getEntityWorld(), entityItem.getPosition());
                    return true;
                }
            }*/
                if (PrimalAPI.randomCheck(10)) {
                    if (entityItem.getItem().getTagCompound().getBoolean("hot")) {
                        entityItem.getItem().getSubCompound("tags").setBoolean("hot", false);
                        entityItem.getEntityWorld().playSound(null, entityItem.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT, 1.0F, PrimalAPI.getRandom().nextFloat() * 0.4F + 0.8F);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn)
    {
        if(item.hasTagCompound())
        {
            tooltip.add(ChatFormatting.GRAY + "Upgrades left: " +  (ToolMaterialMap.materialModifiers.get( this.getMaterial()) - getModifiers(item)));
            if  (getEmerald(item)) {
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