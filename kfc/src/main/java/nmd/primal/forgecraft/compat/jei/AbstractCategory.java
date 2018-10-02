package nmd.primal.forgecraft.compat.jei;

import com.google.common.collect.ImmutableList;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import nmd.primal.forgecraft.ModInfo;

import java.util.List;

/**
 * Created by mminaie on 9/13/18.
 */
public abstract class AbstractCategory<T extends IRecipeWrapper> implements IRecipeCategory<T> {

    @Override
    public String getModName() {
        return ModInfo.MOD_NAME;
    }

    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        return ImmutableList.of();
    }

    @Override
    public IDrawable getIcon() {
        // use the default icon
        return null;
    }
}