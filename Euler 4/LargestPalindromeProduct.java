
// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Tutorial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

public class LargestPalindromeProduct {
    private static long reversed(long value){
        //< we utilize StringBuffer to easily reverse a number >
        var stringBuffer = new StringBuffer(Long.toString(value));
        return Long.parseLong(stringBuffer.reverse().toString());
    }

    // < provide alternative reversed method - mathematical reverse >
    @SuppressWarnings("unused") // < remove annotation if you want to use this instead >
    private static long reversedMathematically(long value){
        var reversed = 0L;
        var remainder = 0L;

        while(value != 0){
            remainder = value % 10;
            reversed  = (reversed * 10) + remainder;
            value /= 10;
        }

        return reversed;
    }
    // < easily checks palindromic number >
    private static boolean isPalindrome(long value){
        return reversed(value) == value;
    }

    // < find the largest palindromic product of two values >
    private static long largestPalindromeProduct(long a, long b){
        var largest = 0L;
        // < we can stop i, j at base case >
        for(var i = a; i > 99; i--){
            for(var j = b; j > 99; j--) {
                var r = i * j;
                if(isPalindrome(r)){
                    largest = Math.max(largest, r);
                }       
            }
        }
        return largest;
    }

    public static void main(String... args){
        var a = 999L;
        var b = 999L;
        System.out.println(largestPalindromeProduct(a, b));
    }

}