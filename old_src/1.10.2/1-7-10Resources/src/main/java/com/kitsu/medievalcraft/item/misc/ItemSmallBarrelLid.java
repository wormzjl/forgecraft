package com.kitsu.medievalcraft.item.misc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemSmallBarrelLid extends Item {
	
	private String name = "itemSmallBarrelLid";
	
	public ItemSmallBarrelLid () {
		
		super();
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_){
		
			if((world.getBlock(x, y+1, z).equals(Blocks.air))&&(world.getBlock(x, y, z)!=ModBlocks.smallBarrelLid)){
				if(!world.isRemote){
				world.setBlock(x, y+1, z, ModBlocks.smallBarrelLid, 0, 2);
				}
				//System.out.println(world.getTileEntity(x, y+1, z));
				player.inventory.decrStackSize(player.inventory.currentItem, 1);
				return true;
		}
		return false;
	}
    
}