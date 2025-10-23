package github.mattzmt.malta.datagen;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.block.custom.BlackPepperCropBlock;
import github.mattzmt.malta.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public static final float[] HIGHER_SAPLING_DROP_CHANCE = new float[]{0.1F, 0.15555557F, 0.225F, 0.3333334F, 0.5F};

    @Override
    public void generate() {
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.BLACK_PEPPER_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(BlackPepperCropBlock.AGE, BlackPepperCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.BLACK_PEPPER_CROP, this.cropDrops(ModBlocks.BLACK_PEPPER_CROP, ModItems.PEPPERCORNS, ModItems.PEPPERCORNS, builder));

        addDrop(ModBlocks.DATE_BUNCH, dropsWithShears(ModBlocks.DATE_BUNCH, applyExplosionDecay(ModBlocks.DATE_BUNCH, ItemEntry.builder(ModItems.DATES))));
        addDrop(ModBlocks.DATE_PALM_LEAVES, fruitLeavesDrops(ModBlocks.DATE_PALM_LEAVES, ModBlocks.DATE_PALM_SAPLING, ModItems.DATES, HIGHER_SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.DATE_PALM_LOG);
        addDrop(ModBlocks.DATE_PALM_WOOD);
        addDrop(ModBlocks.STRIPPED_DATE_PALM_LOG);
        addDrop(ModBlocks.STRIPPED_DATE_PALM_WOOD);
        addDrop(ModBlocks.DATE_PALM_PLANKS);
        addDrop(ModBlocks.DATE_PALM_SAPLING);
        addDrop(ModBlocks.OLIVE_LEAVES, fruitLeavesDrops(ModBlocks.OLIVE_LEAVES, ModBlocks.OLIVE_SAPLING, ModItems.OLIVE, HIGHER_SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.OLIVE_LOG);
        addDrop(ModBlocks.OLIVE_WOOD);
        addDrop(ModBlocks.STRIPPED_OLIVE_LOG);
        addDrop(ModBlocks.STRIPPED_OLIVE_WOOD);
        addDrop(ModBlocks.OLIVE_PLANKS);
        addDrop(ModBlocks.OLIVE_SAPLING);
        addDrop(ModBlocks.SNAIL_SHELL, ModItems.SNAIL_SHELL);
    }

    public LootTable.Builder fruitLeavesDrops(Block leaves, Block sapling, Item fruit, float... saplingChance) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.leavesDrops(leaves, sapling, saplingChance)
                .pool(
                        LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                                .with(
                                        ((LeafEntry.Builder)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(fruit)))
                                                .conditionally(TableBonusLootCondition.builder(impl.getOrThrow(Enchantments.FORTUNE), 0.1F, 0.15555557F, 0.225F, 0.3333334F, 0.5F))
                                )
                );
    }
}