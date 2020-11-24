package day03;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        SportsCar sportsCar = new SportsCar(4, 2, 0, 1);
        Truck truck = new Truck(4, 2, 0, 1, 1);
        Object obj = new Object();
        arrayList.add(sportsCar);
        arrayList.add(truck);
        arrayList.add(1, obj);
        arrayList.add("홍길동");
        arrayList.add(30);

        SportsCar sc1 = (SportsCar) arrayList.get(0);
        sc1.drive();
        Truck tr1 = (Truck) arrayList.get(2);
        tr1.load();

        int num1 = (Integer) arrayList.get(4);
        arrayList.remove(tr1);
        arrayList.remove(0);

        int size = arrayList.size();
        boolean isContain = arrayList.contains(sc1);
        arrayList.clear();
        System.out.println(arrayList.isEmpty());
    }
}
