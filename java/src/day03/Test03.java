package day03;

public class Test03 {
    public static void main(String[] args) {
        Vehicle bike = new Vehicle(2, 1, 0);
        System.out.println(bike.wheels);
        Vehicle copyBike = bike;
        copyBike.wheels = 4;
        System.out.println(copyBike.wheels);
        System.out.println(bike.wheels);

    }
}
