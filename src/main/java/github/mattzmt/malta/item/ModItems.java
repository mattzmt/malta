package github.mattzmt.malta.item;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModItems {
    public static final RegistryKey<Item> CURDLED_MILK_BUCKET_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("curdled_milk_bucket"));
    public static final Item CURDLED_MILK_BUCKET = register(
            "curdled_milk_bucket",
            new Item(new Item.Settings()
                    .recipeRemainder(Items.BUCKET)
                    .useRemainder(Items.BUCKET)
                    .food(ModFoodComponents.CURDLED_MILK_BUCKET, ModConsumableComponents.CURDLED_MILK_BUCKET)
                    .maxCount(1)
                    .registryKey(CURDLED_MILK_BUCKET_KEY)));

    public static final RegistryKey<Item> GBEJNA_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("gbejna"));
    public static final Item GBEJNA = register(
            "gbejna",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.GBEJNA, ModConsumableComponents.GBEJNA)
                    .maxCount(16)
                    .registryKey(GBEJNA_KEY)));

    public static final RegistryKey<Item> PEPPERED_GBEJNA_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("peppered_gbejna"));
    public static final Item PEPPERED_GBEJNA = register(
            "peppered_gbejna",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.PEPPERED_GBEJNA, ModConsumableComponents.PEPPERED_GBEJNA)
                    .maxCount(16)
                    .registryKey(PEPPERED_GBEJNA_KEY)));

    public static final RegistryKey<Item> PEPPERCORNS_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("peppercorns"));
    public static final Item PEPPERCORNS = register(
            "peppercorns",
            new BlockItem(ModBlocks.BLACK_PEPPER_CROP, new Item.Settings()
                    .food(ModFoodComponents.PEPPERCORNS, ModConsumableComponents.PEPPERCORNS)
                    .registryKey(PEPPERCORNS_KEY)));

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, Malta.id(name), item);
    }

    public static void load() {
    }
}