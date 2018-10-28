package nmd.primal.forgecraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nmd.primal.core.api.interfaces.crafting.IDictionaryName;
import nmd.primal.core.common.helper.RegistryHelper;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by kitsu on 11/26/2016.
 */
public class BaseSingleItem extends BaseItem implements IDictionaryName<Item>
{
    public BaseSingleItem(String registryName, int damage)
    {
        super(registryName);
        this.setMaxStackSize(1);
        this.canRepair = false;
        this.setMaxDamage(damage);
    }

    public String getName() {
        return this.getRegistryName().toString();
    }

    public static boolean isHidden()
    {
        return false;
    }

    // ***************************************************************************** //
    //  IDictionaryName
    // ***************************************************************************** //
    private String[] dictionary_names;

    @Override
    public Item setDictionaryNames(String... strings)
    {
        this.dictionary_names = strings;
        return this;
    }

    @Override
    public String[] getDictionaryNames()
    {
        return this.dictionary_names;
    }

    @Override
    public void registerDictionaryNames()
    {
        for (String name : this.getDictionaryNames())
            //RegistryHelper.registerDictionaryNames(new ItemStack(this, 1, OreDictionary.WILDCARD_VALUE), REGISTRY_NAME);
            RegistryHelper.registerDictionaryNames(new ItemStack(this), name);
    }

}