package Week_06;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * https://leetcode-cn.com/problems/triangle/
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        // 这里的等于号很重要
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

    }
}
