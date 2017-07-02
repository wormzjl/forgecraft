package nmd.primal.forgecraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.core.common.items.tools.WorkBlade;
import nmd.primal.core.common.helper.CommonUtils;
import nmd.primal.forgecraft.init.ModItems;

/**
 * Created by mminaie on 7/2/17.
 */
public class YewStave extends BlockCustomBase {

    public AxisAlignedBB AABBSTAVE = new AxisAlignedBB(13/32D, 0.0D, 13/32/16D, 19/32D, 1.0D, 19/32D);

    public YewStave(Material material, String registryName, Float hardness) {
        super(material, registryName, hardness);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return AABBSTAVE;
    }



    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz) {
        if (world.isRemote)
            return true;

        ItemStack pItem = player.getActiveItemStack();

        if(pItem.getItem() instanceof WorkBlade){
            if(world.getBlockState(pos.up()).getBlock() instanceof YewStave ) {
                //TODO play sound, swingArm
                if(CommonUtils.randomCheck(3) ) {
                    PlayerHelper.spawnItemOnGround(world, pos, new ItemStack(ModItems.unstrunglongbow, 1));
                    return true;
                }
            }
        }

        return false;
    }
}
