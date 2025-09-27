package github.mattzmt.malta.entity.client.renderer;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

public class SnailEntityRenderState extends LivingEntityRenderState {
    public boolean isBaby;
    public static float age;
    public static final AnimationState idleAnimationState = new AnimationState();
    public static final AnimationState walkingAnimationState = new AnimationState();
}