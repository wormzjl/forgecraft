package nmd.primal.forgecraft.blocks;

import akka.actor.SystemGuardian;
import akka.actor.dsl.Creators;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.CommonUtils;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.tiles.TileFirebox;

import javax.annotation.Nullable;

import static net.minecraft.block.BlockHorizontal.FACING;

/**
 * Created by kitsu on 11/26/2016.
 */
public class Firebox extends CustomContainerFacing implements ITileEntityProvider {

    public static final PropertyBool ACTIVE =  PropertyBool.create("active");


    public Firebox(Material material) {
        super(material);
        setUnlocalizedName(ModInfo.ForgecraftBlocks.FIREBOX.getUnlocalizedName());
        setRegistryName(ModInfo.ForgecraftBlocks.FIREBOX.getRegistryName());
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, Boolean.valueOf(false)));
        setHardness(3.0f);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileFirebox();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            TileFirebox tile = (TileFirebox) world.getTileEntity(pos);
            if (tile != null)
            {
                ItemStack playerStack = player.getHeldItemMainhand();
                Item playerItem;
                ItemStack tileStack = tile.getStackInSlot(0);

                if(playerStack != null){
                    playerItem = playerStack.getItem();
                    if (playerItem.equals(Items.FLINT_AND_STEEL) || playerItem.equals(Item.getItemFromBlock(Blocks.TORCH))) {
                        if (CommonUtils.getVanillaItemBurnTime(tileStack) > 0) {
                            world.setBlockState(pos, state.withProperty(ACTIVE, true), 2);
                            BlockPos tempPos = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
                            if(world.getBlockState(tempPos).getBlock().equals(Blocks.AIR)){
                                world.setBlockState(tempPos, Blocks.FIRE.getDefaultState(), 2);
                                tile.markDirty();
                                world.notifyBlockUpdate(pos, state, state, 2);
                            }
                            if(playerItem.equals(Items.FLINT_AND_STEEL)){
                                player.inventory.getCurrentItem().damageItem(1, player);
                            }
                        }
                    }
                    if(tile.getStackInSlot(0)!=null){
                        if(CommonUtils.getVanillaItemBurnTime(playerStack) > 0) {
                            if (tileStack.getItem() == playerItem && tileStack.getItemDamage() == playerStack.getItemDamage()) {
                                //tile.setInventorySlotContents(0, playerStack);
                                ItemStack tempStack = new ItemStack(tileStack.getItem(), tileStack.stackSize + 1, tileStack.getItemDamage());
                                if(tileStack.stackSize < 64) {
                                    tile.setInventorySlotContents(0, tempStack);
                                    player.inventory.decrStackSize(player.inventory.currentItem, 1);
                                    //player.setHeldItem(EnumHand.MAIN_HAND, null);
                                    tile.markDirty();
                                    world.notifyBlockUpdate(pos, state, state, 2);
                                }
                            }
                        }
                    }
                    if(tile.getStackInSlot(0)==null){
                        if(CommonUtils.getVanillaItemBurnTime(playerStack) > 0) {
                            if (playerItem != Items.FLINT_AND_STEEL || playerItem != Item.getItemFromBlock(Blocks.TORCH)) {
                                tile.setInventorySlotContents(0, playerStack);
                                player.setHeldItem(EnumHand.MAIN_HAND, null);
                                tile.markDirty();
                                world.notifyBlockUpdate(pos, state, state, 2);
                            }
                        }
                    }
                }
                if(tileStack != null && playerStack == null && player.isSneaking()){
                    player.setHeldItem(EnumHand.MAIN_HAND, tile.getStackInSlot(0));
                    tile.setInventorySlotContents(0, null);
                    tile.markDirty();
                    world.notifyBlockUpdate(pos, state, state, 2);
                    if(state.getValue(ACTIVE)==true){
                        world.setBlockState(pos, state.withProperty(ACTIVE, false), 2);
                    }
                }
                if(!player.isSneaking()){
                    if(playerStack == null) {
                        if (tileStack != null) {
                            ItemStack tempStack1 = new ItemStack(tileStack.getItem(), 1, tileStack.getItemDamage());
                            ItemStack resetStack = new ItemStack(tileStack.getItem(), tileStack.stackSize - 1, tileStack.getItemDamage());
                            world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, tempStack1));
                            tile.setInventorySlotContents(0,resetStack);
                            world.notifyBlockUpdate(pos, state, state, 2);
                        }
                    }
                }
            }
        }
        return true;
    }

    public void onBlockClicked(World world, BlockPos pos, EntityPlayer player) {

    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        if(state.getValue(ACTIVE) == true){
            return 15;
        }
        return 0;
    }

    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return 0;
    }

    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return true;
    }

    @Override
    public boolean isFireSource(World world, BlockPos pos, EnumFacing side)
    {
        if (side == EnumFacing.UP)
        {
            if(!world.isRemote){
                TileFirebox tile = (TileFirebox) world.getTileEntity(pos);
                if(tile.getStackInSlot(0) != null){
                    if(world.getBlockState(pos).getValue(ACTIVE)==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
     */
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote && worldIn.getGameRules().getBoolean("doTileDrops"))
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileFirebox)
            {
                InventoryHelper.dropInventoryItems(worldIn, pos, (TileFirebox)tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        IBlockState state = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
        return state.withProperty(FACING, placer.getHorizontalFacing()).withProperty(ACTIVE, Boolean.valueOf(false));
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        if (stack.hasDisplayName()){
            ((TileFirebox) world.getTileEntity(pos)).setCustomName(stack.getDisplayName());
        }
        //System.out.println(state.getBlock().getMetaFromState(state));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if( (state.getValue(FACING) == EnumFacing.EAST) && state.getValue(ACTIVE) == false){
            i = 0;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.WEST) && state.getValue(ACTIVE) == false){
            i = 1;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.SOUTH) && state.getValue(ACTIVE) == false){
            i = 2;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.NORTH) && state.getValue(ACTIVE) == false){
            i = 3;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.EAST) && state.getValue(ACTIVE) == true){
            i = 4;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.WEST) && state.getValue(ACTIVE) == true){
            i = 5;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.SOUTH) && state.getValue(ACTIVE) == true){
            i = 6;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.NORTH) && state.getValue(ACTIVE) == true){
            i = 7;
            return i;
        }

        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing;
        Boolean active;



        switch (meta & 7)
        {
            case 0:
                enumfacing = EnumFacing.EAST;
                active = false;
                break;
            case 1:
                enumfacing = EnumFacing.WEST;
                active = false;
                break;
            case 2:
                enumfacing = EnumFacing.SOUTH;
                active = false;
                break;
            case 3:
                enumfacing = EnumFacing.NORTH;
                active = false;
                break;
            case 4:
                enumfacing = EnumFacing.EAST;
                active = true;
                break;
            case 5:
                enumfacing = EnumFacing.WEST;
                active = true;
                break;
            case 6:
                enumfacing = EnumFacing.SOUTH;
                active = true;
                break;
            case 7:
                enumfacing = EnumFacing.NORTH;
                active = true;
                break;
            default:
                enumfacing = EnumFacing.NORTH;
                active = false;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(ACTIVE, Boolean.valueOf(active));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING, ACTIVE});
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullyOpaque(IBlockState state)
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

/*
Firebox States
Off
On

 */