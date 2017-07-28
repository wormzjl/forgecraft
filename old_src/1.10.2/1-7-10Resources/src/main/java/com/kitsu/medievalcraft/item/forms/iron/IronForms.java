package com.kitsu.medievalcraft.item.forms.iron;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class IronForms extends Item {
	
	protected IronForms(String name, Item item){
		setMaxStackSize(1);
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		setMaxDamage(64);
		setNoRepair();
		item = this;
		GameRegistry.registerItem(this, name);
	}
	
	 @Override
	    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
	        return false;
	    }
	    
	    @Override
	    public Item getContainerItem()
	    {
	        this.setDamage(new ItemStack(this), +1);
	        return this;
	    }

	    public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_)
	    {
	        return false;
	    }

}
