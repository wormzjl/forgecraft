package nmd.primal.forgecraft.items.weapons;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.common.entities.projectiles.EntityMuckBall;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.init.ModSounds;
import nmd.primal.forgecraft.items.BaseItem;

import javax.annotation.Nullable;

/**
 * Created by Lyle on 4/2/2017.
 */
public class Musket extends BaseItem{

    public Musket(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setMaxStackSize(1);
        this.setNoRepair();
        //this.description = ".72 Calibre"
        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack item, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return 0.0f;

            }
        });
    }
    // Temporary onItemRightClick method
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);
        /*
        if (!player.capabilities.isCreativeMode)
        {
            stack.shrink(1);
        }
        */



        if (!world.isRemote)
        {
            world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, ModSounds.MUSKET_SHOT, SoundCategory.BLOCKS, 0.5F, 0.3F / (itemRand.nextFloat() * 0.4F + 0.8F));
            EntityMuckBall entity = new EntityMuckBall(world, player);
            entity.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 7.0F, 0.5F);
            world.spawnEntity(entity);
        }

        player.addStat(StatList.getObjectUseStats(this));
        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }
}
