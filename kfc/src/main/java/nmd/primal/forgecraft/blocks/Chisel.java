package nmd.primal.forgecraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.init.ModSounds;
import nmd.primal.forgecraft.items.SledgeHammer;
import nmd.primal.forgecraft.util.ToolMaterialMap;

import javax.annotation.Nullable;

public class Chisel extends CustomFacing implements ToolMaterialMap {

    private AxisAlignedBB boundBoxDown = new AxisAlignedBB(
            0.4375D, 0.0D, 0.4375D,
            0.5625D, 0.875D, 0.5625D);
    private AxisAlignedBB boundBoxDownActive = new AxisAlignedBB(
            0.4375D, 0.0D, 0.4375D,
            0.5625D, 0.375D, 0.5625D);
    private AxisAlignedBB boundBoxUp = new AxisAlignedBB(
            0.4375D, 0.125D, 0.4375D,
            0.5625D, 1.0, 0.5625D);
    private AxisAlignedBB boundBoxUpActive = new AxisAlignedBB
            (0.4375D, 0.625D, 0.4375D,
             0.5625D, 1.0D, 0.5625D);
    private AxisAlignedBB boundBoxEast = new AxisAlignedBB(
            0.125D, 0.4375D, 0.4375D,
            1.0D, 0.5625D, 0.5625D);
    private AxisAlignedBB boundBoxEastActive = new AxisAlignedBB(
            0.625D, 0.4375D, 0.4375D,
            1.0D, 0.5625D, 0.5625D);
    private AxisAlignedBB boundBoxWest = new AxisAlignedBB(
            0.0D, 0.4375D, 0.4375D,
            0.875D, 0.5625D, 0.5625D);
    private AxisAlignedBB boundBoxWestActive = new AxisAlignedBB(
            0.0D, 0.4375D, 0.4375D,
            0.375D, 0.5625D, 0.5625D);
    private AxisAlignedBB boundBoxNorth = new AxisAlignedBB(
            0.4375D, 0.4375D, 0.0D,
            0.5625D, 0.5625D, 0.875D);
    private AxisAlignedBB boundBoxNorthActive = new AxisAlignedBB(
            0.4375D, 0.4375D, 0.0D,
            0.5625D, 0.5625D, 0.375D);
    private AxisAlignedBB boundBoxSouth = new AxisAlignedBB(
            0.4375D, 0.4375D, 0.125D,
            0.5625D, 0.5625D, 1.0D);
    private AxisAlignedBB boundBoxSouthActive = new AxisAlignedBB(
            0.4375D, 0.4375D, 0.625D,
            0.5625D, 0.5625D, 1.0D);

    private Item.ToolMaterial realMaterial;

