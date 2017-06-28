package com.kitsu.medievalcraft.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityShortLivedShit extends EntityItem {

    public EntityShortLivedShit(World p_i1709_1_, double p_i1709_2_, double p_i1709_4_, double p_i1709_6_)
    {
        super(p_i1709_1_);
    }
	
	public EntityShortLivedShit(World world, double x, double y, double z,ItemStack stack) {
		super(world, x, y, z, stack);
		this.lifespan = 500;
	}
	
	 public EntityShortLivedShit(World world)
	    {
	        super(world);
	    }
	

}
