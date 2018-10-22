package nmd.primal.forgecraft.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.items.BaseMultiItem;
import nmd.primal.forgecraft.items.parts.ToolPart;

/**
 * Created by mminaie on 3/4/17.
 */
public class TileAnvil extends TileBaseSlot implements ITickable {

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

    private int iterate =0;

    public NonNullList<ItemStack> slotList = NonNullList.<ItemStack>withSize(100, ItemStack.EMPTY);

    @Override
    public void update () {
        World world = this.getWorld();
        if (!world.isRemote) {
            IBlockState state = world.getBlockState(this.pos);

            if(iterate == 200) {
                if (PrimalAPI.randomCheck(1800)) {
                    for (int i = 0; i < this.getSlotListSize(); i++) {
                        ItemStack slotStack = this.getSlotStack(i).copy();
                        if (!slotStack.isEmpty()) {
                            if (slotStack.getItem() instanceof ToolPart) {
                                if (slotStack.hasTagCompound()) {
                                    if (slotStack.getSubCompound("tags").getBoolean("hot")) {
                                        this.getSlotStack(i).getSubCompound("tags").setBoolean("hot", false);
                                    }
                                }
                            }
                            if (slotStack.getItem() instanceof BaseMultiItem) {
                                if (slotStack.hasTagCompound()) {
                                    if (slotStack.getTagCompound().getBoolean("hot")) {
                                        this.getSlotStack(i).getTagCompound().setBoolean("hot", false);
                                    }
                                }
                            }
                        }
                    }
                    iterate =0;
                }
            }
            iterate ++;
        }
    }
}
