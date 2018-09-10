
// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Toturial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

public class SquareSumDifference{
    private static long squareThenSum(int start, int end){
        // < ignore base case 1 - 10 >
        // < start 11 - 100 >
        // < add base case value to result > 
        var sum = 0L;
        for(var i = start; i <= end; i++){
            sum += (long) Math.pow(i, 2);
        }
        return sum + 385;
    }

    private static long sumThenSquare(int end){
        //< can't apply squareThenSum logic here >
        //< addition here works differently >
        var sum = 0L;
        for(var i = 1; i <= end; i++){
            sum += i;
        }

        return (long)(Math.pow(sum, 2));
    }

    private static long sumSquareDifference(int start, int end){
        // < easily get the difference > 
        return sumThenSquare(end) - squareThenSum(start, end);
    }

    public static void main(String... args){
        var start = 11;
        var end = 100;
        System.out.println(sumSquareDifference(start, end));
    }

}