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
public abstract class DefaultItemBlock extends ItemBlock {

    public DefaultItemBlock(String name, Block block) {
        super(block);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);

    }
}
