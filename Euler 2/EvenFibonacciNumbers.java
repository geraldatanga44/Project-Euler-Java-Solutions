import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// <Project Euler 2 >

// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Tutorial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

public class EvenFibonacciNumbers{
    private static long sumEvenFibonacciNumber(long limit){
        // < start with list of initial values >
        var list = Stream.of(1L, 2L).collect(Collectors.toList());

        // < store sum of even fibonacci numbers
        var totalEvenFibonacciNumbers = 0L;

        //< work with fibonacci numbers less then limit >
        for(var index = 0; list.get(index) < limit; index++){
            if(list.get(index) % 2 == 0){
                totalEvenFibonacciNumbers += list.get(index);
            }

            //< generate the next fibonacci number from precious two >
            list.add(list.get(index) + list.get(index + 1));
        }

        return totalEvenFibonacciNumbers;
    }


    private static BigInteger sumEvenFibonacciNumber(BigInteger limit){
        // < start with list of initial values >
        var list = Stream.of(BigInteger.ONE, BigInteger.TWO).collect(Collectors.toList());

        // < store sum of even fibonacci numbers
        var totalEvenFibonacciNumbers = BigInteger.ZERO;

         //< work with fibonacci numbers less then limit >
         for(var index = 0; list.get(index).compareTo(limit) < 0; index++){
             if(list.get(index).mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0){
                 totalEvenFibonacciNumbers = totalEvenFibonacciNumbers.add(list.get(index));
             }

            //< generate the next fibonacci number from precious two >
            list.add(list.get(index).add(list.get(index + 1)));
         }

          return totalEvenFibonacciNumbers;
    }

    public static void main(String... args){
        var limit = 4_000_000L;
        var bLimit = BigInteger.valueOf(4_000_000L);

        System.out.println(sumEvenFibonacciNumber(limit));
        System.out.println(sumEvenFibonacciNumber(bLimit));
    }

}