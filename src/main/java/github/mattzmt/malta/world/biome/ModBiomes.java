package github.mattzmt.malta.world.biome;

import github.mattzmt.malta.Malta;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.text.Text;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModBiomes {
    public static final Text MAQUIS_TITLE = Text.translatable("biome." + Malta.MOD_ID + ".maquis");
    public static final RegistryKey<Biome> MAQUIS = RegistryKey.of(RegistryKeys.BIOME, Malta.id("maquis"));

    public static void bootstrap(Registerable<Biome> context) {
        context.register(MAQUIS, maquis(context));
    }

    private static void addBasicFeatures(GenerationSettings.LookupBackedBuilder generationSettings) {
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
    }

    private static void addMaquisVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_CACTUS_DECORATED);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_FIREFLY_BUSH_NEAR_WATER);
    }

    public static Biome maquis(Registerable<Biome> context) {
        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, 8, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 1, 6));
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        DefaultBiomeFeatures.addFossils(biomeBuilder);
        addBasicFeatures(biomeBuilder);
        DefaultBiomeFeatures.addPlainsTallGrass(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addDefaultDisks(biomeBuilder);
        DefaultBiomeFeatures.addInfestedStone(biomeBuilder);
        DefaultBiomeFeatures.addBushes(biomeBuilder);
        DefaultBiomeFeatures.addPlainsFeatures(biomeBuilder);
        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        addMaquisVegetation(biomeBuilder);
        DefaultBiomeFeatures.addSweetBerryBushes(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.2f)
                .temperature(0.9f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x56A9ED)
                        .waterFogColor(0x56A9ED)
                        .grassColor(0x9ABE4B)
                        .foliageColor(0x82AC1E)
                        .skyColor(0x78A7FF)
                        .fogColor(0x78A7FF)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .build();
    }
}