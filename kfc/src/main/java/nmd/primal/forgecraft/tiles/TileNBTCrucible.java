package nmd.primal.forgecraft.tiles;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import nmd.primal.forgecraft.crafting.BloomeryCrafting;

/**
 * Created by mminaie on 11/11/17.
 */
public class TileNBTCrucible extends BaseTile implements ITickable {

    private Item drops;
    private int heat;
    private boolean hot;
    private String mod0, mod1, mod2;

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
        this.mod0 = nbt.getString("mod0");
        this.mod1 = nbt.getString("mod1");
        this.mod2 = nbt.getString("mod2");
        this.heat = nbt.getInteger("heat");
        this.hot = nbt.getBoolean("hot");
        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        nbt.setInteger("heat", this.heat);
        nbt.setString("mod0", this.mod0);
        nbt.setString("mod1", this.mod1);
        nbt.setString("mod2", this.mod2);
        nbt.setBoolean("hot", this.hot);
        super.writeNBT(nbt);
        return nbt;
    }

}
