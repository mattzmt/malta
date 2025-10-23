package github.mattzmt.malta.item;

import github.mattzmt.malta.Malta;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItemGroups {


    public static <T extends ItemGroup> T register(String name, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, Malta.id(name), itemGroup);
    }

    public static void load() {
    }
}