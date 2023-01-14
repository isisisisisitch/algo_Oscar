package ca.bytetube._08_dp;

public class Knapsack {
    public static void main(String[] args) {
        int[] values = {6, 3, 5, 4, 6};
        int[] weights = {2, 2, 6, 5, 4};
        System.out.println(knapsack(values, weights, 10));
    }


    public static int knapsack(int[] values, int[] weights, int capacity) {
        int[] dp = new int[capacity+1];

        for (int i = 1; i <= values.length; i++) {

            for (int j = capacity; j >= 1; j--) {
                if (j < weights[i - 1]) dp[j] = dp[j];
                else dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }

        }
        return dp[capacity-1];
    }

    public static int knapsack2(int[] values, int[] weights, int capacity) {
        int[] dp = new int[capacity+1];
        int[] tops = new int[capacity+1];
        for (int i = 1; i <= values.length; i++) {

            for (int j = 1; j <= capacity; j++) {
                if (j < weights[i - 1]) dp[j] = tops[j];
                else dp[j] = Math.max(tops[j], tops[j - weights[i - 1]] + values[i - 1]);
            }
            tops = dp;
        }
        return tops[capacity-1];
    }

    public static int knapsack1(int[] values, int[] weights, int capacity) {
        int[][] dp = new int[values.length + 1][capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weights[i - 1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
            }

        }
        return dp[values.length][capacity];
    }

}
