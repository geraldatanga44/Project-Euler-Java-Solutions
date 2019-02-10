//Introduce Functional Programming using Euler 35
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Function{ //use to implement prime test and circular prime test
    boolean function(int n);
}

interface Eratos{ //use to general primes from 2 to n inclusive
    List<Integer> sieve(int n);
}
public class CircularPrimes {
    public static void main(String[] args) {
        Function prime = (n) ->{ //implement prime test algorithm
            if(n < 2) return false;
            int counter = 0;
            final int LIMIT = (int) Math.sqrt(n);
            for(int div = 2; div <= LIMIT; div++){
                if(n % div == 0) counter++;
                if(counter == 1) return false;
            }
            return true;
        };

        Function circular = (n) ->{ //implement circular test algorithm
            final int digits = Integer.toString(n).length() - 1;
            int cp = n;
            while (prime.function(cp)){
                int rm = cp % 10;
                int div = cp / 10;
                cp = (int)(Math.pow(10, digits)) * rm + div;
                if(cp == n) return true;
            }
            return false;
        };

        Eratos eratos = (n) ->{ //implement prime sieving algorithm
            boolean[] detector = new boolean[n + 1];
            List<Integer> primes = new ArrayList<>();
            Arrays.fill(detector, true);
            detector[0] = false;

            for(int i = 2; i < detector.length; i++){
                if(detector[i - 1]){
                    primes.add(i);
                    for(int j = 2 * i; j < detector.length; j += i){
                        detector[j - 1] = false;
                    }
                }
            }
            return primes; //return range of primes to specified limit (inclusive)
        };
        //return number of circular primes through lambda pipe operations
        long circularPrimes = eratos.sieve(999_999).parallelStream().filter(circular::function).count();
        System.out.println(circularPrimes);
    }
}
