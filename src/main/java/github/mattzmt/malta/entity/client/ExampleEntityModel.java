package github.mattzmt.malta.entity.client;

import github.mattzmt.malta.Malta;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class ExampleEntityModel extends EntityModel<ExampleEntityRenderState> {
    public static final EntityModelLayer EXAMPLE_ENTITY = new EntityModelLayer(Identifier.of(Malta.MOD_ID, "example_entity"), "main");
    private final ModelPart example_entity;
    private final ModelPart head;

    private final Animation walkingAnimation;
    private final Animation idlingAnimation;


    public ExampleEntityModel(ModelPart root) {
        super(root);
        this.example_entity = root.getChild("example_entity");
        this.head = this.example_entity.getChild("head");

        this.walkingAnimation = ExampleEntityAnimations.ANIM_EXAMPLE_ENTITY_WALK.createAnimation(root);
        this.idlingAnimation = ExampleEntityAnimations.ANIM_EXAMPLE_ENTITY_IDLE.createAnimation(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData example_entity = modelPartData.addChild("example_entity", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 24.0F, -2.25F));

        ModelPartData shell_bone = example_entity.addChild("shell_bone", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -8.0F, -1.0F, 4.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.origin(-1.0F, -1.0F, -1.75F));

        ModelPartData head = example_entity.addChild("head", ModelPartBuilder.create().uv(18, 23).cuboid(-1.5F, -3.0F, -3.75F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, -3.0F));

        ModelPartData left_eyestalk_bone = head.addChild("left_eyestalk_bone", ModelPartBuilder.create(), ModelTransform.origin(-1.0F, -3.0F, -3.0F));

        ModelPartData left_eyestalk = left_eyestalk_bone.addChild("left_eyestalk_r1", ModelPartBuilder.create().uv(0, 27).cuboid(1.0F, -3.0F, -1.0F, 0.01F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.25F, 0.5F, 0.0F, 0.1572F, -0.3614F, -0.4215F));

        ModelPartData right_eyestalk_bone = head.addChild("right_eyestalk_bone", ModelPartBuilder.create(), ModelTransform.origin(1.0F, -3.0F, -3.0F));

        ModelPartData right_eyestalk = right_eyestalk_bone.addChild("right_eyestalk_r1", ModelPartBuilder.create().uv(2, 27).mirrored().cuboid(2.0F, -3.0F, -1.0F, 0.01F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.25F, -0.75F, 1.0F, 0.1572F, 0.3614F, 0.4215F));

        ModelPartData left_antenna_bone = head.addChild("left_antenna_bone", ModelPartBuilder.create(), ModelTransform.origin(-1.0F, -0.25F, -3.5F));

        ModelPartData left_antenna = left_antenna_bone.addChild("left_antenna_r1", ModelPartBuilder.create().uv(30, 30).cuboid(-1.0F, -2.0F, -1.0F, 0.5F, 1.25F, 0.01F, new Dilation(0.0F)), ModelTransform.of(0.25F, 1.25F, -1.5F, -1.1781F, 0.3927F, 0.0F));

        ModelPartData right_antenna_bone = head.addChild("right_antenna_bone", ModelPartBuilder.create(), ModelTransform.origin(1.0F, -0.25F, -3.5F));

        ModelPartData right_antenna = right_antenna_bone.addChild("right_antenna_r1", ModelPartBuilder.create().uv(31, 30).cuboid(-1.0F, -2.0F, -1.0F, 0.5F, 1.25F, 0.01F, new Dilation(0.0F)), ModelTransform.of(1.25F, 1.25F, -1.0F, -1.1781F, -0.3927F, 0.0F));

        ModelPartData body_bone = example_entity.addChild("body_bone", ModelPartBuilder.create().uv(0, 21).cuboid(-0.5F, 0.0F, 1.25F, 3.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.origin(-1.0F, -1.0F, -4.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(ExampleEntityRenderState state) {
        super.setAngles(state);
        this.setHeadAngles(state.relativeHeadYaw, state.pitch);

        this.walkingAnimation.apply(state.walkingAnimationState, state.age, 1f);
        this.idlingAnimation.apply(state.idleAnimationState, state.age, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }
}