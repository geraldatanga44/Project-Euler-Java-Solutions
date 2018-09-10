
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.List;


// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Tutorial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >


public class LargestPrimeFactor{
    private static List<Long> properDivisor(long value){
        // < sortedSet makes finding largest prime easier > 
        var list = new HashSet<Long>();
        // < we can generate all factor using value square root >
        var sqrt = (long) Math.sqrt(value);
        // < we don't care about 1 or value >
        for(var v = 2L; v <= sqrt; v++){
            if(value % v == 0){
                list.add(v);
                //  < v can be used to find upper bound divisors > 
                list.add(value / v);
            }
        }
        // < since set doesn't guarrantee ordering we sort >
        var sortedList = new ArrayList<Long>();
        // < we can sort list interface >
        sortedList.addAll(list);
        Collections.sort(sortedList);

        return sortedList;
    }

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

    private static long largestPrimeFactor(long value){
        // < sorted list of proper divisors >
        var sortedList = properDivisor(value);
        // < largest prime should be at the back >
        for(var index = sortedList.size() - 1; index >= 0; index--) {
            if(isPrime(sortedList.get(index)))
                return sortedList.get(index);
        }
        // < it will never reach here >
        // < we can return anything >
        // < primes cannot be negative so we can return -1 >
        return -1L;
    }

    public static void main(String... args){
        var value = 600851475143L;
        System.out.println(largestPrimeFactor(value));
    }
}