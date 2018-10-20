package nmd.primal.forgecraft.items.parts;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
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

             HOT | SMITE | BANE  |  FIRE  | FORTUNE | leech
             X.0 |  0.X  | 0.0X  | 0.00X  | 0.000X  | 0.0000X

             ***/

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack item, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (item.hasTagCompound()) {
                    Float returnFloat = 0.0F;
                    if(getSmiteLevel(item)>0){
                        returnFloat += 0.1F;
                    }
                    if(getBaneLevel(item)>0){
                        returnFloat += (0.01F);
                    }
                    if(getFireLevel(item)>0){
                        returnFloat += (0.001F);
                    }
                    if(getFortuneLevel(item)>0){
                        returnFloat += (0.0001F);
                    }
                    if(getLeechLevel(item)>0){
                        returnFloat += (0.00001F);
                    }
                    if(getHot(item)){
                        returnFloat += 1.0F;
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



    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        //System.out.println(item.getTagCompound());
        if(!item.hasTagCompound()) {
            WeaponNBT.setDefaultNBT(item);
        }
    }

    @Override
    public void onCreated(ItemStack item, World worldIn, EntityPlayer playerIn) {

        if(!item.hasTagCompound()) {
            WeaponNBT.setDefaultNBT(item);
        }

    }


    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn)
    {
        if(stack.hasTagCompound()) {
            if (stack.getSubCompound("tags") != null) {
                tooltip.add(ChatFormatting.GRAY + "Upgrades left: " + (WeaponNBT.materialModifiers.get(this.toolMaterial) - getModifiers(stack)));
                if (getSmiteLevel(stack) > 0) {
                    tooltip.add(ChatFormatting.GOLD + "Holy: " + getSmiteLevel(stack));
                }
                if (getBaneLevel(stack) > 0) {
                    tooltip.add(ChatFormatting.GREEN + "Spider Killing: " + getBaneLevel(stack));
                }
                if (getFireLevel(stack) > 0) {
                    tooltip.add(ChatFormatting.RED + "Flame: " + getFireLevel(stack));
                }
                if (getFortuneLevel(stack) > 0) {
                    tooltip.add(ChatFormatting.BLUE + "Thieving: " + getFortuneLevel(stack));
                }
                if (getLeechLevel(stack) > 0) {
                    tooltip.add(ChatFormatting.BLACK + "Life Steal: " + getLeechLevel(stack));
                }
                if (getSharpnessLevel(stack) > 0) {
                    tooltip.add(ChatFormatting.WHITE + "Sharpness: " + getSharpnessLevel(stack));
                }
            }
        }
    }
}