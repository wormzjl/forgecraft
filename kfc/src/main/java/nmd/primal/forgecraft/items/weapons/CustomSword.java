package nmd.primal.forgecraft.items.weapons;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.util.WeaponNBT;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by mminaie on 3/23/17.
 */
public class CustomSword extends ItemSword implements WeaponNBT {

    private double attack, speed;
    private ToolMaterial toolMaterial;
    public CustomSword(String name, ToolMaterial material, double attackDamage, double attackSpeed) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        this.setMaxStackSize(1);
        this.setNoRepair();
        this.attack = attackDamage;
        this.speed = attackSpeed;
        this.toolMaterial= material;
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

    public int getItemEnchantability(ItemStack stack)
    {
        return 0;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity playerin, int itemSlot, boolean isSelected) {
        if(!world.isRemote){
            if(isSelected) {
                if(!stack.hasTagCompound()) {
                    WeaponNBT.setDefaultNBT(stack);
                }
                if(stack.hasTagCompound()) {
                    if (stack.getItemDamage() < stack.getMaxDamage() * 0.5) {
                        WeaponNBT.setSharpnessLevel(stack, 5);
                        //System.out.println("Sharpness = 5");
                    }
                    if (stack.getItemDamage() > stack.getMaxDamage() * 0.5 && stack.getItemDamage() < stack.getMaxDamage() * 0.6) {
                        WeaponNBT.setSharpnessLevel(stack, 4);
                        //System.out.println("Sharpness = 4");
                    }
                    if (stack.getItemDamage() > stack.getMaxDamage() * 0.6 && stack.getItemDamage() < stack.getMaxDamage() * 0.7) {
                        WeaponNBT.setSharpnessLevel(stack, 3);
                        //System.out.println("Sharpness = 3");
                    }
                    if (stack.getItemDamage() > stack.getMaxDamage() * 0.7 && stack.getItemDamage() < stack.getMaxDamage() * 0.8) {
                        WeaponNBT.setSharpnessLevel(stack, 2);
                        //System.out.println("Sharpness = 2");
                    }
                    if (stack.getItemDamage() > stack.getMaxDamage() * 0.8 && stack.getItemDamage() < stack.getMaxDamage() * 0.9) {
                        WeaponNBT.setSharpnessLevel(stack, 1);
                        //System.out.println("Sharpness = 1");
                    }
                    if (stack.getItemDamage() > stack.getMaxDamage() * 0.9 && stack.getItemDamage() < stack.getMaxDamage()) {
                        WeaponNBT.setSharpnessLevel(stack, 0);
                        //System.out.println("Sharpness = 0");
                    }
                }
                //System.out.println(WeaponNBT.getSharpnessLevel(stack));
            }
        }
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        if(!player.world.isRemote) {
            WeaponNBT.removeAndSetEnchantsForStack(stack);
            return false;
        }
        return false;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player)
    {
        if(!player.world.isRemote) {
            System.out.println(WeaponNBT.getSharpnessLevel(stack));
            WeaponNBT.removeAndSetEnchantsForStack(stack);
            return false;
        }
        return false;
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap =  HashMultimap.<String, AttributeModifier>create();

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attack, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.speed, 0));

        }

        return multimap;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add(ChatFormatting.LIGHT_PURPLE + "Damage: " + stack.getItemDamage() );
        if(stack.hasTagCompound())
        {
            tooltip.add(ChatFormatting.GRAY + "Upgrades left: " + (WeaponNBT.materialModifiers.get(this.toolMaterial) - WeaponNBT.getModifiers(stack)));
            if (WeaponNBT.getSmiteLevel(stack) > 0) {
                tooltip.add(ChatFormatting.GOLD + "Holy: " + WeaponNBT.getSmiteLevel(stack));
            }
            if (WeaponNBT.getBaneLevel(stack) > 0) {
                tooltip.add(ChatFormatting.GREEN + "Spider Killing: " + WeaponNBT.getBaneLevel(stack));
            }
            if (WeaponNBT.getFireLevel(stack) > 0) {
                tooltip.add(ChatFormatting.RED + "Flame: " + WeaponNBT.getFireLevel(stack));
            }
            if (WeaponNBT.getFortuneLevel(stack) > 0) {
                tooltip.add(ChatFormatting.BLUE + "Thieving: " + WeaponNBT.getFortuneLevel(stack));
            }
            if (WeaponNBT.getLeechLevel(stack) > 0) {
                tooltip.add(ChatFormatting.BLACK + "Life Steal: " + WeaponNBT.getLeechLevel(stack));
            }
        }
    }

}
