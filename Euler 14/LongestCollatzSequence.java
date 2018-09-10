import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Toturial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

public class LongestCollatzSequence{
    private static LinkedList<Long> generateCollatzSequence(long value){
        // < implement given formula >
        // < n → n/2 (n is even) >
        // < n → 3n + 1 (n is odd )>   
        
        // < list to store sequence > 
        var sequenceList = new LinkedList<Long>();
        while(value != 1){  // < stop at 1 >
            if(value % 2 == 0) // < if value is even
                sequenceList.add(value /= 2);
            else
                sequenceList.add(value = value * 3 + 1); // < must be odd >
        }
        return sequenceList;
    }

    private static int longestCollatzSequence(int limit){
        var longestSequence = 0;
        var longestSequenceValue = 0;
        
        //< through analysis the value is a composite number>
        //< Incrementing by primes will work > 
        for(var value = 1283; value < limit; value += 1283){
            // < get current longest sequence by list size >
            var currLongest = generateCollatzSequence(value).size();
            // <change values if new current longest is found >
            if(currLongest > longestSequence){
                longestSequence = currLongest;
                longestSequenceValue = value;
            }
        }
        return longestSequenceValue;
    }

    public static void main(String... args){
        var limit = 1_000_000;
        var start = System.currentTimeMillis();
        System.out.println(longestCollatzSequence(limit));
        var end = System.currentTimeMillis();
        System.out.println((double)(end - start) / 1000);
    }
}