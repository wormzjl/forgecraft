package nmd.primal.forgecraft.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.oredict.OreDictionary;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.recipes.RecipeHandler;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;

/**
 * Created by mminaie on 11/11/17.
 */
public class CrucibleHandler {

    private static Ingredient crucibleIngredients;

    /***ALLOWED CRUCIBLE ITEMS***/
    //crucibleIngredients.apply(new ItemStack(Blocks.IRON_ORE, 1));

    public static Ingredient getCrucibleIngredients() {
        return crucibleIngredients;
    }

    public static void setCrucibleIngredients(Ingredient crucibleIngredients) {
        crucibleIngredients = crucibleIngredients;
    }

/*

/***RAW CRUCIBLES

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawironcrucible),
                "X","Y",
                        ('X'), "oreIron",
                        ('Y'), ModBlocks.emptycrucible);

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawcleanironcrucible),
                "XL","Y ",
                        ('X'), "dustIron",
                        ('L'), PrimalAPI.Items.CARBONATE_SLACK,
            ('Y'), ModBlocks.emptycrucible);

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawsteelcrucible),
                "XC","Y ",
                        ('X'), new ItemStack(ModBlocks.ironcleanball, 1),
                ('C'), new ItemStack(PrimalAPI.Items.CHARCOAL_HIGH),
                ('Y'), ModBlocks.emptycrucible);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawbronzecrucible),
                "XCX"," X "," Y ",
                        ('X'), "dustCopper",
                        ('C'), "dustTin",
                        ('Y'), ModBlocks.emptycrucible);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawbronzecrucible),
                "XXX"," X "," Y ",
                        ('X'), "nuggetBronze",
                        ('Y'), ModBlocks.emptycrucible);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawbronzecrucible),
                "X","Y",
                        ('X'), new ItemStack(ModItems.bronzepickaxehead, 1,OreDictionary.WILDCARD_VALUE),
                ('Y'), ModBlocks.emptycrucible);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawbronzecrucible),
                "X","Y",
                        ('X'), new ItemStack(ModItems.bronzeaxehead, 1, OreDictionary.WILDCARD_VALUE),
                ('Y'), ModBlocks.emptycrucible);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawbronzecrucible),
                "X","Y",
                        ('X'), new ItemStack(ModItems.bronzeshovelhead, 1, OreDictionary.WILDCARD_VALUE),
                ('Y'), ModBlocks.emptycrucible);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawbronzecrucible),
                "X","Y",
                        ('X'), new ItemStack(ModItems.bronzehoehead, 1, OreDictionary.WILDCARD_VALUE),
                ('Y'), ModBlocks.emptycrucible);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawbronzecrucible),
                "X","Y",
                        ('X'), new ItemStack(ModItems.bronzegladius, 1, OreDictionary.WILDCARD_VALUE),
                ('Y'), ModBlocks.emptycrucible);

        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawbronzecrucible_redstone),
                "R","Y",
                        ('R'), Items.REDSTONE,
            ('Y'), ModBlocks.rawbronzecrucible);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawbronzecrucible_diamond),
                "D","Y",
                        ('D'), PrimalAPI.Items.DIAMOND_KNAPP,
            ('Y'), ModBlocks.rawbronzecrucible);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawbronzecrucible_lapis),
                "L","Y",
                        ('L'), new ItemStack(Items.DYE, 1, 4),
                ('Y'), ModBlocks.rawbronzecrucible);
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawbronzecrucible_emerald),
                "E","Y",
                        ('E'), PrimalAPI.Items.EMERALD_KNAPP,
            ('Y'), ModBlocks.rawbronzecrucible);


        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawbronzecrucible, 1),
                "T", "Y",
                        ('T'), new ItemStack(ModItems.brokenbronzetool, 1),
                ('Y'), new ItemStack(ModBlocks.emptycrucible, 1)
                );
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawironcrucible, 1),
                "T", "Y",
                        ('T'), new ItemStack(ModItems.brokenwroughtirontool, 1),
                ('Y'), new ItemStack(ModBlocks.emptycrucible, 1)
        );
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawcleanironcrucible, 1),
                "T", "Y",
                        ('T'), new ItemStack(ModItems.brokencleanirontool, 1),
                ('Y'), new ItemStack(ModBlocks.emptycrucible, 1)
        );
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawsteelcrucible, 1),
                "T", "Y",
                        ('T'), new ItemStack(ModItems.brokensteeltool, 1),
                ('Y'), new ItemStack(ModBlocks.emptycrucible, 1)
        );
        RecipeHandler.addShapedOreRecipe(new ItemStack(ModBlocks.rawwootzcrucible, 1),
                "T", "Y",
                        ('T'), new ItemStack(ModItems.brokenwootztool, 1),
                ('Y'), new ItemStack(ModBlocks.emptycrucible, 1)
        );

 */

}
