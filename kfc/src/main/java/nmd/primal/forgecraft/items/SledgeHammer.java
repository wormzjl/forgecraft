package nmd.primal.forgecraft.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.items.tools.Gallagher;
import nmd.primal.core.common.recipes.irecipe.ToolCraftingRecipe;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.blocks.Anvil.AnvilBase;
import nmd.primal.forgecraft.blocks.Chisel;
import nmd.primal.forgecraft.util.ToolMaterialMap;

import javax.annotation.Nullable;
import java.util.List;

public class SledgeHammer extends Gallagher implements ToolMaterialMap {

    private int attack;
    private double speed;
    private ToolMaterial material;

    public SledgeHammer(String name, Item.ToolMaterial material, Integer attack, Double speed) {
        super(material, ToolCraftingRecipe.EnumToolType.MALLET_METAL);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setMaxDamage(material.getMaxUses()*3);
        this.setHarvestLevel("pickaxe" ,  material.getHarvestLevel());
        this.material=material;
        this.attack = attack;
        this.speed = speed;
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
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
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing face, float hitx, float hity, float hitz)
    {
        if(!world.isRemote) {
            IBlockState state = world.getBlockState(pos);
            Block block = world.getBlockState(pos).getBlock();
            if(!(block instanceof AnvilBase)) {
                if (!player.isSwingInProgress) {
                    int tempInt = 0;
                    player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, (100 - ((materialModifiers.get(this.getMaterial()) * 13) + tempInt)), 100));
                    player.swingArm(hand);
                    return EnumActionResult.PASS;
                }
            }
        }
        return EnumActionResult.PASS;
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

}
