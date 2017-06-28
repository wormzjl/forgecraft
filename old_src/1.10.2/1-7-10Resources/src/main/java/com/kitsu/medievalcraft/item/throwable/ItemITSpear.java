package com.kitsu.medievalcraft.item.throwable;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.entity.EntityITSpear;
import com.kitsu.medievalcraft.entity.EntityShit;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemITSpear extends ItemSword {

	private String name = "itemITSpear";

	public ItemITSpear(String name, ToolMaterial mat) {
		super(mat);
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		setMaxDamage(100);
		GameRegistry.registerItem(this, name);

	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.bow;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		return 72000;
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		ArrowNockEvent event = new ArrowNockEvent(player, stack);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return event.result;
		}
		if (player.capabilities.isCreativeMode || player.inventory.hasItem(ModItems.itemITSpear))
		{
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		}
		if(!world.isRemote){
			this.setMaxDamage(500);	
		}
		return stack;
	}

	public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_)
	{
		if (!p_77615_2_.isRemote)
		{
		int j = this.getMaxItemUseDuration(p_77615_1_) - p_77615_4_;
		ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return;
		}
		j = event.charge;
		//boolean flag = p_77615_3_.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, p_77615_1_) > 0;
		if (p_77615_3_.inventory.hasItem(ModItems.itemITSpear))
		{
			float f = (float)j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;
			if ((double)f < 0.1D)
			{
				return;
			}
			if (f > 1.0F)
			{
				f = 1.0F;
			}
			EntityITSpear entityspear = new EntityITSpear(p_77615_2_, p_77615_3_, f * 2.0F);
			if (f == 1.0F)
			{
				entityspear.setIsCritical(true);
			}
			/*int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, p_77615_1_);
			if (k > 0)
			{
				entityspear.setDamage(entityspear.getDamage() + (double)k * 0.5D + 0.5D);
			}
			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, p_77615_1_);
			if (l > 0)
			{
				entityspear.setKnockbackStrength(l);
			}
			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, p_77615_1_) > 0)
			{
				entityspear.setFire(100);
			}*/
			//p_77615_1_.damageItem(1, p_77615_3_);
			p_77615_2_.playSoundAtEntity(p_77615_3_, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

				p_77615_3_.inventory.consumeInventoryItem(ModItems.itemITSpear);
			

				this.setMaxDamage(100);
				p_77615_2_.spawnEntityInWorld(entityspear);
				
			}
		}
	}

	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
	{
		return p_77654_1_;
	}
}
