package slip7;

import java.util.Random;
import java.util.concurrent.*;

public class MultiThreadApplication {
    private static int number;

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        // First thread generates a random integer every second
        Runnable generateNumber = () -> {
            number = new Random().nextInt(100);
            System.out.println("Random number: " + number);
        };
        // Second thread computes the square of the number if it's even
        Runnable computeSquare = () -> {
            if (number % 2 == 0) {
                System.out.println("Square of " + number + ": " + number * number);
            }
        };
        // Third thread computes the cube of the number if it's odd
        Runnable computeCube = () -> {
            if (number % 2 != 0) {
                System.out.println("Cube of " + number + ": " + number * number *
                        number);
            }
        };
        executor.scheduleAtFixedRate(generateNumber, 0, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(computeSquare, 0, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(computeCube, 0, 1, TimeUnit.SECONDS);
    }
}