package github.mattzmt.malta;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.item.ModItemGroups;
import github.mattzmt.malta.item.ModItems;
import github.mattzmt.malta.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.client.render.BlockRenderLayer;
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
        ModLootTableModifiers.modifyLootTables();

        CompostingChanceRegistry.INSTANCE.add(ModItems.PEPPERCORNS, 0.2f);

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 3),
                    new ItemStack(ModItems.PEPPERCORNS, 20),
                    16,
                    2,
                    0.04f));
        });
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}