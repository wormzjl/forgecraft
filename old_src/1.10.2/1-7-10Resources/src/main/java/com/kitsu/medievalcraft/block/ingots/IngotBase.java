package com.kitsu.medievalcraft.block.ingots;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class IngotBase extends BlockContainer {

	private final Random random = new Random();
	public static boolean makeParts;
	public static int locX, locY, locZ;

	public IngotBase(String unlocalizedName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setHarvestLevel(null, 0);
		this.setStepSound(soundTypeMetal);
		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		this.setBlockBounds(0.25F, 0.0F,  0.35F, 
				0.75F , 0.15F, 0.7F);
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Item.getItemFromBlock(this);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return null;
	}

	@Override
	public int quantityDropped(Random p_149745_1_)
	{
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand)
	{
		super.randomDisplayTick(world, x, y, z, random);
		if(makeParts == true){
			parts(world, locX, locY, locZ);
			makeParts = false;
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int aa, float bb, float cc, float ff){
		//System.out.println(this.getUnlocalizedName());
		
			//if(player.inventory.getCurrentItem().getItem()!=ModItems.forgeHammer){
			int a = player.inventory.currentItem;
			if(player.inventory.getStackInSlot(a)==null){
				ItemStack jar = new ItemStack(this);
				player.inventory.setInventorySlotContents(a, jar);
				if(!world.isRemote){
					world.setBlock(x, y, z, Blocks.air, 0, 2);
				}
				return true;
			}
			if(player.inventory.getStackInSlot(a)!=null && player.inventory.getCurrentItem().getItem()!=ModItems.forgeHammer){
				if(player.inventory.getStackInSlot(a).getItem()==Item.getItemFromBlock(this)){
					ItemStack jar = new ItemStack(this);
					player.inventory.addItemStackToInventory(jar);
					if(!world.isRemote){
						world.setBlock(x, y, z, Blocks.air, 0, 2);
					}
				}
				return true;
			}

		
		return false;
	}

	private void parts(World world, int x, int y, int z){
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
	}

	@Override
	public int getRenderType() {
		return 0;
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