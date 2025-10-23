package github.mattzmt.malta.entity;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.entity.custom.ExampleEntityEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> EXAMPLE_ENTITY_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Malta.id("example_entity"));

    public static final EntityType<ExampleEntityEntity> EXAMPLE_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Malta.id("example_entity"),
            EntityType.Builder.create(ExampleEntityEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.6f, 0.6f).build(EXAMPLE_ENTITY_KEY));

    public static void registerModEntities() {
        Malta.LOGGER.info("Registering mod entities for "+Malta.MOD_ID);
    }
}