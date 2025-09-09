package github.mattzmt.malta.block;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.block.custom.BlackPepperCropBlock;
import github.mattzmt.malta.item.ModItems;
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
    public static final RegistryKey<Block> BLACK_PEPPER_CROP_KEY = RegistryKey.of(RegistryKeys.BLOCK, Malta.id("black_pepper_crop"));
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

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, Malta.id(name), block);
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block);
        ModItems.register(name, new BlockItem(registered, settings));
        return registered;
    }

    public static <T extends Block> T registerWithItem(String name, T block) {
        return registerWithItem(name, block, new Item.Settings());
    }

    private static DoorBlock newModDoor(BlockSetType blockSetType, Block base, boolean isTransparent, float hardness, float resistance) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .mapColor(base.getDefaultMapColor())
                .instrument(base.getDefaultState().getInstrument())
                .strength(hardness, resistance)
                .pistonBehavior(PistonBehavior.DESTROY);

        if (isTransparent)
            settings.nonOpaque();

        if (base.getDefaultState().isBurnable())
            settings.burnable();

        return new DoorBlock(blockSetType, settings);
    }

    private static WallBlock newModWall(Block base) {
        return new WallBlock(AbstractBlock.Settings.copy(base).solid());
    }

    private static FenceBlock newModFence(Block base, float hardness, float resistance, BlockSoundGroup blockSoundGroup) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .mapColor(base.getDefaultMapColor())
                .instrument(base.getDefaultState().getInstrument())
                .strength(hardness, resistance)
                .sounds(blockSoundGroup);

        if (base.getDefaultState().isToolRequired())
            settings.requiresTool();

        if (base.getDefaultState().isBurnable())
            settings.burnable();

        return new FenceBlock(settings);
    }

    private static FenceBlock newModFence(Block base, float strength, BlockSoundGroup blockSoundGroup) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .mapColor(base.getDefaultMapColor())
                .instrument(base.getDefaultState().getInstrument())
                .strength(strength)
                .sounds(blockSoundGroup);

        if (base.getDefaultState().isToolRequired())
            settings.requiresTool();

        if (base.getDefaultState().isBurnable())
            settings.burnable();

        return new FenceBlock(settings);
    }

    private static FenceGateBlock newModFenceGate(WoodType woodType, Block base, float hardness, float resistance) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .mapColor(base.getDefaultMapColor())
                .instrument(base.getDefaultState().getInstrument())
                .solid()
                .strength(hardness, resistance);

        if (base.getDefaultState().isToolRequired())
            settings.requiresTool();

        if (base.getDefaultState().isBurnable())
            settings.burnable();

        return new FenceGateBlock(woodType, settings);
    }

    private static FenceGateBlock newModFenceGate(WoodType woodType, Block base, float strength) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .mapColor(base.getDefaultMapColor())
                .instrument(base.getDefaultState().getInstrument())
                .solid()
                .strength(strength);

        if (base.getDefaultState().isToolRequired())
            settings.requiresTool();

        if (base.getDefaultState().isBurnable())
            settings.burnable();

        return new FenceGateBlock(
                woodType, settings
        );
    }

    private static StairsBlock newModStairs(Block base) {
        return new StairsBlock(base.getDefaultState(), AbstractBlock.Settings.copy(base));
    }

    private static SlabBlock newModSlab(Block base, float hardness, float resistance, BlockSoundGroup blockSoundGroup) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .mapColor(base.getDefaultMapColor())
                .instrument(base.getDefaultState().getInstrument())
                .strength(hardness, resistance)
                .sounds(blockSoundGroup);

        if (base.getDefaultState().isToolRequired())
            settings.requiresTool();

        if (base.getDefaultState().isBurnable())
            settings.burnable();

        return new SlabBlock(settings);
    }

    private static TrapdoorBlock newModTrapdoor(BlockSetType blockSetType, Block base, float hardness, float resistance) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .mapColor(base.getDefaultMapColor())
                .instrument(base.getDefaultState().getInstrument())
                .strength(hardness, resistance)
                .allowsSpawning(Blocks::never);

        if (base.getDefaultState().isToolRequired())
            settings.requiresTool();

        return new TrapdoorBlock(blockSetType, settings);
    }

    private static PressurePlateBlock newModPressurePlate(BlockSetType blockSetType, Block base, float hardness, float resistance) {
        return new PressurePlateBlock(
                blockSetType,
                AbstractBlock.Settings.create()
                        .mapColor(base.getDefaultMapColor())
                        .instrument(base.getDefaultState().getInstrument())
                        .solid()
                        .noCollision()
                        .strength(hardness, resistance)
                        .pistonBehavior(PistonBehavior.DESTROY));
    }

    private static PressurePlateBlock newModPressurePlate(BlockSetType blockSetType, Block base, float strength) {
        return new PressurePlateBlock(
                blockSetType,
                AbstractBlock.Settings.create()
                        .mapColor(base.getDefaultMapColor())
                        .instrument(base.getDefaultState().getInstrument())
                        .solid()
                        .noCollision()
                        .strength(strength)
                        .pistonBehavior(PistonBehavior.DESTROY));
    }

    private static PressurePlateBlock newModPressurePlate(BlockSetType blockSetType, Block base) {
        return new PressurePlateBlock(
                blockSetType,
                AbstractBlock.Settings.create()
                        .mapColor(base.getDefaultMapColor())
                        .instrument(base.getDefaultState().getInstrument())
                        .solid()
                        .noCollision()
                        .strength(0.5f)
                        .pistonBehavior(PistonBehavior.DESTROY));
    }

    private static ButtonBlock newModButton(BlockSetType blockSetType, int pressTicks, Block base, float hardness, float resistance) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .mapColor(base.getDefaultMapColor())
                .instrument(base.getDefaultState().getInstrument())
                .noCollision()
                .strength(hardness, resistance)
                .pistonBehavior(PistonBehavior.DESTROY);

        return new ButtonBlock(blockSetType, pressTicks, settings);
    }

    private static ButtonBlock newModButton(BlockSetType blockSetType, int pressTicks, Block base, float strength) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .mapColor(base.getDefaultMapColor())
                .instrument(base.getDefaultState().getInstrument())
                .noCollision()
                .strength(strength)
                .pistonBehavior(PistonBehavior.DESTROY);

        return new ButtonBlock(blockSetType, pressTicks, settings);
    }

    private static ButtonBlock newModButton(BlockSetType blockSetType, int pressTicks, Block base) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .mapColor(base.getDefaultMapColor())
                .instrument(base.getDefaultState().getInstrument())
                .noCollision()
                .strength(0.5f)
                .pistonBehavior(PistonBehavior.DESTROY);

        return new ButtonBlock(blockSetType, pressTicks, settings);
    }

    public static void load() {
    }
}
