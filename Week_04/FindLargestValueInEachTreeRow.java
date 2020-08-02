package Week_04;

import Week_02.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

    /**
     * 515. 在每个树行中找最大值
     * <p>
     * leetcode:https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        // 每一行的最大值，那么最简单的方法就和按照层序遍历的思路一样吧
        // 先按照思路写一版本
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxVal = Integer.MIN_VALUE;
            while (size-- > 0) {
                maxVal = queue.peek().val > maxVal ? queue.peek().val : maxVal;
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                queue.poll();
            }
            // 选择subList里最大的值，放到结果里
            ret.add(maxVal);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(2);
        TreeNode l1l2 = new TreeNode(5);
        TreeNode l1r2 = new TreeNode(9);
        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        r1.right = l1r2;
        FindLargestValueInEachTreeRow findLargestValueInEachTreeRow = new FindLargestValueInEachTreeRow();
        findLargestValueInEachTreeRow.largestValues(root);
    }
}
