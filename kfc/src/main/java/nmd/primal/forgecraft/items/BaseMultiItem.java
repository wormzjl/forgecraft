package nmd.primal.forgecraft.items;

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
import nmd.primal.forgecraft.init.ModItems;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by mminaie on 2/19/17.
 */
public class BaseMultiItem extends BaseItem {

    private Item.ToolMaterial mat;

    public BaseMultiItem( String name, Item.ToolMaterial material) {
        super(name);
        mat = material;
        //this.setMaxStackSize(1);
        this.setNoRepair();

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                BaseMultiItem item = (BaseMultiItem) stack.getItem();
                Item itemStack = stack.getItem();
                //TODO get the item name
                if (stack.getItem() instanceof BaseMultiItem) {

                    if(stack.getTagCompound() != null) {
                        /***INGOTS***/
                        if(itemStack.equals(ModItems.ironingotball)) {
                            if (!stack.getTagCompound().getBoolean("hot")) {
                                return 0.0f;
                            }
                            if (stack.getTagCompound().getBoolean("hot")) {
                                return 0.01f;
                            }
                        }
                        if(itemStack.equals(ModItems.bronzeingotball)) {
                            if (!stack.getTagCompound().getBoolean("hot")) {
                                return 0.02f;
                            }
                            if (stack.getTagCompound().getBoolean("hot")) {
                                return 0.03f;
                            }
                        }
                        if(itemStack.equals(ModItems.ironcleaningotball)) {
                            if (!stack.getTagCompound().getBoolean("hot")) {
                                return 0.04f;
                            }
                            if (stack.getTagCompound().getBoolean("hot")) {
                                return 0.05f;
                            }
                        }
                        if(itemStack.equals(ModItems.steelingotball)) {
                            if (!stack.getTagCompound().getBoolean("hot")) {
                                return 0.06f;
                            }
                            if (stack.getTagCompound().getBoolean("hot")) {
                                return 0.07f;
                            }
                        }
                        if(itemStack.equals(ModItems.wootzingotball)) {
                            if (!stack.getTagCompound().getBoolean("hot")) {
                                return 0.08f;
                            }
                            if (stack.getTagCompound().getBoolean("hot")) {
                                return 0.09f;
                            }
                        }
                        /***CHUNKS***/
                        if(itemStack.equals(ModItems.wroughtironchunk)) {
                            if (!stack.getTagCompound().getBoolean("hot")) {
                                return 0.10f;
                            }
                            if (stack.getTagCompound().getBoolean("hot")) {
                                return 0.11f;
                            }
                        }
                        if(itemStack.equals(ModItems.bronzechunk)) {
                            if (!stack.getTagCompound().getBoolean("hot")) {
                                return 0.12f;
                            }
                            if (stack.getTagCompound().getBoolean("hot")) {
                                return 0.13f;
                            }
                        }
                        if(itemStack.equals(ModItems.ironcleanchunk)) {
                            if (!stack.getTagCompound().getBoolean("hot")) {
                                return 0.14f;
                            }
                            if (stack.getTagCompound().getBoolean("hot")) {
                                return 0.15f;
                            }
                        }
                        if(itemStack.equals(ModItems.steelchunk)) {
                            if (!stack.getTagCompound().getBoolean("hot")) {
                                return 0.16f;
                            }
                            if (stack.getTagCompound().getBoolean("hot")) {
                                return 0.17f;
                            }
                        }
                        if(itemStack.equals(ModItems.wootzchunk)) {
                            if (!stack.getTagCompound().getBoolean("hot")) {
                                return 0.18f;
                            }
                            if (stack.getTagCompound().getBoolean("hot")) {
                                return 0.19f;
                            }
                        }
                    }
                }
                return 0.0f;
            }
        });
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn)
    {
        if(!item.isEmpty())
        {
            if (item.hasTagCompound())
            {
                tooltip.add(ChatFormatting.GRAY + "Upgrades: " + item.getTagCompound().getString("upgrades"));
                /*
                tooltip.add(ChatFormatting.GRAY + "Upgrades: " + (3 - getModifiers(item)) );
                if (getEmerald(item) == true) {
                    tooltip.add(ChatFormatting.DARK_GREEN + "Emerald");
                }
                if (getDiamondLevel(item) > 0) {
                    tooltip.add(ChatFormatting.AQUA + "Diamond Level: " + getDiamondLevel(item));
                }
                if (getRedstoneLevel(item) > 0) {
                    tooltip.add(ChatFormatting.RED + "Redstone Level: " + getRedstoneLevel(item) );
                }
                if (getLapisLevel(item) > 0) {
                    tooltip.add(ChatFormatting.BLUE + "Lapis Level: " + getLapisLevel(item) );
                }
                tooltip.add(ChatFormatting.LIGHT_PURPLE + "Damage: " + item.getItemDamage() );
                */
            }
        }
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
    public void onUpdate(ItemStack stack, World world, Entity player, int itemSlot, boolean isSelected) {
        //System.out.println(item.getTagCompound());
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setBoolean("hot", false);
        }
    }

    @Override
    public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem)
    {
        if(entityItem.isWet()){
            if(entityItem.getItem().hasTagCompound()) {
                if(entityItem.getItem().getTagCompound().getBoolean("hot")){
                    entityItem.getItem().getTagCompound().setBoolean("hot", false);
                    entityItem.getEntityWorld().playSound(null, entityItem.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT, 1.0F, PrimalAPI.getRandom().nextFloat() * 0.4F + 0.8F);
                    return true;
                }
            }
        }

        return false;
    }

}
