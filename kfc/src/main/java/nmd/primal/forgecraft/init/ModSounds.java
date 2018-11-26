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
    public static SoundEvent BOW_TWANG;
    public static SoundEvent CHISEL_HIT;
    public static SoundEvent CHISEL_HIT_FINISHED;
    public static SoundEvent ENGINE_EXTENSION;
    public static SoundEvent ENGINE_RETRACTION;
    public static SoundEvent SAW_MACHINE;

    public static void registerSounds()
    {
        PISTON_BELLOWS = registerSound("piston_bellows");
        MUSKET_SHOT = registerSound("musket_shot");
        BOW_TWANG = registerSound("bow_twang");
        CHISEL_HIT = registerSound("chisel_hit");
        CHISEL_HIT_FINISHED = registerSound("chisel_hit_finished");
        ENGINE_EXTENSION = registerSound("piston_engine_out");
        ENGINE_RETRACTION = registerSound("piston_engine_in");
        SAW_MACHINE = registerSound("saw_machine");
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
