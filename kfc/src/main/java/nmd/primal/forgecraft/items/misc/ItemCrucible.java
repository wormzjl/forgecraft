package nmd.primal.forgecraft.items.misc;

import net.minecraft.item.Item;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by mminaie on 11/11/17.
 */
public class ItemCrucible extends Item {

    public ItemCrucible(String unlocalizedName) {
        setUnlocalizedName(unlocalizedName);
        this.setRegistryName(unlocalizedName);
        this.setMaxStackSize(1);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setMaxStackSize(1);
        this.setNoRepair();
    }

    /*@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn)
    {
        if(!item.isEmpty())
        {
            if (item.hasTagCompound())
            {
                NonNullList<ItemStack> ingList = NonNullList.<ItemStack>withSize(5, ItemStack.EMPTY);
                NBTTagCompound nbtTag = item.getSubCompound("Items");
                ItemStackHelper.loadAllItems(nbtTag, ingList);
                tooltip.add(ChatFormatting.BLUE + "Items:" + ingList.get(0));

                /*tooltip.add(ChatFormatting.GRAY + "Upgrades Left: " + (3 - getModifiers(item)) );
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
            }
        }
    }*/

}
