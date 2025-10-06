package github.mattzmt.malta.datagen.lang;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.entity.ModEntities;
import github.mattzmt.malta.item.ModItemGroups;
import github.mattzmt.malta.item.ModItems;
import github.mattzmt.malta.world.biome.ModBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModLangEnUsProvider  extends FabricLanguageProvider {
    public ModLangEnUsProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    private static void addText(@NotNull TranslationBuilder builder, @NotNull Text text, @NotNull String value) {
        if(text.getContent() instanceof TranslatableTextContent translatableTextContent) {
            builder.add(translatableTextContent.getKey(), value);
        }else{
            Malta.LOGGER.warn("Failed to add translation for text: {}", text.getString());
        }
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        //BIOMES
        addText(translationBuilder, ModBiomes.MAQUIS_TITLE, "Maquis");

        //ITEM GROUPS
        addText(translationBuilder, ModItemGroups.MALTA_GROUP_TITLE, "Malta");

        //ITEMS
        translationBuilder.add(ModItems.CURDLED_MILK_BUCKET, "Curdled Milk Bucket");
        translationBuilder.add(ModItems.GBEJNA, "Ġbejna");
        translationBuilder.add(ModItems.PEPPERED_GBEJNA, "Peppered Ġbejna");
        translationBuilder.add(ModItems.PEPPERCORNS, "Peppercorns");
        translationBuilder.add(ModItems.DOUGH, "Dough");
        translationBuilder.add(ModItems.DATES, "Dates");
        translationBuilder.add(ModItems.MAQRUT, "Maqrut");
        translationBuilder.add(ModItems.OLIVE, "Olive");
        translationBuilder.add(ModItems.OLIVE_OIL, "Olive Oil");
        translationBuilder.add(ModItems.GALLETTA, "Galletta");
        translationBuilder.add(ModItems.SALMON_DIP, "Smoked Salmon Dip");
        translationBuilder.add(ModItems.SALMON_DIPPED_GALLETTA, "Smoked Salmon dipped Galletta");
        translationBuilder.add(ModItems.BIGILLA, "Bigilla");
        translationBuilder.add(ModItems.BIGILLA_DIPPED_GALLETTA, "Bigilla dipped Galletta");
        translationBuilder.add(ModItems.GBEJNA_DIP, "Ġbejna Dip");
        translationBuilder.add(ModItems.GBEJNA_DIPPED_GALLETTA, "Ġbejna dipped Galletta");
        translationBuilder.add(ModItems.SNAIL_SPAWN_EGG, "Snail Spawn Egg");
        translationBuilder.add(ModItems.RAW_SNAIL, "Raw Snail");
        translationBuilder.add(ModItems.COOKED_SNAIL, "Cooked Snail");
        translationBuilder.add(ModItems.SNAIL_SHELL, "Snail Shell");

        //BLOCKS
        translationBuilder.add(ModBlocks.BLACK_PEPPER_CROP, "Black Pepper Crop");
        translationBuilder.add(ModBlocks.DATE_BUNCH, "Date Bunch");
        translationBuilder.add(ModBlocks.DATE_PALM_LEAVES, "Date Palm Leaves");
        translationBuilder.add(ModBlocks.DATE_PALM_LOG, "Date Palm Log");
        translationBuilder.add(ModBlocks.DATE_PALM_WOOD, "Date Palm Wood");
        translationBuilder.add(ModBlocks.STRIPPED_DATE_PALM_LOG, "Stripped Date Palm Log");
        translationBuilder.add(ModBlocks.STRIPPED_DATE_PALM_WOOD, "Stripped Date Palm Wood");
        translationBuilder.add(ModBlocks.DATE_PALM_PLANKS, "Date Palm Planks");
        translationBuilder.add(ModBlocks.DATE_PALM_SAPLING, "Date Palm Sapling");
        translationBuilder.add(ModBlocks.OLIVE_LEAVES, "Olive Leaves");
        translationBuilder.add(ModBlocks.OLIVE_LOG, "Olive Log");
        translationBuilder.add(ModBlocks.OLIVE_WOOD, "Olive Wood");
        translationBuilder.add(ModBlocks.STRIPPED_OLIVE_LOG, "Stripped Olive Log");
        translationBuilder.add(ModBlocks.STRIPPED_OLIVE_WOOD, "Stripped Olive Wood");
        translationBuilder.add(ModBlocks.OLIVE_PLANKS, "Olive Planks");
        translationBuilder.add(ModBlocks.OLIVE_SAPLING, "Olive Sapling");
        translationBuilder.add(ModBlocks.SLIME_TRAIL, "Slime Trail");
        translationBuilder.add(ModBlocks.SNAIL_SHELL, "Snail Shell");

        //ENTITIES
        translationBuilder.add(ModEntities.SNAIL, "Snail");

		//SOUNDS
		translationBuilder.add("subtitles.malta.snail_hit", "Snail hurts");
		translationBuilder.add("subtitles.malta.snail_shell_crack", "Snail shell cracks");
		translationBuilder.add("subtitles.malta.snail_death", "Snail dies");
    }
}