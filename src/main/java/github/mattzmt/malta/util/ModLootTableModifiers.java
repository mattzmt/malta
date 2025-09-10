package github.mattzmt.malta.util;

import github.mattzmt.malta.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier VINE_ID
            = Identifier.of("minecraft", "blocks/vine");
    private static final Identifier JUNGLE_LEAVES_ID
            = Identifier.of("minecraft", "blocks/jungle_leaves");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if(VINE_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.PEPPERCORNS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(JUNGLE_LEAVES_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.PEPPERCORNS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(LootTables.HERO_OF_THE_VILLAGE_FARMER_GIFT_GAMEPLAY.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.PEPPERCORNS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 6)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(LootTables.JUNGLE_TEMPLE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.PEPPERCORNS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 6)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(LootTables.VILLAGE_CARTOGRAPHER_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.PEPPERCORNS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 6)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(LootTables.VILLAGE_SAVANNA_HOUSE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.PEPPERCORNS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 6)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(LootTables.VILLAGE_PLAINS_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.PEPPERCORNS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 6)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
