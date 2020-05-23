package name.wwl.demo.study.design.pattern.factory.simple;

public class Main {
    public static void main(String[] args) {
        Moveable m = new SimpleVehicleFactory().createBroom();
        m.go();

        Moveable car = new SimpleVehicleFactory().createCar();
        car.go();
    }
}
