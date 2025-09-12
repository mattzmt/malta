package github.mattzmt.malta.datagen.tags;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.block.custom.BlackPepperCropBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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
                .add(ModBlocks.STRIPPED_DATE_PALM_WOOD);

        valueLookupBuilder(BlockTags.CROPS)
                .add(ModBlocks.BLACK_PEPPER_CROP);

        valueLookupBuilder(BlockTags.LEAVES)
                .add(ModBlocks.DATE_PALM_LEAVES);

        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE)
                .add(ModBlocks.DATE_BUNCH);

        valueLookupBuilder(BlockTags.BEE_GROWABLES)
                .add(ModBlocks.BLACK_PEPPER_CROP);

        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.DATE_PALM_LOG)
                .add(ModBlocks.DATE_PALM_WOOD)
                .add(ModBlocks.STRIPPED_DATE_PALM_LOG)
                .add(ModBlocks.STRIPPED_DATE_PALM_WOOD);
    }
}
