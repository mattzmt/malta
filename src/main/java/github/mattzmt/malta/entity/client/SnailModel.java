package github.mattzmt.malta.entity.client;

import github.mattzmt.malta.entity.client.renderer.SnailEntityRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;

@Environment(EnvType.CLIENT)
public class SnailModel extends EntityModel<SnailEntityRenderState> {
    private final Animation idleAnimation;
    private final Animation walkingAnimation;

    private final ModelPart snail;
    private final ModelPart head;

    public SnailModel(ModelPart modelPart) {
        super(modelPart);
        this.snail = modelPart.getChild("snail");
        this.head = this.snail.getChild("head");

        this.idleAnimation = SnailAnimations.IDLE.createAnimation(modelPart);
        this.walkingAnimation = SnailAnimations.WALKING.createAnimation(modelPart);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData snail = modelPartData.addChild("snail", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 24.0F, -2.25F));

        ModelPartData shell_bone = snail.addChild("shell_bone", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -8.0F, -1.0F, 4.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.origin(-1.0F, -1.0F, -1.75F));

        ModelPartData head = snail.addChild("head", ModelPartBuilder.create().uv(18, 23).cuboid(-1.5F, -3.0F, -3.75F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, -3.0F));

        ModelPartData left_eyestalk_bone = head.addChild("left_eyestalk_bone", ModelPartBuilder.create(), ModelTransform.origin(-1.0F, -3.0F, -3.0F));

        ModelPartData left_eyestalk = left_eyestalk_bone.addChild("left_eyestalk_r1", ModelPartBuilder.create().uv(0, 27).cuboid(1.0F, -3.0F, -1.0F, 0.01F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.25F, 0.5F, 0.0F, 0.1572F, -0.3614F, -0.4215F));

        ModelPartData right_eyestalk_bone = head.addChild("right_eyestalk_bone", ModelPartBuilder.create(), ModelTransform.origin(1.0F, -3.0F, -3.0F));

        ModelPartData right_eyestalk = right_eyestalk_bone.addChild("right_eyestalk_r1", ModelPartBuilder.create().uv(2, 27).mirrored().cuboid(2.0F, -3.0F, -1.0F, 0.01F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.25F, -0.75F, 1.0F, 0.1572F, 0.3614F, 0.4215F));

        ModelPartData left_antenna_bone = head.addChild("left_antenna_bone", ModelPartBuilder.create(), ModelTransform.origin(-1.0F, -0.25F, -3.5F));

        ModelPartData left_antenna = left_antenna_bone.addChild("left_antenna_r1", ModelPartBuilder.create().uv(30, 30).cuboid(-1.0F, -2.0F, -1.0F, 0.5F, 1.25F, 0.01F, new Dilation(0.0F)), ModelTransform.of(0.25F, 1.25F, -1.5F, -1.1781F, 0.3927F, 0.0F));

        ModelPartData right_antenna_bone = head.addChild("right_antenna_bone", ModelPartBuilder.create(), ModelTransform.origin(1.0F, -0.25F, -3.5F));

        ModelPartData right_antenna = right_antenna_bone.addChild("right_antenna_r1", ModelPartBuilder.create().uv(31, 30).cuboid(-1.0F, -2.0F, -1.0F, 0.5F, 1.25F, 0.01F, new Dilation(0.0F)), ModelTransform.of(1.25F, 1.25F, -1.0F, -1.1781F, -0.3927F, 0.0F));

        ModelPartData body_bone = snail.addChild("body_bone", ModelPartBuilder.create().uv(0, 21).cuboid(-0.5F, 0.0F, 1.25F, 3.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.origin(-1.0F, -1.0F, -4.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(SnailEntityRenderState state) {
        super.setAngles(state);

        float yaw = state.relativeHeadYaw * ((float)Math.PI / 180F);
        float pitch = state.pitch * ((float)Math.PI / 180F);

        this.head.yaw = yaw;
        this.head.pitch = pitch;

        this.idleAnimation.apply(SnailEntityRenderState.idleAnimationState, SnailEntityRenderState.age);
        this.walkingAnimation.apply(SnailEntityRenderState.walkingAnimationState, SnailEntityRenderState.age);
    }

    public ModelPart getHead() {
        return head;
    }

    public ModelPart getSnail() {
        return snail;
    }
}