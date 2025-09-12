package github.mattzmt.malta.item;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.block.ModBlocks;
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
                entries.add(ModItems.DOUGH);
                entries.add(ModItems.GALLETTA);

                entries.add(ModBlocks.DATE_PALM_LEAVES);
                entries.add(ModBlocks.DATE_BUNCH);
                entries.add(ModBlocks.DATE_PALM_LOG);
                entries.add(ModBlocks.DATE_PALM_WOOD);
                entries.add(ModBlocks.STRIPPED_DATE_PALM_LOG);
                entries.add(ModBlocks.STRIPPED_DATE_PALM_WOOD);
                entries.add(ModBlocks.DATE_PALM_PLANKS);
                entries.add(ModBlocks.DATE_PALM_SAPLING.asItem());
                entries.add(ModItems.DATES);
            }).build()
    );

    public static <T extends ItemGroup> T register(String name, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, Malta.id(name), itemGroup);
    }

    public static void load() {
    }
}