package nmd.primal.forgecraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.forgecraft.blocks.CustomContainerFacing;
import nmd.primal.forgecraft.tiles.TileAnvil;
import nmd.primal.forgecraft.util.AnvilHandler;

/**
 * Created by mminaie on 6/11/17.
 */
public abstract class AnvilBase extends CustomContainerFacing implements AnvilHandler{

    private boolean anvil;

    public AnvilBase(Material material, String registryName, Float hardness, Boolean anvil) {
        super(material, registryName);

        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setHardness(hardness);
        this.setIsAnvil(anvil);
    }

    public boolean isAnvil() {
        return anvil;
    }

    public void setIsAnvil(boolean anvil) {
        anvil = anvil;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops")) {
            TileAnvil tile = (TileAnvil) world.getTileEntity(pos);
            if (tile != null) {
                for (ItemStack stack : tile.getSlotList()) {
                    if (stack != ItemStack.EMPTY) {
                        float offset = 0.7F;
                        double offsetX = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        double offsetY = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        double offsetZ = world.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
                        stack.setCount(1);
                        ItemStack dropStack = stack.copy();
                        dropStack.setCount(1);
                        EntityItem itemDrop = new EntityItem(world, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, dropStack);
                        itemDrop.setDefaultPickupDelay();
                        world.spawnEntity(itemDrop);
                    }
                }
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileAnvil();
    }




}
