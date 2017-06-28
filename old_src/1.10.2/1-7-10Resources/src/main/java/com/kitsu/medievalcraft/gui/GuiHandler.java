package com.kitsu.medievalcraft.gui;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.contain.ContainerCannon_28;
import com.kitsu.medievalcraft.contain.ContainerForgeAnvil;
import com.kitsu.medievalcraft.contain.ContainerFormTable;
import com.kitsu.medievalcraft.contain.ContainerSolidFilter;
import com.kitsu.medievalcraft.contain.ContainerTestForge;
import com.kitsu.medievalcraft.tileents.cannon.TileCannon_28;
import com.kitsu.medievalcraft.tileents.machine.TileEntityAnvilForge;
import com.kitsu.medievalcraft.tileents.machine.TileEntitySolidFilter;
import com.kitsu.medievalcraft.tileents.machine.TileEntityTestForge;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    public static final int guiIDformTable = 1;
    public static final int guiIDforge = 2;
    public static final int guiIDforgeAnvil = 3; 
    public static final int guiIDsolidFilter = 4;
    public static final int guiIDcannon28 = 5;

    //returns an instance of the Container you made earlier
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
    	TileEntity entity = world.getTileEntity(x, y, z);	
        if (id == guiIDformTable) {
        	return id == guiIDformTable && world.getBlock(x, y, z) == ModBlocks.formtable ? new ContainerFormTable(player.inventory, world, x, y, z) : null;
        }
    	if (entity instanceof TileEntityTestForge) {
    		return new ContainerTestForge(player.inventory, (TileEntityTestForge) entity);
    	}
    	if (entity instanceof TileEntityAnvilForge) {
    		return new ContainerForgeAnvil(player.inventory, (TileEntityAnvilForge) entity);
    	}
    	if (entity instanceof TileEntitySolidFilter) {
    		return new ContainerSolidFilter(player.inventory, (TileEntitySolidFilter) entity);
    	}
    	if (entity instanceof TileCannon_28) {
    		return new ContainerCannon_28(player.inventory, (TileCannon_28) entity);
    	}
        return null;
    }
    
    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);	
        if (id == guiIDformTable) {
        	return id == guiIDformTable && world.getBlock(x, y, z) == ModBlocks.formtable ? new GuiFormTable(player.inventory, world, x, y, z) : null;
        }
        if (entity instanceof TileEntityTestForge) {
        	return new GuiTestForge(player.inventory, (TileEntityTestForge) entity);
        }
        if (entity instanceof TileEntityAnvilForge) {
        	return new GuiForgeAnvil(player.inventory, (TileEntityAnvilForge) entity);
        }
        if (entity instanceof TileEntitySolidFilter) {
        	return new GuiSolidFilter(player.inventory, (TileEntitySolidFilter) entity);
        }
        if (entity instanceof TileCannon_28) {
        	return new GuiCannon_28(player.inventory, (TileCannon_28) entity);
        }
        
        return null;
    }
    
    

}
