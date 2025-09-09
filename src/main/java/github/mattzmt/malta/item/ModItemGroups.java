package github.mattzmt.malta.item;

import github.mattzmt.malta.Malta;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ModItemGroups {
    public static final Text MALTA_GROUP_TITLE = Text.translatable("itemGroup." + Malta.MOD_ID + ".nev_group");
    public static final ItemGroup MALTA_GROUP = register("malta_group", FabricItemGroup.builder()
            .displayName(MALTA_GROUP_TITLE)
            .icon(ModItems.PEPPERED_GBEJNA::getDefaultStack)
            .entries((displayContext, entries) -> {
                entries.add(ModItems.CURDLED_MILK_BUCKET);
                entries.add(ModItems.GBEJNA);
                entries.add(ModItems.PEPPERED_GBEJNA);
                entries.add(ModItems.PEPPERCORNS);
            }).build()
    );

    public static <T extends ItemGroup> T register(String name, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, Malta.id(name), itemGroup);
    }

    public static void load() {
    }
}