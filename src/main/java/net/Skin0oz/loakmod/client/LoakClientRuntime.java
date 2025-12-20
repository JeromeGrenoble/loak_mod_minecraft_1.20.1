package net.Skin0oz.loakmod.client;

import net.Skin0oz.loakmod.LOAKMod;
import net.Skin0oz.loakmod.client.fx.ManaWandParticle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LOAKMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class LoakClientRuntime {

    private LoakClientRuntime() {}

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        ManaWandParticle.clientTick(1.0);
    }
}
