package slip23;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        // Store the student names in a LinkedList
        LinkedList<String> students = new LinkedList<>(Arrays.asList(args));
        // Display the student names using an Iterator
        System.out.println("Displaying student names using an Iterator:");
        Iterator<String> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // Display the student names using a ListIterator
        System.out.println("\nDisplaying student names using a ListIterator:");
        ListIterator<String> listIterator = students.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
