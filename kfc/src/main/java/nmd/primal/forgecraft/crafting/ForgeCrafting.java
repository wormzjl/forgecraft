package nmd.primal.forgecraft.crafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

/**
 * Created by mminaie on 2/11/17.
 */
public class ForgeCrafting {

        // ***************************************************************************** //
        //  Recipe Handler ForgeCrafting
        // ***************************************************************************** //
        private static ArrayList<ForgeCrafting> forgeRecipes = new ArrayList<>();

        private Item input;
        private ItemStack output;

        private int heat_threshold;
        private int ideal_time;
        private int cooldown;


        public ForgeCrafting(Item input, ItemStack output, int heat_threshold, int ideal_time, int cooldown, float heat_variance, float time_variance)
        {
            this.input = input;
            this.output = output;
            this.heat_threshold = heat_threshold;
            this.ideal_time = ideal_time;
            this.cooldown = cooldown;

        }

        // ***************************************************************************** //
        //  Recipe Methods
        // ***************************************************************************** //
        public static void addRecipe(Item input, ItemStack output, int heat_threshold, int ideal_time, int cooldown, float heat_variance, float time_variance)
        {
            forgeRecipes.add(new ForgeCrafting(input, output, heat_threshold, ideal_time, cooldown, heat_variance, time_variance));
        }

        public static boolean isRecipeItem(Item item)
        {
            for(ForgeCrafting recipe : forgeRecipes) {
                if (item.equals(recipe.input))
                    return true;
            }
            return false;
        }

        public static ForgeCrafting getRecipe(Item item)
        {
            for(ForgeCrafting recipe : forgeRecipes) {
                if (item.equals(recipe.input))
                    return recipe;
            }
            return null;
        }

        /*public static ForgeCrafting getRecipeFromOutput(Item item)
        {
            for(ForgeCrafting recipe : forgeRecipes) {
                if (item.equals(recipe.output))
                    return recipe;
            }
            return null;
        }*/

        public Item getInput()
        {
            return this.input;
        }

        public ItemStack getOutput() {return this.output; }

        public int getHeatThreshold()
        {
            return this.heat_threshold;
        }

        public int getIdealTime()
        {
            return this.ideal_time;
        }

        public int getCooldown(){ return this.cooldown;}

        ///
        //  end
        ///




}
