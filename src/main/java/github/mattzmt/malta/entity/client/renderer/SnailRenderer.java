package github.mattzmt.malta.entity.client.renderer;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.entity.client.SnailModel;
import github.mattzmt.malta.entity.custom.SnailEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SnailRenderer extends MobEntityRenderer<SnailEntity, SnailEntityRenderState, SnailModel> {
    public SnailRenderer(EntityRendererFactory.Context context) {
        super(context, new SnailModel(context.getPart(SnailModelLayers.SNAIL)), 0.4f);
    }

    @Override
    public SnailEntityRenderState createRenderState() {
        return new SnailEntityRenderState();
    }

    @Override
    public void updateRenderState(SnailEntity entity, SnailEntityRenderState state, float f) {
        super.updateRenderState(entity, state, f);
        state.isBaby = entity.isBaby();
    }

    @Override
    public Identifier getTexture(SnailEntityRenderState state) {
        return Malta.id("textures/entity/snail/snail.png");
    }

    @Override
    protected void scale(SnailEntityRenderState state, MatrixStack matrices) {
        if (state.isBaby) {
            matrices.scale(0.5F, 0.5F, 0.5F);
        }
    }
}