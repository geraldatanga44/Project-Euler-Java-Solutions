// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Toturial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >
import java.util.HashSet;
public class TenThousandOnePrime{
    private static boolean isPrime(long value){
        //< lowest prime is 2 and primes are positive numbers>
        if(value < 2)
            return false;
        // < set are used to eliminate dupplicates >
        var list = new HashSet<Long>();
        var sqrt = (long) Math.sqrt(value);
        // < if lower bound sqrt has more than >
        // < 1 divisor, value is no longer prime > 
        for(var v = 1L; v <= sqrt; v++){
            if(value % v == 0)
                list.add(v);
            // < list.size() is effective here >
            // < determines we don't pass two divisors >
            if(list.size() > 1)
                return false;
        }
        return true;
    }

    private static long tenThousandOnePrime(long limit) {
        // < Special case prime  [2 == even] >
        // < counter set to 1 for special case >
        // < rest of primes should be odd < Look odd only >>
        var numberOfPrimes = 1L;
        for(var value = 3L; ; value += 2){
            if(isPrime(value)){
                numberOfPrimes++;
            }
            // < exit when numberOfPrimes == 10001 >
            if(numberOfPrimes == limit){
                return value;
            }

        }
    }

    public static void main(String... args){
        var limit = 10_001L;
        System.out.println(tenThousandOnePrime(limit));
    }
}