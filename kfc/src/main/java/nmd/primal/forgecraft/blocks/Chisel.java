package nmd.primal.forgecraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.common.helper.PlayerHelper;
import nmd.primal.forgecraft.items.SledgeHammer;

public class Chisel extends BlockCustomBase {



    public Chisel(Material material, String registryName, Float hardness) {
        super(material, registryName, hardness);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz) {

        if(!world.isRemote){
            ItemStack playerStack = player.inventory.getCurrentItem();
            if (hand.equals(hand.MAIN_HAND)) {
                if(!player.isSwingInProgress) {
                    if (playerStack.getItem() instanceof SledgeHammer) {
                        for (int i = 0; i < 3; i++) {
                            for (int a = 0; a < 3; a++) {
                                if (facing == EnumFacing.UP) {
                                    IBlockState breakState = world.getBlockState(pos.add((a - 1), (-1), (i - 1)));
                                    BlockPos breakPos = pos.add((a - 1), (-1), (i - 1));
                                    //System.out.println(i + ":" + a + ":" + breakState.getBlock());
                                    if (!(breakState.getBlock().equals(Blocks.AIR))) {
                                        NonNullList<ItemStack> tempDrops = NonNullList.create();
                                        world.getBlockState(breakPos).getBlock().getDrops(tempDrops, world, breakPos, breakState, 0);
                                        PlayerHelper.spawnItemOnPlayer(world, player, tempDrops);
                                        //System.out.println(tempDrops);
                                        world.setBlockToAir(breakPos);
                                    }
                                }
                            }
                        }
                        world.setBlockState(pos.down(), state);
                        world.setBlockToAir(pos);
                        //player.swingArm(hand);
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
