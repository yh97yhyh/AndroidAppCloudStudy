package day03;

public class Vehicle {
    int wheels;
    int seats;
    int speed;

    void drive() {
        System.out.println("drive");
    }

    public Vehicle(int wheels, int seats, int speed) {
        this.wheels = wheels;
        this.seats = seats;
        this.speed = speed;
    }
}
