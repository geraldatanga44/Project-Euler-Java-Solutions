

public class DigitFactorials {
    //generate factorials using dynamic programming
    //int[] fac is for caching solutions already computed
    //subscript location contains factorial for the value
    //fac[5] has 125 for 5!
    private static int facDp(int n, int[] fac) {
        if (n == 1) {
            fac[0] = 1;
            fac[n] = n;
            return fac[n];
        }

        if (fac[n] != 0)
            return fac[n];
        else
            fac[n] = n * facDp(n - 1, fac);
        return fac[n];
    }

    //check for curious number
    //reverse number to get individual digit
    //sum the factorial of those digits
    //check against the original number
    //return true if its the same or false otherwise
    private static boolean isCurious(int n, int[] fac) {
        int sum = 0;
        int nc = n;
        int rm;

        while (nc != 0) {
            rm = nc % 10;
            sum += fac[rm];
            nc /= 10;
        }

        return sum == n;
    }

    //housing keeping
    //initialize factorial array
    //check for curious number and add them up
    //return the sum of those number
    //curious based on wiki are 1, 2, 145, and 40585
    //1 and 2 aren't included in question as specified by euler question
    private static int sumCuriousNumbers() {
        //get computed factorials
        int[] fac = new int[10];

        //fill in the fac container
        facDp(9, fac);

        //track the sum
        int sum = 0;
        for (int cur = 145; cur <= 40585; cur += 5) { //here upper bound if unknown?
            if (isCurious(cur, fac)) {                //used 9 factorial for biggest digit
                sum += cur;                         //tkggames youtube channel should confirm
            }
        }

        return sum;
    }

    //display result
    public static void main(String[] args) {
        System.out.println(sumCuriousNumbers());
    }
}