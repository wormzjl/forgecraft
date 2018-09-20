package nmd.primal.forgecraft.compat.JEI.crucible;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.*;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import nmd.primal.core.common.helper.CommonUtils;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.compat.JEI.AbstractCategory;
import nmd.primal.forgecraft.init.ModBlocks;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 9/13/18.
 */
public class CrucibleRecipeCategory extends AbstractCategory<CrucibleRecipeWrapper>
{
    public static String CATEGORY = CommonUtils.prefix("crucible");

    private static ResourceLocation gui_background = new ResourceLocation(ModInfo.MOD_ID,"textures/gui/jei/crucible.png");
    private final IDrawable background;

    public CrucibleRecipeCategory(IGuiHelper guiHelper)
    {
        //background = guiHelper.createDrawable(gui_background, 0, 0, 134, 144, 0, 0, 0, 0);
        background = guiHelper.createDrawable(gui_background, 0,0,160,134);
    }

    @Nonnull
    @Override
    public String getUid()
    {
        return CATEGORY;
    }

    @Nonnull
    @Override
    public String getTitle()
    {
        return I18n.format("jei.category.forgecraft.crucible");
    }

    @Nonnull
    @Override
    public IDrawable getBackground()
    {
        return background;
    }

    @Override
    public void drawExtras(@Nonnull Minecraft minecraft)
    {
        //progress.draw(minecraft, 67, 18);
    }

    @Override
    public void setRecipe(IRecipeLayout layout, CrucibleRecipeWrapper recipe, IIngredients ingredients)
    {
        IGuiItemStackGroup items = layout.getItemStacks();

        /***INPUTS***/
        items.init(0, true, 1, 77);
        items.init(1, true, 1, 58);
        items.init(2, true, 1, 39);
        items.init(3, true, 1, 20);
        items.init(4, true, 1, 1);


        //items.set(0, recipe.getIngredient(0));
        items.set(0, recipe.getIngredient(0));
        items.set(1, recipe.getIngredient(1));
        items.set(2, recipe.getIngredient(2));
        items.set(3, recipe.getIngredient(3));
        items.set(4, recipe.getIngredient(4));

        /***OUTPUTS***/
        items.init(5, false, 115, 96);
        items.set(5, recipe.dropsCooked);

        /***EXTRAS***/
        items.init(6, false, 1, 96);
        ItemStack crucibleStack = new ItemStack(ModBlocks.nbtCrucible, 1, 0);
        items.set(6, crucibleStack);

        items.init(7, false, 58, 96);
        ItemStack bloomeryStack = new ItemStack(ModBlocks.bloomery_brick, 1, 0);
        items.set(7, bloomeryStack);
    }
}