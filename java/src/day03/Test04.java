package day03;

public class Test04 {
    public static void main(String[] args) {
        Sedan sedan = new Sedan(4, 8, 0, 1);
        sedan.loadPassanger();
        sedan.speedUp();
        sedan.drive();

        Truck truck = new Truck(4, 2, 0,1, 1);
        truck.loadCargo();
        truck.speedUp();
    }
}
