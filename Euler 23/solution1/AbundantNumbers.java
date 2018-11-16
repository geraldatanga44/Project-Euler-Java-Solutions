import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class AbundantNumbers {
    public static boolean isAbuntant(int digit) {
        var list = new HashSet<Integer>();

        if (digit < 12)
            return false;

        list.add(1);
        var sqrt = (int) Math.sqrt(digit);
        for (var div = 2; div <= sqrt; div++) {
            if (digit % div == 0) {
                list.add(digit / div);
                list.add(div);
            }
        }

        var sum = list.parallelStream().reduce(0, Integer::sum);
        return sum > digit;
    }

    private static List<List<Integer>> abuntantList(int limit) throws InterruptedException {
        var cores =  Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[cores];
        GenerateAbundantList[] generateAbundantLists = new GenerateAbundantList[cores];

        var number = limit / cores;
        var remainder = limit % cores;

        IntStream.range(0, cores).forEach(w -> {
            threads[w] = new Thread(generateAbundantLists[w] = new GenerateAbundantList((number * w), (number * (w + 1) + 1)));
            threads[w].start();

            if (w == cores - 1) {
                threads[w] = new Thread(generateAbundantLists[w] = new GenerateAbundantList((number * w),
                        (number * (w + 1) + remainder + 1)));
                threads[w].start();
            }
        });

        for (var index = 0; index < threads.length; index++)
            threads[index].join();

        var list = new ArrayList<List<Integer>>();
        for (var index = 0; index < generateAbundantLists.length; index++)
            list.add(generateAbundantLists[index].getList());
        return list;

    }

    private static boolean search(int digit, int[] list) throws InterruptedException {
        if(list[digit] == digit)
            return true;

        return false;
    }


    private static int[] generateAllAbuntantNumbers(List<List<Integer>> list) throws InterruptedException {
        final var SIZE = list.size();
        var threads = new Thread[SIZE];
        GenerateFromAbuntantList[] generateFromAbuntantLists = new GenerateFromAbuntantList[SIZE];

        IntStream.range(0, SIZE).forEach(w -> {
            threads[w] = new Thread(generateFromAbuntantLists[w] = new GenerateFromAbuntantList(list.get(w), list));
            threads[w].start();
        });

        for (var thread : threads)
            thread.join();

        return GenerateFromAbuntantList.getCombo();
    }

    public static int sum(int[] list, int start, int end) throws InterruptedException {
        var sum = 0;
        for (var s = start; s <= end; s++) {
            if (!search(s, list)) {
                sum += s;
            }
        }
        return sum;
    }

    public static int results(int[] list, int SIZE) throws InterruptedException {
        final var LIMIT = 28123;
        DivideConquer[] divideConquers = new DivideConquer[SIZE];
        var threads = new Thread[SIZE];
        var summation = 0;

        var number = LIMIT / SIZE;
        var remainder = LIMIT % SIZE;

        IntStream.range(0, SIZE).forEach(w -> {
            if (w == 0) {
                threads[w] = new Thread(divideConquers[w] = new DivideConquer(list, w + 1, (w + 1) * number));
                threads[w].start();
            } else if (w == SIZE - 1) {
                threads[w] = new Thread(divideConquers[w] = new DivideConquer(list, (number * w) + 1, ((w + 1) * number) + remainder - 1));
                threads[w].start();
            } else {
                threads[w] = new Thread(divideConquers[w] = new DivideConquer(list, (number * w) + 1, (w + 1) * number));
                threads[w].start();
            }
        });

        for (var thread : threads)
            thread.join();

        for (var divide : divideConquers)
            summation += divide.getSum();

        return summation;

    }


    public static void main(String... args) throws InterruptedException {

        var listM = abuntantList(28123);
        var listA = generateAllAbuntantNumbers(listM);
        System.out.println(results(listA, listM.size()));

    }

}
