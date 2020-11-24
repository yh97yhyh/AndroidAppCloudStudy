package day03;

public class Car extends Vehicle {
    int engine;

    public Car(int wheels, int seats, int speed, int engine) {
        super(wheels, seats, speed);
        this.engine = engine;
    }

    void speedUp() {
        speed += 10;
        System.out.println("Speed = " + speed);
    }

    void speedDown() {
        speed -= 10;
        System.out.println("Speed = " + speed);
    }
}
