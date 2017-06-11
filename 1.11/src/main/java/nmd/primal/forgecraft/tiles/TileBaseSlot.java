package nmd.primal.forgecraft.tiles;

import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;

import java.util.List;

/**
 * Created by mminaie on 12/25/16.
 */
public abstract class TileBaseSlot extends BaseTile {

    public NonNullList<ItemStack> slotList = NonNullList.<ItemStack>withSize(100, ItemStack.EMPTY);

    // ***************************************************************************** //
    //  Controls
    // ***************************************************************************** //

    // ***************************************************************************** //
    //  get
    //
    public NonNullList<ItemStack> getSlotList()
    {
        return this.slotList;
    }

    public ItemStack getSlotStack(int i)
    {
        return this.slotList.get(i);
    }

    public int getSlotListSize()
    {
        return slotList.size();
    }

    public int getSlotLimit()
    {
        //return ((ShelfBasic)this.getBlockType()).getShelfSize();
        //return 1;
        return 64;
    }

    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.getSlotList(), index, count);
    }

    public ItemStack incrementStackSize(List<ItemStack> stacks, int index, int count) {
        Integer tempCount = ((ItemStack)stacks.get(index)).getCount();
        ItemStack tempStack = ((ItemStack)stacks.get(index));
        if(tempCount + count > 64) {
            tempStack.setCount(64);
        }
        if(tempCount + count <= 64) {
            tempStack.setCount(tempCount + count);
        }

        return tempStack;
    }

    // ***************************************************************************** //
    //  set
    //
    public void setSlotStack(int index, ItemStack stack)
    {
        this.slotList.set(index, stack);
        this.markDirty();
        this.updateBlock();
    }

    public void clearSlots()
    {
        this.slotList.clear();
        this.markDirty();
        this.updateBlock();
    }

    public void clearSlot(int index) {
        this.slotList.set(index, ItemStack.EMPTY);
        this.markDirty();
        this.updateBlock();

    }

    // ***************************************************************************** //
    //  NBT
    // ***************************************************************************** //
    @Override
    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        //super.readNBT(nbt);
        this.slotList = NonNullList.<ItemStack>withSize(this.getSlotListSize(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(nbt, this.slotList);

        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        //super.writeNBT(nbt);
        ItemStackHelper.saveAllItems(nbt, this.slotList);

        return nbt;
    }
}