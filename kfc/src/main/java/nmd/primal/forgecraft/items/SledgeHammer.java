package nmd.primal.forgecraft.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.util.ITooltipFlag;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.util.ToolMaterialMap;

import javax.annotation.Nullable;
import java.util.List;

public class SledgeHammer extends BaseItem implements ToolMaterialMap {



    private ToolMaterial material;

    public SledgeHammer(String registryName, Item.ToolMaterial material) {
        super(registryName);
        this.setMaxDamage(material.getMaxUses()*3);
        this.setHarvestLevel("pickaxe",  material.getHarvestLevel());
        this.material=material;
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
        if(isSelected){
            entity.setSprinting(false);
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if(!world.isRemote) {
            if (!player.isSwingInProgress) {
                int tempInt = 0;
                player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, (100/(materialModifiers.get(this.getMaterial())+tempInt)), 100));
                player.swingArm(hand);
                return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
    }

    public ToolMaterial getMaterial() {
        return material;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add(ChatFormatting.LIGHT_PURPLE + "Damage: " + item.getItemDamage() );
    }

}
