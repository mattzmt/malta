package github.mattzmt.malta.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.ClearAllEffectsConsumeEffect;

import java.util.List;

import static net.minecraft.component.type.ConsumableComponents.drink;
import static net.minecraft.component.type.ConsumableComponents.food;

public class ModConsumableComponents {
    public static final ConsumableComponent CURDLED_MILK_BUCKET = drink()
            .consumeEffect(ClearAllEffectsConsumeEffect.INSTANCE)
            .build();

    public static final ConsumableComponent GBEJNA = food()
            .consumeSeconds(1f)
            .consumeEffect(new ApplyEffectsConsumeEffect(List.of(
                    new StatusEffectInstance(StatusEffects.REGENERATION, 5 * 20, 0))))
            .build();

    public static final ConsumableComponent PEPPERED_GBEJNA = food()
            .consumeSeconds(1f)
            .consumeEffect(new ApplyEffectsConsumeEffect(List.of(
                    new StatusEffectInstance(StatusEffects.REGENERATION, 5 * 20, 0),
                    new StatusEffectInstance(StatusEffects.HASTE, 10 * 20, 0))))
            .build();

    public static final ConsumableComponent PEPPERCORNS = food()
            .consumeSeconds(0.4f)
            .consumeEffect(new ApplyEffectsConsumeEffect(List.of(
                    new StatusEffectInstance(StatusEffects.HASTE, 10 * 20, 0))))
            .build();
}