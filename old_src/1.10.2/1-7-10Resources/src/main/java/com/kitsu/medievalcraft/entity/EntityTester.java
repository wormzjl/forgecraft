package com.kitsu.medievalcraft.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.item.weapon.ItemHeavyMace;

public class EntityTester extends EntityThrowable {

	private Vec3 vectest;
	private Vec3 vecplayer;


	public EntityTester(World world)
	{
		super(world);
	}

	public EntityTester(World world, EntityLivingBase entity)
	{
		super(world, entity);
	}

	//@SideOnly(Side.CLIENT)
	public EntityTester(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}



	@Override
	protected void onImpact(MovingObjectPosition object) {

		if(Minecraft.getMinecraft().theWorld.difficultySetting.getDifficultyId() == 3){
			if(object.entityHit != null){
				if((ItemHeavyMace.attack == true)){
					vecplayer = ItemHeavyMace.vecp;
					vectest = vectest.createVectorHelper(object.entityHit.posX, object.entityHit.posY, object.entityHit.posZ);
					if((vecplayer.distanceTo(vectest) < 6)){
						ItemHeavyMace.damage = true;
						object.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 8);
					}
				}

			}
		}


		if (!this.worldObj.isRemote){
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
