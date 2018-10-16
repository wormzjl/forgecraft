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
import nmd.primal.forgecraft.util.WeaponNBT;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by mminaie on 3/9/17.
 */
public class WeaponPart extends Item implements WeaponNBT {

    private ToolMaterial toolMaterial;

    public WeaponPart(String name, ToolMaterial material) {
        this.setMaxDamage(material.getMaxUses());
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setMaxStackSize(1);
        this.setNoRepair();

        this.toolMaterial = material;

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

            /***

             smite| bane |  fire | fortune | leech
             X.0  | 0.X  | 0.0X  |  0.00X  | 0.000X

             ***/

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack item, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (item.hasTagCompound()) {
                    Float returnFloat = 0.0F;
                    if(getSmiteLevel(item)>0){
                        returnFloat += 0.1F;
                    }
                    if(getBaneLevel(item)>0){
                        returnFloat += (0.01F * getBaneLevel(item));
                    }
                    if(getFireLevel(item)>0){
                        returnFloat += (0.001F * getFireLevel(item));
                    }
                    if(getFortuneLevel(item)>0){
                        returnFloat += (0.0001F * getFortuneLevel(item));
                    }
                    if(getLeechLevel(item)>0){
                        returnFloat += (0.0001F * getLeechLevel(item));
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

    public ToolMaterial getMaterial() {return toolMaterial;}

    public void createDefaultNBT(ItemStack item){
        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            NBTTagCompound tags = new NBTTagCompound();

            item.getTagCompound().setTag("tags", tags);

            setSmiteLevel(item, 0);
            setBaneLevel(item, 0);
            setFireLevel(item, 0);
            setFortuneLevel(item, 0);
            setLeechLevel(item, 0);
            setSweepingLevel(item, 0);
            setSharpnessLevel(item, 0);
            setModifiers(item, 0);
        }
    }

    @Override
    public void onCreated(ItemStack item, World worldIn, EntityPlayer playerIn) {

        createDefaultNBT(item);

    }


    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn)
    {
        if(item.hasTagCompound())
        {
            tooltip.add(ChatFormatting.GRAY + "Upgrades left: " +  (WeaponNBT.materialModifiers.get(this.toolMaterial) - getModifiers(item)));
            /*if  (getEmerald(item)) {
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
            }*/
        }
    }
}