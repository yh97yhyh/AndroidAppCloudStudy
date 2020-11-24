package day03;

public class Sedan extends Car {
    public Sedan(int wheels, int seats, int speed, int engine) {
        super(wheels, seats, speed, engine);
    }

    void loadPassanger() {
        System.out.println("Load Passanger");
    }
}
