package day03;

public class ThreadTest2 extends Thread {
    int id;

    public ThreadTest2(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(this.id + "Thread Start");
        for(int i = 0; i < 500; i++) {
            System.out.printf("%d번째 Thread - %d\n", this.id, i);
        }
        System.out.println(this.id + "Thread End");
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            ThreadTest2 th = new ThreadTest2(i);
            th.start();
        }
    }
}
