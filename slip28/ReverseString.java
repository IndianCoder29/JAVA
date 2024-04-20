package slip28;

public class ReverseString {
    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}