package github.mattzmt.malta;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.item.ModConsumableComponents;
import github.mattzmt.malta.item.ModFoodComponents;
import github.mattzmt.malta.item.ModItemGroups;
import github.mattzmt.malta.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.client.render.BlockRenderLayer;
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

        CompostingChanceRegistry.INSTANCE.add(ModItems.PEPPERCORNS, 0.2f);

        BlockRenderLayerMap.putBlock(ModBlocks.BLACK_PEPPER_CROP, BlockRenderLayer.CUTOUT);
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}