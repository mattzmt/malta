package github.mattzmt.malta.datagen;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.block.custom.BlackPepperCropBlock;
import github.mattzmt.malta.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.BLACK_PEPPER_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(BlackPepperCropBlock.AGE, BlackPepperCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.BLACK_PEPPER_CROP, this.cropDrops(ModBlocks.BLACK_PEPPER_CROP, ModItems.PEPPERCORNS, ModItems.PEPPERCORNS, builder));

        addDrop(ModBlocks.DATE_BUNCH, dropsWithShears(ModBlocks.DATE_BUNCH, applyExplosionDecay(ModBlocks.DATE_BUNCH, ItemEntry.builder(ModItems.DATES))));
        addDrop(ModBlocks.DATE_PALM_LEAVES, leavesDrops(ModBlocks.DATE_PALM_LEAVES, ModBlocks.DATE_PALM_SAPLING, 0.1f));
        addDrop(ModBlocks.DATE_PALM_LOG);
        addDrop(ModBlocks.DATE_PALM_WOOD);
        addDrop(ModBlocks.STRIPPED_DATE_PALM_LOG);
        addDrop(ModBlocks.STRIPPED_DATE_PALM_WOOD);
        addDrop(ModBlocks.DATE_PALM_PLANKS);
        addDrop(ModBlocks.DATE_PALM_SAPLING);
    }
}