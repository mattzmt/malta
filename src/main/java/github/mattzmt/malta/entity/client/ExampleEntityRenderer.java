package github.mattzmt.malta.entity.client;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.entity.custom.ExampleEntityEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ExampleEntityRenderer extends MobEntityRenderer<ExampleEntityEntity, ExampleEntityRenderState, ExampleEntityModel> {
    private static final Identifier DEFAULT_TEXTURE = Malta.id("textures/entity/example_entity/example_entity.png");

    public ExampleEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new ExampleEntityModel(context.getPart(ExampleEntityModel.EXAMPLE_ENTITY)), 0.4f);
	}

    @Override
    public Identifier getTexture(ExampleEntityRenderState state) {
        return DEFAULT_TEXTURE;
	}

    @Override
    public void render(ExampleEntityRenderState state, MatrixStack matrixStack,
					   VertexConsumerProvider vertexConsumerProvider, int i) {
        if(state.baby)
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        else
            matrixStack.scale(1f, 1f, 1f);

        super.render(state, matrixStack, vertexConsumerProvider, i);
	}

    @Override
    public ExampleEntityRenderState createRenderState() {
        return new ExampleEntityRenderState();
	}

    @Override
    public void updateRenderState(ExampleEntityEntity livingEntity, ExampleEntityRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.walkingAnimationState.copyFrom(livingEntity.walkingAnimationState);
	}

	@Override
	protected RenderLayer getRenderLayer(ExampleEntityRenderState state, boolean showBody, boolean translucent, boolean showOutline) {
		return RenderLayer.getEntityTranslucent(getTexture(state));
	}
}