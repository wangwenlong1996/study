package name.wwl.demo.study.design.pattern.builder;

public class Main {

    public static void main(String[] args) {
        Person p = new Person.PersonBuilder()
                .basicInfo(1,"zhangsan",18).weight(100).build();


        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain t = builder.buildFort().buildMine().buildWall().build();
    }
}
