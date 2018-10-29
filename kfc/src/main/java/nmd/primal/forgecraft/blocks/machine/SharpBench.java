package nmd.primal.forgecraft.blocks.machine;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.blocks.CustomContainerFacingActive;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.items.parts.WeaponPart;
import nmd.primal.forgecraft.items.weapons.CustomSword;
import nmd.primal.forgecraft.items.weapons.SlayerSword;
import nmd.primal.forgecraft.tiles.TileSharpBench;
import nmd.primal.forgecraft.util.WeaponNBT;

import javax.annotation.Nullable;

public class SharpBench extends CustomContainerFacingActive {


    protected static final AxisAlignedBB boundBoxNorth = new AxisAlignedBB(0.28125D, 0.0D, 1/16D, 0.71875D, 11 / 16D, 11 / 16D);
    protected static final AxisAlignedBB boundBoxSouth = new AxisAlignedBB(0.28125D, 0.0D, 5/16D, 0.71875D, 11 / 16D, 15 / 16D);
    protected static final AxisAlignedBB boundBoxEast = new AxisAlignedBB(5/16D, 0.0D, 0.28125D, 15/16D, 11 / 16D, 0.71875D);
    protected static final AxisAlignedBB boundBoxWest = new AxisAlignedBB(1/16D, 0.0D, 0.28125D, 11/16D, 11 / 16D, 0.71875D);

    public SharpBench(Material material, String registryName) {
        super(material, registryName);
        this.setHardness(4.0f);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!world.isRemote) {
            if(player.getActiveHand().equals(EnumHand.MAIN_HAND)) {
                TileSharpBench tile = (TileSharpBench) world.getTileEntity(pos);
                if(player.getHeldItemMainhand().isEmpty()) {
                    if(tile.getSlotStack(0).getItem().equals(ModItems.grindingwheel)) {
                        world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, true), 2);
                        if (tile.getCharge() < 15) {
                            tile.setCharge(tile.getCharge() + 1);
                            return true;
                        }
                    }
                }
                if(player.getHeldItemMainhand().getItem().equals(ModItems.grindingwheel)) {
                    tile.setSlotStack(0, player.getHeldItemMainhand().copy());
                    player.getHeldItemMainhand().shrink(1);
                    return true;
                }
                if(player.getHeldItemMainhand().isEmpty()) {
                    if(player.isSneaking()){
                        if(tile.getSlotStack(0).getItem().equals(ModItems.grindingwheel)){
                            PlayerHelper.spawnItemOnGround(world, pos, tile.getSlotStack(0));
                            tile.clearSlot(0);
                            world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, false), 2);
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity ent)
    {

        if(ent instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) ent;
            TileSharpBench tile = (TileSharpBench) world.getTileEntity(pos);
            if(state.getValue(PrimalAPI.States.ACTIVE) && tile.getSlotStack(0).getItem().equals(ModItems.grindingwheel)){
                ItemStack playerStack = player.inventory.getCurrentItem();
                if(
                        playerStack.getItem() instanceof CustomSword ||
                        playerStack.getItem() instanceof ToolPart
                ){
                    if(playerStack.getItemDamage() > 0){
                        if (!world.isRemote) {
                            if (PrimalAPI.getRandom().nextInt(1, 3) == 1) {
                                playerStack.setItemDamage(playerStack.getItemDamage() - 1);
                                tile.getSlotStack(0).setItemDamage(tile.getSlotStack(0).getItemDamage() + 1);
                                if(tile.getSlotStack(0).getItemDamage()>= tile.getSlotStack(0).getMaxDamage()){
                                    tile.clearSlot(0);
                                }
                                if(playerStack.getItem() instanceof CustomSword) {
                                    WeaponNBT.removeAndSetEnchantsForStack(playerStack);
                                }
                            }
                        }
                        if (world.isRemote) {
                            makeSparks(world, pos, state);
                        }
                    }
                }
            }
        }
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileSharpBench();
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

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops"))
        {
            TileSharpBench tile = (TileSharpBench) world.getTileEntity(pos);
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

    private void makeSparks(World world, BlockPos pos, IBlockState state){
        double d0     = (double)pos.getX() + 0.5D;
        double d1     = (double)pos.getY() + 0.75D;
        double d2     = (double)pos.getZ() + 0.5D;
        double d3     = 0.52D;
        //double d4     = PrimalAPI.getRandom().nextDouble(0.066, 0.33);
        double ySpeed = PrimalAPI.getRandom().nextDouble(0.05, 0.20);
        double zSpeed = PrimalAPI.getRandom().nextDouble(0.05, 0.20);
        if(state.getValue(FACING) == EnumFacing.NORTH) {
            world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, d0, d1, d2, 0.0D, ySpeed, -zSpeed, new int[0]);
        }
        if(state.getValue(FACING) == EnumFacing.SOUTH) {
            world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, d0, d1, d2, 0.0D, ySpeed, zSpeed, new int[0]);
        }
        if(state.getValue(FACING) == EnumFacing.EAST) {
            world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, d0, d1, d2, zSpeed, ySpeed, 0.0D, new int[0]);
        }
        if(state.getValue(FACING) == EnumFacing.WEST) {
            world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, d0, d1, d2, -zSpeed, ySpeed, 0.0D, new int[0]);
        }
    }

}