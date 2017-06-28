package com.kitsu.medievalcraft.item.weapon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;
import com.kitsu.medievalcraft.util.ShieldSwitchTable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemIronShield extends ItemSword {

	public static boolean ironShieldInUse;
	private int wKey;

	public ItemIronShield(String unlocalizedName, ToolMaterial mat) {
		super(mat);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
		//setCreativeTab(CustomTab.MedievalCraftTab);
		setMaxStackSize(1);
		setMaxDamage(mat.getMaxUses());
		setFull3D();
		isRepairable();
	}

	@Override
	public int getItemEnchantability () {
		return 0;
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack){
		return false;
	}

	@Override
	public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player) {
		//ironShieldInUse = true;
		return super.onItemRightClick(stack, world, player);	
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int p_77615_4_) {
		//ironShieldInUse = false;
		int a = player.inventory.currentItem;
		//ItemStack newStack = player.inventory.getStackInSlot(a+1);
		if(a!=8){
			if(player.inventory.getStackInSlot(a+1) != null){
				Item check = player.inventory.getStackInSlot(a+1).getItem();
				if(player.inventory.getStackInSlot(a+1).getItem().equals(checkWeapon(check))){
					player.inventory.changeCurrentItem(-1);
				}
			}
		}
	}

	private Item checkWeapon(Item testItem){
		for(int i = 0; i < ShieldSwitchTable.weapons.size(); i++){
			if(testItem == ShieldSwitchTable.weapons.get(i)){
				wKey = i;
			}
		}
		return ShieldSwitchTable.weapons.get(wKey);
	}


}


