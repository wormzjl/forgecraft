package nmd.primal.forgecraft.blocks.machine;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.forgecraft.blocks.CustomContainerFacingActive;
import nmd.primal.forgecraft.crafting.MachineSawCrafting;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModSounds;
import nmd.primal.forgecraft.tiles.TileMachineSaw;
import nmd.primal.forgecraft.tiles.TileRedstoneEngine;

import javax.annotation.Nullable;
import java.util.Random;

public class MachineSaw extends CustomContainerFacingActive {

    public MachineSaw(Material material, String registryName) {
        super(material, registryName);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (hand.equals(EnumHand.MAIN_HAND)) {
                TileMachineSaw tile = (TileMachineSaw) world.getTileEntity(pos);
                ItemStack playerStack = player.getHeldItem(hand);

                if (tile.isItemValidForSlot(0, playerStack)) {
                    ItemStack setStack = playerStack.copy();
                    setStack.setCount(1);
                    tile.setSlotStack(0, setStack);
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
            TileMachineSaw tile = (TileMachineSaw) world.getTileEntity(pos);

            if(state.getValue(FACING).equals (EnumFacing.NORTH)){
                if(world.getBlockState(pos.west()).getBlock().equals(ModBlocks.redstoneengine)){
                    updateValues(world, pos, tile, state, pos.west());
                    sawThings(world,  pos, state, tile, fromPos);
                }

            }
            if(state.getValue(FACING).equals (EnumFacing.SOUTH)){
                if(world.getBlockState(pos.east()).getBlock().equals(ModBlocks.redstoneengine)){
                    updateValues(world, pos, tile, state, pos.east());
                    sawThings(world,  pos, state, tile, fromPos);
                }
            }
            if(state.getValue(FACING).equals (EnumFacing.EAST)){
                if(world.getBlockState(pos.north()).getBlock().equals(ModBlocks.redstoneengine)){
                    updateValues(world, pos, tile, state, pos.north());
                    sawThings(world,  pos, state, tile, fromPos);
                }
            }
            if(state.getValue(FACING).equals (EnumFacing.WEST)){
                if(world.getBlockState(pos.south()).getBlock().equals(ModBlocks.redstoneengine)){
                    updateValues(world, pos, tile, state, pos.south());
                    sawThings(world,  pos, state, tile, fromPos);
                }
            }
        }
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileMachineSaw();
    }

    private void sawThings(World world, BlockPos pos, IBlockState state, TileMachineSaw tile, BlockPos fromPos){
        if(state.getValue(PrimalAPI.States.ACTIVE) && tile.getTransfer() ){
            if(fromPos.equals(pos.up())) {
                IBlockState sawState = world.getBlockState(fromPos);
                ItemStack sawStack = new ItemStack(Item.getItemFromBlock(sawState.getBlock()), 1, sawState.getBlock().getMetaFromState(sawState));
                MachineSawCrafting recipe = MachineSawCrafting.getRecipe(sawStack);
                if(recipe != null){
                    if(!recipe.isDisabled()) {
                        if(PrimalAPI.randomCheck(15-tile.getRedstone())){
                            PlayerHelper.spawnItemOnGround(world, pos.offset(state.getValue(FACING)), recipe.getOutput());
                            world.destroyBlock(pos.up(), false);
                        } else {
                            world.destroyBlock(pos.up(), true);
                        }
                    }
                }
            }
        }
    }

    private void setValues(TileMachineSaw tile, TileRedstoneEngine tileRedstoneEngine){
        tile.setPower(tileRedstoneEngine.getPower());
        tile.setTorque(tileRedstoneEngine.getTorque());
        tile.setRpm(tileRedstoneEngine.getRPM());
        tile.setRedstone(tileRedstoneEngine.getRedstone());
        tile.setGearMulti(tileRedstoneEngine.getGearMulti());
        tile.setTransfer(tileRedstoneEngine.getTransfer());
    }

    private void clearValues(TileMachineSaw tile, TileRedstoneEngine tileRedstoneEngine){
        tile.setPower(0);
        tile.setTorque(0);
        tile.setRpm(0);
        tile.setRedstone(0);
        tile.setTransfer(tileRedstoneEngine.getTransfer());
    }

    private void updateValues(World world, BlockPos pos, TileMachineSaw tile, IBlockState state, BlockPos offsetPos){
        TileRedstoneEngine tileEngine = (TileRedstoneEngine) world.getTileEntity(offsetPos);
        if(world.getBlockState(offsetPos).getValue(PrimalAPI.States.ACTIVE) && tileEngine.getTransfer()){
            setValues(tile, tileEngine);
            world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, true), 2);
        }
        if(!world.getBlockState(offsetPos).getValue(PrimalAPI.States.ACTIVE) || !tileEngine.getTransfer()){
            clearValues(tile, tileEngine);
            world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, false), 2);
            tile.markDirty();
        }
    }

}
