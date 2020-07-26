package Week_03;

import Week_02.TreeNode;

public class InvertBinaryTree {
    /**
     * 226. 翻转二叉树
     * <p>
     * leetcode:https://leetcode-cn.com/problems/invert-binary-tree/description/
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
    
}
