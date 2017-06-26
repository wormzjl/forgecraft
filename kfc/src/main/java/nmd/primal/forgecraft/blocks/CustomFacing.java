package nmd.primal.forgecraft.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

/**
 * Created by mminaie on 1/1/17.
 */
public abstract class CustomFacing extends Block {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    protected CustomFacing(Material material)
    {
        super(material);
    }

    protected CustomFacing(Material material, MapColor color)
    {
        super(material, color);
    }
}
