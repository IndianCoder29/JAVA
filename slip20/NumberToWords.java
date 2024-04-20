package slip20;

public class NumberToWords {
    private static final String[] units = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

    public static String convert(int num) {
        if (num == 0) {
            return units[0];
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int digit = num % 10;
            sb.insert(0, units[digit] + " ");
            num /= 10;
        }
        return sb.toString().trim();
    }
}