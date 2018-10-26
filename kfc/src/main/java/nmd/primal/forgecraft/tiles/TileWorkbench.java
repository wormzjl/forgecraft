package nmd.primal.forgecraft.tiles;

import net.minecraft.item.ItemStack;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.core.common.items.tools.Gallagher;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.items.parts.WeaponGuard;
import nmd.primal.forgecraft.items.parts.WeaponPart;
import nmd.primal.forgecraft.items.tools.CustomAxe;
import nmd.primal.forgecraft.items.tools.CustomHoe;
import nmd.primal.forgecraft.items.tools.CustomPickaxe;
import nmd.primal.forgecraft.items.tools.CustomShovel;

public class TileWorkbench extends TileBaseSlot{
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        /*if(index == 0){
            if(RecipeHelper.isOreName(stack.getItem(), "stickTreatedWood") ||
                    RecipeHelper.isOreName(stack.getItem(), "stickLacquer") ||
                    RecipeHelper.isOreName(stack.getItem(), "cordageGeneral")){
                return true;
            }
        }
        if(index == 1){
            if(RecipeHelper.isOreName(stack.getItem(), "stickTreatedWood") ||
                    RecipeHelper.isOreName(stack.getItem(), "stickLacquer") ||
                    RecipeHelper.isOreName(stack.getItem(), "cordageGeneral")){
                return true;
            }
        }*/
        if(index == 2){
            if(RecipeHelper.isOreName(stack.getItem(), "stickTreatedWood") ||
                    RecipeHelper.isOreName(stack.getItem(), "stickLacquer") ||
                    RecipeHelper.isOreName(stack.getItem(), "cordageGeneral")){
                return true;
            }
        }
        if(index == 3){
            if ( (stack.getItem() instanceof ToolPart) || stack.getItem() instanceof WeaponPart) {
                return true;
            }
        }
        if(index == 4){
            if ( (RecipeHelper.isOreName(stack.getItem(), "pinBasic")) ||
                    stack.getItem() instanceof WeaponGuard) {
                return true;
            }
        }
        if(index == 5){
            if(stack.getItem() instanceof CustomAxe ||
                    stack.getItem() instanceof CustomHoe ||
                    stack.getItem() instanceof CustomPickaxe ||
                    stack.getItem() instanceof CustomShovel){
                return true;
            }
        }
        if(index == 6){
            if (stack.getItem() instanceof Gallagher) {
                return true;
            }
        }
        return false;
    }
}
