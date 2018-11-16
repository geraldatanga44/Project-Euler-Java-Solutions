import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OneThounsandFibonacciNumber {
    private static int thousandFib(int limit) {
        var list = Stream.of(BigInteger.ONE, BigInteger.ONE).collect(Collectors.toList());
        var index = 0;
        while (list.get(index).toString().length() != limit) {
            if (list.get(index).toString().length() == limit)
                break;
            list.add(list.get(index).add(list.get(index + 1)));
            index++;
        }

        return index + 1;
    }

    public static void main(String... args) {
        System.out.println(thousandFib(1_000));
    }
}
