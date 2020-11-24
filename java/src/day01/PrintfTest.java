package day01;

public class PrintfTest {
    public static void main(String[] args) {
        int numA = 300;
        System.out.println(numA);
        System.out.printf("numA = %d \n", numA);

        System.out.printf("numA = %5d \n", numA);
        int numB = 1;
        System.out.printf("numB = %05d \n", numB);

        double pi = 3.14159265359;
        System.out.printf("pi = %f \n", pi);
        System.out.printf("pi = %.3f \n", pi);
        System.out.printf("pi = %10.3f \n", pi);
        System.out.printf("numA = %d 이고 pi = %.3f \n", numA, pi);

        String name = "홍길동";
        int age = 18;
        System.out.printf("이름은 %s이고 나이는 %d세입니다. \n", name, age);
    }
}
