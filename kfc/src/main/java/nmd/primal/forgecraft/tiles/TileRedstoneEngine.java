package nmd.primal.forgecraft.tiles;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import nmd.primal.forgecraft.items.blocks.ItemGearbox;
import nmd.primal.forgecraft.items.enginetools.BaseEngineTool;

public class TileRedstoneEngine extends TileBaseSlot {

    private int redstone; // AKA power
    private float torque;   // = power/speed
    private float power;// = 100*redstone;
    private float rpm;

    private boolean transfer = false;
    private float gearMulti;

    public float getGearMulti() { return gearMulti; }
    public void setGearMulti(float gearMulti){ this.gearMulti = gearMulti;}

    public int getRedstone() { return redstone; }
    public void setRedstone(int redstone) { this.redstone = redstone; }

    public float getTorque() { return torque; }
    public void setTorque(float torque) {
        this.torque = torque;
    }

    public float getRPM() { return rpm; }
    public void setRPM(float rpm) {
        this.rpm = rpm;
    }

    public float getPower() {return power; }
    public void setPower() { this.power = 100*redstone; }

    public boolean getTransfer() { return transfer; }
    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    public TileRedstoneEngine() {
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
        this.torque = nbt.getFloat("torque");
        this.power = nbt.getFloat("power");
        this.rpm = nbt.getFloat("rpm");
        this.transfer = nbt.getBoolean("transfer");
        this.gearMulti = nbt.getFloat("gear");
        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        nbt.setInteger("redstone", this.redstone);
        nbt.setFloat("torque", this.torque);
        nbt.setFloat("power", this.power);
        nbt.setFloat("rpm", this.rpm);
        nbt.setBoolean("transfer", this.transfer);
        nbt.setFloat("gear", this.gearMulti);
        super.writeNBT(nbt);
        return nbt;
    }



}
