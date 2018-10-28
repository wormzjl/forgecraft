package nmd.primal.forgecraft.items.weapons;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
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
            if(!player.inventory.offHandInventory.isEmpty()) {
                ent.setSprinting(false);
            }
            if (stack.getItemDamage() < stack.getMaxDamage() * 0.5){
                WeaponNBT.setSharpnessLevel(stack, 5);
            }
            if (stack.getItemDamage() > stack.getMaxDamage() * 0.5 && stack.getItemDamage() < stack.getMaxDamage() * 0.6){
                WeaponNBT.setSharpnessLevel(stack, 4);
            }
            if (stack.getItemDamage() > stack.getMaxDamage() * 0.6 && stack.getItemDamage() < stack.getMaxDamage() * 0.7){
                WeaponNBT.setSharpnessLevel(stack, 3);
            }
            if (stack.getItemDamage() > stack.getMaxDamage() * 0.7 && stack.getItemDamage() < stack.getMaxDamage() * 0.8){
                WeaponNBT.setSharpnessLevel(stack, 2);
            }
            if (stack.getItemDamage() > stack.getMaxDamage() * 0.8 && stack.getItemDamage() < stack.getMaxDamage() * 0.9){
                WeaponNBT.setSharpnessLevel(stack, 1);
            }
            if (stack.getItemDamage() > stack.getMaxDamage() * 0.9 && stack.getItemDamage() < stack.getMaxDamage()){
                WeaponNBT.setSharpnessLevel(stack, 0);
            }
        }
    }

}
