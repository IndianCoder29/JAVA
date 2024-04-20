package slip29;

import java.util.LinkedList;

public class Main1 {
    public static void main(String[] args) {
        // Create a LinkedList of Integer objects
        LinkedList<Integer> list = new LinkedList<>();
        // Add some elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Original list: " + list);
        // i. Add element at first position
        list.addFirst(5);
        System.out.println("After adding 5 at first position: " + list);
        // ii. Delete last element
        list.removeLast();
        System.out.println("After removing last element: " + list);
        // iii. Display the size of link list
        System.out.println("Size of the list: " + list.size());
    }
}
