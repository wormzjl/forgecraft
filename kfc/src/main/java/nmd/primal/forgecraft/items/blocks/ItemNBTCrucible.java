package nmd.primal.forgecraft.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;

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
                if (item.hasTagCompound()) {
                    if (getHot(item) == 0){
                        return 0.0f;
                    }
                    if (getHot(item) == 1){
                        return 0.01f;
                    }
                    if (getHot(item) == 2){
                        return 0.02f;
                    }
                    if (getHot(item) == 3){
                        return 0.03f;
                    }
                    if (getHot(item) == 4){
                        return 0.04f;
                    }
                    if (getHot(item) == 5){
                        return 0.05f;
                    }
                    if (getHot(item) == 6){
                        return 0.06f;
                    }
                    if (getHot(item) == 7){
                        return 0.07f;
                    }
                    if (getHot(item) == 8){
                        return 0.08f;
                    }
                    if (getHot(item) == 9){
                        return 0.09f;
                    }
                    if (getHot(item) == 10){
                        return 0.10f;
                    }
                    if (getHot(item) == 11){
                        return 0.11f;
                    }
                    if (getHot(item) == 12){
                        return 0.12f;
                    }
                    if (getHot(item) == 13){
                        return 0.13f;
                    }
                    if (getHot(item) == 14){
                        return 0.14f;
                    }
                    if (getHot(item) == 15){
                        return 0.15f;
                    } else {
                        return 0.0f;
                    }
                }
                return 0.0F;
            }
        });
    }

    public int getHot(ItemStack stack) {
        if(!stack.isEmpty()) {
            if (stack.hasTagCompound()) {
                return stack.getSubCompound("BlockEntityTag").getInteger("hot");
            }
        }
        return 0;
    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        if(!world.isRemote) {
            //System.out.println("We doin it?");
            if (item.hasTagCompound()) {
                //item.setTagCompound(new NBTTagCompound());
                NBTTagCompound tag = item.getSubCompound("BlockEntityTag");

                //item.getTagCompound().setTag("BlockEntityTag", tags);
                //System.out.println(tag.getBoolean("hot"));


            }
        }
    }



}
