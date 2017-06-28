package com.kitsu.medievalcraft.block.machines;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.machine.TileEntitySolidFilter;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class SolidFilter extends BlockContainer {

	private final Random random = new Random();
	//private NBTTagCompound nbt = new NBTTagCompound();

	public SolidFilter(String unlocalizedName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setHarvestLevel("pickaxe", 1, 0);
		this.setStepSound(Block.soundTypeStone);

		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		this.setBlockBounds(0.1F, 0.01F,  0.1F, 
				0.9F,  1.0F, 0.9F);
	}

	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {

		TileEntitySolidFilter tileSand = (TileEntitySolidFilter) world.getTileEntity(x, y, z);
		if (!player.isSneaking()) {
			FMLNetworkHandler.openGui(player, Main.instance, 4, world, x, y, z);
			return true;
		}
		if(player.isSneaking()){
			if(tileSand.getStackInSlot(0)!=null){
				int s = player.inventory.currentItem;
				if((player.inventory.getStackInSlot(s)==null)){
					if((world.getBlock(x, y+1, z).equals(Blocks.sand))||(world.getBlock(x, y+1, z).equals(Blocks.gravel))){
						tileSand.hits++;
						player.worldObj.playSoundAtEntity(player, "step.sand", 0.5F, 0.5F);
						tileSand.getStackInSlot(0).setItemDamage(tileSand.getStackInSlot(0).getItemDamage()+1);
					}
				}
			}
		}
		return true;
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntitySolidFilter tileEnt = (TileEntitySolidFilter) world.getTileEntity(x, y, z);

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

		return new TileEntitySolidFilter();
	}

	@Override
	public int getRenderType() {
		return RenderId.solidFilterID;
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