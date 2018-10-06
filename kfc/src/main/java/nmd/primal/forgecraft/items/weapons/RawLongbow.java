package nmd.primal.forgecraft.items.weapons;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.items.BaseItem;

import javax.annotation.Nullable;
import java.util.List;

public class RawLongbow extends BaseItem {

    public RawLongbow(String registryName) {
        super(registryName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        tooltip.add(ChatFormatting.GRAY + "Stack two Yew Staves in-world and Sneak right-click the bottom Yew Stave with a Work Blade");

    }

}
