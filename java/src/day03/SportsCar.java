package day03;

public class SportsCar extends Car implements Bootable{
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

    @Override
    public void boot() {
        System.out.println("스포츠카 부트");
    }
}
