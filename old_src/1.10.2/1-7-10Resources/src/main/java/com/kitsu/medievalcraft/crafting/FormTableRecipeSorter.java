package com.kitsu.medievalcraft.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class FormTableRecipeSorter implements Comparator {

	final FormTableCraftManager formTable;
	
	public FormTableRecipeSorter(FormTableCraftManager ftcraftmanage) {
		this.formTable = ftcraftmanage;
	}
	
	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof FormTableShapelessRecipes && irecipe2 instanceof FormTableShapedRecipes ? 1 : (irecipe2 instanceof FormTableShapelessRecipes && irecipe1 instanceof FormTableShapedRecipes ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}
