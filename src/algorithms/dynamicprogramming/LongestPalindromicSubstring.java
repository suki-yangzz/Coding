package algorithms.dynamicprogramming;

public class LongestPalindromicSubstring {
    /*
    dp[i][j]表示字符串区间[i, j]是否为回文串
    当i = j时，只有一个字符，肯定是回文串
    如果i = j + 1，说明是相邻字符，此时需要判断s[i]是否等于s[j]
    如果i和j不相邻，即i - j >= 2时，除了判断s[i]和s[j]相等之外，dp[j + 1][i - 1]若为真，就是回文串
     */
}
