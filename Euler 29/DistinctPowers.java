import java.math.BigInteger;
import java.util.HashSet;

// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Toturial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

public class DistinctPowers{
    // < Set datatype is perfect for this question >
    // < all powers will be distinct >
    // < private types won't be able to hold all power results >
    // < <fix > --<BigInteger is used> >

    private static int distinctPowers(BigInteger start, BigInteger end){
        //< list to store powers > 
        var powerList = new HashSet<BigInteger>();
        for( ;start.compareTo(end) <= 0; start = start.add(BigInteger.ONE)){
            for(var exponent = 2; exponent <= end.intValue(); exponent++){
                powerList.add(start.pow(exponent));
            }
        }
        return powerList.size();
    }

    public static void main(String... args){
        var start = BigInteger.TWO;
        var end   = BigInteger.TEN.pow(2);
        System.out.println(distinctPowers(start, end));
    }
}