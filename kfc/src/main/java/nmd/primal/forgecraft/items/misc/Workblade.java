package nmd.primal.forgecraft.items.misc;

import nmd.primal.core.common.items.tools.WorkBlade;
import nmd.primal.forgecraft.ModInfo;

public class Workblade extends WorkBlade {

    public Workblade(String name, ToolMaterial material, float speed) {
        super(material, speed);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(ModInfo.TAB_FORGECRAFT);
    }
}
