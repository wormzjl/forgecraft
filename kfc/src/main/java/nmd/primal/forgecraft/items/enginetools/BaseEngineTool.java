package nmd.primal.forgecraft.items.enginetools;

import nmd.primal.forgecraft.items.BaseSingleItem;

public class BaseEngineTool extends BaseSingleItem {

    private ToolMaterial toolMaterial;

    public BaseEngineTool(String registryName, int damage) {
        super(registryName, damage);
    }
    public BaseEngineTool(String registryName, ToolMaterial toolMaterial) {
        super(registryName, toolMaterial.getMaxUses()*2);
        this.toolMaterial = toolMaterial;

    }

    public ToolMaterial getMaterial() {return toolMaterial;}

}
