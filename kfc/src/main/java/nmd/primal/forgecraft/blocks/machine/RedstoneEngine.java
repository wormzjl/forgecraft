package nmd.primal.forgecraft.blocks.machine;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.forgecraft.blocks.CustomContainerFacingActive;
import nmd.primal.forgecraft.tiles.TileRedstoneEngine;

import javax.annotation.Nullable;
import java.util.Random;

public class RedstoneEngine extends CustomContainerFacingActive {

    protected static final AxisAlignedBB boundBoxNorth = new AxisAlignedBB(0/16D, 0/16D, 0/16D, 10/16D, 27 / 32D, 16/16D);
    protected static final AxisAlignedBB boundBoxSouth = new AxisAlignedBB(6/16D, 6/16D, 0/16D, 1, 27 / 32D, 16/16D);
    protected static final AxisAlignedBB boundBoxEast = new AxisAlignedBB(0/16D, 0/16D, 0/16D, 16/16D, 27 / 32D, 10/16D);
    protected static final AxisAlignedBB boundBoxWest = new AxisAlignedBB(0/16D, 0/16D, 6/16D, 1, 27 / 32D, 16/16D);

    public RedstoneEngine(Material material, String registryName) {
        super(material, registryName);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!world.isRemote) {
            if(hand.equals(EnumHand.MAIN_HAND)) {
                TileRedstoneEngine tile = (TileRedstoneEngine) world.getTileEntity(pos);
                ItemStack playerStack = player.getHeldItem(hand);
                Chunk chunk = world.getChunkFromBlockCoords(pos);

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
                    tile.setTransfer(true);

                    if( world.getRedstonePower(pos.down(), EnumFacing.UP)>0 ||
                            world.getRedstonePower(pos.offset(state.getValue(FACING).getOpposite()), state.getValue(FACING))>0 ) {
                        if(world.getRedstonePower(pos.down(), EnumFacing.UP) > world.getRedstonePower(pos.offset(state.getValue(FACING).getOpposite()), state.getValue(FACING))){
                            tile.setRedstone(world.getRedstonePower(pos.down(), EnumFacing.UP));
                        } else {
                            tile.setRedstone(world.getRedstonePower(pos.offset(state.getValue(FACING).getOpposite()), state.getValue(FACING)));
                        }
                        tile.setPower();
                        this.setValues(tile);
                    }
                    world.markAndNotifyBlock(pos, chunk, state, state, 3);
                    return true;
                }
                if(playerStack.isEmpty()){
                    if(player.isSneaking()){
                        PlayerHelper.spawnItemOnPlayer(world, player, tile.slotList);
                        tile.clearSlots();
                        tile.setTransfer(false);
                        world.markAndNotifyBlock(pos, chunk, state, state, 3);
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
                    int power = world.isBlockIndirectlyGettingPowered(pos);
                    tile.setRedstone(power);
                    tile.setPower();
                    this.setValues(tile);
                    world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, true), 3);
                }
                if (!world.isBlockPowered(pos)) {
                    tile.setRedstone(0);
                    tile.setPower();
                    this.setValues(tile);
                    world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, false), 3);
                }
            }
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        if(state.getValue(FACING).equals(EnumFacing.NORTH)){
            return boundBoxNorth;
        }
        if(state.getValue(FACING).equals(EnumFacing.SOUTH)){
            return boundBoxSouth;
        }
        if(state.getValue(FACING).equals(EnumFacing.EAST)){
            return boundBoxEast;
        }
        if(state.getValue(FACING).equals(EnumFacing.WEST)){
            return boundBoxWest;
        }
        return boundBoxNorth;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileRedstoneEngine();
    }

    private void setValues(TileRedstoneEngine tile){
        if(!tile.getSlotStack(0).isEmpty()){
            NonNullList<ItemStack> gearboxList = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
            if(tile.getSlotStack(0).getSubCompound("BlockEntityTag") != null) {
                ItemStackHelper.loadAllItems(tile.getSlotStack(0).getSubCompound("BlockEntityTag"), gearboxList);
                if (RecipeHelper.isOreName(gearboxList.get(0), "gearPrimalMedium") &&
                        RecipeHelper.isOreName(gearboxList.get(1), "gearPrimalMedium") &&
                        RecipeHelper.isOreName(gearboxList.get(2), "gearboxCoverPrimal")) {
                    tile.setRPM(1200F/(60-2*tile.getRedstone()));
                    tile.setTorque(tile.getPower()/tile.getRPM());
                    tile.setGearMulti(1F);
                }
                if (RecipeHelper.isOreName(gearboxList.get(0), "gearPrimalSmall") &&
                        RecipeHelper.isOreName(gearboxList.get(1), "gearPrimalLarge") &&
                        RecipeHelper.isOreName(gearboxList.get(2), "gearboxCoverPrimal")) {
                    tile.setRPM((1200F/(60-2*tile.getRedstone()))*4);
                    tile.setTorque(tile.getPower()/tile.getRPM());
                    tile.setGearMulti(4F);
                }
                if (RecipeHelper.isOreName(gearboxList.get(0), "gearPrimalLarge") &&
                        RecipeHelper.isOreName(gearboxList.get(1), "gearPrimalSmall") &&
                        RecipeHelper.isOreName(gearboxList.get(2), "gearboxCoverPrimal")) {

                    tile.setRPM((1200F/(60-2*tile.getRedstone()))/4);
                    tile.setTorque(tile.getPower()/tile.getRPM());
                    tile.setGearMulti(0.25F);
                }
            }
        }
    }

}
