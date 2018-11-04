package nmd.primal.forgecraft.blocks.machine;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.blocks.CustomContainerFacingActive;
import nmd.primal.forgecraft.tiles.TileRedstoneBellows;
import javax.annotation.Nullable;
import static nmd.primal.core.common.blocks.redstone.AbstractTrigger.POWERED;

public class RedstoneBellows extends CustomContainerFacingActive {

    public RedstoneBellows(Material material, String registryName) {
        super(material, registryName);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!world.isRemote) {
            return true;
        }
        return false;
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos)
    {
        if(!world.isRemote) {

            IBlockState fromState = world.getBlockState(fromPos);
            TileRedstoneBellows tile = (TileRedstoneBellows) world.getTileEntity(pos);

            if (state.getValue(FACING) == EnumFacing.NORTH && fromPos.equals(pos.south(1))) {
                if (fromState.getValue(POWERED)) {
                    world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, true), 2);

                }
                if (!fromState.getValue(POWERED)) {
                    world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, false), 2);
                }
            }
            if (state.getValue(FACING) == EnumFacing.SOUTH && fromPos.equals(pos.north(1))) {
                if (fromState.getValue(POWERED)) {

                }
            }
            if (state.getValue(FACING) == EnumFacing.EAST && fromPos.equals(pos.west(1))) {
                if (fromState.getValue(POWERED)) {

                }
            }
            if (state.getValue(FACING) == EnumFacing.WEST && fromPos.equals(pos.east(1))) {
                if (fromState.getValue(POWERED)) {

                }
            }
        }
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileRedstoneBellows();
    }

}
