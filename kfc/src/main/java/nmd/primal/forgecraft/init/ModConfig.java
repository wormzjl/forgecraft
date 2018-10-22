package nmd.primal.forgecraft.init;

import net.minecraftforge.common.config.Config;
import nmd.primal.forgecraft.ModInfo;

@Config(modid = ModInfo.MOD_ID, name = ModInfo.MOD_CONFIG, category = "")
@Config.LangKey("forgecraft.config.title")


public final class ModConfig
{
    //static {
    //    ForgeCraft.LOGGER.info("Loading Config File: " + ModInfo.MOD_CONFIG + ".cfg");
    //}

    /**
     *  Main Config Sections
     */
    public static Compatibility compatibility;
    public static Features features;

    /**
     *  Options related to compatibility with mods and vanilla features
     */
    public static class Compatibility
    {
        @Config.Comment({"Ore Dictionary Wrought Iron to common Iron"})
        public static boolean COMPAT_DICTIONARY_WROUGHT_IRON = true;

        //@Config.Comment({"Ore Dictionary Damascus Steel to common Steel"})
        //public static boolean COMPAT_DICTIONARY_DAMASCUS_STEEL = true;
    }

    /**
     *  Customize main features of the mod
     */

    public static class Features
    {
//        @Config.RequiresMcRestart
//        @Config.Comment({"Config to allow or dissallow Copper Tools"})
//        public static boolean ENABLE_COPPER_TOOLS = false;

    }
}



























