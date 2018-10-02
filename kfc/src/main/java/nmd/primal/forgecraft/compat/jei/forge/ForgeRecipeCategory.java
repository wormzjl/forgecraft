package nmd.primal.forgecraft.compat.jei.forge;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import nmd.primal.core.common.helper.CommonUtils;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.compat.jei.AbstractCategory;
import nmd.primal.forgecraft.init.ModBlocks;

import javax.annotation.Nonnull;

/**
 * Created by mminaie on 9/16/18.
 */
public class ForgeRecipeCategory extends AbstractCategory<ForgeRecipeWrapper>
{
    public static String CATEGORY = CommonUtils.prefix("forging");

    private static ResourceLocation gui_background = new ResourceLocation(ModInfo.MOD_ID,"textures/gui/jei/forging.png");
    private final IDrawable background;

    public ForgeRecipeCategory(IGuiHelper guiHelper)
    {
        //background = guiHelper.createDrawable(gui_background, 0, 0, 134, 144, 0, 0, 0, 0);
        background = guiHelper.createDrawable(gui_background, 0,0,77,58);
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
        return I18n.format("jei.category.forgecraft.forging");
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
    public void setRecipe(IRecipeLayout layout, ForgeRecipeWrapper recipe, IIngredients ingredients)
    {
        IGuiItemStackGroup items = layout.getItemStacks();

        /***INPUTS***/
        items.init(0, true, 1, 1);
        items.set(0, new ItemStack(recipe.input, 1));

        /***OUTPUTS***/
        items.init(1, false, 58, 20);
        items.set(1, recipe.output);

        /***EXTRAS***/
        items.init(3, false, 1, 20);
        ItemStack forgeStack = new ItemStack(Item.getItemFromBlock(ModBlocks.forge_brick), 1);
        items.set(3, forgeStack);

        //items.init(7, false, 58, 96);
        //ItemStack bloomeryStack = new ItemStack(ModBlocks.bloomery_brick, 1, 0);
        //items.set(7, bloomeryStack);
    }
}