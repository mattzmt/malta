package github.mattzmt.malta.datagen;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
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
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                offerFoodCookingRecipe("smelting", RecipeSerializer.SMELTING, SmeltingRecipe::new, 200, Items.MILK_BUCKET, ModItems.CURDLED_MILK_BUCKET, 0.35f);
                offerFoodCookingRecipe("smoking", RecipeSerializer.SMOKING, SmokingRecipe::new, 100, Items.MILK_BUCKET, ModItems.CURDLED_MILK_BUCKET, 0.35f);

                createShapeless(RecipeCategory.FOOD, ModItems.GBEJNA, 4)
                        .input(ModItems.CURDLED_MILK_BUCKET)
                        .criterion(hasItem(ModItems.CURDLED_MILK_BUCKET), conditionsFromItem(ModItems.CURDLED_MILK_BUCKET))
                        .offerTo(recipeExporter, "gbejna");

                createShapeless(RecipeCategory.FOOD, ModItems.PEPPERED_GBEJNA, 1)
                        .input(ModItems.GBEJNA)
                        .input(ModItems.PEPPERCORNS)
                        .criterion(hasItem(ModItems.GBEJNA), conditionsFromItem(ModItems.GBEJNA))
                        .criterion(hasItem(ModItems.PEPPERCORNS), conditionsFromItem(ModItems.PEPPERCORNS))
                        .offerTo(recipeExporter, "peppered_gbejna");
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
