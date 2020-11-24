package day01;

public class OpTest3 {
    public static void main(String[] args) {
        boolean isTrue = false;
        System.out.println(!isTrue);

        boolean a = true;
        boolean b = false;
        System.out.println(a&&b);
        System.out.println(a||b);

        int man1 = 35;
        boolean isInTwenty = 20 <= man1 && man1 < 30;
        System.out.println(isInTwenty);
        boolean isTenOrThirty = (man1 >= 10 && man1 < 20) || (man1 >= 30 && man1 < 40);
        System.out.println(isTenOrThirty);                                    

    }
}
