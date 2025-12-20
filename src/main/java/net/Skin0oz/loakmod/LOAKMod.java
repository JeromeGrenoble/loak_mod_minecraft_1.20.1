package net.Skin0oz.loakmod;

import com.mojang.logging.LogUtils;
import net.Skin0oz.loakmod.entity.ModEntities;
import net.Skin0oz.loakmod.entity.client.RhinoRenderer;
import net.Skin0oz.loakmod.registry.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

@Mod(LOAKMod.MOD_ID)
public class LOAKMod {

    public static final String MOD_ID = "loakmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public LOAKMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Registries
        ModItems.register(modEventBus);

        // Mod lifecycle
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        // Forge runtime events
        MinecraftForge.EVENT_BUS.register(this);

        // ===== Runtime server =====
        MinecraftForge.EVENT_BUS.addListener(net.Skin0oz.loakmod.server.LoakServerRuntime::onPlayerTick);

        // ===== Runtime client (sécurisé) =====
        DistExecutor.safeRunWhenOn(
                Dist.CLIENT,
                () -> ClientRuntimeRegistrar::register
        );
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.test);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    /**
     * Classe isolée pour éviter toute référence client côté serveur.
     */
    private static final class ClientRuntimeRegistrar {
        private ClientRuntimeRegistrar() {}

        private static void register() {
            MinecraftForge.EVENT_BUS.addListener(
                    net.Skin0oz.loakmod.client.LoakClientRuntime::onClientTick
            );
        }
    }

    @Mod.EventBusSubscriber(
            modid = MOD_ID,
            bus = Mod.EventBusSubscriber.Bus.MOD,
            value = Dist.CLIENT
    )
    public static final class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.RHINO.get(), RhinoRenderer::new);
        }
    }
}
