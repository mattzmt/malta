package github.mattzmt.malta.item;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.entity.ModEntities;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModItems {
    private static final RegistryKey<Item> CURDLED_MILK_BUCKET_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("curdled_milk_bucket"));
    public static final Item CURDLED_MILK_BUCKET = register(
            "curdled_milk_bucket",
            new Item(new Item.Settings()
                    .recipeRemainder(Items.BUCKET)
                    .useRemainder(Items.BUCKET)
                    .food(ModFoodComponents.CURDLED_MILK_BUCKET, ModConsumableComponents.CURDLED_MILK_BUCKET)
                    .maxCount(1)
                    .registryKey(CURDLED_MILK_BUCKET_KEY)));

    private static final RegistryKey<Item> GBEJNA_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("gbejna"));
    public static final Item GBEJNA = register(
            "gbejna",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.GBEJNA, ModConsumableComponents.GBEJNA)
                    .maxCount(16)
                    .registryKey(GBEJNA_KEY)));

    private static final RegistryKey<Item> PEPPERED_GBEJNA_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("peppered_gbejna"));
    public static final Item PEPPERED_GBEJNA = register(
            "peppered_gbejna",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.GBEJNA, ModConsumableComponents.PEPPERED_GBEJNA)
                    .maxCount(16)
                    .registryKey(PEPPERED_GBEJNA_KEY)));

    private static final RegistryKey<Item> PEPPERCORNS_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("peppercorns"));
    public static final Item PEPPERCORNS = register(
            "peppercorns",
            new BlockItem(ModBlocks.BLACK_PEPPER_CROP,new Item.Settings()
                    .food(ModFoodComponents.PEPPERCORNS, ModConsumableComponents.PEPPERCORNS)
                    .useCooldown(0.2f)
                    .registryKey(PEPPERCORNS_KEY)));

    private static final RegistryKey<Item> DOUGH_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("dough"));
    public static final Item DOUGH = register(
            "dough",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.DOUGH, ModConsumableComponents.DOUGH)
                    .maxCount(16)
                    .registryKey(DOUGH_KEY)));

    private static final RegistryKey<Item> DATES_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("dates"));
    public static final Item DATES = register(
            "dates",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.DATES, ModConsumableComponents.DATES)
                    .registryKey(DATES_KEY)));

    private static final RegistryKey<Item> MAQRUT_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("maqrut"));
    public static final Item MAQRUT = register(
            "maqrut",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.MAQRUT, ModConsumableComponents.MAQRUT)
                    .maxCount(32)
                    .registryKey(MAQRUT_KEY)));

    private static final RegistryKey<Item> OLIVE_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("olive"));
    public static final Item OLIVE = register(
            "olive",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.OLIVE, ModConsumableComponents.OLIVE)
                    .registryKey(OLIVE_KEY)));

    private static final RegistryKey<Item> OLIVE_OIL_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("olive_oil"));
    public static final Item OLIVE_OIL = register(
            "olive_oil",
            new Item(new Item.Settings()
                    .recipeRemainder(Items.BUCKET)
                    .useRemainder(Items.BUCKET)
                    .food(ModFoodComponents.OLIVE_OIL, ModConsumableComponents.OLIVE_OIL)
                    .maxCount(16)
                    .registryKey(OLIVE_OIL_KEY)));

    private static final RegistryKey<Item> GALLETTA_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("galletta"));
    public static final Item GALLETTA = register(
            "galletta",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.GALLETTA, ModConsumableComponents.GALLETTA)
                    .maxCount(16)
                    .registryKey(GALLETTA_KEY)));

    private static final RegistryKey<Item> SALMON_DIP_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("salmon_dip"));
    public static final Item SALMON_DIP = register(
            "salmon_dip",
            new Item(new Item.Settings()
                    .useRemainder(Items.BOWL)
                    .maxCount(1)
                    .registryKey(SALMON_DIP_KEY)));

    private static final RegistryKey<Item> SALMON_DIPPED_GALLETTA_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("salmon_dipped_galletta"));
    public static final Item SALMON_DIPPED_GALLETTA = register(
            "salmon_dipped_galletta",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.GALLETTA, ModConsumableComponents.SALMON_DIPPED_GALLETTA)
                    .maxCount(4)
                    .registryKey(SALMON_DIPPED_GALLETTA_KEY)));

    private static final RegistryKey<Item> BIGILLA_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("bigilla"));
    public static final Item BIGILLA = register(
            "bigilla",
            new Item(new Item.Settings()
                    .useRemainder(Items.BOWL)
                    .maxCount(1)
                    .registryKey(BIGILLA_KEY)));

    private static final RegistryKey<Item> BIGILLA_DIPPED_GALLETTA_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("bigilla_dipped_galletta"));
    public static final Item BIGILLA_DIPPED_GALLETTA = register(
            "bigilla_dipped_galletta",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.GALLETTA, ModConsumableComponents.BIGILLA_DIPPED_GALLETTA)
                    .maxCount(4)
                    .registryKey(BIGILLA_DIPPED_GALLETTA_KEY)));

    private static final RegistryKey<Item> GBEJNA_DIP_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("gbejna_dip"));
    public static final Item GBEJNA_DIP = register(
            "gbejna_dip",
            new Item(new Item.Settings()
                    .useRemainder(Items.BOWL)
                    .maxCount(1)
                    .registryKey(GBEJNA_DIP_KEY)));

    private static final RegistryKey<Item> GBEJNA_DIPPED_GALLETTA_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("gbejna_dipped_galletta"));
    public static final Item GBEJNA_DIPPED_GALLETTA = register(
            "gbejna_dipped_galletta",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.GALLETTA, ModConsumableComponents.GBEJNA_DIPPED_GALLETTA)
                    .maxCount(4)
                    .registryKey(GBEJNA_DIPPED_GALLETTA_KEY)));

    private static final RegistryKey<Item> SNAIL_SPAWN_EGG_KEY = RegistryKey.of(RegistryKeys.ITEM, Malta.id("snail_spawn_egg"));
    public static final Item SNAIL_SPAWN_EGG = register(
            "snail_spawn_egg",
            new SpawnEggItem(ModEntities.SNAIL, new Item.Settings().registryKey(SNAIL_SPAWN_EGG_KEY)));

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, Malta.id(name), item);
    }

    public static void load() {
    }
}