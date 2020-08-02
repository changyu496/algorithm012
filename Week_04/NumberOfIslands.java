package Week_04;

public class NumberOfIslands {

    /**
     * 200. 岛屿数量
     * <p>
     * leetcode:https://leetcode-cn.com/problems/number-of-islands/
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        //这道题也是典型的DFS，有个小技巧的就是，在遍历的时候，如果是1，就是找到岛了，周围（上下左右的陆地都都打掉）
        if (grid.length <= 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    DFSMarketing(i, j, m, n, grid);
                }
            }
        }
        return count;
    }

    private void DFSMarketing(int i, int j, int m, int n, char[][] grid) {
        if (i < 0 || i > m || j < 0 || j > n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        DFSMarketing(i + 1, j, m, n, grid);
        DFSMarketing(i, j + 1, m, n, grid);
        DFSMarketing(i - 1, j, m, n, grid);
        DFSMarketing(i, j - 1, m, n, grid);
    }
}
