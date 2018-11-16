import java.math.BigInteger;
import java.util.Arrays;
public class CoinChange
{
    private static BigInteger[] DPCoins(int[] coins) {
        return Arrays.stream(coins).mapToObj(BigInteger::valueOf).toArray(BigInteger[]::new);
    }

    private static void initializeDP(BigInteger[] coins, int cash) {
        final var SIZE = cash + 1;
        for (var index = 0; index < SIZE; index++) {
            coins[index] = BigInteger.ZERO;
        }
    }

    private static BigInteger iterativeSolution(int[] coins, int cash) {
        // no coins used
        if (cash == 0)
            return BigInteger.ONE;
        // no cash, but coins available
        if (cash < 0)
            return BigInteger.ZERO;
        // cash available, but not coins
        if (cash > 0 && coins.length <= 0)
            return BigInteger.ZERO;

        var DP = new BigInteger[cash + 1];

        initializeDP(DP, cash);

        var DPcoins = DPCoins(coins);

        final var SIZE = new BigInteger(Long.toString(DP.length));

        DP[0] = BigInteger.ONE;

        for (var coin : DPcoins) {
            for (var x = coin; x.compareTo(SIZE) < 0; x = x.add(BigInteger.ONE)) {
                DP[x.intValue()] = DP[x.intValue()].add(DP[(x.subtract(coin)).intValue()]);
            }
        }
        return DP[cash];
    }
    private static int coinChangeVariations(int[] coins, int ncoins, int cash)
    {   //no coins included
        //set{0} = empty set 
        if(cash == 0)
            return 1;
        //we have coins, but no cash 
       if(cash < 0)
           return 0;
        
        //no coins and cash we can't change
        if(cash > 0 && ncoins <= 0)
            return 0;
        
        return coinChangeVariations(coins, ncoins - 1, cash) +
               coinChangeVariations(coins, ncoins, cash - coins[ncoins - 1]);
    }

    public static int coinChangeVariationsWrapper(int[] coins, int cash)
    {
        return coinChangeVariations(coins, coins.length, cash);
    }

    public static void main(String... args)
    {
        var coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
        var cash = 200;
        var ways = coinChangeVariationsWrapper(coins, cash);
        var ways2 = iterativeSolution(coins, cash);
        System.out.println(ways);
        System.out.println(ways2);
    }
}