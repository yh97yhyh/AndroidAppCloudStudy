package day03;

public class AnonymousTest2 {
    public static void main(String[] args) {

        Bootable bootable = new Bootable() {
            @Override
            public void boot() {
                System.out.println("부트");
            }
        };
    }
}
