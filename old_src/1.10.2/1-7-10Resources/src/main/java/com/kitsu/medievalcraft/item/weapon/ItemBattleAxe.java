package com.kitsu.medievalcraft.item.weapon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.events.EventHandle;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBattleAxe extends ItemSword {

	//public static boolean longswordused;
	//private int sKey;

	public ItemBattleAxe(String unlocalizedName, ToolMaterial mat) {

		super(mat);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setMaxStackSize(1);
		setMaxDamage(mat.getMaxUses());
		setFull3D().isRepairable();

	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int p_77663_4_, boolean using) {
		
		if(using == true){
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 10, 4, true));
			player.motionX *= 0.45D;
			player.motionZ *= 0.45D;			
		}


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
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int p_77615_4_) {

	}


}










