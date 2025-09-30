package github.mattzmt.malta.entity.client;

import github.mattzmt.malta.Malta;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class SnailModelLayers {
    public static EntityModelLayer SNAIL = new EntityModelLayer(Malta.id("snail"), "main");
    public static EntityModelLayer SNAIL_BABY = new EntityModelLayer(Malta.id("snail_baby"), "main");

    public static void registerLayers() {
        EntityModelLayerRegistry.registerModelLayer(SNAIL, SnailModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SNAIL_BABY, SnailModel::getTexturedModelData);
    }
}
