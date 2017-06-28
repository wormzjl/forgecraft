package com.kitsu.medievalcraft.item.weapon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.events.EventHandle;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHeavyMace extends ItemSword {

	public static boolean maceInUse;
	public static boolean attack;
	public static Vec3 vecp; 
	public static boolean damage;

	public ItemHeavyMace (String unlocalizedName, ToolMaterial mat) {

		super(mat);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setMaxStackSize(1);
		setMaxDamage(mat.getMaxUses()+ 75);
		setFull3D().isRepairable();
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int p_77663_4_, boolean using) {
		//world.getGameRules().
		/*if(damage == true){
			stack.damageItem(1, (EntityLivingBase) player);
			damage = false;
		}*/

		/*if ((Minecraft.getMinecraft().thePlayer.isSwingInProgress == true) && (using == true)) {
			if(damage == false){
				vecp = vecp.createVectorHelper(player.posX, player.posY, player.posZ);
				attack = true;
				if (!world.isRemote)
				{
					world.spawnEntityInWorld(new EntityTester(world, (EntityLivingBase) player));
				}
			}
		}*/
		
		if(using == true){
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 10, 4, true));
			//((EntityLivingBase) player).attackEntityFrom(DamageSource.causeMobDamage(this), 2.0f);
			
			player.motionX *= 0.45D;
			player.motionZ *= 0.45D;			
		}
		/*if (Minecraft.getMinecraft().          .isSwingInProgress == false)){
			attack = false;
		}*/

	}

	@Override
	public int getItemEnchantability () {
		return 0;

	}

	
	@Override 
	@SideOnly(Side.CLIENT)
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		EventHandle.weaponUse = true;
		return super.onItemRightClick(stack, world, player);
	}

	/*private Item checkWeapon(Item testItem){
		for(int i = 0; i < ShieldSwitchTable.shields.size(); i++){
			if(testItem == ShieldSwitchTable.shields.get(i)){
				sKey = i;
			}
		}
		return ShieldSwitchTable.shields.get(sKey);
	}*/

	@Override
	public boolean getIsRepairable(ItemStack item, ItemStack repair)
	{
		return Items.iron_ingot == repair.getItem() ? true : false;
	}
}











