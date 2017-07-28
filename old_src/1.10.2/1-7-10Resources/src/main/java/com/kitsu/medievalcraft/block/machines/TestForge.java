package com.kitsu.medievalcraft.block.machines;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.machine.TileEntityTestForge;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TestForge extends BlockContainer {
	
	//private static double s= 0.25;
	//private static double a=0.75;
	private final Random random = new Random();
	public static boolean makeIngot;
	public static int ticks;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconSide;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconBot;

	public TestForge(String unlocalizedName, Material mat) {
		super(mat);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(2.0F);
		this.setResistance(6.0F);
		this.setStepSound(Block.soundTypeStone);

	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Main.MODID + ":" + "forgeside");
		this.iconSide = iconRegister.registerIcon(Main.MODID + ":" + "forgeside");
		this.iconBot  = iconRegister.registerIcon(Main.MODID + ":" + "forgebot");
		this.iconTop   = iconRegister.registerIcon(Main.MODID + ":" + "forgetop");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		
		return side == 1 ? this.iconTop : (side == 0 ? this.iconBot : (side != metadata ? this.blockIcon : this.iconSide));
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		
		return new TileEntityTestForge();
	}
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int metadata, float what, float these, float are) {
    	FMLNetworkHandler.openGui(player, Main.instance, 2, world, x, y, z);
    	return true;
    }
    
	public Item getItemDropped(int par1, Random random, int par3) {
		return null;
	}

	public Item getItem(World world, int par2, int par3, int par4) {
		//return Item.getItemFromBlock(ModBlocks.testForge);
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		super.randomDisplayTick(world, x, y, z, random);
		TileEntityTestForge tileEnt = (TileEntityTestForge) world.getTileEntity(x, y, z);
		
		/*if(tileEnt.isRunning == true){
			
		}*/
		/*Block test = world.getBlock(x, y+1, z);
		if (test == TestForgeCrafting.blockToCheck.get(0) || test == TestForgeCrafting.blockToCheck.get(1) || test == TestForgeCrafting.blockToCheck.get(2) 
				|| test == TestForgeCrafting.blockToCheck.get(3) || test == TestForgeCrafting.blockToCheck.get(4)) {
			if (world.canBlockSeeTheSky(x, y+2, z)){
				
			for(int i = 1; i <11; i++){
				//world.setBlockMetadataWithNotify(x, y, z, 1, 2);
				world.spawnParticle("cloud", x + a, y+i+1, z + s, 0, 0.1F, 0);
				world.spawnParticle("largesmoke", x + a, y+i+1, z + s, 0, 0.1F, 0);
				world.spawnParticle("cloud", x + s, y+i+1, z + a, 0, 0.1F, 0);
				world.spawnParticle("largesmoke", x + s, y+i+1, z + a, 0, 0.1F, 0);
				world.spawnParticle("cloud", x + a, y+i+1, z + a, 0, 0.1F, 0);
				world.spawnParticle("largesmoke", x + a, y+i+1, z + a, 0, 0.1F, 0);
				world.spawnParticle("cloud", x + s, y+i+1, z + s, 0, 0.1F, 0);
				world.spawnParticle("largesmoke", x + s, y+i+1, z + s, 0, 0.1F, 0);
			}
			}
		}*/

	}
    
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
			TileEntityTestForge tileEntTestForge = (TileEntityTestForge) world.getTileEntity(x, y, z);

			if (tileEntTestForge != null) {
				for (int i = 0; i < tileEntTestForge.getSizeInventory(); ++i) {
					ItemStack itemstack = tileEntTestForge.getStackInSlot(i);

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
}





















