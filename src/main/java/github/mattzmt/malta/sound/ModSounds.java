package github.mattzmt.malta.sound;

import github.mattzmt.malta.Malta;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {


	private static SoundEvent registerSoundEvent(String name) {
		Identifier id = Malta.id(name);
		return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
	}

	public static void registerSounds() {
		Malta.LOGGER.info("Registering mod sounds for "+Malta.MOD_ID);
	}
}