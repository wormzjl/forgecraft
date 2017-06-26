package nmd.primal.forgecraft.items;

import net.minecraft.item.Item;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by mminaie on 3/7/17.
 */
public class ForgeHammer extends Item {

    public ForgeHammer(String unlocalizedName) {
        setUnlocalizedName(unlocalizedName);
        this.setRegistryName(unlocalizedName);
        this.setMaxDamage(1000);
        //this.setHasSubtypes(true);  //This just says the item has metadata
        this.setMaxStackSize(1);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);

    }

}
