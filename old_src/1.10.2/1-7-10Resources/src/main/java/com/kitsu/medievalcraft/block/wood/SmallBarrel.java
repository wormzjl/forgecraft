package com.kitsu.medievalcraft.block.wood;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.TileEntitySmallBarrel;
import com.kitsu.medievalcraft.util.CustomTab;

public class SmallBarrel extends BlockContainer {

	public SmallBarrel(String unlocalizedName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setHarvestLevel(null, 0);
		this.setStepSound(soundTypeWood);
		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		this.setBlockBounds(0.125F, 0.0F,  0.125F, 
				0.775F,  0.8F, 0.775F);
	}
	//MAKE CASES AND HAVE THEM RUN ON THE CLIENT AND SERVER TO UPDATE THE PLAYERS INVENTORY I GUESS SOME SHIT LIKE THAT
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack p_149689_6_) {
		TileEntitySmallBarrel tile = (TileEntitySmallBarrel) world.getTileEntity(x, y, z);
		tile.res="kitsumedievalcraft:models/UntitledBarrel.png";
	}
	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {
		TileEntitySmallBarrel tile = (TileEntitySmallBarrel) world.getTileEntity(x, y, z);
		//if(!world.isRemote){
		/*if(player.inventory.getCurrentItem()!=null){
			if(player.inventory.getCurrentItem().getItem()==ModItems.itemSmallBarrelLid){
				if(tile.lid==false){
					player.swingItem();
					player.inventory.decrStackSize(player.inventory.currentItem, 1);
					tile.lid=true;
					if(tile.quanta==0){
						tile.type="empty";
					}
					tile.markForUpdate();
					tile.markDirty();
					return true;
				}
			}
		}*/
		if(player.inventory.getCurrentItem()!=null){
			if(player.inventory.getCurrentItem().getItem()==ModItems.soakedLeather){
				if((tile.scuddedloaded==false)&&(tile.soakedloaded==false)){
					player.inventory.decrStackSize(player.inventory.currentItem, 1);
					tile.soakedloaded=true;
					tile.markForUpdate();
					tile.markDirty();
					return true;

				}
			}
		}
		if(player.inventory.getCurrentItem()!=null){
			if(player.inventory.getCurrentItem().getItem()==ModItems.scuddedLeather){
				if((tile.scuddedloaded==false)&&(tile.soakedloaded==false)){
					player.inventory.decrStackSize(player.inventory.currentItem, 1);
					tile.scuddedloaded=true;
					tile.markForUpdate();
					tile.markDirty();
					return true;

				}
			}
		}
		if(player.inventory.getCurrentItem()!=null){
			if(player.inventory.getCurrentItem().getItem()==ModItems.tanninBucket){
				//if(tile.lid==false){
					if((tile.type.equals("empty"))||(tile.type.equals("tannin"))){
						tile.type = "tannin";
						if(tile.quanta < 2){
							ItemStack bucket = new ItemStack(Items.bucket, 1);
							tile.quanta = tile.quanta+1;
							player.inventory.decrStackSize(player.inventory.currentItem, 1);
							player.inventory.addItemStackToInventory(bucket);
							if(tile.quanta==1){
								tile.res = "kitsumedievalcraft:models/UntitledBarrelTan1.png";
							}
							if(tile.quanta==2){
								tile.res = "kitsumedievalcraft:models/UntitledBarrelTan2.png";
							}
							tile.markForUpdate();
							tile.markDirty();
							return true;
						}
					}
				//}
			}
		}
		if(player.inventory.getCurrentItem()!=null){
			if(player.inventory.getCurrentItem().getItem()==ModItems.slackBucket){
				//if(tile.lid==false){
					if((tile.type.equals("empty"))||(tile.type.equals("slack"))){
						tile.type = "slack";
						if(tile.quanta < 2){
							ItemStack bucket = new ItemStack(Items.bucket, 1);
							tile.quanta = tile.quanta+1;
							player.inventory.decrStackSize(player.inventory.currentItem, 1);
							player.inventory.addItemStackToInventory(bucket);
							if(tile.quanta==1){
								tile.res = "kitsumedievalcraft:models/UntitledBarrelSlack1.png";
							}
							if(tile.quanta==2){
								tile.res = "kitsumedievalcraft:models/UntitledBarrelSlack2.png";
							}
							tile.markForUpdate();
							tile.markDirty();
							return true;
						}
					}
				//}
			}
		}
		if(player.inventory.getCurrentItem()!=null){
			if(player.inventory.getCurrentItem().getItem()==Items.bucket){
				//if(tile.lid==false){
					if(tile.quanta>0){
						if(tile.type.equals("tannin")){
							tile.quanta--;
							ItemStack bucket = new ItemStack(ModItems.tanninBucket);
							player.inventory.addItemStackToInventory(bucket);
							player.inventory.decrStackSize(player.inventory.currentItem, 1);
							if(tile.quanta==0){
								tile.type="empty";
								tile.res="kitsumedievalcraft:models/UntitledBarrel.png";
							}
							if(tile.quanta==1){
								tile.res="kitsumedievalcraft:models/UntitledBarrelTan1.png";
							}
							tile.markForUpdate();
							tile.markDirty();
							return true;
						}
						if(tile.type.equals("slack")){
							tile.quanta--;
							ItemStack bucket = new ItemStack(ModItems.slackBucket);
							player.inventory.addItemStackToInventory(bucket);
							player.inventory.decrStackSize(player.inventory.currentItem, 1);
							if(tile.quanta==0){
								tile.type ="empty";
								tile.res="kitsumedievalcraft:models/UntitledBarrel.png";
							}
							if(tile.quanta==1){
								tile.res="kitsumedievalcraft:models/UntitledBarrelSlack1.png";
							}
							tile.markForUpdate();
							tile.markDirty();
							return true;
						}
					}

				//}
			}
		}
		if(player.inventory.getCurrentItem()==null){
			/*if(tile.lid==true){
				ItemStack lid = new ItemStack(ModItems.itemSmallBarrelLid, 1);
				//player.swingItem();
				//int p = player.inventory.getFirstEmptyStack();
				tile.lid=false;
				player.inventory.addItemStackToInventory(lid);
				//player.inventory.setInventorySlotContents(p, lid);
				tile.markForUpdate();
				tile.markDirty();
				return true;
			}*/
			//if(tile.lid==false){
				if(tile.scuddedready==true){
					ItemStack tanned = new ItemStack(ModItems.tannedLeather, 1);
					player.inventory.addItemStackToInventory(tanned);
					tile.scuddedready=false;
					tile.scuddedloaded=false;
					tile.markForUpdate();
					tile.markDirty();
					return true;
				}
			//}
			//if(tile.lid==false){
				if(tile.soakedready==true){
					ItemStack slacked = new ItemStack(ModItems.slackedLeather, 1);
					player.inventory.addItemStackToInventory(slacked);
					tile.soakedready=false;
					tile.soakedloaded=false;
					tile.markForUpdate();
					tile.markDirty();
					return true;
				}
			//}
			//if(tile.lid==false){
				if((tile.soakedready==false)&&(tile.scuddedready==false)){
					world.setBlockToAir(x, y, z);
					ItemStack barrel = new ItemStack(ModBlocks.smallBarrel, 1);
					player.inventory.addItemStackToInventory(barrel);
					tile.markForUpdate();
					tile.markDirty();
					return true;
				}
			//}
		}
		tile.markForUpdate();
		tile.markDirty();

		return true;
	}


	@Override
	public TileEntity createNewTileEntity(World world, int i) {

		return new TileEntitySmallBarrel();
	}

	@Override
	public int getRenderType() {
		return RenderId.smallBarrelID;
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



