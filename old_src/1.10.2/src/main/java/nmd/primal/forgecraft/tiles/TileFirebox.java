package nmd.primal.forgecraft.tiles;

import com.sun.org.apache.xpath.internal.operations.Bool;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import nmd.primal.forgecraft.CommonUtils;
import nmd.primal.forgecraft.blocks.Firebox;
import nmd.primal.forgecraft.init.ModBlocks;
import org.omg.PortableInterceptor.ACTIVE;
import net.minecraft.block.BlockFurnace;

import static net.minecraft.block.BlockHorizontal.FACING;
import static nmd.primal.forgecraft.CommonUtils.getVanillaItemBurnTime;

/**
 * Created by mminaie on 11/30/16.
 */
public class TileFirebox extends BaseTile implements IInventory, ITickable {

    private ItemStack[] inventory = new ItemStack [0];
    private String customName;
    private int iteration = 0;

    public TileFirebox() {
        this.inventory = new ItemStack[this.getSizeInventory()];
    }

    @Override
    public void update () {
        if(!worldObj.isRemote){
            World world = this.getWorld();
            this.iteration ++;
            if(this.iteration == 200 ) {
                //System.out.println(iteration);
                this.iteration = 0;
                IBlockState state = world.getBlockState(this.pos);
                BlockPos abovePos = new BlockPos(this.getPos().getX(), this.getPos().getY()+1, this.getPos().getZ());
                IBlockState aboveState = world.getBlockState(abovePos);
                if (worldObj.getBlockState(this.getPos()).getValue(Firebox.ACTIVE)) {
                    if (this.getStackInSlot(0) == null) {
                        worldObj.setBlockState(this.getPos(), state.withProperty(Firebox.ACTIVE, false), 2);
                        this.markDirty();
                        world.notifyBlockUpdate(pos, state, state, 2);
                    } else {
                        if(this.getStackInSlot(0) != null) {
                            if (worldObj.rand.nextInt((int) Math.floor(getVanillaItemBurnTime(this.getStackInSlot(0)) / 20)) == 0) {
                                this.decrStackSize(0, 1);

                                this.markDirty();
                                world.notifyBlockUpdate(pos, state, state, 2);
                            }
                            if(world.getBlockState(abovePos).getBlock() instanceof BlockFurnace){
                                //System.out.println("Trying to set Block Furnace State active");
                                IBlockState iblockstate = world.getBlockState(abovePos);
                                TileEntityFurnace tileFurnace = (TileEntityFurnace) world.getTileEntity(abovePos);

                                if(world.getBlockState(abovePos).getBlock() == Blocks.LIT_FURNACE){
                                    tileFurnace.setField(0,1000);
                                }
                                if(world.getBlockState(abovePos).getBlock() == Blocks.FURNACE){
                                    BlockFurnace.setState(true, world, abovePos);
                                    //world.setBlockState(abovePos, Blocks.LIT_FURNACE.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
                                    tileFurnace.setField(0,1000);
                                }
                            }
                        }
                    }
                }
            }

        }
        /*if (worldObj.isRemote){
            World world = this.getWorld();
            if(this.getStackInSlot(0)!=null){
                renderItem = new EntityItem(world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), this.getStackInSlot(0));
            }
        }*/
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName (String customName){
        this.customName = customName;
    }

    @Override
    public String getName(){
        //if custName is true return this.customName if false return --v
        // ? means if true : means if false
        return this.hasCustomName() ? this.customName : "container.firebox";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.equals("");
    }

    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        if (index < 0 || index >= this.getSizeInventory())
            return null;
        return this.inventory[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (this.getStackInSlot(index) != null) {
            ItemStack itemstack;

            if (this.getStackInSlot(index).stackSize <= count) {
                itemstack = this.getStackInSlot(index);
                this.setInventorySlotContents(index, null);
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.getStackInSlot(index).splitStack(count);

                if (this.getStackInSlot(index).stackSize <= 0) {
                    this.setInventorySlotContents(index, null);
                } else {
                    //Just to show that changes happened
                    this.setInventorySlotContents(index, this.getStackInSlot(index));
                }

                this.markDirty();
                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        if (index < 0 || index >= this.getSizeInventory()) {
            return;
        }

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }

        if (stack != null && stack.stackSize == 0) {
            stack = null;
        }

        this.inventory[index] = stack;
        this.markDirty();

        World world = this.getWorld();
        IBlockState state = world.getBlockState(this.pos);
        world.notifyBlockUpdate(this.pos, state, state, 3);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = this.getStackInSlot(index);
        this.setInventorySlotContents(index, null);
        return stack;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player){
        return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5f)) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    public void closeInventory(EntityPlayer player){

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        for(int i = 0; i < this.getSizeInventory(); i++){
            this.setInventorySlotContents(i, null);
        }
    }

    // ***************************************************************************** //
    //  NBT
    // ***************************************************************************** //
    @Override
    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        NBTTagList list = nbt.getTagList("Items", Constants.NBT.TAG_COMPOUND);
        inventory = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < list.tagCount(); ++i)
        {
            NBTTagCompound tag = list.getCompoundTagAt(i);
            this.inventory[tag.getByte("slot")] = ItemStack.loadItemStackFromNBT(tag);
        }

        if (nbt.hasKey("CustomName", 8)) {
            this.setCustomName(nbt.getString("CustomName"));
        }

        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        NBTTagList list = new NBTTagList();

        ///
        //  RackMatrix
        ///
        for (int i = 0; i < this.getSizeInventory(); ++i)
        {
            if (inventory[i] != null) {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("slot", (byte) i);
                inventory[i].writeToNBT(tag);
                list.appendTag(tag);
            }
        }

        nbt.setTag("Items", list);

        return nbt;
    }

    @Override
    public NBTTagCompound getUpdateTag()
    {
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 0, this.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
    }

}
