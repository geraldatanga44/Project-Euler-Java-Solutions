// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Tutorial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

public class SmallestMultiple{
    private static long smallestMultiple(){
        //< base case 1 - 10 == 2520 >
        //< increment by base case and start with values > 10 > 
        //< 10 is a factor of 20 >

        var element = new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for(var currValue = 2520L; ; currValue += 2520){
            for(var index = 0; index < element.length; index++){
               if(isSmallestMultiple(currValue, element)){
                   return currValue;
               }
            }
        }
    }

    private static boolean isSmallestMultiple(long currValue, int[] element){
        // < short circuit currValue remainder != 0 >
        for(var index = 0; index < element.length; index++){
            if(currValue % element[index] != 0)
                return false;
        }
        return true;
    }

    public static void main(String... args){
        System.out.println(smallestMultiple());
    }
}