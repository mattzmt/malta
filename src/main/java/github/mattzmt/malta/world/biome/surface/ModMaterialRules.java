package github.mattzmt.malta.world.biome.surface;

import github.mattzmt.malta.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule SANDSTONE = makeStateRule(Blocks.SANDSTONE);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.condition(
                MaterialRules.surface(),
                MaterialRules.sequence(
                        MaterialRules.condition(
                                isAtOrAboveWaterLevel,
                                GRASS_BLOCK),
                        DIRT));

        MaterialRules.MaterialRule sandstonePatches = MaterialRules.condition(
                MaterialRules.biome(ModBiomes.MAQUIS),
                MaterialRules.condition(
                        MaterialRules.surface(),
                        MaterialRules.condition(
                                MaterialRules.noiseThreshold(NoiseParametersKeys.GRAVEL, -0.05, 0.05),
                                SANDSTONE
                        )
                )
        );

        return MaterialRules.sequence(
                sandstonePatches,
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}