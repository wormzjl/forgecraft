package nmd.primal.forgecraft.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class SledgeHammer extends BaseItem {

    public SledgeHammer(String registryName, Item.ToolMaterial material) {
        super(registryName);
        this.setMaxDamage(material.getMaxUses()*3);
        this.setHarvestLevel("pickaxe",  material.getHarvestLevel());
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(!world.isRemote){
            EntityPlayer player = (EntityPlayer) entity;
            if(player.inventory.getCurrentItem().getItem().equals(stack.getItem())) {
                if(player.isPotionActive(MobEffects.MINING_FATIGUE)) {
                    if (!player.isSwingInProgress) {
                        player.removeActivePotionEffect(MobEffects.MINING_FATIGUE);
                    }
                }
            }
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if(!world.isRemote) {
            if (!player.isSwingInProgress) {
                player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 150, 100));
                player.swingArm(hand);
                return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
    }
}
