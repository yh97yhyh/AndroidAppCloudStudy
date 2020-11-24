package day01;

public class OpTest {
    public static void main(String[] args) {
        int numberA = 3;
//        numberA += 1;
//        numberA += 3;
//        System.out.println("numberA = " + numberA);
//        numberA -= 2;
//        System.out.println("numberA = " + numberA);
//        numberA *= 3;
//        System.out.println("numberA = " + numberA);
//        numberA /= 3;
//        System.out.println("numberA = " + numberA);
//        numberA %= 3;
//        System.out.println("numberA = " + numberA);

        numberA = 1;
        numberA++;
        System.out.println("numberA = " + numberA);
        ++numberA;
        System.out.println("numberA = " + numberA);

        int numberB = numberA++;
        System.out.println("numberB = " + numberB);
        System.out.println("numberA = " + numberA);
    }
}
