package nmd.primal.forgecraft.init;

import net.minecraftforge.common.config.Config;
import nmd.primal.forgecraft.ForgeCraft;
import nmd.primal.forgecraft.ModInfo;

@Config(modid = ModInfo.MOD_ID, name = ModInfo.MOD_CONFIG, category = "")
@Config.LangKey("forgecraft.config.title")
@SuppressWarnings("unused")
public class ModConfig
{
    static {
        ForgeCraft.LOGGER.info("Loading Config File: " + ModInfo.MOD_CONFIG + ".cfg");
    }

    /**
     *  Main Config Sections
     */
    public static Compatibility compatibility;
    public static ModConfig.Features features;

    /**
     *  Options related to compatibility with mods and vanilla features
     */
    public static class Compatibility
    {
        @Config.Comment({"Ore Dictionary Wootz steel for compatibility with common mod steel"})
        public static boolean COMPAT_DICTIONARY_WOOTZ_STEEL;
    }

    /**
     *  Customize main features of the mod
     */
    public static class Features
    {
        @Config.Comment({"Smoke is produced from various forge blocks when active"})
        public static boolean FEATURE_ENABLE_SMOKE = true;

        @Config.RequiresMcRestart
        @Config.Comment({"Various forge blocks will set fire to their surroundings when active"})
        public static boolean FEATURE_ENABLE_FIRE = true;

        @Config.Comment({"Sample config for a numeric range"})
        @Config.RangeInt(min = 0, max = 1000)
        public static int FEATURE_HEAT_RANGE = 0;
    }
}