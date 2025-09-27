package github.mattzmt.malta.datagen;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
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
                Item curdledMilkBucket = ModItems.CURDLED_MILK_BUCKET;
                Item gbejna = ModItems.GBEJNA;
                Item peppercorns = ModItems.PEPPERCORNS;
                Item wheat = Items.WHEAT;
                Item waterBucket = Items.WATER_BUCKET;
                Item dough = ModItems.DOUGH;
                Item dates = ModItems.DATES;
                Item olive = ModItems.OLIVE;
                Item glassBottle = Items.GLASS_BOTTLE;
                Item cookedSalmon = Items.COOKED_SALMON;
                Item bowl = Items.BOWL;
                Item salmonDip = ModItems.SALMON_DIP;
                Item galletta = ModItems.GALLETTA;
                Item wheatSeeds = Items.WHEAT_SEEDS;
                Item potato = Items.POTATO;
                Item bigilla = ModItems.BIGILLA;
                Item oliveOil = ModItems.OLIVE_OIL;
                Item gbejnaDip = ModItems.GBEJNA_DIP;

                Block datePalmLog = ModBlocks.DATE_PALM_LOG;

                offerFoodCookingRecipe("smelting", RecipeSerializer.SMELTING, SmeltingRecipe::new, 10 * 20, Items.MILK_BUCKET, curdledMilkBucket, 0.35f);
                offerFoodCookingRecipe("smoking", RecipeSerializer.SMOKING, SmokingRecipe::new, 5 * 20, Items.MILK_BUCKET, curdledMilkBucket, 0.35f);

                createShapeless(RecipeCategory.FOOD, gbejna, 2)
                        .input(curdledMilkBucket)
                        .criterion(hasItem(curdledMilkBucket), conditionsFromItem(curdledMilkBucket))
                        .offerTo(recipeExporter, "gbejna");

                createShapeless(RecipeCategory.FOOD, ModItems.PEPPERED_GBEJNA, 1)
                        .input(gbejna)
                        .input(peppercorns)
                        .criterion(hasItem(gbejna), conditionsFromItem(gbejna))
                        .criterion(hasItem(peppercorns), conditionsFromItem(peppercorns))
                        .offerTo(recipeExporter, "peppered_gbejna");

                createShapeless(RecipeCategory.FOOD, dough, 2)
                        .input(wheat, 3)
                        .input(waterBucket)
                        .criterion(hasItem(wheat), conditionsFromItem(wheat))
                        .criterion(hasItem(waterBucket), conditionsFromItem(waterBucket))
                        .offerTo(recipeExporter, "dough");

                createShapeless(RecipeCategory.FOOD, ModItems.MAQRUT, 2)
                        .input(dough)
                        .input(dates, 2)
                        .criterion(hasItem(dough), conditionsFromItem(dough))
                        .criterion(hasItem(dates), conditionsFromItem(dates))
                        .offerTo(recipeExporter, "maqrut");

                createShapeless(RecipeCategory.FOOD, oliveOil)
                        .input(olive, 3)
                        .input(glassBottle)
                        .criterion(hasItem(olive), conditionsFromItem(olive))
                        .criterion(hasItem(glassBottle), conditionsFromItem(glassBottle))
                        .offerTo(recipeExporter, "olive_oil");

                createShaped(RecipeCategory.FOOD, galletta, 4)
                        .input('D', dough)
                        .pattern("DD")
                        .criterion(hasItem(dough), conditionsFromItem(dough))
                        .offerTo(recipeExporter, "galletta");

                createShapeless(RecipeCategory.FOOD, salmonDip)
                        .input(curdledMilkBucket)
                        .input(cookedSalmon, 2)
                        .input(bowl)
                        .criterion(hasItem(curdledMilkBucket), conditionsFromItem(curdledMilkBucket))
                        .criterion(hasItem(cookedSalmon), conditionsFromItem(cookedSalmon))
                        .criterion(hasItem(bowl), conditionsFromItem(bowl))
                        .offerTo(recipeExporter, "salmon_dip");

                createShapeless(RecipeCategory.FOOD, ModItems.SALMON_DIPPED_GALLETTA, 2)
                        .input(salmonDip)
                        .input(galletta, 2)
                        .criterion(hasItem(salmonDip), conditionsFromItem(salmonDip))
                        .offerTo(recipeExporter, "salmon_dipped_galletta");

                createShapeless(RecipeCategory.FOOD, bigilla)
                        .input(peppercorns)
                        .input(wheatSeeds)
                        .input(potato)
                        .input(bowl)
                        .criterion(hasItem(peppercorns), conditionsFromItem(peppercorns))
                        .criterion(hasItem(wheatSeeds), conditionsFromItem(wheatSeeds))
                        .criterion(hasItem(potato), conditionsFromItem(potato))
                        .criterion(hasItem(bowl), conditionsFromItem(bowl))
                        .offerTo(recipeExporter, "bigilla");

                createShapeless(RecipeCategory.FOOD, ModItems.BIGILLA_DIPPED_GALLETTA, 2)
                        .input(bigilla)
                        .input(galletta, 2)
                        .criterion(hasItem(bigilla), conditionsFromItem(bigilla))
                        .offerTo(recipeExporter, "bigilla_dipped_galletta");

                createShapeless(RecipeCategory.FOOD, gbejnaDip)
                        .input(gbejna, 2)
                        .input(oliveOil)
                        .input(peppercorns)
                        .input(bowl)
                        .criterion(hasItem(gbejna), conditionsFromItem(gbejna))
                        .criterion(hasItem(oliveOil), conditionsFromItem(oliveOil))
                        .criterion(hasItem(peppercorns), conditionsFromItem(peppercorns))
                        .criterion(hasItem(bowl), conditionsFromItem(bowl))
                        .offerTo(recipeExporter, "gbejna_dip");

                createShapeless(RecipeCategory.FOOD, ModItems.GBEJNA_DIPPED_GALLETTA, 2)
                        .input(gbejnaDip)
                        .input(galletta, 2)
                        .criterion(hasItem(gbejnaDip), conditionsFromItem(gbejnaDip))
                        .offerTo(recipeExporter, "gbejna_dipped_galletta");

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DATE_PALM_WOOD, 3)
                        .input('L', datePalmLog)
                        .pattern("LL")
                        .pattern("LL")
                        .criterion(hasItem(datePalmLog), conditionsFromItem(datePalmLog))
                        .offerTo(recipeExporter, "date_palm_wood");

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_DATE_PALM_WOOD, 3)
                        .input('L', ModBlocks.STRIPPED_DATE_PALM_LOG)
                        .pattern("LL")
                        .pattern("LL")
                        .criterion(hasItem(ModBlocks.STRIPPED_DATE_PALM_LOG), conditionsFromItem(ModBlocks.STRIPPED_DATE_PALM_LOG))
                        .offerTo(recipeExporter, "stripped_date_palm_wood");

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DATE_PALM_PLANKS, 4)
                        .input(datePalmLog)
                        .criterion(hasItem(datePalmLog), conditionsFromItem(datePalmLog))
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