package com.kitsu.medievalcraft.block.wood.quartersplit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DarkSplitLog extends BlockRotatedPillar {

	@SideOnly(Side.CLIENT)
	private IIcon iconSide;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconBot;

	public DarkSplitLog(String unlocalizedName, Material mat) {
		super(mat);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(3.0F);
		this.setResistance(3.0F);
		this.setStepSound(Block.soundTypeWood);
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Main.MODID + ":" + "darkSplitLogIcon");
		this.iconSide = iconRegister.registerIcon(Main.MODID + ":" + "darkSplitLogSide");
		this.iconBot  = iconRegister.registerIcon(Main.MODID + ":" + "darkSplitLogTop");
		this.iconTop   = iconRegister.registerIcon(Main.MODID + ":" + "darkSplitLogTop");
	}
	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {

		if(player.inventory.getCurrentItem()!=null){
			if(player.getCurrentEquippedItem().getItem() instanceof ItemAxe){
				player.swingItem();
				player.worldObj.playSoundAtEntity(player, Main.MODID + ":splitlog", 1.0F, 1.0F);
				if(world.rand.nextInt(2)==0){
					if(!world.isRemote){
						world.setBlock(x, y, z, Blocks.air, 0, 2);
						world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.splitBoard, 4, 0)));
						return true;
					}
				}
			}
		}	
		return false;
	}

	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitx, float hity, float hitz, int meta)
	{
		//System.out.println(side);
		int j1 = meta & 3;
		byte b0 = 0;

		switch (side)
		{
		case 0:
			b0=0;
			break;
		case 1:
			b0=0;
			break;
		case 2:
			b0=8;
			break;
		case 3:
			b0=8;
			break;
		case 4:
			b0=4;
		case 5:
			b0=4;
		}

		return j1 | b0;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		this.setBlockBoundsBasedOnState(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
		return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	 public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
	{
		this.func_149797_b(p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_));
	}

	 /**
	  * Returns the bounding box of the wired rectangular prism to render.
	  */
	 @SideOnly(Side.CLIENT)
	 public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_)
	 {
		 this.setBlockBoundsBasedOnState(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
		 return super.getSelectedBoundingBoxFromPool(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
	 }

	 public void func_149797_b(int p_149797_1_)
	 {

		 if (p_149797_1_ == 0)
		 {
			 this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
		 }

		 if (p_149797_1_ == 4)
		 {
			 this.setBlockBounds(0.0F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
		 }

		 if (p_149797_1_ == 8)
		 {
			 this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 1.0F);
			 //this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		 }
		 //this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

	 }

	 @SideOnly(Side.CLIENT)
	 public IIcon getIcon(int side, int metadata)
	 {
		 int k = metadata & 12;
		 int l = metadata & 3;
		 return k == 0 && (side == 1 || side == 0) ? this.getTopIcon(l) : (k == 4 && (side == 5 || side == 4) ? this.getTopIcon(l) : (k == 8 && (side == 2 || side == 3) ? this.getTopIcon(l) : this.getSideIcon(l)));
	 }

	 @SideOnly(Side.CLIENT)
	 protected IIcon getSideIcon(int p_150163_1_)
	 {
		 return this.iconSide;
	 }

	 @SideOnly(Side.CLIENT)
	 protected IIcon getTopIcon(int p_150161_1_)
	 {
		 return this.iconTop;
	 }

	 @Override
	 @SideOnly(Side.CLIENT)
	 public boolean shouldSideBeRendered(IBlockAccess access, int x, int y, int z, int side)
	 {
		 return true;
	 }
	 @Override
	 public boolean isOpaqueCube()
	 {
		 return false;
	 }

	 @Override
	 public boolean renderAsNormalBlock()
	 {
		 return false;
	 }

}
