package nmd.primal.forgecraft.blocks.Anvil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.core.common.items.tools.Gallagher;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.tiles.TileAnvil;

/**
 * Created by mminaie on 3/4/17.
 */
public class AnvilStone extends AnvilBase {

    public AnvilStone(Material material, String registryName, Float hardness, Boolean anvil) {
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

            ItemStack tempironball = new ItemStack(ModItems.ironingotball, 1);
            tempironball.getTagCompound().setBoolean("hot", true);
            ItemStack tempironcleanball = new ItemStack(ModItems.ironcleaningotball, 1);
            tempironcleanball.getTagCompound().setBoolean("hot", true);
            ItemStack tempsteelball = new ItemStack(ModItems.steelingotball, 1);
            tempsteelball.getTagCompound().setBoolean("hot", true);
            ItemStack tempwootzball = new ItemStack(ModItems.wootzingotball, 1);
            tempwootzball.getTagCompound().setBoolean("hot", true);

            ItemStack tempironchunk = new ItemStack(ModItems.ironchunk, 1);
            tempironchunk.getTagCompound().setBoolean("hot", true);
            ItemStack tempironcleanchunk = new ItemStack(ModItems.ironcleanchunk, 1);
            tempironcleanchunk.getTagCompound().setBoolean("hot", true);
            ItemStack tempsteelchunk = new ItemStack(ModItems.steelchunk, 1);
            tempsteelchunk.getTagCompound().setBoolean("hot", true);
            ItemStack tempwootzchunk = new ItemStack(ModItems.wootzchunk, 1);
            tempwootzchunk.getTagCompound().setBoolean("hot", true);



            if (tile != null) {
                if ((pItem.getItem() instanceof Gallagher) || (pItem.getItem() == ModItems.forgehammer)) {
                    if(tile.getSlotStack(12).getItem().equals(tempironball) ){
                        tile.setSlotStack(6, tempironchunk);
                        tile.setSlotStack(7, tempironchunk);
                        tile.setSlotStack(8, tempironchunk);
                        tile.setSlotStack(11, tempironchunk);
                        tile.setSlotStack(12, tempironchunk);
                        tile.setSlotStack(13, tempironchunk);
                        tile.setSlotStack(16, tempironchunk);
                        tile.setSlotStack(17, tempironchunk);
                        tile.setSlotStack(18, tempironchunk);
                        world.playEvent(1031, pos, 0);
                    }
                    if(tile.getSlotStack(12).getItem().equals(tempironcleanball) ){
                        tile.setSlotStack(6, tempironcleanchunk);
                        tile.setSlotStack(7, tempironcleanchunk);
                        tile.setSlotStack(8, tempironcleanchunk);
                        tile.setSlotStack(11, tempironcleanchunk);
                        tile.setSlotStack(12, tempironcleanchunk);
                        tile.setSlotStack(13, tempironcleanchunk);
                        tile.setSlotStack(16, tempironcleanchunk);
                        tile.setSlotStack(17, tempironcleanchunk);
                        tile.setSlotStack(18, tempironcleanchunk);
                        world.playEvent(1031, pos, 0);
                    }
                    if(tile.getSlotStack(12).getItem().equals(tempsteelball) ){
                        tile.setSlotStack(6, tempsteelchunk);
                        tile.setSlotStack(7, tempsteelchunk);
                        tile.setSlotStack(8, tempsteelchunk);
                        tile.setSlotStack(11, tempsteelchunk);
                        tile.setSlotStack(12, tempsteelchunk);
                        tile.setSlotStack(13, tempsteelchunk);
                        tile.setSlotStack(16, tempsteelchunk);
                        tile.setSlotStack(17, tempsteelchunk);
                        tile.setSlotStack(18, tempsteelchunk);
                    }
                    if(tile.getSlotStack(12).getItem().equals(tempwootzball) ){
                            tile.setSlotStack(6, tempwootzchunk);
                            tile.setSlotStack(7, tempwootzchunk);
                            tile.setSlotStack(8, tempwootzchunk);
                            tile.setSlotStack(11, tempwootzchunk);
                            tile.setSlotStack(12, tempwootzchunk);
                            tile.setSlotStack(13, tempwootzchunk);
                            tile.setSlotStack(16, tempwootzchunk);
                            tile.setSlotStack(17, tempwootzchunk);
                            tile.setSlotStack(18, tempwootzchunk);
                    }
                }
                if ((pItem.getItem() instanceof Gallagher) || (pItem.getItem() == ModItems.forgehammer)) {
                    String[] tempArray = new String[25];
                    for (int i = 0; i < 25; i++) {
                        tempArray[i] = tile.getSlotStack(i).getItem().getRegistryName().toString();
                    }
                    /*for (int i = 0; i < 25; i++) {
                        if (tile.getSlotStack(i).getItem() instanceof BaseMultiItem) {
                            if (((BaseMultiItem) tile.getSlotStack(i).getItem()).getMaterial(tile.getSlotStack(i).getItem()) != PrimalMaterials.TOOL_WROUGHT_IRON) {
                                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                                CommonUtils.spawnItemEntityFromWorld(world, pos, new ItemStack(PrimalItems.ROCK_STONE, 3));
                                CommonUtils.spawnItemEntityFromWorld(world, pos, new ItemStack(ModBlocks.ironball, 1));
                                this.breakBlock(world, pos, state);
                                return true;
                            }
                        }
                    }*/
                    doAnvilRecipe(pItem, tempArray, world, tile, pos, player);
                    return true;
                }
                doAnvilInventoryManager(pItem, world, tile, pos, hitx, hity, hitz, state, player);
                return true;
            }
        }
        return false;
    }
}
