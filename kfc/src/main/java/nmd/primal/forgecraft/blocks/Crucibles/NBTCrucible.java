package nmd.primal.forgecraft.blocks.Crucibles;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
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
import nmd.primal.core.common.helper.WorldHelper;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.ItemCrucible;
import nmd.primal.forgecraft.tiles.TileBaseCrucible;
import nmd.primal.forgecraft.tiles.TileNBTCrucible;

import java.util.Random;


/**
 * Created by mminaie on 11/11/17.
 */
public class NBTCrucible extends Block implements ITileEntityProvider {

    protected static final AxisAlignedBB boundBox = new AxisAlignedBB(4/16D, 0.0D, 4/16D, 12/16D, 7/16D, 12/16D);

    private  Ingredient crucibleIngredients;

    public NBTCrucible(Material material, String registryName) {
        super(material);
        setUnlocalizedName(registryName);
        setRegistryName(registryName);
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        setHardness(3.0f);
        //crucibleIngredients.apply(new ItemStack(Blocks.IRON_ORE, 1));
    }

    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state)
    {
        return  NBTHelper.getStackBlockNBT(world, pos, state, super.getItem(world, pos, state));
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!world.isRemote) {
            TileNBTCrucible tile = (TileNBTCrucible) world.getTileEntity(pos);
            ItemStack pItem = player.inventory.getCurrentItem();
            ItemStack pItem1 = new ItemStack(pItem.getItem(), 1);
            if(pItem.isEmpty()){
                if(!player.isSneaking()) {
                    PlayerHelper.playerTakeItem(world, pos, EnumFacing.DOWN, player, this.getItem(world, pos, state));
                    //PlayerHelper.playerTakeItem(world, pos, EnumFacing.DOWN, player, this.getItem(world, pos, state));
                    return true;

                }
            }
            /**SET INGREDIENT ARRAY FOR THE CRUCIBLE NOW**/
            if(!player.isSneaking()) {
                if(!pItem.isEmpty()) {
                    for (int i = 0; i < tile.ingList.size(); i++) {
                        if (tile.ingList.get(i).isEmpty()) {
                            tile.ingList.set(i, pItem1);
                            pItem.shrink(1);
                            tile.update();
                            return true;
                        }
                    }
                }
            }
            /**CLEARS THE INVENTORY**/
            if(player.isSneaking()){
                for(int i=0; i<tile.ingList.size(); i++){
                    //if(!tile.ingList.get(i).isEmpty()) {
                        PlayerHelper.spawnItemOnPlayer(world, player, tile.ingList.get(i));
                        tile.ingList.set(i, ItemStack.EMPTY);
                    //}
                }
                tile.update();
                return true;
            }
        }
        return false;
    }

    /*@Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        /*if (!world.isRemote) {
            TileNBTCrucible tile = (TileNBTCrucible) world.getTileEntity(pos);
            for (int i = 0; i < tile.ingList.size(); i++) {
                if (!tile.ingList.get(i).isEmpty()) {
                    PlayerHelper.spawnItemOnGround(world, pos, tile.ingList.get(i));
                    tile.ingList.set(i, ItemStack.EMPTY);
                }
            }
        }
        world.removeTileEntity(pos);
    }*/

    /*@Override
    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state)
    {
        if (!world.isRemote) {
            TileNBTCrucible tile = (TileNBTCrucible) world.getTileEntity(pos);
            for (int i = 0; i < tile.ingList.size(); i++) {
                if (!tile.ingList.get(i).isEmpty()) {
                    PlayerHelper.spawnItemOnGround(world, pos, tile.ingList.get(i));
                    tile.ingList.set(i, ItemStack.EMPTY);
                }
            }
        }
    }*/

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
