package nmd.primal.forgecraft.compat.jei.workbench;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.CommonUtils;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.compat.jei.AbstractCategory;
import nmd.primal.forgecraft.init.ModBlocks;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mminaie on 9/16/18.
 */
public class WorkbenchRecipeCategory extends AbstractCategory<WorkbenchRecipeWrapper>
{
    public static String CATEGORY = CommonUtils.prefix("workbench");

    private static ResourceLocation gui_background = new ResourceLocation(ModInfo.MOD_ID,"textures/gui/jei/workbench.png");
    private final IDrawable background;

    public WorkbenchRecipeCategory(IGuiHelper guiHelper)
    {
        //background = guiHelper.createDrawable(gui_background, 0, 0, 134, 144, 0, 0, 0, 0);
        background = guiHelper.createDrawable(gui_background, 0,0,115,39);
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
        return "jei.category.forgecraft.workbench";
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
    public void setRecipe(IRecipeLayout layout, WorkbenchRecipeWrapper recipe, IIngredients ingredients)
    {
        IGuiItemStackGroup items = layout.getItemStacks();

        /***INPUTS***/
        items.init(0, true, 1, 1);
        List<ItemStack> slot0 = Arrays.asList( recipe.toolPart.getMatchingStacks());
        items.set(0,slot0);

        items.init(1, true, 20, 1);
        List<ItemStack> slot1 = Arrays.asList( recipe.toolHead.getMatchingStacks());
        items.set(1,slot1);

        items.init(2, true, 39, 1);
        List<ItemStack> slot2 = Arrays.asList( recipe.toolPin.getMatchingStacks());
        items.set(2,slot2);

        items.init(3, true, 39, 20);
        List<ItemStack> slot3 = Arrays.asList( recipe.takeApart.getMatchingStacks());
        items.set(3,slot3);

        /***OUTPUTS***/
        items.init(4, false, 96, 11);
        items.set(4, recipe.output);

        /***EXTRAS***/
        items.init(5, false, 66, 20);
        ItemStack bench = new ItemStack(Item.getItemFromBlock(ModBlocks.workbench), 1);
        items.set(5, bench);

        items.init(6, false, 66, 1);
        NonNullList<ItemStack> tempDrops = NonNullList.<ItemStack>create();
        tempDrops.add(0, new ItemStack(PrimalAPI.Items.STONE_GALLAGHER, 1));
        tempDrops.add(1, new ItemStack(PrimalAPI.Items.NETHER_GALLAGHER, 1));
        tempDrops.add(2, new ItemStack(PrimalAPI.Items.IRON_GALLAGHER, 1));
        tempDrops.add(3, new ItemStack(PrimalAPI.Items.QUARTZ_GALLAGHER, 1));
        items.set(6, tempDrops);
    }
}