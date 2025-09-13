package github.mattzmt.malta.datagen.tags;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.DATE_PALM_LOG.asItem())
                .add(ModBlocks.DATE_PALM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DATE_PALM_LOG.asItem())
                .add(ModBlocks.STRIPPED_DATE_PALM_WOOD.asItem());

        valueLookupBuilder(ItemTags.LOGS)
                .add(ModBlocks.DATE_PALM_LOG.asItem())
                .add(ModBlocks.DATE_PALM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DATE_PALM_LOG.asItem())
                .add(ModBlocks.STRIPPED_DATE_PALM_WOOD.asItem());

        valueLookupBuilder(ItemTags.COMPLETES_FIND_TREE_TUTORIAL)
                .add(ModBlocks.DATE_PALM_LOG.asItem())
                .add(ModBlocks.DATE_PALM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DATE_PALM_LOG.asItem())
                .add(ModBlocks.STRIPPED_DATE_PALM_WOOD.asItem());

        valueLookupBuilder(ItemTags.LEAVES)
                .add(ModBlocks.DATE_PALM_LEAVES.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.DATE_PALM_PLANKS.asItem());

        valueLookupBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.DATE_PALM_SAPLING.asItem());

        valueLookupBuilder(ItemTags.BEE_FOOD)
                .add(ModBlocks.DATE_BUNCH.asItem())
                .add(ModItems.DATES);

        valueLookupBuilder(ItemTags.CHICKEN_FOOD)
                .add(ModItems.PEPPERCORNS);

        valueLookupBuilder(ItemTags.PARROT_FOOD)
                .add(ModItems.PEPPERCORNS)
                .add(ModBlocks.DATE_BUNCH.asItem())
                .add(ModItems.DATES);

        valueLookupBuilder(ItemTags.CREEPER_IGNITERS)
                .add(ModItems.PEPPERCORNS)
                .add(ModItems.PEPPERED_GBEJNA);

        valueLookupBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(ModItems.PEPPERCORNS);

        valueLookupBuilder(ItemTags.VILLAGER_PICKS_UP)
                .add(ModItems.GBEJNA)
                .add(ModItems.PEPPERED_GBEJNA)
                .add(ModItems.IMQARET)
                .add(ModItems.GALLETTA)
                .add(ModItems.SALMON_DIPPED_GALLETTA)
                .add(ModItems.BIGILLA_DIPPED_GALLETTA);
    }
}