package com.kitsu.medievalcraft.item.throwable;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.entity.EntityShit;
import com.kitsu.medievalcraft.entity.EntityShortLivedShit;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShit extends Item {
	
	private String name = "itemShit";
	
	public ItemShit() {
		
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		
	}
	
	@Override
	public boolean hasCustomEntity(ItemStack stack){
		return true;		
	}
	public Entity createEntity(World world, Entity location, ItemStack stack){
		EntityShortLivedShit entity = new EntityShortLivedShit(world, location.posX, location.posY, location.posZ, stack);
		entity.motionX = location.motionX;
		entity.motionY = location.motionY;
		entity.motionZ = location.motionZ;
		
		return entity;		
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	    {

	            --stack.stackSize;


	       world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

	        if (!world.isRemote)
	        {
	            world.spawnEntityInWorld(new EntityShit(world, player));
	        }

	        return stack;
	    }

}
