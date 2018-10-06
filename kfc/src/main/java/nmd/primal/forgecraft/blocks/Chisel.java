package nmd.primal.forgecraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.EnumFaceDirection;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModSounds;
import nmd.primal.forgecraft.items.SledgeHammer;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chisel extends CustomFacing {

    public AxisAlignedBB boundBox = new AxisAlignedBB(0.4375D, 0.0D, 0.4375D, 0.5625D, 0.875D, 0.5625D);

    public Chisel(Material material, String name) {
        super(material, name);
        this.setHardness(8.0f);
        this.setResistance(8.0f);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.DOWN).withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)));
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        if(!worldIn.isRemote) {
            worldIn.setBlockState(pos, state.withProperty(FACING, reverseFacing(EnumFacing.getDirectionFromEntityLiving(pos, placer))).withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)), 2);
        }
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, PrimalAPI.States.ACTIVE});
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return boundBox;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz) {

        if(!world.isRemote){
            ItemStack playerStack = player.inventory.getCurrentItem();
            if (hand.equals(hand.MAIN_HAND)) {
                if(!player.isSwingInProgress) {
                    if (playerStack.getItem() instanceof SledgeHammer) {
                        world.playSound(null, player.posX, player.posY, player.posZ, ModSounds.CHISEL_HIT, SoundCategory.BLOCKS, 0.8F, 0.3F / (PrimalAPI.getRandom().nextFloat() * 0.4F + 0.8F));

                                if (state.getValue(FACING) == EnumFacing.UP) {
                                    if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((a - 1), (1), (i - 1));
                                                IBlockState breakState = world.getBlockState(movePos);
                                                if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                                    doBreaking(world, movePos, pos, breakState);
                                                }
                                            }
                                        }
                                        world.setBlockState(pos.up(), state.withProperty(FACING, state.getValue(FACING)).withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)), 2);
                                        world.setBlockToAir(pos);
                                        return true;
                                    }
                                    if (!state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((a - 1), (1), (i - 1));
                                                if (world.getBlockState(movePos).getBlock() != ModBlocks.chisel) {
                                                    world.sendBlockBreakProgress(player.getEntityId() + PrimalAPI.getRandom().nextInt(100), movePos, 4);
                                                }
                                            }
                                        }
                                        world.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(PrimalAPI.States.ACTIVE, true), 2);
                                        return true;
                                    }
                                }

                                if (state.getValue(FACING) == EnumFacing.DOWN) {
                                    if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((a - 1), (-1), (i - 1));
                                                IBlockState breakState = world.getBlockState(movePos);
                                                if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                                    doBreaking(world, movePos, pos, breakState);
                                                }
                                            }
                                        }
                                        world.setBlockState(pos.down(), state.withProperty(FACING, state.getValue(FACING)).withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)), 2);
                                        world.setBlockToAir(pos);
                                        return true;
                                    }
                                    if (!state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((a - 1), (-1), (i - 1));
                                                if (world.getBlockState(movePos).getBlock() != ModBlocks.chisel) {
                                                    world.sendBlockBreakProgress(player.getEntityId() + PrimalAPI.getRandom().nextInt(100), movePos, 4);
                                                }
                                            }
                                        }
                                        world.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(PrimalAPI.States.ACTIVE, true), 2);
                                        return true;
                                    }
                                }
                                if (state.getValue(FACING) == EnumFacing.SOUTH) {
                                    if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((a - 1), (i-1), (1));
                                                IBlockState breakState = world.getBlockState(movePos);
                                                if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                                    doBreaking(world, movePos, pos, breakState);
                                                }
                                            }
                                        }
                                        world.setBlockState(pos.south(), state.withProperty(FACING, state.getValue(FACING)).withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)), 2);
                                        world.setBlockToAir(pos);
                                        return true;
                                    }
                                    if (!state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((a - 1), (i-1), (1));
                                                if (world.getBlockState(movePos).getBlock() != ModBlocks.chisel) {
                                                    world.sendBlockBreakProgress(player.getEntityId() + PrimalAPI.getRandom().nextInt(100), movePos, 4);
                                                }
                                            }
                                        }
                                        world.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(PrimalAPI.States.ACTIVE, true), 2);
                                        return true;
                                    }
                                }
                                if (state.getValue(FACING) == EnumFacing.NORTH) {
                                    for (int i = 0; i < 3; i++) {
                                        for (int a = 0; a < 3; a++) {
                                            BlockPos movePos = pos.add((a-1), (i-1), (1));
                                            IBlockState breakState = world.getBlockState(movePos);
                                            doBreaking(world, movePos, pos, breakState);
                                        }
                                    }
                                    world.setBlockState(pos.south(), state.withProperty(FACING, state.getValue(FACING)).withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)), 2);
                                    world.setBlockToAir(pos);
                                    return true;
                                }

                    }
                }
            }
        }
        return false;
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, getFacing(meta)).withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf((meta & 8) > 0));
    }

    @Nullable
    public static EnumFacing getFacing(int meta)
    {
        int i = meta & 7;
        return i > 5 ? null : EnumFacing.getFront(i);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumFacing)state.getValue(FACING)).getIndex();

        if (((Boolean)state.getValue(PrimalAPI.States.ACTIVE)).booleanValue())
        {
            i |= 8;
        }

        return i;
    }

    private EnumFacing reverseFacing(EnumFacing facing){
        if(facing == EnumFacing.UP){
            return EnumFacing.DOWN;
        }
        if(facing == EnumFacing.DOWN){
            return EnumFacing.UP;
        }
        if(facing == EnumFacing.NORTH){
            return EnumFacing.SOUTH;
        }
        if(facing == EnumFacing.SOUTH){
            return EnumFacing.NORTH;
        }
        if(facing == EnumFacing.EAST){
            return EnumFacing.WEST;
        }
        if(facing == EnumFacing.WEST){
            return EnumFacing.EAST;
        }
        return null;
    }

    private void doBreaking(World world, BlockPos movePos, BlockPos pos, IBlockState state){

        if (!(state.getBlock().equals(Blocks.AIR))) {
            NonNullList<ItemStack> tempDrops = NonNullList.create();
            world.getBlockState(movePos).getBlock().getDrops(tempDrops, world, movePos, state, 0);
            PlayerHelper.spawnItemOnGround(world, pos, tempDrops);
            world.setBlockToAir(movePos);
        }
    }

    private void makeParticles(World world, BlockPos pos, EnumParticleTypes particle, EnumFacing facing){

        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 0.5D;
        double d2 = (double)pos.getZ() + 0.5D;
        double xVelocity = 0.0D;
        double yVelocity = 0.0D;
        double zVelocity = 0.0D;
        double d4 = PrimalAPI.getRandom().nextDouble(0.066, 0.33);

        if(facing == EnumFacing.NORTH){
            d0 += 0.5D;
        }
        if(facing == EnumFacing.DOWN){
            d1 += 0.5D;
            yVelocity += 0.1D;
        }
        if(facing == EnumFacing.UP){
            d1 -= 0.5D;
        }

        //if(PrimalAPI.getRandom().nextInt(3) == 0){
            world.spawnParticle(particle, d0, d1, d2, 0.0D + xVelocity, 0.0 + yVelocity, 0.0D + zVelocity, new int[1]);
            world.spawnParticle(particle, d0, d1, d2, 0.0D + xVelocity, 0.0 + yVelocity, 0.0D + zVelocity, new int[1]);
        //}



        //double ySpeed = ThreadLocalRandom.current().nextDouble(0.05, 0.20);
    }

}
