package day01;

public class OpTest2 {
    public static void main(String[] args) {
        int numA = 3;
        int numB = 5;

        boolean isBig = numA < numB;
        System.out.printf("numA = %d, numB = %d, numA < numB = %b \n", numA, numB, isBig);

        boolean isSmall = numA > numB;
        System.out.printf("numA = %d, numB = %d, numA > numB = %b \n", numA, numB, isSmall);

        boolean isSame = numA == numB;
        System.out.printf("numA = %d, numB = %d, numA == numB = %b \n", numA, numB, isSame);

        boolean isNotSame = numA != numB;
        System.out.printf("numA = %d, numB = %d, numA != numB = %b \n", numA, numB, isNotSame);
    }
}
