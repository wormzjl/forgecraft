package nmd.primal.forgecraft.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import nmd.primal.forgecraft.ModInfo;

/**
 * Created by mminaie on 3/24/17.
 */
public class ModSounds {

    public static SoundEvent PISTON_BELLOWS;
    public static SoundEvent MUSKET_SHOT;

    public static void registerSounds()
    {
        PISTON_BELLOWS = registerSound("piston_bellows");
        MUSKET_SHOT = registerSound("musket_shot");
    }

    private static SoundEvent registerSound(String name)
    {
        ResourceLocation location = new ResourceLocation(ModInfo.MOD_ID, name);
        SoundEvent sound = new SoundEvent(location);
        sound.setRegistryName(location);
        ForgeRegistries.SOUND_EVENTS.register(sound);
        return sound;
    }

}
