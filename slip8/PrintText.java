package slip8;

public class PrintText implements Runnable {
    private String text;
    private int times;

    public PrintText(String text, int times) {
        this.text = text;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintText("COVID19", 10));
        Thread thread2 = new Thread(new PrintText("LOCKDOWN2020", 20));
        Thread thread3 = new Thread(new PrintText("VACCINATED2021", 30));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
