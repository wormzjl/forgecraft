package nmd.primal.forgecraft.tiles;

import net.minecraft.item.ItemStack;
import nmd.primal.core.common.helper.RecipeHelper;

public class TileGearbox extends TileBaseSlot /*implements ITickable*/ {

    public TileGearbox() {
    }

    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if(index == 0 || index == 1) {
            if(this.getSlotStack(0).isEmpty() && this.getSlotStack(1).isEmpty()){
                if (RecipeHelper.isOreName(stack, "gearPrimal")) {
                    return true;
                }
            }
            if(!this.getSlotStack(0).isEmpty()){
                if(index == 1){
                    if(RecipeHelper.isOreName(this.getSlotStack(0), "gearPrimalSmall") &&
                            RecipeHelper.isOreName(stack, "gearPrimalLarge")){
                        return true;
                    }
                    if(RecipeHelper.isOreName(this.getSlotStack(0), "gearPrimalLarge") &&
                            RecipeHelper.isOreName(stack, "gearPrimalSmall")){
                        return true;
                    }
                    if(RecipeHelper.isOreName(this.getSlotStack(0), "gearPrimalMedium") &&
                            RecipeHelper.isOreName(stack, "gearPrimalMedium")){
                        return true;
                    }
                }
            }
            if(!this.getSlotStack(1).isEmpty()){
                if(index == 0){
                    if(RecipeHelper.isOreName(this.getSlotStack(1), "gearPrimalSmall") &&
                            RecipeHelper.isOreName(stack, "gearPrimalLarge")){
                        return true;
                    }
                    if(RecipeHelper.isOreName(this.getSlotStack(1), "gearPrimalLarge") &&
                            RecipeHelper.isOreName(stack, "gearPrimalSmall")){
                        return true;
                    }
                    if(RecipeHelper.isOreName(this.getSlotStack(1), "gearPrimalMedium") &&
                            RecipeHelper.isOreName(stack, "gearPrimalMedium")){
                        return true;
                    }
                }
            }
        }
        if(index == 2){
            if(this.getSlotStack(2).isEmpty()) {
                if (RecipeHelper.isOreName(stack, "gearboxCoverPrimal")) {
                    return true;
                }
            }
        }
        return false;
    }

}
