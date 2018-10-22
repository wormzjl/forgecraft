package nmd.primal.forgecraft.util;

import net.minecraft.item.ItemStack;

public interface SlotHelper {

    default void doFuelSlotManagement(ItemStack tileSlot, ItemStack playerSlot){



        /***
         *
         * if fuelSlot is empty and playeritem is valid, set fuelSlot playerItem and clear player item
         *
         * if fuelSlot isn't empty and player item matches
         * if fuelSLot + playerItem <= 64 set Fuelslot to fuelSlot.count plus playerItem.count and clear playerItem
         * if fuelSlot + playeritem > 64
         *      do 64 - fuelSlot
         *      add that to fuel slot
         *      decrment that from playerItem
         *
         *
         */

    }

}
