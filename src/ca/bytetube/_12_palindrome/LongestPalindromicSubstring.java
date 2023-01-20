package ca.bytetube._12_palindrome;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));

    }


    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        if (cs.length <= 1) return s;
        int begin = 0;
        int maxLen = 1;
        for (int i = cs.length - 2; i >= 1; i--) {
            int len1 = palindromeLength(cs, i - 1, i + 1);
            int len2 = palindromeLength(cs, i, i + 1);

            len1 = Math.max(len1, len2);

            if (len1 > maxLen) {
                maxLen = len1;
                begin = i - ((maxLen - 1) >> 1);
            }
        }

        if (cs[0] == cs[1] && maxLen < 2) {
            maxLen = 2;
            begin = 0;
        }


        return new String(cs, begin, maxLen);

    }

    private int palindromeLength(char[] cs, int l, int r) {

        while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
            l--;
            r++;
        }

        return r - l - 1;
    }

    public static String longestPalindrome1(String s) {
        char[] cs = s.toCharArray();
        boolean[][] dp = new boolean[cs.length][cs.length];//n 2
        int begin = 0;
        int maxLen = 1;

        for (int j = 0; j < cs.length; j++) {
            for (int i = 0; i < cs.length; i++) {
                if (i > j) break;
                int curLen = j - i + 1;
                if ((curLen) <= 2) dp[i][j] = cs[i] == cs[j];
                else dp[i][j] = cs[i] == cs[j] && dp[i + 1][j - 1];
                if (dp[i][j] && curLen > maxLen) {
                    maxLen = curLen;
                    begin = i;
                }
            }
        }
        // (j- i + 1) <= 2 dp[i][j] = cs[i] == cs[j]

        //(j- i + 1) > 2 dp[i][j] = cs[i] == cs[j] && dp[i+1][j-1]

        return new String(cs, begin, maxLen);

    }
}
