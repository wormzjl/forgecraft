/*package com.kitsu.medievalcraft.item;

import com.kitsu.medievalcraft.CustomTab;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemClayFormBook extends ItemEditableBook {
	private String name = "clayFormBook";
	
	public ItemClayFormBook() 
	{
		super();
		setCreativeTab(CustomTab.MedievalCraftTab);
		this.setUnlocalizedName(name);
		LanguageRegistry.addName(this, name);
		this.setTextureName(name);
		this.setMaxStackSize(1);
		
		GameRegistry.registerItem(this, name);
	}

	private NBTTagList putTableOfContents(NBTTagList bookTagList) {
	       // Create NBT data and add to the book
	       NBTTagCompound tag = new NBTTagCompound();
	       
	       NBTTagList bookPages = new NBTTagList();
	       
	       bookTagList.appendTag(new NBTTagString("Test Book"));

		return bookTagList;
	}
	
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int unknownInt, boolean unknownBool)
	{
		NBTTagList bookTagList = new NBTTagList();
		
		bookTagList = putTableOfContents(bookTagList);
	       itemStack.setTagInfo("pages", bookTagList);
	       itemStack.setTagInfo("author", new NBTTagString("delpi"));
	       itemStack.setTagInfo("title", new NBTTagString("Cloth Uses"));

	}
}

/*
@Override
public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player) {
	//stack = new ItemStack(ModItems.clayFormBook);
	  player.displayGUIBook(stack);

	return super.onItemRightClick(stack, world, player);	
}*/