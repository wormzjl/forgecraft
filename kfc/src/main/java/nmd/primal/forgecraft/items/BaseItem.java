package nmd.primal.forgecraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nmd.primal.core.api.interfaces.crafting.IDictionaryName;
import nmd.primal.core.common.helper.RegistryHelper;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by kitsu on 11/26/2016.
 */
public class BaseItem extends Item implements IDictionaryName<Item>
{
    public BaseItem(String registryName)
    {
        this.setRegistryName(registryName);
        this.setUnlocalizedName(registryName);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
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