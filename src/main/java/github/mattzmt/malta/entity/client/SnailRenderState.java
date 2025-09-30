package github.mattzmt.malta.entity.client;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.passive.Cracks;

public class SnailRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkingAnimationState = new AnimationState();
    public Cracks.CrackLevel crackLevel = Cracks.CrackLevel.NONE;
    public int texture;}