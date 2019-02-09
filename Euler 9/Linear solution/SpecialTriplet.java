public class SpecialTriplet {
    /**
     *
     *            Notes ******
     *            1. a + b + c  = TARGET
     *            2. construct c: c = TARGET - a - b;
     *            3. a < b < c relationship
     *            4. since a < b < c, then a < TARGET / 3 and
     *            5. a < b < TARGET / 2
     *            6. reduce search space?
     *            7.a + b = TARGET and a^2 + b^ = C^2
     *            8. apply above logic 2ab = (TARGET - c)^2 - c^2
     *            9.apply both equations
     *            10.a^2 + 2ab + b^2 = c^2 -(TARGET - c)^2 + c^2 = c^2 -TARGET^2 + 2*TARGET * c
     */
    private static int specialTriplets(final int TARGET){
        int product = 0;
        for(int c = TARGET / 3; c < TARGET; c++ ){
            double sqrt = c * c - TARGET * TARGET + 2 * TARGET* c;
            int ab = (int)Math.sqrt(sqrt);
            if(ab * ab == sqrt){
                int b = (TARGET - c + ab) / 2;
                int a = (TARGET - b - c);
                product =  (a * b * c); break;
            }
        }
        return product;
    }

    public static void main(String... args){
        System.out.println(specialTriplets(1000));
    }
}
