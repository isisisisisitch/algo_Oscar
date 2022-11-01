package ca.bytetube._08_dp;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(arr);
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {

            for (int j = i - 1; j > 0; j--) {
                if (nums[i] <= nums[j]) dp[i] = Math.max(dp[i], 1);
                else dp[i] = Math.max(dp[i], dp[j] + 1);

            }

            max = Math.max(max, dp[i]);

        }
        return max;
    }
}
