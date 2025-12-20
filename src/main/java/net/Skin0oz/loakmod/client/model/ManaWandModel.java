package net.Skin0oz.loakmod.client.model;

import net.Skin0oz.loakmod.LOAKMod;
import net.Skin0oz.loakmod.item.ManaWand.ManaWandItem;
import net.minecraft.resources.ResourceLocation;

import software.bernie.geckolib.model.GeoModel;


public class ManaWandModel extends GeoModel<ManaWandItem> {

    @Override
    public ResourceLocation getModelResource(ManaWandItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                LOAKMod.MOD_ID,
                "geo/item/mana_wand.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(ManaWandItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                LOAKMod.MOD_ID,
                "textures/item/mana_wand.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(ManaWandItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                LOAKMod.MOD_ID,
                "animations/item/mana_wand.animation.json"
        );
    }
}
