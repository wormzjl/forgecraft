package nmd.primal.forgecraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModCrafting;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.init.ModTiles;
import nmd.primal.forgecraft.proxy.CommonProxy;
//import nmd.primal.forgecraft.common.init.*;

import java.util.Locale;

@Mod(   modid = ModInfo.MOD_ID,
        name = ModInfo.MOD_NAME,
        version = ModInfo.MOD_VERSION,
        acceptedMinecraftVersions = ModInfo.MC_VERSIONS
        //dependencies = ModInfo.DEPENDENCIES,
        //guiFactory = ModInfo.GUI_FACTORY,
        //updateJSON = ModInfo.UPDATE_JSON
)
public class ForgeCraft
{
    @Instance
    public static ForgeCraft instance;

    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.SERVER_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModItems.init();
        ModBlocks.init();
        ModItems.register();
        ModBlocks.register();
        ModTiles.registerTileEntities();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        //this.proxy.init(event);
        proxy.init();
        ModCrafting.register();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //this.proxy.postInit(event);
    }

    /*@EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        //event.registerServerCommand(new PrimalCommand());
    }

    //public File getConfigDirectory()
    //{
    //    return CONFIG_DIRECTORY;
    //}
    */
}