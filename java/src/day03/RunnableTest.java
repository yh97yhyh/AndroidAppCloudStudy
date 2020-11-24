package day03;

public class RunnableTest {
    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            Thread th = new Thread(new Run(i));
            th.start();
        }
    }
}

class Run implements Runnable {
    int id;

    public Run(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.printf("=== %d번 째 Thread Start ===\n", id);
        for(int i=0; i<100; i++) {
            System.out.printf("%d번 째 Thread - %d\n", this.id, i);
        }
        System.out.printf("=== %d번 째 Thread End ===\n", id);
    }
}
