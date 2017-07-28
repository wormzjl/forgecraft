package com.kitsu.medievalcraft.block.cannon;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.Random;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.entity.EntityCannonBall;
import com.kitsu.medievalcraft.entity.EntityModelArrow;
import com.kitsu.medievalcraft.entity.ProjectileCannonBall;
import com.kitsu.medievalcraft.gui.GuiHandler;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.cannon.TileCannon_28;
import com.kitsu.medievalcraft.tileents.machine.TileEntityFirebox;
import com.kitsu.medievalcraft.util.CannonUtil;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jdk.nashorn.internal.runtime.regexp.joni.MatcherFactory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class Cannon_28 extends BlockContainer implements CannonUtil{

	private final Random random = new Random();

	public Cannon_28(String unlocalizedName, Material material) {
		super(material.iron);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setHarvestLevel("pickaxe", 1, 0);
		this.setStepSound(Block.soundTypeMetal);
		//this.isFlammable(world, x, y, z, face);
		//(xmin, ymin, zmin, 
		// xmax, ymax, zmax)
		this.setBlockBounds(0.0F, 0.0F, 0.0F,
				1.0F, 0.85F, 1.0F);
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face){
		return false;
	}

	private Entity shootCannon(World world, Integer x, Integer y, Integer z){

		EntityCannonBall cannonball = null;
		TileCannon_28 tile = null;
		Item ball = null;
		if(!world.isRemote){
			tile = (TileCannon_28) world.getTileEntity(x, y, z);
			ball = new ItemStack(ModBlocks.cannonBall_28, 0, 1).getItem();
			if(tile.getStackInSlot(0)!=null && tile.getStackInSlot(0).getItem()==Items.gunpowder){
				tile.isOn=true;
				tile.smoke=true;
				world.playSoundEffect(x, y, z, (Main.MODID + ":cannon1"), 2.0f, world.rand.nextFloat()/0.5f * 0.1F + 0.8F);
				for(int i=0; i < world.playerEntities.size(); i++) {
					EntityPlayer test = (EntityPlayer)world.playerEntities.get(i);
					Vec3 vecTest = Vec3.createVectorHelper(test.posX, test.posY, test.posZ);
					Vec3 vecPlayer = Vec3.createVectorHelper(x, y, z);
					if (vecPlayer.distanceTo(vecTest) < 200.0F  && vecPlayer.distanceTo(vecTest) > 10.0F)
					{
						world.playSoundAtEntity(test, (Main.MODID + ":cannon1"), (float) (200-(vecPlayer.distanceTo(vecTest)))/400, 1.0F);	
					}
				}

				if(tile.getStackInSlot(1)!=null){
					if(tile.getStackInSlot(1).getItem()==ball){
						tile.decrStackSize(1, 1);
						cannonball = new EntityCannonBall(world, (double)x+((Math.sin(Math.toRadians(angles[world.getBlockMetadata(x, y, z)])))/2), (double)y+0.5, (double)z+((Math.cos(Math.toRadians(angles[world.getBlockMetadata(x, y, z)])))/2), null);
						//System.out.println(angles[world.getBlockMetadata(x, y, z)]);
						//System.out.println(Math.cos(Math.toRadians(angles[world.getBlockMetadata(x, y, z)])));
						//System.out.println(Math.sin(Math.toRadians(angles[world.getBlockMetadata(x, y, z)])));
						//cannonball.setVelocity(((tile.getStackInSlot(0).stackSize*(Math.sin(Math.toRadians(angles[world.getBlockMetadata(x, y, z)]))))-(world.rand.nextFloat()/4)),0.25, ((tile.getStackInSlot(0).stackSize*(Math.cos(Math.toRadians(angles[world.getBlockMetadata(x, y, z)]))))-(world.rand.nextFloat()/4)));
						cannonball.motionX = ((tile.getStackInSlot(0).stackSize*(Math.sin(Math.toRadians(angles[world.getBlockMetadata(x, y, z)]))))-(world.rand.nextFloat()/4));
						cannonball.motionY = 0.02;
						cannonball.motionZ = ((tile.getStackInSlot(0).stackSize*(Math.cos(Math.toRadians(angles[world.getBlockMetadata(x, y, z)]))))-(world.rand.nextFloat()/4));
						tile.setInventorySlotContents(0, null);
						tile.markForUpdate();
						tile.markDirty();
					}
				}
			}
		}
		tile.markForUpdate();
		tile.markDirty();
		return cannonball;
	}
	@Override
	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {

		if(!world.isRemote){
			TileCannon_28 tileEnt = (TileCannon_28) world.getTileEntity(x, y, z);
			if(tileEnt.isOn==false){
				if(player.inventory.getCurrentItem()!=null){
					if(player.inventory.getCurrentItem().getItem()==Items.flint_and_steel){
						world.spawnEntityInWorld(shootCannon(world,x,y,z));
						tileEnt.smoke=true;
						tileEnt.markForUpdate();
						tileEnt.markDirty();
						return true;
					}
				}
			}
			if (!player.isSneaking()) {
				if(player.inventory.getCurrentItem()==null||player.inventory.getCurrentItem().getItem()!=Items.flint_and_steel){
					player.openGui(Main.instance, GuiHandler.guiIDcannon28, world, x, y, z);
					return true;
				}
			}
		}

		return false;
	}
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
		if(!world.isRemote){
			if (world.isBlockIndirectlyGettingPowered(x, y, z))
			{
				TileCannon_28 tileEnt = (TileCannon_28) world.getTileEntity(x, y, z);
				if(tileEnt.isOn==false){
					world.spawnEntityInWorld(shootCannon(world, x, y, z));
					tileEnt.smoke = true;
					tileEnt.markForUpdate();
					tileEnt.markDirty();
				}
			}
		}
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	/*@Override
	public void setBlockBoundsBasedOnState(IBlockAccess iBlock, int x, int y, int z)
	{
		int l = iBlock.getBlockMetadata(x, y, z) & 7;

		switch (l)
		{
		case 1:
		default:
			this.setBlockBounds(0F, 0.0F, 0F, 1F, 1F, 1F);
			break;
		case 2:
			this.setBlockBounds(0F, 0.0F, 0F, 1F, 1F, 1F);
			break;
		case 3:
			this.setBlockBounds(0F, 0.0F, 0F, 1F, 1F, 1F);
			break;
		case 4:
			this.setBlockBounds(0F, 0.0F, 0F, 1F, 1F, 1F);
			break;
		case 5:
			this.setBlockBounds(0F, 0.0F, 0F, 1F, 1F, 1F);
		}
	}*/

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
	 * cleared to be reused)
	 */
	/*@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		this.setBlockBoundsBasedOnState(world, x, y, z);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}*/
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		//22.5
		//11.25
		if(!world.isRemote){
			double a = living.rotationYaw;
			if (a<0){
				a=360+a;
			}
			//a = a;
			System.out.println(living.rotationYaw);
			System.out.println(a);
			if(a >= 180-11.25 && a <= 180+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 0, 2);
				System.out.println("0");
			}
			if(a >= 202.5-11.25 && a <= 202.5+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 1, 2);
				System.out.println("1");
			}
			if(a >= 225-11.25 && a <= 225+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 2, 2);
				System.out.println("2");
			}
			if(a >= 247.5-11.25 && a <= 247.5+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 3, 2);
				System.out.println("3");
			}
			if(a >= 270-11.25 && a <= 270+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 4, 2);
				System.out.println("4");
			}
			if(a >= 292.5-11.25 && a <= 292.5+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 5, 2);
				System.out.println("5");
			}
			if(a >= 315-11.25 && a <= 315+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 6, 2);
				System.out.println("6");
			}
			if(a >= 337.5-11.25 && a <= 337.5+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 7, 2);
				System.out.println("7");
			}
			if(a <= 0+11.25 && a >=0){
				world.setBlockMetadataWithNotify(x, y, z, 8, 2);
				System.out.println("8");
			}
			if(a >= 360-11.25 && a <= 360){
				world.setBlockMetadataWithNotify(x, y, z, 8, 2);
				System.out.println("8");
			}
			if(a >= 22.5-11.25 && a <= 22.5+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 9, 2);
				System.out.println("9");
			}
			if(a >= 45-11.25 && a <= 45+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 10, 2);
				System.out.println("10");
			}
			if(a >= 67.5-11.25 && a <= 67.5+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 11, 2);
				System.out.println("11");
			}
			if(a >= 90-11.25 && a <= 90+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 12, 2);
				System.out.println("12");
			}
			if(a >= 112.5-11.25 && a <= 112.5+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 13, 2);
				System.out.println("13");
			}
			if(a >= 135-11.25 && a <= 135+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 14, 2);
				System.out.println("14");
			}
			if(a >= 157.5-11.25 && a <= 157.5+11.25){
				world.setBlockMetadataWithNotify(x, y, z, 15, 2);
				System.out.println("15");
			}
		}
	}

	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		if(!world.isRemote){
			int last = world.getBlockMetadata(x, y, z);
			if(player.isSneaking()==true){
				if(world.getBlockMetadata(x, y, z)==15){
					world.setBlockMetadataWithNotify(x, y, z, 0, 2);
					System.out.println("A: " + world.getBlockMetadata(x,y,z));
				}
				if(world.getBlockMetadata(x, y, z)<15 && last !=15){
					world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z)+1, 2);
					System.out.println("B: " + world.getBlockMetadata(x,y,z));
				}
			}
			if(!player.isSneaking()==true){
				if(world.getBlockMetadata(x, y, z)>0){
					world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z)-1, 2);
					System.out.println("C: " + world.getBlockMetadata(x,y,z));
				} 
				if(world.getBlockMetadata(x, y, z)==0 && last != 1){
					world.setBlockMetadataWithNotify(x, y, z, 15, 2);
					System.out.println("D: " + world.getBlockMetadata(x,y,z));
				}
			}
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileCannon_28 tileEnt = (TileCannon_28) world.getTileEntity(x, y, z);

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
		return new TileCannon_28();
	}
	@Override
	public int getRenderType() {
		return RenderId.cannon_28ID;
	}
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand)
	{
		super.randomDisplayTick(world, x, y, z, random);
	}

}
/*
if(world.isRemote){
	TileCannon_28 tileEnt = (TileCannon_28) world.getTileEntity(x, y, z);
	if(tileEnt.smoke==true){
		System.out.println("make smoke");
		for(int f = 0; f < 10; f++){
			world.spawnParticle("cloud", x + (Math.sin(Math.toRadians(angles[world.getBlockMetadata(x, y, z)])))+world.rand.nextFloat()/10, y+world.rand.nextFloat()/10, z + (Math.cos(Math.toRadians(angles[world.getBlockMetadata(x, y, z)]))+world.rand.nextFloat()/10),
					(Math.sin(Math.toRadians(angles[world.getBlockMetadata(x, y, z)])))/5, 0.2D, (Math.cos(Math.toRadians(angles[world.getBlockMetadata(x, y, z)])))/5);
		}
		tileEnt.smoke=false;
	}
}
 */
