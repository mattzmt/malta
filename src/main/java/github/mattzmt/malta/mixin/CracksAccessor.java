package github.mattzmt.malta.mixin;

import net.minecraft.entity.passive.Cracks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Cracks.class)
public interface CracksAccessor {
    @Invoker("<init>")
    static Cracks create(float low, float medium, float high) {
        throw new AssertionError();
    }
}