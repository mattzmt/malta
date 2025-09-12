package github.mattzmt.malta.datagen.tags;

import github.mattzmt.malta.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

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

        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.DATE_PALM_PLANKS.asItem());
    }
}