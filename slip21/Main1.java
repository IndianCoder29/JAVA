package slip21;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of subjects: ");
        int N = scanner.nextInt();
        // Use a LinkedList to store the subjects
        LinkedList<String> subjects = new LinkedList<>();
        System.out.println("Enter " + N + " subjects: ");
        for (int i = 0; i < N; i++) {
            subjects.add(scanner.next());
        }
        // Display the subjects using an Iterator
        System.out.println("The subjects are: ");
        Iterator<String> iterator = subjects.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        scanner.close();
    }
}