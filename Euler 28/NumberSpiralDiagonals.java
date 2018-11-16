// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Toturial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

public class NumberSpiralDiagonals{
    //derive formula by looking at diagonals
    // top-right    : n^2
    // top-left     : n^2 -  n + 1;
    // botton-left  : n^2 - 2n + 2;
    // botton-right : n^2 - 3n + 3
    //                -------------
    //                4n^2 -6n + 6
    public static long numberSpiralDiagonals(int limit){
        var solution = 1L; // < special < center value > >
        for(var spiral = 3; spiral <= limit; spiral += 2){
            solution += (4 * Math.pow(spiral, 2) - (6 * spiral) + 6);
        } 
        return solution;
    }

    public static void main(String... args){
        var limit = 1_00_1;
        System.out.println(numberSpiralDiagonals(limit));
    }
}