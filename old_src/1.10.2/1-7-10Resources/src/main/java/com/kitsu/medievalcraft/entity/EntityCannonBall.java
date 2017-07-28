package com.kitsu.medievalcraft.entity;

import java.util.List;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.util.CannonUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityCannonBall extends Entity implements CannonUtil{

	private EntityLivingBase tntPlacedBy;
	public int damage = 100;
	private int field_145791_d = -1;
	private int field_145792_e = -1;
	private int field_145789_f = -1;
	private int h;
	public Entity shootingEntity;
	private boolean smoke = true;

	public EntityCannonBall(World p_i1582_1_) {
		super(p_i1582_1_);
		this.preventEntitySpawning = true;
		this.setSize(0.5F, 0.5F);
		//this.yOffset = this.height / 2.0F;
		this.boundingBox.setBounds(0.49, 0.49, 0.49, 0.51, 0.51, 0.51);

	}

	public EntityCannonBall(World world, double x, double y, double z, EntityLivingBase entLiving)
	{
		this(world);
		this.setPosition(x, y, z);
		float f = (float)(Math.random() * Math.PI * 2.0D);
		this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
		this.motionY = 0.05D;
		this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.tntPlacedBy = entLiving;
		this.renderDistanceWeight = 100;
		this.smoke = true;
	}

	public void onUpdate()
	{
		
		if(h > 0 && h < 2){
			if(this.smoke==true){
				for(int g = 0; g < 50; g++){
					this.worldObj.spawnParticle("explode", this.posX + (worldObj.rand.nextFloat()*2 - 1), this.posY + (worldObj.rand.nextFloat()*2 - 1), (this.posZ + worldObj.rand.nextFloat()*2 - 1),0.0, 0.0, 0.0);
				}
				this.smoke=false;
			}
		}
		h++;
		/*double x = this.posX;
		double y = this.posY;
		double z = this.posZ;
		
		if(worldObj.isRemote){
			if(this.smoke==true){
				for(int g = 0; g < 10; g++){
					worldObj.spawnParticle("largesmoke", x +worldObj.rand.nextFloat()/10, y+worldObj.rand.nextFloat()/10, z +worldObj.rand.nextFloat()/10,
							1.0, 1.0D, 1.0);
				}
				this.smoke=false;
			}
		}*/
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY -= 0.03999999910593033D;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;

		Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
		Vec3 vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
		MovingObjectPosition mop = this.worldObj.func_147447_a(vec31, vec3, false, true, false);
		vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
		vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

		if (mop != null)
		{
			vec3 = Vec3.createVectorHelper(mop.hitVec.xCoord, mop.hitVec.yCoord, mop.hitVec.zCoord);
			//System.out.println(mop.entityHit);
		}

		if(!worldObj.isRemote){

			if(this.motionX==0||this.motionY==0||this.motionZ==0){
				this.explode();
				this.setDead();
			}
		}

	}
	@Override
	public boolean canBeCollidedWith()
	{
		return true;
	}

	private void explode()
	{
		float f = 1F+(this.worldObj.rand.nextFloat()/3)+(this.worldObj.rand.nextFloat()/4)+this.worldObj.rand.nextFloat()/5;
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {

	}

	public EntityLivingBase getTntPlacedBy()
	{
		return this.tntPlacedBy;
	}

	@Override
	protected void entityInit() {
		this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
	}



}
