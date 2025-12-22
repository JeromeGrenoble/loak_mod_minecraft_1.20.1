package net.Skin0oz.loakmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.Skin0oz.loakmod.LOAKMod;
import net.Skin0oz.loakmod.entity.custom.RhinoEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RhinoRenderer extends MobRenderer<RhinoEntity, model<RhinoEntity>> {
    public RhinoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new model<>(pContext.bakeLayer(ModModelLayers.RHINO_LAYER)), 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(RhinoEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(
                LOAKMod.MOD_ID,
                "textures/entity/ram.png"
        );
    }

    @Override
    public void render(RhinoEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {

            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
