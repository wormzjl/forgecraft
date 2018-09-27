package nmd.primal.forgecraft.items.tools.bronze;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.init.ModConfig;
import nmd.primal.forgecraft.items.tools.AbstractAxe;
import nmd.primal.forgecraft.util.ToolNBT;

import javax.annotation.Nullable;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mminaie on 6/25/17.
 */
public class BronzeAxe extends AbstractAxe implements ToolNBT {

    Item drop;

    public BronzeAxe(String name, Item.ToolMaterial material, Item damageDrop, Integer damage, Float speed) {
        super(name, material, damageDrop, damage, speed);

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

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


    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        if(!player.world.isRemote){
            World world = player.getEntityWorld();
            //System.out.println(world.getBlockState(pos).getBlock());
            if(itemstack.getItem() instanceof BronzeAxe){
                if( getEmerald(itemstack)){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(33), 1);
                }
                /*if( getDiamondLevel(itemstack) > 0 ){
                    itemstack.getItem().setHarvestLevel("pickaxe", 3);
                }*/
                if ( getLapisLevel(itemstack) > 0) {
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(35), ModConfig.Features.BRONZE_LAPIS_MULTIPLIER);
                }
            }
        }

        return false;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        //return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;

        if(material != Material.WOOD && material != Material.PLANTS && material != Material.VINE){
            return  super.getDestroySpeed(stack, state);
        } else {
            return this.efficiency + 1;
        }

    }

}
