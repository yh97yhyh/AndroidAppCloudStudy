package day03;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(4, "바나나");
        map.put(3, "사과");
        map.put(1, "토마토");
        map.put(3, "복숭아"); // 사과를 덮어씀

        System.out.println(map);

        System.out.println(map.get(4));

        map.remove(4);


    }
}
