import java.util.HashSet;

public class PandigitalProducts {
    private static int[] digits() {
        final var SIZE = 9;
        final var arr = new int[SIZE];
        var low = 0;
        var high = SIZE - 1;

        for (; low < high; low++, high--) {
            arr[low] = low + 1;
            arr[high] = high + 1;
        }
        arr[SIZE / 2] = (SIZE + 1) / 2;
        return arr;
    }

    private static boolean isPandigital(String digits) {
        final var LENGTH = digits.length();
        final var arr = digits();

        if (LENGTH < 9 || LENGTH > 9)
            return false;
        var set = new HashSet<Integer>();
        var low = 0;
        var high = LENGTH - 1;

        while (low < high) {
            set.add(Character.getNumericValue(digits.charAt(low)));
            set.add(Character.getNumericValue(digits.charAt(high)));
            low++;
            high--;
        }
        set.add(Character.getNumericValue(digits.charAt(LENGTH / 2)));

        for (var a : arr)
            if (!set.contains(a))
                return false;

        return true;
    }

    private static String build(int x, int y) {
        var str = Integer.toString(x) + Integer.toString(y) + Integer.toString(y * x);
        final var LENGTH = str.length();

        if (LENGTH < 9 || LENGTH > 9)
            return "";
        return str;
    }

    private static int sumPandigitals(int start, int end) {
        var set = new HashSet<Integer>();
        for (; start <= end; start++) {
            for (var inner = start + 100; inner <= end; inner++) {
                if (isPandigital(build(start, inner))) {
                    set.add(start * inner);
                }
            }
        }
        return set.parallelStream().reduce(0, Integer::sum);
    }

    public static void main(String... args) {
        System.out.println(sumPandigitals(1, 2000));
    }
}
