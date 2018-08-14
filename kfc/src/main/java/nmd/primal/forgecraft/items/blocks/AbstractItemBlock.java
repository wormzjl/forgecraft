package nmd.primal.forgecraft.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nmd.primal.forgecraft.ModInfo;


/**
 * Created by mminaie on 2/7/18.
 */
public class AbstractItemBlock extends ItemBlock {
    private boolean is_fire_proof;

    public AbstractItemBlock(Block block, boolean sub_types) {
        super(block);
        this.setHasSubtypes(sub_types);
    }

    public AbstractItemBlock(Block block) {
        this(block, false);
    }

    @Override
    public CreativeTabs getCreativeTab() {
        return ModInfo.TAB_FORGECRAFT;
    }

    /**
     * Retrieves the normal 'lifespan' of this item when it is dropped on the ground as amount EntityItem.
     * This is in ticks, standard result is 6000, or 5 mins.
     *
     * @param itemStack The current ItemStack
     * @param world     The world the entity is in
     * @return The normal lifespan in ticks.
     */
    @Override
    public int getEntityLifespan(ItemStack itemStack, World world) {
        return 6000;
    }
}
