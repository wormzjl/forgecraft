package com.kitsu.medievalcraft.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.contain.ContainerFormTable;

public class GuiFormTable extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(Main.MODID + ":" + "textures/gui/formtablegui.png");
	
	public GuiFormTable(InventoryPlayer playerinv, World world, int x, int y, int z) {
		
		super(new ContainerFormTable(playerinv, world, x, y, z));
		this.xSize = 200;
		this.ySize = 200;
		
	}
	
	public void onGuiClosed(){
		super.onGuiClosed();
	}


	protected void drawGuiContainerForegroundLayer(int i, int j) {
		//Name xstart ystart color
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Form Table"), 100, 5, 0xFFFFFF);
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}
	
	

}
