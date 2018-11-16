import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class QuadraticPrimes {
    private static boolean isPrime(long value) {
        if (value < 2)
            return false;
        var list = new HashSet<Long>();
        var sqrt = (long) Math.sqrt(value);

        for (var v = 1L; v <= sqrt; v++) {
            if (value % v == 0)
                list.add(v);

            if (list.size() > 1)
                return false;
        }

        return true;
    }

    private static long quadraticForm(long n, long a, long b) {
        return (long) (Math.pow(n, 2) + (a * n) + b);
    }

    private static long consecutivePrimeCounter(long a, long b) {
        for (var n = 0;; n++) {
            if (!isPrime(quadraticForm(n, a, b)))
                return n;
        }
    }

    private static List<Long> generateBPrimes(long limit) {
        var listPrimes = new ArrayList<Long>();
        for (var v = 1L; v <= limit; v += 2) {
            if (isPrime(v))
                listPrimes.add(v);
        }
        return listPrimes;
    }

    private static long maxConsecutivePrimeSolution(long limit) {
        var listPrimes = generateBPrimes(limit);
        var maxProduct = 0L;
        var maxCounter = 0L;

        for (var a = -999; a <= 1000; a += 2) {
            for (var j = 0; j < listPrimes.size(); j++) {
                var b = listPrimes.get(j);
                var currCount = consecutivePrimeCounter(a, b);
                if (currCount > maxCounter) {
                    maxCounter = currCount;
                    maxProduct = a * b;
                }
            }
        }
        return maxProduct;
    }

    public static void main(String... args) {
        System.out.println(maxConsecutivePrimeSolution(1_000));
    }
}
