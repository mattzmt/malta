package github.mattzmt.malta.block;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.block.custom.BlackPepperCropBlock;
import github.mattzmt.malta.item.ModItems;
import github.mattzmt.malta.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {
    private static final RegistryKey<Block> BLACK_PEPPER_CROP_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("black_pepper_crop"));
    public static final Block BLACK_PEPPER_CROP = register(
            "black_pepper_crop",
            new BlackPepperCropBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .registryKey(BLACK_PEPPER_CROP_KEY)));

    private static final RegistryKey<Block> DATE_BUNCH_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("date_bunch"));
    public static final Block DATE_BUNCH = registerWithItem(
            "date_bunch",
            DATE_BUNCH_KEY,
            new HangingRootsBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_ORANGE)
                    .breakInstantly()
                    .sounds(BlockSoundGroup.WART_BLOCK)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .registryKey(DATE_BUNCH_KEY)));

    private static final RegistryKey<Block> DATE_PALM_LEAVES_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("date_palm_leaves"));
    public static final Block DATE_PALM_LEAVES = registerWithItem(
            "date_palm_leaves",
            DATE_PALM_LEAVES_KEY,
            new TintedParticleLeavesBlock(0, AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)
                    .registryKey(DATE_PALM_LEAVES_KEY)));

    private static final RegistryKey<Block> DATE_PALM_LOG_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("date_palm_log"));
    public static final Block DATE_PALM_LOG = registerWithItem(
            "date_palm_log",
            DATE_PALM_LOG_KEY,
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).registryKey(DATE_PALM_LOG_KEY)));

    private static final RegistryKey<Block> DATE_PALM_WOOD_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("date_palm_wood"));
    public static final Block DATE_PALM_WOOD = registerWithItem(
            "date_palm_wood",
            DATE_PALM_WOOD_KEY,
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).registryKey(DATE_PALM_WOOD_KEY)));

    private static final RegistryKey<Block> STRIPPED_DATE_PALM_LOG_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("stripped_date_palm_log"));
    public static final Block STRIPPED_DATE_PALM_LOG = registerWithItem(
            "stripped_date_palm_log",
            STRIPPED_DATE_PALM_LOG_KEY,
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).registryKey(STRIPPED_DATE_PALM_LOG_KEY)));

    private static final RegistryKey<Block> STRIPPED_DATE_PALM_WOOD_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("stripped_date_palm_wood"));
    public static final Block STRIPPED_DATE_PALM_WOOD = registerWithItem(
            "stripped_date_palm_wood",
            STRIPPED_DATE_PALM_WOOD_KEY,
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).registryKey(STRIPPED_DATE_PALM_WOOD_KEY)));

    private static final RegistryKey<Block> DATE_PALM_PLANKS_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("date_palm_planks"));
    public static final Block DATE_PALM_PLANKS = registerWithItem(
            "date_palm_planks",
            DATE_PALM_PLANKS_KEY,
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).registryKey(DATE_PALM_PLANKS_KEY)));

    private static final RegistryKey<Block> DATE_PALM_SAPLING_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("date_palm_sapling"));
    public static final Block DATE_PALM_SAPLING = registerWithItem(
            "date_palm_sapling",
            DATE_PALM_SAPLING_KEY,
            new SaplingBlock(ModSaplingGenerators.DATE_PALM, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).registryKey(DATE_PALM_SAPLING_KEY)));

    private static final RegistryKey<Block> OLIVE_LEAVES_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("olive_leaves"));
    public static final Block OLIVE_LEAVES = registerWithItem(
            "olive_leaves",
            OLIVE_LEAVES_KEY,
            new TintedParticleLeavesBlock(0, AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)
                    .registryKey(OLIVE_LEAVES_KEY)));

    private static final RegistryKey<Block> OLIVE_LOG_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("olive_log"));
    public static final Block OLIVE_LOG = registerWithItem(
            "olive_log",
            OLIVE_LOG_KEY,
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).registryKey(OLIVE_LOG_KEY)));

    private static final RegistryKey<Block> OLIVE_WOOD_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("olive_wood"));
    public static final Block OLIVE_WOOD = registerWithItem(
            "olive_wood",
            OLIVE_WOOD_KEY,
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).registryKey(OLIVE_WOOD_KEY)));

    private static final RegistryKey<Block> STRIPPED_OLIVE_LOG_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("stripped_olive_log"));
    public static final Block STRIPPED_OLIVE_LOG = registerWithItem(
            "stripped_olive_log",
            STRIPPED_OLIVE_LOG_KEY,
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).registryKey(STRIPPED_OLIVE_LOG_KEY)));

    private static final RegistryKey<Block> STRIPPED_OLIVE_WOOD_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("stripped_olive_wood"));
    public static final Block STRIPPED_OLIVE_WOOD = registerWithItem(
            "stripped_olive_wood",
            STRIPPED_OLIVE_WOOD_KEY,
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).registryKey(STRIPPED_OLIVE_WOOD_KEY)));

    private static final RegistryKey<Block> OLIVE_PLANKS_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("olive_planks"));
    public static final Block OLIVE_PLANKS = registerWithItem(
            "olive_planks",
            OLIVE_PLANKS_KEY,
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).registryKey(OLIVE_PLANKS_KEY)));

    private static final RegistryKey<Block> OLIVE_SAPLING_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("olive_sapling"));
    public static final Block OLIVE_SAPLING = registerWithItem(
            "olive_sapling",
            OLIVE_SAPLING_KEY,
            new SaplingBlock(ModSaplingGenerators.OLIVE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).registryKey(OLIVE_SAPLING_KEY)));

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, Malta.id(name), block);
    }

    public static <T extends Block> T registerWithItem(String name, RegistryKey registryKey, T block, Item.Settings settings) {
        T registered = register(name, block);
        ModItems.register(name, new BlockItem(registered, settings.useBlockPrefixedTranslationKey().registryKey(registryKey)));
        return registered;
    }

    public static <T extends Block> T registerWithItem(String name, RegistryKey registryKey, T block) {
        return registerWithItem(name, registryKey, block, new Item.Settings());
    }

    public static void load() {
    }
}