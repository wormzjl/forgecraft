package nmd.primal.forgecraft.items.tools;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.util.ToolNBT;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mminaie on 3/20/17.
 */
public class CustomAxe extends AbstractAxe implements ToolNBT {

    Item drop;

    public CustomAxe(String name, Item.ToolMaterial material, Item damageDrop, Integer damage, Float speed) {
        super(name, material, damageDrop, damage, speed);
        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

            /***

             hot . emerald . diamond . redstone . lapis
             0  .    0    .    0    .     0    .   0

             ***/

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack item, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (item.hasTagCompound()) {



                        if (getHot(item) != true) {
                            if (getModifiers(item) != 0) {
                                if ((getEmerald(item) == true) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.1F;
                                }

                                if ((getEmerald(item) == true) &&
                                        (getDiamondLevel(item) == 1) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.11F;
                                }

                                if ((getEmerald(item) == true) &&
                                        (getDiamondLevel(item) == 2) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.12F;
                                }

                                if ((getEmerald(item) == true) &&
                                        (getDiamondLevel(item) == 1) &&
                                        (getRedstoneLevel(item) == 1) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.111F;
                                }

                                if ((getEmerald(item) == true) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 2) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.102F;
                                }

                                // ============

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 1) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.01F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 2) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.02F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 3) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.03F;
                                }

                                //=======

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 1) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.001F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 2) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.002F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 3) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.003F;
                                }

                                //=========

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 1)) {
                                    return 0.0001F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 2)) {
                                    return 0.0002F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 3)) {
                                    return 0.0003F;
                                }

                                //=======

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 1) &&
                                        (getRedstoneLevel(item) == 1) &&
                                        (getLapisLevel(item) == 1)) {
                                    return 0.0111F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 2) &&
                                        (getRedstoneLevel(item) == 1) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.021F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 1) &&
                                        (getRedstoneLevel(item) == 2) &&
                                        (getLapisLevel(item) == 0)) {
                                    return 0.012F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 1) &&
                                        (getLapisLevel(item) == 2)) {
                                    return 0.0012F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 0) &&
                                        (getRedstoneLevel(item) == 2) &&
                                        (getLapisLevel(item) == 1)) {
                                    return 0.0021F;
                                }

                                if ((getEmerald(item) == false) &&
                                        (getDiamondLevel(item) == 1) &&
                                        (getRedstoneLevel(item) == 0) &&
                                        (getLapisLevel(item) == 2)) {
                                    return 0.0102F;
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

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        if(!player.world.isRemote){
            World world = player.getEntityWorld();
            if(itemstack.getItem() instanceof CustomAxe){
                if( getEmerald(itemstack)){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(33), 1);
                }
                if( getDiamondLevel(itemstack) > 0 ){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(34), getDiamondLevel(itemstack));
                    //itemstack.getItem().setHarvestLevel("pickaxe", 3);
                }
                if( getRedstoneLevel(itemstack) > 0 ){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(32), getRedstoneLevel(itemstack));
                    //System.out.println(itemstack.getEnchantmentTagList());
                }
                if ( getLapisLevel(itemstack) > 0) {
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(35), getLapisLevel(itemstack));
                }
            }
        }
        return false;
    }
}
