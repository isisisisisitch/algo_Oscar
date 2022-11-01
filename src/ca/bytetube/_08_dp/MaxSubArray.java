package ca.bytetube._08_dp;

public class MaxSubArray {
    public static void main(String[] args) {
        int max = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(max);
    }


    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int dp = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (dp <= 0) {
                dp = nums[i];
            } else {
                dp += nums[i];
            }
            max = Math.max(max,dp);
        }
        return max;
    }


}
