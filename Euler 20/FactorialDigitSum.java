import java.math.BigInteger;

public class FactorialDigitSum {
    private static BigInteger factor(int value) {
        var summation = BigInteger.ONE;
        for (var x = value; x > 0; x--) {
            summation = summation.multiply(BigInteger.valueOf(x));
        }
        return summation;
    }

    private static int sumFactorialDigit(int value) {
        var digits = factor(value).toString();
        var sum = 0;
        for (var c : digits.toCharArray()) {
            sum += Integer.parseInt(Character.toString(c));
        }
        return sum;
    }

    public static void main(String... args) {
        System.out.println(sumFactorialDigit(100));
    }
}