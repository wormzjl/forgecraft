package com.kitsu.medievalcraft.item.craftingtools;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.crucible.CrucibleBase;
import com.kitsu.medievalcraft.block.ingots.IngotBase;
import com.kitsu.medievalcraft.item.TongsDamageTable;
import com.kitsu.medievalcraft.tileents.crucible.TileCrucibleBase;
import com.kitsu.medievalcraft.tileents.ingots.TileIngotBase;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;

public class SlottedTongs extends Item {

	private String name = "slottedTongs";
	private Item item;

	public SlottedTongs() {

		setMaxStackSize(1);
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		setMaxDamage(100);
		setNoRepair();
		item = this;
		GameRegistry.registerItem(this, name);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_){
		if(!world.isRemote){
			if((world.getBlock(x, y, z).getMaterial().isSolid()==true)){
				if((player.isSneaking())){
					if(stack.getItemDamage()!=0){
						if(world.getBlock(x, y+1, z).equals(Blocks.air)){
							world.setBlock(x, y+1, z, TongsDamageTable.blockToGet.get(stack.getItemDamage()), 0, 2);
							if(world.getBlock(x, y+1, z) instanceof CrucibleBase){
								TileCrucibleBase tile = (TileCrucibleBase) world.getTileEntity(x, y+1, z);
								tile.hot=true;
								stack.setItemDamage(0);
							}
							if(world.getBlock(x, y+1, z) instanceof IngotBase){
								TileIngotBase tile = (TileIngotBase) world.getTileEntity(x, y+1, z);
								tile.hot=true;
								stack.setItemDamage(0);
							}
						}
					}
				}
			}
			if((world.getBlock(x, y, z) instanceof CrucibleBase) && (player.isSneaking())){
				TileCrucibleBase tile = (TileCrucibleBase) world.getTileEntity(x, y, z);
				Block tempBlock = world.getBlock(x, y, z);
				if(tile.hot==true){
					this.setDamage(stack, TongsDamageTable.blockToStore.get(tempBlock));
					world.setBlock(x, y, z, Blocks.air, 0, 2);
				}
			}
			if((world.getBlock(x, y, z) instanceof IngotBase) && (player.isSneaking())){
				TileIngotBase tile = (TileIngotBase) world.getTileEntity(x, y, z);
				Block tempBlock = world.getBlock(x, y, z);
				if(tile.hot==true){
					this.setDamage(stack, TongsDamageTable.blockToStore.get(tempBlock));
					world.setBlock(x, y, z, Blocks.air, 0, 2);
				}
			}
		}
		return true;
	}
	
    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
        return false;
    }
    
    @Override
    public Item getContainerItem()
    {
        item.setDamage(new ItemStack(item), +1);
        return item;
    }

    public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_)
    {
        return false;
    }

}
