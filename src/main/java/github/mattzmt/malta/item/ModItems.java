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
    public static final Item CURDLED_MILK_BUCKET = register(
            "curdled_milk_bucket",
            new Item(newSettings("curdled_milk_bucket")
                    .recipeRemainder(Items.BUCKET)
                    .useRemainder(Items.BUCKET)
                    .food(ModFoodComponents.CURDLED_MILK_BUCKET, ModConsumableComponents.CURDLED_MILK_BUCKET)
                    .maxCount(1)));

    public static final Item GBEJNA = register(
            "gbejna",
            new Item(newSettings("gbejna")
                    .food(ModFoodComponents.GBEJNA, ModConsumableComponents.GBEJNA)
                    .maxCount(16)));

    public static final Item PEPPERED_GBEJNA = register(
            "peppered_gbejna",
            new Item(newSettings("peppered_gbejna")
                    .food(ModFoodComponents.GBEJNA, ModConsumableComponents.PEPPERED_GBEJNA)
                    .maxCount(16)));

    public static final Item PEPPERCORNS = register(
            "peppercorns",
            new BlockItem(ModBlocks.BLACK_PEPPER_CROP,newSettings("peppercorns")
                    .food(ModFoodComponents.PEPPERCORNS, ModConsumableComponents.PEPPERCORNS)
                    .useCooldown(0.2f)));

    public static final Item DOUGH = register(
            "dough",
            new Item(newSettings("dough")
                    .food(ModFoodComponents.DOUGH, ModConsumableComponents.DOUGH)
                    .maxCount(16)));

    public static final Item DATES = register(
            "dates",
            new Item(newSettings("dates")
                    .food(ModFoodComponents.DATES, ModConsumableComponents.DATES)));

    public static final Item MAQRUT = register(
            "maqrut",
            new Item(newSettings("maqrut")
                    .food(ModFoodComponents.MAQRUT, ModConsumableComponents.MAQRUT)
                    .maxCount(32)));

    public static final Item OLIVE = register(
            "olive",
            new Item(newSettings("olive")
                    .food(ModFoodComponents.OLIVE, ModConsumableComponents.OLIVE)));

    public static final Item OLIVE_OIL = register(
            "olive_oil",
            new Item(newSettings("olive_oil")
                    .recipeRemainder(Items.GLASS_BOTTLE)
                    .useRemainder(Items.GLASS_BOTTLE)
                    .food(ModFoodComponents.OLIVE_OIL, ModConsumableComponents.OLIVE_OIL)
                    .maxCount(16)));

    public static final Item GALLETTA = register(
            "galletta",
            new Item(newSettings("galletta")
                    .food(ModFoodComponents.GALLETTA, ModConsumableComponents.GALLETTA)
                    .maxCount(16)));

    public static final Item SALMON_DIP = register(
            "salmon_dip",
            new Item(newSettings("salmon_dip")
                    .recipeRemainder(Items.BOWL)
                    .useRemainder(Items.BOWL)
                    .maxCount(1)));

    public static final Item SALMON_DIPPED_GALLETTA = register(
            "salmon_dipped_galletta",
            new Item(newSettings("salmon_dipped_galletta")
                    .food(ModFoodComponents.GALLETTA, ModConsumableComponents.SALMON_DIPPED_GALLETTA)
                    .maxCount(4)));

    public static final Item BIGILLA = register(
            "bigilla",
            new Item(newSettings("bigilla")
                    .recipeRemainder(Items.BOWL)
                    .useRemainder(Items.BOWL)
                    .maxCount(1)));

    public static final Item BIGILLA_DIPPED_GALLETTA = register(
            "bigilla_dipped_galletta",
            new Item(newSettings("bigilla_dipped_galletta")
                    .food(ModFoodComponents.GALLETTA, ModConsumableComponents.BIGILLA_DIPPED_GALLETTA)
                    .maxCount(4)));

    public static final Item GBEJNA_DIP = register(
            "gbejna_dip",
            new Item(newSettings("gbejna_dip")
                    .recipeRemainder(Items.BOWL)
                    .useRemainder(Items.BOWL)
                    .maxCount(1)));

    public static final Item GBEJNA_DIPPED_GALLETTA = register(
            "gbejna_dipped_galletta",
            new Item(newSettings("gbejna_dipped_galletta")
                    .food(ModFoodComponents.GALLETTA, ModConsumableComponents.GBEJNA_DIPPED_GALLETTA)
                    .maxCount(4)));

    public static final Item SNAIL_SPAWN_EGG = register(
            "snail_spawn_egg",
            new SpawnEggItem(ModEntities.SNAIL, newSettings("snail_spawn_egg")));

    public static final BlockItem SNAIL_SHELL = register(
            "snail_shell",
            new BlockItem(ModBlocks.SNAIL_SHELL, newSettings("snail_shell")));

    public static final Item RAW_SNAIL = register(
            "raw_snail",
            new Item(newSettings("raw_snail")
                    .useRemainder(ModItems.SNAIL_SHELL)
                    .food(ModFoodComponents.RAW_SNAIL, ModConsumableComponents.RAW_SNAIL)));

    public static final Item COOKED_SNAIL = register(
            "cooked_snail",
            new Item(newSettings("cooked_snail")
                    .useRemainder(ModItems.SNAIL_SHELL)
                    .food(ModFoodComponents.COOKED_SNAIL)));

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, Malta.id(name), item);}

    private static Item.Settings newSettings(String name) {
        return new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Malta.id(name)));}

    public static void load() {}
}