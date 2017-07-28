package com.kitsu.medievalcraft.block.cannon;

import java.util.Random;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.cannon.TileCannonBall28;
import com.kitsu.medievalcraft.tileents.ingots.TileEntityMyDiamond;
import com.kitsu.medievalcraft.util.CustomTab;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CannonBallBlock28 extends BlockContainer {

	public CannonBallBlock28(String unlocalizedName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(3.0F);
		this.setResistance(8.0F);
		this.setHarvestLevel("pickaxe",1, 0);
		this.setStepSound(soundTypeStone);
		//this.setLightLevel(2.0F);
		//xmin, ymin, zmin, 
		this.setBlockBounds(0.38F, 0.0F, 0.38F, 
				//xmax,  ymax, zmax
				0.62F, 0.35F, 0.62F);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){

		int a = player.inventory.currentItem;
		if(!world.isRemote){
			if(player.inventory.getStackInSlot(a)!=null){
				if(player.getHeldItem().getItem()==Item.getItemFromBlock(this)){
					ItemStack jar = new ItemStack(this);
					player.inventory.addItemStackToInventory(jar);
					if(!world.isRemote){
						world.setBlock(x, y, z, Blocks.air, 0, 2);
					}
				}
			}
			if(player.inventory.getStackInSlot(a)==null){
				ItemStack jar = new ItemStack(this);
				player.inventory.setInventorySlotContents(a, jar);
				if(!world.isRemote){
					world.setBlock(x, y, z, Blocks.air, 0, 2);
				}
			}
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {

		return new TileCannonBall28();
	}

	@Override
	public int getRenderType() {
		return RenderId.my28CannonBallID;
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