package github.mattzmt.malta.util;

import github.mattzmt.malta.Malta;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModTags {
	public static class Items {


		private static TagKey<Item> createTag(String name) {
			return TagKey.of(RegistryKeys.ITEM, Malta.id(name));
		}
	}
}