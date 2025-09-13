package github.mattzmt.malta.datagen.lang;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.item.ModItemGroups;
import github.mattzmt.malta.item.ModItems;
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
        //ITEM GROUPS
        addText(translationBuilder, ModItemGroups.MALTA_GROUP_TITLE, "Malta");

        //ITEMS
        translationBuilder.add(ModItems.CURDLED_MILK_BUCKET, "Curdled Milk Bucket");
        translationBuilder.add(ModItems.GBEJNA, "Ġbejna");
        translationBuilder.add(ModItems.PEPPERED_GBEJNA, "Peppered Ġbejna");
        translationBuilder.add(ModItems.PEPPERCORNS, "Peppercorns");
        translationBuilder.add(ModItems.DOUGH, "Dough");
        translationBuilder.add(ModItems.DATES, "Dates");
        translationBuilder.add(ModItems.IMQARET, "Imqaret");
        translationBuilder.add(ModItems.GALLETTA, "Galletta");
        translationBuilder.add(ModItems.SALMON_DIP, "Smoked Salmon Dip");
        translationBuilder.add(ModItems.SALMON_DIPPED_GALLETTA, "Smoked Salmon dipped Galletta");
        translationBuilder.add(ModItems.BIGILLA, "Bigilla");
        translationBuilder.add(ModItems.BIGILLA_DIPPED_GALLETTA, "Bigilla dipped Galletta");

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
    }
}