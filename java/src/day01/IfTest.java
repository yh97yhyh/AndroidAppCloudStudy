package day01;

public class IfTest {
    public static void main(String[] args) {
        int adult = 19;
        int age = 15;
        boolean isKorean = true;

        if(age < adult) {
            if(isKorean) {
                System.out.println("당신은 한국인 미성년자입니다.");
            } else {
                System.out.println("당신은 외국인 미성년자입니다.");
            }
        } else {
            System.out.println("당신은 성인입니다.");
        }
    }
}
