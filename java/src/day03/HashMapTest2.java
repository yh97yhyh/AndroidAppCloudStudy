package day03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest2 {
    public static void main(String[] args) {
        HashMap<String, String> bts = new HashMap<>();
        bts.put("진", "김석진");
        bts.put("슈가", "민윤기");
        bts.put("제이홉", "정호석");
        bts.put("RM", "김남준");
        bts.put("지민", "박지민");
        bts.put("뷔", "김태형");
        bts.put("정국", "전정국");

        //keySet()
        Iterator<String> it = bts.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.printf("Key = %s 이고 Value = %s 이다.\n", key, bts.get(key));
        }

        System.out.println();

        for(String key: bts.keySet()) {
            System.out.printf("Key = %s 이고 Value = %s 이다.\n", key, bts.get(key));
        }

        System.out.println();

        //entrySet()
        for(Map.Entry<String, String> member: bts.entrySet()) {
            System.out.printf("Key = %s 이고 Value = %s 이다.\n", member.getKey(), member.getValue());
        }
    }
}
