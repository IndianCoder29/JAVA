import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class StringLinkedListDemo {

    public static void main(String args[]) {
        LinkedList<String> lls = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int ch = 0;

        while (ch != 4) {
            System.out.println("Enter your choice:\n1) Add\n2) Remove\n3) Display\n4) Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter the String to be added:");
                    String str = sc.next();
                    lls.add(str);
                    break;
                case 2:
                    if (!lls.isEmpty()) {
                        lls.removeFirst();
                        System.out.println("Deleted the first element of the list");
                    } else {
                        System.out.println("Empty List, Nothing to delete");
                    }
                    break;
                case 3:
                    ListIterator<String> lis = lls.listIterator(lls.size());
                    System.out.println("Contents of the list in reverse order:");
                    while (lis.hasPrevious()) {
                        System.out.println(lis.previous());
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        sc.close();
    }
}