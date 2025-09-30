package github.mattzmt.malta.world.gen;

import github.mattzmt.malta.entity.ModEntities;
import github.mattzmt.malta.world.biome.ModBiomes;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.MEADOW, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP, ModBiomes.MAQUIS), SpawnGroup.CREATURE, ModEntities.SNAIL, 4, 1, 3);
        SpawnRestriction.register(ModEntities.SNAIL, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}