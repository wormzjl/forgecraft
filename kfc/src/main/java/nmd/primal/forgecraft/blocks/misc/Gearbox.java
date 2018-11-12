package nmd.primal.forgecraft.blocks.misc;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nmd.primal.core.common.helper.NBTHelper;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.blocks.CustomContainerFacing;
import nmd.primal.forgecraft.tiles.TileGearbox;

import java.util.Random;


/**
 * Created by mminaie on 11/11/17.
 */
public class Gearbox extends CustomContainerFacing implements ITileEntityProvider {

    protected static final AxisAlignedBB boundBox = new AxisAlignedBB(4/16D, 0.0D, 4/16D, 12/16D, 7/16D, 12/16D);

    //private  Ingredient crucibleIngredients;

    public Gearbox(Material material, String registryName) {
        super(material, registryName);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hands, EnumFacing face, float hitX, float hitY, float hitZ) {

        if (!world.isRemote) {

            TileGearbox tile = (TileGearbox) world.getTileEntity(pos);
            ItemStack slot0 = tile.getSlotStack(0);
            ItemStack slot1 = tile.getSlotStack(1);
            ItemStack slot2 = tile.getSlotStack(2);
            ItemStack playerStack = player.getHeldItemMainhand();

            if (slot2.isEmpty()) {
                if (state.getValue(FACING) == EnumFacing.NORTH) {
                    if (hitX < 0.5) {
                        return sideInventoryManager(world, player, tile, slot0, 0);
                    }
                    if (hitX > 0.5) {
                        return sideInventoryManager(world, player, tile, slot1, 1);
                    }

                    return true;
                }
                if (state.getValue(FACING) == EnumFacing.SOUTH) {
                    if (hitX > 0.5) {
                        return sideInventoryManager(world, player, tile, slot0, 0);
                    }
                    if (hitX < 0.5) {
                        return sideInventoryManager(world, player, tile, slot1, 1);
                    }

                    return true;
                }
                if (state.getValue(FACING) == EnumFacing.EAST) {
                    if (hitZ < 0.5) {
                        return sideInventoryManager(world, player, tile, slot0, 0);
                    }
                    if (hitZ > 0.5) {
                        return sideInventoryManager(world, player, tile, slot1, 1);
                    }

                    return true;
                }
                if (state.getValue(FACING) == EnumFacing.WEST) {
                    if (hitZ > 0.5) {
                        return sideInventoryManager(world, player, tile, slot0, 0);
                    }
                    if (hitZ < 0.5) {
                        return sideInventoryManager(world, player, tile, slot1, 1);
                    }

                    return true;
                }
                if (tile.isItemValidForSlot(2, playerStack)) {
                    return sideInventoryManager(world, player, tile, slot0, 2);
                }
            }

        }

        return false;
    }

    private boolean sideInventoryManager(World world, EntityPlayer player, TileGearbox tile, ItemStack slot, int index)
    {
        if(!player.isSneaking()) {
            ItemStack stack = player.getHeldItemMainhand();
            if (slot.isEmpty()) {
                if(tile.isItemValidForSlot(index, slot)) {
                    tile.setSlotStack(index, stack);
                    player.setHeldItem(EnumHand.MAIN_HAND, ItemStack.EMPTY);
                    //player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                    return true;
                }
            }
        }
        if(player.isSneaking()){
            if(!slot.isEmpty()){
                PlayerHelper.spawnItemOnPlayer(world, player, tile.getSlotStack(index));
                tile.clearSlot(index);
                return true;
            }
        }
        return false;
    }

    private IBlockState getReplacementBlock(World world, BlockPos pos, IBlockState state)
    {
        return Blocks.AIR.getDefaultState();
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
    {
        this.onBlockHarvested(world, pos, state, player);
        return this.destroyBlock(world, pos, state, EnumFacing.UP, player);
    }

    public ItemStack getThisItem(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        return  NBTHelper.getStackBlockNBT(world, pos, state, super.getPickBlock(state, null, world, pos, player));
    }

    public boolean destroyBlock(World world, BlockPos pos, IBlockState state, EnumFacing face, EntityPlayer player)
    {
        if (!world.isRemote) {
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof TileGearbox) {
                //PlayerHelper.playerTakeItem(world, pos, EnumFacing.DOWN, player, player.getActiveHand(), this.getCrucibleItem(world, pos, state, player));
                ItemStack dropStack = new ItemStack(this, 1);
                PlayerHelper.spawnItemOnPlayer(world, player, dropStack);
                world.setBlockState(pos, this.getReplacementBlock(world, pos, state));
                world.markTileEntityForRemoval(tile);
                return true;
            }
        }
        return false;
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        if (!world.isRemote) {
            TileGearbox tile = (TileGearbox) world.getTileEntity(pos);
            //CrucibleCrafting recipe = CrucibleCrafting.getRecipe(tile.ingList.get(0), tile.ingList.get(1), tile.ingList.get(2), tile.ingList.get(3), tile.ingList.get(4));
            /*if(recipe != null && tile.getStatus() && tile.getHot() == 6){
                if(tile.getDrops() != null) {
                    PlayerHelper.spawnItemOnPlayer(world, player, recipe.getDropsCooked());
                } else {
                    PlayerHelper.spawnItemOnPlayer(world, player, recipe.getDropsRaw());
                }
            }
            if(recipe != null && tile.getStatus() && tile.getHot() == 15){
                PlayerHelper.spawnItemOnPlayer(world, player, recipe.getDropsRaw());
            }
            if(!tile.getStatus() && tile.getHot() != 15 && tile.getHot() != 6){
                PlayerHelper.spawnItemOnPlayer(world, player, tile.ingList);
            }*/
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        // see above onBlockHarvested
        return null;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        TileEntity tileentity = world.getTileEntity(pos);
        if (tileentity instanceof TileGearbox) {
            TileGearbox tile = (TileGearbox) world.getTileEntity(pos);
            if(NBTHelper.hasNBT(stack)){
                NBTTagCompound tag = stack.getTagCompound();
                world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing()), 2);
                //tile.readNBT(tag);
            }
        }
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 1;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileGearbox();
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return boundBox;
    }
}
