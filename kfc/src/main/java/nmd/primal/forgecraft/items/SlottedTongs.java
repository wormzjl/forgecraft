package nmd.primal.forgecraft.items;

import net.minecraft.item.Item;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by mminaie on 12/30/17.
 */
public class SlottedTongs extends Item {


    public SlottedTongs(String unlocalizedName) {
        setUnlocalizedName(unlocalizedName);
        this.setRegistryName(unlocalizedName);
        this.setMaxStackSize(1);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
    }

}
