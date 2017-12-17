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
    private String mod0, mod1, mod2;
    public NonNullList<ItemStack> ingList = NonNullList.<ItemStack>withSize(5, ItemStack.EMPTY);

    @Override
    public void update () {
        if (!world.isRemote) {
            World world = this.getWorld();
            IBlockState state = world.getBlockState(this.pos);
            /*iteration++;
            //System.out.println(iteration);
            if(iteration == 100 ){
                iteration = 0;
                countdown += 100;
                //System.out.println(countdown);
                BloomeryCrafting recipe = BloomeryCrafting.getRecipeFromOutput(new ItemStack(state.getBlock(), 1));
                if(recipe != null){
                    if (countdown > recipe.getCooldown()){
                        world.setBlockState(this.pos, Block.getBlockFromItem(recipe.getCoolOutput().getItem()).getDefaultState(), 3);
                        countdown = 0;
                    }
                }
            }*/
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
        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        ItemStackHelper.saveAllItems(nbt, this.ingList);
        nbt.setInteger("heat", this.heat);
        nbt.setBoolean("hot", this.hot);
        super.writeNBT(nbt);
        return nbt;
    }

}

/*

this.slotList = NonNullList.<ItemStack>withSize(this.getSlotListSize(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(nbt, this.slotList);

 */