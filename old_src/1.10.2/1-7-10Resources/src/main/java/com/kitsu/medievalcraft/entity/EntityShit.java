package com.kitsu.medievalcraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityShit extends EntityThrowable {

	public EntityShit(World world)
	{
		super(world);
	}

	public EntityShit(World world, EntityLivingBase entity)
	{
		super(world, entity);
	}

	//@SideOnly(Side.CLIENT)
	public EntityShit(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}



	@Override
	protected void onImpact(MovingObjectPosition object) {

		if (object.entityHit != null) {

			float impactDamage = 1.0F;

			object.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), impactDamage);	
		}

		for (int i = 0; i < 8; ++i)
		{
			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}

		if (!this.worldObj.isRemote)
		{
			this.setDead();
			//this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(ModItems.itemShit)));
		}

	}



	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}

}
