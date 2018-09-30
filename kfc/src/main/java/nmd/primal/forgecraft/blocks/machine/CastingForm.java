package nmd.primal.forgecraft.blocks.machine;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import net.minecraftforge.items.IItemHandler;
import nmd.primal.forgecraft.CommonUtils;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.blocks.CustomContainerFacing;
import nmd.primal.forgecraft.crafting.CastingCrafting;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.SlottedTongs;
import nmd.primal.forgecraft.tiles.TileCastingForm;
import nmd.primal.forgecraft.util.CastingFormHandler;
import nmd.primal.forgecraft.util.ToolNBT;

import static nmd.primal.forgecraft.items.SlottedTongs.ITEM_HANDLER;

/**
 * Created by mminaie on 6/19/17.
 */
public class CastingForm extends CustomContainerFacing implements CastingFormHandler, ToolNBT {

    protected static AxisAlignedBB bound = new AxisAlignedBB(0/16D, 0.0D, 0/16D, 16/16D, 3/16D, 16/16D);

    public CastingForm(Material material, String registryName) {
        super(material, registryName);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setTickRandomly(true);
    }


    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz) {

        if (!world.isRemote) {
            TileCastingForm tile = (TileCastingForm)  world.getTileEntity(pos);
            ItemStack pItem = player.inventory.getCurrentItem();

            if(pItem.getItem() != ModItems.slottedtongs) {
                doInventoryManager(pItem, world, tile, pos, hitx, hity, hitz, state, player);
            }
            if(pItem.getItem().equals(ModItems.slottedtongs)){

                IItemHandler inventory = pItem.getCapability(ITEM_HANDLER, null);
                SlottedTongs itemstackItem = (SlottedTongs) pItem.getItem();
                ItemStack tongsStack = inventory.getStackInSlot(0).copy();

                //SlottedTongs tongs = (SlottedTongs) pItem.getItem();
                if(tongsStack.getItem().equals(Item.getItemFromBlock(ModBlocks.nbtCrucible))) {

                    NBTTagCompound tag = tongsStack.getTagCompound().copy();

                    if(tag != null){
                        NonNullList<ItemStack> ingList = NonNullList.<ItemStack>withSize(5, ItemStack.EMPTY);
                        NonNullList<ItemStack> ingListEmpty = NonNullList.<ItemStack>withSize(5, ItemStack.EMPTY);
                        ItemStackHelper.loadAllItems(tag.getCompoundTag("BlockEntityTag"), ingList);

                        CrucibleCrafting crucibleRecipe = CrucibleCrafting.getRecipe(ingList.get(0), ingList.get(1), ingList.get(2), ingList.get(3), ingList.get(4));

                        if(crucibleRecipe != null){
                            if(tag.getCompoundTag("BlockEntityTag").getBoolean("status") && tag.getCompoundTag("BlockEntityTag").getInteger("hot") == 15){
                                Item[] tempArray = new Item[25];
                                for(int i=0; i<25; i++){
                                    tempArray[i] = tile.getSlotStack(i).getItem();
                                }
                                System.out.println(crucibleRecipe.getDropsCooked());

                                CastingCrafting casting = CastingCrafting.getRecipe(crucibleRecipe.getDropsCooked(), tempArray);
                                if(casting != null){
                                    NBTTagCompound tagOutput = casting.getOutput().getTagCompound();
                                    NBTTagCompound crucibleOutput = crucibleRecipe.getDropsCooked().getTagCompound();

                                    if(tagOutput != null) {
                                        ItemStack dropStack = casting.getOutput();

                                        System.out.println(dropStack);
                                        System.out.println(crucibleOutput);

                                        dropStack.setTagCompound(new NBTTagCompound());
                                        NBTTagCompound tags = new NBTTagCompound();

                                        dropStack.getTagCompound().setTag("tags", tags);
                                        setHot(dropStack, false);
                                        if (crucibleOutput.getString("upgrades") == "emerald") {
                                            setEmerald(dropStack, true);
                                            setModifiers(dropStack, 1);
                                        } else {
                                            setEmerald(dropStack, false);
                                        }
                                        if (crucibleOutput.getString("upgrades") == "diamond") {
                                            setDiamondLevel(dropStack, 1);
                                            setModifiers(dropStack, 1);
                                        } else {
                                            setDiamondLevel(dropStack, 0);
                                        }
                                        if (crucibleOutput.getString("upgrades") == "redstone") {
                                            setRedstoneLevel(dropStack, 1);
                                            setModifiers(dropStack, 1);
                                        } else {
                                            setRedstoneLevel(dropStack, 0);
                                        }
                                        if (crucibleOutput.getString("upgrades") == "lapis") {
                                            setLapisLevel(dropStack, 1);
                                            setModifiers(dropStack, 1);
                                        } else {
                                            setLapisLevel(dropStack, 0);
                                        }

                                        CommonUtils.spawnItemEntityFromWorld(world, pos, dropStack);
                                        tag.getCompoundTag("BlockEntityTag").setBoolean("status", false);
                                        tag.getCompoundTag("BlockEntityTag").setInteger("hot", 0);
                                        ItemStackHelper.saveAllItems(tag.getCompoundTag("BlockEntityTag"), ingListEmpty);
                                        inventory.getStackInSlot(0).setTagCompound(tag);
                                        itemstackItem.markDirty(pItem);
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops"))
        {
            TileCastingForm tile = (TileCastingForm) world.getTileEntity(pos);
            if (tile !=null)
            {
                for (ItemStack stack : tile.getSlotList())
                {
                    if (stack != null) {
                        float offset = 0.7F;
                        double offsetX = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        double offsetY = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        double offsetZ = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        EntityItem item = new EntityItem(world, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, stack);
                        item.setDefaultPickupDelay();
                        world.spawnEntity(item);
                    }
                }
            }
        }

        super.breakBlock(world, pos, state);
    }


    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCastingForm();
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return bound;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        //if(!worldIn.isRemote) {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing()), 2);
        //}
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if( state.getValue(FACING) == EnumFacing.EAST) {
            i = 0;
            return i;
        }
        if( state.getValue(FACING) == EnumFacing.WEST) {
            i = 1;
            return i;
        }
        if( state.getValue(FACING) == EnumFacing.SOUTH){
            i = 2;
            return i;
        }
        if( state.getValue(FACING) == EnumFacing.NORTH){
            i = 3;
            return i;
        }
        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        if (meta == 0){
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
        }
        if (meta == 1) {
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
        }
        if (meta == 2) {
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
        }
        if (meta == 3) {
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
        }
        return iblockstate;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING});
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
