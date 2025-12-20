package net.Skin0oz.loakmod.server;

import net.Skin0oz.loakmod.LOAKMod;
import net.Skin0oz.loakmod.client.fx.ManaWandParticle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LOAKMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class LoakServerRuntime {

    private LoakServerRuntime() {}

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
    }
}
