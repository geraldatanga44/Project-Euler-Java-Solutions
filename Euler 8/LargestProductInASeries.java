// < use java jdk 10 to compile and execute solution >
// < tutorial on installing jdk 10.0.2 >
// < Youtube channel : https://www.youtube.com/user/Parsike >
// < Toturial explanation on my channel - > changes have been made >
// < Git repo has all updated content on problem -> Repo is the truth :) >
// < Re-write == Cleaner code + comments >

public class LargestProductInASeries{

    private static String dataString(){
        // < I thought it will be easier to see the data like this >
        // < However, if the data file is very large, File Streams will be used >
        var dataString = 
                "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";
        return dataString;
    }
    
    private static long largestProductInASeries(String data, int adjacentNumbers){
        var maxProduct = 0L;
        // < index + adjacentNumber is the entire subString > 
        for(var index = 0; index + adjacentNumbers < data.length(); index++){
            // < product resets to 1L when inner loop done with computation >
            var product = 1L;
            // <index = start, index + adjacentNumbers = end >
            var subString = data.subSequence(index, index + adjacentNumbers);
            for(var subIndex = 0; subIndex < subString.length(); subIndex++){
                // < if one of the values in the substring is zero >
                // < entire product is zero, we stop when we find a zero >
                if(Character.getNumericValue(subString.charAt(subIndex)) == 0){
                    break; // < exit inner for-loop >
                }
                // < perform calculation>
                // < convert char to int >
                product = product * Character.getNumericValue(subString.charAt(subIndex));
                // < calculate largest product >
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    public static void main(String... args){
        var adjacentNumbers = 13;
        var data = dataString();
        System.out.println(largestProductInASeries(data, adjacentNumbers));
    }
}