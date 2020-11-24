package day03;

public class Test01 {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(4, 4, 0);
        v1.drive();
        Car c1 = new Car(4, 4, 0, 4);
        c1.speedUp();
        c1.speedDown();
        c1.drive();

        Truck t1 = new Truck(7, 2, 0, 8, 1);
        t1.drive();
        t1.speedUp();
        t1.speedUp();
        t1.speedDown();
        t1.load();
    }
}
