package com.kitsu.medievalcraft.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.contain.ContainerForgeAnvil;
import com.kitsu.medievalcraft.tileents.machine.TileEntityAnvilForge;

public class GuiForgeAnvil extends GuiContainer {
	private ResourceLocation texture = new ResourceLocation(Main.MODID + ":" + "textures/gui/forgeovengui.png");

	public GuiForgeAnvil(InventoryPlayer inventoryPlayer, TileEntityAnvilForge tileEntity) {
		super(new ContainerForgeAnvil(inventoryPlayer, tileEntity));
		// TODO Auto-generated constructor stub
	}

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		//String name = "Forge";
		
		//this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		//this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
		
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

}
