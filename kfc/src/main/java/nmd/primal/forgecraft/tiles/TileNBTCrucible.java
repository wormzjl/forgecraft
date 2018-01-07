package nmd.primal.forgecraft.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

/**
 * Created by mminaie on 11/11/17.
 */
public class TileNBTCrucible extends BaseTile implements ITickable {

    private Item drops;
    private int heat;
    private boolean hot;
    private boolean status;

    public Item getDrops() {
        return drops;
    }

    public void setDrops(Item drops) {
        this.drops = drops;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public boolean getHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public NonNullList<ItemStack> getIngList() {
        return ingList;
    }

    public void setIngList(NonNullList<ItemStack> ingList) {
        this.ingList = ingList;
    }

    public NonNullList<ItemStack> ingList = NonNullList.<ItemStack>withSize(5, ItemStack.EMPTY);

    @Override
    public void update () {
        if (!world.isRemote) {
            World world = this.getWorld();
            IBlockState state = world.getBlockState(this.pos);

        }
    }

    // ***************************************************************************** //
    //  NBT
    // ***************************************************************************** //
    @Override
    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        super.readNBT(nbt);
        this.ingList = NonNullList.<ItemStack>withSize(this.ingList.size(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(nbt, this.ingList);
        this.heat = nbt.getInteger("heat");
        this.hot = nbt.getBoolean("hot");
        this.status = nbt.getBoolean("status");
        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        ItemStackHelper.saveAllItems(nbt, this.ingList);
        nbt.setInteger("heat", this.heat);
        nbt.setBoolean("hot", this.hot);
        nbt.setBoolean("status", this.status);
        super.writeNBT(nbt);
        return nbt;
    }

}

/*

this.slotList = NonNullList.<ItemStack>withSize(this.getSlotListSize(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(nbt, this.slotList);

 */