package github.mattzmt.malta;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.entity.ModEntities;
import github.mattzmt.malta.entity.custom.SnailEntity;
import github.mattzmt.malta.item.ModItemGroups;
import github.mattzmt.malta.item.ModItems;
import github.mattzmt.malta.util.ModLootTableModifiers;
import github.mattzmt.malta.world.gen.ModFoliagePlacers;
import github.mattzmt.malta.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Malta implements ModInitializer {
	public static final String MOD_ID = "malta";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Malta mod initialised");

        ModItems.load();
        ModItemGroups.load();
        ModBlocks.load();
        ModFoliagePlacers.load();
        ModLootTableModifiers.modifyLootTables();
        ModWorldGeneration.generateModWorldGen();
        ModFoliagePlacers.load();
        ModEntities.registerModEntities();

        FabricDefaultAttributeRegistry.register(ModEntities.SNAIL, SnailEntity.createAttributes());

        CompostingChanceRegistry.INSTANCE.add(ModItems.PEPPERCORNS, 0.2f);

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> factories.add((entity, random) -> new TradeOffer(
                new TradedItem(Items.EMERALD, 2),
                new ItemStack(ModItems.PEPPERCORNS, 20),
                16,
                2,
                0.04f)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> factories.add((entity, random) -> new TradeOffer(
                new TradedItem(ModItems.PEPPERCORNS, 26),
                new ItemStack(Items.EMERALD, 1),
                16,
                2,
                0.04f)));

        StrippableBlockRegistry.register(ModBlocks.DATE_PALM_LOG, ModBlocks.STRIPPED_DATE_PALM_LOG);
        StrippableBlockRegistry.register(ModBlocks.DATE_PALM_WOOD, ModBlocks.STRIPPED_DATE_PALM_WOOD);
        StrippableBlockRegistry.register(ModBlocks.OLIVE_LOG, ModBlocks.STRIPPED_OLIVE_LOG);
        StrippableBlockRegistry.register(ModBlocks.OLIVE_WOOD, ModBlocks.STRIPPED_OLIVE_WOOD);

        makeFlammable(ModBlocks.DATE_BUNCH);
        makeFlammable(ModBlocks.DATE_PALM_LEAVES, 30, 60);
        makeFlammable(ModBlocks.DATE_PALM_LOG);
        makeFlammable(ModBlocks.DATE_PALM_WOOD);
        makeFlammable(ModBlocks.STRIPPED_DATE_PALM_LOG);
        makeFlammable(ModBlocks.STRIPPED_DATE_PALM_WOOD);
        makeFlammable(ModBlocks.DATE_PALM_PLANKS, 5, 20);
        makeFlammable(ModBlocks.DATE_PALM_SAPLING);
        makeFlammable(ModBlocks.OLIVE_LEAVES, 30, 60);
        makeFlammable(ModBlocks.OLIVE_LOG);
        makeFlammable(ModBlocks.OLIVE_WOOD);
        makeFlammable(ModBlocks.STRIPPED_OLIVE_LOG);
        makeFlammable(ModBlocks.STRIPPED_OLIVE_WOOD);
        makeFlammable(ModBlocks.OLIVE_PLANKS, 5, 20);
        makeFlammable(ModBlocks.OLIVE_SAPLING);
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }

    private static void makeFlammable(Block block) {
        FlammableBlockRegistry.getDefaultInstance().add(block, 5, 5);
    }
    private static void makeFlammable(Block block, int burn, int spread) {
        FlammableBlockRegistry.getDefaultInstance().add(block, burn, spread);
    }
}