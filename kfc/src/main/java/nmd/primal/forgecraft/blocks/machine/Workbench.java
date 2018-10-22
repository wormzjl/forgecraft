package nmd.primal.forgecraft.blocks.machine;

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
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.core.common.items.tools.Gallagher;
import nmd.primal.forgecraft.blocks.CustomContainerFacing;
import nmd.primal.forgecraft.crafting.WorkbenchCrafting;
import nmd.primal.forgecraft.tiles.TileWorkbench;

import javax.annotation.Nullable;

public class Workbench extends CustomContainerFacing {


    protected static final AxisAlignedBB boundBoxNorth = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 10 / 16D, 8/16D);
    protected static final AxisAlignedBB boundBoxSouth = new AxisAlignedBB(0.0D, 0.0D, 8/16D, 1.0D, 10 / 16D, 1.0D);
    protected static final AxisAlignedBB boundBoxEast = new AxisAlignedBB(8/16D, 0.0D, 0.0D, 1.0D, 10 / 16D, 1.0D);
    protected static final AxisAlignedBB boundBoxWest = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 8/16D, 10 / 16D, 1.0D);

    public Workbench(Material material, String registryName) {
        super(material, registryName);
        this.setHardness(4.0f);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!world.isRemote) {
            if (hand.equals(hand.MAIN_HAND) ) {

                TileWorkbench tile = (TileWorkbench) world.getTileEntity(pos);
                ItemStack playerStack = player.inventory.getCurrentItem();

                if (tile != null) {
                    ItemStack slot0 = tile.getSlotStack(0);
                    ItemStack slot1 = tile.getSlotStack(1);
                    ItemStack slot2 = tile.getSlotStack(2);
                    ItemStack slot3 = tile.getSlotStack(3);
                    ItemStack slot4 = tile.getSlotStack(4);
                    ItemStack slot5 = tile.getSlotStack(5);
                    ItemStack slot6 = tile.getSlotStack(6);
                    if (hitY > 0.5D) {
                        if (!player.isSneaking()) {
                            /*if (tile.isItemValidForSlot(6, playerStack)) {
                                if (slot6.isEmpty()) {
                                    tile.setSlotStack(6, playerStack.splitStack(1));
                                    //player.inventory.getCurrentItem().shrink(1);
                                    return true;
                                }
                            }*/
                            if(! (playerStack.getItem() instanceof Gallagher)) {
                                if (slot4.isEmpty() && slot3.isEmpty() && slot2.isEmpty()) {
                                    if (tile.isItemValidForSlot(5, playerStack)) {
                                        if (slot5.isEmpty()) {
                                            tile.setSlotStack(5, playerStack.splitStack(1));
                                            //player.inventory.getCurrentItem().shrink(1);
                                            return true;
                                        }
                                    }
                                }
                                if (tile.isItemValidForSlot(4, playerStack)) {
                                    if (slot4.isEmpty()) {
                                        tile.setSlotStack(4, playerStack.splitStack(1));
                                        //player.inventory.getCurrentItem().shrink(1);
                                        return true;
                                    }
                                }
                                if (tile.isItemValidForSlot(3, playerStack)) {
                                    if (slot3.isEmpty()) {
                                        tile.setSlotStack(3, playerStack.splitStack(1));
                                        //player.inventory.getCurrentItem().shrink(1);
                                        return true;
                                    }
                                }
                                if (tile.isItemValidForSlot(2, playerStack)) {
                                    if (slot2.isEmpty()) {
                                        tile.setSlotStack(2, playerStack.splitStack(1));
                                        //player.inventory.getCurrentItem().shrink(1);
                                        return true;
                                    }
                                }
                            }
                            if(playerStack.getItem() instanceof Gallagher) {
                                if (!slot2.isEmpty() && !slot3.isEmpty() && !slot4.isEmpty() && slot5.isEmpty()) {
                                    WorkbenchCrafting recipe = WorkbenchCrafting.getRecipe(slot2, slot3, slot4, slot5);
                                    System.out.println(slot5);
                                    if (recipe != null) {
                                        ItemStack drops = recipe.getOutput();
                                        if (slot3.hasTagCompound()) {
                                            drops.setTagCompound(slot3.getTagCompound());
                                        }
                                        PlayerHelper.spawnItemOnPlayer(world, player, drops);
                                        tile.clearSlot(2);
                                        tile.clearSlot(3);
                                        tile.clearSlot(4);
                                        tile.clearSlot(5);
                                        playerStack.damageItem(1, player);
                                        return true;
                                    }
                                }
                                if (slot2.isEmpty() && slot3.isEmpty() && slot4.isEmpty() && !slot5.isEmpty()) {
                                    WorkbenchCrafting recipe = WorkbenchCrafting.getRecipe(slot2, slot3, slot4, slot5);
                                    if (recipe != null) {
                                        ItemStack drops = recipe.getOutput();
                                        if (slot5.hasTagCompound()) {
                                            drops.setTagCompound(slot5.getTagCompound());
                                            drops.setItemDamage(slot5.getItemDamage());
                                        }
                                        PlayerHelper.spawnItemOnPlayer(world, player, drops);
                                        tile.clearSlot(2);
                                        tile.clearSlot(3);
                                        tile.clearSlot(4);
                                        tile.clearSlot(5);
                                        playerStack.damageItem(1, player);
                                        return true;
                                    }
                                }
                            }
                        }
                        if(player.isSneaking()){
                            if(!slot2.isEmpty()){
                                PlayerHelper.spawnItemOnPlayer(world, player, slot2);
                                tile.clearSlot(2);
                            }
                            if(!slot3.isEmpty()){
                                PlayerHelper.spawnItemOnPlayer(world, player, slot3);
                                tile.clearSlot(3);
                            }
                            if(!slot4.isEmpty()){
                                PlayerHelper.spawnItemOnPlayer(world, player, slot4);
                                tile.clearSlot(4);
                            }
                            if(!slot5.isEmpty()){
                                PlayerHelper.spawnItemOnPlayer(world, player, slot5);
                                tile.clearSlot(5);
                            }
                            if(!slot6.isEmpty()){
                                PlayerHelper.spawnItemOnPlayer(world, player, slot6);
                                tile.clearSlot(6);
                            }

                        }
                    }
                    if (hitY < 0.5D) {
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
                    }
                }
            }
        }
        return true;
    }

    private boolean sideInventoryManager(World world, EntityPlayer player, TileWorkbench tile, ItemStack slot, int index)
    {

        if(!player.isSneaking()) {

            ItemStack stack = player.inventory.getCurrentItem();
            if (!(stack.isEmpty())  ) {
                if( stack.isItemEqual(slot) ) {
                    if (slot.getCount() < 64) {
                        if (stack.getCount() + slot.getCount() > 64) {
                            stack.shrink(64 - slot.getCount());
                            slot.setCount(64);
                            return true;
                        }
                        if (stack.getCount() + slot.getCount() < 64) {
                            slot.grow(stack.getCount());
                            stack.shrink(stack.getCount());
                            return true;
                        }
                    }
                }
                if (slot.isEmpty()) {
                    tile.setSlotStack(index, stack);
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
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

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        state = state.getActualState(source, pos);
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

        switch (enumfacing)
        {
            case EAST:
            default:
                return boundBoxEast;
            case SOUTH:
                return boundBoxSouth;
            case WEST:
                return boundBoxWest;
            case NORTH:
                return boundBoxNorth;
        }
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileWorkbench();
    }
}
