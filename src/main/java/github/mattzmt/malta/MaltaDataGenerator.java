package github.mattzmt.malta;

import github.mattzmt.malta.datagen.ModLootTableProvider;
import github.mattzmt.malta.datagen.ModModelProvider;
import github.mattzmt.malta.datagen.ModRecipeProvider;
import github.mattzmt.malta.datagen.lang.ModLangEnUsProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MaltaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModLangEnUsProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
	}
}
