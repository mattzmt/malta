package github.mattzmt.malta.world.tree;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator DATE_PALM = new SaplingGenerator(Malta.MOD_ID + ":date_palm",
            Optional.empty(), Optional.of(ModConfiguredFeatures.DATE_PALM_KEY), Optional.empty());
}
