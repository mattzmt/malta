package github.mattzmt.malta.world.biome;

import github.mattzmt.malta.Malta;
import github.mattzmt.malta.world.biome.surface.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Malta.id("overworld"), 6));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Malta.MOD_ID, ModMaterialRules.makeRules());
    }
}
