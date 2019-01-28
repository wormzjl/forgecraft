package nmd.primal.forgecraft.items.weapons;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.util.WeaponNBT;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by mminaie on 6/25/17.
 */
public class SlayerSword extends CustomSword {

    public SlayerSword(String name, Item.ToolMaterial material, double attackDamage, double attackSpeed) {
        super(name, material, attackDamage, attackSpeed);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity ent, int itemSlot, boolean isSelected) {

        if(isSelected){
            EntityPlayer player = (EntityPlayer) ent;
            if(!stack.hasTagCompound()) {
                WeaponNBT.setDefaultNBT(stack);
            }

            if(!player.inventory.offHandInventory.isEmpty()) {
                ent.setSprinting(false);
            }
            if(stack.hasTagCompound()) {
                if (stack.getItemDamage() < stack.getMaxDamage() * 0.5) {
                    WeaponNBT.setSharpnessLevel(stack, 5);
                }
                if (stack.getItemDamage() > stack.getMaxDamage() * 0.5 && stack.getItemDamage() < stack.getMaxDamage() * 0.6) {
                    WeaponNBT.setSharpnessLevel(stack, 4);
                }
                if (stack.getItemDamage() > stack.getMaxDamage() * 0.6 && stack.getItemDamage() < stack.getMaxDamage() * 0.7) {
                    WeaponNBT.setSharpnessLevel(stack, 3);
                }
                if (stack.getItemDamage() > stack.getMaxDamage() * 0.7 && stack.getItemDamage() < stack.getMaxDamage() * 0.8) {
                    WeaponNBT.setSharpnessLevel(stack, 2);
                }
                if (stack.getItemDamage() > stack.getMaxDamage() * 0.8 && stack.getItemDamage() < stack.getMaxDamage() * 0.9) {
                    WeaponNBT.setSharpnessLevel(stack, 1);
                }
                if (stack.getItemDamage() > stack.getMaxDamage() * 0.9 && stack.getItemDamage() < stack.getMaxDamage()) {
                    WeaponNBT.setSharpnessLevel(stack, 0);
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(ChatFormatting.LIGHT_PURPLE + "Damage: " + stack.getItemDamage());
        if (stack.hasTagCompound()) {
            if (stack.getSubCompound("tags") != null) {
                //System.out.println(WeaponNBT.materialModifiers.get(this.toolMaterial));
                //System.out.println(stack.getSubCompound("tags").getInteger("modifiers"));
                tooltip.add(ChatFormatting.GRAY + "Upgrades left: " + (WeaponNBT.materialModifiers.get(this.toolMaterial) - WeaponNBT.getModifiers(stack)));
                //if (WeaponNBT.getSmiteLevel(stack) > 0) {
                tooltip.add(ChatFormatting.GOLD + "Holy: " + WeaponNBT.getSmiteLevel(stack));
                //}
                //if (WeaponNBT.getBaneLevel(stack) > 0) {
                tooltip.add(ChatFormatting.GREEN + "Spider Killing: " + WeaponNBT.getBaneLevel(stack));
                //}
                //if (WeaponNBT.getFireLevel(stack) > 0) {
                tooltip.add(ChatFormatting.RED + "Flame: " + WeaponNBT.getFireLevel(stack));
                //}
                //if (WeaponNBT.getFortuneLevel(stack) > 0) {
                tooltip.add(ChatFormatting.BLUE + "Thieving: " + WeaponNBT.getFortuneLevel(stack));
                //}
                //if (WeaponNBT.getLeechLevel(stack) > 0) {
                tooltip.add(ChatFormatting.LIGHT_PURPLE + "Life Steal: " + WeaponNBT.getLeechLevel(stack));
                //}
                //if (WeaponNBT.getSharpnessLevel(stack) > 0) {
                tooltip.add(ChatFormatting.WHITE + "Sharpness: " + WeaponNBT.getSharpnessLevel(stack));
                //}
            }
        }
    }
}
