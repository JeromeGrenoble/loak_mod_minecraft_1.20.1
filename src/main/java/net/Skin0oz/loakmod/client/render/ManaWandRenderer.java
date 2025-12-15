package net.Skin0oz.loakmod.client.render;
import net.Skin0oz.loakmod.client.model.ManaWandModel;
import net.Skin0oz.loakmod.item.ManaWandItem;

import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ManaWandRenderer extends GeoItemRenderer<ManaWandItem> {
    public ManaWandRenderer() {
        super(new ManaWandModel());
    }
}

