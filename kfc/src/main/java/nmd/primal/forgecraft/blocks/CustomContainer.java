package nmd.primal.forgecraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * Created by mminaie on 3/4/17.
 */
public abstract class CustomContainer extends BlockContainer{

    protected CustomContainer(Material material)
    {
        super(material);
    }

    protected CustomContainer(Material material, MapColor color)
    {
        super(material, color);
    }

}
