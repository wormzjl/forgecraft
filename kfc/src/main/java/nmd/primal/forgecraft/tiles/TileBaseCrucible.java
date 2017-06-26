package nmd.primal.forgecraft.tiles;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import nmd.primal.forgecraft.crafting.BloomeryCrafting;

/**
 * Created by mminaie on 2/4/17.
 */
public class TileBaseCrucible extends BaseTile implements ITickable {

    private int iteration = 0;
    public int countdown = 0;

    @Override
    public void update () {
        if (!world.isRemote) {
            World world = this.getWorld();
            IBlockState state = world.getBlockState(this.pos);
            iteration++;
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
            }
        }
    }
}
