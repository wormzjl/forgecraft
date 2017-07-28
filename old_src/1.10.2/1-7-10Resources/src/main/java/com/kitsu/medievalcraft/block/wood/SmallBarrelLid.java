package com.kitsu.medievalcraft.block.wood;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.TileEntitySmallLid;

public class SmallBarrelLid extends BlockContainer {

	public SmallBarrelLid(String unlocalizedName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		//this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setHarvestLevel(null, 0);
		this.setStepSound(soundTypeWood);
		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		//this.setBlockBounds(0.17F, 0.0F,  0.315F, 
		//		0.8F,  0.15F, 0.725F);
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block p_149749_5_, int p_149749_6_){
		if(!world.isRemote){
			TileEntitySmallLid tileLid = (TileEntitySmallLid) world.getTileEntity(x, y, z);
			if(tileLid.ring<2){
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.itemSmallBarrelLid, 1, 0)));
				//System.out.println(world.getTileEntity(x, y, z));
				//System.out.println(tileLid.logs);
				if(tileLid.logs>0){
					world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.halfSplitBoard, tileLid.logs, 0)));
				}
				
			}

		}
		super.breakBlock(world, x, y, z, p_149749_5_, p_149749_6_);
	}
	
	@Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    }

	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {

		if(!world.isRemote){
			TileEntitySmallLid tileLid = (TileEntitySmallLid) world.getTileEntity(x, y, z);
			if(player.inventory.getCurrentItem()!=null){
				if((player.getCurrentEquippedItem().getItem().equals(ModItems.halfSplitBoard))){
					if(tileLid.logs<8){
						player.inventory.decrStackSize(player.inventory.currentItem, 1);
						tileLid.logs = tileLid.logs +1;
						world.markBlockForUpdate(x, y, z);
						return true;
					}
				}
			}
			if(player.inventory.getCurrentItem()!=null){
				if((player.getCurrentEquippedItem().getItem().equals(ModItems.saplingRing))){
					
					if(tileLid.logs==8){
						player.inventory.decrStackSize(player.inventory.currentItem, 1);
						tileLid.ring = tileLid.ring +1;
						if(tileLid.ring==2){
							world.markBlockForUpdate(x, y, z);
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {

		return new TileEntitySmallLid();
	}

	@Override
	public int getRenderType() {
		return RenderId.smallLidID;
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



