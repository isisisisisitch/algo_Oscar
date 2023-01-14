package ca.bytetube._00_CCC._00_array;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * @author dal
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        return 0;
    }


    public int coinChange(int amount) {//0
        int[] coins = {1, 5, 20, 25};

        if (amount < 1) return Integer.MAX_VALUE;
        if (amount == 1 || amount == 5|| amount == 20||amount == 25) return 1;

        int min1 = Math.min(coinChange(amount - 1), coinChange(amount - 5));
        int min2 = Math.min(coinChange(amount - 20), coinChange(amount - 25));



        return Math.min(min1,min2);

    }

}
