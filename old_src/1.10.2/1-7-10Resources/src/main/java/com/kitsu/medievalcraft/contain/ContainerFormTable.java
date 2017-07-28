package com.kitsu.medievalcraft.contain;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.crafting.FormTableCraftManager;

public class ContainerFormTable extends Container {

	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	
	public ContainerFormTable (InventoryPlayer invplayer, World world, int x, int y, int z) {
		craftMatrix = new InventoryCrafting (this, 5, 5);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;
		
		this.addSlotToContainer(new SlotCrafting(invplayer.player, craftMatrix, craftResult, 0, 141, 43));
		
		for(int i=0; i<5; i++) {
			for (int k=0; k<5; k++) {
				this.addSlotToContainer (new Slot(craftMatrix, k+i*5, 8+k*18, 7+i*18));
			}
		}
		
		for(int i=0; i<3; i++) {
			for (int k=0; k<9; k++) {
				this.addSlotToContainer (new Slot(invplayer, k+i*9+9, 8+k*18, 106+i*18));
			}
		}
		
		for(int i=0; i<9; i++) {
			this.addSlotToContainer (new Slot(invplayer, i, 8+i*18, 164));
		}
		
		onCraftMatrixChanged(craftMatrix);
	}
	
    public void onCraftMatrixChanged (IInventory iinventory) {
    	craftResult.setInventorySlotContents(0,FormTableCraftManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
    }
    
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		
		if (worldObj.getBlock(posX, posY, posZ) != ModBlocks.formtable) {
			return false;	
		}
		return player.getDistanceSq(posX + 0.5D, posY + 0.5D, posZ + 0.5D) <= 64.0D;
	}
	
    /**
     * Called when the container is closed.
     */
    /*public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 25; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    player.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }*/
	
	 public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
	    {
	        ItemStack itemstack = null;
	        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            if (p_82846_2_ == 0)
	            {
	                if (!this.mergeItemStack(itemstack1, 10, 46, true))
	                {
	                    return null;
	                }

	                slot.onSlotChange(itemstack1, itemstack);
	            }
	            else if (p_82846_2_ >= 10 && p_82846_2_ < 37)
	            {
	                if (!this.mergeItemStack(itemstack1, 37, 46, false))
	                {
	                    return null;
	                }
	            }
	            else if (p_82846_2_ >= 37 && p_82846_2_ < 46)
	            {
	                if (!this.mergeItemStack(itemstack1, 10, 37, false))
	                {
	                    return null;
	                }
	            }
	            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
	            {
	                return null;
	            }

	            if (itemstack1.stackSize == 0)
	            {
	                slot.putStack((ItemStack)null);
	            }
	            else
	            {
	                slot.onSlotChanged();
	            }

	            if (itemstack1.stackSize == itemstack.stackSize)
	            {
	                return null;
	            }

	            slot.onPickupFromSlot(p_82846_1_, itemstack1);
	        }

	        return itemstack;
	    }
}
