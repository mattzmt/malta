package github.mattzmt.malta.entity.client;

import com.google.common.collect.ImmutableMap;
import github.mattzmt.malta.Malta;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.Cracks;
import net.minecraft.util.Identifier;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class SnailCrackFeatureRenderer extends FeatureRenderer<SnailRenderState, SnailModel> {
    private static final Map<Cracks.CrackLevel, Identifier> CRACK_TEXTURES = ImmutableMap.of(
            Cracks.CrackLevel.LOW,
            Malta.id("textures/entity/snail/cracks_low.png"),
            Cracks.CrackLevel.MEDIUM,
            Malta.id("textures/entity/snail/cracks_medium.png"),
            Cracks.CrackLevel.HIGH,
            Malta.id("textures/entity/snail/cracks_high.png")
    );

    public SnailCrackFeatureRenderer(FeatureRendererContext<SnailRenderState, SnailModel> featureRendererContext) {
        super(featureRendererContext);
    }

	public void render(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, SnailRenderState state, float limbAngle, float limbDistance) {
        if (!state.invisible) {
            Cracks.CrackLevel crackLevel = state.crackLevel;
            if (crackLevel != Cracks.CrackLevel.NONE) {
                Identifier identifier = (Identifier)CRACK_TEXTURES.get(crackLevel);
                renderModel(this.getContextModel(), identifier, matrices, queue, light, state, -1, OverlayTexture.DEFAULT_UV);
            }
        }
    }
}