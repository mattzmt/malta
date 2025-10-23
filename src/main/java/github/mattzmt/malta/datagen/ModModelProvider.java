package github.mattzmt.malta.datagen;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.block.custom.BlackPepperCropBlock;
import github.mattzmt.malta.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import static net.minecraft.client.data.BlockStateModelGenerator.createWeightedVariant;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.BLACK_PEPPER_CROP, BlackPepperCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);

        blockStateModelGenerator.registerTintableCross(ModBlocks.DATE_BUNCH, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerTintedBlockAndItem(ModBlocks.DATE_PALM_LEAVES, TexturedModel.LEAVES, 0xA7B245);
        blockStateModelGenerator.registerTintedBlockAndItem(ModBlocks.OLIVE_LEAVES, TexturedModel.LEAVES, 0x8EA657);

        blockStateModelGenerator.createLogTexturePool(ModBlocks.DATE_PALM_LOG)
                .log(ModBlocks.DATE_PALM_LOG)
                .wood(ModBlocks.DATE_PALM_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_DATE_PALM_LOG)
                .log(ModBlocks.STRIPPED_DATE_PALM_LOG)
                .wood(ModBlocks.STRIPPED_DATE_PALM_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.OLIVE_LOG)
                .log(ModBlocks.OLIVE_LOG)
                .wood(ModBlocks.OLIVE_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_OLIVE_LOG)
                .log(ModBlocks.STRIPPED_OLIVE_LOG)
                .wood(ModBlocks.STRIPPED_OLIVE_WOOD);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DATE_PALM_PLANKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OLIVE_PLANKS);

        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.DATE_PALM_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.OLIVE_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockModelDefinitionCreator.of(ModBlocks.SLIME_TRAIL).with(
                                BlockStateVariantMap.models(Properties.AGE_3)
                                        .register(0, createWeightedVariant(createSubModel(blockStateModelGenerator, "_0")))
                                        .register(1, createWeightedVariant(createSubModel(blockStateModelGenerator, "_1")))
                                        .register(2, createWeightedVariant(createSubModel(blockStateModelGenerator, "_2")))
                                        .register(3, createWeightedVariant(createSubModel(blockStateModelGenerator, "_3")))));

		blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.SNAIL_SHELL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.DATE_PALM_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.OLIVE_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.CURDLED_MILK_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.GBEJNA, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEPPERED_GBEJNA, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUGH, Models.GENERATED);
        itemModelGenerator.register(ModItems.DATES, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAQRUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OLIVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OLIVE_OIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.GALLETTA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALMON_DIP, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALMON_DIPPED_GALLETTA, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIGILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIGILLA_DIPPED_GALLETTA, Models.GENERATED);
        itemModelGenerator.register(ModItems.GBEJNA_DIP, Models.GENERATED);
        itemModelGenerator.register(ModItems.GBEJNA_DIPPED_GALLETTA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNAIL_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SNAIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_SNAIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNAIL_SHELL, Models.GENERATED);
    }

    private Identifier createSubModel(BlockStateModelGenerator generator, String suffix) {
        return Models.CARPET.upload(
                ModBlocks.SLIME_TRAIL,
                suffix,
                TextureMap.of(TextureKey.WOOL, Malta.id("block/slime_trail"+suffix)),
                generator.modelCollector);}
}