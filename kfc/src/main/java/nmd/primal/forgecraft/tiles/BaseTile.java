package nmd.primal.forgecraft.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by kitsu on 12/3/2016.
 */
public abstract class BaseTile extends TileEntity {

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
        return oldState.getBlock() != newSate.getBlock();
    }

    public void updateBlock()
    {
        // might be good
        //this.markDirty();

        World world = this.getWorld();
        IBlockState state = world.getBlockState(this.pos);
        world.notifyBlockUpdate(this.pos, state, state, 3);
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

    // ***************************************************************************** //
    //  Packets
    // ***************************************************************************** //
    @Override
    public NBTTagCompound getUpdateTag()
    {
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 0, this.writeNBT(new NBTTagCompound()));
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.readNBT(packet.getNbtCompound());
    }
}
