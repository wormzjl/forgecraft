package nmd.primal.forgecraft.items.weapons;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.init.ModSounds;
import nmd.primal.forgecraft.items.BaseItem;

import javax.annotation.Nullable;

/**
 * Created by mminaie on 7/2/17.
 */
public class Longbow extends BaseItem {

    int mod=15;
    int time=0;

    public Longbow(String name) {
        super(name);
        this.setMaxDamage(9000);
        this.setMaxStackSize(1);
        this.setNoRepair();

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {

            @SideOnly(Side.CLIENT)
            public float apply(ItemStack item, @Nullable World worldIn, @Nullable EntityLivingBase playerin) {

                    if (time < 1 * mod) {
                        return 0.0F;
                    }
                    if (time >= 1 * mod && time < 2 * mod) {
                        return 0.1F;
                    }
                    if (time >= 2 * mod && time < 3 * mod) {
                        return 0.2F;
                    }
                    if (time >= 3 * mod && time < 4 * mod) {
                        return 0.3F;
                    }
                    if (time >= 4 * mod && time < 5 * mod) {
                        return 0.4F;
                    }
                    if (time >= 5 * mod && time < 6 * mod) {
                        return 0.5F;
                    }
                    if (time >= 6 * mod && time < 7 * mod) {
                        return 0.6F;
                    }
                    if (time >= 7 * mod && time < 8 * mod) {
                        return 0.7F;
                    }
                    if (time >= 8 * mod && time < 72000) {
                        return 0.8F;
                    }

                return 0.0f;
            }
        });
    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity playerin, int itemSlot, boolean isSelected) {

        EntityPlayer player = (EntityPlayer) playerin;
        if(player.inventory.getCurrentItem().getItem() == ModItems.longbow) {
            time = item.getMaxItemUseDuration() - player.getItemInUseCount();
        }

    }

    private ItemStack findAmmo(EntityPlayer player)
    {

        for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
        {
            ItemStack itemstack = player.inventory.getStackInSlot(i);

            if (this.isArrow(itemstack))
            {
                return itemstack;
            }
        }

        return ItemStack.EMPTY;

    }

    protected boolean isArrow(ItemStack stack)
    {
        return stack.getItem() instanceof ItemArrow;
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            worldIn.playSound(null, entityplayer.getPosition(), ModSounds.BOW_TWANG, SoundCategory.BLOCKS, 1.0F, 1.0F);
            boolean flag = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = this.findAmmo(entityplayer);

            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag)
            {
                if (itemstack.isEmpty())
                {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getArrowVelocity(i);

                if ((double)f >= 0.1D)
                {
                    boolean flag1 = entityplayer.capabilities.isCreativeMode || (itemstack.getItem() instanceof ItemArrow && ((ItemArrow) itemstack.getItem()).isInfinite(itemstack, stack, entityplayer));

                    if (!worldIn.isRemote)
                    {
                        ItemArrow itemarrow = (ItemArrow)((ItemArrow)(itemstack.getItem() instanceof ItemArrow ? itemstack.getItem() : Items.ARROW));
                        EntityArrow entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);
                        entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 6.0F, 1.0F);

                        if (f >= 1.0F)
                        {
                            entityarrow.setIsCritical(true);
                        }

                        stack.damageItem(1, entityplayer);

                        entityarrow.pickupStatus = EntityArrow.PickupStatus.ALLOWED;

                        worldIn.spawnEntity(entityarrow);
                    }

                    //worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);


                    if (!flag1 && !entityplayer.capabilities.isCreativeMode)
                    {
                        itemstack.shrink(1);

                        if (itemstack.isEmpty())
                        {
                            entityplayer.inventory.deleteStack(itemstack);
                        }
                    }

                    entityplayer.addStat(StatList.getObjectUseStats(this));
                }
            }
        }
    }

    /**
     * Gets the velocity of the arrow entity from the bow's charge
     */

    public static float getArrowVelocity(int charge)
    {
        float f = (float)charge / 120;

        if (f > 1.0F)
        {
            f = 1.0F;
        }
        if(f < 0.1){
            f =0.1f;
        }

        return f;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }



    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }

    /**
     * Called when the equipped item is right clicked.
     */
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        boolean flag = !this.findAmmo(playerIn).isEmpty();

        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
        if (ret != null) return ret;

        if (!playerIn.capabilities.isCreativeMode && !flag)
        {
            return flag ? new ActionResult(EnumActionResult.PASS, itemstack) : new ActionResult(EnumActionResult.FAIL, itemstack);
        }
        else
        {
            playerIn.setActiveHand(handIn);
            return new ActionResult(EnumActionResult.SUCCESS, itemstack);
        }
    }

    @Override
    public int getItemEnchantability()
    {
        return 0;
    }
}