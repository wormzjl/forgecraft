package nmd.primal.forgecraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by kitsu on 12/3/2016.
 */
public abstract class CustomContainerFacingActive extends BlockContainer {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    protected CustomContainerFacingActive(Material material, String registryName)
    {
        super(material);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(registryName);
        this.setHardness(3.0f);
        this.setResistance(4.0f);
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        //if(!worldIn.isRemote) {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing()).withProperty(PrimalAPI.States.ACTIVE, false), 2);
        //}
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if(!state.getValue(PrimalAPI.States.ACTIVE)) {
            if (state.getValue(FACING) == EnumFacing.EAST) {
                i = 0;
                return i;
            }
            if (state.getValue(FACING) == EnumFacing.WEST) {
                i = 1;
                return i;
            }
            if (state.getValue(FACING) == EnumFacing.SOUTH) {
                i = 2;
                return i;
            }
            if (state.getValue(FACING) == EnumFacing.NORTH) {
                i = 3;
                return i;
            }
        }
        if(state.getValue(PrimalAPI.States.ACTIVE)) {
            if (state.getValue(FACING) == EnumFacing.EAST) {
                i = 4;
                return i;
            }
            if (state.getValue(FACING) == EnumFacing.WEST) {
                i = 5;
                return i;
            }
            if (state.getValue(FACING) == EnumFacing.SOUTH) {
                i = 6;
                return i;
            }
            if (state.getValue(FACING) == EnumFacing.NORTH) {
                i = 7;
                return i;
            }
        }
        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        if (meta == 0){
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
        }
        if (meta == 1) {
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
        }
        if (meta == 2) {
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
        }
        if (meta == 3) {
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
        }
        return iblockstate;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING, PrimalAPI.States.ACTIVE});
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
}
