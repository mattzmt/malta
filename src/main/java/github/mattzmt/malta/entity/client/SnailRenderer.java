package github.mattzmt.malta.entity.client;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.entity.custom.SnailEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SnailRenderer extends MobEntityRenderer<SnailEntity, SnailRenderState, SnailModel> {
    private static final Identifier DEFAULT_TEXTURE = Malta.id("textures/entity/snail/snail.png");

    public SnailRenderer(EntityRendererFactory.Context context) {
        super(context, new SnailModel(context.getPart(SnailModel.SNAIL)), 0.4f);
        this.addFeature(new SnailCrackFeatureRenderer(this));}

    @Override
    public Identifier getTexture(SnailRenderState state) {
        return DEFAULT_TEXTURE;}

    @Override
    public void render(SnailRenderState state, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(state.baby)
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        else
            matrixStack.scale(1f, 1f, 1f);

        super.render(state, matrixStack, vertexConsumerProvider, i);}

    @Override
    public SnailRenderState createRenderState() {
        return new SnailRenderState();}

    @Override
    public void updateRenderState(SnailEntity livingEntity, SnailRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.walkingAnimationState.copyFrom(livingEntity.walkingAnimationState);
        livingEntityRenderState.crackLevel = livingEntity.getCrackLevel();}

	@Override
	protected RenderLayer getRenderLayer(SnailRenderState state, boolean showBody, boolean translucent, boolean showOutline) {
		return RenderLayer.getEntityTranslucent(getTexture(state));
	}
}