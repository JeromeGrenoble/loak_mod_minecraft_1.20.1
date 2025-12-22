package net.Skin0oz.loakmod.event;

import net.Skin0oz.loakmod.LOAKMod;
import net.Skin0oz.loakmod.entity.ModEntities;
import net.Skin0oz.loakmod.entity.client.ModModelLayers;
import net.Skin0oz.loakmod.entity.client.model;
import net.Skin0oz.loakmod.entity.custom.RhinoEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LOAKMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    // Enregistrement des attributs des entités
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAttributes().build());
    }

    // Enregistrement des LayerDefinitions pour les modèles
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(
                ModModelLayers.RHINO_LAYER,
                model::createBodyLayer
        );
    }
}