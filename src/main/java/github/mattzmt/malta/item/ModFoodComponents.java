package github.mattzmt.malta.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CURDLED_MILK_BUCKET = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.25f)
            .alwaysEdible()
            .build();

    public static final FoodComponent GBEJNA = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.25f)
            .build();

    public static final FoodComponent PEPPERCORNS = new FoodComponent.Builder()
            .nutrition(1)
            .alwaysEdible()
            .build();

    public static final FoodComponent DOUGH = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.25f)
            .build();

    public static final FoodComponent DATES = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.16f)
            .build();

    public static final FoodComponent MAQRUT = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.3f)
            .build();

    public static final FoodComponent OLIVE = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.125f)
            .build();

    public static final FoodComponent GALLETTA = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.25f)
            .build();
}