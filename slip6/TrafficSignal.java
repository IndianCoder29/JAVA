package slip6;

public class TrafficSignal {
    public static void main(String[] args) {
    Thread red = new Thread(new Signal("RED", 10000)); // Red for 10 seconds
    Thread yellow = new Thread(new Signal("YELLOW", 2000)); // Yellow for 2seconds
    Thread green = new Thread(new Signal("GREEN", 5000)); // Green for 5seconds
    red.start();
    yellow.start();
    green.start();
    }
}

class Signal implements Runnable {
    private String color;
    private int duration;

    public Signal(String color, int duration) {
        this.color = color;
        this.duration = duration;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(color + " signal is ON");
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(color + " signal is OFF");
        }
    }
}