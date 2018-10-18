package nmd.primal.forgecraft.blocks.fluids;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import nmd.primal.core.common.fluids.AbstractFluidBlock;
import nmd.primal.forgecraft.ModInfo;

public class BasicFluidBlockKFC extends AbstractFluidBlock {


    private boolean isSolidTexture;
    private boolean isBurning;

    public BasicFluidBlockKFC(Fluid fluid, Material material, boolean isSolidTexture, boolean isBurning)
    {
        super(fluid, material);
        this.isSolidTexture = isSolidTexture;
        this.isBurning = isBurning;
    }

    public BasicFluidBlockKFC(Fluid fluid, Material material)
    {
        this(fluid, material, false, false);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
    }

}
