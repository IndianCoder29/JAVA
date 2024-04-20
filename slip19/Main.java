package slip19;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of integers: ");
        int N = scanner.nextInt();
        // Use a LinkedList to store the integers
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("Enter " + N + " integers: ");
        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }
        // Display only the negative integers
        System.out.println("Negative integers are: ");
        for (int num : list) {
            if (num < 0) {
                System.out.println(num);
            }
        }
        scanner.close();
    }
}