package day03;

public class Test02 {
    public static void main(String[] args) {
        Car car = new Car(4, 4, 0, 1);
        Car truck = new Truck( 4, 4, 0, 1, 1);
        Car sportsCar = new SportsCar(4, 2, 0, 1);

        Car[] cars = {car, truck, sportsCar};
        for(Car c:cars) {
            c.speedUp();
        }

    }
}
