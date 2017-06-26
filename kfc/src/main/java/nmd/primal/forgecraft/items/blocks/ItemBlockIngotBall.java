package nmd.primal.forgecraft.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.enumhandler.EnumHandler;

import java.util.List;

//import static nmd.primal.forgecraft.enumhandler.EnumHandler.IngotTypes.*;

/**
 * Created by mminaie on 2/12/17.
 */
public class ItemBlockIngotBall extends ItemBlock {

    public ItemBlockIngotBall(Block block){
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
        //this.setRegistryName(name);
    }

    public int getMetadata(int damage)
    {
        return damage;
    }


    public String getUnlocalizedNameInefficiently(ItemStack stack) {
        EnumHandler.IngotTypes v = EnumHandler.IngotTypes.values()[stack.getItemDamage()];
        //EnumOreType z = EnumOreType.values()[stack.getItemDamage()];
        switch(v) {
            case IRONCOOL:
            case IRONHOT:

                return "item.forgecraft:"+v.name;
            default:
                return "item.forgecraft:unknown";
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        subItems.add(new ItemStack(itemIn, 1, EnumHandler.IngotTypes.IRONCOOL.meta));
        subItems.add(new ItemStack(itemIn, 1, EnumHandler.IngotTypes.IRONHOT.meta));

    }

}
