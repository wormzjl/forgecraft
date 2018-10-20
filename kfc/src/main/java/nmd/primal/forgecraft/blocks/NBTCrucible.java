package nmd.primal.forgecraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.NBTHelper;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.items.SlottedTongs;
import nmd.primal.forgecraft.tiles.TileNBTCrucible;

import java.util.Random;

import static net.minecraft.util.EnumHand.MAIN_HAND;


/**
 * Created by mminaie on 11/11/17.
 */
public class NBTCrucible extends BlockContainer implements ITileEntityProvider {

    protected static final AxisAlignedBB boundBox = new AxisAlignedBB(4/16D, 0.0D, 4/16D, 12/16D, 7/16D, 12/16D);

    //private  Ingredient crucibleIngredients;

    public NBTCrucible(Material material, String registryName) {
        super(material);
        setUnlocalizedName(registryName);
        setRegistryName(registryName);
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        setHardness(3.0f);
        setDefaultState(this.blockState.getBaseState().withProperty(PrimalAPI.States.LAYERS, Integer.valueOf(0)));
        //setDefaultState(this.blockState.getBaseState().withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)));
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing face, float hitX, float hitY, float hitZ) {

        if (!world.isRemote) {

            TileNBTCrucible tile = (TileNBTCrucible) world.getTileEntity(pos);

            if(hand.equals(MAIN_HAND)) {

                System.out.println(player.inventory.getCurrentItem());
                System.out.println(hand);

                ItemStack pItem = player.inventory.getCurrentItem().copy();
                pItem.setCount(1);

                /**PICKS UP THE CRUCIBLE**/
                if (player.isSneaking() == false) {
                    if (pItem.isEmpty()) {
                        CrucibleCrafting recipe = CrucibleCrafting.getRecipe(tile.ingList.get(0), tile.ingList.get(1), tile.ingList.get(2), tile.ingList.get(3), tile.ingList.get(4));
                        if (recipe != null) {
                            tile.setDrops(recipe.getDropsRaw());
                        }
                        PlayerHelper.playerTakeItem(world, pos, EnumFacing.DOWN, player, player.getActiveHand(), this.getCrucibleItem(world, pos, state, player));
                        world.setBlockState(pos, this.getReplacementBlock(world, pos, state));
                        world.markTileEntityForRemoval(tile);
                        return true;
                    }
                }
            }

            /**SET INGREDIENT ARRAY FOR THE CRUCIBLE NOW**/
            if( player.inventory.getSlotFor(player.inventory.getCurrentItem()) != -1 ) {
                ItemStack pItem = player.inventory.getCurrentItem().copy();
                pItem.setCount(1);
                if (!player.isSneaking()) {
                    if (!pItem.isEmpty()) {
                        if (!tile.getStatus() || tile.getHot() == 15 || tile.getHot() == 6) {
                            if (pItem.getItem() instanceof SlottedTongs) {
                                return false;
                            } else {
                                pItem.setCount(1);
                                for (int i = 1; i < tile.ingList.size() + 1; i++) {
                                    if (tile.ingList.get(i - 1).isEmpty()) {
                                        tile.ingList.set(i - 1, pItem);
                                        tile.setHot(i);
                                        world.setBlockState(pos, state.withProperty(PrimalAPI.States.LAYERS, i), 2);
                                        player.inventory.getCurrentItem().shrink(1);
                                        tile.update();
                                        tile.markDirty();
                                        return true;
                                    }
                                }

                            }
                        }
                    }
                }
            }
                /**CLEARS THE INVENTORY**/
            if(hand.equals(MAIN_HAND)) {
                if (player.isSneaking()) {
                    ItemStack pItem = player.inventory.getCurrentItem().copy();
                    if (pItem.isEmpty()) {
                        if (tile.getHot() != 15) {
                            if (!tile.getStatus()) {
                                for (int i = 0; i < tile.ingList.size(); i++) {
                                    if (!tile.ingList.get(i).isEmpty()) {
                                        PlayerHelper.spawnItemOnPlayer(world, player, tile.ingList.get(i));
                                        tile.ingList.set(i, ItemStack.EMPTY);
                                    }
                                }
                                world.setBlockState(pos, state.withProperty(PrimalAPI.States.LAYERS, 0), 2);
                                tile.setHot(0);
                                tile.setStatus(false);
                                tile.update();
                                tile.markDirty();
                                return true;
                            }
                        }
                    }
                }
            }
                /**REMOVE COOKED ITEM**/
            if (player.isSneaking() == true) {
                if (hand.equals(MAIN_HAND)) {
                    ItemStack pItem = player.inventory.getCurrentItem().copy();
                    if (pItem.isEmpty()) {
                        if (tile.getStatus() && tile.getHot() == 6) {
                            ItemStack dropStack = tile.getDrops().copy();
                            world.setBlockState(pos, state.withProperty(PrimalAPI.States.LAYERS, 0), 2);
                            tile.setHot(0);
                            tile.setStatus(false);
                            tile.setDrops(ItemStack.EMPTY);
                            tile.ingList.clear();
                            //PlayerHelper.spawnItemOnPlayer(world, player, dropStack);
                            //PlayerHelper.spawnItemOnGround(world, player.getPosition(), dropStack);
                            EntityItem entityitem = new EntityItem(world, player.posX, player.posY, player.posZ, dropStack); // ? player.posY - 1.0D
                            world.spawnEntity(entityitem);
                            tile.update();
                            tile.markDirty();
                            return true;
                        }
                    }
                }
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

    public ItemStack getCrucibleItem(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        return  NBTHelper.getStackBlockNBT(world, pos, state, super.getPickBlock(state, null, world, pos, player));
    }

    public boolean destroyBlock(World world, BlockPos pos, IBlockState state, EnumFacing face, EntityPlayer player)
    {
        if (!world.isRemote) {
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof TileNBTCrucible) {
                //PlayerHelper.playerTakeItem(world, pos, EnumFacing.DOWN, player, player.getActiveHand(), this.getCrucibleItem(world, pos, state, player));
                ItemStack dropStack = new ItemStack(ModBlocks.nbtCrucible, 1);
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
            TileNBTCrucible tile = (TileNBTCrucible) world.getTileEntity(pos);
            CrucibleCrafting recipe = CrucibleCrafting.getRecipe(tile.ingList.get(0), tile.ingList.get(1), tile.ingList.get(2), tile.ingList.get(3), tile.ingList.get(4));
            if(recipe != null && tile.getStatus() && tile.getHot() == 6){
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
            }
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
        if (tileentity instanceof TileNBTCrucible) {
            TileNBTCrucible tile = (TileNBTCrucible) world.getTileEntity(pos);
            if(NBTHelper.hasNBT(stack)){
                NBTTagCompound tag = stack.getTagCompound();
                world.setBlockState(pos, state.withProperty(PrimalAPI.States.LAYERS, tile.getHot()), 2);
                //tile.readNBT(tag);
            }
        }
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if( state.getValue(PrimalAPI.States.LAYERS) == 0){
            i = 0;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 1){
            i = 1;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 2){
            i = 2;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 3){
            i = 3;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 4){
            i = 4;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 5){
            i = 5;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 6){
            i = 6;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 7){
            i = 7;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 8){
            i = 8;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 9){
            i = 9;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 10){
            i = 10;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 11){
            i = 11;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 12){
            i = 12;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 13){
            i = 13;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 14){
            i = 14;
            return i;
        }

        if( state.getValue(PrimalAPI.States.LAYERS) == 15){
            i = 15;
            return i;
        }

        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {

        IBlockState iblockstate = this.getDefaultState();

        if (meta == 0){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 0);
        }
        if (meta == 1){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 1);
        }
        if (meta == 2){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 2);
        }
        if (meta == 3){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 3);
        }
        if (meta == 4){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 4);
        }
        if (meta == 5){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 5);
        }
        if (meta == 6){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 6);
        }
        if (meta == 7){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 7);
        }
        if (meta == 8){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 8);
        }
        if (meta == 9){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 9);
        }
        if (meta == 10){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 10);
        }
        if (meta == 11){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 11);
        }
        if (meta == 12){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 12);
        }
        if (meta == 13){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 13);
        }
        if (meta == 14){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 14);
        }
        if (meta == 15){
            iblockstate = iblockstate.withProperty(PrimalAPI.States.LAYERS, 15);
        }
        return iblockstate;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {PrimalAPI.States.LAYERS});
    }


    @Override
    public int quantityDropped(Random random)
    {
        return 1;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileNBTCrucible();
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return boundBox;
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
