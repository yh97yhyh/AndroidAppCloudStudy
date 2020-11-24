package day03;

import java.util.HashSet;

public class Lotto {
    public static void main(String[] args) {
        HashSet<Integer> lotto = new HashSet<>();

        while (true) {
            if(lotto.size() >= 6) {
                break;
            }

            int num = (int) Math.floor(Math.random()*45 + 1);
            lotto.add(num);
        }

        System.out.println(lotto);
    }
}
