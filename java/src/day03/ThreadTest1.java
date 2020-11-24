package day03;

public class ThreadTest1 {
    public static void main(String[] args) {
        ThreadClass th = new ThreadClass();
        th.start();
    }

}

class ThreadClass extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Thread 1");
    }
}