package nmd.primal.forgecraft.tiles;

import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import nmd.primal.forgecraft.items.blocks.ItemGearbox;
import nmd.primal.forgecraft.items.enginetools.BaseEngineTool;

public class TileMachineSaw extends TileBaseSlot /*implements ITickable*/ {



    private float torque;
    private float power;
    private float rpm;

    private int redstone;
    private float gearMulti;

    private boolean transfer;
    private boolean playSound;

    public int getRedstone() {
        return redstone;
    }

    public void setRedstone(int redstone) {
        this.redstone = redstone;
    }

    public float getGearMulti() {
        return gearMulti;
    }

    public void setGearMulti(float gearMulti) {
        this.gearMulti = gearMulti;
    }

    public void setTorque(float torque) {
        this.torque = torque;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public void setRpm(float rpm) {
        this.rpm = rpm;
    }

    public float getTorque() {
        return torque;
    }

    public float getPower() {
        return power;
    }

    public float getRpm() {
        return rpm;
    }

    public boolean getTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }
    public boolean getPlaySound() {
        return playSound;
    }

    public void setPlaySound(boolean playSound) {
        this.playSound = playSound;
    }

    public TileMachineSaw() {
    }

    public boolean isItemValidForSlot(int index, ItemStack stack) {

        if(index == 0){
            if(this.getSlotStack(0).isEmpty() && stack.getItem() instanceof BaseEngineTool) {
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
        this.torque = nbt.getFloat("torque");
        this.power = nbt.getFloat("power");
        this.rpm = nbt.getFloat("rpm");
        this.redstone = nbt.getInteger("redstone");
        this.gearMulti = nbt.getFloat("gear");
        this.transfer = nbt.getBoolean("transfer");
        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        nbt.setFloat("torque", this.torque);
        nbt.setFloat("power", this.power);
        nbt.setFloat("rpm", this.rpm);
        nbt.setInteger("redstone", this.redstone);
        nbt.setFloat("gear", this.gearMulti);
        nbt.setBoolean("transfer", this.transfer);
        super.writeNBT(nbt);
        return nbt;
    }



}
