package nmd.primal.forgecraft.compat.JEI.anvil;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import nmd.primal.core.common.helper.CommonUtils;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.compat.JEI.AbstractCategory;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 9/16/18.
 */
public class AnvilRecipeCategory extends AbstractCategory<AnvilRecipeWrapper>
{
    public static String CATEGORY = CommonUtils.prefix("anvil");

    private static ResourceLocation gui_background = new ResourceLocation(ModInfo.MOD_ID,"textures/gui/jei/anvil.png");
    private final IDrawable background;

    public AnvilRecipeCategory(IGuiHelper guiHelper)
    {
        //background = guiHelper.createDrawable(gui_background, 0, 0, 134, 144, 0, 0, 0, 0);
        background = guiHelper.createDrawable(gui_background, 0,0,160,96);
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
        return I18n.format("jei.category.forgecraft.anvil");
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
    public void setRecipe(IRecipeLayout layout, AnvilRecipeWrapper recipe, IIngredients ingredients)
    {
        IGuiItemStackGroup items = layout.getItemStacks();

        /***INPUTS***/
        items.init(0, true, 1, 1);
        items.init(1, true, 20, 1);
        items.init(2, true, 39, 1);
        items.init(3, true, 58, 1);
        items.init(4, true, 77, 1);

        items.init(5, true, 1, 20);
        items.init(6, true, 20, 20);
        items.init(7, true, 39, 20);
        items.init(8, true, 58, 20);
        items.init(9, true, 77, 20);

        items.init(10, true, 1, 39);
        items.init(11, true, 20, 39);
        items.init(12, true, 39, 39);
        items.init(13, true, 58, 39);
        items.init(14, true, 77, 39);

        items.init(15, true, 1, 58);
        items.init(16, true, 20, 58);
        items.init(17, true, 39, 58);
        items.init(18, true, 58, 58);
        items.init(19, true, 77, 58);

        items.init(20, true, 1, 77);
        items.init(21, true, 20, 77);
        items.init(22, true, 39, 77);
        items.init(23, true, 58, 77);
        items.init(24, true, 77, 77);

        //items.set(0, recipe.getIngredient(0));

        for(int i =0; i < 25; i++){
            items.set(i, recipe.getIngredient(i));
        }

        /***OUTPUTS***/
        items.init(25, false, 133, 40);
        items.set(25, recipe.output);

        /***EXTRAS***/
        items.init(26, false, 105, 28);
        ItemStack hammerStack = new ItemStack(ModItems.forgehammer, 1);
        items.set(26, hammerStack);

        //items.init(7, false, 58, 96);
        //ItemStack bloomeryStack = new ItemStack(ModBlocks.bloomery_brick, 1, 0);
        //items.set(7, bloomeryStack);
    }
}