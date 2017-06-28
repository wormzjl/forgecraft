package nmd.primal.forgecraft.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nmd.primal.forgecraft.items.ItemTest;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ModItems {

    public static Item test;
    //public static Item cheese;

    public static void init() {

        //test = new ItemTest();
        //cheese = new ItemCheese();
    }

    public static void register() {

        //GameRegistry.register(test);
        //GameRegistry.register(cheese);
    }

    public static void registerRenders() {
        //registerRender(cheese);
        //registerRender(test);
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
