package net.Skin0oz.loakmod.item.ManaWand;

import net.Skin0oz.loakmod.client.fx.ManaWandParticle;
import net.Skin0oz.loakmod.client.render.ManaWandRenderer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class ManaWandItem extends Item implements GeoItem {

    private static final RawAnimation IDLE  = RawAnimation.begin().thenLoop("idle");
    private static final RawAnimation SHOOT = RawAnimation.begin().then("shoot", Animation.LoopType.PLAY_ONCE);
    AnimationController<GeoAnimatable> controller;



    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ManaWandItem(Properties properties) {
        super(properties);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private ManaWandRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) this.renderer = new ManaWandRenderer();
                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, "controller", 0, state -> {
                    state.setAnimation(IDLE);
                    return PlayState.CONTINUE;
                }).triggerableAnim("shoot", SHOOT)
        );
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // On laisse le serveur assigner l'ID si besoin (utile en multi plus tard)
        if (level instanceof ServerLevel serverLevel) {
            GeoItem.getOrAssignId(stack, serverLevel);
            long id = GeoItem.getOrAssignId(stack, serverLevel);
            triggerAnim(player, id, "controller", "shoot");

        }

        if (level.isClientSide) {
            long id = GeoItem.getId(stack);

            // Attention: ne marche que si un ID a déjà été assigné au stack (souvent via le serveur)
            if (id != 0L) {
                var manager = this.getAnimatableInstanceCache().getManagerForId(id);

                // Ici le type est GeoAnimatable, pas ManaWandItem
                AnimationController<GeoAnimatable> controller =
                        manager.getAnimationControllers().get("controller");

                if (controller != null) {
                    controller.stop();
                    controller.forceAnimationReset();
                    controller.tryTriggerAnimation("shoot");
                    //-------------Interaction ici ---------------
                    ManaWandParticle.startTriplePentagram(1.0);

                }
            }
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }
}