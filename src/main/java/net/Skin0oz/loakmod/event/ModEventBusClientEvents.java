package net.Skin0oz.loakmod.event;

import net.Skin0oz.loakmod.LOAKMod;
import net.Skin0oz.loakmod.entity.client.ModModelLayers;
import net.Skin0oz.loakmod.entity.client.model;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LOAKMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RHINO_LAYER, model::createBodyLayer);
    }

}
