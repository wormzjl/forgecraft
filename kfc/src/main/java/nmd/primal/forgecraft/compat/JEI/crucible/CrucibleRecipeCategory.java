package nmd.primal.forgecraft.compat.JEI.crucible;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.*;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import nmd.primal.core.common.compat.jei.AbstractCategory;
import nmd.primal.core.common.helper.CommonUtils;
import nmd.primal.core.common.init.ModInfo;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 9/13/18.
 */
public class CrucibleRecipeCategory extends AbstractCategory<CrucibleRecipeWrapper>
{
    public static String CATEGORY = CommonUtils.prefix("crucible");

    private static ResourceLocation gui_background = new ResourceLocation(ModInfo.MOD_ID,"textures/gui/jei/cauldron.png");
    private static ResourceLocation gui_progress = new ResourceLocation(ModInfo.MOD_ID,"textures/gui/jei/cauldron_progress.png");
    private final IDrawable background;
    private final IDrawableAnimated progress;

    public CrucibleRecipeCategory(IGuiHelper guiHelper)
    {
        background = guiHelper.createDrawable(gui_background, 0, 0, 160, 60, 0, 0, 0, 0);

        IDrawableStatic progressDrawable = guiHelper.createDrawable(gui_progress, -14, -1, 24, 52);
        progress = guiHelper.createAnimatedDrawable(progressDrawable, 200, IDrawableAnimated.StartDirection.BOTTOM, false);
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
        progress.draw(minecraft, 67, 18);
    }

    @Override
    public void setRecipe(IRecipeLayout layout, CrucibleRecipeWrapper recipe, IIngredients ingredients)
    {
        //IGuiFluidStackGroup fluids = layout.getFluidStacks();
        IGuiItemStackGroup items = layout.getItemStacks();

        //  input fluid
        //fluids.init(0, true, 6, 8, 13, 48, 4000, true, null);
        //fluids.set(ingredients);

        //  output_items fluid
        //if (recipe.output_fluid != null) {
        //fluids.init(1, false, 135, 8, 13, 48, 4000, true, null);
        //fluids.set(ingredients);
        //}

        //  input items
        items.init(0, true, 31, 18);
        items.init(1, true, 50, 18);
        items.init(2, true, 31, 37);
        items.init(3, true, 50, 37);

        //items.set(0, recipe.item_input_1);
        //items.set(1, recipe.item_input_2);
        //items.set(2, recipe.item_input_3);
        //items.set(3, recipe.item_input_4);

        //items.set(0, RecipeHelper.getSlotList(recipe.input_slots, 0));
        //items.set(1, RecipeHelper.getSlotList(recipe.input_slots, 1));
        //items.set(2, RecipeHelper.getSlotList(recipe.input_slots, 2));
        //items.set(3, RecipeHelper.getSlotList(recipe.input_slots, 3));

        //  output_items items
        //if (recipe.output_items != null) {
        items.init(4, false, 104, 18);
        items.set(ingredients);

        items.init(5, false, 104, 37);
        items.set(ingredients);
        //}
    }
}