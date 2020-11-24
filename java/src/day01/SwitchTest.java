package day01;

public class SwitchTest {
    public static void main(String[] args) {
        String school = "중학교";
        switch (school) {
            case "초등학교" :
                System.out.println("당신은 초등학생입니다.");
                break;
            case "중학교" :
                System.out.println("당신은 중학생입니다.");
                break;
            case "고등학교" :
                System.out.println("당신은 고등학생입니다.");
                break;
            case "대학교" :
                System.out.println("당신은 대학생입니다.");
                break;
        }
    }
}
