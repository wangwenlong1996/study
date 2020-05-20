package name.wwl.demo.study.design.pattern.strategy;


public class Cat{
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}