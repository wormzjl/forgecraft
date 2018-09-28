package nmd.primal.forgecraft.tiles;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.helper.RecipeHelper;
import nmd.primal.forgecraft.blocks.machine.Forge;
import nmd.primal.forgecraft.crafting.ForgeCrafting;
import nmd.primal.forgecraft.items.BaseMultiItem;
import nmd.primal.forgecraft.items.parts.ToolPart;
import nmd.primal.forgecraft.util.ToolNBT;

import static nmd.primal.core.api.PrimalAPI.randomCheck;
import static nmd.primal.core.common.helper.FireHelper.makeSmoke;

/**
 * Created by mminaie on 11/30/16.
 */
public class TileForge extends TileBaseSlot implements ITickable, ToolNBT{

    private int arraySize = 2;
    private double[] normalMin = {0.0625, 0.5625};
    private double[] normalMax = {0.4375, 0.9375};
    private double[] reverseMin = {0.5625, 0.0625};
    private double[] reverseMax = {0.9375, 0.4375};

    public int getArraySize(){return arraySize;}
    public double getNormalX(Integer x) {
        return normalMin[x];
    }
    public double getNormalZ(Integer x) {
        return normalMax[x];
    }
    public double getReverseX(Integer x) {
        return reverseMin[x];
    }
    public double getReverseZ(Integer x) {return reverseMax[x];
    }

    //private NonNullList<ItemStack> mySlotList = NonNullList.<ItemStack>withSize(5, ItemStack.EMPTY);
    //private ItemStack[] inventory = new ItemStack [0];
    //private String customName;
    private int iteration = 0;
    private int heat;
    private int cookCounter2, cookCounter3, cookCounter4, cookCounter5, cookCounter6;

    @Override
    public void update () {
        if(!world.isRemote) {
            World world = this.getWorld();
            this.iteration++;
            IBlockState state = world.getBlockState(this.pos);
            BlockPos abovePos = new BlockPos(this.getPos().getX(), this.getPos().getY() + 1, this.getPos().getZ());
            IBlockState aboveState = world.getBlockState(abovePos);
            Block block = world.getBlockState(abovePos).getBlock();
            if (world.getBlockState(this.getPos()).getValue(PrimalAPI.States.ACTIVE)) {

                if (this.iteration == 200) {
                    RecipeHelper.fuelManager(world, this, this.getSlotStack(0));
                    if(randomCheck(800)) {
                        makeSmoke(world, pos);
                    }
                }
                if(this.iteration == 250){
                    setHeat(this.getHeat()-25);
                }
                if (this.iteration == 300) {
                    this.heatManager(this.getHeat(), state, this.getSlotStack(0), world, pos);
                    if (this.getSlotStack(0) == ItemStack.EMPTY) {
                        world.setBlockState(this.getPos(), state.withProperty(PrimalAPI.States.ACTIVE, false), 2);
                        this.markDirty();
                        world.notifyBlockUpdate(pos, state, state, 2);
                    }
                    RecipeHelper.fuelManager(world, this, this.getSlotStack(0));
                    if(randomCheck(1000)) {
                        makeSmoke(world, pos);
                    }

                }
                if(this.iteration >=301){
                    iteration =0;
                }
                craftingManager();
            }



        }
    }

    private void slotZeroManager(World world){
        if(this.getSlotStack(0) != ItemStack.EMPTY) {
            Integer decrInt = (int) Math.floor(RecipeHelper.getBurnTime(this.getSlotStack(0)) / 5);
            if(decrInt == 0) {
                decrInt = 1;
            }
            Integer size = this.getSlotStack(0).getCount();
            Integer burnModifier = 0;
            if(size / 16 <= 1){
                burnModifier = 1;
            }
            if(size / 16 > 1 && size / 16 <= 2){
                burnModifier = 2;
            }
            if(size / 16 > 2 && size / 16 <= 3){
                burnModifier = 3;
            }
            if(size / 16 > 3 && size / 16 <= 4){
                burnModifier = 4;
            }
            if (world.rand.nextInt(decrInt) == 0) {
                if (world.rand.nextInt(burnModifier) == 0) {
                    //System.out.println("Fuel Burn" + this.getSlotStack(0));
                    this.decrStackSize(0, 1);
                    this.markDirty();
                    this.updateBlock();
                }
            }
            if (this.getSlotStack(0).getCount() == 1){
                this.decrStackSize(0, 1);
                this.markDirty();
                this.updateBlock();
            }
            if(randomCheck(1000)) {
                makeSmoke(world, pos);
            }
        }
    }

