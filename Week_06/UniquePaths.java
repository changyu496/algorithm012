package Week_06;

/**
 * 62. 不同路径
 * <p>
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {
    // 类似于课上例题
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return -1;
        }
        // 二维数组，存储DP方程
        // 最优子结构 右边的和+下边的和
        int[][] dp = new int[m][n];
        // 第一列初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 第一行初始化
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(0, 0));
    }
}
