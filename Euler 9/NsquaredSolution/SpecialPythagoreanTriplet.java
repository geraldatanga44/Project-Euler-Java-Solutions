// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Toturial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

public class SpecialPythagoreanTriplet{
    private static long specialPythagoreanTriplet(int limit){
        // < start a = 3 base case >
        // < start b = a + 1 base case >
        for(var a = 3; a < limit; a++ ){
            for(var b = a + 1; b < limit; b++){
                // < calculate c using a & b
                var c = (Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));
                // < verify a + b + c == limit >
                if((a + b + c) == limit){
                    return (long)(a * b * c);
                }
            }
        }
        //< never reach here >
        return -1L;
    }

    public static void main(String... args){
        var limit = 1_000;
        System.out.println(specialPythagoreanTriplet(limit));
    }
}