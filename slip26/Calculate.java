package slip26;

public class Calculate {
    public static int calculateSum(int number) {
        int firstDigit = Integer.parseInt(Integer.toString(number).substring(0,
                1));
        int lastDigit = Integer.parseInt(Integer.toString(number).substring(Integer.toString(number).length() - 1));
        return firstDigit + lastDigit;
    }
}