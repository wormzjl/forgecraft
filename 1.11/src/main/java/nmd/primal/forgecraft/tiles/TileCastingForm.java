package nmd.primal.forgecraft.tiles;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * Created by mminaie on 6/19/17.
 */
public class TileCastingForm extends TileBaseSlot {

    double[] normalX = {0.125,0.3125,0.5,0.6875,0.875};

    public double getNormalX(Integer x) {
        return normalX[x];
    }

    double[] normalZ = {0.125,0.3125,0.5,0.6875,0.875};

    public double getNormalZ(Integer z) {
        return normalZ[z];
    }

    double[] reverseX = {0.875,0.6875,0.5,0.3125,0.125};

    public double getReverseX(Integer x) {
        return reverseX[x];
    }

    double[] reverseZ = {0.875,0.6875,0.5,0.3125,0.125};

    public double getReverseZ(Integer z) {
        return reverseZ[z];
    }


    public NonNullList<ItemStack> slotList = NonNullList.<ItemStack>withSize(100, ItemStack.EMPTY);

}
