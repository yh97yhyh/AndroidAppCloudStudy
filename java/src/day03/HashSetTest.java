package day03;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> bts = new HashSet<>();
        bts.add("진");
        bts.add("슈가");
        System.out.println(bts.add("제이홉"));
        System.out.println(bts.add("슈가"));
        bts.add("RM");
        bts.add("지민");
        bts.add("뷔");
        bts.add("정국");

        System.out.println(bts);

//        for(String name:bts) {
//            System.out.println(name);
//        }

        Iterator<String> it = bts.iterator();
        while(it.hasNext()) {
            String name = it.next();
            System.out.println(name);
        }

        System.out.println(bts.size());

        bts.toArray();
    }
}
