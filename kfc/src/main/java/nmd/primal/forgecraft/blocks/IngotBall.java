package nmd.primal.forgecraft.blocks;

import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalAPI;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mminaie on 2/6/17.
 */
public class IngotBall extends BlockCustomBase {

    protected static AxisAlignedBB boundBoxLarge = new AxisAlignedBB(6/16D, 0.0D, 6/16D, 10/16D, 4/16D, 10/16D);
    protected static AxisAlignedBB boundBoxSmall = new AxisAlignedBB(7/16D, 0.0D, 7/16D, 9/16D, 2/16D, 9/16D);
    //public static final PropertyBool ACTIVE =  PropertyBool.create("active");
    private String type;

    public IngotBall(Material material, String registryName, Float hardness, String type){
        super(material, registryName, hardness);
        this.type = type;
        this.setTickRandomly(true);
    }


    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        if(this.type.equals("chunk")){
            return boundBoxSmall;
        }else
        return boundBoxLarge;
    }


    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        //System.out.println(stack.getItemDamage());
        worldIn.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)), 2);
        //System.out.println(state.getValue(ACTIVE));
    }

    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state)
    {

        if(!world.isRemote){
            if(state.getValue(PrimalAPI.States.ACTIVE)){
                world.setBlockState(pos, Blocks.FLOWING_LAVA.getDefaultState().withProperty(BlockDynamicLiquid.LEVEL, 1), 3);
            }
            if(!state.getValue(PrimalAPI.States.ACTIVE)){
                //PlayerHelper.spawnItemOnGround(world, pos, new ItemStack(this, 1));
            }
        }
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if(  state.getValue(PrimalAPI.States.ACTIVE) == false) {
            i = 0;
            return i;
        }
        if(  state.getValue(PrimalAPI.States.ACTIVE) == true) {
            i = 1;
            return i;
        }
        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        if (meta == 0){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false));
        }
        if (meta == 1) {
            iblockstate = iblockstate.withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(true));
        }
        return iblockstate;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {PrimalAPI.States.ACTIVE});
    }

    @Override
    public void randomTick(World world, BlockPos pos, IBlockState state, Random random)
    {
        this.updateTick(world, pos, state, random);
        if(!world.isRemote){
            if ( ThreadLocalRandom.current().nextInt(0,4) == 0) {
                if(state.getValue(PrimalAPI.States.ACTIVE) == true) {
                    world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)), 2);
                    world.playSound((EntityPlayer) null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);
                }
            }
        }
    }

}
