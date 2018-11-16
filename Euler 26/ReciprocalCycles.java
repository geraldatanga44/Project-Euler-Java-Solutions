import java.util.HashMap;

public class ReciprocalCycles {
    private static int usingMod(int denominator) {
        var map = new HashMap<Integer, Integer>();
        var mod = 1;
        for (var index = 1; ; index++) {
            if (map.containsKey(mod)) {
                return index - map.get(mod);
            } else {
                map.put(mod, index);
                mod = mod * 10 % denominator;
            }
        }
    }

    private static int longestCycle(int limit) {
        var longest = 0;
        var denominator = 0;

        for (var index = limit; index >= 2; index--) {
            var currLongest = usingMod(index);
            if (currLongest > longest) {
                longest = currLongest;
                denominator = index;
            }
        }
        return denominator;
    }

    public static void main(String... args) {
        System.out.println(longestCycle(1_000));
    }
}