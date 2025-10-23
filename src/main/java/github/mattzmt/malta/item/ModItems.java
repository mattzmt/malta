package github.mattzmt.malta.item;

import github.mattzmt.malta.Malta;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModItems {


    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, Malta.id(name), item);}

    private static Item.Settings newSettings(String name) {
        return new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Malta.id(name)));}

    public static void load() {}
}