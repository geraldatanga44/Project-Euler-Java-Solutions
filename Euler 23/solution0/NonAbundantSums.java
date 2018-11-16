import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NonAbundantSums {
    private static boolean isAbuntantNumber(int value) {
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

        for (var d : list)
            sum += d;
        return sum > value;
    }

    public static List<Integer> aList(int limit) {
        var list = new ArrayList<Integer>();
        for (var v = 12; v <= limit; v++) {
            if (isAbuntantNumber(v))
                list.add(v);
        }
        return list;
    }

    private static int aSum(int limit) {
        var array = new int[limit + 1];
        var list = aList(limit);

        for (var o = 0; o < list.size(); o++) {
            for (var i = o; i < list.size(); i++) {
                var sum = list.get(o) + list.get(i);
                if (sum <= limit)
                    array[sum] = sum;
            }
        }
        var sum = 0;
        for (var index = 1; index < limit; index++) {
            if (array[index] != index)
                sum += index;
        }

        return sum;
    }

    public static void main(String... args) {
        System.out.println(aSum(28123));
    }
}
