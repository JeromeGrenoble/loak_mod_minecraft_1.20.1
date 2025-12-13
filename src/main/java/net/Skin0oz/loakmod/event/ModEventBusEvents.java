package net.Skin0oz.loakmod.event;

import com.google.common.eventbus.Subscribe;
import net.Skin0oz.loakmod.LOAKMod;
import net.Skin0oz.loakmod.entity.ModEntities;
import net.Skin0oz.loakmod.entity.client.ModModelLayers;
import net.Skin0oz.loakmod.entity.client.RhinoModel;
import net.Skin0oz.loakmod.entity.custom.RhinoEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LOAKMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAttributes().build());
    }

}
