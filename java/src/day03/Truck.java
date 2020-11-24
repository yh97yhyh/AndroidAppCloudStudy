package day03;

public class Truck extends Car {
    int loadage;

    public Truck(int wheels, int seats, int speed, int engine, int loadage) {
        super(wheels, seats, speed, engine);
        this.loadage = loadage;
    }

    void load() {
        loadage += 1;
        System.out.println("loadage = " + loadage);
    }

    void unLoad() {
        loadage -= 1;
        System.out.println("loadage = " + loadage);
    }

    void loadCargo() {
        System.out.println("Load Cargo");
    }

    @Override
    void speedUp() {
        speed += 5;
        System.out.println("Turck Speed = " + speed);
    }

    @Override
    void speedDown() {
        speed -= 5;
        System.out.println("Turck Speed = " + speed);
    }
}
