package nmd.primal.forgecraft.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.ModInfo;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;

/**
 * Created by kitsu on 12/3/2016.
 */

@GameRegistry.ObjectHolder(ModInfo.MOD_ID)
@Mod.EventBusSubscriber
public class ModRegistries {

    @SubscribeEvent
    public static void customRegistries(RegistryEvent.NewRegistry event) {
        PrimalAPI.logger(1, "Custom Registry", CrucibleCrafting.RECIPE_PREFIX);
        RegistryBuilder registryCrucible = new RegistryBuilder();
        registryCrucible.setType(CrucibleCrafting.class);
        registryCrucible.setName(new ResourceLocation(ModInfo.MOD_ID, "recipes_" + CrucibleCrafting.RECIPE_PREFIX));
        registryCrucible.setIDRange(0, 1000);
        registryCrucible.create();
    }
}
