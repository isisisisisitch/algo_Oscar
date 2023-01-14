package ca.bytetube._08_dp;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("ABCD","BABC"));
    }


    public static int longestCommonSubstring(String str1,String str2){

        char[] nums1 = str1.toCharArray();
        char[] nums2 = str2.toCharArray();
        char[] rowNums = nums1, colNums = nums2;
        if (nums1.length < nums2.length) {
            colNums = nums1;
            rowNums = nums2;
        }

        int[] dp = new int[colNums.length + 1];
        int max = 0;
        for (int i = 1; i <= rowNums.length; i++) {
            for (int j = colNums.length; j >= 1 ; j--) {
                if (rowNums[i - 1] == colNums[j - 1]) {
                    dp[j] = dp[j-1] + 1;
                    max = Math.max(dp[j],max);
                } else {
                    //  dp[j] top ,dp[j-1] left
                    dp[j] = 0;
                }

            }
        }
        return max;

    }
}
