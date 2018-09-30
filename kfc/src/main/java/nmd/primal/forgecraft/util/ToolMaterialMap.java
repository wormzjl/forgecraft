package nmd.primal.forgecraft.util;

import net.minecraft.item.Item;
import nmd.primal.core.api.PrimalAPI;

import java.util.Hashtable;


/**
 * Created by mminaie on 3/29/17.
 */
public interface ToolMaterialMap {


     Hashtable<Item.ToolMaterial, Integer> materialModifiers = new Hashtable<Item.ToolMaterial, Integer>(){{

        put(PrimalAPI.ToolMaterials.TOOL_COPPER, 1);
        put(PrimalAPI.ToolMaterials.TOOL_BRONZE, 1);
        put(PrimalAPI.ToolMaterials.TOOL_CRUDE_IRON, 1);
        put(PrimalAPI.ToolMaterials.TOOL_WROUGHT_IRON, 2);
        put(PrimalAPI.ToolMaterials.TOOL_CLEAN_IRON, 3);
        put(PrimalAPI.ToolMaterials.TOOL_BASIC_STEEL, 4);
        put(PrimalAPI.ToolMaterials.TOOL_WOOTZ_STEEL, 5);

    }};



}
