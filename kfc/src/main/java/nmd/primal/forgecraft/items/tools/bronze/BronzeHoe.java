package nmd.primal.forgecraft.items.tools.bronze;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.init.ModConfig;
import nmd.primal.forgecraft.items.tools.AbstractHoe;
import nmd.primal.forgecraft.util.ToolNBT;

import javax.annotation.Nullable;

/**
 * Created by mminaie on 3/21/17.
 */
public class BronzeHoe extends AbstractHoe implements ToolNBT {

    public BronzeHoe(String name, ToolMaterial material, Item damageDrop) {
        super(name, material, damageDrop);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        if(!player.world.isRemote){
            World world = player.getEntityWorld();

            if(itemstack.getItem() instanceof BronzeHoe){
                if( getEmerald(itemstack)){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(33), 1);
                }
                /*if( getDiamondLevel(itemstack) > 0 ){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(34), getDiamondLevel(itemstack));
                    itemstack.getItem().setHarvestLevel("pickaxe", 3);
                }*/
                /*if( getRedstoneLevel(itemstack) > 0 ){
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(32), getRedstoneLevel(itemstack));
                    //System.out.println(itemstack.getEnchantmentTagList());
                }*/
                if ( getLapisLevel(itemstack) > 0) {
                    itemstack.addEnchantment(Enchantment.getEnchantmentByID(35), ModConfig.Features.BRONZE_LAPIS_MULTIPLIER);
                }
            }
        }

        return false;
    }

}
