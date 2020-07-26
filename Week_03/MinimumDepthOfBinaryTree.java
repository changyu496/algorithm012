package Week_03;

import Week_02.TreeNode;

public class MinimumDepthOfBinaryTree {

    /**
     * 111. 二叉树的最小深度
     * <p>
     * leetcode:https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return leftDepth + rightDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
