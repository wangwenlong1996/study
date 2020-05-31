package name.wwl.demo.study.design.pattern.builder;

public interface TerrainBuilder {

    TerrainBuilder buildWall();

    TerrainBuilder buildFort();

    TerrainBuilder buildMine();

    Terrain build();
}
