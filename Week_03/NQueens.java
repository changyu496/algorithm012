package Week_03;

import java.util.*;

public class NQueens {

    /**
     * 51. N皇后
     * <p>
     * leetcode:https://leetcode-cn.com/problems/n-queens/
     *
     * @param n
     * @return
     */
    Set<Integer> cols = new HashSet<>();
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //回溯算法
        dfs(0, n, new ArrayList<>());
        return generateAns(ans, n);
    }

    private void dfs(int rows, int n, List<Integer> curState) {
        if (rows == n) {
            // 这句很重要，Java中是引用，需要拷贝出来一份做为最终的答案
            ans.add(new ArrayList<>(curState));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(rows + col) || na.contains(rows - col)) {
                continue;
            }
            cols.add(col);
            pie.add(rows + col);
            na.add(rows - col);
            curState.add(col);
            dfs(rows + 1, n, curState);
            cols.remove(col);
            pie.remove(rows + col);
            na.remove(rows - col);
            curState.remove(curState.size() - 1);
        }
    }

    private List<List<String>> generateAns(List<List<Integer>> ans, int n) {
        List<List<String>> finalAns = new ArrayList<>();
        for (List<Integer> an : ans) {
            List<String> solution = new ArrayList<>();
            for (int j = 0; j < ans.get(0).size(); j++) {
                String str = generateRow(n, an.get(j));
                solution.add(str);
            }
            finalAns.add(solution);
        }
        return finalAns;
    }

    private String generateRow(int n, int index) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(index == i ? "Q" : ".");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }
}
