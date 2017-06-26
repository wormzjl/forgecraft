package nmd.primal.forgecraft.tiles;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;

/**
 * Created by mminaie on 4/9/17.
 */
public class TileBreaker extends TileBaseSlot {

    private float charge = 0.0f;

    public float getCharge() {
        return charge;
    }

    public void setCharge(float a) {
        this.charge = a;
        this.updateBlock();
    }

    public NonNullList<ItemStack> slotList = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);

    @Override
    public int getSlotLimit() {
        return 1;
    }

    // ***************************************************************************** //
    //  NBT
    // ***************************************************************************** //
    @Override
    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        super.readNBT(nbt);
        this.charge = nbt.getFloat("charge");
        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        nbt.setFloat("charge", this.charge);
        super.writeNBT(nbt);
        return nbt;
    }

}
