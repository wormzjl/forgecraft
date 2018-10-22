package nmd.primal.forgecraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.common.items.tools.Gallagher;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.tiles.TileAnvil;
import nmd.primal.forgecraft.util.AnvilHandler;

/**
 * Created by mminaie on 6/10/17.
 */
public class AnvilIron extends AnvilBase implements AnvilHandler {

    public AnvilIron(Material material, String registryName, Float hardness, Boolean anvil) {
        super(material, registryName, hardness, anvil);

    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz) {

        /******************************************************************************
         Crafting AnvilStone Recipes
         *****************************************************************************/
        if (!world.isRemote) {
            ItemStack pItem = player.inventory.getCurrentItem();
            TileAnvil tile = (TileAnvil) world.getTileEntity(pos);
            ItemStack stack12 = tile.getSlotStack(12).copy();
            if (tile != null) {
                if ((pItem.getItem() instanceof Gallagher) || (pItem.getItem() == ModItems.forgehammer)) {
                    ItemStack[] tempArray = new ItemStack[25];
                    for (int i = 0; i < 25; i++) {
                        tempArray[i] = tile.getSlotStack(i);
                    }
                    /*for (int i = 0; i < 25; i++) {
                        if (tile.getSlotStack(i).getItem() instanceof BaseMultiItem) {
                            if (((BaseMultiItem) tile.getSlotStack(i).getItem()).getMaterial(tile.getSlotStack(i).getItem()) != PrimalMaterials.TOOL_BASIC_STEEL
                                    || ((BaseMultiItem) tile.getSlotStack(i).getItem()).getMaterial(tile.getSlotStack(i).getItem()) != PrimalMaterials.TOOL_CLEAN_IRON
                                    || ((BaseMultiItem) tile.getSlotStack(i).getItem()).getMaterial(tile.getSlotStack(i).getItem()) != PrimalMaterials.TOOL_WROUGHT_IRON
                                    ) {
                                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                                CommonUtils.spawnItemEntityFromWorld(world, pos, new ItemStack(PrimalItems.ROCK_STONE, 3));
                                CommonUtils.spawnItemEntityFromWorld(world, pos, new ItemStack(ModBlocks.ironball, 1));
                                this.breakBlock(world, pos, state);
                            }
                        }
                    }*/
                    doAnvilRecipe(pItem, stack12, tempArray, world, tile, pos, player);
                    return true;
                }
                doAnvilInventoryManager(pItem, world, tile, pos, hitx, hity, hitz, state, player);
                return true;
            }
        }
        return false;
    }
}
