package nmd.primal.forgecraft.tiles;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * Created by mminaie on 6/19/17.
 */
public class TileCastingForm extends TileBaseSlot {

    double[] normalX = {2/16D, 4/16D, 6/16D, 8/16D, 10/16D};

    public double getNormalX(Integer x) {
        return normalX[x];
    }

    double[] normalZ = {2/16D, 4/16D, 6/16D, 8/16D, 10/16D};

    public double getNormalZ(Integer z) {
        return normalZ[z];
    }

    double[] reverseX = {10/16D, 8/16D, 6/16D, 4/16D, 2/16D};

    public double getReverseX(Integer x) {
        return reverseX[x];
    }

    double[] reverseZ = {10/16D, 8/16D, 6/16D, 4/16D, 2/16D};

    public double getReverseZ(Integer z) {
        return reverseZ[z];
    }


    public NonNullList<ItemStack> slotList = NonNullList.<ItemStack>withSize(100, ItemStack.EMPTY);

}
