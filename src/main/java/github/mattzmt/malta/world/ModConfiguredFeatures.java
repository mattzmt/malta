package github.mattzmt.malta.world;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.world.gen.PalmFoliagePlacer;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLeavesTreeDecorator;
import net.minecraft.world.gen.treedecorator.AttachedToLogsTreeDecorator;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> DATE_PALM_KEY = registryKey("date_palm");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, DATE_PALM_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.DATE_PALM_LOG),
                new BendingTrunkPlacer(6, 0, 0, 5, ConstantIntProvider.create(1)),

                BlockStateProvider.of(ModBlocks.DATE_PALM_LEAVES),
                new PalmFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2)),

                new TwoLayersFeatureSize(1, 0, 2)).decorators(List.of(
                new AttachedToLogsTreeDecorator(
                        1,
                        BlockStateProvider.of(ModBlocks.DATE_BUNCH),
                        List.of(Direction.DOWN)))).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Malta.id(name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
