import java.util.Arrays;

public class LexicographicPermutations {
    private static int[] init(int inclusiveRange) {
        var array = new int[inclusiveRange + 1];
        for (var index = 0; index < array.length; index++)
            array[index] = index;
        return array;
    }

    private static void swap(int[] array, int a, int b) {
        var temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static boolean nextPermutation(int[] array) {
        var elements = array.length;
        var leftindex = 0;
        for (leftindex = elements - 2; leftindex >= 0; leftindex--)
            if (array[leftindex] < array[leftindex + 1])
                break;
        if (leftindex == -1) 
            return false;

        var swapIndex = elements - 1;
        for (; array[leftindex] > array[swapIndex]; swapIndex--);

        swap(array, leftindex, swapIndex);

        var x = leftindex + 1;
        var z = elements - 1;

        while (z > x) {
            swap(array, z, x);
            z--;
            x++;
        }
        return true;
    }

    private static String oneMillionPermutation(int limit, int[] array) {
        var counter = 0;
        while (nextPermutation(array)) {
            if (++counter == limit)
                break;
        }

        var str = Arrays.toString(array).replaceAll("\\[|\\]|, |\\s","");
        return str;
    }

    public static void main(String... args) {
        var array = init(9);
        System.out.println(oneMillionPermutation(999999, array));
    }
}
