package slip15;

public class Main {
    public static void main(String[] args) {
        // Get the main thread
        Thread t = Thread.currentThread();
        // Print the name of the main thread
        System.out.println("Thread Name: " + t.getName());
        // Print the priority of the main thread
        System.out.println("Thread Priority: " + t.getPriority());
    }
}