package nmd.primal.forgecraft.items;

import net.minecraft.item.Item;

/**
 * Created by mminaie on 2/19/17.
 */
public class BaseMultiItem extends BaseItem {

    private Item.ToolMaterial mat;
    private int ID;

    public BaseMultiItem( String registryName, Item.ToolMaterial material, Integer ID) {
        setUnlocalizedName(registryName);
        setRegistryName(registryName);
        mat = material;
        this.ID = ID;

    }

    public Item.ToolMaterial getMaterial(Item item){
        return mat;
    }

    public int getID() {
        return ID;
    }
}
