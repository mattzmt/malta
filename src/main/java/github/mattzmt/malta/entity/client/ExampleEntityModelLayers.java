package github.mattzmt.malta.entity.client;

import github.mattzmt.malta.Malta;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class ExampleEntityModelLayers {
    public static EntityModelLayer EXAMPLE_ENTITY = new EntityModelLayer(Malta.id("example_entity"), "main");
    public static EntityModelLayer EXAMPLE_ENTITY_BABY = new EntityModelLayer(Malta.id("example_entity_baby"), "main");

    public static void registerLayers() {
        EntityModelLayerRegistry.registerModelLayer(EXAMPLE_ENTITY, ExampleEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EXAMPLE_ENTITY_BABY, ExampleEntityModel::getTexturedModelData);
    }
}
