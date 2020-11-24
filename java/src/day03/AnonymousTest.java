package day03;

// 한 번 쓰고 말 때 익명클래스 사용
public class AnonymousTest {
    public static void main(String[] args) {
        Chair sofa = new Chair() {
            @Override
            void seat() {
                System.out.println("Seat");

            }
        };
        sofa.seat();
    }
}

abstract class Chair {
    abstract void seat();
}