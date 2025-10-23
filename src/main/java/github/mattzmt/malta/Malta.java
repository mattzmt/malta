package github.mattzmt.malta;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.entity.ModEntities;
import github.mattzmt.malta.item.ModItemGroups;
import github.mattzmt.malta.item.ModItems;
import github.mattzmt.malta.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Malta implements ModInitializer {
	public static final String MOD_ID = "malta";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Malta mod initialised");

        ModItems.load();
        ModItemGroups.load();
        ModBlocks.load();
        ModEntities.registerModEntities();
		ModSounds.registerSounds();
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }

    private static void makeFlammable(Block block) {
        FlammableBlockRegistry.getDefaultInstance().add(block, 5, 5);
    }

    private static void makeFlammable(Block block, int burn, int spread) {
        FlammableBlockRegistry.getDefaultInstance().add(block, burn, spread);
    }
}