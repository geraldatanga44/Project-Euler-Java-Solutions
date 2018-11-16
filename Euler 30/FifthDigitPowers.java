public class FifthDigitPowers {
    private static int sumPowerDigit(int value, int power) {
        var solution = 0;
        while (value != 0) {
            var remainder = value % 10;
            solution += Math.pow(remainder, power);
            value /= 10;
        }
        return solution;
    }

    public static int fifthDigitPower(int start, int end, int increment, int power) {
        var solution = 0;
        for (; start <= end; start += increment) {
            var current = sumPowerDigit(start, power);
            if (current == start) {
                solution += start;
            }

        }
        return solution;
    }

    public static void main(String... args) {
        System.out.println(fifthDigitPower(2, 200_000, 1, 5));
    }
}