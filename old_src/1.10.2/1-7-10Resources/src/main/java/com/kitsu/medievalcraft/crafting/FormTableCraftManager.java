package com.kitsu.medievalcraft.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.kitsu.medievalcraft.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class FormTableCraftManager implements IRecipe{

	private static final FormTableCraftManager instance = new FormTableCraftManager();
    private List recipes = new ArrayList();
    private ItemStack output = null;
    private Object[] input = null;
    private int width = 0;
    private int height = 0;
    private boolean mirrored = true;
    //private static final String __OBFID = "CL_00000090";

    public static final FormTableCraftManager getInstance() {
        return instance;
    }
    
   private FormTableCraftManager () {

	   recipes = new ArrayList();
	   ////////RECIPES////////////////////////////////////////////////////////
	   //EXAMPLE RECIPE
	   //this.addRecipe(new ItemStack(ModItems.longSword, 1), new Object[]{"S", "S", "S", "S", "S", 'S', Items.stick});
	   //this.addRecipe(new ItemStack(ModItems.xxx, 1), new Object[]{"", "", "", "", "", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.pickaxeClayForm, 1), new Object[]{   "ccccc", "cc cc", "c   c", "  c  ", "ccccc", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.spadeHeadClayForm, 1), new Object[]{ "ccccc", "cc cc", "c   c", "c   c", "ccccc", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.hoeHeadClayForm, 1), new Object[]{   "ccccc", "c   c", "c ccc", "ccccc", "ccccc", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.axeHeadClayForm, 1), new Object[]{   "ccccc", "c ccc", "    c", "c ccc", "ccccc", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.longswordClayForm, 1), new Object[]{ "cccc ", "ccc c", "cc cc", "c ccc", " cccc", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.shortswordClayForm, 1), new Object[]{"cc cc", "cc cc", "cc cc", "c   c", "cc cc", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.daggerClayForm, 1), new Object[]{    "ccccc", "cc cc", "cc cc", "cc cc", "ccccc", 'c', Items.clay_ball});
	   //this.addRecipe(new ItemStack(ModItems.halberdClayForm, 1), new Object[]{   "ccccc", "c ccc", "     ", "   cc", "c ccc", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.speartipClayForm, 1), new Object[]{  "ccccc", "cc cc", "cc cc", "c   c", "ccccc", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.maceheadClayForm, 1), new Object[]{  "cc cc", "c   c", "     ", "c   c", "cc cc", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.sharptipClayForm, 1), new Object[]{  "ccccc", "cc cc", "c   c", "ccccc", "ccccc", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.battleaxeClayForm, 1), new Object[]{ "c c c", "     ", "     ", "     ", "c c c", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.ringClayForm, 1), new Object[]{      "ccccc", "cc cc", "c   c", "cc cc", "ccccc", 'c', Items.clay_ball});
	   //this.addRecipe(new ItemStack(ModItems.plateClayForm, 1), new Object[]{     "ccccc", "c   c", "c   c", "c   c", "ccccc", 'c', Items.clay_ball});
	   this.addRecipe(new ItemStack(ModItems.sawbladeClayForm, 1), new Object[]{  "ccccc", "ccccc", "     ", "c    ", "ccccc", 'c', Items.clay_ball});
	   
       Collections.sort(this.recipes, new FormTableRecipeSorter(this));
    }

	public FormTableShapedRecipes addRecipe(ItemStack p_92103_1_, Object ... p_92103_2_)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (p_92103_2_[i] instanceof String[])
        {
            @SuppressWarnings("cast")
			String[] astring = (String[])((String[])p_92103_2_[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (p_92103_2_[i] instanceof String)
            {
                String s2 = (String)p_92103_2_[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < p_92103_2_.length; i += 2)
        {
            Character character = (Character)p_92103_2_[i];
            ItemStack itemstack1 = null;

            if (p_92103_2_[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)p_92103_2_[i + 1]);
            }
            else if (p_92103_2_[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)p_92103_2_[i + 1], 1, 32767);
            }
            else if (p_92103_2_[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)p_92103_2_[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        FormTableShapedRecipes shapedrecipes = new FormTableShapedRecipes(j, k, aitemstack, p_92103_1_);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack p_77596_1_, Object ... p_77596_2_)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = p_77596_2_;
        int i = p_77596_2_.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }
        

        this.recipes.add(new ShapelessRecipes(p_77596_1_, arraylist));
    }


	public ItemStack findMatchingRecipe(InventoryCrafting p_82787_1_, World p_82787_2_)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < p_82787_1_.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = p_82787_1_.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
        {
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;

            if (i1 < 0)
            {
                i1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        }
		for (j = 0; j < this.recipes.size(); ++j)
		{
		    IRecipe irecipe = (IRecipe)this.recipes.get(j);

		    if (irecipe.matches(p_82787_1_, p_82787_2_))
		    {
		        return irecipe.getCraftingResult(p_82787_1_);
		    }
		}

		return null;
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }

	@Override
	public boolean matches(InventoryCrafting p_77569_1_, World p_77569_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting p_77572_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRecipeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getRecipeOutput() {
		// TODO Auto-generated method stub
		return null;
	}
}