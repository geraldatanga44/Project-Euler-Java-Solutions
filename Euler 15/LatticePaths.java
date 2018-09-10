// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Toturial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

//       watch this : Art of Problem Solving: Counting Paths on a Grid
// ***** https://www.youtube.com/watch?v=M8BYckxI8_U *****

//       Combinations and Permutations
// read: **** https://www.mathsisfun.com/combinatorics/combinations-permutations.html ****


public class LatticePaths{
    private static long binomialCoefficient(long n, long k){
        var solution = 1L;
        if(n == k)
            k = n - k;
        
        for(var i = 0; i < k; i++){
            solution = solution * (n - i);
            solution = solution / (i + 1);
        }
        return solution;
    }

    private static long latticePaths(final int grid){
        // < base case = 6 for 2 * 2 grid >
        // < 2 chose 2 = 1 < won't work > we need 6 >
        // < grid * 2 choose grid = 6 >
        // < apply base case to asked problem >
        var solution = binomialCoefficient(grid * 2, grid);
        return solution;
    }

    public static void main(String... args){
        var grid = 20;
        System.out.println(latticePaths(grid));
    }
}