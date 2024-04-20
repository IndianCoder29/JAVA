import java.util.*;
public class FriendNames{
    public static void main(String args[]){
        System.out.print("Enter the number of Friends : ");
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();

        Set<String> friendSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of friend "+ (i+1) +": ");
            String name = sc.next();
            friendSet.add(name);
        }

        List<String> sortedFriend = new ArrayList<>(friendSet);
        Collections.sort(sortedFriend);

        System.out.println("\nFriends in sorted order");
        for (String s : sortedFriend) {
            System.out.println(s);
        }

        sc.close();
        
    }
}