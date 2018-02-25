package nmd.primal.forgecraft.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModItems;

import javax.annotation.Nullable;

/**
 * Created by mminaie on 2/7/18.
 */
public class ItemNBTCrucible extends ItemBlock {
    public ItemNBTCrucible(String name, Block block) {
        super(block);
        //super();
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack item, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                //TODO get the item name
                if (item.hasTagCompound()) {
                    if (getStatus(item)){
                        return 0.1f;
                    }
                } else if (item.hasTagCompound()) {
                    if (!getStatus(item)){
                        return 0.0f;
                    }
                }
                else {
                    return 0.0F;
                }
                return 0.0F;
            }
        });
    }

    public boolean getStatus(ItemStack stack) {
        if(!stack.isEmpty()) {
            if (stack.hasTagCompound()) {
                return stack.getSubCompound("BlockEntityTag").getBoolean("hot");
            }
        }
        return false;
    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        if(!world.isRemote) {
            //System.out.println("We doin it?");
            if (item.hasTagCompound()) {
                //item.setTagCompound(new NBTTagCompound());
                NBTTagCompound tag = item.getSubCompound("BlockEntityTag");

                //item.getTagCompound().setTag("BlockEntityTag", tags);
                System.out.println(tag.getBoolean("hot"));


            }
        }
    }

}
