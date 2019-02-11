import java.math.BigInteger;

interface Palindrome{
    boolean isPalindrome(BigInteger n);
}
public class DoubleBasePalindromes {
    public static void main(String[] args) {
        Palindrome base10 = (n) ->{ //implement palindrome for base 10
            if(n.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0)
                return false;
            BigInteger cp = n;
            BigInteger rm;
            BigInteger res = BigInteger.ZERO;

            while (cp.compareTo(BigInteger.ZERO) != 0){
                rm = cp.mod(BigInteger.TEN);
                res = res.multiply(BigInteger.TEN).add(rm);
                cp = cp.divide(BigInteger.TEN);
            }
            return res.compareTo(n) == 0;
        };

        Palindrome base2 = (n) ->{ //implement base 2 using base 10
            String binary = Integer.toBinaryString(n.intValue());
            BigInteger integer = new BigInteger(binary);
            return base10.isPalindrome(integer);
        };
        //increment can be done adding 2
        BigInteger sum = BigInteger.ZERO;
        for(BigInteger i = BigInteger.ONE; i.compareTo(BigInteger.valueOf(1000_000)) < 0; i = i.add(BigInteger.TWO)){
            if(base10.isPalindrome(i) && base2.isPalindrome(i))
                sum = sum.add(i);
        }

        System.out.println(sum);
    }
}
