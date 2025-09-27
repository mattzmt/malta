package github.mattzmt.malta.entity;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.entity.custom.SnailEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> SNAIL_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Malta.id("snail"));
    public static final EntityType<SnailEntity> SNAIL = Registry.register(Registries.ENTITY_TYPE,
            Malta.id("snail"),
            EntityType.Builder.create(SnailEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.8f, 0.6f).build(SNAIL_KEY));

    public static void registerModEntities() {
        Malta.LOGGER.info("Registering mod entities for "+Malta.MOD_ID);
    }
}