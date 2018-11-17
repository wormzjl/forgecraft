package nmd.primal.forgecraft.tiles;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.forgecraft.items.blocks.ItemGearbox;
import nmd.primal.forgecraft.items.enginetools.BaseEngineTool;

public class TileRedstoneEngine extends TileBaseSlot implements ITickable {

    private int redstone; // AKA power
    private int torque;   // = power/speed
    private int speed;    // = power/torque

    public int getRedstone() { return redstone; }
    public void setRedstone(int redstone) { this.redstone = redstone; }
    public int getTorque() { return torque; }
    public void setTorque(int torque) { this.torque = torque; }
    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public TileRedstoneEngine() {
    }



    @Override
    public void update () {
        if(!world.isRemote) {
            World world = this.getWorld();
            IBlockState state = world.getBlockState(this.pos);
            BlockPos pos = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ());
            Block block = world.getBlockState(pos).getBlock();

            NonNullList<ItemStack> renderList = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
            //System.out.println(this.getSlotStack(0).getTagCompound());
            if(this.getSlotStack(0).getSubCompound("BlockEntityTag") != null) {
                ItemStackHelper.loadAllItems(this.getSlotStack(0).getSubCompound("BlockEntityTag"), renderList);
                //System.out.println(renderList);
            }
        }
    }



    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if(index == 0 ) {
            if (this.getSlotStack(0).isEmpty() && stack.getItem() instanceof ItemGearbox) {
                return true;
            }
        }

        if(index == 1){
            if(this.getSlotStack(1).isEmpty() && !this.getSlotStack(0).isEmpty() && stack.getItem() instanceof BaseEngineTool) {
                return true;
            }
        }
        return false;
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



}
