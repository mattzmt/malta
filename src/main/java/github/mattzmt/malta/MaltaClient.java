package github.mattzmt.malta;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.entity.ModEntities;
import github.mattzmt.malta.entity.client.SnailModelLayers;
import github.mattzmt.malta.entity.client.SnailRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.BlockRenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaltaClient implements ClientModInitializer {
    public static final String MOD_ID = "malta";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static int blendColors(int c1, int c2, float ratio) {
        float inv = 1.0f - ratio;
        int r = (int)(((c1 >> 16 & 0xFF) * inv) + ((c2 >> 16 & 0xFF) * ratio));
        int g = (int)(((c1 >> 8 & 0xFF) * inv) + ((c2 >> 8 & 0xFF) * ratio));
        int b = (int)(((c1 & 0xFF) * inv) + ((c2 & 0xFF) * ratio));
        return (r << 16) | (g << 8) | b;
    }

    @Override
    public void onInitializeClient() {
        LOGGER.info("Malta mod initialised on the client");

        BlockRenderLayerMap.putBlock(ModBlocks.BLACK_PEPPER_CROP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.DATE_BUNCH, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.DATE_PALM_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.OLIVE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.SLIME_TRAIL, BlockRenderLayer.TRANSLUCENT);

		SnailModelLayers.registerLayers();
        EntityRendererRegistry.register(ModEntities.SNAIL, SnailRenderer::new);

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                int biomeColor = BiomeColors.getFoliageColor(world, pos);

                int base = 0xA0C060;
                return blendColors(biomeColor, base, 0.5f);
            }
            return 0xA0C060;
        }, ModBlocks.DATE_PALM_LEAVES);

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                int biomeColor = BiomeColors.getFoliageColor(world, pos);

                int base = 0x9AA191;
                return blendColors(biomeColor, base, 0.5f);
            }
            return 0x9aa191;
        }, ModBlocks.OLIVE_LEAVES);
    }
}