package com.kitsu.medievalcraft.item.weapon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;
import com.kitsu.medievalcraft.util.ShieldSwitchTable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWoodenShield extends ItemSword {


	public static boolean woodenShieldInUse;
	private int wKey;
	//private float yaw;

	public ItemWoodenShield(String unlocalizedName, ToolMaterial mat) {
		super(mat);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
		setCreativeTab(CustomTab.MedievalCraftTab);
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
	public void onUpdate(ItemStack stack, World world, Entity player, int p_77663_4_, boolean using) {
		//if((stack.stackTagCompound.getBoolean("WOODSHIELDUSE")) == true){
		//player.setLocationAndAngles(player.posX, player.posY, player.posZ, yaw - 45, player.rotationPitch);
		//}
	}

	@Override
	public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player) {
		woodenShieldInUse = true;
		//yaw = player.rotationYaw;
		stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setBoolean("WOODSHIELDUSE", true);
		return super.onItemRightClick(stack, world, player);	
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int p_77615_4_) {
		woodenShieldInUse = false;
		stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setBoolean("WOODSHIELDUSE", false);
		int a = player.inventory.currentItem;
		//ItemStack newStack = player.inventory.getStackInSlot(a+1);
		if(a!=8){
			if(player.inventory.getStackInSlot(a+1) != null){
				//int a = player.inventory.currentItem;
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

	@Override
	public boolean getIsRepairable(ItemStack item, ItemStack repair){
		return Item.getItemFromBlock(Blocks.planks) == repair.getItem() ? true : false;
	}


}