    private void heatManager(Integer h, IBlockState state, ItemStack stack, World world, BlockPos pos){
        if(state.getValue(PrimalAPI.States.ACTIVE) == true){
            if(!stack.isEmpty()) {
                if(h > 0) {
                    this.setHeat(h - 25);
                }
                if(h < 50 ){
                    world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, false), 2);
                }
            }
            if(stack.isEmpty() || RecipeHelper.getBurnTime(stack) <=0){
                world.setBlockState(pos, state.withProperty(PrimalAPI.States.ACTIVE, false), 2);
            }
            if(this.getSlotStack(0).getItem() == PrimalAPI.Items.CHARCOAL_FAIR){
                if(this.getHeat() > 1610){
                    this.setHeat(1600);
                }
            }
            if(this.getSlotStack(0).getItem() == net.minecraft.init.Items.COAL && this.getSlotStack(0).getMetadata() == 1){
                if(this.getHeat() > 1210){
                    this.setHeat(1200);
                }
            }
            if(this.getSlotStack(0).getItem() == PrimalAPI.Items.CHARCOAL_GOOD){
                if(this.getHeat() > 2110){
                    this.setHeat(2100);
                }
            }
            if(this.getSlotStack(0).getItem() == PrimalAPI.Items.CHARCOAL_HIGH){
                if(this.getHeat() > 3510){
                    this.setHeat(3500);
                }
            }
        }
        if(state.getValue(PrimalAPI.States.ACTIVE) == false){
            if(h > 50){
                this.setHeat(h - 50);
            }
            if(h < 0){
                this.setHeat(0);
            }
        }
        if(world.getBlockState(pos).getBlock() instanceof Forge){
            Forge tempBlock = (Forge) world.getBlockState(pos).getBlock();
            if(this.getHeat() > tempBlock.getMaxHeat()){
                world.setBlockState(pos, Blocks.FIRE.getDefaultState(), 2);
                //world.markTileEntityForRemoval(this);
            }
        }
        this.updateBlock();
        this.markDirty();
    }


    private void craftingManager() {

        for (int i = 1; i < this.getSlotListSize(); i++) {
            ItemStack stack = this.getSlotStack(i).copy();

            ForgeCrafting recipe = ForgeCrafting.getRecipe(stack.getItem());
            if (recipe != null) {
                NBTTagCompound stackCompound = new NBTTagCompound();
                if(stack.hasTagCompound()){
                    stackCompound=stack.getTagCompound().copy();
                }
                if(i == 1){
                    if (this.getHeat() >= recipe.getHeatThreshold()) {
                        cookCounter2++;
                    }
                    if (this.getHeat() < recipe.getHeatThreshold() && cookCounter2 > 0) {
                        cookCounter2--;
                    }
                    if (cookCounter2 >= recipe.getIdealTime()) {
                        ItemStack outputStack = recipe.getOutput().copy();
                        outputNBTManager(stack, outputStack, stackCompound);
                        this.setSlotStack(i, outputStack);
                        cookCounter2 = 0;
                    }
                }
                if(i == 2){
                    if (this.getHeat() >= recipe.getHeatThreshold()) {
                        cookCounter3++;
                    }
                    if (this.getHeat() < recipe.getHeatThreshold() && cookCounter3 > 0) {
                        cookCounter3--;
                    }
                    if (cookCounter3 >= recipe.getIdealTime()) {
                        ItemStack outputStack = recipe.getOutput().copy();
                        outputNBTManager(stack, outputStack, stackCompound);
                        this.setSlotStack(i, outputStack);

                        cookCounter3 = 0;
                    }
                }
                if(i == 3){
                    if (this.getHeat() >= recipe.getHeatThreshold()) {
                        cookCounter4++;
                    }
                    if (this.getHeat() < recipe.getHeatThreshold() && cookCounter4 > 0) {
                        cookCounter4--;
                    }
                    if (cookCounter4 >= recipe.getIdealTime()) {
                        ItemStack outputStack = recipe.getOutput().copy();
                        outputNBTManager(stack, outputStack, stackCompound);
                        this.setSlotStack(i, outputStack);
                        cookCounter4 = 0;
                    }
                }
                if(i == 4){
                    if (this.getHeat() >= recipe.getHeatThreshold()) {
                        cookCounter5++;
                    }
                    if (this.getHeat() < recipe.getHeatThreshold() && cookCounter5 > 0) {
                        cookCounter5--;
                    }
                    if (cookCounter5 >= recipe.getIdealTime()) {
                        ItemStack outputStack = recipe.getOutput().copy();
                        outputNBTManager(stack, outputStack, stackCompound);
                        this.setSlotStack(i, outputStack);
                        cookCounter5 = 0;
                    }
                }
            }
        }
    }

    private ItemStack outputNBTManager(ItemStack stack, ItemStack outputStack, NBTTagCompound stackCompound){
        if(stack.hasTagCompound()){
            if(stack.getItem() instanceof ToolPart) {
                outputStack.setItemDamage(stack.getItemDamage());
                outputStack.setTagCompound(stackCompound);
                outputStack.getSubCompound("tags").setBoolean("hot", true);
                return outputStack;
            }
            if(stack.getItem() instanceof BaseMultiItem) {
                outputStack.setItemDamage(stack.getItemDamage());
                outputStack.setTagCompound(stackCompound);
                outputStack.getTagCompound().setBoolean("hot", true);
                return outputStack;
            }
        }
        return null;
    }

    public int getHeat(){
        return this.heat;
    }

    public void setHeat(int newHeat){
        this.heat = newHeat;
    }
    @Override
    public int getSlotLimit() {
        return 1;
    }

    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = this.getSlotStack(index);
        this.setSlotStack(index, ItemStack.EMPTY);
        return stack;
    }

    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if(index == 0){
            if(stack.getItem() == net.minecraft.init.Items.COAL){
                if(stack.getMetadata() == 1) {
                    return true;
                }
            }
            if(stack.getItem() == PrimalAPI.Items.CHARCOAL_GOOD
                    || stack.getItem() == PrimalAPI.Items.CHARCOAL_HIGH
                    || stack.getItem() == PrimalAPI.Items.CHARCOAL_FAIR){
                return true;
            }
        }
        return false;
    }

    // ***************************************************************************** //
    //  NBT
    // ***************************************************************************** //
    @Override
    public NBTTagCompound readNBT(NBTTagCompound nbt)
    {
        super.readNBT(nbt);
        this.heat = nbt.getInteger("heat");
        return nbt;
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nbt)
    {
        nbt.setInteger("heat", this.heat);
        super.writeNBT(nbt);
        return nbt;
    }

}
