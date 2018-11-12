package nmd.primal.forgecraft.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.common.helper.RecipeHelper;

import javax.annotation.Nullable;

public class ItemGearbox extends DefaultItemBlock {
    public ItemGearbox(String name, Block block) {
        super(name, block);

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {

                if (stack.hasTagCompound()) {

                    NonNullList<ItemStack> renderList = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
                    if(stack.getSubCompound("BlockEntityTag") != null) {

                        ItemStackHelper.loadAllItems(stack.getSubCompound("BlockEntityTag"), renderList);
                        //System.out.println(renderList);

                        if (RecipeHelper.isOreName(renderList.get(2), "gearboxCoverPrimal")) {
                            return 0.1f;
                        } else {
                            return 0.0F;
                        }
                    }
                }
                return 0.0f;
            }
        });
    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        if(!world.isRemote) {

            if (!item.hasTagCompound()) {
                NonNullList<ItemStack> list = NonNullList.withSize(3, ItemStack.EMPTY);
                item.getOrCreateSubCompound("BlockEntityTag");
                ItemStackHelper.saveAllItems(item.getSubCompound("BlockEntityTag"), list, true);
            }
        }
    }

}
