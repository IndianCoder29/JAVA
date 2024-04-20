package slip17;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of integers: ");
        int N = scanner.nextInt();
        // Use a TreeSet to store the integers
        // TreeSet automatically sorts the elements and does not allow duplicates
        Set<Integer> set = new TreeSet<>();
        System.out.println("Enter " + N + " integers: ");
        for (int i = 0; i < N; i++) {
            set.add(scanner.nextInt());
        }
        // Display the integers in sorted order
        System.out.println("The integers in sorted order are: " + set);

        scanner.close();
    }
}