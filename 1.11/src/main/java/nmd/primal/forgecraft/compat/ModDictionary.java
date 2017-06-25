package nmd.primal.forgecraft.compat;

import net.minecraftforge.oredict.OreDictionary;
import nmd.primal.forgecraft.init.ModBlocks;

/**
 * Created by mminaie on 2/7/17.
 */
public class ModDictionary {/*******************************************************************************
 *  Register Only Vanilla OreDictionary Entries Here
 *    Mod Items/Blocks have their names added through the respective
 *    registration methods as a list of comma delineated strings.
 *
 *    EXAMPLE:
 *      LEATHER_CORDAGE = registerItem(new PrimalItem("leather_cordage"), "cordageGeneral, cordageLeather");
 *
 */
        public static void registerDictionaryNames()
        {
            //if (ModConfig.COMPATIBILITY_DICTIONARY_MAGMACREAM_AS_SLIME)
                //OreDictionary.registerOre("clayball", Items.CLAY_BALL);
                OreDictionary.registerOre("ingotIron", ModBlocks.ironball);
                OreDictionary.registerOre("nuggetIron", ModBlocks.ironchunk);
                OreDictionary.registerOre("ingotIron", ModBlocks.ironcleanball);
                OreDictionary.registerOre("nuggetIron", ModBlocks.ironcleanchunk);
                OreDictionary.registerOre("ingotSteel", ModBlocks.steelball);
                OreDictionary.registerOre("nuggetSteel", ModBlocks.steelchunk);



        }
}