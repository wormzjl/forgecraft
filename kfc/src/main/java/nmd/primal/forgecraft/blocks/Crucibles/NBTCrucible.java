package nmd.primal.forgecraft.blocks.Crucibles;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.api.interfaces.IPickup;
import nmd.primal.core.common.helper.NBTHelper;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.core.common.helper.WorldHelper;
import nmd.primal.core.common.tiles.machines.TileStorageCrate;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.ItemCrucible;
import nmd.primal.forgecraft.items.SlottedTongs;
import nmd.primal.forgecraft.tiles.TileBaseCrucible;
import nmd.primal.forgecraft.tiles.TileNBTCrucible;

import java.util.Random;


/**
 * Created by mminaie on 11/11/17.
 */
public class NBTCrucible extends BlockContainer implements ITileEntityProvider, IPickup {

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
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing face, float hitX, float hitY, float hitZ) {

        if (!world.isRemote) {
            TileNBTCrucible tile = (TileNBTCrucible) world.getTileEntity(pos);
            ItemStack pItem = player.inventory.getCurrentItem();
            ItemStack pItem1 = new ItemStack(pItem.getItem(), 1);
            if(pItem.isEmpty()){
                if(!player.isSneaking()) {
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

    @Override
    public boolean takeBlock(World world, BlockPos pos, IBlockState state, EnumFacing face, EntityPlayer player)
    {
        if (world.isRemote)
            return true;

        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TileNBTCrucible) {

            PlayerHelper.playerTakeItem(world, pos, EnumFacing.DOWN, player, this.getItem(world, pos, state));

            //world.updateComparatorOutputLevel(pos, state.getBlock());
            return world.setBlockState(pos, this.getReplacementBlock(world, pos, state));
        }

        return false;
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        // Spawn the dropped daub repair_item here to avoid collision with the remaining block,
        //  otherwise the repair_item entities was getting thrown off in random directions well beyond pickup range
        //if (!world.isRemote)
        //    CommonUtils.spawnItemOnPlayer(world, player, this.getItem(world, pos, state));
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
        if (stack.hasDisplayName())
        {
            TileEntity tileentity = world.getTileEntity(pos);

            if (tileentity instanceof TileNBTCrucible)
            {
                //((TileStorageCrate)tileentity).setCustomName(stack.getDisplayName());
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
