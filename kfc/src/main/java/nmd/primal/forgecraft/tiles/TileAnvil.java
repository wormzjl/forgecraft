package nmd.primal.forgecraft.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.parts.ToolPart;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mminaie on 3/4/17.
 */
public class TileAnvil extends TileBaseSlot implements ITickable {

    double[] normalX = {0.125,0.3125,0.5,0.6875,0.875};

    public double getNormalX(Integer x) {
        return normalX[x];
    }

    double[] normalZ = {0.125,0.3125,0.5,0.6875,0.875};

    public double getNormalZ(Integer z) {
        return normalZ[z];
    }

    double[] reverseX = {0.875,0.6875,0.5,0.3125,0.125};

    public double getReverseX(Integer x) {
        return reverseX[x];
    }

    double[] reverseZ = {0.875,0.6875,0.5,0.3125,0.125};

    public double getReverseZ(Integer z) {
        return reverseZ[z];
    }


    public NonNullList<ItemStack> slotList = NonNullList.<ItemStack>withSize(100, ItemStack.EMPTY);

    @Override
    public void update () {
        World world = this.getWorld();
        if (!world.isRemote) {
            IBlockState state = world.getBlockState(this.pos);

            if ( ThreadLocalRandom.current().nextInt(0,10000) == 0 ) {
                for(int i=0; i<this.getSlotListSize(); i++){
                    if(this.getSlotStack(i).getItem() == ModItems.ironchunkhot){
                        if(ThreadLocalRandom.current().nextInt(0,1000) == 1){
                            this.setSlotStack(i, new ItemStack(ModBlocks.ironchunk, 1));
                            this.updateBlock();
                            this.markDirty();
                        }
                    }
                    if(this.getSlotStack(i).getItem() == ModItems.ironingotballhot){
                        if(ThreadLocalRandom.current().nextInt(0,1000) == 2){
                            this.setSlotStack(i, new ItemStack(ModBlocks.ironball, 1));
                            this.updateBlock();
                            this.markDirty();
                        }
                    }
                    if(this.getSlotStack(i).getItem() instanceof ToolPart){
                        if(ThreadLocalRandom.current().nextInt(0,1000) == 3){
                            ((ToolPart) this.getSlotStack(i).getItem()).setHot(this.getSlotStack(i), false);
                            this.updateBlock();
                            this.markDirty();
                        }
                    }
                }
            }

        }
    }


}
