import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Toturial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

public class LargeSum{
    // < file is local to directory >
    // < if not specify full path >
    // < reads file and return list of String values >
    private static List<String> readFileReturnList(final String FILENAME){
        var stringValues = new ArrayList<String>();
        try(var br = new BufferedReader(new FileReader(FILENAME))){
            var currentFileLine = "";
            while((currentFileLine = br.readLine()) != null){
                stringValues.add(currentFileLine);
            }
        }catch(IOException exception){
            exception.printStackTrace();
        }
        return stringValues;
    }

    private static String largeSum(final String FILENAME) throws IOException{
        // < list of String values >
        // < values won't fit in long primitive type >
        // < we use BigInteger >
        var numberList = readFileReturnList(FILENAME);
        var sumOfLargeValues = BigInteger.ZERO;
        for(var largeValue : numberList){
            sumOfLargeValues = sumOfLargeValues.add(new BigInteger(largeValue));
        }
        // < return first 10 values of the solution > 
        return sumOfLargeValues.toString().substring(0, 10);
    }

    public static void main(String... args) throws IOException{
        final var FILENAME = "dataFile.txt";
        System.out.println(largeSum(FILENAME));
    }
}