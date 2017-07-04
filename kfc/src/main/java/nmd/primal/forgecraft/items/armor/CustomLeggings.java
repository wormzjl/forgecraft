package nmd.primal.forgecraft.items.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by mminaie on 7/3/17.
 */
public class CustomLeggings extends ItemArmor{

    public CustomLeggings(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name) {
        super(materialIn, renderIndexIn, equipmentSlotIn);

        this.setRegistryName(name);
        this.setUnlocalizedName(name);
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
