package github.mattzmt.malta.block;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.block.custom.BlackPepperCropBlock;
import github.mattzmt.malta.block.custom.SlimeTrailBlock;
import github.mattzmt.malta.block.custom.SnailShellBlock;
import github.mattzmt.malta.item.ModItems;
import github.mattzmt.malta.sound.ModSounds;
import github.mattzmt.malta.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {
    public static final Block BLACK_PEPPER_CROP = register(
            "black_pepper_crop",
            new BlackPepperCropBlock(newSettings("black_pepper_crop")
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block DATE_BUNCH = registerWithItem(
            "date_bunch",
            new HangingRootsBlock(newSettings("date_bunch")
                    .mapColor(MapColor.TERRACOTTA_ORANGE)
                    .breakInstantly()
                    .sounds(BlockSoundGroup.WART_BLOCK)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block DATE_PALM_LEAVES = registerWithItem(
            "date_palm_leaves",
            new TintedParticleLeavesBlock(0, newSettings("date_palm_leaves")
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
                    .solidBlock(Blocks::never)));

    public static final Block DATE_PALM_LOG = registerWithItem(
            "date_palm_log",
            new PillarBlock(copySettings(Blocks.OAK_LOG, "date_palm_log")));

    public static final Block DATE_PALM_WOOD = registerWithItem(
            "date_palm_wood",
            new PillarBlock(copySettings(Blocks.OAK_WOOD, "date_palm_wood")));

    public static final Block STRIPPED_DATE_PALM_LOG = registerWithItem(
            "stripped_date_palm_log",
            new PillarBlock(copySettings(Blocks.STRIPPED_OAK_LOG, "stripped_date_palm_log")));

    public static final Block STRIPPED_DATE_PALM_WOOD = registerWithItem(
            "stripped_date_palm_wood",
            new PillarBlock(copySettings(Blocks.STRIPPED_OAK_WOOD, "stripped_date_palm_wood")));

    public static final Block DATE_PALM_PLANKS = registerWithItem(
            "date_palm_planks",
            new Block(copySettings(Blocks.OAK_PLANKS, "date_palm_planks")));

    public static final Block DATE_PALM_SAPLING = registerWithItem(
            "date_palm_sapling",
            new SaplingBlock(ModSaplingGenerators.DATE_PALM, copySettings(Blocks.OAK_SAPLING, "date_palm_sapling")));

    public static final Block OLIVE_LEAVES = registerWithItem(
            "olive_leaves",
            new TintedParticleLeavesBlock(0, newSettings("olive_leaves")
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
                    .solidBlock(Blocks::never)));

    public static final Block OLIVE_LOG = registerWithItem(
            "olive_log",
            new PillarBlock(copySettings(Blocks.OAK_LOG, "olive_log")));

    public static final Block OLIVE_WOOD = registerWithItem(
            "olive_wood",
            new PillarBlock(copySettings(Blocks.OAK_WOOD, "olive_wood")));

    public static final Block STRIPPED_OLIVE_LOG = registerWithItem(
            "stripped_olive_log",
            new PillarBlock(copySettings(Blocks.STRIPPED_OAK_LOG, "stripped_olive_log")));

    public static final Block STRIPPED_OLIVE_WOOD = registerWithItem(
            "stripped_olive_wood",
            new PillarBlock(copySettings(Blocks.STRIPPED_OAK_WOOD, "stripped_olive_wood")));

    public static final Block OLIVE_PLANKS = registerWithItem(
            "olive_planks",
            new Block(copySettings(Blocks.OAK_PLANKS, "olive_planks")));

    public static final Block OLIVE_SAPLING = registerWithItem(
            "olive_sapling",
            new SaplingBlock(ModSaplingGenerators.OLIVE, copySettings(Blocks.OAK_SAPLING, "olive_sapling")));

    public static final Block SLIME_TRAIL = register(
            "slime_trail",
            new SlimeTrailBlock(
					newSettings("slime_trail")
                    	.mapColor(MapColor.PALE_GREEN)
                    	.sounds(BlockSoundGroup.SLIME)
                    	.nonOpaque()
                    	.noCollision()
                    	.pistonBehavior(PistonBehavior.DESTROY)
						.replaceable()));

	public static final Block SNAIL_SHELL = register(
			"snail_shell",
			new SnailShellBlock(
					newSettings("snail_shell")
							.mapColor(MapColor.TERRACOTTA_BROWN)
							.nonOpaque()
							.pistonBehavior(PistonBehavior.DESTROY)
							.breakInstantly()
			));

    private static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, Malta.id(name), block);}

    private static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block);
        ModItems.register(name, new BlockItem(registered, settings.useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, Malta.id(name)))));
        return registered;}

    private static <T extends Block> T registerWithItem(String name, T block) {
        return registerWithItem(name, block, new Item.Settings());}

    private static AbstractBlock.Settings newSettings(String name) {
        return AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Malta.id(name)));}

    private static AbstractBlock.Settings copySettings(AbstractBlock block, String name) {
        return AbstractBlock.Settings.copy(block).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Malta.id(name)));}

    public static void load() {}
}