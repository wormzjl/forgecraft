package nmd.primal.forgecraft.items.tools;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.util.ToolNBT;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractHoe extends ItemHoe implements ToolNBT {

    private Item drop;

    public AbstractHoe(String name, ToolMaterial material, Item damageDrop) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setMaxStackSize(1);
        this.setNoRepair();
        this.drop = damageDrop;
        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

            /***

             hot | emerald | diamond | redstone | lapis
             X.0 |   0.X   |   0.0X  |   0.00X  |  0.000X

             ***/

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack item, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (item.hasTagCompound()) {
                    Float returnFloat = 0.0F;
                    if(getEmerald(item)){
                        returnFloat += 0.1F;
                    }
                    if(getDiamondLevel(item)>0){
                        returnFloat += (0.01F * getDiamondLevel(item));
                    }
                    if(getRedstoneLevel(item)>0){
                        returnFloat += (0.001F * getRedstoneLevel(item));
                    }
                    if(getLapisLevel(item)>0){
                        returnFloat += (0.0001F * getLapisLevel(item));
                    }
                    if(getHot(item)){
                        returnFloat = 1.0F;
                    }
                    return returnFloat;
                }
                return 0.0F;
            }
        });
    }

    public static boolean isHidden()
    {
        return false;
    }

    @Override
    public void onCreated(ItemStack item, World world, EntityPlayer playerIn) {

        if(!world.isRemote) {
            if (!item.hasTagCompound()) {
                item.setTagCompound(new NBTTagCompound());
                NBTTagCompound tags = new NBTTagCompound();

                item.getTagCompound().setTag("tags", tags);

                /*setHot(item, false);

                setHot(item, false);
                setEmerald(item, false);
                setDiamondLevel(item, 0);
                setRedstoneLevel(item, 0);
                setLapisLevel(item, 0);
                setModifiers(item, 0);*/
            }
        }
    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int itemSlot, boolean isSelected) {
        if(!world.isRemote) {
            if (!item.hasTagCompound()) {
                item.setTagCompound(new NBTTagCompound());
                NBTTagCompound tags = new NBTTagCompound();

                item.getTagCompound().setTag("tags", tags);

                setHot(item, false);
                setEmerald(item, false);
                setDiamondLevel(item, 0);
                setRedstoneLevel(item, 0);
                setLapisLevel(item, 0);
                setModifiers(item, 0);

            }

            if( this.getMaxDamage(item) - this.getDamage(item) <= 1 ){
                PlayerHelper.spawnItemOnPlayer(world, (EntityPlayer) player, new ItemStack(this.drop, 1));
                ((EntityPlayer) player).inventory.deleteStack(item);
            }

        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn)
    {
        if(!item.isEmpty())
        {
            if (item.hasTagCompound())
            {
                tooltip.add(ChatFormatting.GRAY + "Upgrades added: " + (getModifiers(item)) );
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
            }
        }
    }

    @Override
    protected void setBlock(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

        if (!worldIn.isRemote)
        {
            worldIn.setBlockState(pos, state, 11);
            if(stack.getMaxDamage() - stack.getItemDamage() >1 ) {
                stack.damageItem(1, player);
            } else {
                ItemStack dropStack = new ItemStack(drop, 1);
                dropStack.setItemDamage(stack.getItemDamage());
                dropStack.setTagCompound(new NBTTagCompound());
                NBTTagCompound copyNBT;
                copyNBT = stack.getSubCompound("tags").copy();
                dropStack.setTagCompound(copyNBT);
                PlayerHelper.spawnItemOnPlayer(worldIn, player, dropStack);
                player.renderBrokenItemStack(stack);
                stack.shrink(1);
            }
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        if(stack.getMaxDamage() - stack.getItemDamage() >1 ) {
            stack.damageItem(1, attacker);
            return true;
        } else {
            ItemStack dropStack = new ItemStack(drop, 1, stack.getItemDamage());
            NBTTagCompound copyNBT = stack.getTagCompound();
            dropStack.setTagCompound(copyNBT);

            EntityPlayer player = (EntityPlayer) attacker;
            World world = attacker.getEntityWorld();
            if(!world.isRemote) {
                PlayerHelper.spawnItemOnPlayer(world, player, dropStack);
                attacker.renderBrokenItemStack(stack);
                stack.shrink(1);
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D)
        {
            if(stack.getMaxDamage() - stack.getItemDamage() >1 ) {
                stack.getTagCompound().removeTag("ench");
                if(getDiamondLevel(stack) > 0) {
                    if(ThreadLocalRandom.current().nextInt(0, getDiamondLevel(stack)) == 0) {
                        stack.damageItem(1, entityLiving);
                    }
                } else stack.damageItem(1, entityLiving);
            } else {
                ItemStack dropStack = new ItemStack(drop, 1, stack.getItemDamage());
                NBTTagCompound copyNBT = stack.getTagCompound();
                dropStack.setTagCompound(copyNBT);
                EntityPlayer player = (EntityPlayer) entityLiving;
                PlayerHelper.spawnItemOnPlayer(world, player, dropStack);
                entityLiving.renderBrokenItemStack(stack);
                stack.shrink(1);
            }
        }

        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return false;
    }

    @Override
    public boolean isRepairable()
    {
        return false;
    }

    @Override
    public int getItemEnchantability(ItemStack stack)
    {
        return 0;
    }

}
