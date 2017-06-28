package nmd.primal.forgecraft.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by kitsu on 12/3/2016.
 */
public abstract class BaseTile extends TileEntity{

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
        return oldState.getBlock() != newSate.getBlock();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.readNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        nbt = super.writeToNBT(nbt);
        return this.writeNBT(nbt);
    }

    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        // Override in lower tile classes
        return nbt;
    }

    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        // Override in lower tile classes
        return nbt;
    }


}
