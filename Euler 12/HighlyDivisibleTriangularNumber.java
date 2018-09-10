

// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Toturial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

import java.util.HashSet;
import java.util.Set;

public class HighlyDivisibleTriangularNumber{
    private static Set<Integer> setOfFactors(int value){
        // < get all divisors using sqrt of value >
        var sqrt = (int) Math.sqrt(value); 
        // < set to hold divisor >
        var setList = new HashSet<Integer>();
        for(var v = 1; v <= sqrt; v++){
            if(value % v == 0){
                //< use lower bound v to get upper bound value / v >
                setList.add(v);
                setList.add(value / v);
            }
        }
        return setList;
    }

    private static int highlyDivisibleTriangularNumberOverFiveThundredDivisors(int fiveHundred){
        // <generate pattern >
        // <1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ... >

        for(int value = 1, increment = 2; ;value += increment, increment++){
            if(setOfFactors(value).size() > fiveHundred){
                return value;
            }
        }
    }

    public static void main(String... args){
        var fiveHundred = 5_00;
        System.out.println(highlyDivisibleTriangularNumberOverFiveThundredDivisors(fiveHundred));
    }
}