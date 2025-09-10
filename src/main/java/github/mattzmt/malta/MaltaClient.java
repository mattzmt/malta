package github.mattzmt.malta;

import github.mattzmt.malta.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaltaClient implements ClientModInitializer {
    public static final String MOD_ID = "malta";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Malta mod initialised on the client");
        BlockRenderLayerMap.putBlock(ModBlocks.BLACK_PEPPER_CROP, BlockRenderLayer.CUTOUT);
    }
}
