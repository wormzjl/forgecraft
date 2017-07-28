package com.kitsu.medievalcraft.item.weapon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.events.EventHandle;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLongSword extends ItemSword {


	//private String unlocalizedname = "forgeHammer";
	//ItemStack repair = new ItemStack(Items.iron_ingot);
	//ItemStack item = new ItemStack(ModItems.longSword);
	//public static boolean longswordused;
	//private int sKey;

	public ItemLongSword(String unlocalizedName, ToolMaterial mat) {

		super(mat);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setMaxStackSize(1);
		setMaxDamage(mat.getMaxUses());
		setFull3D().isRepairable();

	}

	@Override
	public int getItemEnchantability () {
		return 0;
	}

	@Override 
	@SideOnly(Side.CLIENT)
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		EventHandle.weaponUse = true;
		//player.setItemInUse(stack, 72000);
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




}










