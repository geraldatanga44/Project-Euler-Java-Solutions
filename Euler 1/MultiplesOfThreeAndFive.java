// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Tutorial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class MultiplesOfThreeAndFive{
    // < uses short circuit > 
    // < faster than divide and conquer >
    private static int shortCircuit(int m, int n, int limit){
        var min = Math.min(m, n);
        var sum = 0;
        for(var x = min; x < limit; x++)
            if(x % m == 0 || x % n == 0)
                sum += x;
        return sum;
    }
    //< streams api>
    private static int functionalShortCircut(int m,int n,int limit){
        var min = Math.min(m, n);
        return IntStream.range(min, limit).
                filter(w -> w % m == 0 || w % n == 0).
                reduce(0, Integer::sum);
    }


    // < trying to optimize by divide and conquer >
    // < return list of muliples for one value    >
    public static List<Integer> singly(int val, int limit){
        return Stream.iterate(val, i -> i < limit, i -> i + val).
                parallel().collect(Collectors.toList());
    }

    // < point here is to provide alternative algorithm >
    // < utilize threads here to speed up calculations  >
    // < average run time is 0.02 seconds

    private static int divideConquer(int m, int n, int limit) throws InterruptedException {
        ThreadMultiplesOfThreeAndFive[] mn = new ThreadMultiplesOfThreeAndFive[2]; 
        Thread[] threads = new Thread[2];
        var intsv = new int[] {m, n};

       for(var index = 0; index < threads.length; index++){
           threads[index] = new Thread(mn[index] = new ThreadMultiplesOfThreeAndFive(intsv[index], limit));
           threads[index].run();
       }

       for(var thread : threads)
           thread.join();

        Set<Integer> nodup = new HashSet<>();
        for(ThreadMultiplesOfThreeAndFive x : mn)
            nodup.addAll(x.getMultiples());

        return nodup.parallelStream().reduce(0, Integer::sum);
    }


    public static void main(String... args) throws InterruptedException{
        var limit = 1000;
        var n = 5;
        var m = 3;
        
        System.out.println(shortCircuit(m, n, limit));
        System.out.println(functionalShortCircut(m, n, limit));
        System.out.println(divideConquer(m, n, limit));

        var pM = BigInteger.valueOf(5);
        var pN = BigInteger.valueOf(3);
        // < To see pattern make sure to increase the limit cap >
        var pLimit = BigInteger.valueOf(1000);
        System.out.println(pattern(pM, pN, pLimit));
    }


    // <see the pattern in this problem by using bigInteger >
    // <add this to main if needed, the limit increase, the pattern shows up > 
    private static BigInteger pattern(BigInteger m, BigInteger n, BigInteger limit){
        BigInteger min = m.min(n);
        return Stream.iterate(min, i-> i.compareTo(limit) < 0, i-> i.add(BigInteger.ONE)).
                parallel().filter(w -> w.mod(m).compareTo(BigInteger.ZERO) ==0 ||
                w.mod(n).compareTo(BigInteger.ZERO) == 0).reduce(BigInteger.ZERO, BigInteger::add);
    }

}