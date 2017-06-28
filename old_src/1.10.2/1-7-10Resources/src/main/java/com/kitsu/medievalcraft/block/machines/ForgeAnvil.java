package com.kitsu.medievalcraft.block.machines;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.machine.TileEntityAnvilForge;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ForgeAnvil extends BlockContainer{

	private final Random random = new Random();

	public ForgeAnvil(String unlocalizedName, Material mat) {
		super(mat);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(2.0F);
		this.setResistance(6.0F);
		this.setStepSound(Block.soundTypeStone);

	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityAnvilForge();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntityAnvilForge tileEnt = (TileEntityAnvilForge) world.getTileEntity(x, y, z);
		if(!world.isRemote){

			if(player.inventory.getCurrentItem()!=null){
				if (tileEnt.getStackInSlot(0)==null){
					tileEnt.setInventorySlotContents(0, player.inventory.getCurrentItem());
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					tileEnt.markForUpdate();
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
				tileEnt.markForUpdate();
				return true;
			}
			if (player.isSneaking() && player.inventory.getCurrentItem()==null) {
				if(tileEnt.getStackInSlot(0)!=null){
					player.inventory.setInventorySlotContents(player.inventory.currentItem, tileEnt.getStackInSlot(0));
					tileEnt.setInventorySlotContents(0, null);
				}
				tileEnt.markForUpdate();
				return true;
			}
			if (!player.isSneaking()){
				if((player.inventory.getCurrentItem()==null)){
					if(tileEnt.getStackInSlot(0)!=null){
						ItemStack pStack = tileEnt.getStackInSlot(0).copy();
						pStack.stackSize = 1;
						world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, pStack));
						tileEnt.setInventorySlotContents(0, null);
						tileEnt.markForUpdate();
					}
				}
				tileEnt.markForUpdate();
				return true;
			}
		}
		tileEnt.markForUpdate();
		tileEnt.markDirty();
		return true;
	}

	public Item getItemDropped(int par1, Random random, int par3) {
		return Item.getItemFromBlock(ModBlocks.forgeAnvil);
	}

	public Item getItem(World world, int par2, int par3, int par4) {
		return Item.getItemFromBlock(ModBlocks.forgeAnvil);
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityAnvilForge tileEnt = (TileEntityAnvilForge) world.getTileEntity(x, y, z);

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
		}

		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public int getRenderType() {
		return RenderId.anvilForgeID;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack p_149689_6_) {
    	int dir = MathHelper.floor_double((player.rotationYaw * 4F) / 360F + 0.5D) & 3; 
    	world.setBlockMetadataWithNotify(x, y, z, dir, 0);
    	//System.out.println(dir);
    }

	

}





















