package net.Skin0oz.loakmod.entity.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.Skin0oz.loakmod.LOAKMod;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LOAKMod.MOD_ID);

    public static final RegistryObject<SoundEvent> RAM_DEATH =
            register("entity.ram.death");

    public static final RegistryObject<SoundEvent> RAM_HURT =
            register("entity.ram.hurt");

    public static final RegistryObject<SoundEvent> RAM_IDLE =
            register("entity.ram.ambient");

    public static final RegistryObject<SoundEvent> RAM_ATTACK =
            register("entity.ram.attack");

    public static final RegistryObject<SoundEvent> RAM_FALL =
            register("entity.ram.step");

    private static RegistryObject<SoundEvent> register(String id) {
        return SOUND_EVENTS.register(id,
                () -> SoundEvent.createVariableRangeEvent(
                        ResourceLocation.fromNamespaceAndPath(LOAKMod.MOD_ID, id)
                ));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}