package ca.bytetube._08_dp;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        //System.out.println(Integer.MAX_VALUE + 1);//2147483647  -2147483648
        System.out.println(coinChange1(39));//39 = 25 + 5 + 5 +4*1
        System.out.println(coinChange3(39,new int[] {25,20,1}));


    }

    public static int coinChange3(int amount,int[] coins) {//n = 6
        //① Define state
        //dp(n) is the minimum number of coins needed to get n cents
        int[] dp = new int[amount + 1];

        //② Set initial state
        //int[] faces = {25, 20, 5, 1};
        Arrays.sort(coins);//
        for (int face : coins) {
            if (amount < face) break;
            dp[face] = 1;
        }

        for (int i = 1; i <= amount; i++) {//n = 41(1~40)
            int min = Integer.MAX_VALUE;
            //③ Determine the state transition equation
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) min = Math.min(dp[i - coins[j]], min);//2

            }
            dp[i] = min + 1;

        }

        return dp[amount];
    }



    public static int coinChange2(int n) {//n = 6
        //① Define state
        //dp(n) is the minimum number of coins needed to get n cents
        int[] dp = new int[n + 1];

        //② Set initial state
        int[] faces = {25, 20, 5, 1};
        Arrays.sort(faces);//
        for (int face : faces) {
            if (n < face) break;
            dp[face] = 1;
        }

        for (int i = 1; i <= n; i++) {//n = 41(1~40)
            int min = Integer.MAX_VALUE;
            //③ Determine the state transition equation
            if (i >= 1) min = Math.min(dp[i - 1], min);//2
            if (i >= 5) min = Math.min(dp[i - 5], min);//2
            if (i >= 20) min = Math.min(dp[i - 20], min);//2
            if (i >= 25) min = Math.min(dp[i - 25], min);//2
            dp[i] = min + 1;
            System.out.print(dp[i] +" ");
        }

        return dp[n];
    }


    public static int coinChange1(int n) {//n = 6
        if (n <= 1) return n;
        int[] dp = new int[n + 1];//0
        int[] faces = {25, 20, 5, 1};
        Arrays.sort(faces);//
        for (int face : faces) {
            if (n < face) break;
            dp[face] = 1;
        }

        return coinChange1(n, dp);

    }

    private static int coinChange1(int n, int[] dp) {
        if (n < 1) return Integer.MAX_VALUE;//2147483647
        if (n == 25 || n == 20 || n == 5 || n == 1) return 1;
        if (dp[n] == 0) {
            int min1 = Math.min(coinChange1(n - 25, dp), coinChange1(n - 20, dp));
            int min2 = Math.min(coinChange1(n - 5, dp), coinChange1(n - 1, dp));
            dp[n] = Math.min(min1, min2) + 1;
        }

        return dp[n];
    }

    /**
     * n = 6 coinChange(6)--->?
     * min1=0
     * (
     * coinChange(6 - 25) = coinChange(-19)=0
     * coinChange(6 - 20) = coinChange(-14)=0
     * )
     * <p>
     * min2=0
     * (
     * coinChange(6 - 5) = coinChange(1) = -2147483648
     * (
     * min1 = 2147483647
     * min2 = 2147483647
     * coinChange(1 - 1) = coinChange(0) = 1
     * (
     * min1 = 0
     * min2 = 0
     * )
     * )
     * )
     * min + 1
     * <p>
     * <p>
     * coinChange(5) =
     * (
     * min1 = 2147483647
     * min2
     * )
     */
    public static int coinChange(int n) {//6
        if (n < 1) return Integer.MAX_VALUE;//2147483647
        if (n == 25 || n == 20 || n == 5 || n == 1) return 1;
        //2147483647      2147483647
        int min1 = Math.min(coinChange(n - 25), coinChange(n - 20));
        //2147483647    -2147483648+1*(4)
        int min2 = Math.min(coinChange(n - 5), coinChange(n - 1));
        return Math.min(min1, min2) + 1;


    }
}
