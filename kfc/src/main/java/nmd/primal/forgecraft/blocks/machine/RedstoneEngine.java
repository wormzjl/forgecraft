package nmd.primal.forgecraft.blocks.machine;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.blocks.CustomContainerFacingActive;
import nmd.primal.forgecraft.tiles.TileRedstoneEngine;

import javax.annotation.Nullable;
import java.util.Random;

public class RedstoneEngine extends CustomContainerFacingActive {

    protected static final AxisAlignedBB boundBox = new AxisAlignedBB(0/16D, 0/16D, 0/16D, 1, 9 / 16D, 1);

    public RedstoneEngine(Material material, String registryName) {
        super(material, registryName);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!world.isRemote) {
            if(hand.equals(EnumHand.MAIN_HAND)) {
                TileRedstoneEngine tile = (TileRedstoneEngine) world.getTileEntity(pos);
                ItemStack playerStack = player.getHeldItem(hand);

                if(tile.isItemValidForSlot(0, playerStack)){
                    ItemStack setStack = playerStack.copy();
                    setStack.setCount(1);
                    tile.setSlotStack(0, setStack);
                    playerStack.shrink(1);
                    return true;
                }
                if(tile.isItemValidForSlot(1, playerStack)){
                    ItemStack setStack = playerStack.copy();
                    setStack.setCount(1);
                    tile.setSlotStack(1, setStack);
                    playerStack.shrink(1);
                    return true;
                }
                if(playerStack.isEmpty()){
                    if(player.isSneaking()){
                        PlayerHelper.spawnItemOnPlayer(world, player, tile.slotList);
                        tile.clearSlots();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
        if (!world.isRemote) {
            TileRedstoneEngine tile = (TileRedstoneEngine) world.getTileEntity(pos);
            if (fromPos.equals(pos.down()) || fromPos.equals(pos.offset(state.getValue(FACING).getOpposite()))) {
                if (world.isBlockIndirectlyGettingPowered(pos)>0) {
                    world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, true), 2);
                    int power = world.isBlockIndirectlyGettingPowered(pos);
                    tile.setRedstone(power);
                    tile.updateBlock();

                }
                if (!world.isBlockPowered(pos)) {
                    world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, false), 2);
                    tile.setRedstone(0);
                    tile.updateBlock();
                }
            }
        }
    }

    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        if (state.getValue(PrimalAPI.States.ACTIVE) == Boolean.TRUE) {
            if (state.getValue(PistonBellows.FACING) == EnumFacing.NORTH) {

            }
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return boundBox;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileRedstoneEngine();
    }

}
