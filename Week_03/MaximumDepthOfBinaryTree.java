package Week_03;

import Week_02.TreeNode;

public class MaximumDepthOfBinaryTree {
    /**
     * 104. 二叉树的最大深度
     * <p>
     * leetcode:https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // 递归，左子树的高度和右子树的高度取最大值
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    private int helper(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(helper(root.left, depth + 1), helper(root.right, depth + 1));
    }
}
