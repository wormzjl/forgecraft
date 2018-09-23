package nmd.primal.forgecraft.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.api.interfaces.IPickup;
import nmd.primal.core.common.helper.NBTHelper;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.core.common.tiles.AbstractTileTank;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.blocks.Anvil.AnvilBase;
import nmd.primal.forgecraft.blocks.Anvil.AnvilStone;
import nmd.primal.forgecraft.blocks.Crucibles.NBTCrucible;
import nmd.primal.forgecraft.blocks.machine.Forge;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.blocks.ItemNBTCrucible;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.tiles.TileAnvil;
import nmd.primal.forgecraft.tiles.TileForge;
import nmd.primal.forgecraft.tiles.TileNBTCrucible;
import nmd.primal.forgecraft.util.AnvilHandler;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by mminaie on 12/30/17.
 */


public class SlottedTongs extends Item implements IPickup, AnvilHandler{

    @CapabilityInject(IItemHandler.class)
    public static Capability<IItemHandler> ITEM_HANDLER;

    public SlottedTongs(String unlocalizedName) {
        setUnlocalizedName(unlocalizedName);
        this.setRegistryName(unlocalizedName);
        this.setMaxStackSize(1);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                IItemHandler inventory = stack.getCapability(ITEM_HANDLER, null);
                ItemStack slotStack = inventory.getStackInSlot(0).copy();

                if (stack.getItem() instanceof SlottedTongs) {
                    if (slotStack.getItem() instanceof ItemNBTCrucible) {
                        /***Render Empty Crucible***/
                        if(inventory.getStackInSlot(0).getSubCompound("BlockEntityTag").getInteger("hot") == 0){
                            return 0.99f;
                        }
                        /***Render Level 1***/
                        if(inventory.getStackInSlot(0).getSubCompound("BlockEntityTag").getInteger("hot") == 1){
                            return 0.011f;
                        }
                        /***Render Level 2***/
                        if(inventory.getStackInSlot(0).getSubCompound("BlockEntityTag").getInteger("hot") == 2){
                            return 0.012f;
                        }
                        /***Render Level 3***/
                        if(inventory.getStackInSlot(0).getSubCompound("BlockEntityTag").getInteger("hot") == 3){
                            return 0.013f;
                        }
                        /***Render Level 4***/
                        if(inventory.getStackInSlot(0).getSubCompound("BlockEntityTag").getInteger("hot") == 4){
                            return 0.014f;
                        }
                        /***Render Level 5***/
                        if(inventory.getStackInSlot(0).getSubCompound("BlockEntityTag").getInteger("hot") == 5){
                            return 0.015f;
                        }
                        /***Render Level Cooked***/
                        if(inventory.getStackInSlot(0).getSubCompound("BlockEntityTag").getInteger("hot") == 6){
                            return 0.016f;
                        }
                        /***Render Failed***/
                        if(inventory.getStackInSlot(0).getSubCompound("BlockEntityTag").getInteger("hot") == 7){
                            return 0.017f;
                        }
                        /***Render Hot***/
                        if(inventory.getStackInSlot(0).getSubCompound("BlockEntityTag").getInteger("hot") == 15){
                            return 0.025f;
                        }
                    }
                    if(slotStack.getItem() instanceof ToolPart){
                        ToolPart toolPart = (ToolPart) inventory.getStackInSlot(0).getItem();
                        if(toolPart.getID() == "pickaxe"){
                            if (inventory.getStackInSlot(0).getSubCompound("tags") != null) {
                                if (slotStack.getSubCompound("tags").getBoolean("hot")) {
                                    return 0.03f;
                                }
                                if (!inventory.getStackInSlot(0).getSubCompound("tags").getBoolean("hot")) {
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON){
                                        return 0.04f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON){
                                        return 0.05f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL){
                                        return 0.06f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL){
                                        return 0.07f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_BRONZE){
                                        return 0.08f;
                                    }
                                }
                            }
                        }
                        if(toolPart.getID() == "axe"){
                            if (inventory.getStackInSlot(0).getSubCompound("tags") != null) {
                                if (slotStack.getSubCompound("tags").getBoolean("hot")) {
                                    return 0.09f;
                                }
                                if (!inventory.getStackInSlot(0).getSubCompound("tags").getBoolean("hot")) {
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON){
                                        return 0.10f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON){
                                        return 0.11f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL){
                                        return 0.12f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL){
                                        return 0.13f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_BRONZE){
                                        return 0.14f;
                                    }
                                }
                            }
                        }
                        if(toolPart.getID() == "shovel"){
                            if (inventory.getStackInSlot(0).getSubCompound("tags") != null) {
                                if (slotStack.getSubCompound("tags").getBoolean("hot")) {
                                    return 0.15f;
                                }
                                if (!inventory.getStackInSlot(0).getSubCompound("tags").getBoolean("hot")) {
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON){
                                        return 0.16f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON){
                                        return 0.17f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL){
                                        return 0.18f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL){
                                        return 0.19f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_BRONZE){
                                        return 0.20f;
                                    }
                                }
                            }
                        }
                        if(toolPart.getID() == "hoe"){
                            if (inventory.getStackInSlot(0).getSubCompound("tags") != null) {
                                if (slotStack.getSubCompound("tags").getBoolean("hot")) {
                                    return 0.21f;
                                }
                                if (!inventory.getStackInSlot(0).getSubCompound("tags").getBoolean("hot")) {
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON){
                                        return 0.22f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON){
                                        return 0.23f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL){
                                        return 0.24f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL){
                                        return 0.25f;
                                    }
                                    if(toolPart.getMaterial() == PrimalAPI.ToolMaterials.TOOL_BRONZE){
                                        return 0.26f;
                                    }
                                }
                            }
                        }
                    }
                    if(slotStack.getItem() instanceof BaseMultiItem){
                        Item slotItem = slotStack.getItem();
                        if (slotStack.getTagCompound() != null) {
                            if (!slotStack.getTagCompound().getBoolean("hot")) {
                                if (slotItem.equals(ModItems.bronzeingotball)) {
                                    return 0.27f;
                                }
                                if (slotItem.equals(ModItems.ironingotball)) {
                                    return 0.28f;
                                }
                                if (slotItem.equals(ModItems.ironcleaningotball)) {
                                    return 0.29f;
                                }
                                if (slotItem.equals(ModItems.steelingotball)) {
                                    return 0.30f;
                                }
                                if (slotItem.equals(ModItems.wootzingotball)) {
                                    return 0.31f;
                                }
                                if (slotItem.equals(ModItems.bronzechunk)) {
                                    return 0.32f;
                                }
                                if (slotItem.equals(ModItems.wroughtironchunk)) {
                                    return 0.33f;
                                }
                                if (slotItem.equals(ModItems.ironcleanchunk)) {
                                    return 0.34f;
                                }
                                if (slotItem.equals(ModItems.steelchunk)) {
                                    return 0.35f;
                                }
                                if (slotItem.equals(ModItems.wootzchunk)) {
                                    return 0.36f;
                                }
                            }
                            if (slotStack.getTagCompound().getBoolean("hot")) {
                                if (slotItem.equals(ModItems.bronzeingotball)) {
                                    return 0.37f;
                                }
                                if (slotItem.equals(ModItems.ironingotball)) {
                                    return 0.38f;
                                }
                                if (slotItem.equals(ModItems.ironcleaningotball)) {
                                    return 0.39f;
                                }
                                if (slotItem.equals(ModItems.steelingotball)) {
                                    return 0.40f;
                                }
                                if (slotItem.equals(ModItems.wootzingotball)) {
                                    return 0.41f;
                                }
                                if (slotItem.equals(ModItems.bronzechunk)) {
                                    return 0.42f;
                                }
                                if (slotItem.equals(ModItems.wroughtironchunk)) {
                                    return 0.43f;
                                }
                                if (slotItem.equals(ModItems.ironcleanchunk)) {
                                    return 0.44f;
                                }
                                if (slotItem.equals(ModItems.steelchunk)) {
                                    return 0.45f;
                                }
                                if (slotItem.equals(ModItems.wootzchunk)) {
                                    return 0.46f;
                                }
                            }
                        }
                    }
                }
                return 0.0F;
            }
        });

    }



    @Override
    public ICapabilityProvider initCapabilities(final ItemStack stack, NBTTagCompound nbt)
    {
        return new ICapabilityProvider()
        {
            final ItemStackHandler itemHandler = new ItemStackHandler(1);

            @Override
            public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
            {
                if (capability == ITEM_HANDLER)
                    return true;
                return false;
            }

            @SuppressWarnings("unchecked")
            @Nullable
            @Override
            public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
            {
                if (capability == ITEM_HANDLER)
                    return (T) itemHandler;
                return null;
            }
        };
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing face, float hitx, float hity, float hitz)
    {
        if(!world.isRemote) {
            if (hand.equals(player.getActiveHand())) {
                IBlockState state = world.getBlockState(pos);
                Block block = world.getBlockState(pos).getBlock();
                ItemStack itemstack = player.getHeldItem(hand);
                IItemHandler inventory = itemstack.getCapability(ITEM_HANDLER, null);
                ItemStack slotStack = inventory.getStackInSlot(0).copy();
/*
            if (block instanceof AnvilStone) {
                TileAnvil tile = (TileAnvil) world.getTileEntity(pos);
                doAnvilInventoryManager(itemstack, world, tile, pos, hitx, hity, hitz, state, player);
                return EnumActionResult.SUCCESS;
            }
*/
                if (slotStack.isEmpty()) {
                    if (block instanceof NBTCrucible) {
                        ItemStack tempStack = takeBlock(world, pos, state, face, player, block).copy();
                        inventory.insertItem(0, tempStack, false);
                        world.setBlockState(pos, this.getReplacementBlock(world, pos, state));
                        return EnumActionResult.SUCCESS;
                    }
                }
                if (!slotStack.isEmpty()) {
                    if (slotStack.getItem() instanceof ItemNBTCrucible) {
                        NBTTagCompound tag = slotStack.getSubCompound("BlockEntityTag").copy();

                        if (tag != null) {
                            ItemBlock temp = (ItemBlock) slotStack.getItem();
                            int i = this.getMetadata(slotStack.getMetadata());
                            IBlockState iblockstate1 = temp.getBlock().getStateForPlacement(world, pos, face, hitx, hity, hitz, i, player, hand);
                            temp.placeBlockAt(slotStack, player, world, pos.up(1), face, hitx, hity, hitz, iblockstate1);
                            inventory.extractItem(0, 1, false);
                            return EnumActionResult.SUCCESS;
                        }
                    }
                }

                /*****
                 DROPS the ToolParts into the World
                 *****/
                if (!slotStack.isEmpty()) {
                    if (!(block instanceof AnvilBase)) {
                        if (slotStack.getItem() instanceof ToolPart) {
                            ItemStack tempStack = slotStack;
                            PlayerHelper.spawnItemOnGround(world, pos, tempStack);
                            inventory.extractItem(0, 1, false);
                            return EnumActionResult.SUCCESS;
                        }
                    }
                }

                /*****
                 Cools the Ingots on the Tongs
                 *****/
                if (!slotStack.isEmpty()) {
                    if (world.getBlockState(pos).getBlock() == PrimalAPI.Blocks.BARREL) {
                        AbstractTileTank tileTank = (AbstractTileTank) world.getTileEntity(pos);
                        if (slotStack.getTagCompound().getBoolean("hot")) {
                            if (tileTank.getContainedFluid().getFluid().equals(FluidRegistry.WATER) ||
                                    tileTank.getContainedFluid().getFluid().equals(PrimalAPI.Fluids.RAIN_WATER)
                                    ) {
                                ItemStack tempStack = slotStack.copy();
                                tempStack.getTagCompound().setBoolean("hot", false);
                                inventory.extractItem(0, 1, false);
                                PlayerHelper.spawnItemOnGround(world, pos, tempStack);
                                world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT, 1.0F, PrimalAPI.getRandom().nextFloat() * 0.4F + 0.8F);
                                return EnumActionResult.SUCCESS;
                            }
                        }
                    }
                }

                /*****
                 DROPS the Ingots into the World
                 *****/
                if (!slotStack.isEmpty()) {
                    if (!(block instanceof AnvilBase)) {
                        if (!(block instanceof Forge)) {
                            if (slotStack.getItem() instanceof BaseMultiItem) {
                                ItemStack tempStack = slotStack.copy();
                                PlayerHelper.spawnItemOnGround(world, pos, tempStack);
                                inventory.extractItem(0, 1, false);
                                return EnumActionResult.SUCCESS;
                            }
                            if (!(slotStack.getItem() instanceof BaseMultiItem)) {
                                if (RecipeHelper.isOreName(slotStack.getItem(), "ingotIron")) {
                                    ItemStack tempStack = slotStack.copy();
                                    PlayerHelper.spawnItemOnGround(world, pos, tempStack);
                                    inventory.extractItem(0, 1, false);
                                    return EnumActionResult.SUCCESS;
                                }
                                if (RecipeHelper.isOreName(slotStack.getItem(), "nuggetIron")) {
                                    ItemStack tempStack = slotStack.copy();
                                    PlayerHelper.spawnItemOnGround(world, pos, tempStack);
                                    inventory.extractItem(0, 1, false);
                                    return EnumActionResult.SUCCESS;
                                }
                                if (RecipeHelper.isOreName(slotStack.getItem(), "ingotSteel")) {
                                    ItemStack tempStack = slotStack.copy();
                                    PlayerHelper.spawnItemOnGround(world, pos, tempStack);
                                    inventory.extractItem(0, 1, false);
                                    return EnumActionResult.SUCCESS;
                                }
                                if (RecipeHelper.isOreName(slotStack.getItem(), "nuggetSteel")) {
                                    ItemStack tempStack = slotStack.copy();
                                    PlayerHelper.spawnItemOnGround(world, pos, tempStack);
                                    inventory.extractItem(0, 1, false);
                                    //inventory.insertItem(0, ItemStack.EMPTY, false);
                                    return EnumActionResult.SUCCESS;
                                }
                            }
                        }
                    }
                }
                return EnumActionResult.FAIL;
            }
            return EnumActionResult.FAIL;
        }
        return EnumActionResult.FAIL;
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

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn)
    {
        if(!stack.isEmpty())
        {
            IItemHandler inventory = stack.getCapability(ITEM_HANDLER, null);
            ItemStack slotStack = inventory.getStackInSlot(0).copy();
            if (!slotStack.isEmpty())
            {
                tooltip.add(ChatFormatting.GRAY + "Holding: " + slotStack.getItem().getUnlocalizedName());
                /*
                tooltip.add(ChatFormatting.GRAY + "Upgrades: " + (3 - getModifiers(item)) );
                if (getEmerald(item) == true) {
                    tooltip.add(ChatFormatting.DARK_GREEN + "Emerald");
                }
                if (getDiamondLevel(item) > 0) {
                    tooltip.add(ChatFormatting.AQUA + "Diamond Level: " + getDiamondLevel(item));
                }
                if (getRedstoneLevel(item) > 0) {
                    tooltip.add(ChatFormatting.RED + "Redstone Level: " + getRedstoneLevel(item) );
                }
                if (getLapisLevel(item) > 0) {
                    tooltip.add(ChatFormatting.BLUE + "Lapis Level: " + getLapisLevel(item) );
                }
                tooltip.add(ChatFormatting.LIGHT_PURPLE + "Damage: " + item.getItemDamage() );
                */
            }
        }
    }

    @Nullable
    @Override
    public NBTTagCompound getNBTShareTag(ItemStack stack)
    {
        super.getNBTShareTag(stack);
        IItemHandler inventory = stack.getCapability(ITEM_HANDLER, null);
        NonNullList<ItemStack> setList = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
        ItemStackHelper.saveAllItems(stack.getTagCompound(), setList);
        return stack.getTagCompound();
    }

    @Override
    public void readNBTShareTag(ItemStack stack, @Nullable NBTTagCompound nbt)
    {
        super.readNBTShareTag(stack, nbt);

        stack.deserializeNBT(nbt);
        IItemHandler inventory = stack.getCapability(ITEM_HANDLER, null);
        NonNullList<ItemStack> setList = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(nbt, setList);
        inventory.insertItem(0, setList.get(0), false);

    }

}
