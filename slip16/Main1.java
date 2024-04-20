package slip16;

import java.util.TreeSet;

public class Main1 {
    public static void main(String[] args) {
        // Create a TreeSet
        TreeSet<String> colors = new TreeSet<>();
        // Add some colors
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Black");
        // Print out the TreeSet in ascending order
        System.out.println("Colors in ascending order: " + colors);
    }
}