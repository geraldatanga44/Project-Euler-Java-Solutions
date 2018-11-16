import java.util.HashSet;

public class AmicableNumbers {
    private static int divisors(int value) {
        var sqrt = (int) Math.sqrt(value);
        var list = new HashSet<Integer>();
        var sum = 0;

        list.add(1);
        for (var v = 2; v <= sqrt; v++) {
            if (value % v == 0) {
                list.add(v);
                list.add(value / v);
            }
        }

        sum = list.parallelStream().reduce(0, Integer::sum);
        return sum;
    }

    private static int sumAmicableNumbers(int limit) {
        var sum = 0;
        for (var x = 2; x < limit; x++) {
            var b = divisors(x);
            var a = divisors(b);

            if (x != b && x == a) {
                sum += x;
            }
        }
        return sum;
    }

    public static void main(String... args) {
        System.out.println(sumAmicableNumbers(10_000));
    }
}