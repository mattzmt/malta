package github.mattzmt.malta.world.gen;

import github.mattzmt.malta.Malta;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacers {
    public static final FoliagePlacerType<PalmFoliagePlacer> PALM_FOLIAGE_PLACER =
            Registry.register(
                    Registries.FOLIAGE_PLACER_TYPE,
                    Malta.id("date_palm_placer"),
                    new FoliagePlacerType<>(PalmFoliagePlacer.CODEC)
            );

    private static <P extends net.minecraft.world.gen.foliage.FoliagePlacer> FoliagePlacerType<P> register(
            String name,
            FoliagePlacerType<P> type
    ) {
        return Registry.register(Registries.FOLIAGE_PLACER_TYPE, Malta.id(name), type);
    }

    public static void load() {
        // Call this once during mod initialization (e.g., in your ModInitializer).
    }
}
