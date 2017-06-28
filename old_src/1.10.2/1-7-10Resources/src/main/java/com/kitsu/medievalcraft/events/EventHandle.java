package com.kitsu.medievalcraft.events;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.item.craftingtools.ForgeHammer;
import com.kitsu.medievalcraft.util.ShieldSwitchTable;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EventHandle {

	//private int wKey, sKey;
	//public static int longbowD;
	public int longbowTicks;
	//public static boolean longbowUse;
	public static boolean mobcheck, weaponUse;

	Random rand = new Random();

	/*@SubscribeEvent
public void zombieJoinsEvent(EntityJoinWorldEvent event){
	if(event.entity instanceof EntityRazorBack){
		event.entity.po
		System.out.println(event.entity.posX + ":" + event.entity.posy + ":" + event.entity.posZ);
	}
}*/

	@SubscribeEvent
	public void ironOreJungleEvent (HarvestDropsEvent event){
		if(BiomeDictionary.isBiomeOfType(event.world.getBiomeGenForCoords(event.x, event.z), Type.JUNGLE)){
			if(event.block.equals(Blocks.iron_ore)){
				event.drops.clear();
				ItemStack testStack = new ItemStack(ModBlocks.wootzOre);
				event.drops.add(testStack);
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void longbowUseEvent (PlayerUseItemEvent.Tick event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if(player.worldObj.isRemote == true){

				if(player.getItemInUse().getItem().equals(ModItems.longbow)){
					longbowTicks = player.getItemInUseDuration();
					ItemStack stack = player.inventory.getCurrentItem();

					if((longbowTicks > 0) && (longbowTicks <=5)){
						stack.stackTagCompound = new NBTTagCompound();
						stack.stackTagCompound.setInteger("D", 1);
					}
					if((longbowTicks > 5) && (longbowTicks <=10)){
						stack.stackTagCompound = new NBTTagCompound();
						stack.stackTagCompound.setInteger("D", 2);
					}
					if((longbowTicks > 10) && (longbowTicks <=15)){
						stack.stackTagCompound = new NBTTagCompound();
						stack.stackTagCompound.setInteger("D", 3);
					}
					if((longbowTicks > 15) && (longbowTicks <=20)){
						stack.stackTagCompound = new NBTTagCompound();
						stack.stackTagCompound.setInteger("D", 4);
					}
					if((longbowTicks > 20) && (longbowTicks <=25)){
						stack.stackTagCompound = new NBTTagCompound();
						stack.stackTagCompound.setInteger("D", 5);
					}
					if((longbowTicks > 25) && (longbowTicks <=30)){
						stack.stackTagCompound = new NBTTagCompound();
						stack.stackTagCompound.setInteger("D", 6);
					}
					if((longbowTicks > 30) && (longbowTicks <=35)){
						stack.stackTagCompound = new NBTTagCompound();
						stack.stackTagCompound.setInteger("D", 7);
					}
					if((longbowTicks > 35) && (longbowTicks <=40)){
						stack.stackTagCompound = new NBTTagCompound();
						stack.stackTagCompound.setInteger("D", 8);
					}
					if((longbowTicks > 40) && (longbowTicks <=45)){
						stack.stackTagCompound = new NBTTagCompound();
						stack.stackTagCompound.setInteger("D", 9);
					}
					if(longbowTicks == 45){
						player.playSound((Main.MODID + ":tautBow"), 0.8F, 1.0F);
						//player.worldObj.playSoundAtEntity(player, (Main.MODID + ":tautBow"), 0.8F, 1.0F);
					}
					if((longbowTicks > 45) && (longbowTicks <=55)){
						stack.stackTagCompound = new NBTTagCompound();
						stack.stackTagCompound.setInteger("D", 10);
					}

					if((longbowTicks > 100)){
						longbowTicks = 100;
						stack.stackTagCompound = new NBTTagCompound();
						stack.stackTagCompound.setInteger("D", 10);
					}
				}
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void getMouseEvent(MouseEvent event){
		if((event.button == 0) && (event.buttonstate == true)){
			ForgeHammer.forgeHammerLeftClick = true;
		}
		if(event.buttonstate == false){
			ForgeHammer.forgeHammerLeftClick = false;
		}
		//System.out.println("Button: " + event.button);
		//System.out.println("ButtonState: " + event.buttonstate);
	}

	/*@SubscribeEvent
public void splitLogEvent(PlayerInteractEvent event){
	if(event.entityPlayer instanceof EntityPlayer){
		EntityPlayer player = event.entityPlayer;
		if((event.useBlock.equals(ModBlocks.cleanAcacia))
				||(event.useBlock.equals(ModBlocks.cleanBirch))
				||(event.useBlock.equals(ModBlocks.cleanDarkOak))
				||(event.useBlock.equals(ModBlocks.cleanJungle))
				||(event.useBlock.equals(ModBlocks.cleanOak))
				||(event.useBlock.equals(ModBlocks.cleanSpruce))){
			System.out.println("Player Used Wood");
			if(player.inventory.getCurrentItem()!=null){
				System.out.println(player.inventory.getCurrentItem().getClass());
				if(player.getItemInUse().getItem() instanceof ItemAxe){
					player.swingItem();
					if(!event.world.isRemote){
						event.world.setBlock(event.x, event.y, event.z, ModBlocks.splitLog, 0, 2);
					}
				}
			}	
		}
	}
}*/

	@SubscribeEvent
	public void emptyHandBarkEvent(PlayerInteractEvent event) {
		if(!event.entity.worldObj.isRemote){
			if (event.entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.entity;
				if(player.inventory.getCurrentItem()!=null){
					Block test = event.world.getBlock(event.x, event.y, event.z);
					//Block isEmpty = event.world.getBlock(event.x, event.y + 1, event.z);
					ItemStack itemStack = new ItemStack(ModItems.itemBark);
					//ItemStack stickStack = new ItemStack(Items.stick);

					if((player.inventory.getCurrentItem().getItem() == Items.stick)) {
						if((event.action == event.action.RIGHT_CLICK_BLOCK ) && ((test == Blocks.log)||test == Blocks.log2) ) { //&& (test == ModBlocks.testForge) && (isEmpty == Blocks.air)
							if(test == Blocks.log){
								player.worldObj.playSoundAtEntity(player, Main.MODID + ":scrapes1", 0.15F, 0.85F);
								int woodMeta = event.world.getBlockMetadata(event.x,event.y, event.z);
								if(woodMeta == 0 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanOak, 0, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 4 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanOak, 4, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 8 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanOak, 8, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 1 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanSpruce, 0, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 5 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanSpruce, 4, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 9 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanSpruce, 8, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 2 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanBirch, 0, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 6 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanBirch, 4, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 10 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanBirch, 8, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 3 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanJungle, 0, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 7 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanJungle, 4, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 11 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanJungle, 8, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
							}
							if(test == Blocks.log2){
								player.worldObj.playSoundAtEntity(player, Main.MODID + ":scrapes1", 0.2F, 0.8F);
								int woodMeta = event.world.getBlockMetadata(event.x, event.y, event.z);
								if(woodMeta == 0 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y, event.z, ModBlocks.cleanAcacia, 0, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 4 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y, event.z, ModBlocks.cleanAcacia, 4, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 8 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y, event.z, ModBlocks.cleanAcacia, 8, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 1 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y, event.z, ModBlocks.cleanDarkOak, 0, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 5 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y, event.z, ModBlocks.cleanDarkOak, 4, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 9 && event.world.rand.nextInt(9)==0){
									event.world.setBlock(event.x, event.y, event.z, ModBlocks.cleanDarkOak, 8, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 1 + event.world.rand.nextInt(2), 0)));
								}
							}
						}
					}
				}
			}
		}
	}

	/*@SubscribeEvent
	public void flintKnappedEvent(PlayerInteractEvent event) {
		if(!event.entity.worldObj.isRemote){
			if (event.entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.entity;
				Block test = event.world.getBlock(event.x, event.y, event.z);
				ItemStack flint = new ItemStack(Items.flint);
				ItemStack flintKnapped = new ItemStack(ModItems.flintKnapped, 1 + event.world.rand.nextInt(3), 0);
				//if(player.isSneaking()){
				if((player.inventory.getCurrentItem() != null)) {
					if((player.inventory.getCurrentItem().getItem().equals(Items.flint)) && (test==Blocks.stone)){

						if(player.isSwingInProgress == false){
							player.worldObj.playSoundAtEntity(player, "mob.chicken.step", 1.0f, 1.0f);
							player.swingItem();
							if((event.world.rand.nextInt(4)==0)){
							player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
							if((event.world.rand.nextInt(2)==0)){
								event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y+1, event.z, flintKnapped));
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}

						}
					}
				}
			}
		}
	}*/

	@SubscribeEvent
	public void flintHandBarkEvent(PlayerInteractEvent event) {
		if(!event.entity.worldObj.isRemote){
			if (event.entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.entity;
				Block test = event.world.getBlock(event.x, event.y, event.z);
				//Block isEmpty = event.world.getBlock(event.x, event.y + 1, event.z);
				ItemStack itemStack = new ItemStack(ModItems.itemBark);
				ItemStack flint = new ItemStack(ModItems.flintKnapped);
				//if(player.isSneaking()){
				if((player.inventory.getCurrentItem() != null)) {
					if((player.inventory.getCurrentItem().getUnlocalizedName().contains("flintKnapped"))){
						if((event.action == event.action.RIGHT_CLICK_BLOCK ) && ((test == Blocks.log)||test == Blocks.log2)) {
							if(test == Blocks.log){
								player.worldObj.playSoundAtEntity(player, Main.MODID + ":scrapes1", 0.15F, 0.85F);
								int woodMeta = event.world.getBlockMetadata(event.x,event.y, event.z);
								if(woodMeta == 0 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanOak, 0, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 4 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanOak, 4, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 8 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanOak, 8, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 1 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanSpruce, 0, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 5 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanSpruce, 4, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 9 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanSpruce, 8, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 2 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanBirch, 0, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 6 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanBirch, 4, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 10 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanBirch, 8, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 3 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanJungle, 0, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 7 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanJungle, 4, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 11 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y,event.z, ModBlocks.cleanJungle, 8, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
							}
							if(test == Blocks.log2){
								player.worldObj.playSoundAtEntity(player, Main.MODID + ":scrapes1", 0.2F, 0.8F);
								int woodMeta = event.world.getBlockMetadata(event.x, event.y, event.z);
								if(woodMeta == 0 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y, event.z, ModBlocks.cleanAcacia, 0, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 4 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y, event.z, ModBlocks.cleanAcacia, 4, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 8 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y, event.z, ModBlocks.cleanAcacia, 8, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 1 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y, event.z, ModBlocks.cleanDarkOak, 0, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 5 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y, event.z, ModBlocks.cleanDarkOak, 4, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
								if(woodMeta == 9 && event.world.rand.nextInt(6)==0){
									event.world.setBlock(event.x, event.y, event.z, ModBlocks.cleanDarkOak, 8, 2);
									event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemBark, 2 + event.world.rand.nextInt(2), 0)));
								}
							}
							if(event.world.rand.nextInt(50)==0){
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void myDiamondPlayerInteractEvent(PlayerInteractEvent event) {
		if(!event.entity.worldObj.isRemote){
			if (event.entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.entity;
				ItemStack itemStack = new ItemStack(Items.diamond);
				if(player.isSneaking()){
					if((player.inventory.getCurrentItem() != null)) {
						if((player.inventory.getCurrentItem().getItem().equals(Items.diamond))){
							if((event.action == event.action.RIGHT_CLICK_BLOCK )){
								if(event.world.getBlock(event.x, event.y + 1, event.z).equals(Blocks.air)){
									event.world.setBlock(event.x, event.y + 1, event.z, ModBlocks.myDiamond, 0, 2);
									//event.world.setBlock(event.x, event.y+1, event.z, Blocks.bedrock);
									player.inventory.consumeInventoryItem(Items.diamond);
								}
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void myEmeraldPlayerInteractEvent(PlayerInteractEvent event) {
		if(!event.entity.worldObj.isRemote){
			if (event.entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.entity;
				//Block test = event.world.getBlock(event.x, event.y, event.z);
				//Block isEmpty = event.world.getBlock(event.x, event.y + 1, event.z);
				ItemStack itemStack = new ItemStack(Items.emerald);
				if(player.isSneaking()){
					if((player.inventory.getCurrentItem() != null)) {
						if((player.inventory.getCurrentItem().isItemEqual(itemStack)) && (player.inventory.getStackInSlot(player.inventory.currentItem).stackSize >= 2)){
							if((event.action == event.action.RIGHT_CLICK_BLOCK ) ) { //&& (test == ModBlocks.testForge) && (isEmpty == Blocks.air)
								if(event.world.getBlock(event.x, event.y + 1, event.z).equals(Blocks.air)){
									player.inventory.decrStackSize(player.inventory.currentItem, 1);
									event.world.setBlock(event.x, event.y + 1, event.z, ModBlocks.myEmerald, 0, 2);
									player.inventory.consumeInventoryItem(Items.emerald);
								}
							}
						}
					}
				}
			}
		}
	}

	/*@SubscribeEvent
	public void onItemShitJoinEvent(ItemEvent event){

		if(!event.entity.worldObj.isRemote){

			if(event.entity.getgetEntityItem().getItem() == ModItems.itemShit){
				//System.out.println(event.entityItem.worldObj.getBlock((int)event.entityItem.posX, (int)event.entityItem.posY-2, (int)event.entityItem.posZ));
				/*if(event.entityItem.worldObj.getBlock((int)event.entityItem.posX, (int)event.entityItem.posY-1, (int)event.entityItem.posZ)==Blocks.grass){
					event.entityItem.setDead();
				}
				event.lifespan=200;
			}
		}
	}*/

	@SubscribeEvent
	public void onLivingUpdateEventShit(LivingUpdateEvent event) {
		//eventLongbowTicks = ItemLongbow.longbowTicks;
		//System.out.println(eventLongbowTicks);
		//MAKE COWS SHIT
		//Differentiates Client and Server
		if (!event.entity.worldObj.isRemote) {
			//Default to 100000
			if ( rand.nextInt(1500) == 0 ) {
				//Checks to see if the LivingUpdate is being applied to cow, if so:
				if (event.entity instanceof EntityCow) {

					event.entityLiving.dropItem(ModItems.itemShit, 1);
				}
			}
		}	
	}

	/*
@SubscribeEvent
@SideOnly(Side.CLIENT)
public void onLivingUpdateLongSword (LivingUpdateEvent event) {

	if (event.entity instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.entity;

		if (player.isUsingItem() == true) {
			useItem = player.inventory.getCurrentItem();
			j = useItem.getItemDamage();

			if(useItem.isItemEqual(new ItemStack(ModItems.longSword, OreDictionary.WILDCARD_VALUE, j))) {

				player.inventory.changeCurrentItem(1);

				if (player.inventory.getCurrentItem() != null) {
					switchedItem = player.inventory.getCurrentItem();
					i = switchedItem.getItemDamage();

					if ((switchedItem.isItemEqual(new ItemStack(ModItems.woodenShield, OreDictionary.WILDCARD_VALUE, i))) || (switchedItem.isItemEqual(new ItemStack(ModItems.ironShield, OreDictionary.WILDCARD_VALUE, i)))){

					} else player.inventory.changeCurrentItem(-1);

				} else player.inventory.changeCurrentItem(-1);	
			}
		}
	}
}*/


	/*@SubscribeEvent
@SideOnly(Side.CLIENT)
public void onPlayerUpdateMaceWoodenShield (LivingUpdateEvent event) {

	if (event.entity instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.entity;

		if (player.isUsingItem() == true) {
			useItem2 = player.inventory.getCurrentItem();
			j = useItem2.getItemDamage();

			if(useItem2.isItemEqual(new ItemStack(ModItems.heavyMace, OreDictionary.WILDCARD_VALUE, j))) {

				player.inventory.changeCurrentItem(1);

				if (player.inventory.getCurrentItem() != null) {
					switchedItem2 = player.inventory.getCurrentItem();
					i = switchedItem2.getItemDamage();

					if ((switchedItem2.isItemEqual(new ItemStack(ModItems.woodenShield, OreDictionary.WILDCARD_VALUE, i))) || (switchedItem2.isItemEqual(new ItemStack(ModItems.ironShield, OreDictionary.WILDCARD_VALUE, i)))){

					} else player.inventory.changeCurrentItem(-1);

				} else player.inventory.changeCurrentItem(-1);	
			}
		}
	}
}*/
/*
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void SwordToShieldSwitch (LivingUpdateEvent event) {

		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;

			if(player.isUsingItem() == true){
				if((checkWeapon(player.getItemInUse().getItem())) == true){
					if(weaponUse == true){
						if(player.inventory.currentItem != 0){
							int a = player.inventory.currentItem;
							if(player.inventory.getStackInSlot(a-1) != null){
								if((checkShield(player.inventory.getStackInSlot(a-1).getItem())) == true){
									player.inventory.changeCurrentItem(+1);
									weaponUse = false;
								}
							}
						}
					}
				}
			}
		}
	}

	private boolean checkWeapon(Item testItem){
		for(int i = 0; i < ShieldSwitchTable.weapons.size(); i++){
			if(testItem == ShieldSwitchTable.weapons.get(i)){
				return true;
			}
		}
		return false;
	}
	private Boolean checkShield(Item testItem){
		for(int i = 0; i < ShieldSwitchTable.shields.size(); i++){
			if(testItem == ShieldSwitchTable.shields.get(i)){
				return true;
			}
		}
		return false;
	}


	@SubscribeEvent
	public void onPlayerHurtShield (LivingHurtEvent event) {

		if(event.entity.worldObj.isRemote){
			if (event.entity instanceof EntityPlayer && event.ammount > 0) {
				EntityPlayer player = (EntityPlayer) event.entity;
				Entity mobEntity = event.source.getEntity();
				String mobString = event.source.getDamageType();
				//System.out.println(mobEntity);
				//System.out.println(mobString);
				if (player.inventory.getCurrentItem()!=null){
					if(player.isUsingItem()==true){
						if (player.inventory.getCurrentItem()!=null){
							if (player.inventory.getCurrentItem().getItem().equals(checkShield(player.inventory.getCurrentItem().getItem()))) {
								if ((mobString.equals("explosion"))  || (mobString.equals("thrown")) || (mobString.equals("arrow") || (mobString.equals("player")) || (mobString.equals("mob")) || (mobString.equals("fireball")))) {

									Vec3 vec3 = player.getLook(1.0F).normalize();
									Vec3 vec31 = Vec3.createVectorHelper(mobEntity.posX - player.posX, mobEntity.boundingBox.minY + mobEntity.height / 2.0F - (player.posY + player.getEyeHeight()), mobEntity.posZ - player.posZ);
									double d0 = vec31.lengthVector();
									vec31 = vec31.normalize();
									double d1 = vec3.dotProduct(vec31);
									double d2 = 1.0D - 0.025D / d0;

									if (d1 + 0.3 > d2) {

										if(player.inventory.getCurrentItem().getItem().equals(ModItems.woodenShield)){
											if(event.ammount > 1.5F){
												event.ammount = event.ammount-2F;
											} else event.ammount = 0;
											player.getCurrentEquippedItem().damageItem(2, player);
											player.worldObj.playSoundAtEntity(player, Main.MODID + ":woodshieldbash", 1.0F, 1.0F);
											//event.entityLiving.addPotionEffect(new PotionEffect(Potion.resistance.id, 60, 0, true));
											if (mobString.equals("explosion") && rand.nextInt(5) == 1) {	
												--player.getCurrentEquippedItem().stackSize;
											}	
										}
										if(player.inventory.getCurrentItem().getItem().equals(ModItems.ironShield)){
											if(event.ammount > 4F){
												event.ammount = event.ammount-4F;
											} else event.ammount = 0;
											player.getCurrentEquippedItem().damageItem(4, player);
											player.worldObj.playSoundAtEntity(player, Main.MODID + ":ironShieldBash", 1.0F, 1.0F);
										}

									}
								}
							}
						}
					}
				}
			}
		}
	}
*/


}









