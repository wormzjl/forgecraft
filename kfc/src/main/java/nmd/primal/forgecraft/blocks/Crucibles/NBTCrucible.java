package nmd.primal.forgecraft.blocks.Crucibles;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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
import nmd.primal.core.api.interfaces.IPickup;
import nmd.primal.core.api.interfaces.types.ITypeNBT;
import nmd.primal.core.api.interfaces.types.ITypeWood;
import nmd.primal.core.common.helper.NBTHelper;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;
import nmd.primal.forgecraft.items.SlottedTongs;
import nmd.primal.forgecraft.tiles.TileNBTCrucible;

import java.util.Random;


/**
 * Created by mminaie on 11/11/17.
 */
public class NBTCrucible extends BlockContainer implements ITileEntityProvider, IPickup {

    protected static final AxisAlignedBB boundBox = new AxisAlignedBB(4/16D, 0.0D, 4/16D, 12/16D, 7/16D, 12/16D);

    //private  Ingredient crucibleIngredients;

    public NBTCrucible(Material material, String registryName) {
        super(material);
        setUnlocalizedName(registryName);
        setRegistryName(registryName);
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        setHardness(3.0f);
        //setDefaultState(this.blockState.getBaseState().withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)));
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing face, float hitX, float hitY, float hitZ) {

        if (!world.isRemote) {
            TileNBTCrucible tile = (TileNBTCrucible) world.getTileEntity(pos);
            ItemStack pItem = player.inventory.getCurrentItem();
            ItemStack pItem1 = new ItemStack(pItem.getItem(), 1);
            /**CLEARS THE INVENTORY**/
            if(player.isSneaking()){
                for(int i=0; i<tile.ingList.size(); i++){
                    //if(!tile.ingList.get(i).isEmpty()) {
                    PlayerHelper.spawnItemOnPlayer(world, player, tile.ingList.get(i));
                    tile.ingList.set(i, ItemStack.EMPTY);
                    //}
                }
                tile.update();
                tile.markDirty();
                return true;
            }
            /**PICKS UP THE CRUCIBLE**/
            if(pItem.isEmpty()){
                if(!player.isSneaking()) {
                    CrucibleCrafting recipe = CrucibleCrafting.getRecipe(tile.ingList.get(0), tile.ingList.get(1), tile.ingList.get(2), tile.ingList.get(3), tile.ingList.get(4));
                    if(recipe != null){
                        tile.setDrops(recipe.getDropsRaw());
                    }
                    return takeBlock(world, pos, state, face, player);
                }
            }
            /**SET INGREDIENT ARRAY FOR THE CRUCIBLE NOW**/
            if(!player.isSneaking()) {
                if(!pItem.isEmpty()) {
                    if(pItem.getItem() instanceof SlottedTongs) {
                        return false;
                    } else {
                        for (int i = 0; i < tile.ingList.size(); i++) {
                            if (tile.ingList.get(i).isEmpty()) {
                                tile.ingList.set(i, pItem1);
                                pItem.shrink(1);
                                tile.update();
                                tile.markDirty();
                                return true;
                            }
                        }
                    }
                }
            }

        }
        return false;
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
    {
        this.onBlockHarvested(world, pos, state, player);
        return this.takeBlock(world, pos, state, EnumFacing.UP, player);
    }

    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state)
    {
        return  NBTHelper.getStackBlockNBT(world, pos, state, super.getItem(world, pos, state));
    }

    public boolean takeBlock(World world, BlockPos pos, IBlockState state, EnumFacing face, EntityPlayer player)
    {
        if (world.isRemote)
            return true;

        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TileNBTCrucible) {
//World world, BlockPos pos, EnumFacing face, EntityPlayer player, EnumHand hand, ItemStack stack
            PlayerHelper.playerTakeItem(world, pos, EnumFacing.DOWN, player, player.getActiveHand(), this.getItem(world, pos, state));

            //world.updateComparatorOutputLevel(pos, state.getBlock());
            return world.setBlockState(pos, this.getReplacementBlock(world, pos, state));
        }

        return false;
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        if (!world.isRemote) {
            TileNBTCrucible tile = (TileNBTCrucible) world.getTileEntity(pos);
            ItemStack pItem = player.inventory.getCurrentItem();
            CrucibleCrafting recipe = CrucibleCrafting.getRecipe(tile.ingList.get(0), tile.ingList.get(1), tile.ingList.get(2), tile.ingList.get(3), tile.ingList.get(4));
            System.out.println("Harvested" + tile.getStatus() + " | " + tile.getHot());
            if(recipe != null && tile.getStatus() && !tile.getHot()){
                PlayerHelper.spawnItemOnPlayer(world, player, tile.getDrops());
                System.out.println("Drop stuff");
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
        if (tileentity instanceof TileNBTCrucible)
        {
            TileNBTCrucible tile = (TileNBTCrucible) world.getTileEntity(pos);
            NBTTagCompound tag = stack.getSubCompound("BlockEntityTag").copy();
            //tile.writeNBT(tag);
            tile.setHot(tag.getBoolean("hot"));
        }
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        TileNBTCrucible tile = (TileNBTCrucible) world.getTileEntity(pos);
        if (tile != null && tile instanceof TileNBTCrucible) {
            System.out.println("Hot:" + tile.getHot() + " Status: " + tile.getStatus());
            if(tile.getHot()){
                System.out.println("Should Be Red");
                return state.withProperty(PrimalAPI.States.ACTIVE, true);
            }
            if(!tile.getHot()){
                System.out.println("Should Be Brown");
                return state.withProperty(PrimalAPI.States.ACTIVE, false);
            }
        }
        return state;
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
