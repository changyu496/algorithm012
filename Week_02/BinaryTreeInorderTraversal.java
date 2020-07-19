package Week_02;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {


    /**
     * 94. 二叉树的中序遍历
     * <p>
     * leetcode:https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 这道题如果是用递归做，是非常简单的，只要能理解含义即可
        List<Integer> ret = new ArrayList<>();
        helper(root, ret);
        return ret;
    }

    private void helper(TreeNode node, List<Integer> ret) {
        if (node == null) {
            return;
        } else {
            helper(node.left, ret);
            ret.add(node.val);
            helper(node.right, ret);
        }

    }
}
