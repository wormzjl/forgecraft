package nmd.primal.forgecraft.crafting;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;
import nmd.primal.core.api.interfaces.ICustomRecipe;
import nmd.primal.forgecraft.ModInfo;

import java.util.Collection;

/**
 * Created by mminaie on 9/15/18.
 */
public abstract class AbstractCrafting <RECIPE extends IForgeRegistryEntry.Impl<RECIPE>> extends IForgeRegistryEntry.Impl<RECIPE> implements ICustomRecipe<RECIPE>
{
    private boolean is_disabled, is_hidden;

    public AbstractCrafting()
    {
        this.is_disabled = false;
        this.is_hidden = false;
    }

    abstract public Collection<RECIPE> getRecipes();

    // ***************************************************************************** //
    //  Disable/Hidden Recipe controls
    // ***************************************************************************** //
    @Override
    public RECIPE setDisabled(boolean is_disabled)
    {
        this.is_disabled = is_disabled;
        return (RECIPE) this;
    }

    @Override
    public RECIPE setHidden(boolean is_hidden)
    {
        this.is_hidden = is_hidden;
        return (RECIPE) this;
    }

    @Override
    public boolean isDisabled()
    {
        return this.is_disabled;
    }

    @Override
    public boolean isHidden()
    {
        return this.is_hidden;
    }

    // ***************************************************************************** //
    //  Helper Methods
    // ***************************************************************************** //
    public static ResourceLocation getFullRecipeName(String prefix, String name)
    {
        return getFullRecipeName(ModInfo.MOD_ID, prefix, name);
    }

    public static ResourceLocation getFullRecipeName(String id, String prefix, String name)
    {
        return new ResourceLocation(id, prefix + "_" + name);
    }

    // ***************************************************************************** //
    //  ..
    // ***************************************************************************** //
}