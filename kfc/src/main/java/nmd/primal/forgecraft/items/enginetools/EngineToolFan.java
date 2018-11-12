package nmd.primal.forgecraft.items.enginetools;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EngineToolFan extends BaseEngineTool {

    public EngineToolFan(String registryName, ToolMaterial toolMaterial) {
        super(registryName, toolMaterial);
    }

    public void doWork(World world, BlockPos pos, IBlockState state, EnumFacing facing){

    }

}
