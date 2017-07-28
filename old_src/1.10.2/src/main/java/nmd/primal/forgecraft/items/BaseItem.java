package nmd.primal.forgecraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by kitsu on 11/26/2016.
 */
public class BaseItem extends Item
{
    public BaseItem()
    {
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
    }

    public String getName() {
        return this.getRegistryName().toString();
    }

    public static boolean isHidden()
    {
        return false;
    }

}