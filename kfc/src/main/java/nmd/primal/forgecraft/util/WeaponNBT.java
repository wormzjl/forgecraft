package nmd.primal.forgecraft.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreIngredient;
import nmd.primal.core.api.PrimalAPI;

import java.util.Hashtable;

/**
 * Created by mminaie on 3/17/17.
 */
public interface WeaponNBT {

    /***
     * smite
     * bane
     * fire
     * fortune
     * leech
     * sweeping
     * sharpness
     ***/

    /***
     *
     * @param stack The ItemStack to get Modifiers from
     * @return int The number of modifiers applied
     */
    default int getModifiers(ItemStack stack) {
        if(!stack.isEmpty()) {
            if (stack.hasTagCompound()) {
                if (stack.getSubCompound("tags") != null) {
                    return stack.getSubCompound("tags").getInteger("modifiers");
                }
            }
        }
        return 0;
    }

    /***
     *
     * @param stack The stack to set modifiers to
     * @param mods The number of modifiers added
     */
    default void setModifiers(ItemStack stack, Integer mods){
        stack.getSubCompound("tags").setInteger("modifiers", mods);
    }

    default int getSmiteLevel(ItemStack stack){
        if(!stack.isEmpty()) {
            if (stack.hasTagCompound()) {
                if (stack.getSubCompound("tags") != null) {
                    return stack.getSubCompound("tags").getInteger("smite");
                }
            }
        }
        return 0;
    }
    default void setSmiteLevel(ItemStack stack, int smite){
        stack.getSubCompound("tags").setInteger("smite", smite);
    }

    default int getBaneLevel(ItemStack stack) {
        if(!stack.isEmpty()) {
            if (stack.hasTagCompound()) {
                if (stack.getSubCompound("tags") != null) {
                    return stack.getSubCompound("tags").getInteger("bane");
                }
            }
        }
        return 0;
    }
    default void setBaneLevel(ItemStack stack, Integer level){
        stack.getSubCompound("tags").setInteger("bane", level);
    }

    default int getFireLevel(ItemStack stack) {
        if(!stack.isEmpty()) {
            if (stack.hasTagCompound()) {
                if (stack.getSubCompound("tags") != null) {
                    return stack.getSubCompound("tags").getInteger("fire");
                }
            }
        }
        return 0;
    }
    default void setFireLevel(ItemStack stack, Integer level){
        stack.getSubCompound("tags").setInteger("fire", level);
    }

    default int getFortuneLevel(ItemStack stack) {
        if(!stack.isEmpty()) {
            if (stack.hasTagCompound()) {
                if (stack.getSubCompound("tags") != null) {
                    return stack.getSubCompound("tags").getInteger("fortune");
                }
            }
        }
        return 0;
    }
    default void setFortuneLevel(ItemStack stack, Integer level){
        stack.getSubCompound("tags").setInteger("fortune", level);
    }

    default int getSweepingLevel(ItemStack stack) {
        if(!stack.isEmpty()) {
            if (stack.hasTagCompound()) {
                if (stack.getSubCompound("tags") != null) {
                    return stack.getSubCompound("tags").getInteger("sweeping");
                }
            }
        }
        return 0;
    }
    default void setSweepingLevel(ItemStack stack, Integer level){
        stack.getSubCompound("tags").setInteger("sweeping", level);
    }

    default int getSharpnessLevel(ItemStack stack) {
        if(!stack.isEmpty()) {
            if (stack.hasTagCompound()) {
                if (stack.getSubCompound("tags") != null) {
                    return stack.getSubCompound("tags").getInteger("sharp");
                }
            }
        }
        return 0;
    }
    default void setSharpnessLevel(ItemStack stack, Integer level){
        stack.getSubCompound("tags").setInteger("sharp", level);
    }

    default int getLeechLevel(ItemStack stack) {
        if(!stack.isEmpty()) {
            if (stack.hasTagCompound()) {
                if (stack.getSubCompound("tags") != null) {
                    return stack.getSubCompound("tags").getInteger("leech");
                }
            }
        }
        return 0;
    }
    default void setLeechLevel(ItemStack stack, Integer level){
        stack.getSubCompound("tags").setInteger("leech", level);
    }

    default NBTTagCompound getTags(ItemStack stack){
        if(!stack.isEmpty()) {
            if (stack.hasTagCompound()) {
                if (stack.getSubCompound("tags") != null) {
                    return stack.getSubCompound("tags");
                }
            }
        }
        return null;
    }

    default boolean getHot(ItemStack stack){

        if(!stack.isEmpty()){
            if(stack.hasTagCompound()){
                if(stack.getSubCompound("tags") !=null){
                    return stack.getSubCompound("tags").getBoolean("hot");
                }
            }
        }

        return false;
    }

    default void setHot(ItemStack stack){

    }

    static void setDefaultNBT(ItemStack stack) {

        stack.getOrCreateSubCompound("tags");
        stack.getSubCompound("tags").setInteger("smite", 0);
        stack.getSubCompound("tags").setInteger("bane", 0);
        stack.getSubCompound("tags").setInteger("fire", 0);
        stack.getSubCompound("tags").setInteger("fortune", 0);
        stack.getSubCompound("tags").setInteger("leech", 0);
        stack.getSubCompound("tags").setInteger("sweeping", 0);
        stack.getSubCompound("tags").setInteger("sharpness", 0);
        stack.getSubCompound("tags").setInteger("modifiers", 0);
        stack.getSubCompound("tags").setBoolean("hot", false);
    }

    Hashtable<Item.ToolMaterial, Integer> materialModifiers = new Hashtable<Item.ToolMaterial, Integer>(){{

        put(PrimalAPI.ToolMaterials.TOOL_COPPER, 3);
        put(PrimalAPI.ToolMaterials.TOOL_BRONZE, 3);
        put(PrimalAPI.ToolMaterials.TOOL_CRUDE_IRON, 4);
        put(PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, 5);
        put(PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, 7);
        put(PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL, 8);
        put(PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, 9);

    }};

    Hashtable<Ingredient, String> StackToUpgrade = new Hashtable<Ingredient, String>(){{

        put(new OreIngredient("dustSilver"), "bane");

    }};

}
