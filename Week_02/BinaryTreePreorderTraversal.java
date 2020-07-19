package Week_02;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    /**
     * 144. 二叉树的前序遍历
     * <p>
     * leetcode:https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // 继续套路，要理解先序遍历即可，还有递归
        List<Integer> ret = new ArrayList<>();
        helper(root, ret);
        return ret;
    }

    private void helper(TreeNode node, List<Integer> ret) {
        if (node == null) {
            return;
        }
        ret.add(node.val);
        helper(node.left, ret);
        helper(node.right, ret);
    }
}
