public class CancellingFractions {
    //Get greatest common divisor
    private static double gcd(double a, double b){
        return  a == 0 ? b : gcd(b % a, a);
    }
    //if the numerator and denominator have vertically aligned
    //digits, then they are trivial examples so lets skip them
    private static  boolean simDigit(double a, double b){
        StringBuilder i = new StringBuilder(Double.toString(a));
        StringBuilder j = new StringBuilder(Double.toString(b));
        return  i.charAt(0) == j.charAt(0) || i.charAt(1) == j.charAt(1);
    }

    private static double removeSim(double a, double b){
        StringBuilder i = new StringBuilder(Double.toString(a));
        StringBuilder j = new StringBuilder(Double.toString(b));

        //cross out the diagonals only, then return simplified ratio
        //left to right
        if(i.charAt(0) == j.charAt(1)){
            i.deleteCharAt(0);
            j.deleteCharAt(1);
            return Double.parseDouble(i.toString()) / Double.parseDouble(j.toString());
        }
        //cross out the diagonals only, then return simplified ratio
        //right to left
        if(i.charAt(1) == j.charAt(0)){
            i.deleteCharAt(1);
            j.deleteCharAt(0);
            return Double.parseDouble(i.toString()) / Double.parseDouble(j.toString());
        }
        //if any above cases do not work, the there is nothing to cross out
        return 1.0;
    }

    private static double cnFrac(){
        double numerator = 1; //track numerator
        double denominator = 1; //track denominator

        for(double num = 10; num <= 99; num++){ //numerator
            for(double denom = num + 1; denom <= 99; denom++){ //denominator
                if(simDigit(num, denom)) //stop if vertically matched
                    continue;
                double factor = gcd(num, denom); //get gcd of num, and denom
                double reduce = removeSim(num, denom); //get simplified form
                double origin = num / denom; //get ratio of original numerator and denominator

                if(reduce == origin){ //check if simplified is the same as original
                    numerator *= (num / factor); //reduced recursive stack call gcd by factor
                    denominator *= (denom / factor); //reduced recursive stack call gcd by factor
                }
            }
        }
        return  denominator / gcd(numerator, denominator); //return the gcd of denominator
    }

    public static void main(String[] args) {
        //run file to see result
        System.out.println(cnFrac());
    }
}
