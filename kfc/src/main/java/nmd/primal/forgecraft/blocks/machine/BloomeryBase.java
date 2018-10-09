package nmd.primal.forgecraft.blocks.machine;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.core.common.recipes.inworld.FireSource;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.blocks.CustomContainerFacing;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;
import nmd.primal.forgecraft.items.SlottedTongs;
import nmd.primal.forgecraft.tiles.TileBloomery;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static nmd.primal.forgecraft.items.SlottedTongs.ITEM_HANDLER;
import static org.jline.utils.InfoCmp.Capability.newline;

/**
 * Created by mminaie on 6/11/17.
 */
public class BloomeryBase extends CustomContainerFacing implements ITileEntityProvider {

    //public static final PropertyBool COVERED =  PropertyBool.create("covered");
    private int maxHeat;
    public AxisAlignedBB AABB = new AxisAlignedBB(5/32D, 0.0D, 5/32D, 27/32D, 12/16D, 27/32D);

    public BloomeryBase(Material material, String registryName, Integer maxHeat) {
        super(material, registryName);
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)));
        setHardness(3.0f);
        setResistance(5.0f);
        this.maxHeat=maxHeat;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return AABB;
    }

    public int getMaxHeat() {
        return maxHeat;
    }

    public void setMaxHeat(int maxHeat) {
        this.maxHeat = maxHeat;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileBloomery();
    }

    /*@Override
    public void randomTick(World world, BlockPos pos, IBlockState state, Random random)
    {
        this.updateTick(world, pos, state, random);
        if(!world.isRemote){
            if(state.getValue(PrimalAPI.States.ACTIVE) == true) {
                FireHelper.makeSmoke(world, pos, 50);
            }
        }
    }*/

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {

        if (world.isRemote)
            return true;



        TileBloomery tile = (TileBloomery) world.getTileEntity(pos);
        if (tile != null) {
            ItemStack pItem = player.inventory.getCurrentItem();
            ItemStack tileItem = tile.getSlotStack(0);
            ItemStack tileItem1 = tile.getSlotStack(1);
            if(pItem.isEmpty()) {

                if(!player.isSneaking()){
                    if(world.getBlockState(pos).getValue(PrimalAPI.States.ACTIVE)){

                        Integer bloomeryHeat = tile.getHeat();
                        String display =  "Fuel Remaining: " + tileItem.getCount() + "\n" + "Current Temp: " + bloomeryHeat.toString();
                        ITextComponent itextcomponent = new TextComponentString(display);

                        NBTTagCompound tag = tile.getSlotStack(1).getSubCompound("BlockEntityTag");

                        if(tag != null) {
                            NonNullList<ItemStack> ingList = NonNullList.<ItemStack>withSize(5, ItemStack.EMPTY);
                            NonNullList<ItemStack> dropList = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
                            ItemStackHelper.loadAllItems(tag, ingList);
                            ItemStackHelper.loadAllItems(tag, dropList);
                            CrucibleCrafting recipe = CrucibleCrafting.getRecipe(ingList.get(0), ingList.get(1), ingList.get(2), ingList.get(3), ingList.get(4));
                            if (recipe != null) {
                                if(!recipe.isHidden()) {
                                    if (!recipe.isDisabled()) {
                                        Integer minTemp = recipe.getCookTemp();
                                        Integer cookCounter = tile.getCookCounter();
                                        Integer idealTime = recipe.getCookTime();
                                        Integer remainingTime = idealTime - cookCounter;


                                        String display1 = "Cooking: " + recipe.getDropsCooked().getItem().getItemStackDisplayName(recipe.getDropsCooked());
                                        String display2 = "Target Temp: " + minTemp.toString();
                                        String display3 = "Time Left: " + remainingTime.toString() + "\n";
                                        String display4 = "Finished";
                                        //String display5 = "Current Temp: " + tile.getHeat();


                                        ITextComponent cookingText = new TextComponentString(display1);
                                        ITextComponent targetTempText = new TextComponentString(display2);
                                        ITextComponent timeLeftText = new TextComponentString(display3);
                                        ITextComponent finishedText = new TextComponentString(display4);
                                        //ITextComponent itextcomponent5 = new TextComponentString(display5);
                                        if (tileItem1.getSubCompound("BlockEntityTag").getBoolean("status")) {
                                            player.sendMessage(finishedText);
                                        } else {
                                            player.sendMessage(cookingText);
                                            player.sendMessage(itextcomponent);
                                            player.sendMessage(targetTempText);
                                            player.sendMessage(timeLeftText);
                                        }
                                    }
                                }
                            }
                            return true;
                        }
                        else {
                            String noRecipe =  "Fuel Remaining: " + tileItem.getCount() + "\n" + "Current Temp: " + bloomeryHeat.toString() + "\n";
                            ITextComponent noRecipeText = new TextComponentString(noRecipe);
                            player.sendMessage(noRecipeText);
                        }
                    }
                }
            }

            if(tile.getSlotStack(0) != ItemStack.EMPTY) {
                if((FireSource.useSource(world, pos, facing, player, hand, pItem, hitX, hitY, hitZ))) {
                    world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, true), 2);
                    tile.setHeat(100);
                    tile.markDirty();
                    tile.updateBlock();
                    return true;
                }
            }
            if((!pItem.isEmpty()) && tile.isItemValidForSlot(0, pItem)) {
                if (!tileItem.isEmpty()){
                    if(pItem.getItem() == tileItem.getItem()){
                        if(tileItem.getCount() < 64){
                            if(tileItem.getCount() + pItem.getCount() <= 64){
                                tileItem.grow(pItem.getCount());
                                player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                                tile.markDirty();
                                tile.updateBlock();
                                return true;
                            }
                            if(tileItem.getCount() + pItem.getCount() > 64){
                                pItem.setCount(64-pItem.getCount());
                                tileItem.setCount(64);
                                tile.markDirty();
                                tile.updateBlock();
                                return true;
                            }
                        }
                    }
                }
                if(tileItem.isEmpty()) {
                    tile.setSlotStack(0, pItem);
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                    return true;
                }
            }

            if((!pItem.isEmpty()) && tile.isItemValidForSlot(1, pItem)) {
                if (!tileItem1.isEmpty()) {
                    return false;
                }
                if(tileItem1.isEmpty()){

                    ItemStack place_stack = pItem.copy();
                    //if (tile.putStack(slot, place_stack))
                    tile.setSlotStack(1, place_stack);
                    pItem.shrink(1);
                    return true;
                }
            }

            /***SLOTTED TONGS CODE TO PLACE THE ITEMS***/
            if(pItem.getItem() instanceof SlottedTongs) {


                IItemHandler inventory = pItem.getCapability(ITEM_HANDLER, null);
                ItemStack slotStack = inventory.getStackInSlot(0).copy();
                SlottedTongs itemstackItem = (SlottedTongs) pItem.getItem();

                //SlottedTongs temp = (SlottedTongs) pItem.getItem();
                if (!pItem.isEmpty() && tile.isItemValidForSlot(1, slotStack)) {
                    if (!tileItem1.isEmpty()) {
                        return false;
                    }
                    if(tileItem1.isEmpty()){

                        ItemStack place_stack = slotStack.copy();
                        //if (tile.putStack(slot, place_stack))
                        tile.setSlotStack(1, inventory.extractItem(0, 1, false));
                        itemstackItem.markDirty(pItem);
                        return true;
                    }
                }
            }
            /***SLOTTED TONGS CODE TO REMOVE THE ITEMS***/
            if(pItem.getItem() instanceof SlottedTongs) {

                IItemHandler inventory = pItem.getCapability(ITEM_HANDLER, null);
                ItemStack slotStack = inventory.getStackInSlot(0).copy();
                SlottedTongs itemstackItem = (SlottedTongs) pItem.getItem();

                //SlottedTongs temp = (SlottedTongs) pItem.getItem();

                if (!pItem.isEmpty() && inventory.getStackInSlot(0).isEmpty()) {
                    if (tileItem1.isEmpty()) {
                        return false;
                    }
                    if(!tileItem1.isEmpty()){
                        ItemStack place_stack = tileItem1.copy();
                        if(inventory.getStackInSlot(0).isEmpty()){
                            inventory.insertItem(0, place_stack, false);
                            tile.setSlotStack(1, ItemStack.EMPTY);
                            itemstackItem.markDirty(pItem);
                            return true;
                        }
                    }
                }
            }

            if (!tile.getSlotStack(0).isEmpty()) {
                if(player.inventory.getCurrentItem().getItem() instanceof ItemSpade) {
                    ItemStack returnStack = tile.getSlotStack(0).copy();
                    PlayerHelper.spawnItemOnPlayer(world, player, returnStack);
                    tile.clearSlot(0);
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        int lightState =0;
        if(state.getValue(PrimalAPI.States.ACTIVE) == true){
            lightState = 10;
        }
        return lightState;
    }

    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return 0;
    }

    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return true;
    }

    @Override
    public boolean isFireSource(World world, BlockPos pos, EnumFacing side)
    {
        if(!world.isRemote){
            if(world.getBlockState(pos).getValue(PrimalAPI.States.ACTIVE)==true){
                return true;
            }
        }
        return false;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity ent)
    {
        if(ent instanceof EntityPlayer){
            if(state.getValue(PrimalAPI.States.ACTIVE) == true){
                ent.setFire(1);
            }
        }
    }

    /**
     * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
     */
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops"))
        {
            TileBloomery tile = (TileBloomery) world.getTileEntity(pos);
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
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        if(!worldIn.isRemote) {
            worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing()).withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(false)), 2);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if( (state.getValue(FACING) == EnumFacing.EAST) && state.getValue(PrimalAPI.States.ACTIVE) == false){
            i = 0;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.WEST) && state.getValue(PrimalAPI.States.ACTIVE) == false){
            i = 1;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.SOUTH) && state.getValue(PrimalAPI.States.ACTIVE) == false){
            i = 2;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.NORTH) && state.getValue(PrimalAPI.States.ACTIVE) == false){
            i = 3;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.EAST) && state.getValue(PrimalAPI.States.ACTIVE) == true){
            i = 4;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.WEST) && state.getValue(PrimalAPI.States.ACTIVE) == true){
            i = 5;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.SOUTH) && state.getValue(PrimalAPI.States.ACTIVE) == true){
            i = 6;
            return i;
        }
        if( (state.getValue(FACING) == EnumFacing.NORTH) && state.getValue(PrimalAPI.States.ACTIVE) == true){
            i = 7;
            return i;
        }

        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing;
        Boolean active;
        switch (meta & 7)
        {
            case 0:
                enumfacing = EnumFacing.EAST;
                active = false;
                break;
            case 1:
                enumfacing = EnumFacing.WEST;
                active = false;
                break;
            case 2:
                enumfacing = EnumFacing.SOUTH;
                active = false;
                break;
            case 3:
                enumfacing = EnumFacing.NORTH;
                active = false;
                break;
            case 4:
                enumfacing = EnumFacing.EAST;
                active = true;
                break;
            case 5:
                enumfacing = EnumFacing.WEST;
                active = true;
                break;
            case 6:
                enumfacing = EnumFacing.SOUTH;
                active = true;
                break;
            case 7:
                enumfacing = EnumFacing.NORTH;
                active = true;
                break;
            default:
                enumfacing = EnumFacing.NORTH;
                active = false;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(PrimalAPI.States.ACTIVE, Boolean.valueOf(active));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING, PrimalAPI.States.ACTIVE});
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

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("incomplete-switch")
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
    {
        if(state.getValue(PrimalAPI.States.ACTIVE) == true)
        {
            double d0 = (double)pos.getX() + 0.5D;
            double d1 = (double)pos.getY() + 0.2D;
            double d2 = (double)pos.getZ() + 0.5D;
            double d3 = 0.52D;
            double d4 = ThreadLocalRandom.current().nextDouble(0.075, 0.35);
            double ySpeed = ThreadLocalRandom.current().nextDouble(0.0, 0.075);

            if (rand.nextDouble() < 0.1D)
            {
                world.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }
            if(rand.nextInt(4) == 1){
                world.spawnParticle(EnumParticleTypes.FLAME, d0+d4, d1, d2+d4, 0.0D, ySpeed, 0.0D, new int[0]);
                world.spawnParticle(EnumParticleTypes.FLAME, d0+d4, d1, d2-d4, 0.0D, ySpeed, 0.0D, new int[0]);
            }
            if(rand.nextInt(4) == 2){
                world.spawnParticle(EnumParticleTypes.FLAME, d0+d4, d1, d2-d4, 0.0D, ySpeed, 0.0D, new int[0]);
                world.spawnParticle(EnumParticleTypes.FLAME, d0-d4, d1, d2+d4, 0.0D, ySpeed, 0.0D, new int[0]);
            }
            if(rand.nextInt(4) == 3){
                world.spawnParticle(EnumParticleTypes.FLAME, d0-d4, d1, d2+d4, 0.0D, ySpeed, 0.0D, new int[0]);
                world.spawnParticle(EnumParticleTypes.FLAME, d0-d4, d1, d2-d4, 0.0D, ySpeed, 0.0D, new int[0]);
            }
            if(rand.nextInt(4) == 4){
                world.spawnParticle(EnumParticleTypes.FLAME, d0-d4, d1, d2-d4, 0.0D, ySpeed, 0.0D, new int[0]);
                world.spawnParticle(EnumParticleTypes.FLAME, d0+d4, d1, d2+d4, 0.0D, ySpeed, 0.0D, new int[0]);
            }
        }
    }
}
