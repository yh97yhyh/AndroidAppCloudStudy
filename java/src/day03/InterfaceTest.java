package day03;

public class InterfaceTest {
    public static void main(String[] args) {
        Bike bike = new Bike(2, 1, 0);
        bike.boot();
        Computer com = new Computer();
        com.boot();

        Bootable bike2 = new Bike(2,1, 0);
        Bootable com2 = new Computer();
        bike2.boot();
        com2.boot();
    }
}

class Bike extends Vehicle implements Bootable {

    public Bike(int wheels, int seats, int speed) {
        super(wheels, seats, speed);
    }

    @Override
    public void boot() {
        System.out.println("Bike 시동");
    }
}

class Computer implements Bootable {

    @Override
    public void boot() {
        System.out.println("Computer 부팅");
    }
}