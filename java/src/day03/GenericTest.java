package day03;

import java.awt.*;
import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        ArrayList<Car> carList = new ArrayList();
        ArrayList<String> strList = new ArrayList<>();
        ArrayList<Integer> intList = new ArrayList<>();

        Car car = new Car(4, 4, 1, 1);
        SportsCar sc = new SportsCar(4, 2, 2, 1);

        carList.add(car);
        carList.add(sc);

        Car car1 = carList.get(0);
        Car car2 = carList.get(1);
        car1.speedUp();
        car2.speedUp();
    }
}
