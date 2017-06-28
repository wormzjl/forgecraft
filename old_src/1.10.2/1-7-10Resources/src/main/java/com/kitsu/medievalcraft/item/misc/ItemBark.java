package com.kitsu.medievalcraft.item.misc;

import net.minecraft.item.Item;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemBark extends Item {
	
	private String name = "itemBark";
	
	public ItemBark () {
		
		super();
		
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		
	}
	
	/*public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		
		int x = Minecraft.getMinecraft().objectMouseOver.blockX;
		int y = Minecraft.getMinecraft().objectMouseOver.blockY;
		int z = Minecraft.getMinecraft().objectMouseOver.blockZ;
		System.out.println(world.getBlock(x, y, z));
		
		return super.onItemRightClick(stack, world, player);
	}*/
    
}
