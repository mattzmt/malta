package github.mattzmt.malta.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CURDLED_MILK_BUCKET = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.1f)
            .alwaysEdible()
            .build();

    public static final FoodComponent GBEJNA = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.6f)
            .build();

    public static final FoodComponent PEPPERED_GBEJNA = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.6f)
            .build();

    public static final FoodComponent PEPPERCORNS = new FoodComponent.Builder()
            .nutrition(1)
            .alwaysEdible()
            .build();
}