package github.mattzmt.malta.datagen;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.block.custom.BlackPepperCropBlock;
import github.mattzmt.malta.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.BLACK_PEPPER_CROP, BlackPepperCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);

        blockStateModelGenerator.registerTintableCross(ModBlocks.DATE_BUNCH, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerSingleton(ModBlocks.DATE_PALM_LEAVES, TexturedModel.LEAVES);

        blockStateModelGenerator.createLogTexturePool(ModBlocks.DATE_PALM_LOG)
                .log(ModBlocks.DATE_PALM_LOG)
                .wood(ModBlocks.DATE_PALM_WOOD);

        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_DATE_PALM_LOG)
                .log(ModBlocks.STRIPPED_DATE_PALM_LOG)
                .wood(ModBlocks.STRIPPED_DATE_PALM_WOOD);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DATE_PALM_PLANKS);

        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.DATE_PALM_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CURDLED_MILK_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.GBEJNA, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEPPERED_GBEJNA, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUGH, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.DATE_PALM_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.DATES, Models.GENERATED);
        itemModelGenerator.register(ModItems.IMQARET, Models.GENERATED);
        itemModelGenerator.register(ModItems.GALLETTA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALMON_DIP, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALMON_DIPPED_GALLETTA, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIGILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIGILLA_DIPPED_GALLETTA, Models.GENERATED);
    }
}