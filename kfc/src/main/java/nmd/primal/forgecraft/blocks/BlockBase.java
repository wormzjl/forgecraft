package nmd.primal.forgecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by mminaie on 2/6/17.
 */
public class BlockBase extends Block{

    public BlockBase(Material material, String registryName, Float hardness) {
        super(material);
        setUnlocalizedName(registryName);
        setRegistryName(registryName);
        setCreativeTab(ModInfo.TAB_FORGECRAFT);
        setHardness(hardness);
    }

}
