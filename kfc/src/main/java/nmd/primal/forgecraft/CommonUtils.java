package nmd.primal.forgecraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by kitsu on 11/23/2016.
 */
public class CommonUtils {

    public static void print(Object object){
        System.out.println(object);
    }

    public static int getVanillaItemBurnTime(ItemStack stack)
    {
        if (stack == null)
        {
            return 0;
        }
        Item item = stack.getItem();

        if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
        {
            Block block = Block.getBlockFromItem(item);
            if (block == Blocks.WOODEN_SLAB) return 150;
            if (block.getDefaultState().getMaterial() == Material.WOOD) return 300;
            if (block == Blocks.COAL_BLOCK) return 16000;
        }

        //if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
        //if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
        //if (item instanceof ItemHoe && ((ItemHoe)item).getMaterialName().equals("WOOD")) return 200;
        if(item == Items.STICK) return 100;
        if(item == Items.COAL) return 1600;
        if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
        if (item == Items.BLAZE_ROD) return 2400;
        if (item == Items.BLAZE_POWDER) return 800;
        return GameRegistry.getFuelValue(stack);
    }

    public static void spawnItemEntity(World world, EntityPlayer player, ItemStack stack)
    {
        EntityItem entityitem = new EntityItem(world, player.posX, player.posY, player.posZ, stack); // player.posY - 1.0D
        world.spawnEntity(entityitem);

        if (!(player instanceof FakePlayer))
            entityitem.onCollideWithPlayer(player);
    }

    public static void spawnItemEntityFromWorld(World world, BlockPos pos, ItemStack stack){
        EntityItem entityitem = new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), stack); // player.posY - 1.0D
        world.spawnEntity(entityitem);
    }




}
