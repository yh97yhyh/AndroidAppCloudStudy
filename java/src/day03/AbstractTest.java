package day03;

public class AbstractTest {
    public static void main(String[] args) {
        SubCar1 subCar1 = new SubCar1();
        subCar1.speedUp();
        subCar1.speedDown();

        Car1 subCar2 = new SubCar1();
        subCar2.speedUp();
    }

}

// abstract class는 항상 상속받은 class로만 객체 생성 가능
abstract class Car1 {
    int speed;

    abstract void speedUp();
    abstract void speedDown();
}

class SubCar1 extends Car1 {
    @Override
    void speedUp() {
        speed += 10;
        System.out.println("Speed = " + speed);
    }

    @Override
    void speedDown() {
        speed -= 10;
        System.out.println("Speed = " + speed);
    }
}