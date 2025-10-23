package github.mattzmt.malta.block;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModBlocks {


    private static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, Malta.id(name), block);}

    private static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block);
        ModItems.register(name, new BlockItem(registered, settings.useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, Malta.id(name)))));
        return registered;}

    private static <T extends Block> T registerWithItem(String name, T block) {
        return registerWithItem(name, block, new Item.Settings());}

    private static AbstractBlock.Settings newSettings(String name) {
        return AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Malta.id(name)));}

    private static AbstractBlock.Settings copySettings(AbstractBlock block, String name) {
        return AbstractBlock.Settings.copy(block).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Malta.id(name)));}

    public static void load() {}
}