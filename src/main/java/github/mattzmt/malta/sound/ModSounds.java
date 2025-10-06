package github.mattzmt.malta.sound;

import github.mattzmt.malta.Malta;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModSounds {
	public static final SoundEvent SNAIL_HIT = registerSoundEvent("snail_hit");
	public static final SoundEvent SNAIL_SHELL_CRACK = registerSoundEvent("snail_shell_crack");
	public static final SoundEvent SNAIL_DEATH = registerSoundEvent("snail_death");
	public static final SoundEvent SNAIL_SHELL_BREAK = registerSoundEvent("snail_shell_break");
	public static final SoundEvent SNAIL_SHELL_FALL = registerSoundEvent("snail_shell_impact");
	public static final SoundEvent SNAIL_SHELL_STEP = registerSoundEvent("snail_shell_step");

	public static BlockSoundGroup SNAIL_SHELL_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
			SNAIL_SHELL_BREAK, SNAIL_SHELL_STEP, SoundEvents.BLOCK_STONE_PLACE, SoundEvents.BLOCK_STONE_HIT, SNAIL_SHELL_FALL);

	private static SoundEvent registerSoundEvent(String name) {
		Identifier id = Malta.id(name);
		return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
	}

	public static void registerSounds() {
		Malta.LOGGER.info("Registering mod sounds for "+Malta.MOD_ID);
	}
}