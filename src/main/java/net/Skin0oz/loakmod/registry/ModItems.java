package net.Skin0oz.loakmod.registry;

import net.Skin0oz.loakmod.LOAKMod;
import net.Skin0oz.loakmod.item.ManaWandItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LOAKMod.MOD_ID);

    public static final RegistryObject<Item> test = ITEMS.register("test",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<ManaWandItem> MANA_WAND = ITEMS.register("mana_wand",
            () -> new ManaWandItem(new Item.Properties().stacksTo(1)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
