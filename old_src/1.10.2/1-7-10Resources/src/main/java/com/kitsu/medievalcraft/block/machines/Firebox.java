package com.kitsu.medievalcraft.block.machines;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.machine.TileEntityFirebox;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Firebox extends BlockContainer{

	private final Random random = new Random();

	public Firebox(String unlocalizedName, Material material) {
		super(material.rock);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setHarvestLevel("pickaxe", 1, 0);
		this.setStepSound(Block.soundTypeStone);
		//this.isFlammable(world, x, y, z, face);
		//(xmin, ymin, zmin, 
		// xmax, ymax, zmax)
		this.setBlockBounds(0.0F, 0.00F, 0.0F,
				1.0F, 1.00F, 1.0F);

	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face){
		return true;
	}

	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
		if (this == ModBlocks.firebox && side == UP){
			TileEntityFirebox tile = (TileEntityFirebox) world.getTileEntity(x, y, z);
			if(tile.isOn==true){
				if(this.getItemBurnTime(tile.getStackInSlot(0))>0){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int getLightValue(IBlockAccess world,int  x,int y,int z){
		if(world.getBlockMetadata(x, y, z)==1){
			return 15;
		}
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand)
	{
		super.randomDisplayTick(world, x, y, z, random);


		if(world.getBlockMetadata(x, y, z)==1){
			if (rand.nextInt(24) == 0&&world.getBlock(x, y+1, z)!=Blocks.fire)
			{
				world.playSound((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "fire.fire", 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
			}
			int l;
			float f;
			float f1;
			float f2;
			for (l = 0; l < 3; ++l)
			{
				f = (float)(x+0.1) + ((rand.nextFloat()/1.25f));
				f1 = (float)y+0.3f + rand.nextFloat() * 0.4F;
				f2 = (float)(z+0.1) + ((rand.nextFloat()/1.25f));
				world.spawnParticle("fire", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
			}
		}

	}
	//PACKETHANDLE FOR C 
	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {

		TileEntityFirebox tileEnt = (TileEntityFirebox) world.getTileEntity(x, y, z);
		if(!world.isRemote){
			if(player.inventory.getCurrentItem()!=null){
				if((player.inventory.getCurrentItem().getItem()==Item.getItemFromBlock(Blocks.torch))||
						(player.inventory.getCurrentItem().getItem()==Items.flint_and_steel)||
						(player.inventory.getCurrentItem().getItem()==ModItems.fireBow)
						){
					world.setBlockMetadataWithNotify(x, y, z, 1, 3);
					tileEnt.markForUpdate();
					tileEnt.markDirty();
					player.inventory.getCurrentItem().damageItem(1, player);
					if(world.getBlock(x, y, z).equals(Blocks.air)){
						world.setBlock(x, y+1, z, Blocks.fire, 0, 2);
					}
				}
			}
			if(player.inventory.getCurrentItem()!=null){
				if (tileEnt.getStackInSlot(0)==null){
					if(isItemFuel(player.inventory.getCurrentItem())==true){
						tileEnt.setInventorySlotContents(0, player.inventory.getCurrentItem());
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					}
				}
				if (tileEnt.getStackInSlot(0)!=null){
					if(player.inventory.getCurrentItem()!=null){
						ItemStack pStack = player.inventory.getCurrentItem().copy();
						ItemStack sStack = tileEnt.getStackInSlot(0).copy();
						ItemStack sStackTemp = tileEnt.getStackInSlot(0).copy();
						if(tileEnt.getStackInSlot(0).stackSize < 64){
							sStackTemp.stackSize++;
							if ((sStack.getItem().equals(pStack.getItem())) && (sStack.getItemDamage() == pStack.getItemDamage())  ){
								tileEnt.setInventorySlotContents(0, sStackTemp);
								player.inventory.decrStackSize(player.inventory.currentItem, 1);
							}
						}
					}
				}
				return true;
			}
			if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
				if(tileEnt.getStackInSlot(0)!=null){
					player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(0));
					tileEnt.setInventorySlotContents(0, null);
				}
				return true;
			}
			if (!player.isSneaking()) {
				if((player.inventory.getCurrentItem()==null)){
					if(tileEnt.getStackInSlot(0)!=null){
						ItemStack pStack = tileEnt.getStackInSlot(0).copy();
						pStack.stackSize = 1;
						world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
						tileEnt.decrStackSize(0, 1);
					}
				}
				return true;
			}
		}
		tileEnt.markForUpdate();
		tileEnt.markDirty();
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack p_149689_6_) {
		world.setBlockMetadataWithNotify(x, y, z, 0, 2);

		world.markBlockForUpdate(x, y, z);
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityFirebox tileEnt = (TileEntityFirebox) world.getTileEntity(x, y, z);

		if (tileEnt != null) {
			for (int i = 0; i < tileEnt.getSizeInventory(); ++i) {
				ItemStack itemstack = tileEnt.getStackInSlot(i);

				if (itemstack != null) {
					float f = this.random.nextFloat() * 0.6F + 0.1F;
					float f1 = this.random.nextFloat() * 0.6F + 0.1F;
					float f2 = this.random.nextFloat() * 0.6F + 0.1F;

					while (itemstack.stackSize > 0) {
						int j = this.random.nextInt(21) + 10;

						if (j > itemstack.stackSize) {
							j = itemstack.stackSize;
						}

						itemstack.stackSize -= j;
						EntityItem entityitem = new EntityItem(world, x + f, y + f1, z + f2, new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
						}

						float f3 = 0.025F;
						entityitem.motionX = (float) this.random.nextGaussian() * f3;
						entityitem.motionY = (float) this.random.nextGaussian() * f3 + 0.1F;
						entityitem.motionZ = (float) this.random.nextGaussian() * f3;
						world.spawnEntityInWorld(entityitem);
					}
				}
			}
			world.func_147453_f(x, y, z, block);
		}

		super.breakBlock(world, x, y, z, block, meta);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityFirebox();
	}
	public static int getItemBurnTime(ItemStack p_145952_0_)
	{
		if (p_145952_0_ == null)
		{
			return 0;
		}
		Item item = p_145952_0_.getItem();

		if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
		{
			Block block = Block.getBlockFromItem(item);

			if (block == Blocks.wooden_slab)
			{
				return 150;
			}

			if (block.getMaterial() == Material.wood)
			{
				return 300;
			}

			if (block == Blocks.coal_block)
			{
				return 16000;
			}
		}

		if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
		if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
		if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
		if (item == Items.stick) return 100;
		if (item == Items.coal) return 1600;
		if (item == Items.lava_bucket) return 20000;
		if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
		if (item == Items.blaze_rod) return 2400;
		return GameRegistry.getFuelValue(p_145952_0_);
	}
	public static boolean isItemFuel(ItemStack stack)
	{
		return getItemBurnTime(stack) > 0;
	}
	@Override
	public int getRenderType() {
		return RenderId.fireboxID;
	}
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

}
