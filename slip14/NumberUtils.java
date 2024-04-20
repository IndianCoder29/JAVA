package slip14;

public class NumberUtils {
    public static int sumOfFirstAndLastDigit(int num) {
        int lastDigit = num % 10;
        int firstDigit = num;
        while (firstDigit >= 10) {
            firstDigit /= 10;
        }
        return firstDigit + lastDigit;
    }
}