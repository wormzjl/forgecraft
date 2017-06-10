package nmd.primal.forgecraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nmd.primal.forgecraft.init.ModItems;
//import nmd.primal.forgecraft.Item.ModItems;

/**
 * Created by kitsu on 11/24/2016.
 */
public class ModInfo {
        /** Mod Details**/
    public static final String MOD_ID = "forgecraft";
    public static final String MOD_NAME = "Kitsu's ForgeCraft";
    //public static final String MOD_PREFIX = MOD_ID + ":";
    public static final String MOD_CHANNEL = MOD_ID;
    public static final String MOD_VERSION = "1.2.23";
    public static final String MC_VERSIONS = "[1.11.0, 1.12.0)";
    public static final String DEPENDENCIES = "required-after:forge@[13.20.0.2226,);" + "required-after:primal@[0.4,);";

    /** Mod Structures **/
    public static final String SERVER_PROXY = "nmd.primal.forgecraft.proxy.ServerProxy";
    public static final String CLIENT_PROXY = "nmd.primal.forgecraft.proxy.ClientProxy";
    //public static final String GUI_FACTORY  = "nmd.primal.forgecraft.gui.GuiFactory";
    //public static final String UPDATE_JSON  = "";

    public enum ForgecraftItems {
        TEST("test", "itemtest"),
        BELLOWSHANDLE("bellowshandle", "bellowshandle"),
        STONETONGS("stonetongs", "stonetongs"),
        SOFTCRUCIBLE("softcrucible", "softcrucible"),
        FORGINGMANUAL("forgingmanual","forgingmanual");

        private String unlocalizedName;
        private String registryName;

        ForgecraftItems(String unlocalizedName, String registryName) {
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }
        public String getRegistryName() {
            return registryName;
        }

    }

    public enum ForgecraftBlocks {
        FIREBOX("firebox", "firebox"),
        PISTONBELLOWS("pistonbellows", "pistonbellows"),
        BLOOMERY("bloomery", "bloomery"),
        EMPTYCRUCIBLE("emptycrucible", "emptycrucible");

        private String unlocalizedName;
        private String registryName;

        ForgecraftBlocks(String unlocalizedName, String registryName) {
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }
        public String getRegistryName() {
            return registryName;
        }

    }

    /** Creative Tabs **/
    public static CreativeTabs TAB_FORGECRAFT = new CreativeTabs(MOD_ID)
    {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.forgehammer);
        }
    };

    /*
        public static CreativeTabs TAB_PRIMAL = new CreativeTabs(MOD_ID)
    {

        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(PrimalItems.FLINT_HATCHET);
        }

    };
    */


}