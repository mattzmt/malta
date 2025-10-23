package github.mattzmt.malta.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModTreeGeneration.generateTrees();
        ModEntitySpawns.addSpawns();
    }
}