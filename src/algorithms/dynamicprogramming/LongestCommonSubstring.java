package algorithms.dynamicprogramming;

public class LongestCommonSubstring {

    public static int LCS (String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < s1.length() + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < s2.length() + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (maxLen < dp[i][j])
                    maxLen = dp[i][j];
            }
        }
        return maxLen;
    }

    public static void main (String[] args) {
        String s1 = "abcdfg";
        String s2 = "abdfgi";
        System.out.println(LCS(s1, s2));
    }
}
