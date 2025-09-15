package github.mattzmt.malta.datagen;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                offerFoodCookingRecipe("smelting", RecipeSerializer.SMELTING, SmeltingRecipe::new, 200, Items.MILK_BUCKET, ModItems.CURDLED_MILK_BUCKET, 0.35f);
                offerFoodCookingRecipe("smoking", RecipeSerializer.SMOKING, SmokingRecipe::new, 100, Items.MILK_BUCKET, ModItems.CURDLED_MILK_BUCKET, 0.35f);

                createShapeless(RecipeCategory.FOOD, ModItems.GBEJNA, 2)
                        .input(ModItems.CURDLED_MILK_BUCKET)
                        .criterion(hasItem(ModItems.CURDLED_MILK_BUCKET), conditionsFromItem(ModItems.CURDLED_MILK_BUCKET))
                        .offerTo(recipeExporter, "gbejna");

                createShapeless(RecipeCategory.FOOD, ModItems.PEPPERED_GBEJNA, 1)
                        .input(ModItems.GBEJNA)
                        .input(ModItems.PEPPERCORNS)
                        .criterion(hasItem(ModItems.GBEJNA), conditionsFromItem(ModItems.GBEJNA))
                        .criterion(hasItem(ModItems.PEPPERCORNS), conditionsFromItem(ModItems.PEPPERCORNS))
                        .offerTo(recipeExporter, "peppered_gbejna");

                createShapeless(RecipeCategory.FOOD, ModItems.DOUGH, 2)
                        .input(Items.WHEAT, 3)
                        .input(Items.WATER_BUCKET)
                        .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                        .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
                        .offerTo(recipeExporter, "dough");

                createShapeless(RecipeCategory.FOOD, ModItems.MAQRUT, 2)
                        .input(ModItems.DOUGH)
                        .input(ModItems.DATES, 2)
                        .criterion(hasItem(ModItems.DOUGH), conditionsFromItem(ModItems.DOUGH))
                        .criterion(hasItem(ModItems.DATES), conditionsFromItem(ModItems.DATES))
                        .offerTo(recipeExporter, "maqrut");

                createShaped(RecipeCategory.FOOD, ModItems.GALLETTA, 4)
                        .input('D', ModItems.DOUGH)
                        .pattern("DD")
                        .criterion(hasItem(ModItems.DOUGH), conditionsFromItem(ModItems.DOUGH))
                        .offerTo(recipeExporter, "galletta");

                createShapeless(RecipeCategory.FOOD, ModItems.SALMON_DIP)
                        .input(ModItems.CURDLED_MILK_BUCKET)
                        .input(Items.COOKED_SALMON, 2)
                        .input(Items.BOWL)
                        .criterion(hasItem(ModItems.CURDLED_MILK_BUCKET), conditionsFromItem(ModItems.CURDLED_MILK_BUCKET))
                        .criterion(hasItem(Items.COOKED_SALMON), conditionsFromItem(Items.COOKED_SALMON))
                        .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                        .offerTo(recipeExporter, "salmon_dip");

                createShapeless(RecipeCategory.FOOD, ModItems.SALMON_DIPPED_GALLETTA, 2)
                        .input(ModItems.SALMON_DIP)
                        .input(ModItems.GALLETTA, 2)
                        .criterion(hasItem(ModItems.SALMON_DIP), conditionsFromItem(ModItems.SALMON_DIP))
                        .offerTo(recipeExporter, "salmon_dipped_galletta");

                createShapeless(RecipeCategory.FOOD, ModItems.BIGILLA)
                        .input(ModItems.PEPPERCORNS)
                        .input(Items.WHEAT_SEEDS)
                        .input(Items.POTATO)
                        .input(Items.BOWL)
                        .criterion(hasItem(ModItems.PEPPERCORNS), conditionsFromItem(ModItems.PEPPERCORNS))
                        .criterion(hasItem(Items.WHEAT_SEEDS), conditionsFromItem(Items.WHEAT_SEEDS))
                        .criterion(hasItem(Items.POTATO), conditionsFromItem(Items.POTATO))
                        .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                        .offerTo(recipeExporter, "bigilla");

                createShapeless(RecipeCategory.FOOD, ModItems.BIGILLA_DIPPED_GALLETTA, 2)
                        .input(ModItems.BIGILLA)
                        .input(ModItems.GALLETTA, 2)
                        .criterion(hasItem(ModItems.BIGILLA), conditionsFromItem(ModItems.BIGILLA))
                        .offerTo(recipeExporter, "bigilla_dipped_galletta");

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DATE_PALM_WOOD, 3)
                        .input('L', ModBlocks.DATE_PALM_LOG)
                        .pattern("LL")
                        .pattern("LL")
                        .criterion(hasItem(ModBlocks.DATE_PALM_LOG), conditionsFromItem(ModBlocks.DATE_PALM_LOG))
                        .offerTo(recipeExporter, "date_palm_wood");

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_DATE_PALM_WOOD, 3)
                        .input('L', ModBlocks.STRIPPED_DATE_PALM_LOG)
                        .pattern("LL")
                        .pattern("LL")
                        .criterion(hasItem(ModBlocks.STRIPPED_DATE_PALM_LOG), conditionsFromItem(ModBlocks.STRIPPED_DATE_PALM_LOG))
                        .offerTo(recipeExporter, "stripped_date_palm_wood");

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DATE_PALM_PLANKS, 4)
                        .input(ModBlocks.DATE_PALM_LOG)
                        .criterion(hasItem(ModBlocks.DATE_PALM_LOG), conditionsFromItem(ModBlocks.DATE_PALM_LOG))
                        .offerTo(recipeExporter, "date_palm_planks_from_log");

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DATE_PALM_PLANKS, 4)
                        .input(ModBlocks.STRIPPED_DATE_PALM_LOG)
                        .criterion(hasItem(ModBlocks.STRIPPED_DATE_PALM_LOG), conditionsFromItem(ModBlocks.STRIPPED_DATE_PALM_LOG))
                        .offerTo(recipeExporter, "date_palm_planks_from_stripped_log");

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DATE_PALM_PLANKS, 4)
                        .input(ModBlocks.DATE_PALM_WOOD)
                        .criterion(hasItem(ModBlocks.DATE_PALM_WOOD), conditionsFromItem(ModBlocks.DATE_PALM_WOOD))
                        .offerTo(recipeExporter, "date_palm_planks_from_wood");

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DATE_PALM_PLANKS, 4)
                        .input(ModBlocks.STRIPPED_DATE_PALM_WOOD)
                        .criterion(hasItem(ModBlocks.STRIPPED_DATE_PALM_WOOD), conditionsFromItem(ModBlocks.STRIPPED_DATE_PALM_WOOD))
                        .offerTo(recipeExporter, "date_palm_planks_from_stripped_wood");

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_WOOD, 3)
                        .input('L', ModBlocks.OLIVE_LOG)
                        .pattern("LL")
                        .pattern("LL")
                        .criterion(hasItem(ModBlocks.OLIVE_LOG), conditionsFromItem(ModBlocks.OLIVE_LOG))
                        .offerTo(recipeExporter, "olive_wood");

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_OLIVE_WOOD, 3)
                        .input('L', ModBlocks.STRIPPED_OLIVE_LOG)
                        .pattern("LL")
                        .pattern("LL")
                        .criterion(hasItem(ModBlocks.STRIPPED_OLIVE_LOG), conditionsFromItem(ModBlocks.STRIPPED_OLIVE_LOG))
                        .offerTo(recipeExporter, "stripped_olive_wood");

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_PLANKS, 4)
                        .input(ModBlocks.OLIVE_LOG)
                        .criterion(hasItem(ModBlocks.OLIVE_LOG), conditionsFromItem(ModBlocks.OLIVE_LOG))
                        .offerTo(recipeExporter, "olive_planks_from_log");

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_PLANKS, 4)
                        .input(ModBlocks.STRIPPED_OLIVE_LOG)
                        .criterion(hasItem(ModBlocks.STRIPPED_OLIVE_LOG), conditionsFromItem(ModBlocks.STRIPPED_OLIVE_LOG))
                        .offerTo(recipeExporter, "olive_planks_from_stripped_log");

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_PLANKS, 4)
                        .input(ModBlocks.OLIVE_WOOD)
                        .criterion(hasItem(ModBlocks.OLIVE_WOOD), conditionsFromItem(ModBlocks.OLIVE_WOOD))
                        .offerTo(recipeExporter, "olive_planks_from_wood");

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_PLANKS, 4)
                        .input(ModBlocks.STRIPPED_OLIVE_WOOD)
                        .criterion(hasItem(ModBlocks.STRIPPED_OLIVE_WOOD), conditionsFromItem(ModBlocks.STRIPPED_OLIVE_WOOD))
                        .offerTo(recipeExporter, "olive_planks_from_stripped_wood");
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
