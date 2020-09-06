package Week_09;

/**
 * 5. 最长回文子串
 * <p>
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 动态规划
        int start = 0, end = 0;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                boolean ret = s.charAt(i) == s.charAt(j);
                if (j - i == 1 && ret) {
                    dp[i][j] = true;
                    if (end - start <= j - i) {
                        start = i;
                        end = j;
                    }
                    continue;
                }
                if (dp[i + 1][j - 1] && ret) {
                    dp[i][j] = true;
                    if (end - start <= j - i) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
