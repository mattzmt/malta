package github.mattzmt.malta.datagen;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.block.custom.BlackPepperCropBlock;
import github.mattzmt.malta.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
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
    }
}
