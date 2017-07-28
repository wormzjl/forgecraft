package com.kitsu.medievalcraft.item.throwable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.entity.EntityTester;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemTester extends Item {

	private String name = "itemTester";

	public ItemTester() {

		setUnlocalizedName(name);
		//setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		GameRegistry.registerItem(this, name);

	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

		--stack.stackSize;

		if (!world.isRemote)
		{
			world.spawnEntityInWorld(new EntityTester(world, player));
		}

		return stack;
	}

}