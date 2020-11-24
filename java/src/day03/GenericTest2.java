package day03;

import java.util.ArrayList;

public class GenericTest2 {
    public static void main(String[] args) {
        ArrayList<Bootable> bootableArrayList = new ArrayList<>();
        SportsCar sportsCar = new SportsCar(4, 2, 0, 1);
        Computer computer = new Computer();

        bootableArrayList.add(sportsCar);
        bootableArrayList.add(computer);

        Bootable sc = bootableArrayList.get(0);
        Bootable com1 = bootableArrayList.get(1);
        sc.boot();

        bootableArrayList.get(1).boot();
    }
}
