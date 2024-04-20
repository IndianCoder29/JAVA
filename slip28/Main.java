package slip28;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Currently executing thread: " +
                        Thread.currentThread().getName());
            }
        }, "Thread 1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Currently executing thread: " +
                        Thread.currentThread().getName());
            }
        }, "Thread 2");
        thread1.start();
        thread2.start();
    }
}