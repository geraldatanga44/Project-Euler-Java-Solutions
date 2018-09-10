import java.math.BigInteger;

// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Toturial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

public class PowerDigitSum{

    private static int powerDigitSum(int exponent){
        return reversedAddition(BigInteger.TWO.pow(exponent));
    }

    private static int powerDigitSum0(int exponent){
        return stringSolution(BigInteger.TWO.pow(exponent));
    }

    //< gets each individual value >
    //< pretty much reversing a number and adding each digit > 
    private static int reversedAddition(BigInteger value){
        var solution = 0;
        var remainder = BigInteger.ZERO;
        while(value.compareTo(BigInteger.ZERO) != 0){
            remainder = value.mod(BigInteger.TEN);
            solution += remainder.intValue();
            value = value.divide(BigInteger.TEN);
        }
        return solution;
    }
    
    // < alternative solution >
    private static int stringSolution(BigInteger value){
        var solution = 0;
        for(var c : value.toString().toCharArray()){
            solution += Character.getNumericValue(c);
        }
        return solution;
    }
    public static void main(String... args){
        var exponent = 1_000;
        System.out.println(powerDigitSum(exponent));
        System.out.println(powerDigitSum0(exponent));
    }
}