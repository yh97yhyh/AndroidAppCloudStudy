package day03;

public class SportsCar extends Car {
    public SportsCar(int wheels, int seats, int speed, int engine) {
        super(wheels, seats, speed, engine);
    }

    @Override
    void speedUp() {
        speed += 20;
        System.out.println("SportsCar Speed = " + speed);
    }

    @Override
    void speedDown() {
        speed -= 20;
        System.out.println("SportsCar Speed = " + speed);
    }
}
