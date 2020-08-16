package Week_06;

/**
 * 64. 最小路径和
 * <p>
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        //分析思路
        // 最后[0,0]的最小路径等于 min([0,1]的最小路径,[1,0]的最小路径)+1
        // 我的还有一个弱项，就是数组的基本操作玩的不6
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        // 第一列
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 第一行
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] grid = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        int ret = minimumPathSum.minPathSum(grid);
        System.out.println(ret);
    }
}
