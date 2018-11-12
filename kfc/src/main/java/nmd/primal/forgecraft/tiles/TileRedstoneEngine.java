package nmd.primal.forgecraft.tiles;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.forgecraft.blocks.CustomContainerFacing;

public class TileRedstoneEngine extends TileBaseSlot /*implements ITickable*/ {

    public int getRedstone() {
        return redstone;
    }

    public void setRedstone(int redstone) {
        this.redstone = redstone;
    }

    private int redstone;

    public TileRedstoneEngine() {
    }

    // ***************************************************************************** //
    //  NBT
    // ***************************************************************************** //
    @Override
    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        super.readNBT(nbt);
        this.redstone = nbt.getInteger("redstone");
        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        nbt.setInteger("redstone", this.redstone);
        super.writeNBT(nbt);
        return nbt;
    }

    /*@Override
    public void update () {
        if(!world.isRemote) {
            World world = this.getWorld();
            IBlockState state = world.getBlockState(this.pos);
            BlockPos pos = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ());
            Block block = world.getBlockState(pos).getBlock();
            if(world.isBlockPowered(pos)){
                if(state.getValue(CustomContainerFacing.FACING).equals(EnumFacing.NORTH)){
                    world.getEntitiesWithinAABB(Entity.class)
                }
            }
        }
    }*/

}
