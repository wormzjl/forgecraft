package nmd.primal.forgecraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

/**
 * Created by kitsu on 12/3/2016.
 */
public abstract class CustomContainerFacing extends BlockContainer {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    protected CustomContainerFacing(Material material, String registryName)
    {
        super(material);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(registryName);
        this.setHardness(3.0f);
        this.setResistance(4.0f);
    }

    protected CustomContainerFacing(Material material, MapColor color)
    {
        super(material, color);
    }
}
