package nmd.primal.forgecraft.init;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.init.Items;

import static nmd.primal.forgecraft.init.ModConfig.Compatibility.COMPAT_DICTIONARY_WROUGHT_IRON;

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
            OreDictionary.registerOre("ingotBronze", ModItems.bronzeingotball);
            OreDictionary.registerOre("nuggetBronze", ModItems.bronzechunk);
            if(COMPAT_DICTIONARY_WROUGHT_IRON) {
                OreDictionary.registerOre("ingotIron", ModItems.ironingotball);
                OreDictionary.registerOre("nuggetIron", ModItems.wroughtironchunk);
            }
            OreDictionary.registerOre("ingotIron", ModItems.ironcleaningotball);
            OreDictionary.registerOre("nuggetIron", ModItems.ironcleanchunk);
            OreDictionary.registerOre("ingotSteel", ModItems.steelingotball);
            OreDictionary.registerOre("nuggetSteel", ModItems.steelchunk);
            OreDictionary.registerOre("ingotBronze", ModItems.bronzeingotball);
            OreDictionary.registerOre("nuggetBronze", ModItems.bronzechunk);
            //if(COMPAT_DICTIONARY_DAMASCUS_STEEL) {
            OreDictionary.registerOre("ingotWootz", ModItems.wootzingotball);
            OreDictionary.registerOre("nuggetWootz", ModItems.wootzchunk);
            //}
            OreDictionary.registerOre("dustBlaze", Items.BLAZE_POWDER);
            OreDictionary.registerOre("weaponHandle", ModItems.bonehandle);
            OreDictionary.registerOre("weaponGuard", ModItems.boneguard);
        }
}