package github.mattzmt.malta.datagen.tags;

import github.mattzmt.malta.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.DATE_PALM_LOG)
                .add(ModBlocks.DATE_PALM_WOOD)
                .add(ModBlocks.STRIPPED_DATE_PALM_LOG)
                .add(ModBlocks.STRIPPED_DATE_PALM_WOOD)
                .add(ModBlocks.OLIVE_LOG)
                .add(ModBlocks.OLIVE_WOOD)
                .add(ModBlocks.STRIPPED_OLIVE_LOG)
                .add(ModBlocks.STRIPPED_OLIVE_WOOD);

        valueLookupBuilder(BlockTags.CROPS)
                .add(ModBlocks.BLACK_PEPPER_CROP);

        valueLookupBuilder(BlockTags.BEE_GROWABLES)
                .add(ModBlocks.BLACK_PEPPER_CROP);

        valueLookupBuilder(BlockTags.MAINTAINS_FARMLAND)
                .add(ModBlocks.BLACK_PEPPER_CROP);

        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE)
                .add(ModBlocks.DATE_BUNCH);

        valueLookupBuilder(BlockTags.LEAVES)
                .add(ModBlocks.DATE_PALM_LEAVES)
                .add(ModBlocks.OLIVE_LEAVES);

        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.DATE_PALM_LOG)
                .add(ModBlocks.DATE_PALM_WOOD)
                .add(ModBlocks.STRIPPED_DATE_PALM_LOG)
                .add(ModBlocks.STRIPPED_DATE_PALM_WOOD)
                .add(ModBlocks.OLIVE_LOG)
                .add(ModBlocks.OLIVE_WOOD)
                .add(ModBlocks.STRIPPED_OLIVE_LOG)
                .add(ModBlocks.STRIPPED_OLIVE_WOOD);

        valueLookupBuilder(BlockTags.LOGS)
                .add(ModBlocks.DATE_PALM_LOG)
                .add(ModBlocks.DATE_PALM_WOOD)
                .add(ModBlocks.STRIPPED_DATE_PALM_LOG)
                .add(ModBlocks.STRIPPED_DATE_PALM_WOOD)
                .add(ModBlocks.OLIVE_LOG)
                .add(ModBlocks.OLIVE_WOOD)
                .add(ModBlocks.STRIPPED_OLIVE_LOG)
                .add(ModBlocks.STRIPPED_OLIVE_WOOD);

        valueLookupBuilder(BlockTags.COMPLETES_FIND_TREE_TUTORIAL)
                .add(ModBlocks.DATE_PALM_LOG)
                .add(ModBlocks.DATE_PALM_WOOD)
                .add(ModBlocks.STRIPPED_DATE_PALM_LOG)
                .add(ModBlocks.STRIPPED_DATE_PALM_WOOD)
                .add(ModBlocks.OLIVE_LOG)
                .add(ModBlocks.OLIVE_WOOD)
                .add(ModBlocks.STRIPPED_OLIVE_LOG)
                .add(ModBlocks.STRIPPED_OLIVE_WOOD);

        valueLookupBuilder(BlockTags.PLANKS)
                .add(ModBlocks.OLIVE_PLANKS);

        valueLookupBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.DATE_PALM_SAPLING)
                .add(ModBlocks.OLIVE_SAPLING);

        valueLookupBuilder(BlockTags.SAND)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.SANDSTONE);
    }
}