    public Chisel(Material material, String name, Item.ToolMaterial realMaterial) {
        super(material, name);
        this.setHardness(8.0f);
        this.setResistance(8.0f);
        this.realMaterial = realMaterial;
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.DOWN).withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        if(state.getValue(FACING)==EnumFacing.UP && !state.getValue(PrimalAPI.States.ACTIVE)){
            return boundBoxUp;
        }
        if(state.getValue(FACING)==EnumFacing.UP && state.getValue(PrimalAPI.States.ACTIVE)){
            return boundBoxUpActive;
        }
        if(state.getValue(FACING)==EnumFacing.DOWN && !state.getValue(PrimalAPI.States.ACTIVE)){
            return boundBoxDown;
        }
        if(state.getValue(FACING)==EnumFacing.DOWN && state.getValue(PrimalAPI.States.ACTIVE)){
            return boundBoxDownActive;
        }
        if(state.getValue(FACING)==EnumFacing.EAST && !state.getValue(PrimalAPI.States.ACTIVE)){
            return boundBoxEast;
        }
        if(state.getValue(FACING)==EnumFacing.EAST && state.getValue(PrimalAPI.States.ACTIVE)){
            return boundBoxEastActive;
        }
        if(state.getValue(FACING)==EnumFacing.WEST && !state.getValue(PrimalAPI.States.ACTIVE)){
            return boundBoxWest;
        }
        if(state.getValue(FACING)==EnumFacing.WEST && state.getValue(PrimalAPI.States.ACTIVE)){
            return boundBoxWestActive;
        }
        if(state.getValue(FACING)==EnumFacing.NORTH && !state.getValue(PrimalAPI.States.ACTIVE)){
            return boundBoxNorth;
        }
        if(state.getValue(FACING)==EnumFacing.NORTH && state.getValue(PrimalAPI.States.ACTIVE)){
            return boundBoxNorthActive;
        }
        if(state.getValue(FACING)==EnumFacing.SOUTH && !state.getValue(PrimalAPI.States.ACTIVE)){
            return boundBoxSouth;
        }
        if(state.getValue(FACING)==EnumFacing.SOUTH && state.getValue(PrimalAPI.States.ACTIVE)){
            return boundBoxSouthActive;
        }
        return boundBoxDown;
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
    public Item.ToolMaterial getRealMaterial() {
        return realMaterial;
    }



    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz) {

        if(!world.isRemote){
            ItemStack playerStack = player.inventory.getCurrentItem();
            ItemStack offStack = player.inventory.offHandInventory.get(0);
            int toolHarvestLevel = playerStack.getItem().getHarvestLevel(playerStack, "pickaxe", player, state);
            if (hand.equals(hand.MAIN_HAND) && offStack == ItemStack.EMPTY) {
                if(!player.isSwingInProgress) {
                    if(player.getActivePotionEffect(MobEffects.MINING_FATIGUE ) == null){
                        if (playerStack.getItem() instanceof SledgeHammer) {
                            SledgeHammer playerItem = (SledgeHammer) playerStack.getItem();
                            world.playSound(null, player.posX, player.posY, player.posZ, ModSounds.CHISEL_HIT, SoundCategory.BLOCKS, (float) (PrimalAPI.getRandom().nextDouble(0.5D, 0.8D)), (float) (PrimalAPI.getRandom().nextDouble(0.3D, 1.0D)));
                            playerStack.damageItem(1, player);
                            player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, (100 - ((materialModifiers.get(playerItem.getMaterial()) * 8) + (materialModifiers.get(this.getRealMaterial()) * 8))), 100));
                            if (PrimalAPI.getRandom().nextInt(1, 10) != 1) {

                                if (state.getValue(FACING) == EnumFacing.UP) {
                                    if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((a - 1), (1), (i - 1));
                                                IBlockState breakState = world.getBlockState(movePos);
                                                if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                                    doBreaking(world, movePos, breakState, player);
                                                }
                                            }
                                        }
                                        doMoving(world, pos, toolHarvestLevel, state, state.getValue(FACING));
                                        return true;
                                    }
                                    if (!state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((a - 1), (1), (i - 1));
                                                if (!(world.getBlockState(movePos).getBlock() instanceof Chisel)) {
                                                    IBlockState breakState = world.getBlockState(movePos);
                                                    doDamaging(world, movePos, breakState, player);
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
                                                    doBreaking(world, movePos, breakState, player);
                                                }
                                            }
                                        }
                                        doMoving(world, pos, toolHarvestLevel, state, state.getValue(FACING));
                                        return true;
                                    }
                                    if (!state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((a - 1), (-1), (i - 1));
                                                if (!(world.getBlockState(movePos).getBlock() instanceof Chisel)) {
                                                    IBlockState breakState = world.getBlockState(movePos);
                                                    doDamaging(world, movePos, breakState, player);
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
                                                BlockPos movePos = pos.add((a - 1), (i - 1), (1));
                                                IBlockState breakState = world.getBlockState(movePos);
                                                if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                                    doBreaking(world, movePos, breakState, player);
                                                }
                                            }
                                        }
                                        doMoving(world, pos, toolHarvestLevel, state, state.getValue(FACING));
                                        return true;
                                    }
                                    if (!state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((a - 1), (i - 1), (1));
                                                if (!(world.getBlockState(movePos).getBlock() instanceof Chisel)) {
                                                    IBlockState breakState = world.getBlockState(movePos);
                                                    doDamaging(world, movePos, breakState, player);
                                                }
                                            }
                                        }
                                        world.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(PrimalAPI.States.ACTIVE, true), 2);
                                        return true;
                                    }
                                }
                                if (state.getValue(FACING) == EnumFacing.NORTH) {
                                    if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((a - 1), (i - 1), (-1));
                                                IBlockState breakState = world.getBlockState(movePos);
                                                if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                                    doBreaking(world, movePos, breakState, player);
                                                }
                                            }
                                        }
                                        doMoving(world, pos, toolHarvestLevel, state, state.getValue(FACING));
                                        return true;
                                    }
                                    if (!state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((a - 1), (i - 1), (-1));
                                                if (!(world.getBlockState(movePos).getBlock() instanceof Chisel)) {
                                                    IBlockState breakState = world.getBlockState(movePos);
                                                    doDamaging(world, movePos, breakState, player);
                                                }
                                            }
                                        }
                                        world.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(PrimalAPI.States.ACTIVE, true), 2);
                                        return true;
                                    }
                                }
                                if (state.getValue(FACING) == EnumFacing.EAST) {
                                    if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((1), (i - 1), (a - 1));
                                                IBlockState breakState = world.getBlockState(movePos);
                                                if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                                    doBreaking(world, movePos, breakState, player);
                                                }
                                            }
                                        }
                                        doMoving(world, pos, toolHarvestLevel, state, state.getValue(FACING));
                                        return true;
                                    }
                                    if (!state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((1), (i - 1), (a - 1));
                                                if (!(world.getBlockState(movePos).getBlock() instanceof Chisel)) {
                                                    IBlockState breakState = world.getBlockState(movePos);
                                                    doDamaging(world, movePos, breakState, player);
                                                }
                                            }
                                        }
                                        world.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(PrimalAPI.States.ACTIVE, true), 2);
                                        return true;
                                    }
                                }
                                if (state.getValue(FACING) == EnumFacing.WEST) {
                                    if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((-1), (i - 1), (a - 1));
                                                IBlockState breakState = world.getBlockState(movePos);
                                                if (state.getValue(PrimalAPI.States.ACTIVE)) {
                                                    doBreaking(world, movePos, breakState, player);
                                                }
                                            }
                                        }
                                        doMoving(world, pos, toolHarvestLevel, state, state.getValue(FACING));
                                        return true;
                                    }
                                    if (!state.getValue(PrimalAPI.States.ACTIVE)) {
                                        for (int i = 0; i < 3; i++) {
                                            for (int a = 0; a < 3; a++) {
                                                BlockPos movePos = pos.add((-1), (i - 1), (a - 1));
                                                if (!(world.getBlockState(movePos).getBlock() instanceof Chisel)) {
                                                    IBlockState breakState = world.getBlockState(movePos);
                                                    doDamaging(world, movePos, breakState, player);
                                                }
                                            }
                                        }
                                        world.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(PrimalAPI.States.ACTIVE, true), 2);
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(offStack != ItemStack.EMPTY) {
                String printout = "Is your offhand empty?";
                ITextComponent text = new TextComponentString(printout);
                player.sendStatusMessage(text, true);
                return false;
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


    @SideOnly(Side.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state)
    {
        return true;
    }

    private void doMoving(World world, BlockPos pos, int toolHarvestLevel, IBlockState state, EnumFacing facing){
        if( (world.getBlockState(pos.offset(facing, 2)).getBlock() != Blocks.AIR) ) {
            if ((compareHarvestLevel(toolHarvestLevel, world.getBlockState(pos.offset(facing, 1)).getBlock().getHarvestLevel(world.getBlockState(pos.offset(facing, 1))))) ||
                    (world.getBlockState(pos.offset(facing, 1)).getBlock() == Blocks.AIR)) {
                //if(state.getBlock().getBlockHardness(state, world, pos.offset(facing, 1)) > 0) {
                    world.setBlockState(pos.offset(facing, 1), state.withProperty(FACING, state.getValue(FACING)).withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)), 2);
                    world.setBlockToAir(pos);
                //}
            }
        } else {
            world.destroyBlock(pos, true);
        }
    }

    private void doBreaking(World world, BlockPos movePos, IBlockState state, EntityPlayer player){
        if (!(state.getBlock().equals(Blocks.AIR))) {
            if(world.getBlockState(movePos).getBlock().getBlockHardness(state, world, movePos)>0) {

                ItemStack playerStack = player.inventory.getCurrentItem();
                int toolHarvestLevel = playerStack.getItem().getHarvestLevel(playerStack, "pickaxe", player, state);
                world.destroyBlock(movePos, compareHarvestLevel(toolHarvestLevel, state.getBlock().getHarvestLevel(state)));
                world.sendBlockBreakProgress(player.getEntityId()+PrimalAPI.getRandom().nextInt(100), movePos, 0);
            }
        }
    }

    private void doDamaging(World world, BlockPos movePos, IBlockState state, EntityPlayer player){
        if (!(state.getBlock().equals(Blocks.AIR))) {
            if(world.getBlockState(movePos).getBlock().blockHardness>0) {
                world.sendBlockBreakProgress(player.getEntityId() - PrimalAPI.getRandom().nextInt(100), movePos, PrimalAPI.getRandom().nextInt(3,10));
            }
        }
    }

    private boolean compareHarvestLevel(int inputLevel, int compareHarvest){
        if(inputLevel >= compareHarvest && compareHarvest > 0){
            return true;
        } else return false;
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
