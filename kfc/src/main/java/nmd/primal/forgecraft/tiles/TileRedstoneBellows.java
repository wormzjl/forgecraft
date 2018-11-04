package nmd.primal.forgecraft.tiles;

import net.minecraft.nbt.NBTTagCompound;

public class TileRedstoneBellows extends TileBaseSlot {



    private int iteration = 0;
    private int animateIteration = 0;

    public TileRedstoneBellows() {
    }

    public int getIteration(){
        return this.iteration;
    }
    public int getAnimation(){
        return this.animateIteration;
    }

    public void doIterate(){
        if(iteration >= 0 && iteration < 4){
            iteration+=1;
            animateIteration=iteration;
        }
        if(iteration >= 4){
            iteration+=1;
            animateIteration=iteration;
        }
    }

    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        super.readNBT(nbt);
        this.iteration = nbt.getInteger("iteration");
        this.animateIteration = nbt.getInteger("animate");
        return nbt;
    }

    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        nbt.setInteger("iteration", this.iteration);
        nbt.setInteger("animate", this.animateIteration);
        return nbt;
    }

}
