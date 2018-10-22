package nmd.primal.forgecraft.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.init.ModTileRenders;
import nmd.primal.forgecraft.models.ModelPlateHelmet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kitsu on 11/26/2016.
 */
public class ClientProxy implements CommonProxy {

    public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

    @Override
    public void preInit(){
        //ModItems.registerCustomRenders();
    }

    @Override
    public void init() {
        //OBJLoader.INSTANCE.addDomain(ModInfo.MOD_ID);
        //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ModItems.stonetongs, 0, new ModelResourceLocation("stonetongs", "inventory"));
        ModItems.registerRenders();
        ModBlocks.registerRenders();
        //this.registerModelBakeryStuff();
        this.registerTileRendering();
        this.registerModels();
    }

    //@Override
    public void registerTileRendering()
    {
        ModTileRenders.init();
    }

    public void registerModels(){

        ModelPlateHelmet custom_armor = new ModelPlateHelmet(1.0f);

        armorModels.put(ModItems.leatherhelmet, custom_armor);
    }

    @Override
    public void registerModelBakeryVariants(){
        //ModelBakery.registerItemVariants(ModItems.stonetongs, new ResourceLocation(ModInfo.MOD_ID, "stonetongs_default"),
        //        new ResourceLocation(ModInfo.MOD_ID, "stonetongs_emptyhot"));
    }



}
