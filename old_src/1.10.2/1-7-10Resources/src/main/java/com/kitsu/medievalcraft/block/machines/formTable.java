package com.kitsu.medievalcraft.block.machines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.gui.GuiHandler;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class formTable extends Block {
	
	
	
	@SideOnly(Side.CLIENT)
	private IIcon formTableTop; 
	/*
	@SideOnly(Side.CLIENT)
	private IIcon formTableSide; */

	public formTable(String unlocalizedName, Material material) {
		super(material);
	
		this.setBlockName(unlocalizedName);
		//this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(3.5F);
		this.setResistance(2.0F);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (int side, int metadata) {
		
		return side == 1 ? this.formTableTop : this.blockIcon; 
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		
		this.blockIcon = iconRegister.registerIcon(Main.MODID + ":" + "formTableSide");
		this.formTableTop = iconRegister.registerIcon(Main.MODID + ":" + "formTableTop");
	}
	
	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {
		
		
		if (!player.isSneaking()) {
			player.openGui(Main.instance, GuiHandler.guiIDformTable, world, x, y, z);
			return true;
		}
		return false;
	}

}







