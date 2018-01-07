package nmd.primal.forgecraft.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.api.interfaces.IPickup;
import nmd.primal.core.common.helper.NBTHelper;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.tiles.TileNBTCrucible;

/**
 * Created by mminaie on 12/30/17.
 */
public class SlottedTongs extends Item implements IPickup {

    public SlottedTongs(String unlocalizedName) {
        setUnlocalizedName(unlocalizedName);
        this.setRegistryName(unlocalizedName);
        this.setMaxStackSize(1);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
    }

    public NonNullList<ItemStack> slotList = NonNullList.withSize(1, ItemStack.EMPTY);

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing face, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote){
            IBlockState state = world.getBlockState(pos);
            Block block = world.getBlockState(pos).getBlock();
            if(slotList.get(0).isEmpty() || slotList.get(0).getItem().equals(Items.AIR) || slotList.get(0).getItem().equals(Blocks.AIR)){
                ItemStack tempStack = takeBlock(world, pos, state, face, player, block).copy();
                slotList.set(0, tempStack);
                world.setBlockState(pos, this.getReplacementBlock(world, pos, state));
                return EnumActionResult.SUCCESS;
            }
            if(!slotList.get(0).isEmpty() ){
                System.out.println("Current Item:" + slotList.get(0));
                NBTTagCompound tag = this.slotList.get(0).getSubCompound("BlockEntityTag").copy();
                if(tag != null){
                    ItemBlock temp = (ItemBlock) slotList.get(0).getItem();
                    int i = this.getMetadata(slotList.get(0).getMetadata());
                    IBlockState iblockstate1 = temp.getBlock().getStateForPlacement(world, pos, face, hitX, hitY, hitZ, i, player, hand);
                    temp.placeBlockAt(slotList.get(0), player, world, pos.up(1), face, hitX, hitY, hitZ, iblockstate1);
                    slotList.set(0, ItemStack.EMPTY);
                    return EnumActionResult.SUCCESS;
                }
                return EnumActionResult.FAIL;
            }
            return EnumActionResult.FAIL;
        }
        return EnumActionResult.SUCCESS;
    }


    public ItemStack getItem(World world, BlockPos pos, IBlockState state, Block block)
    {
        block = world.getBlockState(pos).getBlock();
        return  NBTHelper.getStackBlockNBT(world, pos, state, new ItemStack(Item.getItemFromBlock(block), 1, block.damageDropped(state)));
    }

    public ItemStack takeBlock(World world, BlockPos pos, IBlockState state, EnumFacing face, EntityPlayer player, Block block)
    {
        if (!world.isRemote) {

            block = world.getBlockState(pos).getBlock();
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof TileNBTCrucible) {

                return this.getItem(world, pos, state, block);
                //PlayerHelper.playerTakeItem(world, pos, EnumFacing.DOWN, player, this.getItem(world, pos, state, block));

                //world.updateComparatorOutputLevel(pos, state.getBlock());
            }
        }

        return ItemStack.EMPTY;
    }

}
