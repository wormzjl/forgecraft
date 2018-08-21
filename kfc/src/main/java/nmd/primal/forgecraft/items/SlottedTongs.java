package nmd.primal.forgecraft.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.api.interfaces.IPickup;
import nmd.primal.core.common.helper.NBTHelper;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.blocks.Anvil.AnvilBase;
import nmd.primal.forgecraft.blocks.Anvil.AnvilStone;
import nmd.primal.forgecraft.blocks.Crucibles.NBTCrucible;
import nmd.primal.forgecraft.blocks.Forge;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.blocks.ItemNBTCrucible;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.tiles.TileAnvil;
import nmd.primal.forgecraft.tiles.TileForge;
import nmd.primal.forgecraft.tiles.TileNBTCrucible;
import nmd.primal.forgecraft.util.AnvilHandler;

import javax.annotation.Nullable;

/**
 * Created by mminaie on 12/30/17.
 */
public class SlottedTongs extends Item implements IPickup, AnvilHandler{

    public SlottedTongs(String unlocalizedName) {
        setUnlocalizedName(unlocalizedName);
        this.setRegistryName(unlocalizedName);
        this.setMaxStackSize(1);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                SlottedTongs item = (SlottedTongs) stack.getItem();
                ItemStack slotStack = item.getSlotList().get(0);
                //TODO get the item name
                if (stack.getItem() instanceof SlottedTongs) {
                    //System.out.println(slotStack.getTagCompound());
                    if (slotStack.getItem() instanceof ItemNBTCrucible){
                        //System.out.println(item.getSlotList().get(0).getSubCompound("BlockEntityTag").getInteger("hot"));
                        //Render Empty Crucible
                        if(item.getSlotList().get(0).getSubCompound("BlockEntityTag").getInteger("hot") == 0){
                            return 0.0f;
                        }
                        //Render Level 1
                        if(item.getSlotList().get(0).getSubCompound("BlockEntityTag").getInteger("hot") == 1){
                            return 0.011f;
                        }
                        //Render Level 2
                        if(item.getSlotList().get(0).getSubCompound("BlockEntityTag").getInteger("hot") == 2){
                            return 0.012f;
                        }
                        //Render Level 3
                        if(item.getSlotList().get(0).getSubCompound("BlockEntityTag").getInteger("hot") == 3){
                            return 0.013f;
                        }
                        //Render Level 4
                        if(item.getSlotList().get(0).getSubCompound("BlockEntityTag").getInteger("hot") == 4){
                            return 0.014f;
                        }
                        //Render Level 5
                        if(item.getSlotList().get(0).getSubCompound("BlockEntityTag").getInteger("hot") == 5){
                            return 0.015f;
                        }
                        //Render Cooked
                        if(item.getSlotList().get(0).getSubCompound("BlockEntityTag").getInteger("hot") == 6){
                            return 0.016f;
                        }
                        //Render Slagged
                        if(item.getSlotList().get(0).getSubCompound("BlockEntityTag").getInteger("hot") == 7){
                            return 0.017f;
                        }
                        //Render Hot
                        if(item.getSlotList().get(0).getSubCompound("BlockEntityTag").getInteger("hot") == 15){
                            return 0.025f;
                        }
                    }
                    if(slotStack.getItem() instanceof ToolPart){
                        ToolPart toolPart = (ToolPart) item.getSlotList().get(0).getItem();
                        if(toolPart.getID() == "pickaxe"){
                            if (item.getSlotList().get(0).getSubCompound("tags") != null) {
                                if (slotStack.getSubCompound("tags").getBoolean("hot")) {
                                    return 0.03f;
                                }
                                if (!item.getSlotList().get(0).getSubCompound("tags").getBoolean("hot")) {
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
                            if (item.getSlotList().get(0).getSubCompound("tags") != null) {
                                if (slotStack.getSubCompound("tags").getBoolean("hot")) {
                                    return 0.09f;
                                }
                                if (!item.getSlotList().get(0).getSubCompound("tags").getBoolean("hot")) {
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
                            if (item.getSlotList().get(0).getSubCompound("tags") != null) {
                                if (slotStack.getSubCompound("tags").getBoolean("hot")) {
                                    return 0.15f;
                                }
                                if (!item.getSlotList().get(0).getSubCompound("tags").getBoolean("hot")) {
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
                            if (item.getSlotList().get(0).getSubCompound("tags") != null) {
                                if (slotStack.getSubCompound("tags").getBoolean("hot")) {
                                    return 0.21f;
                                }
                                if (!item.getSlotList().get(0).getSubCompound("tags").getBoolean("hot")) {
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
                                if (slotItem.equals(ModItems.ironchunk)) {
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
                                if (slotItem.equals(ModItems.ironchunk)) {
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

    public NonNullList<ItemStack> getSlotList() {
        return slotList;
    }

    public void setSlotList(ItemStack stack) {
        slotList.set(0, stack);
    }

    public NonNullList<ItemStack> slotList = NonNullList.withSize(1, ItemStack.EMPTY);

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing face, float hitx, float hity, float hitz)
    {
        if(!world.isRemote){
            //if (hand.equals(player.swingingHand)) {
                IBlockState state = world.getBlockState(pos);
                Block block = world.getBlockState(pos).getBlock();
                ItemStack itemstack = player.getHeldItem(hand);

                if (block instanceof AnvilStone) {
                    TileAnvil tile = (TileAnvil) world.getTileEntity(pos);
                    doAnvilInventoryManager(itemstack, world, tile, pos, hitx, hity, hitz, state, player);
                    return EnumActionResult.SUCCESS;
                }

                if (slotList.get(0).isEmpty()) {
                    if (block instanceof NBTCrucible) {
                        ItemStack tempStack = takeBlock(world, pos, state, face, player, block).copy();
                        slotList.set(0, tempStack);
                        world.setBlockState(pos, this.getReplacementBlock(world, pos, state));
                        return EnumActionResult.SUCCESS;
                    }
                }
                if (!slotList.get(0).isEmpty()) {
                    if (slotList.get(0).getItem() instanceof ItemNBTCrucible) {
                        NBTTagCompound tag = this.slotList.get(0).getSubCompound("BlockEntityTag").copy();
                        NBTTagCompound defaultNBT = this.slotList.get(0).getTagCompound();
                        if (tag != null) {
                            ItemBlock temp = (ItemBlock) slotList.get(0).getItem();
                            int i = this.getMetadata(slotList.get(0).getMetadata());
                            IBlockState iblockstate1 = temp.getBlock().getStateForPlacement(world, pos, face, hitx, hity, hitz, i, player, hand);
                            temp.placeBlockAt(slotList.get(0), player, world, pos.up(1), face, hitx, hity, hitz, iblockstate1);
                            slotList.set(0, ItemStack.EMPTY);
                            return EnumActionResult.SUCCESS;
                        }
                    }
                }

                /*****
                 TAKES anything out from the Forge
                 *****/
                if (slotList.get(0).isEmpty()) {
                    if (world.getBlockState(pos).getBlock() instanceof Forge) {
                        TileForge tile = (TileForge) world.getTileEntity(pos);
                        for (int i = 2; i < tile.getSlotListSize(); i++) {
                            if (tile.getSlotStack(i) != ItemStack.EMPTY) {
                                ItemStack tempStack = tile.getSlotStack(i).copy();
                                System.out.println(tempStack);
                                slotList.set(0, tempStack);
                                tile.setSlotStack(i, ItemStack.EMPTY);
                                System.out.println(slotList.get(0));
                                return EnumActionResult.SUCCESS;
                            }
                        }
                    }
                }

                /*****
                 PUTS the Ingots into the Forge
                 *****/
                if (!slotList.get(0).isEmpty()) {
                    if (world.getBlockState(pos).getBlock() instanceof Forge) {
                        TileForge tile = (TileForge) world.getTileEntity(pos);
                        if (!(slotList.get(0).getItem() instanceof ToolPart)) {
                            for (int i = 2; i < tile.getSlotListSize(); i++) {
                                ItemStack tempStack = slotList.get(0).copy();
                                tile.setSlotStack(i, tempStack);
                                slotList.set(0, ItemStack.EMPTY);
                                return EnumActionResult.SUCCESS;
                            }
                        }
                    }
                }
                /*****
                 PUTS the ToolParts into the Forge
                 *****/

                if (!slotList.get(0).isEmpty()) {
                    if (world.getBlockState(pos).getBlock() instanceof Forge) {
                        TileForge tile = (TileForge) world.getTileEntity(pos);
                        if (slotList.get(0).getItem() instanceof ToolPart) {
                            ItemStack tempStack = slotList.get(0).copy();
                            tile.setSlotStack(4, tempStack);
                            slotList.set(0, ItemStack.EMPTY);
                            return EnumActionResult.SUCCESS;
                        }
                    }
                }

                /*****
                 DROPS the ToolParts into the World
                 *****/
                if (!slotList.get(0).isEmpty()) {
                    if (!(block instanceof AnvilBase)) {
                        if (slotList.get(0).getItem() instanceof ToolPart) {
                            ItemStack tempStack = slotList.get(0).copy();
                            PlayerHelper.spawnItemOnGround(world, pos, tempStack);
                            slotList.set(0, ItemStack.EMPTY);
                            return EnumActionResult.SUCCESS;
                        }
                    }
                }
                /*****
                 DROPS the Ingots into the World
                 *****/
                if (!slotList.get(0).isEmpty()) {
                    if (!(block instanceof AnvilBase)) {
                        if (slotList.get(0).getItem() instanceof BaseMultiItem) {
                            ItemStack tempStack = slotList.get(0).copy();
                            PlayerHelper.spawnItemOnGround(world, pos, tempStack);
                            slotList.set(0, ItemStack.EMPTY);
                            return EnumActionResult.SUCCESS;
                        }
                    }
                }
            //}

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

}
