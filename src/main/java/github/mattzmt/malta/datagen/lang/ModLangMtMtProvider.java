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

public class ModLangMtMtProvider extends FabricLanguageProvider {
    public ModLangMtMtProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "mt_mt", registryLookup);
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
        addText(translationBuilder, ModBiomes.MAQUIS_TITLE, "Makkja");

        //ITEM GROUPS
        addText(translationBuilder, ModItemGroups.MALTA_GROUP_TITLE, "Malta");

        //ITEMS
        translationBuilder.add(ModItems.CURDLED_MILK_BUCKET, "Barmil tal-Ħalib Imbaqqat");
        translationBuilder.add(ModItems.GBEJNA, "Ġbejna");
        translationBuilder.add(ModItems.PEPPERED_GBEJNA, "Ġbejna tal-Bżar");
        translationBuilder.add(ModItems.PEPPERCORNS, "Żerriegħa tal-Bżar");
        translationBuilder.add(ModItems.DOUGH, "Għaġina");
        translationBuilder.add(ModItems.DATES, "Tamal");
        translationBuilder.add(ModItems.MAQRUT, "Maqrut");
        translationBuilder.add(ModItems.OLIVE, "Żebbuġa");
        translationBuilder.add(ModItems.OLIVE_OIL, "Żejt taż-Żebbuġ");
        translationBuilder.add(ModItems.GALLETTA, "Galletta");
        translationBuilder.add(ModItems.SALMON_DIP, "Dip tas-Salamun Affumikat");
        translationBuilder.add(ModItems.SALMON_DIPPED_GALLETTA, "Galletta b'dip tas-Salamun Affumikat");
        translationBuilder.add(ModItems.BIGILLA, "Bigilla");
        translationBuilder.add(ModItems.BIGILLA_DIPPED_GALLETTA, "Galletta bil-Bigilla");
        translationBuilder.add(ModItems.GBEJNA_DIP, "Dip tal-Ġbejniet");
        translationBuilder.add(ModItems.GBEJNA_DIPPED_GALLETTA, "Galletta b'dip tal-Ġbejniet");
        translationBuilder.add(ModItems.SNAIL_SPAWN_EGG, "Bajda tal-Bebbux");
        translationBuilder.add(ModItems.RAW_SNAIL, "Bebbuxu Nej");
        translationBuilder.add(ModItems.COOKED_SNAIL, "Bebbuxu Msajjar");
        translationBuilder.add(ModItems.SNAIL_SHELL, "Qoxra tal-Bebbux");

        //BLOCKS
        translationBuilder.add(ModBlocks.BLACK_PEPPER_CROP, "Żargħa tal-Bżar");
        translationBuilder.add(ModBlocks.DATE_BUNCH, "Għanqud tat-Tamal");
        translationBuilder.add(ModBlocks.DATE_PALM_LEAVES, "Weraq Tamri");
        translationBuilder.add(ModBlocks.DATE_PALM_LOG, "Zokk Tamri");
        translationBuilder.add(ModBlocks.DATE_PALM_WOOD, "Injam Tamri");
        translationBuilder.add(ModBlocks.STRIPPED_DATE_PALM_LOG, "Zokk Tamri Mqaxxar");
        translationBuilder.add(ModBlocks.STRIPPED_DATE_PALM_WOOD, "Injam Tamri Mqaxxar");
        translationBuilder.add(ModBlocks.DATE_PALM_PLANKS, "Twavel Tamri");
        translationBuilder.add(ModBlocks.DATE_PALM_SAPLING, "Nebbieta tat-Tamra");
        translationBuilder.add(ModBlocks.OLIVE_LEAVES, "Weraq tas-Żebbuġ");
        translationBuilder.add(ModBlocks.OLIVE_LOG, "Zokk taż-Żebbuġ");
        translationBuilder.add(ModBlocks.OLIVE_WOOD, "Injam taż-Żebbuġ");
        translationBuilder.add(ModBlocks.STRIPPED_OLIVE_LOG, "Zokk taż-Żebbuġ Imqaxxar");
        translationBuilder.add(ModBlocks.STRIPPED_OLIVE_WOOD, "Injam taż-Żebbuġ Imqaxxar");
        translationBuilder.add(ModBlocks.OLIVE_PLANKS, "Twavel taż-Żebbuġ");
        translationBuilder.add(ModBlocks.OLIVE_SAPLING, "Nebbieta taż-Żebbuġ");
        translationBuilder.add(ModBlocks.SLIME_TRAIL, "Mogħdija Żliqija");
        translationBuilder.add(ModBlocks.SNAIL_SHELL, "Qoxra tal-Bebbux");

        //ENTITIES
        translationBuilder.add(ModEntities.SNAIL, "Bebbuxu");

		//SOUNDS
		translationBuilder.add("subtitles.malta.snail_hit", "Bebbuxu jitweġġa'");
		translationBuilder.add("subtitles.malta.snail_shell_crack", "Qoxra tal-bebbux tixxaqqaq");
		translationBuilder.add("subtitles.malta.snail_death", "Bebbuxu jmut");
    }
}