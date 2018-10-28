package nmd.primal.forgecraft.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.core.common.items.tools.Gallagher;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.items.parts.WeaponGuard;
import nmd.primal.forgecraft.items.parts.WeaponPart;
import nmd.primal.forgecraft.items.tools.CustomAxe;
import nmd.primal.forgecraft.items.tools.CustomHoe;
import nmd.primal.forgecraft.items.tools.CustomPickaxe;
import nmd.primal.forgecraft.items.tools.CustomShovel;

public class TileSharpBench extends TileBaseSlot implements ITickable {

    private int iteration = 0;

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    private int charge;

    @Override
    public void update () {
        World world = this.getWorld();
        if (!world.isRemote) {
            IBlockState state = world.getBlockState(this.pos);

            if(state.getValue(PrimalAPI.States.ACTIVE)){
                this.iteration++;
                if(iteration > 80){
                    if(charge > 0){
                        charge -= 1;
                    }
                    iteration = 0;
                }
            }
        }
    }

    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if(index == 0){
            if(stack.getItem()== ModItems.grindingwheel){
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
        this.charge = nbt.getInteger("charge");
        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        nbt.setInteger("charge", this.charge);
        super.writeNBT(nbt);
        return nbt;
    }
}
