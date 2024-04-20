package slip6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of integers:");
        int n = scanner.nextInt();
        // Create a TreeSet to store integers
        TreeSet<Integer> set = new TreeSet<Integer>();
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            set.add(num); // TreeSet will not add duplicate elements
        }
        // Display the integers in sorted order
        System.out.println("Sorted integers: " + set);
        System.out.println("Enter an integer to search:");
        int searchNum = scanner.nextInt();
        // Search for the integer using the contains method
        if (set.contains(searchNum)) {
            System.out.println(searchNum + " is in the set.");
        } else {
            System.out.println(searchNum + " is not in the set.");
        }
        scanner.close();
    }
}