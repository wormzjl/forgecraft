package nmd.primal.forgecraft.items;

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
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.items.blocks.ItemNBTCrucible;
import nmd.primal.forgecraft.items.parts.ToolPart;

import javax.annotation.Nullable;

/**
 * Created by mminaie on 2/19/17.
 */
public class BaseMultiItem extends BaseItem {

    private Item.ToolMaterial mat;

    public BaseMultiItem( String name, Item.ToolMaterial material) {
        super(name);
        mat = material;
        this.setMaxStackSize(1);
        this.setNoRepair();

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                BaseMultiItem item = (BaseMultiItem) stack.getItem();
                //TODO get the item name
                if (stack.getItem() instanceof BaseMultiItem) {
                    if(stack.getTagCompound() != null) {
                        if (!stack.getTagCompound().getBoolean("hot")) {
                            return 0.0f;
                        }
                        if (stack.getTagCompound().getBoolean("hot")) {
                            return 0.1f;
                        }
                    }
                }
                return 0.0f;
            }
        });



    }

    public Item.ToolMaterial getMaterial(Item item){
        return mat;
    }

    @Override
    public void onCreated(ItemStack item, World worldIn, EntityPlayer playerIn) {

        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            item.getTagCompound().setBoolean("hot", false);
        }
    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        //System.out.println(item.getTagCompound());
        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
            item.getTagCompound().setBoolean("hot", false);
        }

    }
}
